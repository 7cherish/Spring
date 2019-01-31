package com.kh.spring.memo.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.memo.model.vo.Memo;

public interface MemoService {

	List<Memo> memoList();

	int insertMemo(Memo memo);

	int deleteMemo(Map<String, String> map);



}
