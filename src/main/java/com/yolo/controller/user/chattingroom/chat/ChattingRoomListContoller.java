package com.yolo.controller.user.chattingroom.chat;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yolo.model.Chat_nameVO;
import com.yolo.model.ChattingRoomVO;
import com.yolo.service.chat.ChatNameServiceInf;
					
@RequestMapping(value="/chat")					
@Controller
public class ChattingRoomListContoller {
	
	@Resource
	private ChatNameServiceInf chatNameService;
	
	/**
	 * Method : chatMain
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param model
	 * @return
	 * Method 설명 : 해당 유저의 채팅방 목록 조회
	 */
	@RequestMapping(value="/chattingroomlist")
	public String chatMain(@RequestParam String mem_id, Model model){
		List<ChattingRoomVO> chattingRoomList = chatNameService.selectChattingRoomList(mem_id);
		model.addAttribute("chattingRoomList", chattingRoomList);
		return "chattingRoomList";
	}
	
	
	/**
	 * Method : updateChattingRoom
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param parameterMap {chat_seq, mem_id, name}
	 * @return
	 * Method 설명 : 채팅방 이름 변경
	 */
	@RequestMapping(value="/chattingroomlist/update")
	@ResponseBody
	public String updateChattingRoom(@RequestBody Map<String, String> parameterMap){
		int chat_seq = Integer.valueOf(parameterMap.get("chat_seq"));
		String mem_id = parameterMap.get("mem_id");
		String name = parameterMap.get("name");
		
		Chat_nameVO chatNameVO = new Chat_nameVO(0, chat_seq, name, mem_id);
		int result = chatNameService.updateChattingRoom(chatNameVO);
		if (result == 1) {
			return "Y";
		} else {
			return "N";
		}
	}
	
	
	
	@RequestMapping(value="/chattingroomlist/delete")
	public String deleteChattingRoom(String mem_id, String chat_seq){
		chatNameService.deleteChattingRoom(mem_id, chat_seq);
		return "redirect:/chat/chattingroomlist?mem_id="+mem_id;
	}
}
