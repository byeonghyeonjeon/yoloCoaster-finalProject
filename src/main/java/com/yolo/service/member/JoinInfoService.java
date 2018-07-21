package com.yolo.service.member;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yolo.dao.member.inf.JoinInfoDaoInf;
import com.yolo.model.JoininfoVO;

@Service
public class JoinInfoService implements JoinInfoServiceInf{
	
	@Resource
	JoinInfoDaoInf joinInfoDao;

	@Override
	public int idCheck(String mem_id) {
		return joinInfoDao.idCheck(mem_id);
	}
	
}
