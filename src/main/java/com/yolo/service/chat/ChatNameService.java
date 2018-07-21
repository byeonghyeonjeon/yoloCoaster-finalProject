package com.yolo.service.chat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yolo.dao.chat.inf.ChatGroupDaoInf;
import com.yolo.dao.chat.inf.ChatNameDaoInf;
import com.yolo.model.Chat_nameVO;
import com.yolo.model.ChattingRoomVO;

@Service
public class ChatNameService implements ChatNameServiceInf{
	
	@Resource
	private ChatNameDaoInf chatNameDao;
	
	@Resource
	private ChatGroupDaoInf chatGroupDao;
	
	@Override
	public List<ChattingRoomVO> selectChattingRoomList(String mem_id) {
		//해당 유저의 모든 채팅방 목록
		List<ChattingRoomVO> chattingRoomList = chatNameDao.selectChattingRoomList(mem_id);
		
		//해당 유저의 메세지가 있는 채팅방 목록
		List<ChattingRoomVO> chattingRoomListByMsg= chatNameDao.selectChattingRoomListByMessage(mem_id);
		
		//모든 채팅방 목록 초기화
		for (ChattingRoomVO chattingRoomVO : chattingRoomList) {
			for (ChattingRoomVO chattingRoomVOByMsg : chattingRoomListByMsg) {
				if (chattingRoomVO.getChat_seq() == chattingRoomVOByMsg.getChat_seq()) {
					chattingRoomVO.setMessageCount(chattingRoomVOByMsg.getMessageCount());
				}
			}
		}
		
		return chattingRoomList;
	}

	@Override
	public int updateChattingRoom(Chat_nameVO chatNameVO) {
		int result =  chatNameDao.updateChattingRoom(chatNameVO);
		if(result != 1)
			new Exception("채팅방 이름 업데이트가 안됨");
		return result;
	}

	@Override
	public int deleteChattingRoom(String mem_id, String chat_seq) {
		Map<String, String> map = new HashMap<>();
		map.put("mem_id", mem_id);
		map.put("chat_seq", chat_seq);
		
		int result1 = chatNameDao.deleteChattingRoom(map);
		if (result1 != 1)
			new Exception("채팅방이름 삭제 에러");
		
		int result2 = chatGroupDao.deleteChattingRoom(map);
		if (result2 != 1)
			new Exception("참여자목록 삭제 에러");
		
		return result1+result2;
	}

	@Override
	public Chat_nameVO selectChatName(Chat_nameVO chatNameVO) {
		return chatNameDao.selectChatName(chatNameVO);
	}

}
