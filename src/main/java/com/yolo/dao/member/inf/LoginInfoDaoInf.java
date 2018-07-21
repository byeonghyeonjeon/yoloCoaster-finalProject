package com.yolo.dao.member.inf;

import com.yolo.model.MemberVO;

public interface LoginInfoDaoInf {
	public MemberVO getMemberLogin(MemberVO memVO);

	public int logout(String mem_id);
}
