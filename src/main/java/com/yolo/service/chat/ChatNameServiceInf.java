package com.yolo.service.chat;

import java.util.List;

import com.yolo.model.Chat_nameVO;
import com.yolo.model.ChattingRoomVO;

public interface ChatNameServiceInf {
	/**
	 * Method : selectChattingRoomList
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 채팅방 목록 조회
	 */
	List<ChattingRoomVO> selectChattingRoomList(String mem_id);
	
	/**
	 * Method : updateChattingRoom
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatNameVO
	 * @return
	 * Method 설명 : 채팅방 이름 변경
	 */
	int updateChattingRoom(Chat_nameVO chatNameVO);
	
	/**
	 * Method : deleteChattingRoom
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param chat_seq
	 * @return
	 * Method 설명 : 채팅방 나가기 (채팅방이름 및 참여자목록에서 삭제)
	 */
	int deleteChattingRoom(String mem_id, String chat_seq);
	
	/**
	 * Method : selectChatName
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatNameVO
	 * @return
	 * Method 설명 : 채팅방 접속시 채팅방 이름 조회 및 체크
	 */
	Chat_nameVO selectChatName(Chat_nameVO chatNameVO);
}
