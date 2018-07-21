package com.yolo.yolo.service.category;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yolo.init.TestInit;
import com.yolo.model.CategoryVO;
import com.yolo.service.admin.CategoryServiceInf;

/**
 * CategoryServiceTest.java
 *
 * @author Jun
 * @since 2018. 6. 21.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 21. Jun 최초 생성
 *
 * </pre>
 */
public class CategoryServiceTest extends TestInit{

	Logger loger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private CategoryServiceInf categoryService;
	
	
	@Test
	public void createServiceTest() throws Exception {
		assertNotNull(categoryService);
	}
	
	
	
	@Test
	public void selectCategoryListTest() {
		List<CategoryVO> categoryVOs = categoryService.selectCategoryList();
		assertNotNull(categoryVOs);
		assertEquals(2, categoryVOs.size());
	}
	

}
