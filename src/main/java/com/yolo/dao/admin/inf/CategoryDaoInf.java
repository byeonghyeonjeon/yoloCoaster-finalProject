package com.yolo.dao.admin.inf;

import java.util.List;

import com.yolo.model.CategoryVO;

public interface CategoryDaoInf {
	/**
	 * Method : selectCategoryList
	 * 최초작성일 : 2018. 6. 21.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return 모든 카테고리 목록
	 * Method 설명 : 모든 카테고리 목록 반환
	 */
	List<CategoryVO> selectCategoryList();
}
