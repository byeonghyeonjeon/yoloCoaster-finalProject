package com.yolo.controller.user.board.schedule;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.ContentForm;
import com.yolo.model.Content_detailVO;
import com.yolo.model.PageVO;
import com.yolo.model.ScheduleVO;
import com.yolo.model.Schedule_detailVO;
import com.yolo.service.board.BoardServiceInf;
import com.yolo.service.schedule.ScheduleServiceInf;

@RequestMapping("scheBoard")
@Controller
public class scheBoardController {
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource
	BoardServiceInf boardService;
	
	@Resource
	ScheduleServiceInf scheService;
	/**
	 * 
	 * Method : selectScheBoardList
	 * 최초작성일 : 2018. 6. 21.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @return
	 * Method 설명 : 일정게시판 조회
	 */
	@RequestMapping("selectScheBoardList")
	public String selectScheBoardList(Model model,PageVO page) {
		//페이지네이션
		if(page!=null){
			page.setPageNo(page.getPageNo()); // 현재 페이지 번호
		}
		
		//페이지 블록 사이즈
		page.setBlockSize(10);
		//전체 게시물 수
		page.setTotalCount(boardService.selectScheListForBoard().size());
		//페이징객체 만들기
		page.makePaging();
		//해당 페이지의 리스트 가져오기
		List<ScheduleVO> scheList = boardService.getSchePageList(page);
		//모델에 담기
		model.addAttribute("page", page);
		
		
		model.addAttribute("scheList",scheList);
		return "selectScheBoardList";
	}
	
	@RequestMapping("search")
	public String search(Model model,PageVO page,@RequestParam(required=true)String keyword) {
			//페이지네이션
			if(page!=null){
				page.setPageNo(page.getPageNo()); // 현재 페이지 번호
			}
			
			//페이지 블록 사이즈
			page.setBlockSize(10);
			//전체 게시물 수
			page.setTotalCount(boardService.selectScheListForBoard(keyword));
			//페이징객체 만들기
			page.makePaging();
			//해당 페이지의 리스트 가져오기
			List<ScheduleVO> scheList = boardService.getSchePageList(page,keyword);
			//모델에 담기
			model.addAttribute("page", page);
			
			
			model.addAttribute("scheList",scheList);
			model.addAttribute("keyword", keyword);
		
		
		return "searchScheBoard";
	}
	

	
	/**
	 * 
	 * Method : ScheduleDetailReadPage
	 * 최초작성일 : 2018. 7. 7.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param session
	 * @param req
	 * @param detail_seq
	 * @param model
	 * @param list
	 * @return
	 * Method 설명 :단순 조회
	 */
	@RequestMapping("selectScheBoardUnit")
	public String ScheduleDetailReadPage(Model model,@RequestParam(required=false)String link,
			HttpSession session, HttpServletRequest req,
			@RequestParam(value="detail_seq",required=false)String detail_seq,
			@ModelAttribute ContentForm list) {
		//세션에서 값꺼내기
		int schedule_seq = 0;
		if(session.getAttribute("link")!=null){
			schedule_seq = Integer.parseInt(session.getAttribute("link")+"");
		}
		if(link!=null){
			session.setAttribute("link", link);
			schedule_seq=Integer.parseInt(session.getAttribute("link")+"");
			model.addAttribute("link",link);
		}
		
		int detail_seq_int = 0;
		
		log.debug("{},{}","schedule_seq",schedule_seq);
		log.debug("{},{}","detail_seq_int",detail_seq_int);
		//어떤 세부일정 가져올지 찾기(detail_seq:고유번호)
		
		//세부 일정 조회
		List<Schedule_detailVO> shceDetailList =  scheService.selectSchDetail(schedule_seq);
		
		
		//디테일 리스트의 첫번째 값을 셋팅
		if(shceDetailList.size()>0){
			detail_seq_int=shceDetailList.get(0).getDetail_seq();
		
		
		
		
		
		
		if(detail_seq!=null){
			detail_seq_int = Integer.parseInt(detail_seq);
		}
		List<Content_detailVO> contentList = scheService.selectContentDetailList(detail_seq_int);
		
		//세부일정 리스트
		model.addAttribute("shceDetailList",shceDetailList);
		log.debug("{},{}","shceDetailList",shceDetailList);
		
		//내용 리스트
		if(contentList.size()>0){
			String mem_id = scheService.getScheduleMemId(schedule_seq);
			model.addAttribute("contentList",contentList);
			log.debug("{},{}","contentList",contentList);
			List<Bookmark_areaVO> bookmarkList= scheService.getBookmarkListStr(contentList,mem_id);
			model.addAttribute("bookmarkList",bookmarkList);
		}
		
//		model.addAttribute("detail_seq",detail_seq);
		
		
		//세션에 값담기
		session.setAttribute("detail_seq", detail_seq);
		model.addAttribute("detail_seq",detail_seq);
		session.setAttribute("schedule_seq", schedule_seq);
		model.addAttribute("schedule_seq",schedule_seq);
		model.addAttribute("link",link);
		}
		return "ScheduleDetailReadPage";
	}
	
	
}
