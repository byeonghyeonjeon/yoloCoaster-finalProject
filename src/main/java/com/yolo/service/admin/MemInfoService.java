package com.yolo.service.admin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yolo.dao.admin.inf.MemInfoDaoInf;
import com.yolo.model.MemJoinInfoVO;

@Service
public class MemInfoService implements MemInfoServiceInf{
	
	@Resource
	MemInfoDaoInf memInfoDao;

	@Override
	public List<MemJoinInfoVO> getMemberList(Map<String, String> paramMap) {
		List<MemJoinInfoVO> res = memInfoDao.getMemberList(paramMap);
		for (MemJoinInfoVO memJoinInfoVO : res) {
			if(memJoinInfoVO.getJoin_path().equals("03")){
				memJoinInfoVO.setJoin_path("페이스북");
			}else if(memJoinInfoVO.getJoin_path().equals("02")){
				memJoinInfoVO.setJoin_path("네이버");
			}else{
				memJoinInfoVO.setJoin_path("회원가입");
			}
		}
		//모든멤버리스트 가져오기(admin제외)
		return res;
	}

	@Override
	public int getMemberListCnt(Map<String, String> paramMap) {
		return memInfoDao.getMemberListCnt(paramMap);
	}

	@Override
	public int todayRegMember() {
		return memInfoDao.todayRegMember();
	}

	@Override
	public int todatDrop() {
		return memInfoDao.todayDropMember();
	}

	@Override
	public int blackList(Map<String, String> paramMap) {
		//있는지 체크 있으면 다음 없으면 인서트
		String mem_id = paramMap.get("mem_id");
		int res = memInfoDao.selectBlackList(mem_id);
		int resMem = memInfoDao.updateMemSTBlack(paramMap);
		if(res!=1){
			return memInfoDao.insertBlackList(mem_id);
		}else {
			return memInfoDao.blackList(paramMap);
		}
	}


}
