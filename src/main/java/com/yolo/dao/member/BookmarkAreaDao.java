package com.yolo.dao.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.member.inf.BookmarkAreaDaoInf;
import com.yolo.model.Bookmark_areaVO;
@Repository
public class BookmarkAreaDao implements BookmarkAreaDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	/**
	 * 
	 * Method : getBookmarkList
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 즐겨찾기한 여행지 리스트 가져오기
	 */
	@Override
	public List<Bookmark_areaVO> getBookmarkList(String mem_id) {
		logger.debug("{}{}", "getBookmarkList",mem_id);
		return sessionTemplate.selectList("member.getBookmarkList",mem_id);
	}


	@Override
	public int deleteBookmarkArea(int link) {
		return sessionTemplate.delete("member.deleteBookmarkArea",link);
	}


	@Override
	public Bookmark_areaVO selectBookmarkAreaList(String param,String mem_id) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("param", param);
		paramMap.put("mem_id", mem_id);
		return sessionTemplate.selectOne("scheDetail.selectBookmarkAreaList",paramMap);
	}
}
