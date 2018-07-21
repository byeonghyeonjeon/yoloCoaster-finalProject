package com.yolo.yolo.dao.board;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yolo.dao.board.inf.BoardDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.PageVO;
import com.yolo.model.PboardVO;

public class BoardDaoTest extends TestInit{

	Logger loger = LoggerFactory.getLogger(getClass());
	
	@Resource
	BoardDaoInf dao;
	
	@Test
	public void createDaoTest() {
		assertNotNull(dao);
	}
	
	@Test
	public void selectBoardCntTest() throws Exception {
	
		int res = dao.selectBoardCnt(2);
		loger.debug("{}",res);
		assertNotNull(res);
		assertEquals(129, res);
	}

	@Test
	public void boardDeleteTest() throws Exception {
		String link = "173";
		int res = dao.deleteBoard(link);
		assertEquals(1, res);
	}
	
	@Test
	public void keywordTest() throws Exception {
		int ex = 129;
		int res = dao.selectBoardCnt(2, "질문");
		assertEquals(ex, res);
	}
	
	@Test
	public void keywordPageTest() throws Exception {
		int ex = 10;
		PageVO page = new PageVO();
		page.setPboard_seq(2);
		page.setPageNo(1);
		int res = dao.getboardList(page, "질문").size();
		assertEquals(ex, res);
	}
	
	@Test
	public void boardDataDeleteTest() throws Exception {
		int res = dao.deleteDataBoard(2);
		assertEquals(1, res);
	}
}
