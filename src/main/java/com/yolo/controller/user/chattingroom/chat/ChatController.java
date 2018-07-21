package com.yolo.controller.user.chattingroom.chat;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yolo.model.Chat_groupVO;
import com.yolo.model.Chat_nameVO;
import com.yolo.model.FriendMemberVO;
import com.yolo.model.MemberVO;
import com.yolo.model.MessageVO;
import com.yolo.service.admin.FileAddServiceInf;
import com.yolo.service.chat.ChatGroupServiceInf;
import com.yolo.service.chat.ChatNameServiceInf;
import com.yolo.service.chat.MessageServiceInf;

@RequestMapping(value = "/chat")
@Controller
public class ChatController {
	
	@Resource
	private ChatNameServiceInf chatNameService;
	
	@Resource
	private MessageServiceInf messageService;
	
	@Resource
	private ChatGroupServiceInf chatGroupService;
	
	@Resource
	private FileAddServiceInf fileAddService;
	
	/**
	 * Method : chatMain 
	 * 최초작성일 : 2018. 6. 25. 
	 * 작성자 : Jun 
	 * 변경이력 :
	 * 
	 * @param chatGroupVO 채팅방 아이디 및 멤버아이디
	 * @return Method 설명 : 채팅방 기본
	 */
	@RequestMapping(value = "/main")
	public String chatMain(Chat_groupVO chatGroupVO, Model model, HttpSession session) {
		if (session.getAttribute("memberVO") != null) {
			String mem_id_session = ((MemberVO) session.getAttribute("memberVO")).getMem_id();
			String mem_id_request = chatGroupVO.getMem_id();
			if (mem_id_session.equals(mem_id_request)) {
				int chat_seq = chatGroupVO.getChat_seq();
				Chat_nameVO chatNameVO = new Chat_nameVO();
				chatNameVO.setChat_seq(chat_seq);
				chatNameVO.setMem_id(mem_id_request);

				Chat_nameVO resultChatNameVO = chatNameService.selectChatName(chatNameVO);
				if (resultChatNameVO == null) {
					return "redirect:/main";
				}
				
				//채팅방 참여자 목록 조회
				List<FriendMemberVO> resultChatGroupVOList = chatGroupService.selectChattingRoomMemberAndFriend(chatGroupVO).get("chattingRoomMemberList");
				model.addAttribute("chatGroupVOs", resultChatGroupVOList);
				
				//읽지않은 메세지 조회
				List<MessageVO> notReadMessageList = messageService.selectNotReadMessage(chatNameVO);
				session.setAttribute("chatNameVO", resultChatNameVO);
				model.addAttribute("notReadMessageList", notReadMessageList);
				return "chatMain";
			}
		}
		return "redirect:/main";
	}
	
	
	/**
	 * Method : sendMessage
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param parameterMap
	 * @param model
	 * @return
	 * Method 설명 : 채팅 전송시 DB에 저장하는 메서드
	 */
	@RequestMapping("/sendMessage")
	@ResponseBody
	public MessageVO sendMessage(@RequestBody Map<String, String> parameterMap){
		if (parameterMap != null) {
			MessageVO messageVO = new MessageVO();
			messageVO.setChat_seq(Integer.valueOf(parameterMap.get("chat_seq")));
			messageVO.setMessage_content(parameterMap.get("message_content"));
			messageVO.setMessage_mem_id(parameterMap.get("message_mem_id"));
			messageVO.setMessage_sort(parameterMap.get("message_sort"));
			
			String message_dt = getMessage_dt();
			messageVO.setMessage_dt(message_dt);
			int result = messageService.sendMessage(messageVO);
			if (result == 1) {
				return messageVO;
			}
		}
		return null;
	}
	
	/**
	 * Method : disconnect
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatGroupVO
	 * Method 설명 : 채팅방에서 나간경우 나간시간 업데이트
	 */
	@RequestMapping("/disconnect")
	public void disconnect(Chat_groupVO chatGroupVO) {
		chatGroupService.updateMem_outtm(chatGroupVO);
	}
	
	/**
	 * Method : selectBeforeMessage
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param messageVO
	 * @return List<MessageVO> json타입
	 * Method 설명 : 이전 메세지 최대 10건 조회
	 */
	@RequestMapping("/selectBeforeMessage")
	@ResponseBody
	public List<MessageVO> selectBeforeMessage(@RequestBody Map<String, String> parameterMap) {
		MessageVO messageVO = new MessageVO();
		messageVO.setChat_seq(Integer.valueOf(parameterMap.get("chat_seq")));
		messageVO.setMessage_seq(Integer.valueOf(parameterMap.get("message_seq")));
		
		List<MessageVO> messageList = messageService.selectBeforeMessage(messageVO);
		
		return messageList;
	}
	
	/**
	 * Method : imageUpload
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param multipartFile
	 * @param session
	 * @return
	 * Method 설명 : 이미지 업로드
	 */
	@RequestMapping("/imageUpload")
	@ResponseBody
	public MessageVO imageUpload(@RequestPart("file") MultipartFile multipartFile, HttpSession session){
		String mem_id = ((MemberVO)session.getAttribute("memberVO")).getMem_id();
		int chat_seq = ((Chat_nameVO)session.getAttribute("chatNameVO")).getChat_seq();
		String message_dt = getMessage_dt();
		
		MessageVO messageVO = new MessageVO();
		messageVO.setMessage_mem_id(mem_id);
		messageVO.setChat_seq(chat_seq);
		messageVO.setMessage_dt(message_dt);
		
		return messageService.imageUpload(multipartFile, messageVO);
	}
	
	
	private String getMessage_dt(){
		//날짜 생성
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int monthInt = cal.get(Calendar.MONTH) + 1;
		String month = (monthInt < 10) ? "0"+monthInt : ""+monthInt;
		int dayInt = cal.get(Calendar.DAY_OF_MONTH);
		String day = (dayInt < 10) ? "0"+dayInt : ""+dayInt;
		int ampmInt = cal.get(Calendar.AM_PM);
		String ampm = (ampmInt == 0) ? "오전" : "오후";
		int hourInt = cal.get(Calendar.HOUR);
		String hour = (hourInt < 10) ? "0"+hourInt : ""+hourInt;
		int minuteInt = cal.get(Calendar.MINUTE);
		String minute = (minuteInt < 10) ? "0"+minuteInt : ""+minuteInt;
		
		StringBuilder sb = new StringBuilder();
		sb.append(year);
		sb.append(month);
		sb.append(day);
		sb.append(",");
		sb.append(ampm);
		sb.append(" ");
		sb.append(hour);
		sb.append(":");
		sb.append(minute);
		
		return sb.toString();
	}
}
