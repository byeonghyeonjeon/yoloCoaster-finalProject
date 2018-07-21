package com.yolo.controller.admin.admin;

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

import com.yolo.model.BoardVO;
import com.yolo.model.File_addVO;
import com.yolo.model.PageVO;
import com.yolo.model.ReplyVO;
import com.yolo.model.TagVO;
import com.yolo.service.admin.AdminBoardServiceInf;
import com.yolo.service.board.BoardServiceInf;
import com.yolo.service.board.ReplyServiceInf;

@RequestMapping("adminBoard")
@Controller
public class AdminBoardController {
	
	@Resource
	ReplyServiceInf replyService;
	
	@Resource
	BoardServiceInf boardService;

	@Resource
	AdminBoardServiceInf adminBoardService;
	//데이터 완전삭제
		@RequestMapping("reSetting")
		@ResponseBody
		public String reSetting(@RequestBody Map<String, String> parameterMap,HttpSession session){
			if (parameterMap != null) {
			
				String link = parameterMap.get("link");
				String board_st = parameterMap.get("board_st");
				if(board_st.equals("Y")||board_st=="Y"){
					board_st="N";
				}else{
					board_st="Y";
				}
				Map<String, String> paramMap = new HashMap<String, String>();
				paramMap.put("link", link);
				paramMap.put("board_st", board_st);
				int res = adminBoardService.boardStReset(paramMap);
				if(res==1){
					return "1";
				}
			}
			return "0";
		}
		
		
		//데이터 완전삭제
		@RequestMapping("deleteQna")
		@ResponseBody
		public String deleteQna(@RequestBody Map<String, String> parameterMap,HttpSession session){
			if (parameterMap != null) {
			
				String link = parameterMap.get("link");
				int res = adminBoardService.deleteDataBoard(link);
				if(res==1){
					return "1";
				}
			}
			return "0";
		}

	/**
	 * 
	 * Method : adminNotice
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : brown
	 * 변경이력 :
	 * @return
	 * Method 설명 :게시글 관리
	 */
	@RequestMapping("adminNotice")
	public String adminNotice(PageVO page, Model model,HttpSession session,@RequestParam(required=false)String keyword){
		if(keyword!=null){
			if(page!=null){
				page.setPageNo(page.getPageNo()); // 현재 페이지 번호
			}
			
			//페이지 블록 사이즈
			page.setBlockSize(10);
			
			Map<String, String> paramMap = new HashMap<String, String>();
				//게시판 선택
				paramMap.put("pboard_seq", 1+"");
				paramMap.put("keyword", keyword);
			//전체 게시물 수 (게시판번호)
			int totalCnt = adminBoardService.adminSelectBoardCnt(paramMap);
			page.setTotalCount(totalCnt);
			//게시판선택(게시판번호): 페이지객체에 입력
			page.setPboard_seq(1);
			//페이징객체 만들기
			page.makePaging();
			//해당 페이지의 리스트 가져오기
			
			Map<String, String> paramMap2 = new HashMap<String, String>();
			paramMap2.put("pboard_seq", 1+"");
			paramMap2.put("keyword", keyword);
			paramMap2.put("pageNo", page.getPageNo()+"");
			List<BoardVO> boardList = adminBoardService.adminSelectListboard(paramMap2);
			//모델에 담기
			model.addAttribute("page", page);
			model.addAttribute("boardList", boardList);
			
			//전체 게시물 수
			model.addAttribute("stat1", totalCnt);
		}else{
		
		if(page!=null){
			page.setPageNo(page.getPageNo()); // 현재 페이지 번호
		}
		
		//페이지 블록 사이즈
		page.setBlockSize(10);
		
		//게시판 선택
		int param = 1;
		//전체 게시물 수 (게시판번호)
		int totalCnt = boardService.adminSelectBoardCnt(param);
		page.setTotalCount(totalCnt);
		//게시판선택(게시판번호): 페이지객체에 입력
		page.setPboard_seq(1);
		//페이징객체 만들기
		page.makePaging();
		//해당 페이지의 리스트 가져오기
		List<BoardVO> boardList = boardService.adminSelectListboard(page);
		//모델에 담기
		model.addAttribute("page", page);
		model.addAttribute("boardList", boardList);
		//전체 게시물 수
		model.addAttribute("stat1", totalCnt);
		}

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("pboard_seq","1");
		paramMap.put("condition", "Y");
		int stat3 = adminBoardService.adminBoardStCnt(paramMap);
		
		
		Map<String, String> timeMap = new HashMap<String, String>();
		timeMap.put("pboard_seq", "1");
		int stat2 = boardService.todayRegBoard(timeMap);
		
		
		//오늘 작성된 게시글
		model.addAttribute("stat2", stat2);
		//답변을 기다리는 게시글
		model.addAttribute("stat3", stat3);
		
		//keyword 반환
		model.addAttribute("keyword", keyword);
		
		return "adminNotice";
	}
	
	/**
	 * 
	 * Method : adminQnA
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : brown
	 * 변경이력 :
	 * @return
	 * Method 설명 :Qna관리
	 */
	@RequestMapping("adminQna")
	public String adminQnA(PageVO page, Model model,HttpSession session,@RequestParam(required=false)String keyword){
		if(keyword!=null){
			if(page!=null){
				page.setPageNo(page.getPageNo()); // 현재 페이지 번호
			}
			
			//페이지 블록 사이즈
			page.setBlockSize(10);
			
			Map<String, String> paramMap = new HashMap<String, String>();
				//게시판 선택
				paramMap.put("pboard_seq", 2+"");
				paramMap.put("keyword", keyword);
			//전체 게시물 수 (게시판번호)
			int totalCnt = adminBoardService.adminSelectBoardCnt(paramMap);
			page.setTotalCount(totalCnt);
			//게시판선택(게시판번호): 페이지객체에 입력
			page.setPboard_seq(2);
			//페이징객체 만들기
			page.makePaging();
			//해당 페이지의 리스트 가져오기
			
			Map<String, String> paramMap2 = new HashMap<String, String>();
			paramMap2.put("keyword", keyword);
			paramMap2.put("pboard_seq", 2+"");
			paramMap2.put("keyword", keyword);
			paramMap2.put("pageNo", page.getPageNo()+"");
			List<BoardVO> qnaList = adminBoardService.adminSelectListboard(paramMap2);
			//모델에 담기
			model.addAttribute("page", page);
			model.addAttribute("boardList", qnaList);
			
			//전체 게시물 수
			model.addAttribute("stat1", totalCnt);
		}else{
		if(page!=null){
			page.setPageNo(page.getPageNo()); // 현재 페이지 번호
		}
		
		//페이지 블록 사이즈
		page.setBlockSize(10);
		
		//게시판 선택
		int param = 2;
		//전체 게시물 수 (게시판번호)
		int totalCnt = boardService.adminSelectBoardCnt(param);
		page.setTotalCount(totalCnt);
		//게시판선택(게시판번호): 페이지객체에 입력
		page.setPboard_seq(2);
		//페이징객체 만들기
		page.makePaging();
		//해당 페이지의 리스트 가져오기
		List<BoardVO> qnaList = boardService.adminSelectListboard(page);
		//모델에 담기
		model.addAttribute("page", page);
		model.addAttribute("boardList", qnaList);
		
		//전체 게시물 수
		model.addAttribute("stat1", totalCnt);
		}
		//기본 하단 셋팅
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("pboard_seq", "2");
		paramMap.put("condition", "0");
		int stat3 = boardService.adminBoardWait(paramMap);
		
		
		Map<String, String> timeMap = new HashMap<String, String>();
		timeMap.put("pboard_seq", "2");
		int stat2 = boardService.todayRegBoard(timeMap);
		
		
		//오늘 작성된 게시글
		model.addAttribute("stat2", stat2);
		//답변을 기다리는 게시글
		model.addAttribute("stat3", stat3);
		
		//keyword 반환
		model.addAttribute("keyword", keyword);
		
		return "adminQna";
	}
	
	/**
	 * 
	 * Method : adminQnaInsert
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param page
	 * @param model
	 * @param session
	 * @return
	 * Method 설명 :qna 답변등록페이지
	 */
	@RequestMapping("adminQnaInsert")
	public String adminQnaInsert(PageVO page, Model model,HttpSession session,@RequestParam(required=true)int pboard_seq){
		BoardVO boardVO = boardService.selectBoard(pboard_seq);
		model.addAttribute("boardVO",boardVO);
		return "adminQnaInsert";
	}
	
	
	@RequestMapping("adminQnaInsertReg")
	public String adminQnaInsertReg(HttpSession session,BoardVO boardVO){
		if(session.getAttribute("mem_id").equals("admin")){
			if(boardVO!=null){
				int res =  adminBoardService.updateBoard(boardVO);
			}
		}
		
		return "redirect:/adminBoard/adminQna";
	}
	
	
	
	
	@RequestMapping("adminNoticeDetail")
	public String adminNoticeDetail(Model model,HttpSession session,@RequestParam(required=false)String link,
			BoardVO boardVO
			){
		
		
		if(link!=null){
			int link_int = Integer.parseInt(link);
			
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
		
		return "adminNoticeDetail";
		
	}
}
