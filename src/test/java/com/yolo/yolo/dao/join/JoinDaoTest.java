package com.yolo.yolo.dao.join;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.join.Inf.JoinDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.MemberVO;

public class JoinDaoTest extends TestInit{
	
	@Resource
	JoinDaoInf joinDao;

	@Test
	public void insertMemberTest() {
		/**Given**/
		MemberVO memVO = new MemberVO();
		memVO.setMem_id("joindao");
		memVO.setMem_pass("1234");
		memVO.setMem_mail("adfw@naod.com");
		memVO.setMem_name("황금독수리");

		/**When**/
		int a = joinDao.insertMember(memVO);

		/**then**/
		assertEquals(1, a);

	}

}
