package com.kh.spring.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao{
   
   @Autowired SqlSessionTemplate sqlSession ;

   @Override
   public int insertMember(Member member) {
      System.out.println("member"+ member);
      int result = sqlSession.insert("member.insertMember" , member);
      return result;
   }
   
   
      
}