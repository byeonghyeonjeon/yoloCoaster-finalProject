/**
 * 
 */
package com.yolo.controller.admin.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author PC15
 *
 */
@RequestMapping(value="/admin")
@Controller
public class AdminController {
	
	@RequestMapping("/main")
	public String AdminMain(){
		
		return "adminNotice";
	}
	
	/**
	 * 
	 * Method : adminStat
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @return
	 * Method 설명 : 관리자 통계화면
	 */
	@RequestMapping("adminStat")
	public String adminStat(){
		
		return "adminStat";
	}
	
	
	

}
