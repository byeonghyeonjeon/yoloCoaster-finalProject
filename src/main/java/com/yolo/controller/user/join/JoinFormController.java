package com.yolo.controller.user.join;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yolo.model.MemberVO;
import com.yolo.service.join.JoinServiceInf;
import com.yolo.service.member.JoinInfoServiceInf;
import com.yolo.service.member.LikeAreaServiceInf;

/**
 * JoinFormController.java
 *
 * @author PC14
 * @since 2018. 6. 19.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 19. PC14 최초 생성
 *
 * </pre>
 */
@Controller
@RequestMapping("join")
public class JoinFormController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	//서비스 호출
	@Resource
	JoinInfoServiceInf joinInfoService;
	
	@Resource
	JoinServiceInf joinService;
	
	@Resource
	LikeAreaServiceInf likeAreaService;
	
	@RequestMapping("/joinForm")
	public String getJoinFormPage() {
		//회원가입 폼 호출
		return "joinForm";
	}
	
	@RequestMapping("/faceBookJoinForm")
	public String getFaceBookJoinFormPage(@RequestParam String mem_mail, String mem_gen, String mem_age, @ModelAttribute("infoVO")MemberVO memVO, Model model) {
		//페이스북 회원가입 폼 호출
		memVO = new MemberVO();
		//정보를 객체에 담음
		memVO.setMem_mail(mem_mail);
		if(mem_gen!=""){if(mem_gen.equals("female")){memVO.setMem_gen("W");}else{memVO.setMem_gen("M");}}
		memVO.setMem_age(Integer.toString((Integer.parseInt(mem_age)/10)*10));
		model.addAttribute("infoVO", memVO);
		model.addAttribute("join_path", "03");
		
		return "joinForm";
	}
	
	@RequestMapping("naverLoginCallBack")
	public String naverLoginCallBack(){
		return "content/user/main/naverLoginCallBack";
	}
	
	
	@RequestMapping("naverJoinForm")
	public String getNaverJoinFormPage(@RequestParam String mem_mail, String mem_gen, String mem_age, @ModelAttribute("infoVO")MemberVO memVO, Model model) {
		//네이버 회원가입 폼 호출
		memVO = new MemberVO();
		//정보를 객체에 담음
		memVO.setMem_mail(mem_mail);
		if(mem_gen.equals("F")){memVO.setMem_gen("W");}else{memVO.setMem_gen("M");}
		memVO.setMem_age(mem_age.substring(0, 2));
		model.addAttribute("infoVO", memVO);
		model.addAttribute("join_path", "02");
		System.out.println(memVO);
		
		return "joinForm";
	}
	
	@RequestMapping("/idCheck")
	@ResponseBody
	public String idCheck(@RequestBody String id){
		//일치하는 아이디가 있는지 확인
		int result = joinInfoService.idCheck(id);
		if(result == 0){//사용가능
			return id; 
		}else{//사용불가
			return ""; 
		}
	}
	
	@RequestMapping("/insertMember")
	@ResponseBody
	public String insertMember(@RequestBody Map<String,Object> json_Data){
		
		MemberVO memVO = new MemberVO();
		memVO.setMem_id((String)json_Data.get("mem_id"));
		memVO.setMem_mail((String)json_Data.get("mem_mail"));
		memVO.setMem_pass((String)json_Data.get("mem_pass"));
		memVO.setMem_name((String)json_Data.get("mem_name"));
		memVO.setMem_gen((String)json_Data.get("mem_gen"));
		memVO.setMem_age((String)json_Data.get("mem_age"));
		memVO.setMem_add1((String)json_Data.get("mem_addr1"));
		memVO.setMem_add2((String)json_Data.get("mem_addr2"));
		memVO.setMem_tel((String)json_Data.get("mem_tel"));
		memVO.setMem_nick((String)json_Data.get("mem_nick"));
		
		String join_path = (String)json_Data.get("join_path");
		System.out.println(join_path);
		
		ArrayList<String> like_area = (ArrayList<String>) json_Data.get("like_area");
		 
		//서비스 요청 
		int joinResult = joinService.insertMember(memVO, like_area, join_path);
		
		if(joinResult !=0){
			return "yes";			
		}else{
			return "no";			
		}
		
	}
	
	
}
