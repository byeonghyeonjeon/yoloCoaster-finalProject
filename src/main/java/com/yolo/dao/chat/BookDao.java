/**
 * 
 */
package com.yolo.dao.chat;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.chat.inf.BookDaoInf;
import com.yolo.model.BookSearchVO;
import com.yolo.model.BookVO;

/**
 * @author PC15
 *
 */
@Repository("bookDao")
public class BookDao implements BookDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int bookInsert(BookVO bookVO) {
		return sessionTemplate.insert("book.bookInsert", bookVO);
	}

	@Override
	public List<BookVO> getBookMain(int chat_seq) {
		return sessionTemplate.selectList("book.getBookMain", chat_seq);
	}

	@Override
	public BookVO getBookDetail(int book_seq) {		
		return sessionTemplate.selectOne("book.getBookDetail", book_seq);
	}

	@Override
	public int bookDelete(int book_seq) {
		return sessionTemplate.delete("book.bookDelete", book_seq);
	}

	@Override
	public int bookUpdate(BookVO bookVO) {
		return sessionTemplate.update("book.bookUpdate", bookVO);
	}

	@Override
	public List<BookVO> bookSearch(BookSearchVO bookSearchVO) {
		return sessionTemplate.selectList("book.bookSearch", bookSearchVO);
	}
	


}
