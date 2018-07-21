package com.yolo.service.login;

import java.util.List;

import com.yolo.model.EmailVO;
import com.yolo.model.MemberVO;

public interface FindInfoServiceInf {
	
	int findMemId(MemberVO memVO);
	
	List<String> getjoinCertify(MemberVO memVO);  
	
	List<String> getMemIdList(MemberVO memVO);  
	
	boolean sendMail(EmailVO mailVO);
	
	int findMemPass(MemberVO memVO);

	int resetMemberPass(MemberVO memVO);
	
	String getPassCertify(MemberVO memVO);

}
