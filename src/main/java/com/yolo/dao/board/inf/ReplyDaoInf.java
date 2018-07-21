package com.yolo.dao.board.inf;

import java.util.List;

import com.yolo.model.ReplyVO;

public interface ReplyDaoInf {

	/**
	 * 
	 * Method : insertReply
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : brown
	 * 변경이력 :
	 * @param reply
	 * @return
	 * Method 설명 : 리플등록
	 */
	public int insertReply(ReplyVO reply);

	/**
	 * 
	 * Method : selectReplyList
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : brown
	 * 변경이력 :
	 * @param link_int
	 * @return
	 * Method 설명 :댓글 조회
	 */
	public List<ReplyVO> selectReplyList(int link_int);
	
	/**
	 * Method : updateReply
	 * 최초작성일 : 2018. 7. 14.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param reply
	 * @return
	 * Method 설명 : 댓글 수정
	 */
	public int updateReply(ReplyVO reply);
	
	/**
	 * Method : deleteReply
	 * 최초작성일 : 2018. 7. 14.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param reply_seq
	 * @return
	 * Method 설명 : 댓글 삭제
	 */
	public int deleteReply(int reply_seq);

}
