package com.yolo.yolo.dao.member;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.member.inf.AreaDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.AreaVO;

public class AreaTest extends TestInit{

	@Resource
	AreaDaoInf areaDao;
	
	@Test
	public void createTest() {
		assertNotNull(123);
	}
	
	@Test
	public void selectAreaTest() throws Exception {
		AreaVO input = new AreaVO();
		input.setAreacode("2");
		AreaVO resvo = areaDao.selectArea("2");
		int intRes = 1;
		assertEquals("인천", resvo.getAreaname());
	}
	
	@Test
	public void deleteBOokmarkDeleteTest() throws Exception {
		AreaVO input = new AreaVO();
		input.setAreacode("2");
		String resvo = areaDao.selectAreaCode("인천");
		assertEquals("2", resvo);
	}
}
