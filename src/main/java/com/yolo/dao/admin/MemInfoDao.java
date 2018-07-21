package com.yolo.dao.admin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.admin.inf.MemInfoDaoInf;
import com.yolo.model.MemJoinInfoVO;

@Repository
public class MemInfoDao implements MemInfoDaoInf{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	
	@Override
	public List<MemJoinInfoVO> getMemberList(Map<String, String>paramMap) {
		//모든 회원 리스트 가져오기(admin 제외)
		return sessionTemplate.selectList("adminMember.getMemberList",paramMap);
	}


	@Override
	public int getMemberListCnt(Map<String, String> paramMap) {
		return sessionTemplate.selectOne("adminMember.getMemberListCnt",paramMap);
	}
	
	
	@Override
	public int todayRegMember() {
		return sessionTemplate.selectOne("adminMember.todayRegMember");
	}


	@Override
	public int todayDropMember() {
		return sessionTemplate.selectOne("adminMember.todayDropMember");
	}


	@Override
	public int blackList(Map<String, String> paramMap) {
		return sessionTemplate.update("adminMember.todayDropMember",paramMap);
	}


	@Override
	public int selectBlackList(String paramMap) {
		return sessionTemplate.selectOne("adminMember.selectBlackList",paramMap);
	}


	@Override
	public int insertBlackList(String paramMap) {
		return sessionTemplate.insert("adminMember.insertBlackList",paramMap);
	}


	@Override
	public int updateMemSTBlack(Map<String, String> paramMap) {
		return sessionTemplate.update("adminMember.updateMemSTBlack",paramMap);
	}

}
