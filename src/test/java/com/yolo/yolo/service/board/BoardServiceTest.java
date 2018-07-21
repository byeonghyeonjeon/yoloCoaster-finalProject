package com.yolo.yolo.service.board;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.junit.Test;
import org.slf4j.Logger;

import com.yolo.init.TestInit;
import com.yolo.model.PboardVO;
import com.yolo.service.board.BoardServiceInf;

public class BoardServiceTest extends TestInit {

	@Resource
	BoardServiceInf service;

	@Test
	public void createServiceTest() throws Exception {
		assertNotNull(service);
		
	}
	
	@Test
	public void getListTest() throws Exception {

		int res = service.selectBoardCnt(2);
		assertNotNull(res);
		assertEquals(129, res);
	}
}
