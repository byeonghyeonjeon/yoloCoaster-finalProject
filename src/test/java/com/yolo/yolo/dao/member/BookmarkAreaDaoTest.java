package com.yolo.yolo.dao.member;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.member.inf.BookmarkAreaDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.AreaVO;
import com.yolo.model.Bookmark_areaVO;

public class BookmarkAreaDaoTest extends TestInit{

	@Resource
	BookmarkAreaDaoInf bookmarkAreaDao;
	
	@Test
	public void createTest() {
		assertNotNull(bookmarkAreaDao);
	}

	@Test
	public void selectBookmarkListTest() throws Exception {
		List<Bookmark_areaVO> res = bookmarkAreaDao.getBookmarkList("test");
		assertEquals(1, res.size());
		assertEquals("test", res.get(0).getMem_id());
	}
	
	
	
	
}
