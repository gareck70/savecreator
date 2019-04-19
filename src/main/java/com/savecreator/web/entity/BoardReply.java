package com.savecreator.web.entity;

public class BoardReply {
	private String replyId;
	private String boardId;
	private int depth;
	private String replyContent;
	private String replyWriter;
	private String password;
	private String registerDatetime;
	public String getReplyId() {
		return replyId;
	}
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegisterDatetime() {
		return registerDatetime;
	}
	public void setRegisterDatetime(String registerDatetime) {
		this.registerDatetime = registerDatetime;
	}
	@Override
	public String toString() {
		return "BoardReply [replyId=" + replyId + ", boardId=" + boardId + ", depth=" + depth + ", replyContent="
				+ replyContent + ", replyWriter=" + replyWriter + ", password=" + password + ", registerDatetime="
				+ registerDatetime + "]";
	}

	
}
	
	
	