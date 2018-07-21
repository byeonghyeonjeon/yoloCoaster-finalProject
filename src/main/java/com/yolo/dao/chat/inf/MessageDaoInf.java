package com.yolo.dao.chat.inf;

import java.util.List;
import java.util.Map;

import com.yolo.model.Chat_nameVO;
import com.yolo.model.MessageVO;

public interface MessageDaoInf {
	/**
	 * Method : sendMessage
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param messageVO
	 * @return
	 * Method 설명 : 메세지 DB에 저장
	 */
	int sendMessage(MessageVO messageVO);
	
	/**
	 * Method : selectNotReadMessage
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatNameVO
	 * @return
	 * Method 설명 : 안읽은 메세지 조회
	 */
	List<MessageVO> selectNotReadMessage(Chat_nameVO chatNameVO);
	
	/**
	 * Method : selectBeforeMessage
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param messageVO
	 * @return
	 * Method 설명 : 과거메세지 최대 10건 조회
	 */
	List<MessageVO> selectBeforeMessage(MessageVO messageVO);
	
	/**
	 * Method : selectImgCount
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatNameVO
	 * @return
	 * Method 설명 : 채팅방내의 사진 총 개수 조회
	 */
	int selectImgCount(Chat_nameVO chatNameVO);
	
	/**
	 * Method : selectImgPaging
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 채팅방내의 사진첩에 쓰일 메세지 조회
	 */
	List<MessageVO> selectImgPaging(Map<String, Integer> map);
	
}
