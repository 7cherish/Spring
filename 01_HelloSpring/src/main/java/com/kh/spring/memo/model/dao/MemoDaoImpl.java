package com.kh.spring.memo.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.memo.model.vo.Memo;

@Repository
public class MemoDaoImpl implements MemoDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<Memo> memoList() {
		List<Memo> list = sqlSession.selectList("memo.selectList");
		return list;
	}

	@Override
	public int insertMemo(Memo memo) {
		int result = sqlSession.insert("memo.insertMemo", memo);
		return result;
	}

	@Override
	public int deleteMemo(Map<String, String> map) {
		return sqlSession.delete("memo.deleteMemo", map);
	}

}
