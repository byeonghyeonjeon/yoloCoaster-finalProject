package com.yolo.yolo.dao.join;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.member.inf.JoinInfoDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.JoininfoVO;

public class JoinInfoDaoTest extends TestInit{
	
	@Resource
	JoinInfoDaoInf joinInfoDao;
	
	@Test
	public void createDaoTest() throws Exception {
		assertNotNull(joinInfoDao);
	}
	
	@Test
	public void idChackTest(){
		/**Given**/
		String mem_id = "test";

		/**When**/
		int a = joinInfoDao.idCheck(mem_id);

		/**then**/
		assertEquals(1, a);
		
	}
	
	@Test
	public void insertMemberJoinInfo() throws Exception {
		/**Given**/
		JoininfoVO joininfoVO = new JoininfoVO();
		joininfoVO.setMem_id("sk002");

		/**When**/
		int a = joinInfoDao.insertMemberJoinInfo(joininfoVO);

		/**then**/
		assertEquals(1, a);

	}

}
