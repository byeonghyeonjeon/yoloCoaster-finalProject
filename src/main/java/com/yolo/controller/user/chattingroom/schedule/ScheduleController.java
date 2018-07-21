/**
 * 
 */
package com.yolo.controller.user.chattingroom.schedule;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yolo.model.Chat_nameVO;
import com.yolo.model.MemberVO;
import com.yolo.model.ScheduleVO;
import com.yolo.service.schedule.ScheduleServiceInf;

/**
 * @author PC15
 *
 */
						
@RequestMapping(value="/chatSchedule")					
@Controller
public class ScheduleController {
	
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private ScheduleServiceInf scheduleService;
	
	
	@RequestMapping(value="/main")
	public String chatScheduleMain(){
		
		return "content/user/chattingroom/chatSchedule/chatScheduleMain";
	}
	
	
	
	/**
	 * 
	 * Method : getchatScheduleList
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param session
	 * @param scheduleVO
	 * @param chat_VO
	 * @return
	 * Method 설명 : chatScheduleMain.jsp에서 ajax를 통해 요청
	 */
	@RequestMapping("getchatScheduleList")
	public @ResponseBody List<ScheduleVO> getchatScheduleList(HttpSession session, ScheduleVO scheduleVO, Chat_nameVO chat_VO){
		
		
		logger.debug("{}", "getchatScheduleList");
		
		List<ScheduleVO> chatScheduleList = null;
		
		chat_VO = (Chat_nameVO) session.getAttribute("chatNameVO");
		scheduleVO.setChat_seq(chat_VO.getChat_seq());
		
		chatScheduleList = scheduleService.getchatScheduleList(scheduleVO);
		
		return chatScheduleList;
	}
	
	/**
	 * 
	 * Method : chatInsertScheduleModal
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @return
	 * Method 설명 : 채팅방에 스케줄 일정을 추가하는 컨트롤 메서드
	 */
	@RequestMapping("chatInsertScheduleModal")
	@ResponseBody
	public int chatInsertScheduleModal(HttpSession session,ScheduleVO scheduleVO){
		
		logger.debug("{}", "chatInsertScheduleModal-----------------------------");
		
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		Chat_nameVO chat_VO = (Chat_nameVO) session.getAttribute("chatNameVO");

		scheduleVO.setSchedule_mem_id(memberVO.getMem_id());
		scheduleVO.setChat_seq(chat_VO.getChat_seq());
		logger.debug("{}{}", "chatInsertScheduleModal : memberVO.getMem_id() : " , memberVO.getMem_id());
		logger.debug("{}{}", "chatInsertScheduleModal : chat_VO.getChat_seq() : " , chat_VO.getChat_seq());
		logger.debug("{}{}", "chatInsertScheduleModal : scheduleVO.getSchedule_title() : " , scheduleVO.getSchedule_title());
		logger.debug("{}{}", "chatInsertScheduleModal : scheduleVO.getSchedule_start : " , scheduleVO.getSchedule_start());
		logger.debug("{}{}", "chatInsertScheduleModal : scheduleVO.getSchedule_end : " , scheduleVO.getSchedule_end());
		logger.debug("{}{}", "chatInsertScheduleModal : scheduleVO.getSchedule_color : " , scheduleVO.getSchedule_label());
		logger.debug("{}{}", "chatInsertScheduleModal : scheduleVO.getSchedule_private() : " , scheduleVO.getSchedule_private());
		
		int schedule_seq_Num = scheduleService.insertChatScheduleModal(scheduleVO);
		logger.debug("{}{}","chatInsertScheduleModal : schedule_seq_Num : ",schedule_seq_Num );
		
		return schedule_seq_Num;
	}
	
	/**
	 * 
	 * Method : chatModifyScheduleModal
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param session
	 * @param scheduleVO
	 * @return
	 * Method 설명 : 채팅방 스케줄에서 모달창으로 스케줄을 수정하는 메서드
	 */
	@RequestMapping("chatModifyScheduleModal")
	@ResponseBody
	public List<ScheduleVO> chatModifyScheduleModal(HttpSession session, ScheduleVO scheduleVO, Chat_nameVO chat_VO){
		logger.debug("{}","chatModifyScheduleModal 여기로 오는지 테스트" );
		
		
		List<ScheduleVO> chatScheduleList = null;
		
		chat_VO = (Chat_nameVO) session.getAttribute("chatNameVO");
		scheduleVO.setChat_seq(chat_VO.getChat_seq());
		
		
		
		logger.debug("{}{}" , "scheduleVO.getSchedule_seq() : " , scheduleVO.getSchedule_seq());
		logger.debug("{}{}" , "scheduleVO.getSchedule_private() : " , scheduleVO.getSchedule_private());
		logger.debug("{}{}" , "scheduleVO.getSchedule_title() : " , scheduleVO.getSchedule_title());
		logger.debug("{}{}" , "scheduleVO.getSchedule_start() : " , scheduleVO.getSchedule_start());
		logger.debug("{}{}" , "scheduleVO.getSchedule_end() : " , scheduleVO.getSchedule_end());
		logger.debug("{}{}" , "scheduleVO.getSchedule_label() : " , scheduleVO.getSchedule_label());
		
		scheduleService.chatModifyScheduleModal(scheduleVO);
		
		chatScheduleList = scheduleService.getchatScheduleList(scheduleVO);
		
		return chatScheduleList;

	}
	
	
	/**
	 * 
	 * Method : chatDeleteScheduleModal
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param session
	 * @param scheduleVO
	 * Method 설명 : 채팅 스케줄에서 일정을 삭제하는 컨트롤러
	 */
	@RequestMapping("chatDeleteScheduleModal")
	@ResponseBody
	public void chatDeleteScheduleModal(HttpSession session, ScheduleVO scheduleVO){
		
		logger.debug("{}","chatDeleteScheduleModal 여기로 오는지 테스트" );
		
		logger.debug("{}{}", "scheduleVO.getSchedule_seq() : scheduleVO.getSchedule_seq()" , scheduleVO.getSchedule_seq());
		
		scheduleService.chatDeleteScheduleModal(scheduleVO.getSchedule_seq());
		
	}
	
	@RequestMapping("chatDragScheduleModify")
	@ResponseBody
	public List<ScheduleVO> chatDragScheduleModify(HttpSession session, ScheduleVO scheduleVO, Chat_nameVO chat_VO){
		
		logger.debug("{}", "chatDragScheduleModify");
		logger.debug("{}", scheduleVO.getSchedule_seq());
		logger.debug("{}", scheduleVO.getSchedule_start());
		logger.debug("{}", scheduleVO.getSchedule_end());
		
		scheduleService.chatDragScheduleModify(scheduleVO);
		
		List<ScheduleVO> chatScheduleList = null;
		
		chat_VO = (Chat_nameVO) session.getAttribute("chatNameVO");
		scheduleVO.setChat_seq(chat_VO.getChat_seq());
		
		chatScheduleList = scheduleService.getchatScheduleList(scheduleVO);
		
		return chatScheduleList;
		
	}
	
	
	@RequestMapping("chatScheDetail")
	public String chatScheDetail(){
		
		return "chatSchedule/chatScheDetail";
	}
}
