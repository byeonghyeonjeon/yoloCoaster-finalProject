package com.yolo.controller.user.board.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yolo.model.BoardVO;
import com.yolo.model.MessageVO;
import com.yolo.model.PageVO;
import com.yolo.model.PboardVO;
import com.yolo.service.board.BoardServiceInf;

/**
 * OnAController.java
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
@RequestMapping("/qna")
@Controller("QnAController")
public class QnAController {
	
	@Resource
	BoardServiceInf boardService;
	
	
	
	//세션체크
	@RequestMapping("/sessionCheck")
	@ResponseBody
	public String sessionCheck(@RequestBody Map<String, String> parameterMap,HttpSession session){
		if (parameterMap != null) {
		
			String userId = parameterMap.get("userId");
			String mem_id = session.getAttribute("mem_id")+"";
			
			if(userId.equals(mem_id)){
				return "1";
			}
		}
		return null;
	}
	
	/**
	 * Method : qnaListForm
	 * 최초작성일 : 2018. 6. 21.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : Q&A 메인 폼
	 */
	@RequestMapping("/qnaMain")
	public String qnaListForm(Model model, BoardVO qnaBoard,HttpSession session,PboardVO pboardVO,PageVO page){
		session.setAttribute("pboardSeq", 2);
		if(page!=null){
			page.setPageNo(page.getPageNo()); // 현재 페이지 번호
		}
		
		//페이지 블록 사이즈
		page.setBlockSize(10);
		//전체 게시물 수
		page.setTotalCount(boardService.selectBoardCnt(2));
		//게시판선택
		page.setPboard_seq(2);
		//페이징객체 만들기
		page.makePaging();
		//해당 페이지의 리스트 가져오기
		List<BoardVO> boardList = boardService.getboardList(page);
		//모델에 담기
		model.addAttribute("page", page);
		model.addAttribute("boardList", boardList);
		
		
		
		return "qnaMain";
	}
	
	/**
	 * Method : qnaInsertForm
	 * 최초작성일 : 2018. 6. 21.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : Q&A 게시글 작성 폼
	 */
	@RequestMapping("/qnaInsert")
	public String qnaInsertForm(HttpSession session,Model model){
		
		
		return "qnaInsert";
	}
	
	/**
	 * Method : qnaDetailForm
	 * 최초작성일 : 2018. 6. 21.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : Q&A 게시글 상세 폼
	 */
	@RequestMapping("/qnaDetail")
	public String qnaDetailForm(@RequestParam(required=false) int boardNo, Model model){
		BoardVO board =  boardService.selectBoard(boardNo);
		
		model.addAttribute("board",board);
		return "qnaDetail";
	}
	
	/**
	 * Method : qnaUpdateForm
	 * 최초작성일 : 2018. 6. 21.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : Q&A 게시글 수정 폼이동
	 */
	@RequestMapping("/qnaUpdate")
	public String qnaUpdateForm(){
		return "qnaUpdate";
	}
	
	/**
	 * 
	 * Method : qnaUpdateForm
	 * 최초작성일 : 2018. 6. 22.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @return
	 * Method 설명 : qna페이지 내 검색
	 */
	@RequestMapping("/qnaSearch")
	public String qnaSearch(
			@RequestParam(required=true)String keyword,
			Model model, BoardVO qnaBoard,HttpSession session,PboardVO pboardVO,PageVO page){
		
		if(page!=null){
			page.setPageNo(page.getPageNo()); // 현재 페이지 번호
		}
		//페이지 블록 사이즈
		page.setBlockSize(10);
		//전체 게시물 수
		page.setTotalCount(boardService.selectBoardCnt(2,keyword));
		//게시판선택
		page.setPboard_seq(2);
		//페이징객체 만들기
		page.makePaging();
		//해당 페이지의 리스트 가져오기
		List<BoardVO> boardList = boardService.getboardList(page,keyword);
		//모델에 담기
		model.addAttribute("page", page);
		model.addAttribute("boardList", boardList);
		model.addAttribute("keyword", keyword);
		
		
		
		return "qnaMain";
	}
	
	/**
	 * 
	 * Method : qnaUpdateReg
	 * 최초작성일 : 2018. 6. 22.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @return
	 * Method 설명 : 수정 등록
	 */
	@RequestMapping("/qnaUpdateReg")
	public String qnaUpdateReg(){
		
		return "qnaDetail";
	}
	
	/**
	 * 
	 * Method : insertQnaReg
	 * 최초작성일 : 2018. 6. 22.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @return
	 * Method 설명 :  qna 등록
	 */
	@RequestMapping("/insertQnaReg")
	public String insertQnaReg(HttpSession session,Model model,BoardVO board){
		if(session.getAttribute("mem_id")!=null){
		board.setPboard_seq(2);
		board.setBoard_reply("0");
		
		
		String mem_id = session.getAttribute("mem_id")+"";

		board.setBoard_mem_id(mem_id);
		boardService.insertBoard(board);
		
		}
		return "redirect:/qna/qnaMain";
	}
}
