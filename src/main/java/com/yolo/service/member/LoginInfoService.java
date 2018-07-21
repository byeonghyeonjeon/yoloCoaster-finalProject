package com.yolo.service.member;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yolo.dao.member.inf.LoginInfoDaoInf;
import com.yolo.model.MemberVO;


@Service
public class LoginInfoService implements LoginInfoServiceInf{
	
	@Resource
	LoginInfoDaoInf loginInfoDao; 

	@Override
	public MemberVO getMemberLogin(MemberVO memVO) {
		return loginInfoDao.getMemberLogin(memVO);
	}
	
	@Override
	public int logout(String mem_id){
		return loginInfoDao.logout(mem_id);
	}

}
