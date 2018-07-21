package com.yolo.controller.user.main;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yolo.model.BasicinfoVO;
import com.yolo.model.BoardVO;
import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.CategoryVO;
import com.yolo.model.MemberVO;
import com.yolo.model.PageVO;
import com.yolo.model.TravelVO;
import com.yolo.service.admin.CategoryServiceInf;
import com.yolo.service.basicInfo.BasicInfoServiceInf;
import com.yolo.service.basicInfo.TravelOfMainServiceInf;

/**
 * IndexController.java
 *
 * @author Jun
 * @since 2018. 6. 16.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 16. Jun 최초 생성
 *
 * </pre>
 */
@RequestMapping
@Controller
public class IndexController {
	
	@Resource
	private CategoryServiceInf categoryService;
	
	@Resource
	private TravelOfMainServiceInf travelOfMainService;
	
	@Resource(name="basicInfoService")
	private BasicInfoServiceInf basicInfoService;
	
	@RequestMapping("/main")
	public String choiceMethod(Model model, HttpSession session, CategoryVO categoryVO, @RequestParam(required=false, defaultValue="01") String selected) {
		if (selected != null) {
			switch (selected) {
			case "01":
				// 활성화된 카테고리 
				model.addAttribute("categoryVOs", selectCategoryList());
				MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
				
				
				if (memberVO != null) {
					if(memberVO.getMem_id() != null){
						String mem_id = null;
						mem_id = memberVO.getMem_id();
						
						// 회원 아이디에 맞는 관심지역 조회
						List<TravelVO> basicinfoVO = travelOfMainService.areaOfInterest(mem_id);
						if(basicinfoVO.size() != 0){
							// 관심지역 총 개수 조회
							int areaCnt = travelOfMainService.numberOfAreaOfInterest(mem_id);
							// 관심지역 리스트
							model.addAttribute("basicinfoVO", basicinfoVO);
							// 관심지역 총 개수 
							model.addAttribute("areaCnt", areaCnt);
						}
						
						// 프로필 기반으로 여행지 추천
						List<TravelVO> profileBasicVO = travelOfMainService.profileRecommend(memberVO);
						if(profileBasicVO.size() != 0){
							// 프로필  총 개수 조회
							int profileCnt = travelOfMainService.numberOfProfileRecommend(memberVO);
							// 프로필 리스트
							model.addAttribute("profileBasicVO", profileBasicVO);
							// 프로필 총 개수 
							model.addAttribute("profileCnt", profileCnt);
						}
						
						// 지역 축제 여행지 추천
						List<TravelVO> eventBasicVO = travelOfMainService.eventRecommend(memberVO);
						if(eventBasicVO.size() != 0){
							// 지역 축제  총 개수 조회
							int eventCnt = travelOfMainService.numberOfEventRecommend(memberVO);
							// 지역 축제 리스트
							model.addAttribute("eventBasicVO", eventBasicVO);
							// 지역 축제 총 개수
							model.addAttribute("eventCnt", eventCnt);
							
						}
					}
				}
				break;
			case "02":
				String keyword = "";
				try {
					keyword = URLEncoder.encode(categoryVO.getCate_name().trim(),"UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return "redirect:/travel/search?selected=keyword&keyword="+keyword;
			}
		}
		//세션의 아이디 확인 후 header에서 로그인 또는 로그아웃 둘 중에 하나 띄움
		
		
		return "index";
	}
	
	
	/**
	 * Method : selectCategoryList
	 * 최초작성일 : 2018. 6. 21.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return 모든 카테고리 목록
	 * Method 설명 : 활성화된 모든 카테고리 반환
	 */
	private List<CategoryVO> selectCategoryList() {
		return categoryService.selectCategoryList();
	}
	
	@RequestMapping("mainSelect")
	public String choiceMethod(Model model, HttpSession session) {

		return "mainSelect";
	}
	
	/**
	 * Method : bookmarkPaging
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param pageNoMap
	 * @param session
	 * @return
	 * Method 설명 : 우측바 즐겨찾기 목록 페이징 처리
	 */
	@RequestMapping("bookmarkPaging")
	@ResponseBody
	public Map<String, Object> bookmarkPaging(@RequestBody Map<String, Integer> pageNoMap, HttpSession session) {
		if(session.getAttribute("memberVO") != null){
			String mem_id = ((MemberVO)session.getAttribute("memberVO")).getMem_id();
			int pageNo = pageNoMap.get("pageNo");
			int result = basicInfoService.selectBookmarkCnt(mem_id);
			List<Bookmark_areaVO> list = basicInfoService.getBookmarkAreaRightBar(mem_id, pageNo); 
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("bookmark_areaVOs", list);
			map.put("totalCnt", result);
			return map;
		}
		return null;
	}
	
	/**
	 * Method : areaOfInterestMore
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : 관심지역 더보기 조회
	 */
	@RequestMapping("areaMore")
	public String areaOfInterestMore(PageVO page, Model model, HttpSession session, @RequestParam(defaultValue="area") String select ){
		if(select == null){
			return "redirect:/main";
		}
		
		if(page!=null){
			page.setPageNo(page.getPageNo()); // 현재 페이지 번호
		}
		
		String mem_id = null;
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		if (memberVO != null) {
			if (memberVO.getMem_id() != null) {
				mem_id = memberVO.getMem_id();
			}
		}
		
		select = select.trim();
		//페이지 블록 사이즈
		page.setBlockSize(10);
		// 회원 아이디가 존재 할 경우 관심지역 조회 가능
		if(mem_id != null){
			// 관심지역 전부 조회
			if(select.equals("area")){
				//게시판선택(게시판번호): 페이지객체에 입력
				page.setPboard_seq(1);
				//전체 게시물 수 (게시판번호)
				page.setTotalCount(travelOfMainService.numberOfAreaOfInterest(mem_id));
				//페이징객체 만들기
				page.makePaging();
				//해당 페이지의 리스트 가져오기
				List<TravelVO> basicinfoVOs = travelOfMainService.areaRecommendPage(page, mem_id);
				model.addAttribute("basicinfoVOs", basicinfoVOs);
				model.addAttribute("page", page);
			}
			
			// 프로필 기반으로 전보 조회
			if(select.equals("profile")){
				//게시판선택(게시판번호): 페이지객체에 입력
				page.setPboard_seq(1);
				//전체 게시물 수 (게시판번호)
				page.setTotalCount(travelOfMainService.numberOfProfileRecommend(memberVO));
				//페이징객체 만들기
				page.makePaging();
				//해당 페이지의 리스트 가져오기
				List<TravelVO> profileBasicVOs = travelOfMainService.getAllprofileRecommend(page, memberVO);
				model.addAttribute("basicinfoVOs", profileBasicVOs); 
				model.addAttribute("page", page);
			}
			
			if(select.equals("event")){
				//게시판선택(게시판번호): 페이지객체에 입력
				page.setPboard_seq(1);
				//전체 게시물 수 (게시판번호)
				page.setTotalCount(travelOfMainService.numberOfEventRecommend(memberVO));
				//페이징객체 만들기
				page.makePaging();
				//해당 페이지의 리스트 가져오기
				List<TravelVO> eventBasicVOs = travelOfMainService.eventRecommendPage(page, memberVO);
				model.addAttribute("basicinfoVOs", eventBasicVOs); 
				model.addAttribute("page", page);
			}
		}
		
		
		return "areaListMore";
	}
	
	
}
