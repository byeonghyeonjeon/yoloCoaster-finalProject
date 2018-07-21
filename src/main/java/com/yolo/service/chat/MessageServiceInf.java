package com.yolo.service.chat;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.yolo.model.Chat_nameVO;
import com.yolo.model.MessageVO;

public interface MessageServiceInf {
	
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
	 * Method : imageUpload
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param multipartFile
	 * @param messageVO
	 * @return
	 * Method 설명 : 이미지 업로드
	 */
	MessageVO imageUpload(MultipartFile multipartFile, MessageVO messageVO);
	
	/**
	 * Method : selectImgList
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param pageNum
	 * @param chatNameVO
	 * @return
	 * Method 설명 : 사진첩 페이지네이션
	 */
	Map<String, Object> selectImgList(int pageNum, Chat_nameVO chatNameVO);
}
