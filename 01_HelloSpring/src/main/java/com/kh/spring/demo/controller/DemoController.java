package com.kh.spring.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.demo.model.service.DemoService;
import com.kh.spring.demo.model.vo.Dev;

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
 * - Map, Model, ModelMap : 뷰에 전달한 모델 데이터
 * - Command객체 - vo객체
 * - Error, BindingResult : 유효성 검사 관련 객체
 * - SessionStatus : 세션관리객체
 * - java.util.Locale : 서버지역정보
 * 
 */

@Controller
public class DemoController {

	// DI (의존주입)
	// 필드로 생성
	@Autowired
	DemoService demoService;
	
	@RequestMapping("/demo/demo.do")
	public String demo() {
		System.out.println("demo메소드가 요청되었습니다.");
		
		// 리턴할 페이지를 적어준다.
		return "demo/demo"; // /WEB-INF/views/demo/demo.jsp
	}
	
	@RequestMapping("/demo/demo1.do")
	public String demo1(HttpServletRequest request) {
		String devName = request.getParameter("devName");
		int devAge = Integer.parseInt(request.getParameter("devAge"));
		String devEmail = request.getParameter("devEmail");
		String devGender = request.getParameter("devGender");
		String[] devLang = request.getParameterValues("devLang");
		
		Dev dev = new Dev(0, devName, devAge, devEmail, devGender, devLang);
		
		System.out.println("demo1메소드가 요청되었습니다.");
		System.out.println("dev@demo1()@DemoController = " + dev);
		
		request.setAttribute("dev", dev);
		
		// 리턴할 페이지를 적어준다.
		return "demo/demoResult"; // /WEB-INF/views/demo/demoResult.jsp
		
	}
	
	// @RequestParam(value="devName")에 담긴 것을 String devName에 담아라)
	@RequestMapping("/demo/demo2.do")
	public String demo2(Model model, 
						@RequestParam(value="devName", required=false) String devName,
						@RequestParam(value="devAge", defaultValue="30") int devAge,
						@RequestParam(value="devEmail") String devEmail,
						@RequestParam(value="devGender") String devGender,
						@RequestParam(value="devLang") String[] devLang) {
		
		Dev dev = new Dev(0, devName, devAge, devEmail, devGender, devLang);
		
//		request.setAttribute("dev", dev);
		model.addAttribute("dev", dev);
		
		System.out.println("demo2메소드가 요청되었습니다.");
		System.out.println("dev@demo2()@DemoController = " + dev);
		
		// 리턴할 페이지를 적어준다.
		return "demo/demoResult"; // /WEB-INF/views/demo/demoResult.jsp
		
	}
	
	@RequestMapping("/demo/demo3.do")
	public String demo3(Model model, Dev dev) {
		
		
		System.out.println("demo3메소드가 요청되었습니다.");
		System.out.println("dev@demo3()@DemoController = " + dev);
		
		model.addAttribute("dev", dev);
		
		// 리턴할 페이지를 적어준다.
		return "demo/demoResult"; // /WEB-INF/views/demo/demoResult.jsp
	}
	
	// value와 method 둘 다 배열이다.
	@RequestMapping(value= "/demo/insertDev.do", method= RequestMethod.POST)
	public String insertDev(Dev dev) {
		// 업무로직
		
		int result = demoService.insertDev(dev);
		
		System.out.println("insertDev메소드가 요청되었습니다.");
		System.out.println(result > 0? "등록성공":"등록실패");
		
		return "redirect:/demo/demoList.do";
	}
	
	@RequestMapping("/demo/demoList.do")
	public String selectDemoList(Model model) {
		
		List<Dev> list = demoService.selectDemoList();
		model.addAttribute("list", list);
		
		System.out.println("selectDemoList메소드가 요청되었습니다.");
		System.out.println("dev@selectDemoList()@DemoController = " + list);
		
		return "demo/demoList";
	}
	
	@RequestMapping(value= "/demo/deleteDev.do", method= RequestMethod.GET)
	public String deleteDev(String no) {

		int result = demoService.deleteDev(no);
		
		System.out.println("deleteDev메소드가 요청되었습니다.");
		System.out.println(result > 0? "삭제성공":"삭제실패");
		
		return "redirect:/demo/demoList.do";
	}
}
