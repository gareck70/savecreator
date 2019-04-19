package com.savecreator.web.entity;

public class BoardReply {
	private String replyId;
	private String boardId;
	private int depth;
	private String reply_content;
	private String reply_writer;
	private String password;
	private String registerDatetime;
	@Override
	public String toString() {
		return "BoardReply [replyId=" + replyId + ", boardId=" + boardId + ", depth=" + depth + ", reply_content="
				+ reply_content + ", reply_writer=" + reply_writer + ", password=" + password + ", registerDatetime="
				+ registerDatetime + "]";
	}
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
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_writer() {
		return reply_writer;
	}
	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
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
}
