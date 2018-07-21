package com.yolo.service.chat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yolo.dao.chat.inf.ChatGroupDaoInf;
import com.yolo.model.Chat_groupVO;
import com.yolo.model.Chat_nameVO;
import com.yolo.model.FriendMemberVO;

@Service
public class ChatGroupService implements ChatGroupServiceInf{
	@Resource
	private ChatGroupDaoInf chatGroupDao;
	
	@Override
	public int updateMem_outtm(Chat_groupVO chatGroupVO) {
		return chatGroupDao.updateMem_outtm(chatGroupVO);
	}

	@Override
	public Map<String, List<FriendMemberVO>> selectChattingRoomMemberAndFriend(Chat_groupVO chatGroupVO) {
		List<FriendMemberVO> chattingRoomMemberList = null;
		List<FriendMemberVO> chattingRoomFriendList = null;
		
		chattingRoomMemberList = chatGroupDao.selectChattingRoomMember(chatGroupVO);
		chattingRoomFriendList = chatGroupDao.selectFriendNotInChattingRoom(chatGroupVO);
		
		Map<String, List<FriendMemberVO>> resultMap = new HashMap<String, List<FriendMemberVO>>();
		resultMap.put("chattingRoomMemberList", chattingRoomMemberList);
		resultMap.put("chattingRoomFriendList", chattingRoomFriendList);
		return resultMap;
	}

	@Override
	public int inviteChat(Chat_groupVO chatGroupVO) {
		chatGroupDao.inviteChat_group(chatGroupVO);
		List<FriendMemberVO> list = chatGroupDao.selectChattingRoomMember(chatGroupVO);
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < list.size(); i++) {
			FriendMemberVO friendMemberVO = list.get(i);
			if (i != 0)
				sb.append(",");
			sb.append(friendMemberVO.getMem_id());
		}
		sb.append("]");
		Chat_nameVO chatNameVO = new Chat_nameVO();
		chatNameVO.setMem_id(chatGroupVO.getMem_id());
		chatNameVO.setChat_seq(chatGroupVO.getChat_seq());
		chatNameVO.setName(sb.toString());
		return chatGroupDao.inviteChat_name(chatNameVO);
	}
	

}
