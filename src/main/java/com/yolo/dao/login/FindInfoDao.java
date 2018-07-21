package com.yolo.dao.login;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yolo.dao.login.inf.FindInfoDaoInf;
import com.yolo.model.MemberVO;
@Repository
public class FindInfoDao implements FindInfoDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;

	@Override
	public int findMemId(MemberVO memVO) {
		// 해당 회원 아이디 개수 받아오기
		return sessionTemplate.update("login.findMemId", memVO);
	}
	
	@Override
	public int findMemPass(MemberVO memVO) {
		// 해당 회원 난수추가
		return sessionTemplate.update("login.findMemPass", memVO);
	}
	
	@Override
	public int resetMemberPass(MemberVO memVO) {
		// 회원 비밀번호 변경
		return sessionTemplate.update("login.resetMemberPass", memVO);
	}
	
	@Override
	public List<String> getjoinCertify(MemberVO memVO) {
		// 회원 인증번호 받아오기
		return sessionTemplate.selectList("login.getjoinCertify", memVO);
	}
	
	@Override
	public String getPassCertify(MemberVO memVO) {
		// 해당 회원 비밀번호 인증번호 받기
		return sessionTemplate.selectOne("login.getPassCertify", memVO);
	}
	
	@Override
	public List<String> getMemIdList(MemberVO memVO) {
		// 회원 아이디 리스트 받아오기
		return sessionTemplate.selectList("login.getMemIdList", memVO);
	}
	

}
