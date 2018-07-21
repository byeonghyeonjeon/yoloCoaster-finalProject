package com.yolo.service.schedule;

import java.util.List;

import com.yolo.model.Bookmark_areaVO;

public interface ScheduleDetailServiceInf {

	/**
	 * 
	 * Method : getBookmarkList
	 * 최초작성일 : 2018. 7. 13.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 회원의 즐겨찾기 여행지 가져오기
	 */
	public List<Bookmark_areaVO> getBookmarkList(String mem_id);

}
