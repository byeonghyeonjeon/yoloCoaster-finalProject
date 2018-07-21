package com.yolo.yolo.dao.login;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.login.inf.LoginDaoInf;
import com.yolo.init.TestInit;

public class LoginDaoTest extends TestInit{
	
	@Resource
	LoginDaoInf loginDao;

	@Test
	public void insertLoginInfoTest() {
		/**Given**/
		String mem_id = "a001"; 

		/**When**/
		int result = loginDao.insertLoginInfo(mem_id);
		

		/**then**/
		assertNotNull(loginDao);
		assertEquals(1, result);

	}

}
