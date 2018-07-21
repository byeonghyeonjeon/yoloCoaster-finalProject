/**
 * 
 */
package com.yolo.controller.user.chattingroom.book;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yolo.model.BookSearchVO;
import com.yolo.model.BookVO;
import com.yolo.model.Chat_nameVO;
import com.yolo.model.MemberVO;
import com.yolo.service.admin.ImageFilterServiceInf;
import com.yolo.service.chat.BookServiceInf;

/**
 * @author PC15
 *
 */
@RequestMapping(value="/chatBook")
@Controller
public class BookController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="bookService")
	private BookServiceInf bookService;
	

	@RequestMapping(value="/main")
	public String chatBookMain(HttpSession session, Model model){
		//chat_seq가져오기
		Chat_nameVO chat_nameVO = (Chat_nameVO) session.getAttribute("chatNameVO");		
		int chat_seq = chat_nameVO.getChat_seq();
		
		//bookMain리스트 조회 요청
		Map<String, Object> bookMap = bookService.getBookMain(chat_seq);
		
		List<BookVO> bookVOList = (List<BookVO>) bookMap.get("bookVOList");
		int currentMoney= (int) bookMap.get("currentMoney");
		int thisInCome = (int) bookMap.get("thisInCome");
		int thisOutCome = (int) bookMap.get("thisOutCome");
		
		model.addAttribute("bookVOList", bookVOList);
		model.addAttribute("currentMoney", currentMoney);
		model.addAttribute("thisInCome", thisInCome);
		model.addAttribute("thisOutCome", thisOutCome);
		
		
		return "content/user/chattingroom/chatBook/chatBookMain";
	}
	
	@RequestMapping(value="/main/create")
	public String chatBookMainCreate(){
		
		return "content/user/chattingroom/chatBook/chatBookCreate";
	}
	
	@RequestMapping(value="/main/detail")
	public String chatBookMainDetail(@RequestBody Map<String, String> bookMap, HttpSession session, Model model){
		String book_seq = bookMap.get("book_seq");
		int book_seq_int = Integer.parseInt(book_seq);
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");		
		String user_id = memberVO.getMem_id();
		
		//bookVO 조회요청
		BookVO bookVO = bookService.getBookDetail(book_seq_int);
		
		model.addAttribute("user_id", user_id);
		model.addAttribute("bookVO", bookVO);
		
		return "content/user/chattingroom/chatBook/chatBookDetail";
	}
	
	/* bookList 추가 insert*/
	@RequestMapping(value="/create/insert")
	@ResponseBody
	public Map<String, Object> chatBookCreateInsert(@RequestBody Map<String, String> bookMap, HttpSession session, Model model) throws IOException{
		//chat_seq 가져오기
		Chat_nameVO chat_nameVO = (Chat_nameVO) session.getAttribute("chatNameVO");
		int chat_seq = chat_nameVO.getChat_seq(); 
		//mem_id 가져오기
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		String mem_id = memberVO.getMem_id();
		
		String book_money = bookMap.get("book_money");
		int book_money_int = Integer.parseInt(book_money);
		String book_cate = bookMap.get("book_cate");
		String book_memo = bookMap.get("book_memo");
		
		String book_day = bookMap.get("book_day");
		//시간이랑 날짜로 나누기 ??		
		String book_dt = book_day.substring(0,10);
		String book_time = book_day.substring(11,16);		
		
		String book_detail = bookMap.get("book_detail");
		String book_method = bookMap.get("book_method");		
		String book_inout = bookMap.get("book_inout");
		
		//bookVO에 정보 설정	
		BookVO bookVO = new BookVO();
		bookVO.setChat_seq(chat_seq);
		bookVO.setBook_mem_id(mem_id);
		bookVO.setBook_cate(book_cate);
		bookVO.setBook_detail(book_detail);
		
		bookVO.setBook_time(book_time);
		bookVO.setBook_dt(book_dt);
		
		bookVO.setBook_method(book_method);
		bookVO.setBook_memo(book_memo);
		bookVO.setBook_money(book_money_int);
		bookVO.setBook_inout(book_inout);
		
		//bookInsert 요청
		int bookInsertCnt = bookService.bookInsert(bookVO);
				
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("bookInsertCnt", bookInsertCnt);
		return  resultMap;
	}
	
	
	/* bookList 검색*/
	@RequestMapping(value="/main/search")
	public String chatBookMainSearch(@RequestBody Map<String, String> bookMap, HttpSession session, Model model){
		//chat_seq 가져오기
		Chat_nameVO chat_nameVO = (Chat_nameVO) session.getAttribute("chatNameVO");
		int chat_seq = chat_nameVO.getChat_seq(); 
		
		String selectMonth =  bookMap.get("selectMonth");
		String selectInOut =  bookMap.get("selectInOut");
		String selectContent =  bookMap.get("selectContent");
		String searchText = bookMap.get("searchText");
		
		BookSearchVO bookSearchVO = new BookSearchVO();
		bookSearchVO.setSearchText(searchText);
		bookSearchVO.setSelectMonth(selectMonth);
		bookSearchVO.setSelectInOut(selectInOut);
		bookSearchVO.setSelectContent(selectContent);
		bookSearchVO.setChat_seq(chat_seq);
		
		List<BookVO> bookVOList = bookService.bookSearch(bookSearchVO);
		
		model.addAttribute("bookVOList",bookVOList);
		
		return "content/user/chattingroom/chatBook/chatBookTable";
	}
	
	/* book 수정 */
	@RequestMapping(value="/detail/update")
	public String chatBookDetailUpdate(@RequestBody Map<String, String> bookMap, HttpSession session, Model model){
		//update할 정보 가져오기
		String book_seq = bookMap.get("book_seq");
		String book_money = bookMap.get("book_money");
		int book_seq_int = Integer.parseInt(book_seq);
		int book_money_int = Integer.parseInt(book_money);		 
		String book_method = bookMap.get("book_method");
		String book_memo = bookMap.get("book_memo");
		String book_inout = bookMap.get("book_inout");
		String book_detail = bookMap.get("book_detail");
		String book_cate = bookMap.get("book_cate");
		
		String book_day = bookMap.get("book_day");
		String book_dt = book_day.substring(0,10);
		String book_time = book_day.substring(11,16);
		
		
		//bookVO에 정보 설정
		BookVO bookVO = new BookVO();
		
		bookVO.setBook_seq(book_seq_int);	
		bookVO.setBook_cate(book_cate);
		bookVO.setBook_detail(book_detail);
		bookVO.setBook_money(book_money_int);
		bookVO.setBook_method(book_method);
		bookVO.setBook_memo(book_memo);
		bookVO.setBook_inout(book_inout);
		
		bookVO.setBook_dt(book_dt);
		bookVO.setBook_time(book_time);
		
		int bookUpdateCnt = bookService.bookUpdate(bookVO);		 
				
		
		return chatBookMainDetail(bookMap, session, model);
	}
	
	/* book 삭제 */
	@RequestMapping(value="/detail/delete")
	public String chatBookDetailDelete(@RequestBody Map<String, String> bookMap, HttpSession session, Model model){		
		
		String book_seq = bookMap.get("book_seq");
		int book_seq_int = Integer.parseInt(book_seq); 
		
		int bookDeleteCnt = bookService.bookDelete(book_seq_int);
		
		return chatBookMain(session, model);
	}
}
