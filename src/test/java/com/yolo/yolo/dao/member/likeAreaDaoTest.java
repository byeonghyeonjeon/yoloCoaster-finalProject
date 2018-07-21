package com.yolo.yolo.dao.member;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.member.inf.AreaDaoInf;
import com.yolo.dao.member.inf.LikeAreaDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.AreaVO;
import com.yolo.model.Like_areaVO;

public class likeAreaDaoTest extends TestInit{
	
	@Resource
	LikeAreaDaoInf dao;

	@Resource
	AreaDaoInf areaDao;
	@Test
	public void insertLikeAreaTest() {
		/**Given**/
		Like_areaVO laVO =  new Like_areaVO();
		laVO.setMem_id("a001");
		laVO.setArea_code("1");

		/**When**/
		int a = dao.insertLikeArea(laVO);

		/**then**/
		assertEquals(1, a);

	}
	
	/**
	 * 
	 * Method : selectArea
	 * 최초작성일 : 2018. 7. 1.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 지역 코드 넣으면 이름 가져오는지
	 */
	@Test
	public void selectArea() throws Exception {
		String areaCode = "1";
		
		AreaVO areaVo = areaDao.selectArea(areaCode);
		String res = areaVo.getAreaname();
		assertEquals("서울", res);
		
	}
	
	/**
	 * 
	 * Method : selectAreaListTest
	 * 최초작성일 : 2018. 7. 1.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : input : String List output : areaName List
	 */
	@Test
	public void selectAreaListTest() throws Exception {
		List<String> inputList =new ArrayList<String>();
		inputList.add("1");
		inputList.add("2");
		inputList.add("3");
		
		List<String> resList = new ArrayList<String>();
		for (int i = 0; i < inputList.size(); i++) {
			AreaVO areaVo = areaDao.selectArea(inputList.get(i));
			resList.add(areaVo.getAreaname());
		}
		
		
		assertEquals("서울", resList.get(0));
		assertEquals("인천", resList.get(1));
		assertEquals("대전", resList.get(2));
	}

}
