package com.kh.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.spring.demo.model.service.DemoService;
import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

/**
 * 
 * @author POTATO
 * 
 * @Controller클래스 메소드가 가질 수 있는 파라미터
 * - HttpServletRequest
 * - HttpServletResponse
 * - HttpSession
 * 
 * - InputStream / Reader : 요청에 대한 입력
 * - OutputStream / Writer : 응답에 대한 출력
 * 
 * 하위 어노테이션을 가진 매개변수를 사용할 수 있다.
 * - @PathVariable
 * - @RequestParam
 * - @RequestHeader
 * - @CookieValue
 * - @RequestBody
 * 
 * - Map, Model, ModelMap : 뷰에 전달할 모델 데이터를 가진 객체 (속성에 저장할 필요없이 이 객체에 넣으면 된다)
 * - Command객체 - vo객체
 * - Error, BindingResult : 유효성 검사 관련 객체
 * - SessionStatus : 세션관리객체
 * - java.util.Locale : 서버지역정보
 * 
 
 * 
 * @RequestMapping설명
 * 	Mybatis때처럼 DispatcherServlet 하나로 .do로 끝나는 모든 요청을 받아서 처리하고 실제 요청은 메소드로 컨트롤러에 위임하게 된다.
 * 	예를 들면 @ReqeustMapping 어노테이션을 사용해서 (사용자의 요청. url. 요청메소드(get|post)) 알맞게 해당메소드로 연결시켜줄 수 있다.
 * 
 *  return은 리턴할 페이지를 적어준다.
 *  경로를 포함해서 적어줄 수 있다.
 *  return "demo/demo"; // /WEB-INF/views/demo/demo.jsp 여기로 view단을 선정해서 간다.
 */

@Controller
public class MemberController {
	// DI (의존주입) : 스프링은 빈을 관리시, 기본적으로 싱클턴으로 처리한다.
	// cf) 프로그램 돌아가면서 그 객체가 달랑 하나만 만들어지고 그걸 공유해서 쓰는 패턴이 싱클턴 패턴이다.
	// 자기 빈으로 등록된 객체중에서 DemoService 타입으로 검색해서
	// 실제 구현객체 demoServiceImpl을 demoService에 넣어준다. (참조 주소값 넣어준다는 얘기임)
	// 필드로 생성
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value= "/member/memberEnroll.do", method= RequestMethod.POST)
	public String insertMember(Member member) {
		// 업무로직
		int result = memberService.insertMember(member);
		
		System.out.println("insertMember메소드가 요청되었습니다.");
		System.out.println(result > 0? "등록성공":"등록실패");
		
		// 리다이렉트 하는 법 : redirect: 하고 다음 요청 주소를 적으면 된다. /는 인덱스
		return "redirect:/member/memberEnrollEnd.do";
	}
}
