package com.kh.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 * 스프링 FrameWork의 특징
 * - IOC Inversion Of Control 제어의 역전 : 개발자가 직접 구현했던 것들을 프레임워크로 가져간것.
 * 											그만큼 개발자가 할 일이 없다. 인수인계 용이하다.
 * - DI Dependency Injection 의존주입 : 멤버 컨트롤러를 하나 만들었는데 필요한 것이 멤버 서비스라는 객체였다. 
 * 										DB 업무로직을 처리하기 위해서. 
 * 										이제는 멤버 서비스를 뭘 대입하지 않고 필드로 선언만 할 것이다. 
 * 										여태까지 했던 멤버서비스 = new 멤버서비스 이런게 사라진다. 
 * 										이걸 프레임워크쪽에서 자동으로 넣어준다. 
 * 										그걸 이제 DI라고 한다. 
 * 										멤버 컨트롤러는 멤버 서비스 없이는 아무 일도 못한다. 
 * 										업무로직 요청을 못하기 때문에. 제어가 역전된거다. 
 * 										멤버서비스 - 멤버서비스타입의 m이란 변수에 뉴 멤버서비스로 객체를 만들어 넣었는데 
 * 										이제는 그럴 필요가 없다.
 * IOC와 DI는 따라 다니는 개념이다. 같은 맥락에서 이해하면 좋다.
 * 
 * - AOP Aspect Oriented Programming 관점지향프로그래밍 : 공통된 업무들을 별도로 빼서 처리하는 것이다. 
 * 														  예를 들면 서버쪽에 기록을 남기는 작업을 별도로 관리한다.
 * 
 * 위의 세 개는 필수로 알고 있어야 한다.
 * 
 * - POJO Plain Old Java Object 평범하고 늙은 자바 객체. <-> ejb 예전 기업용 프레임워크.
 * - PSA Portable Service Abstraction 추상화된 제어 : 예를 들면 JDK에도 로깅을 지원하는 프레임워크가 있다. 
 * 													  당신이 뭘 사용하던지간에 log4j를 사용하든 다른 로깅프레임워크를 사용하든 
 * 													  이것을 상위레벨에서 제어할 수 있다는 것이다. 
 * 
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// @RequestMapping에 적혀있는걸로 하위 메소드들을 연결시켜달라.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// 로깅용으로 콘솔에 찍는 것
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		// 기존 request나 session의 setAttribute와 비슷하다.
		// model이 대신 해주는거라고 생각하면 된다.
		model.addAttribute("serverTime", formattedDate );
		
		// 따로 view단 처리가 없다.
		
		return "home";
	}
	
}
