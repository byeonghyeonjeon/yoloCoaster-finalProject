package com.yolo.controller.user.mypage;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yolo.model.MemberVO;
import com.yolo.service.member.MemberServiceInf;

@RequestMapping("myPageDrop")
@Controller
public class MyPageDropController {

	@Resource
	MemberServiceInf memberService;

	// 회원탈퇴창으로 이동
	@RequestMapping("dropMem")
	public String dropMem(MemberVO member, Model model) {

		model.addAttribute("memberVO", member);
		return "dropMem";
	}

	// 비밀번호 확인창으로 이동
	@RequestMapping("dropMemCheckPass")
	public String dropMemCheckPass(MemberVO member, Model model) {

		model.addAttribute("memberVO", member);
		return "dropMemCheckPass";
	}

	// 회원탈퇴후 메인화면으로 보냄
	@RequestMapping("dropMemReg")
	public String dropMemReg(MemberVO member, Model model,HttpSession session) {

		String mem_id = session.getAttribute("mem_id")+"";
		memberService.updateMemeberSt(mem_id);
		session.invalidate();
		model.addAttribute("memberVO", member);
		return "dropMemReg";
	}
}
