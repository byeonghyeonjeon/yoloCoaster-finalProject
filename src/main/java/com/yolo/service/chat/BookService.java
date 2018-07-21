/**
 * 
 */
package com.yolo.service.chat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yolo.dao.chat.inf.BookDaoInf;
import com.yolo.model.BookSearchVO;
import com.yolo.model.BookVO;

@Service("bookService")
public class BookService implements BookServiceInf {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "bookDao")
	private BookDaoInf bookDao;

	@Override
	public int bookInsert(BookVO bookVO) {		
		return bookDao.bookInsert(bookVO);
	}

	@Override
	public Map<String, Object> getBookMain(int chat_seq) {
		Map<String, Object> bookMap = new HashMap<String, Object>();
		//가계부 리스트 가져오기 
		List<BookVO> bookVOList = bookDao.getBookMain(chat_seq);		
		
		//현재 월 구하기
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.KOREA);
		Date current = new Date();
		String month = monthFormat.format(current);		
				
		//현재보유 금액 >> 전체(수입-지출)
		int inCome = 0;
		int outCome = 0;			
		for(BookVO bookVO : bookVOList){
			if(bookVO.getBook_inout().equals("IN")){
				inCome += bookVO.getBook_money();
			}else if (bookVO.getBook_inout().equals("OUT")){
				outCome += bookVO.getBook_money();
			}
		}
		//현재 보유 금액
		int currentMoney = inCome - outCome;
		
		int thisInCome = 0;
		int thisOutCome = 0;
		//이번달 수입/ 지출내역
		for(BookVO bookVO : bookVOList){
			if(bookVO.getBook_dt().substring(5, 7).equals(month)){
				if(bookVO.getBook_inout().equals("IN")){
					thisInCome += bookVO.getBook_money();
				}else if(bookVO.getBook_inout().equals("OUT")){
					thisOutCome += bookVO.getBook_money();
				}
			}
		}
		
		bookMap.put("bookVOList", bookVOList);
		bookMap.put("currentMoney", currentMoney);
		bookMap.put("thisInCome", thisInCome);
		bookMap.put("thisOutCome", thisOutCome);	
		
		return bookMap;
	}

	@Override
	public BookVO getBookDetail(int book_seq) {		
		return bookDao.getBookDetail(book_seq);
	}

	
	@Override
	public int bookDelete(int book_seq) {	
		return bookDao.bookDelete(book_seq);	
	}

	@Override
	public int bookUpdate(BookVO bookVO) {
		return bookDao.bookUpdate(bookVO);
	}

	@Override
	public List<BookVO> bookSearch(BookSearchVO bookSearchVO) {
		return bookDao.bookSearch(bookSearchVO);
	}

}
