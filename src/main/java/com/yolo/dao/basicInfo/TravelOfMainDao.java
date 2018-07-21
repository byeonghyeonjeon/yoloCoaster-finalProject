package com.yolo.dao.basicInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.basicInfo.inf.TravelOfMainDaoInf;
import com.yolo.model.BasicinfoVO;
import com.yolo.model.MemberVO;
import com.yolo.model.PageVO;
import com.yolo.model.TravelVO;

/**
 * travelOfMainDao.java
 *
 * @author JiHee
 * @since 2018. 7. 7.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 7. JiHee 최초 생성
 *
 * </pre>
 */
@Repository
public class TravelOfMainDao implements TravelOfMainDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public List<TravelVO> areaOfInterest(String mem_id) {
		return sessionTemplate.selectList("index.areaOfInterest", mem_id);
	}

	@Override
	public int numberOfAreaOfInterest(String mem_id) {
		return sessionTemplate.selectOne("index.numberOfAreaOfInterest", mem_id);
	}

	@Override
	public List<TravelVO> profileRecommend(String subAddr1) {
		return sessionTemplate.selectList("index.profileRecommend",subAddr1);
	}

	@Override
	public List<TravelVO> areaRecommendPage(Map<String, String> map) {
		return sessionTemplate.selectList("index.areaRecommendPage", map);
	}

	@Override
	public int numberOfProfileRecommend(String addr1) {
		return sessionTemplate.selectOne("index.numberOfProfileRecommend", addr1);
	}

	@Override
	public List<TravelVO> profileRecommendPage(Map<String, String> map) {
		return sessionTemplate.selectList("index.profileRecommendPage", map);
	}

	@Override
	public List<TravelVO> eventRecommendPage(Map<String, String> map) {
		return sessionTemplate.selectList("index.eventRecommendPage", map);
	}

	@Override
	public int numberOfEventRecommend(String addr1) {
		return sessionTemplate.selectOne("index.numberOfEventRecommend", addr1);
	}

	@Override
	public List<TravelVO> eventRecommend(String addr1) {
		return sessionTemplate.selectList("index.eventRecommend", addr1);
	}
	
	
}
