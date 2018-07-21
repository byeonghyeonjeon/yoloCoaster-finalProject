package com.yolo.dao.login.inf;

import java.util.List;

import com.yolo.model.MemberVO;

public interface FindInfoDaoInf {
	
	int findMemId(MemberVO memVO);
	
	List<String> getjoinCertify(MemberVO memVO);  
	
	List<String> getMemIdList(MemberVO memVO);

	int findMemPass(MemberVO memVO);

	int resetMemberPass(MemberVO memVO);

	String getPassCertify(MemberVO memVO);
	
	
}
