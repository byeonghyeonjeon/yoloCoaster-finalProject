package com.yolo.yolo.dao.login;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.login.inf.FindInfoDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.MemberVO;

public class FindInfoDaoTest extends TestInit{
	
	@Resource
	FindInfoDaoInf findInfoDao;

	@Test
	public void getMemberId() {
		/**Given**/
		MemberVO memVO = new MemberVO();
		memVO.setMem_name("박선영");
		memVO.setMem_mail("dmsgktnekfl@naver.com");

		/**When**/
		List<String> idList = findInfoDao.getMemIdList(memVO);

		/**then**/
		assertNotNull(idList);
		System.out.println(idList);

	}

}
