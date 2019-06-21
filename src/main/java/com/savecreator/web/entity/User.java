package com.savecreator.web.entity;

public class User {
	private String idx;
	private String pwd;
	private String email;
	private String phoneNm;
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNm() {
		return phoneNm;
	}
	public void setPhoneNm(String phoneNm) {
		this.phoneNm = phoneNm;
	}
	@Override
	public String toString() {
		return "User [idx=" + idx + ", pwd=" + pwd + ", email=" + email + ", phoneNm=" + phoneNm + "]";
	}
	
}
