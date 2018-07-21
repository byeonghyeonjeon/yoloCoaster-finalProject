package com.yolo.model;

public class ChattingRoomVO {
	private int chat_seq;
	private int messageCount;
	private String name;
	
	public int getChat_seq() {
		return chat_seq;
	}
	public void setChat_seq(int chat_seq) {
		this.chat_seq = chat_seq;
	}
	public int getMessageCount() {
		return messageCount;
	}
	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ChattingRoomVO(int chat_seq, int messageCount, String name) {
		super();
		this.chat_seq = chat_seq;
		this.messageCount = messageCount;
		this.name = name;
	}

	public ChattingRoomVO() {
		super();
	}
	
	@Override
	public String toString() {
		return "ChattingRoomVO [chat_seq=" + chat_seq + ", messageCount="
				+ messageCount + ", name=" + name + "]";
	}
}
