package com.kh.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.board.model.exception.BoardException;
import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Attachment;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.common.util.Utils;

@Controller
public class BoardController {

	Logger logger = Logger.getLogger(getClass());

	@Autowired
	BoardService boardService;

	@RequestMapping("/board/boardList.do")
	public ModelAndView selectBoardList(@RequestParam(value = "cPage", defaultValue = "1") int cPage,
			ModelAndView mav) {

		if (logger.isDebugEnabled()) {
			logger.debug("게시판 목록페이지");
		}

		int numPerPage = 10;

		// 업무로직
		// 1. 게시글리스트 (페이징 적용된 것)
		System.out.println(cPage);
		List<Map<String, String>> list = boardService.selectBoardList(cPage, numPerPage);

		// 2. 전체컨텐츠수
		int totalContents = boardService.selectBoardTotalContents();

		mav.addObject("list", list);
		mav.addObject("cPage", cPage);
		mav.addObject("numPerPage", numPerPage);
		mav.addObject("totalContents", totalContents);

		mav.setViewName("board/boardList");

		return mav;
	}

	@RequestMapping("/board/boardForm.do")
	public void boardForm() {
		// void로 했을때 ViewTranslator (스프링컨테이너에서 제공) 에서
		// 요청 url로부터 view단파일경로를 유추(jsp파일)
	}

	@RequestMapping("/board/insertBoard.do")
	public ModelAndView insertBoard(Board board,
			@RequestParam(name = "upFile", required = false) MultipartFile[] upFiles, HttpServletRequest request,
			ModelAndView mav) {
		logger.debug("board = " + board);
		logger.debug("fileName1 = " + upFiles[0].getOriginalFilename());
		logger.debug("size1 = " + upFiles[0].getSize());
		logger.debug("fileName2 = " + upFiles[1].getOriginalFilename());
		logger.debug("size2 = " + upFiles[1].getSize());

		try {
			// 1. 파일업로드 (실제경로를 얻어내는 방법은 세션-서블릿-리얼패스)
			String saveDirectory = request.getSession().getServletContext().getRealPath("/resources/upload/board");

			logger.debug("saveDirectory = " + saveDirectory);

			List<Attachment> attachList = new ArrayList<>();

			// MultipartFile 처리
			for (MultipartFile f : upFiles) {
				if (!f.isEmpty()) {
					// 사용자가 업로드한 파일명 구하기
					String originalFileName = f.getOriginalFilename();

					// 서버저장용 파일명
					String renamedFileName = Utils.getRenamedFileName(originalFileName);
					logger.debug("renamedFileName = " + renamedFileName);

					// 실제서버에 파일저장
					try {
						f.transferTo(new File(saveDirectory + "/" + renamedFileName));
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}

					// 첨부파일객체 생성. 리스트 추가
					Attachment attach = new Attachment();
					attach.setOriginalFileName(originalFileName);
					attach.setRenamedFileName(renamedFileName);
					attachList.add(attach);
				}
			}

			// 2. 업무로직
			int result = boardService.insertBoard(board, attachList);

			// 3. view단 처리
			String loc = "/board/boardList.do";
			String msg = "";

			if (result > 0) {
				msg = "게시물 등록 성공!";
			} else {
				msg = "게시물 등록 실패";
			}

			mav.addObject("msg", msg);
			mav.addObject("loc", loc);
			mav.setViewName("common/msg");

		} catch (Exception e) {
			logger.error("게시물 등록 에러", e);
			throw new BoardException("게시물 등록 에러", e);
		}
		return mav;
	}
	
	@RequestMapping("/board/boardView.do")
	public void boardView() {
		
	}
}