package com.yolo.service.member;

import java.util.List;

import com.yolo.model.Like_areaVO;

public interface LikeAreaServiceInf {
	int insertLikeArea(Like_areaVO laVO);

	public List<Like_areaVO> selectLikeAreaList(String mem_id);

	/**
	 * 
	 * Method : deleteLikeArea
	 * 최초작성일 : 2018. 7. 1.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 :회원의 관심지역 전체 삭제
	 */
	public int deleteLikeArea(String mem_id);

}
