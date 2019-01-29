package com.kh.spring.memo.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Memo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int memono;
	private String memo;
	private String password;
	private Date memodate;
	
	public Memo() {
		super();
	}

	public Memo(int memono, String memo, String password, Date memodate) {
		super();
		this.memono = memono;
		this.memo = memo;
		this.password = password;
		this.memodate = memodate;
	}

	public int getMemono() {
		return memono;
	}

	public void setMemono(int memono) {
		this.memono = memono;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getMemodate() {
		return memodate;
	}

	public void setMemodate(Date memodate) {
		this.memodate = memodate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "[memono=" + memono + ", memo=" + memo + ", password=" + password + ", memodate=" + memodate + "]";
	}
	
	
	
	
	
	

}
