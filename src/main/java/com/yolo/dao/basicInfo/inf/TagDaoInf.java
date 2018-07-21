package com.yolo.dao.basicInfo.inf;

import java.util.List;

import com.yolo.model.TagVO;

public interface TagDaoInf {

	public int insertTag(TagVO tag);

	/**
	 * 
	 * Method : selectTagList
	 * 최초작성일 : 2018. 7. 4.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param board_seq
	 * @return
	 * Method 설명 : 태그 가져오기
	 */
	public List<TagVO> selectTagList(int board_seq);

	/**
	 * 
	 * Method : delete
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param board_seq
	 * @return
	 * Method 설명 :해당게시글의 태그리스트 삭제
	 */
	public int deleteTagList(int board_seq);
}
