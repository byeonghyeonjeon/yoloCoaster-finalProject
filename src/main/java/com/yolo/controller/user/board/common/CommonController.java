package com.yolo.controller.user.board.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * CommonController.java
 *
 * @author JiHee
 * @since 2018. 6. 21.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 21. JiHee 최초 생성
 *
 * </pre>
 */
@RequestMapping("/common")
@Controller("CommonController")
public class CommonController {
	
	/**
	 * Method : searchForm
	 * 최초작성일 : 2018. 6. 21.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글 검색  폼
	 */
	@RequestMapping("/searchBoard")
	public String searchForm(){
		return "searchBoard";
	}
	
	/**
	 * Method : insertReplyForm
	 * 최초작성일 : 2018. 6. 21.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : 댓글 작성 폼
	 */
	@RequestMapping("/insertReply")
	public String insertReplyForm(){
		return "insertReply";
	}

}
