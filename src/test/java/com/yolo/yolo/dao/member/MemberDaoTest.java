package com.yolo.yolo.dao.member;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yolo.dao.member.inf.JoinInfoDaoInf;
import com.yolo.dao.member.inf.MemberDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.MemberVO;

/**
 * 
 * MemberDaoTest.java
 *
 * @author Brown
 * @since 2018. 6. 16.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 16. Brown 최초 생성
 *
 * </pre>
 */
public class MemberDaoTest extends TestInit{

	Logger loger = LoggerFactory.getLogger(getClass());
	
	@Resource
	MemberDaoInf memberDao;
	
	@Test
	public void createDaoTest() throws Exception {
		assertNotNull(memberDao);
	}
	
	@Test
	public void memberStUpdateTest() throws Exception {
		String mem_id = "test";
		int res = memberDao.updateMemeberSt(mem_id);
		assertEquals(1, res);
	}
	
	
	/**
	 * 
	 * Method : test
	 * 최초작성일 : 2018. 6. 16.
	 * 작성자 : Brown
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Test
	public void dataAccessTest() {
		MemberVO member = new MemberVO();
		member.setMem_id("test");
		member.setMem_pass("123");
		
		MemberVO res = 	memberDao.getMemberLogin(member);
		String name = res.getMem_name();
		assertEquals("테스트", name);
	}
	
	@Test
	public void memberPasswordTest() throws Exception {
		MemberVO member = new MemberVO();
		member.setMem_id("test");
		member.setMem_pass("123");
		
		//아이디 비밀번호 맞는지 확인
		//맞으면 1 아니면 0
		int res = memberDao.checkMemPass(member);
		//아닌값 넣기
		assertEquals(1, res);
	}

}
