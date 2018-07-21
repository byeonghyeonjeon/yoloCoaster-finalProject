package com.yolo.dao.admin;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.admin.inf.CategoryDaoInf;
import com.yolo.model.CategoryVO;
@Repository
public class CategoryDao implements CategoryDaoInf{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * Method : selectCategoryList
	 * 최초작성일 : 2018. 6. 21.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return 모든 카테고리 목록
	 * Method 설명 : 모든 카테고리 목록 반환
	 */
	@Override
	public List<CategoryVO> selectCategoryList() {
		return sessionTemplate.selectList("category.selectCategoryList");
	}
	
}
