package com.yolo.dao.login;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yolo.dao.login.inf.LoginDaoInf;

@Repository
public class LoginDao implements LoginDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;

	@Override
	public int insertLoginInfo(String mem_id) {
		return sessionTemplate.insert("member.insertLoginInfo", mem_id);
	}

}
