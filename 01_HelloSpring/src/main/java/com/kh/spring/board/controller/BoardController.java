package com.kh.spring.board.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.board.model.service.BoardService;


@Controller
public class BoardController {

	Logger logger = Logger.getLogger(getClass());

	@Autowired
	BoardService boardService;
	
	@RequestMapping("/board/boardList.do")
	public ModelAndView selectBoardList(@RequestParam(value = "cPage", defaultValue = "1") 
										int cPage,
										ModelAndView mav) {

		if (logger.isDebugEnabled()) {
			logger.debug("게시판 목록페이지");
		}
		
		int numPerPage = 10;
		
		// 업무로직
		// 1. 게시글리스트 (페이징 적용된 것)
		List<Map<String, String>> list = boardService.selectBoardList(cPage, numPerPage);
		
		// 2. 전체컨텐츠수
		mav.addObject("list", list);
		mav.setViewName("board/boardList");

		return mav;
	}
}