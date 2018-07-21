package com.yolo.controller.user.board.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yolo.model.BoardVO;
import com.yolo.model.File_addVO;
import com.yolo.model.MemberVO;
import com.yolo.model.PageVO;
import com.yolo.model.PboardVO;
import com.yolo.model.ReplyVO;
import com.yolo.model.TagVO;
import com.yolo.service.admin.FileAddServiceInf;
import com.yolo.service.board.BoardServiceInf;
import com.yolo.service.board.ReplyServiceInf;

/**
 * BoardController.java
 *
 * @author JiHee
 * @since 2018. 6. 21.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 21. JiHee 최초 생성
 *
 * </pre>
 */
@RequestMapping("/board")
@Controller("BoardController")
public class BoardController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource
	BoardServiceInf boardService;
	
	@Resource
	ReplyServiceInf replyService;
	
	@Resource
	FileAddServiceInf fileService;
	
	/**
	 * Method : travelMainForm
	 * 최초작성일 : 2018. 6. 21.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : 여행후기 메인 게시판 폼
	 */
	@RequestMapping("/travelMain")
	public String travelMainForm(PageVO page, Model model,HttpSession session){
		
		if(page!=null){
			page.setPageNo(page.getPageNo()); // 현재 페이지 번호
		}
		
		//페이지 블록 사이즈
		page.setBlockSize(10);
		//전체 게시물 수 (게시판번호)
		page.setTotalCount(boardService.selectBoardCnt(1));
		//게시판선택(게시판번호): 페이지객체에 입력
		page.setPboard_seq(1);
		session.setAttribute("pboardSeq", 1);
		//페이징객체 만들기
		page.makePaging();
		//해당 페이지의 리스트 가져오기
		List<BoardVO> boardList = boardService.getboardList(page);
		//모델에 담기
		model.addAttribute("page", page);
		model.addAttribute("boardList", boardList);
		return "travelMain";
	}
	
	/**
	 * Method : detailForm
	 * 최초작성일 : 2018. 6. 21.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : 여행후기 게시글 상세 폼
	 */
	@RequestMapping("/travelDetail")
	public String detailForm(Model model,HttpSession session,@RequestParam(required=false)String link,
			BoardVO boardVO,@RequestParam(required=false)String update
			){
		
		
		if(link!=null){
			int link_int = Integer.parseInt(link);
			
			log.debug("{},{}","link",link);
			session.setAttribute("link", link);
				//조회수 올려주기
			boardVO = boardService.updateHit(link_int);
			List<ReplyVO> replyList = replyService.selectReplyList(link_int);
			//게시글 조회
			model.addAttribute("boardVO",boardVO);
		
			//댓글 리스트가 빈값이 아니라면 모델에 추가
			if(replyList!=null){
				model.addAttribute("replyList",replyList);
			}
			
			List<TagVO> tagList = boardService.selectTagList(link_int);
			if(tagList.size()>0){
				model.addAttribute("tagList",tagList);
			}
			
			List<File_addVO> imageList = boardService.selectImageList(link_int);
			if(imageList.size()>0){
				model.addAttribute("imageList",imageList);
			}
		}
		if(update!=null){
			log.debug("{},{}","if(update!=null){",update);
			return "travelUpdate";
		}
		
		
		return "travelDetail";
	}
	
	
	/**
	 * Method : travelSearch
	 * 최초작성일 : 2018. 6. 22.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : 여행후기 페이지 내 검색
	 */
	@RequestMapping("/travelSearch")
	public String travelSearch(
			
			@RequestParam(required=true)String keyword,
			Model model, BoardVO qnaBoard,HttpSession session,PboardVO pboardVO,PageVO page){
		
		if(page!=null){
			page.setPageNo(page.getPageNo()); // 현재 페이지 번호
		}
		 
		//페이지 블록 사이즈
		page.setBlockSize(10);
		//전체 게시물 수
		page.setTotalCount(boardService.selectBoardCnt(1,keyword));
		//게시판선택
		page.setPboard_seq(1);
		//페이징객체 만들기
		page.makePaging();
		//해당 페이지의 리스트 가져오기
		List<BoardVO> boardList = boardService.getboardList(page,keyword);
		//모델에 담기
		model.addAttribute("page", page);
		model.addAttribute("boardList", boardList);
		model.addAttribute("keyword", keyword);
		
		return "travelMain";
	}
	
	/**
	 * Method : insertForm
	 * 최초작성일 : 2018. 6. 21.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : 여행후기 게시글 작성 폼
	 */
	@RequestMapping("/travelInsert")
	public String insertForm(HttpSession session,Model model
			){
		
		
		
		
		
		return "travelInsert";
	}
	
	/**
	 * Method : insertTravelReg
	 * 최초작성일 : 2018. 6. 22.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : 여행후기 등록
	 * @throws IOException 
	 */
	@RequestMapping("/insertTravelReg")
	public String insertTravelReg(HttpSession session,BoardVO boardVO,Model model,
			TagVO tagVO,MultipartHttpServletRequest mhsr
			) throws IOException{
		
		//세션에서 부모게시판번호 아이디 확인
		String pboardSeq = session.getAttribute("pboardSeq")+"";
		String memId = session.getAttribute("mem_id")+"";
		int pboard_seq = Integer.parseInt(pboardSeq);
		
		
		
		//boardVO가 널이 아니면
		if(boardVO!=null){
			log.debug("{},{}","/travelInsert/boardVO}",boardVO);
			boardVO.setPboard_seq(pboard_seq);
			boardVO.setBoard_mem_id(memId);
			boardVO.setBoard_private("Y");
			
			//저장
			boardService.insertBoard(boardVO);
			
			//tagVO가 널이 아니면
			if(!StringUtils.isEmpty(StringUtils.trimWhitespace(tagVO.getTag_content()))){
				boardService.insertTag(tagVO,boardVO.getBoard_seq());
				
				
			}
				
			
			
			//multipart가 널이 아니면
			if(mhsr!=null){
				log.debug("{},{}","mhsr.getFileNames()",mhsr.getFileNames());
				
				String dirPath ="/upload/imageFolder/boardImage/";
				List<MultipartFile> mf = mhsr.getFiles("file[]");
					
					//fileService.insertFileList(mhsr, dirPath, boardVO.getBoard_seq());
					for (MultipartFile multipartFile : mf) {
						if(multipartFile!=null){
							fileService.imageUpload(multipartFile, dirPath, boardVO.getBoard_seq());
						}
					}
			}
		}
		
		
		return "redirect:/board/travelMain";
	}
	
	
	/**
	 * Method : travelUpdateReg
	 * 최초작성일 : 2018. 6. 22.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : 여행후기 수정 등록
	 * @throws IOException 
	 */
	@RequestMapping("/travelUpdateReg")
	public String travelUpdateReg(HttpSession session,BoardVO boardVO,Model model,
			TagVO tagVO,MultipartHttpServletRequest mhsr,File_addVO fileAdd) throws IOException{
		
		String link = session.getAttribute("link")+"";
		int link_int =Integer.parseInt(link);
		log.debug("{},{}","게시글 수정 파일목록 :",fileAdd.toString());
		
		
				//boardVO가 널이 아니면
				if(boardVO!=null){
					log.debug("{},{}","/travelInsert/boardVO}",boardVO);
					boardVO.setBoard_seq(link_int);
					
					//저장
					boardService.updateBoard(boardVO);
					
					//해당글의 태그 다 지우기
					boardService.deleteTagList(link_int);
					//tagVO가 널이 아니면
					if(!StringUtils.isEmpty(StringUtils.trimWhitespace(tagVO.getTag_content()))){
						log.debug("{/travelInsert/tagVO},{}","",tagVO.toString());
							boardService.insertTag(tagVO,link_int);
					}
				
					if(fileAdd.getAdd_path()!=null){
					String[] arrayAddpath = fileAdd.getAdd_path().split(",");
						
					
					//해당 게시글의 리스트 다 가져와서 넘어온거 빼고 다 지우기
					List<File_addVO> oriFileList = boardService.selectImageList(link_int);
					for (int i = 0; i < oriFileList.size(); i++) {
						for (String str : arrayAddpath) {
							if(oriFileList.get(i).getAdd_path().equals(str)){
								oriFileList.remove(i);
							}
						}
					}
					//안넘어온 파일 지우기
					for (File_addVO file_addVO : oriFileList) {
						fileService.deleteFile(file_addVO.getAdd_seq());
					}
					}
					
					
					//multipart가 널이 아니면
					if(mhsr!=null){
						log.debug("{},{}","mhsr.getFileNames()",mhsr.getFileNames());
						
						String dirPath ="/upload/imageFolder/boardImage/";
						List<MultipartFile> mf = mhsr.getFiles("file[]");
							
							//fileService.insertFileList(mhsr, dirPath, boardVO.getBoard_seq());
							for (MultipartFile multipartFile : mf) {
								if(multipartFile!=null){
									fileService.imageUpload(multipartFile, dirPath, link_int);
								}
							}
					}
				}
		
		return "redirect:/board/travelDetail?link="+link_int;
	}
	
	
	@RequestMapping("/travelReply")
	public String travelReply(HttpSession session, Model model,
//			@RequestParam(required=false)int board_seq
			ReplyVO reply
			){
		if(reply!=null){
			log.debug("{},{}","/travelReply/travelReply/board_seq",reply.getBoard_seq());
			
			//0이면 첫댓글 1이면 2면 2차댓글
			reply.setPreply_seq(0);
			replyService.insertReply(reply,session);
		}
		String link = session.getAttribute("link")+"";
		return "redirect:/board/travelDetail?link="+link;
	}

	
	@RequestMapping("travelDelete")
	public String travelDelete(HttpSession session){
		String link = session.getAttribute("link")+"";
		boardService.deleteBoard(link);
		
		return "redirect:/board/travelMain";
	}
	
	// 댓글 수정
	@RequestMapping("replyModify")
	public String replyUpdate(HttpSession session ,ReplyVO replyVO){
		String link = session.getAttribute("link")+"";
		
		replyVO.setReply_member_id(session.getAttribute("mem_id").toString());
		
		replyService.updateReply(replyVO);
		
		return "redirect:/board/travelDetail?link="+link;
	}
	
	// 댓글 삭제
	@RequestMapping("replyDelete")
	public String replyDelete(HttpSession session ,ReplyVO replyVO)
	{
		String link = session.getAttribute("link")+"";
		
		replyService.deleteReply(replyVO.getReply_seq());
		
		return "redirect:/board/travelDetail?link="+link;
	}
}
