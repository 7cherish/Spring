package com.kh.spring.memo.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.spring.memo.model.vo.Memo;

public interface MemoDao {

	List<Memo> memoList();

	int insertMemo(Memo memo);

	int deleteMemo(Map<String, String> map);


}
