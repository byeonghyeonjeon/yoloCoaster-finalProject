package com.yolo.yolo.dao.basicInfo;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.basicInfo.inf.BasicInfoDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.BasicinfoVO;

public class BasicInfoDaoTest extends TestInit{
	
	@Resource
	BasicInfoDaoInf infoDao;

	@Test
	public void daoTest() {
		assertNotNull(infoDao);
	}
	
	@Test
	public void getBasicInfoTest(){
		
//		BasicinfoVO basicinfoVO = new BasicinfoVO();
//		basicinfoVO.setContentid("123");
		
		BasicinfoVO resu = infoDao.getBasicInfo("123");
		
		assertNotNull(resu);
		
	}
	

}
