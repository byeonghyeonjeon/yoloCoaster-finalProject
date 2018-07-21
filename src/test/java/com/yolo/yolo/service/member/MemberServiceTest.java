package com.yolo.yolo.service.member;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yolo.init.TestInit;
import com.yolo.model.MemberVO;
import com.yolo.service.member.MemberServiceInf;
/**
 * 
 * MemberServiceTest.java
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
public class MemberServiceTest extends TestInit{

	@Resource
	MemberServiceInf memberService;
	
	/**
	 * 
	 * Method : createServiceTest
	 * 최초작성일 : 2018. 6. 16.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : service create test
	 */
	@Test
	public void createServiceTest() throws Exception {
		assertNotNull(memberService);
	}
	

	@Test
	public void serviceAccessToDBTest() throws Exception {
		MemberVO member = new MemberVO();
		member.setMem_id("test");
		member.setMem_pass("123");
		MemberVO res= memberService.getMemberLogin(member);
		String resName = res.getMem_name();
		assertEquals("테스트", resName);
	}
	
	@Test
	public void memberPasswordTest() throws Exception {
		MemberVO member = new MemberVO();
		member.setMem_id("test");
		member.setMem_pass("123");
		
		//아이디 비밀번호 맞는지 확인
		//맞으면 1 아니면 0
		int res = memberService.checkMemPass(member);
		//아닌값 넣기
		assertEquals(1, res);
	}
}
