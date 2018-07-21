package com.yolo.service.login;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yolo.dao.login.inf.LoginDaoInf;

@Service
public class LoginService implements LoginServiceInf{
	
	@Resource
	LoginDaoInf loginDao;

	@Override
	public int insertLoginInfo(String mem_id) {
		return loginDao.insertLoginInfo(mem_id);
	}

}
