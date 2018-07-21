package com.yolo.dao.chat;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.chat.inf.ChatNameDaoInf;
import com.yolo.model.Chat_nameVO;
import com.yolo.model.ChattingRoomVO;
@Repository
public class ChatNameDao implements ChatNameDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Method : insertChat_name
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param list
	 * @return
	 * Method 설명 : 채팅방 생성시 이름 추가
	 */
	@Override
	public int insertChat_name(List<Chat_nameVO> list) {
		return sessionTemplate.insert("chatName.insertChat_name", list);
	}
	
	/**
	 * Method : selectChattingRoomList
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 채팅방 목록 조회(메세지가 없는 경우도 포함)
	 */
	@Override
	public List<ChattingRoomVO> selectChattingRoomList(String mem_id) {
		return sessionTemplate.selectList("chatName.selectChattingRoomList", mem_id);
	}
	
	/**
	 * Method : selectChattingRoomListByMessage
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 채팅방 목록 조회(메세지가 있는 경우만)
	 */
	@Override
	public List<ChattingRoomVO> selectChattingRoomListByMessage(String mem_id) {
		return sessionTemplate.selectList("chatName.selectChattingRoomListByMessage", mem_id);
	}

	/**
	 * Method : updateChattingRoom
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatNameVO
	 * @return
	 * Method 설명 : 채팅방 이름 변경
	 */
	@Override
	public int updateChattingRoom(Chat_nameVO chatNameVO) {
		return sessionTemplate.update("chatName.updateChattingRoom", chatNameVO);
	}
	
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
	@Override
	public int deleteChattingRoom(Map<String, String> map) {
		return sessionTemplate.delete("chatName.deleteChattingRoom", map);
	}
	
	/**
	 * Method : selectChatName
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatNameVO
	 * @return
	 * Method 설명 : 채팅방 접속시 채팅방 이름 조회 및 체크
	 */
	@Override
	public Chat_nameVO selectChatName(Chat_nameVO chatNameVO) {
		return sessionTemplate.selectOne("chatName.selectChatName", chatNameVO);
	}
	
}
