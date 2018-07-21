package com.yolo.controller.user.main;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yolo.model.MemberVO;
import com.yolo.service.member.LoginInfoServiceInf;

@Controller
@RequestMapping("login")
public class LoginController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource
	LoginInfoServiceInf loginInfoService;
	
	@RequestMapping("/getMemberLogin")
	@ResponseBody
	public String getMemberLogin(@RequestBody Map<String, String> userInfo, HttpSession session){
		//일치하는 유저 정보 가져오기
		MemberVO memVO = new MemberVO();
		memVO.setMem_id(userInfo.get("mem_id"));
		memVO.setMem_pass(userInfo.get("mem_pass"));
		//log.debug("{} : {}", "유저정보", memVO.toString());
		
		MemberVO memberVO = loginInfoService.getMemberLogin(memVO);
		
		if(memberVO != null){	//유저정보가 있을 때
			session.setAttribute("memberVO", memberVO);
			session.setAttribute("mem_id", memberVO.getMem_id());
			
			//관리자
			if(memberVO.getMem_id().equals("admin")){
				return"admin";
			}
			
			return "yes"; 
		}else{					//유저정보가 없을 때
			return "no"; 
		}
		
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(@RequestBody String location, HttpSession session){
		session.invalidate();
		System.out.println("location : "+location);
		//회원 세션종료후 메인으로 이동
		if(location!=""){
			return "yes";
		}else{
			return "no";
		}
	}
	
}
