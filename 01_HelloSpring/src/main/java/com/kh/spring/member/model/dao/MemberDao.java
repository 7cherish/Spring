package com.kh.spring.member.model.dao;

import com.kh.spring.member.model.vo.Member;

public interface MemberDao {

	int insertMember(Member m);

	Member selectMember(String memberId);

	int updateMember(Member m);

}