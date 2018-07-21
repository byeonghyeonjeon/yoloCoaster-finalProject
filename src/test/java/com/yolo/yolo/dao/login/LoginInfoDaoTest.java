package com.yolo.yolo.dao.login;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.member.inf.LoginInfoDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.MemberVO;

public class LoginInfoDaoTest extends TestInit{
	
	@Resource
	LoginInfoDaoInf loginInfoDao;

	@Test
	public void getMemberLoginTest() {
		/**Given**/
		MemberVO userinfo = new MemberVO();
		userinfo.setMem_id("a001");
		userinfo.setMem_pass("1234");

		/**When**/
		MemberVO resultVO = null;
		resultVO = loginInfoDao.getMemberLogin(userinfo);

		/**then**/
		assertNotNull(resultVO);
		assertEquals(userinfo.getMem_id(), resultVO.getMem_id());
		System.out.println("resultVO : " + resultVO.toString());
	}

}
