package com.yolo.yolo.dao.admin;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.yolo.dao.admin.inf.CategoryDaoInf;
import com.yolo.dao.admin.inf.MemInfoDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.MemJoinInfoVO;

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
public class AdminMemberTest extends TestInit{

	@Resource
	MemInfoDaoInf memInfoDao;
	
	@Test
	public void DaoCreatTest() { 
		/**Given**/
//		List<MemJoinInfoVO> memInfoList = null;
//
//		/**When**/
//		memInfoList = memInfoDao.getMemberList();
//
//		/**then**/
//		assertNotNull(memInfoList);
//		assertEquals(10, memInfoList.size());
//		System.out.println(memInfoList);

	}
	
	@Test
	public void selectBlackListTest() throws Exception {
		int res  = memInfoDao.selectBlackList("zxc");
		assertEquals(0, res);
	}
	

}
