package com.yolo.dao.member.inf;

import java.util.List;

import com.yolo.model.Bookmark_areaVO;

public interface BookmarkAreaDaoInf {

	/**
	 * 
	 * Method : getBookmarkList
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : in userId out bookmarkVO
	 */
	public List<Bookmark_areaVO> getBookmarkList(String mem_id);
	
	/**
	 * 
	 * Method : deleteBookmarkArea
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param link
	 * @return
	 * Method 설명 :여행지 즐겨찾기 삭제
	 */
	public int deleteBookmarkArea(int link);

	/**
	 * 
	 * Method : selectBookmarkAreaList
	 * 최초작성일 : 2018. 7. 14.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param content_content
	 * @param mem_id 
	 * @return
	 * Method 설명 :세부일정의 여행지 즐겨찾기 리스트 조회
	 */
	public Bookmark_areaVO selectBookmarkAreaList(String content_content, String mem_id);

}
