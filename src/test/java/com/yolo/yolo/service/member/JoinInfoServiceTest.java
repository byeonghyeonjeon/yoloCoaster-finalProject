package com.yolo.yolo.service.member;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.init.TestInit;
import com.yolo.service.member.JoinInfoServiceInf;

public class JoinInfoServiceTest extends TestInit{

	@Resource
	JoinInfoServiceInf joinInfoService;
	
	@Test
	public void createServiceTest() throws Exception {
		assertNotNull(joinInfoService);
	}
	
	@Test
	public void idChackTest(){
		/**Given**/
		String mem_id = "test";

		/**When**/
		int a = joinInfoService.idCheck(mem_id);

		/**then**/
		assertEquals(1, a);
		
	}

}
