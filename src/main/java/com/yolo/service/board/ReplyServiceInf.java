package com.yolo.service.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.yolo.model.ReplyVO;

public interface ReplyServiceInf {

	/**
	 * 
	 * Method : insertReply
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : brown
	 * 변경이력 :
	 * @param reply
	 * @param session 
	 * @return
	 * Method 설명 : 댓글등록
	 */
	int insertReply(ReplyVO reply, HttpSession session);

	/**
	 * 
	 * Method : selectReplyList
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param link_int
	 * @return
	 * Method 설명 : 댓글가져오기
	 */
	List<ReplyVO> selectReplyList(int link_int);
	
	/**
	 * Method : updateReply
	 * 최초작성일 : 2018. 7. 14.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param reply
	 * @return
	 * Method 설명 : 댓글 수정
	 */
	int updateReply(ReplyVO reply);
	
	/**
	 * Method : deleteReply
	 * 최초작성일 : 2018. 7. 14.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param reply_seq
	 * @return
	 * Method 설명 : 댓글 삭제
	 */
	int deleteReply(int reply_seq);


}
