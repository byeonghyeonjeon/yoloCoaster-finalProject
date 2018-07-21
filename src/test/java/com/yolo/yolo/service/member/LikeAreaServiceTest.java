package com.yolo.yolo.service.member;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.init.TestInit;
import com.yolo.model.Like_areaVO;
import com.yolo.service.member.LikeAreaServiceInf;

public class LikeAreaServiceTest extends TestInit{

	@Resource
	LikeAreaServiceInf service;

	@Test
	public void insertLikeAreaTest() {
		/**Given**/
		Like_areaVO laVO =  new Like_areaVO();
		laVO.setMem_id("a001");
		laVO.setArea_code("1");

		/**When**/
		int a = service.insertLikeArea(laVO);

		/**then**/
		assertEquals(1, a);

	}

}
