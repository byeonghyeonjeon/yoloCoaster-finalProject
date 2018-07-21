/**
 * 
 */
package com.yolo.controller.user.chattingroom.group;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yolo.model.Chat_groupVO;
import com.yolo.model.Chat_nameVO;
import com.yolo.model.FriendMemberVO;
import com.yolo.model.MemberVO;
import com.yolo.service.chat.ChatGroupServiceInf;

/**
 * GroupController.java
 *
 * @author Jun
 * @since 2018. 6. 29.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 29. Jun 최초 생성
 *
 * </pre>
 */
@RequestMapping(value="/chatGroup")
@Controller
public class GroupController {
	
	@Resource
	private ChatGroupServiceInf chatGroupService;
	
	/**
	 * Method : chatGroup
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param session
	 * @param model
	 * @return
	 * Method 설명 : 채팅방 내의 친구초대 메인
	 */
	@RequestMapping(value="/main")
	public String chatGroup(HttpSession session, Model model){
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		Chat_nameVO chatNameVO = (Chat_nameVO) session.getAttribute("chatNameVO");
		
		Chat_groupVO chatGroupVO = new Chat_groupVO();
		chatGroupVO.setChat_seq(chatNameVO.getChat_seq());
		chatGroupVO.setMem_id(memberVO.getMem_id());
		
		Map<String, List<FriendMemberVO>> resultMap = chatGroupService.selectChattingRoomMemberAndFriend(chatGroupVO);
		
		model.addAttribute("friendList", resultMap.get("chattingRoomFriendList"));
		model.addAttribute("memberList", resultMap.get("chattingRoomMemberList"));
		return "content/user/chattingroom/chatGroup/chatGroupMain";
	}
	
	
	/**
	 * Method : inviteChat
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param parameterMap (mem_id)
	 * @return
	 * Method 설명 : 해당 채팅방에 친구를 초대함
	 */
	@RequestMapping(value="/inviteChat")
	public String inviteChat(@RequestBody Map<String, String> parameterMap, HttpSession session) {
		Chat_nameVO chatNameVO = (Chat_nameVO)session.getAttribute("chatNameVO");
		int chat_seq = chatNameVO.getChat_seq();
		String mem_id = parameterMap.get("mem_id");
		
		Chat_groupVO chatGroupVO = new Chat_groupVO();
		chatGroupVO.setChat_seq(chat_seq);
		chatGroupVO.setMem_id(mem_id);
		
		chatGroupService.inviteChat(chatGroupVO);
		
		return "redirect:/chatGroup/main";
	}
}
