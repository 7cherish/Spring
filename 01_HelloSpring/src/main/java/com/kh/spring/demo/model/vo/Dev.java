package com.kh.spring.demo.model.vo;

import java.io.Serializable;
import java.util.Arrays;

public class Dev implements Serializable{
	
	// DB할때 char타입은 되도록 안 쓰는게 좋다.
	// 나중에 형변환할때 다 스트링으로 들어가기 때문이다.
	
    private static final long serialVersionUID = 1L;
    
	private int devNo;
	private String devName;
	private int devAge;
	private String devEmail;
	private String devGender;
	private String[] devLang;

	public Dev() {
		super();
	}
	
	public Dev(int devNo, String devName, int devAge, String devEmail, String devGender, String[] devLang) {
		super();
		this.devNo = devNo;
		this.devName = devName;
		this.devAge = devAge;
		this.devEmail = devEmail;
		this.devGender = devGender;
		this.devLang = devLang;
	}
	
	
	public int getDevNo() {
		return devNo;
	}
	public void setDevNo(int devNo) {
		this.devNo = devNo;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public int getDevAge() {
		return devAge;
	}
	public void setDevAge(int devAge) {
		this.devAge = devAge;
	}
	public String getDevEmail() {
		return devEmail;
	}
	public void setDevEmail(String devEmail) {
		this.devEmail = devEmail;
	}
	public String getDevGender() {
		return devGender;
	}
	public void setDevGender(String devGender) {
		this.devGender = devGender;
	}
	public String[] getDevLang() {
		return devLang;
	}
	public void setDevLang(String[] devLang) {
		this.devLang = devLang;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "[devNo=" + devNo + ", devName=" + devName + ", devAge=" + devAge + ", devEmail=" + devEmail
				+ ", devGender=" + devGender + ", devLang=" + Arrays.toString(devLang) + "]";
	}
	
	
	
}
