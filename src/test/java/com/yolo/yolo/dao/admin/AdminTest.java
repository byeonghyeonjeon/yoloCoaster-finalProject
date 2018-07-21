package com.yolo.yolo.dao.admin;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.yolo.dao.admin.inf.CategoryDaoInf;
import com.yolo.init.TestInit;

/**
 * 
 * AdminTest.java
 *
 * @author Brown
 * @since 2018. 6. 15.
 * @version 1.0
 * @see
 * data access test
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 15. Brown 최초 생성
 *
 * </pre>
 */
public class AdminTest extends TestInit{

	@Resource
	CategoryDaoInf categoryDao;
	
	@Test
	public void DaoCreatTest() { 
		assertNotNull(categoryDao);
	}
	

}
