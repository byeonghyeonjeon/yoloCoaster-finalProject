package com.yolo.dao.chat.inf;

import com.yolo.model.ChatVO;

public interface ChatDaoInf {
	
	/**
	 * Method : insertChat
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatVO 상태만 가짐
	 * @return
	 * Method 설명 : 새로운 채팅방 생성
	 */
	int insertChat(ChatVO chatVO);

}
