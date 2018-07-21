package com.yolo.yolo.service.member;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.init.TestInit;
import com.yolo.model.MemberVO;
import com.yolo.service.member.LoginInfoServiceInf;

public class LoginInfoServiceTest extends TestInit{
	
	@Resource
	LoginInfoServiceInf loginInfoService;

	@Test
	public void getMemberLoginTest() {
		/**Given**/
		MemberVO userinfo = new MemberVO();
		userinfo.setMem_id("a001");
		userinfo.setMem_pass("1234");

		/**When**/
		MemberVO resultVO = null;
		resultVO = loginInfoService.getMemberLogin(userinfo);

		/**then**/
		assertNotNull(resultVO);
		assertEquals(userinfo.getMem_id(), resultVO.getMem_id());
		System.out.println("resultVO : " + resultVO.toString());

	}

}
