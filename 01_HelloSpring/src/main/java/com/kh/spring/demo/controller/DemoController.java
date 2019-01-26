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
	
	/*
	 * @RequestMapping("/demo/demo2.do")
	 * public String demo2(HttpServletRequest request,
	 * 					   @RequestParam(value="devName" String devName,
	 * 					   @RequestParam(value-"devAge" int devAge,
	 * 					   @RequestParam(value-"devEmail" String devEmail,
	 * 					   @RequestParam(value-"devGender" String devGender,
	 * 					   @RequestParam(value-"devLang" String[] devLang){
	 * 
	 * Dev dev = new Dev(0, devName, devAge, devEmail, devGender, devLang);
	 * 
	 * request.setAttribute("dev", dev);
	 * 
	 * System.out.println("demo2메소드가 요청되었습니다.");
	 * System.out.println("dev@demo2()@DemoController = " + dev);
	 * 
	 * // 리턴할 페이지를 적어준다.
	 * return "demo/demoResult"; // /WEB-INF/views/demo/demoResult.jsp
	 * 
	 * }
	 * 
	 * 
	 * */
	
	/* 
	 * @RequestParam(value="devName")에 전송된 값을 String devName에 담아라)
	 * RequestParam으로 지정한 것은 반드시 value가 있어야 한다.
	 * required 속성의 기본값은 true이다.
	 * false로 해야 value가 없어도 에러가 발생하지 않는다.
	 * 
	 * defaultValue : 값이 없다면 이것으로 대체
	 * 
	 * Spring에서는 HttpServletRequest 대신 Model을 많이 사용한다.
	 */
	@RequestMapping("/demo/demo2.do")
	public String demo2(Model model, 
						@RequestParam(value="devName", required=false) String devName,
						@RequestParam(value="devAge", defaultValue="30") int devAge,
						@RequestParam(value="devEmail") String devEmail,
						@RequestParam(value="devGender") String devGender,
						@RequestParam(value="devLang") String[] devLang) {
		
		Dev dev = new Dev(0, devName, devAge, devEmail, devGender, devLang);
		
		model.addAttribute("dev", dev);
		
		System.out.println("demo2메소드가 요청되었습니다.");
		System.out.println("dev@demo2()@DemoController = " + dev);
		
		// 리턴할 페이지를 적어준다.
		return "demo/demoResult"; // /WEB-INF/views/demo/demoResult.jsp
		
	}
	
	// Model에 담아도 HttpServletRequest와 마찬가지로 EL로 접근할 수 있다.
	@RequestMapping("/demo/demo3.do")
	public String demo3(Model model, Dev dev) {
		
		
		System.out.println("demo3메소드가 요청되었습니다.");
		System.out.println("dev@demo3()@DemoController = " + dev);
		
		model.addAttribute("dev", dev);
		
		// 리턴할 페이지를 적어준다.
		return "demo/demoResult"; // /WEB-INF/views/demo/demoResult.jsp
	}
	
	/* 
	 * value와 method 둘 다 배열이다.
	 * method= RequestMethod.POST  POST만 받는다. URL로 접근하면 에러
	 * 
	 * Dev dev 커맨드 객체
	 * 커맨드 패턴(Command pattern)이란 
	 * 요청을 객체의 형태로 캡슐화하여 사용자가 보낸 요청을 나중에 이용할 수 있도록 
	 * 매서드 이름, 매개변수 등 요청에 필요한 정보를 저장 또는 로깅, 취소할 수 있게 하는 패턴이다.
	*/
	@RequestMapping(value= "/demo/insertDev.do", method= RequestMethod.POST)
	public String insertDev(Dev dev) {
		// 업무로직
		int result = demoService.insertDev(dev);
		
		System.out.println("insertDev메소드가 요청되었습니다.");
		System.out.println(result > 0? "등록성공":"등록실패");
		
		// 리다이렉트 하는 법 : redirect: 하고 다음 요청 주소를 적으면 된다. /는 인덱스
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
	
<<<<<<< HEAD
	@RequestMapping("/demo/deleteDev.do")
	public String deleteDev(String no) {
		// 업무로직
		int result = demoService.deleteDev(no);
		
		System.out.println("deleteDev메소드가 요청되었습니다.");
		System.out.println(result > 0? "삭제성공":"삭제실패");
		
		return "redirect:/demo/demoList.do";
	}
	
	@RequestMapping("/demo/updateDev.do")
	public String updateDev(String no) {
		// 업무로직
		
		
		return "";
	}
=======
	@RequestMapping(value="/demo/deleteDev.do", method=RequestMethod.GET)
	public String deleteDev(Model model,
							@RequestParam(value="devNo") int devNo) {
		
		demoService.deleteDev();
		
		System.out.println("deleteDev메소드가 요청되었습니다.");
		
		return "demo/demoList";
	}
	
>>>>>>> 8329c54fb4bea34ecdff0fe34dabe928e0ebf8c2
}
