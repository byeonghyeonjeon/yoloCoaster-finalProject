package com.yolo.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yolo.dao.admin.inf.CategoryDaoInf;
import com.yolo.model.CategoryVO;

@Service
public class CategoryService implements CategoryServiceInf{
	
	@Resource
	private CategoryDaoInf categoryDao;
	
	@Override
	public List<CategoryVO> selectCategoryList() {
		return categoryDao.selectCategoryList();
	}
	
}
