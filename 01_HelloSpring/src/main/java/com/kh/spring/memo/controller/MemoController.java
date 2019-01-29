package com.kh.spring.memo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.memo.model.service.MemoService;
import com.kh.spring.memo.model.vo.Memo;

@Controller
public class MemoController {
	Logger logger = Logger.getLogger(getClass());
	
	@Autowired(required=false)
	MemoService memoService;
	
	@RequestMapping("/memo/memo.do")
	public ModelAndView memo(ModelAndView mav) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("메모 요청!");
		}
		mav.setViewName("/memo/memo");
		/* Memo m = memoService.selectOneMemo(mav.addObject("memoNo")); */
		
		
		return mav; // ModelAndView 객체를 반환한다.
	}
	
	@RequestMapping("/memo/insertMemo.do")
	public String insertMemo(@RequestParam String memo, HttpSession session) {
		
		
		return "redirect:/";
	}
}
