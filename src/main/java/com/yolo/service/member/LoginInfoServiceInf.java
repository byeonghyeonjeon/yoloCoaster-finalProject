package com.yolo.service.member;

import com.yolo.model.MemberVO;

public interface LoginInfoServiceInf {
	public MemberVO getMemberLogin(MemberVO memVO);

	int logout(String mem_id);
}
