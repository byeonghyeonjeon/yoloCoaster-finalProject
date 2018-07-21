package com.yolo.dao.join;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yolo.dao.join.Inf.JoinDaoInf;
import com.yolo.model.MemberVO;
@Repository
public class JoinDao implements JoinDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;

	@Override
	public int insertMember(MemberVO memVO) {
		return sessionTemplate.insert("login.insertMember", memVO);
	}
	
	

}
