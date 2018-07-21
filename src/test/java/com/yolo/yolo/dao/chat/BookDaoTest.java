/**
 * 
 */
package com.yolo.yolo.dao.chat;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.chat.inf.BookDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.BookSearchVO;
import com.yolo.model.BookVO;

/**
 * @author PC15
 *
 */
public class BookDaoTest extends TestInit{
	
	@Resource(name = "bookDao")
	private BookDaoInf bookDao;
	

	@Test
	public void bookSearchTest() {
		
		BookSearchVO bookSearchVO = new BookSearchVO();
		bookSearchVO.setChat_seq(28);
		
		/*bookSearchVO.setSelectMonth("ALL");*/
		bookSearchVO.setSelectMonth("07");
		bookSearchVO.setSelectInOut("IN");
		bookSearchVO.setSelectContent("CATEGORY");
		bookSearchVO.setSearchText("식비"); 
		
		List<BookVO> bookVOList = bookDao.bookSearch(bookSearchVO);
		
		assertNotNull(bookVOList);
		assertEquals(3, bookVOList.size());
		
	}

}
