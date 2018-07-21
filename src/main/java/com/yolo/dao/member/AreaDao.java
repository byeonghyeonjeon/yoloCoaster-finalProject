package com.yolo.dao.member;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.member.inf.AreaDaoInf;
import com.yolo.model.AreaVO;
@Repository
public class AreaDao implements AreaDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public AreaVO selectArea(String areaCode) {
		return sessionTemplate.selectOne("likeArea.selectArea",areaCode);
	}

	@Override
	public int deleteLikeArea(String mem_id) {
		return sessionTemplate.delete("likeArea.deleteLikeArea",mem_id);
	}

	@Override
	public int selectBoardCnt(String mem_id) {
		return sessionTemplate.selectOne("likeArea.selectBoardCnt",mem_id);
	}

	@Override
	public String selectAreaCode(String param) {
		return sessionTemplate.selectOne("likeArea.selectAreaCode",param);
	}
	
}
