package com.yolo.dao.member;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.member.inf.JoinInfoDaoInf;
import com.yolo.model.JoininfoVO;
@Repository
public class JoinInfoDao implements JoinInfoDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int idCheck(String mem_id) {
		return sessionTemplate.selectOne("member.idCheck", mem_id);
	}
	
	@Override
	public int insertMemberJoinInfo(JoininfoVO joininfoVO){
		return sessionTemplate.insert("login.insertMemberJoinInfo", joininfoVO);
	}

	
	
}
