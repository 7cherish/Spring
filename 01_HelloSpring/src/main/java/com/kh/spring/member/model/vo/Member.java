package com.kh.spring.member.model.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

public class Member implements Serializable{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   
   // 웹서버 프로그래밍 진행할 때 
   // 1. DB 컬럼명 (mybatis에서 카멜케이싱 자동으로 바꿔주는 설정으로 대소문자 구분하지 않고 _ 써도 해결 가능하다.)
   // 2. VO 필드명
   // 3. form의 name값을 같게 한다.
   private String memberId;
   private String password;
   private String memberName;
   private String gender;
   private int age ;
   private String email;
   private String phone;
   private String address;
   private String[] hobby;
   private Date enrollDate;
   
   public Member() {
      super();
   }

   public Member(String memberId, String password, String memberName, String gender, int age, String email,
         String phone, String address, String[] hobby, Date enrollDate) {
      super();
      this.memberId = memberId;
      this.password = password;
      this.memberName = memberName;
      this.gender = gender;
      this.age = age;
      this.email = email;
      this.phone = phone;
      this.address = address;
      this.hobby = hobby;
      this.enrollDate = enrollDate;
   }

   public String getMemberId() {
      return memberId;
   }

   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getMemberName() {
      return memberName;
   }

   public void setMemberName(String memberName) {
      this.memberName = memberName;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String[] getHobby() {
      return hobby;
   }

   public void setHobby(String[] hobby) {
      this.hobby = hobby;
   }

   public Date getEnrollDate() {
      return enrollDate;
   }

   public void setEnrollDate(Date enrollDate) {
      this.enrollDate = enrollDate;
   }

   @Override
   public String toString() {
      return "[memberId=" + memberId + ", password=" + password + ", memberName=" + memberName + ", gender="
            + gender + ", age=" + age + ", email=" + email + ", phone=" + phone + ", address=" + address
            + ", hobby=" + Arrays.toString(hobby) + ", enrollDate=" + enrollDate + "]";
   }
   
   
   
   
}