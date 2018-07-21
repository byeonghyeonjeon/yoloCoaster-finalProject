package com.yolo.dao.board;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.board.inf.ReplyDaoInf;
import com.yolo.model.ReplyVO;
@Repository
public class ReplyDao implements ReplyDaoInf{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int insertReply(ReplyVO reply) {
		int res = 0;
		logger.debug("{},{}","{public int insertReply(ReplyVO reply) ",reply);
		res = sessionTemplate.insert("board.insertReply",reply);
		return res;
	}

	@Override
	public List<ReplyVO> selectReplyList(int link) {
		return sessionTemplate.selectList("board.selectReplyList",link);
	}

	@Override
	public int updateReply(ReplyVO reply) {
		return sessionTemplate.update("board.updateReply", reply);
	}

	@Override
	public int deleteReply(int reply_seq) {
		return sessionTemplate.delete("board.deleteReply", reply_seq);
	}
	
}
