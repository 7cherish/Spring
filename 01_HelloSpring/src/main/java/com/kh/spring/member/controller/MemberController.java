package com.kh.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

@Controller
@SessionAttributes(value= {"memberLoggedIn"})
// memberLoggedIn이라는 이름으로 모델에 세션속성으로 담으라는 뜻.
// value={""} 문자열 배열로 여러 개가 올 수 있다.
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
/*
	@RequestMapping(value = "/member/memberLogin.do", method = RequestMethod.POST)
	public String MemberLogin(@RequestParam String memberId, 
							  @RequestParam String password, 
							  Model model,
							  HttpSession session) {
		// 아이디를 통해서 selectOne메소드 호출결과 Member 객체를 가져온다.
		Member m = memberService.selectOneMember(memberId);

		System.out.println("m@MemberLogin@MemberController = " + m);

		// 2. 처리결과에 따라 view단 분기처리
		String loc = "/";
		String msg = "";
		String view = "common/msg";

		// 로그인 처리
		if (m == null) {
			msg = "아이디가 존재하지 않습니다.";
			loc = "/";
		} else {
			// 비밀번호 비교
			if (bcryptPasswordEncoder.matches(password, m.getPassword())) {
				// 비밀번호 일치했을시 세션 상태 유지
				session.setAttribute("memberLoggedIn", m);
				view = "redirect:/";

			} else {
				msg = "비밀번호를 잘못 입력하셨습니다.";
				loc = "/";
			}
		}

		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);

		return view;
	}
*/
/*
	@RequestMapping(value = "/member/memberLogin.do", method = RequestMethod.POST)
	public String MemberLogin(@RequestParam String memberId, 
			@RequestParam String password, 
			Model model,
			HttpSession session) {
		// 아이디를 통해서 selectOne메소드 호출결과 Member 객체를 가져온다.
		Member m = memberService.selectOneMember(memberId);
		
		System.out.println("m@MemberLogin@MemberController = " + m);
		
		// 2. 처리결과에 따라 view단 분기처리
		String loc = "/";
		String msg = "";
		String view = "common/msg";
		
		// 로그인 처리
		if (m == null) {
			msg = "아이디가 존재하지 않습니다.";
			loc = "/";
		} else {
			// 비밀번호 비교
			if (bcryptPasswordEncoder.matches(password, m.getPassword())) {
				// 비밀번호 일치했을시 세션 상태 유지
				model.addAttribute("memberLoggedIn", m);
				view = "redirect:/";
				
			} else {
				msg = "비밀번호를 잘못 입력하셨습니다.";
				loc = "/";
			}
		}
		
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return view;
	}
*/	
	
	/**
	 * ModelAndView(2.0)
	 * 	- Model 과 View 단 정보를 한 번에 다룬다.
	 * 
	 * ModelMap(2.0) : 일반 클래스
	 * 	- Model 객체관리, View 단은 문자열로 리턴하는 형식이다.
	 * 
	 * Model(2.5) : 인터페이스
	 * 	- Model 객체관리, View 단은 문자열로 리턴하는 형식이다.
	 * 
	 */
	@RequestMapping(value = "/member/memberLogin.do", method = RequestMethod.POST)
	public ModelAndView MemberLogin(@RequestParam String memberId, 
			@RequestParam String password, 
			ModelAndView mav,
			HttpSession session) {
		// 아이디를 통해서 selectOne메소드 호출결과 Member 객체를 가져온다.
		Member m = memberService.selectOneMember(memberId);
		
		System.out.println("m@MemberLogin@MemberController = " + m);
		
		// 2. 처리결과에 따라 view단 분기처리
		String loc = "/";
		String msg = "";
		String view = "common/msg";
		
		// 로그인 처리
		if (m == null) {
			msg = "아이디가 존재하지 않습니다.";
			loc = "/";
		} else {
			// 비밀번호 비교
			if (bcryptPasswordEncoder.matches(password, m.getPassword())) {
				// 비밀번호 일치했을시 세션 상태 유지
				mav.addObject("memberLoggedIn", m);
				view = "redirect:/";
				
			} else {
				msg = "비밀번호를 잘못 입력하셨습니다.";
				loc = "/";
			}
		}
		
		mav.addObject("loc", loc);
		mav.addObject("msg", msg);
		mav.setViewName(view);
		
		return mav;
	}
	
	@RequestMapping("/member/memberLogout.do")
	public String logout(SessionStatus sessionStatus) {
		// 기존에서처럼 session.SetAttribute() 사용하면 session.invalidate()으로 무효화시키면 된다.
		// @SessionAttributes 사용하면 sessionStatus.setComplete()로 무효화한다.
		// 둘 중 하나만 사용한다.
		
		if(!sessionStatus.isComplete()) {
			sessionStatus.setComplete();
		}
		
		return "redirect:/";
	}
	
	

}