package com.yolo.dao.member.inf;

import com.yolo.model.JoininfoVO;

public interface JoinInfoDaoInf {
	
	public int idCheck(String mem_id);
	
	int insertMemberJoinInfo(JoininfoVO joininfoVO);
	
}
