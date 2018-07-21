package com.yolo.service.join;

import java.util.ArrayList;

import com.yolo.model.MemberVO;

public interface JoinServiceInf {
	public int insertMember(MemberVO memVO, ArrayList<String> like_area, String join_path);
}
