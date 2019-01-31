package com.kh.spring.memo.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.memo.model.dao.MemoDao;
import com.kh.spring.memo.model.vo.Memo;

@Service
public class MemoServiceImpl implements MemoService {
	
	@Autowired
	MemoDao memoDao;

	@Override
	public List<Memo> memoList() {
		return memoDao.memoList();
	}

	@Override
	public int insertMemo(Memo memo) {
		return memoDao.insertMemo(memo);
	}

	@Override
	public int deleteMemo(Map<String, String> map) {
		return memoDao.deleteMemo(map);
	}




}
