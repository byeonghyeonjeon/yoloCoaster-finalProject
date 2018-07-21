package com.yolo.dao.member;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.member.inf.LoginInfoDaoInf;
import com.yolo.model.MemberVO;
@Repository
public class LoginInfoDao implements LoginInfoDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public MemberVO getMemberLogin(MemberVO memVO) {
		return sessionTemplate.selectOne("login.getMemberLogin", memVO);
	}

	@Override
	public int logout(String mem_id) {
		return sessionTemplate.update("login.logout", mem_id);
	}
	
}
