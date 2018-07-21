package com.yolo.controller.user.join;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yolo.model.EmailVO;
import com.yolo.model.MemberVO;
import com.yolo.service.login.FindInfoServiceInf;

@RequestMapping("findInfo")
@Controller
public class FindInfoController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource
	FindInfoServiceInf findInfoService;
	
	@RequestMapping("/findId")
	public String findId() {
		//아이디 찾기 폼 호출
		return "findIdForm";
	}
	
	@RequestMapping("/matchFindId")
	@ResponseBody
	public String matchFindId(@RequestBody Map<String, String> userInfo) {
		//회원 아이디 찾기 (이름, 이메일 주소 맞으면 메일보내기 & 성공 리턴하면 인증번호입력칸 활성화
		MemberVO memVO = new MemberVO();
		memVO.setMem_name(userInfo.get("mem_name"));
		memVO.setMem_mail(userInfo.get("mem_mail"));
		int result = findInfoService.findMemId(memVO);
		if(result!=0){
			//메일보내기
			EmailVO mailVO = new EmailVO();
			mailVO.setReceiver(memVO.getMem_mail());
			mailVO.setSubject(memVO.getMem_name() + "님의 아이디 찾기 인증번호 입니다.");
			mailVO.setContent("yolocoaster 인증번호 : " + findInfoService.getjoinCertify(memVO).get(0));
			boolean res = findInfoService.sendMail(mailVO);
			if(res){
				return "yes";				
			}else{
				return "no";
			}
			
		}else{
			return "no";
		}
		
		
	}
	
	@RequestMapping("/findIdResult")
	public String findIdResult(@ModelAttribute("asdf")MemberVO memVO, String join_certify, Model model){
		//인증번호 일치할때 액션
		String certify = findInfoService.getjoinCertify(memVO).get(0);
		if(certify.equals(join_certify)){
			List<String> idList = findInfoService.getMemIdList(memVO);
			model.addAttribute("memberIdList", idList);
			model.addAttribute("mem_name", memVO.getMem_name());
			return "findIdList";
		}
		
		return "findIdForm";
	}
	
	
	@RequestMapping("/findPasswordForm")
	public String findPassword(String id, Model model) {
		//비밀번호 찾기 폼 호출
		model.addAttribute("userId", id);
		return "findPasswordForm";
	}
	
	@RequestMapping("/matchFindPassword")
	@ResponseBody
	public String matchFindPassword(@RequestBody Map<String, String> userInfo) {
		//회원 비밀번호 찾기 (이름, 이메일 주소 맞으면 메일보내기 & 성공 리턴하면 인증번호입력칸 활성화
		MemberVO memVO = new MemberVO();
		memVO.setMem_name(userInfo.get("mem_name"));
		memVO.setMem_mail(userInfo.get("mem_mail"));
		memVO.setMem_id(userInfo.get("mem_id"));
		int result = findInfoService.findMemPass(memVO);
		String passCertify = findInfoService.getPassCertify(memVO);
		
		if(result!=0 && passCertify!=null){
			//메일보내기
			EmailVO mailVO = new EmailVO();
			mailVO.setReceiver(memVO.getMem_mail());
			mailVO.setSubject(memVO.getMem_name() + "님의 비밀번호 찾기 인증번호 입니다.");
			mailVO.setContent("yolocoaster 인증번호 : " + passCertify);
			boolean res = findInfoService.sendMail(mailVO);
			if(res){
				return "yes";				
			}else{
				return "no";
			}
			
		}else{
			return "no";
		}
		
		
	}

	@RequestMapping("/resetPasswordForm")
	public String resetPasswordForm(@RequestParam String mem_id, String mem_name, String mem_mail, String join_certify, Model model){
		MemberVO memVO = new MemberVO();
		memVO.setMem_id(mem_id);
		memVO.setMem_name(mem_name);
		memVO.setMem_mail(mem_mail);
		
		//비밀번호찾기 인증번호 일치할때 액션
		String certify = findInfoService.getPassCertify(memVO);
		if(certify.equals(join_certify)){
			model.addAttribute("userId", memVO.getMem_id());
			return "resetPasswordForm";
		}
		
		return "findPasswordForm";
	}
	
	@RequestMapping("/resetPassword")
	public String resetPassword(@RequestParam String mem_id, String mem_pass){
		//비밀번호변경
		MemberVO memVO = new MemberVO();
		memVO.setMem_id(mem_id);
		memVO.setMem_pass(mem_pass);
		int result = findInfoService.resetMemberPass(memVO);
		if(result!=0){
			return "index";
		}
		
		return "resetPasswordForm";
	}
	
	
}
