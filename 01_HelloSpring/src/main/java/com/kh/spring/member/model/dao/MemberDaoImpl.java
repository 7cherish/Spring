package com.kh.spring.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public int insertMember(Member member) {
		System.out.println("member@insertMember@MemberDaoImpl = " + member);
		int result = sqlSession.insert("member.insertMember", member);
		return result;
	}

	@Override
	public Member selectMember(String memberId) {
		System.out.println("memberId@selectMember@MemberDaoImpl = " + memberId);
		Member m = (Member) sqlSession.selectOne("member.selectOneMember", memberId);
		return m;
	}

	@Override
	public int updateMember(Member m) {
		System.out.println("m@updateMember@MemberDaoImpl = " + m);
		int result = sqlSession.update("member.updateMember", m);
		return result;
	}

}