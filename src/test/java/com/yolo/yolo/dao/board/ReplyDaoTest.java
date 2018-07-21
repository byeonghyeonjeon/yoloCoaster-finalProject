package com.yolo.yolo.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.board.inf.ReplyDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.ReplyVO;

public class ReplyDaoTest extends TestInit{

	@Resource
	ReplyDaoInf dao;
	
	@Test
	public void createTest() {
		assertNotNull(dao);
	}

	@Test
	public void insertTest() throws Exception {
		ReplyVO reply = new ReplyVO();
		int res = dao.insertReply(reply);
		assertEquals(1, res);
	}
	
//	댓글 조회
	@Test
	public void selectReplyListTest() throws Exception {
		List<ReplyVO> res=dao.selectReplyList(145);
		
		assertEquals(1, res.size());
	}
}
