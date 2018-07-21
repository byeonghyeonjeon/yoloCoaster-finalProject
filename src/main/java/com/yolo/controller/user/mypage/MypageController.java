package com.yolo.controller.user.mypage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.Like_areaVO;
import com.yolo.model.MemberVO;
import com.yolo.model.PageVO;
import com.yolo.service.admin.FileAddServiceInf;
import com.yolo.service.board.BoardServiceInf;
import com.yolo.service.member.LikeAreaServiceInf;
import com.yolo.service.member.MemberServiceInf;

@RequestMapping("myPage")
@Controller
public class MypageController {

	@Resource
	MemberServiceInf memberService;

	@Resource
	LikeAreaServiceInf likeAreaService;
	
	@Resource
	FileAddServiceInf fileAddService;
	
	@Resource
	BoardServiceInf boardService; 
	
	Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 
	 * Method : name 최초작성일 : 2018. 6. 18. 작성자 : Brown 변경이력 :
	 * 
	 * @param member
	 * @param model
	 * @return Method 설명 :마이페이지 메인 조회
	 */
	@RequestMapping("main")
	public String name(MemberVO member,HttpSession session, Model model) {
		if(session.getAttribute("memberVO")!=null){
			
			//회원정보 
		member= (MemberVO) session.getAttribute("memberVO");
		member = memberService.selectMemberInfo(member);
		model.addAttribute("memberVO", member);
		
		List<Like_areaVO> likeAreaList =likeAreaService.selectLikeAreaList(member.getMem_id());
		int tempMaxLikeAreaNum =0;
		if(likeAreaList.size()>0){
			model.addAttribute("likeAreaList",likeAreaList);
			tempMaxLikeAreaNum = likeAreaList.size();
		}
		model.addAttribute("tempMaxLikeAreaNum",tempMaxLikeAreaNum);
		return "myPage";
		}
		return "redirect:/main";
	}

	/**
	 * 
	 * Method : updateMyInfo 최초작성일 : 2018. 6. 18. 작성자 : Brown 변경이력 : 수정
	 * 
	 * @param member
	 * @param model
	 * @return Method 설명 : 개인정보 수정페이지로 이동
	 */
	@RequestMapping("update")
	public String myPageUpdate(MemberVO member,HttpSession session, Model model) {
		if(memberService.checkMemPass(member)!=1){
			String message = "비밀번호를 확인해주세요";
			model.addAttribute("message",message);
			return"checkPass";
		}
		
		String mem_id = session.getAttribute("mem_id")+"";
		List<Like_areaVO> likeAreaList =likeAreaService.selectLikeAreaList(mem_id);
		if(likeAreaList.size()>0){
			model.addAttribute("likeAreaList",likeAreaList);
			int tempMaxLikeAreaNum = likeAreaList.size();
			model.addAttribute("tempMaxLikeAreaNum",tempMaxLikeAreaNum);
		}
		
		
		//전체정보 다 가지는 멤버 VO필요
		member = memberService.selectMemberInfoNonBlind(member);
		model.addAttribute("memberVO", member);
		return "myPageUpdate";
	}

	// 비밀번호 수정끝내고 다시 마이페이지이동
	@RequestMapping("updateMyInfo")
	public String updateMyInfo(MemberVO member,Like_areaVO likeArea
			,HttpSession session
			,MultipartHttpServletRequest mhsr
			, Model model) throws IOException {
		if(session.getAttribute("memberVO")!=null){
		
		logger.debug("{},{}","updateMyInfo_member",member);
		logger.debug("{},{}","updateMyInfo_likeArea",likeArea);
		if(likeArea!=null){
			if (likeArea.getArea_code() != null) {
				String[] areaList = likeArea.getArea_code().split(",");
				if(areaList.length>0){
					int res = likeAreaService.deleteLikeArea(member.getMem_id());
					for (String areaCode : areaList) {
						likeArea.setArea_code(areaCode);
						likeArea.setMem_id(member.getMem_id());
						likeAreaService.insertLikeArea(likeArea);
						
					}
				}
			}
		}
		//이미지 저장
		if(mhsr!=null){
			List<String> resFile = fileAddService.insertFileList(mhsr, "/upload/imageFolder/myProfile", 0);
			if(resFile.size()>0){
				member.setMem_profile(resFile.get(0));
			}
		}
		//member info update
		int resMemberInfo = memberService.updateMemberInfo(member);
		MemberVO newmemberVO = memberService.selectMemberInfo(member);
		session.setAttribute("memberVO", newmemberVO);
		//업데이트 완료후
		member = memberService.selectMemberInfo(member);
		model.addAttribute("memberVO", member);
		return "redirect:/myPage/main";
		}
		return "redirect:/main";}

	// 비밀번호 확인창으로 이동
	@RequestMapping("checkPass")
	public String checkPass(MemberVO member,HttpSession session, Model model) {
		member= (MemberVO) session.getAttribute("memberVO");
		member = memberService.selectMemberInfo(member);
		model.addAttribute("memberVO", member);
		return "checkPass";
	}

	// 활동정보 페이지(최근본 게시글)
	@RequestMapping("selectRecentBoard")
	public String selectRecentBoard(MemberVO member, Model model){
			
			return  "selectRecentBoard";
	}
	
	// 활동정보 페이지(최근본 여행지)
		@RequestMapping("selectRecentTrevel")
		public String selectRecentTrevel(MemberVO member, Model model){
				return "selectRecentTrevel";
		
		}

	// 여행지 즐겨찾기
	@RequestMapping("selectBookmarkArea")
	public String selectBookmarkArea(MemberVO member,PageVO page,
			HttpSession session, Model model) {
		String mem_id =session.getAttribute("mem_id")+"";
		
		
		if(page!=null){
			page.setPageNo(page.getPageNo()); // 현재 페이지 번호
		}
		
		//페이지 블록 사이즈
		page.setBlockSize(10);
		//전체 게시물 수
		page.setTotalCount(boardService.selectBoardCnt(mem_id));
		
		Map<String, String> map = new HashMap<String, String>(); 
		map.put("pageNo", page.getPageNo()+"");
		map.put("mem_id", mem_id);
		//페이징객체 만들기
		page.makePaging();
		//해당 페이지의 리스트 가져오기
	
		List<Bookmark_areaVO> bookmarkAreaList = boardService.getBookmarkAreaPageList(map);
		//모델에 담기
		model.addAttribute("page", page);
		//회원 아이디에 해당하는 즐겨찾기 리스트 불러오기
//		List<Bookmark_areaVO> bookmarkAreaList = memberService.selectBookmarkArea(mem_id);
		model.addAttribute("bookmarkAreaList",bookmarkAreaList);
		return "selectBookmarkArea";
	}

	//최근본 게시글 삭제
	@RequestMapping("updateRecentBoard")
	public String updateRecentBoard(MemberVO member, Model model) {

		
		//최근본 게시글로 이동
		return "selectRecentBoard";
	}
	
	//여행지 즐겨찾기 삭제
	@RequestMapping("deleteBookmarkArea")
	public String deleteBookmarkArea(MemberVO member,
			@RequestParam(required=true)int link,
			Model model) {
		logger.debug("{},{}","deleteBookmarkArea",link);
		int res = memberService.deleteBookmarkArea(link);
		
		//여행지 즐겨찾기 삭제
		return "redirect:/myPage/selectBookmarkArea";
	}
	
	@RequestMapping("deleteBookmarkAreaList")
	public String deleteBookmarkAreaList(MemberVO member,
			@RequestParam(required=true)int[] delBookmark,
			Model model) {
		
		for (int i = 0; i < delBookmark.length; i++) {
			int res = memberService.deleteBookmarkArea(delBookmark[i]);
		}
		logger.debug("{},{}","delBookmark",delBookmark);
	//	int res = memberService.deleteBookmarkArea(link);
		
		//여행지 즐겨찾기 삭제
		return "redirect:/myPage/selectBookmarkArea";
	}
	
	
	
}
