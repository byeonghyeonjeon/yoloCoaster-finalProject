package com.yolo.dao.member.inf;

import java.util.List;

import com.yolo.model.Like_areaVO;

public interface LikeAreaDaoInf {
	int insertLikeArea(Like_areaVO laVO);

	/**
	 * 
	 * Method : selectLikeAreaList
	 * 최초작성일 : 2018. 7. 1.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 회원의 관심지역 리스트 
	 */
	public List<Like_areaVO> selectLikeAreaList(String mem_id);
}
