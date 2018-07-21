package com.yolo.dao.member;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.member.inf.MemberDaoInf;
import com.yolo.model.MemberVO;
@Repository
public class MemberDao implements MemberDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	public MemberDao() {
		
	}

	
	/**
	 * 
	 * Method : getMemberLogin
	 * 최초작성일 : 2018. 6. 16.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param member
	 * @return
	 * Method 설명 : 회원 조회 메서드
	 */
	@Override
	public MemberVO getMemberLogin(MemberVO member) {
		logger.debug("{}","before getMemberLogin");
		System.out.println("ddd");
		MemberVO res = sessionTemplate.selectOne("login.getMemberLogin",member);
	
		logger.debug("{},{}","after getMemberLogin",member.getMem_id());
		return res;
	}

	@Override
	public MemberVO selectMemberInfo(MemberVO member) {
		logger.debug("{},{}","before selectMemberInfo",member.getMem_id());
		MemberVO res = sessionTemplate.selectOne("member.selectMemberInfo",member);
		logger.debug("{}",res.toString());
		return res;
	}


	@Override
	public int checkMemPass(MemberVO member) {
		logger.debug("{},{}","before selectMemberInfo",member.getMem_id());
		int res = sessionTemplate.selectOne("member.checkMemPass",member);
		logger.debug("{}",res);
		return res;
	}


	@Override
	public int updateMemberInfo(MemberVO member) {
		logger.debug("{},{}","before updateMemberInfo MemberVO",member);
		int res = sessionTemplate.update("member.updateMemberInfo",member);
		logger.debug("{}",res);
		return res;
	}


	@Override
	public int updateMemeberSt(String mem_id) {
		int res = sessionTemplate.update("member.updateMemeberSt",mem_id);
		logger.debug("{}",res);
		return res;
	}
	
	

	
	
}
