/**
 * 
 */
package com.yolo.controller.user.chattingroom.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author PC15
 *
 */
@RequestMapping(value="/chatBoard")
@Controller
public class BoardController {

	@RequestMapping(value="/main")
	public String chatBoardMain(){
		
		return "content/user/chattingroom/chatBoard/chatBoardMain";
	}
	
	@RequestMapping(value="/main/detail")
	public String chatBoardMainDetail(){
		
		return "content/user/chattingroom/chatBoard/chatBoardDetail";
	}	
	
	@RequestMapping(value="/main/create")
	public String chatBoardMainCreate(){
		
		return "content/user/chattingroom/chatBoard/chatBoardCreate";
	}
	
	@RequestMapping(value="/detail/update")
	public String chatBoardDetailUpdated(){
		
		return "redirect:/chatBoard/main/detail";
	}
	
	@RequestMapping(value="/detail/delete")
	public String chatBoardDetailDelete(){
		
		return "redirect:/chatBoard/main";
	}
	
	/* boardList 검색*/
	@RequestMapping(value="/main/search")
	public String chatBoardMainSearch(){
		
		return "redirect:/chatBoard/main";
	}

	
}
