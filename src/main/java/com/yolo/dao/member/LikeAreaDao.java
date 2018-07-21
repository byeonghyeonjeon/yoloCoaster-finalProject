package com.yolo.dao.member;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.member.inf.LikeAreaDaoInf;
import com.yolo.model.Like_areaVO;
@Repository
public class LikeAreaDao implements LikeAreaDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int insertLikeArea(Like_areaVO laVO) {
		return sessionTemplate.insert("member.insertLikeArea", laVO);
	}

	@Override
	public List<Like_areaVO> selectLikeAreaList(String mem_id) {
		return sessionTemplate.selectList("likeArea.selectLikeAreaList",mem_id);
	}
	
	
	
}
