package com.yolo.service.member;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yolo.dao.member.inf.AreaDaoInf;
import com.yolo.dao.member.inf.LikeAreaDaoInf;
import com.yolo.model.AreaVO;
import com.yolo.model.Like_areaVO;
@Transactional
@Service
public class LikeAreaService implements LikeAreaServiceInf{
	
	@Resource
	LikeAreaDaoInf likeAreaDao; 

	@Resource
	AreaDaoInf areaDao;
	
	@Override
	public int insertLikeArea(Like_areaVO laVO) {
		return likeAreaDao.insertLikeArea(laVO);
	}

	@Override
	public List<Like_areaVO> selectLikeAreaList(String mem_id) {
		
		List<Like_areaVO> resList = likeAreaDao.selectLikeAreaList(mem_id);
		for (int i = 0; i < resList.size(); i++) {
			AreaVO areaVo = areaDao.selectArea(resList.get(i).getArea_code());
			resList.get(i).setMem_id(areaVo.getAreaname());
		}
		return resList;
	}

	@Override
	public int deleteLikeArea(String mem_id) {
		return areaDao.deleteLikeArea(mem_id);
	}


}
