package com.yolo.dao.chat.inf;

import java.util.List;
import java.util.Map;

import com.yolo.model.Chat_nameVO;
import com.yolo.model.ChattingRoomVO;

public interface ChatNameDaoInf {
	
	/**
	 * Method : insertChat_name
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param list 채팅방 아이디와 이름, 멤버아이디를 가짐
	 * @return
	 * Method 설명 : 새로운 채팅방 이름 생성
	 */
	int insertChat_name(List<Chat_nameVO> list);
	
	/**
	 * Method : selectChattingRoomList
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 채팅방 목록 조회(메세지가 없는 경우도 포함)
	 */
	List<ChattingRoomVO> selectChattingRoomList(String mem_id);
	
	/**
	 * Method : selectChattingRoomListByMessage
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 채팅방 목록 조회(메세지가 있는 경우만)
	 */
	List<ChattingRoomVO> selectChattingRoomListByMessage(String mem_id);
	
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
	 * Method 설명 : 채팅방 나가기 (채팅방이름에서 삭제)
	 */
	int deleteChattingRoom(Map<String, String> map);
	
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
