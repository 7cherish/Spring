package com.kh.spring.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

@Controller
public class MemberController {

	// 빈으로 등록되어 있다면 스프링이 자동으로 해줌.
	// 등록되어 있지 않다면 서버가 켜지지 않는다.
	@Autowired
	MemberService memberService;

	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	@RequestMapping("/member/memberEnroll.do")
	public String MemberEnroll() {
		return "member/memberEnroll";
		// 리턴할 페이지 경로
	}

	@RequestMapping("/member/memberEnrollEnd.do")
	public String MemberEnrollEnd(Member member, HttpServletRequest req) {
		System.out.println("암호화 전 : " + member.getPassword());
		String temp = member.getPassword();
		
		// BCrypt방식 암호화
		member.setPassword(bcryptPasswordEncoder.encode(temp));
		System.out.println("암호화 후 : " + member.getPassword());
		
		System.out.println("member@MemberEnrollEnd@MemberController = " + member);

		// 1. 비지니스로직 실행
		int result = memberService.insertMember(member);

		// 2. 처리결과에 따라 view단 분기처리
		String loc = "/";
		String msg = "";

		if (result > 0) {
			msg = "회원가입성공!";
		} else {
			msg = "회원가입실패!";
		}

		req.setAttribute("loc", loc);
		req.setAttribute("msg", msg);

		return "common/msg";
	}

}