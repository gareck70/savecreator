package com.savecreator.web.entity;

public class List {
	private int no;
	private String title;
	private String content;
	private String wrtierId;
	private String regdate;
	private int hit;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWrtierId() {
		return wrtierId;
	}
	public void setWrtierId(String wrtierId) {
		this.wrtierId = wrtierId;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	@Override
	public String toString() {
		return "List [no=" + no + ", title=" + title + ", content=" + content + ", wrtierId=" + wrtierId + ", regdate="
				+ regdate + ", hit=" + hit + "]";
	}
	
}
