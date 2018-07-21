package com.yolo.model;

import java.util.Date;

public class Chat_groupVO {
	private int group_seq;
	private int chat_seq;
	private String mem_id;
	private Date mem_outtm;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public Date getMem_outtm() {
		return mem_outtm;
	}
	public void setMem_outtm(Date mem_outtm) {
		this.mem_outtm = mem_outtm;
	}
	
	public int getGroup_seq() {
		return group_seq;
	}
	public void setGroup_seq(int group_seq) {
		this.group_seq = group_seq;
	}
	public int getChat_seq() {
		return chat_seq;
	}
	public void setChat_seq(int chat_seq) {
		this.chat_seq = chat_seq;
	}
	
	public Chat_groupVO() {
		super();
	}

	public Chat_groupVO(int group_seq, int chat_seq, String mem_id,
			Date mem_outtm) {
		super();
		this.group_seq = group_seq;
		this.chat_seq = chat_seq;
		this.mem_id = mem_id;
		this.mem_outtm = mem_outtm;
	}
	@Override
	public String toString() {
		return "Chat_groupVO [group_seq=" + group_seq + ", chat_seq="
				+ chat_seq + ", mem_id=" + mem_id + ", mem_outtm=" + mem_outtm
				+ "]";
	}
	
}
