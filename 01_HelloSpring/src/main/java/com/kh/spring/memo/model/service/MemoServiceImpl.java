package com.kh.spring.memo.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.memo.model.dao.MemoDao;
import com.kh.spring.memo.model.vo.Memo;

@Service
public class MemoServiceImpl implements MemoService {
	
	@Autowired
	MemoDao memoDao;


}
