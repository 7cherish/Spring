package com.kh.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;


@Controller
public class MemberController {
   
   @Autowired
   MemberService memberService ;
   
   @RequestMapping("/member/memberEnroll.do")
   public String MemberEnroll() {
      return "member/memberEnroll";
      //리턴할 페이지 경로
   }
   
   @RequestMapping("/member/memberEnrollEnd.do")
      public String MemberEnrollEnd(Model model , Member m) {
      
      int result = memberService.insertMember(m);
      System.out.println(result > 0?"등록성공":"등록실패");
         
      return "redirect:/";
      }
      
   
}