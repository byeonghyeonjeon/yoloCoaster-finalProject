/**
 * 
 */
package com.yolo.dao.chat.inf;

import java.util.List;

import com.yolo.model.BookSearchVO;
import com.yolo.model.BookVO;

/**
 * @author PC15
 *
 */
public interface BookDaoInf {
	
	/**
	 * 
	* Method : bookInsert
	* 최초작성일 : 2018. 7. 3.
	* 작성자 : PC15
	* 변경이력 :
	* @param bookVO
	* @return
	* Method 설명 : bookInsert 요청
	 */
	public int bookInsert(BookVO bookVO);
	
	public List<BookVO> getBookMain(int chat_seq);
	
	public BookVO getBookDetail(int book_seq);
	
	/**
	 * 
	* Method : bookDelete
	* 최초작성일 : 2018. 7. 4.
	* 작성자 : PC15
	* 변경이력 :
	* @param book_seq
	* @return
	* Method 설명 : bookVO 삭제 요청
	 */
	public int bookDelete(int book_seq);
	
	/**
	 * 
	* Method : bookUpdate
	* 최초작성일 : 2018. 7. 4.
	* 작성자 : PC15
	* 변경이력 :
	* @param bookVO
	* @return
	* Method 설명 :bookVO 수정 요청
	 */
	public int bookUpdate(BookVO bookVO);

	/**
	* Method : bookSearch
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC15
	* 변경이력 :
	* @param bookSearchVO
	* @return
	* Method 설명 :
	*/
	public List<BookVO> bookSearch(BookSearchVO bookSearchVO);
}
