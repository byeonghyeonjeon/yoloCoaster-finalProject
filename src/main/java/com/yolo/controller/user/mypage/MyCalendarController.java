package com.yolo.controller.user.mypage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.yolo.model.Bookmark_scheVO;
import com.yolo.model.Content_detailVO;
import com.yolo.model.MemberVO;
import com.yolo.model.ScheduleVO;
import com.yolo.model.Schedule_detailVO;
import com.yolo.service.schedule.ScheduleServiceInf;

@RequestMapping("myCalendar")
@Controller
public class MyCalendarController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	ScheduleServiceInf scheduleService;
	
	/**
	 * 
	 * Method : myCalender
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param model
	 * @return
	 * Method 설명 : 로그인한 회원 캘린더의 일정 목록을 불러온다
	 */
	@RequestMapping("/Calendar")
	public String myCalender(Model model, HttpSession session){
		
		
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");

		if(memberVO == null){
			return "redirect:/main";
		}
		
		List<ScheduleVO> calendarList = scheduleService.getMemberScheduleList(memberVO.getMem_id());
		List<Bookmark_scheVO> bookMarkList = scheduleService.myCalendarBookMarkList(memberVO.getMem_id());
			
		if( calendarList != null){
//			logger.debug("{}", calendarList.get(0).getSchedule_start());
			
			model.addAttribute("calendarList", calendarList);
			model.addAttribute("bookMarkList", bookMarkList);
			return "Calendar";			
		}	
		return "Calendar";
		
	}
	
	
	/**
	 * 
	 * Method : myScheduleDetailPage
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @return
	 * Method 설명 : 일정 세부보기 
	 */
	@RequestMapping("scheduleDetailPage")
	public String myScheduleDetailPage(@RequestParam(required=false)String schedule_seq
			,@RequestParam(required=false)String link
			,HttpSession session,Model model
			
			){
		
		logger.debug("{},{}","schedule_seq",schedule_seq);
		
		
		
		//해당 일정의 번호를 입력하면 세부일정 목록 조회
		int pram = 0;
			if(schedule_seq!=null){
				pram = Integer.parseInt(schedule_seq);
				logger.debug("{},{}","schedule_seq!=null",schedule_seq);
				
			}
		
			//일정검색에서 넘어올때
			if(link!=null){
				String tempLink = session.getAttribute("link")+"";
				pram=Integer.parseInt(link);
				session.setAttribute("schedule_seq", pram); 
				logger.debug("{},{}","link!=null",link);
			}
			session.setAttribute("schedule_seq", schedule_seq); 
			
		//세부 일정 조회
		List<Schedule_detailVO> shceDetailList =  scheduleService.selectSchDetail(pram);
		int detail_seq = 0;
		
		if(shceDetailList.size()>0){
			detail_seq = shceDetailList.get(0).getDetail_seq();
		
			List<Content_detailVO> contentList = scheduleService.selectContentDetailList(detail_seq);
		
			session.setAttribute("detail_seq", detail_seq);
			//내용 리스트
			if(contentList.size()>0){
				model.addAttribute("contentList",contentList);
			}
		}else {
			Schedule_detailVO scheDetail = new Schedule_detailVO();
			scheDetail.setSchedule_seq(pram);
			scheDetail.setDetail_step(1);
			scheduleService.createScheDetail(scheDetail);
			
			// 세부일정 리스트에 담아서 보내기
			shceDetailList = scheduleService.selectSchDetail(pram);
			detail_seq = shceDetailList.get(0).getDetail_seq();
			
			//세부 내용 리스트에 담아 보내기
//			List<Content_detailVO> contentList = scheduleService.selectContentDetailList(detail_seq);
			session.setAttribute("detail_seq", detail_seq);
//			model.addAttribute("contentList",contentList);
//			logger.debug("{},{}","contentList",contentList.size());
		}
		//세부일정 리스트
		model.addAttribute("shceDetailList",shceDetailList);
		return "ScheduleDetailPage";
	}
	
	/**
	 * 
	 * Method : insertSche
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KYJ
	 * 변경이력 :
	 * @param session
	 * @param req
	 * @param model
	 * @param scheVO
	 * @return
	 * Method 설명 : 일정을 생성한다.
	 */
	@RequestMapping("insertSche")
	public String insertSche(HttpSession session,HttpServletRequest req,Model model, ScheduleVO scheVO) {
		//로그인 세션값에서 유저아이디 추출
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		
		scheVO.setSchedule_mem_id(memberVO.getMem_id());
		
		
			scheduleService.insertSchedule(scheVO);
		
		return "redirect:/myCalendar/Calendar";
	}
	
	
	/**
	 * 
	 * Method : modifyScheduleModal
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @return
	 * Method 설명 : 모달창 일정수정에서 일정을 업데이트 하는 컨트롤러 메서드
	 */
	@RequestMapping("modifyScheduleModal")
	public String modifyScheduleModal(ScheduleVO scheduleVO){
		
		logger.debug("{}{}", "modifyScheduleModal : scheduleVO.getSchedule_title() ", scheduleVO.getSchedule_title());
		logger.debug("{}{}", "modifyScheduleModal : scheduleVO.getSchedule_seq() ", scheduleVO.getSchedule_seq());
		logger.debug("{}{}", "modifyScheduleModal : scheduleVO.getSchedule_start() ", scheduleVO.getSchedule_start());
		logger.debug("{}{}", "modifyScheduleModal : scheduleVO.getSchedule_end() ", scheduleVO.getSchedule_end());
		logger.debug("{}{}", "modifyScheduleModal : scheduleVO.getSchedule_label() ", scheduleVO.getSchedule_label());
		logger.debug("{}{}", "modifyScheduleModal : scheduleVO.getSchedule_private() ", scheduleVO.getSchedule_private());
		
		int modalUpdate = scheduleService.modifyScheduleModal(scheduleVO);
		
		return "redirect:/myCalendar/Calendar";
		
	}
	
	
	/**
	 * 
	 * Method : deleteScheduleModal
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @return
	 * Method 설명 : 모달창에서 삭제 버튼을 통해 일정을 삭제하는 컨트롤러 메서드
	 */
	@RequestMapping("deleteScheduleModal")
	public String deleteScheduleModal(ScheduleVO scheduleVO){
		
		logger.debug("{}{}", "deleteScheduleModal : scheduleVO.getSchedule_seq()", scheduleVO.getSchedule_seq());
		
		int delete = scheduleService.deleteScheduleModal(scheduleVO.getSchedule_seq());
		
		return "redirect:/myCalendar/Calendar";
	}
	
	
	
	/**
	 * 
	 * Method : dragScheduleModify
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param scheduleVO
	 * Method 설명 : 마이캘린더에서 드래그로 일정 수정
	 */
	@RequestMapping("dragScheduleModify")
	public String dragScheduleModify(ScheduleVO scheduleVO){
		
		
		logger.debug("{}{}", "dragScheduleModify : scheduleVO.getSchedule_seq()", scheduleVO.getSchedule_seq());
		logger.debug("{}{}", "dragScheduleModify : scheduleVO.getSchedule_start()", scheduleVO.getSchedule_start());
		logger.debug("{}{}", "dragScheduleModify : scheduleVO.getSchedule_end()", scheduleVO.getSchedule_end());
		
		if(scheduleVO.getSchedule_seq() != 0){
			
			int dragUpdate = scheduleService.dragScheduleModify(scheduleVO);
		}
		
		
		return "redirect:/myCalendar/Calendar";
		
	}
	
	
	
	@RequestMapping("bookMarkScheduleInsert")
	@ResponseBody
	public void bookMarkScheduleInsert(HttpSession session, ScheduleVO scheduleVO){
		
		logger.debug("{}", "bookMarkScheduleInsert ---- 이곳 먼저 들어온다");
		
		logger.debug("{}{}" , "scheduleVO.getSchedule_start() : ", scheduleVO.getSchedule_start());
		logger.debug("{}{}" , "scheduleVO.getSchedule_end() : ", scheduleVO.getSchedule_end());
		logger.debug("{}{}" , "scheduleVO.getSchedule_title() : ", scheduleVO.getSchedule_title());
		logger.debug("{}{}" , "session.getAttribute(mem_id) : ",session.getAttribute("mem_id"));
		scheduleVO.setSchedule_mem_id((String) session.getAttribute("mem_id"));
		scheduleService.bookMarkscheduleInsert(scheduleVO);
		logger.debug("{}", "bookMarkScheduleInsert ---- 이 곳 종료");
		
	}
	
	
	@RequestMapping("myCalendarBookMarkCheckDelete")
	@ResponseBody
	public void myCalendarBookMarkCheckDelete(HttpSession session, ScheduleVO scheduleVO, @RequestParam("bookmark_seq")int bookmark_seq, Bookmark_scheVO bookmark_scheVO){
		
		logger.debug("{}", "myCalendarBookMarkCheckDelete ---- 이곳 먼저 들어온다");
		logger.debug("{}{}" , "session.getAttribute(mem_id) : ",session.getAttribute("mem_id"));
		logger.debug("{}{}", "bookmark_seq : " ,bookmark_seq);
		bookmark_scheVO.setBookmark_seq(bookmark_seq);
		bookmark_scheVO.setMem_id((String) session.getAttribute("mem_id"));
		scheduleVO.setSchedule_mem_id((String) session.getAttribute("mem_id"));
		scheduleService.bookMarkscheduleInsert(scheduleVO);
		scheduleService.myCalendarBookMarkCheckDelete(bookmark_scheVO);
		logger.debug("{}", "myCalendarBookMarkCheckDelete ---- 이 곳 종료");
		
	}
	
	
}
