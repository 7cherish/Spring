package com.kh.spring.memo.controller;

import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.memo.model.service.MemoService;
import com.kh.spring.memo.model.vo.Memo;

@Controller
public class MemoController {
	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	MemoService memoService;
	
	@RequestMapping("/memo/memo.do")
	public ModelAndView memo(ModelAndView mav) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("메모 요청!");
		}
		mav.setViewName("/memo/memo");
		
		List<Memo> list = memoService.memoList();
		
		mav.addObject("list", list); // mav.addObject("변수 이름", "뷰로 보낼 데이터 값");
		
		return mav; // ModelAndView 객체를 반환한다.
	}
	
	@RequestMapping("/memo/insertMemo.do")
	public ModelAndView insertMemo(Memo memo, ModelAndView mav) {
		
		int result = memoService.insertMemo(memo);
		
		System.out.println("result@insertMemo@MemberController = " + result);
		
		// 2. 처리결과에 따라 view단 분기처리
		String loc = "/";
		String msg = "";
		String view = "common/msg";
		if (result > 0) {
			msg = "메모등록성공!";
			loc = "/memo/memo.do";
			
		} else {
			msg = "메모등록실패";
			loc = "/memo/memo.do";
		}
		
		mav.addObject("msg", msg); // mav.addObject("변수 이름", "뷰로 보낼 데이터 값");
		mav.addObject("loc", loc); // mav.addObject("변수 이름", "뷰로 보낼 데이터 값");
		mav.setViewName(view); // mav.setViewName("뷰의 경로");
		
		return mav;
	}
}
