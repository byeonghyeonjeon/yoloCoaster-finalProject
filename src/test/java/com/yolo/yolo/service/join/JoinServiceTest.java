package com.yolo.yolo.service.join;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.join.Inf.JoinDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.Like_areaVO;
import com.yolo.model.MemberVO;
import com.yolo.service.join.JoinServiceInf;

public class JoinServiceTest extends TestInit{

	@Resource
	JoinServiceInf joinService;

	@Test
	public void insertMemberTest() {
		/**Given**/
		MemberVO memVO = new MemberVO();
		memVO.setMem_id("joinService");
		memVO.setMem_pass("1234");
		memVO.setMem_mail("adfw@naod.com");
		memVO.setMem_name("황금독수리");
		
		ArrayList<String> like_area = new ArrayList<String>();
		String join_path = "01";

		/**When**/
		int a = joinService.insertMember(memVO, like_area, join_path);

		/**then**/
		assertEquals(1, a);

	}

}
