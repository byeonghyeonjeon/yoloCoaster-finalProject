/**
 * 
 */
package com.yolo.model;

import java.util.List;

public class Content_detailVO {

	private int content_seq;
	private int detail_seq;
	private String content_title;
	private int content_order;
	private String content_shape;
	private String content_content;

	public Content_detailVO() {
		super();
	}

	public Content_detailVO(int content_seq, int detail_seq,
			String content_title, int content_order, String content_shape,
			String content_content) {
		super();
		this.content_seq = content_seq;
		this.detail_seq = detail_seq;
		this.content_title = content_title;
		this.content_order = content_order;
		this.content_shape = content_shape;
		this.content_content = content_content;
	}

	public int getContent_seq() {
		return content_seq;
	}

	public void setContent_seq(int content_seq) {
		this.content_seq = content_seq;
	}

	public int getDetail_seq() {
		return detail_seq;
	}

	public void setDetail_seq(int detail_seq) {
		this.detail_seq = detail_seq;
	}

	public String getContent_title() {
		return content_title;
	}

	public void setContent_title(String content_title) {
		this.content_title = content_title;
	}

	public int getContent_order() {
		return content_order;
	}

	public void setContent_order(int content_order) {
		this.content_order = content_order;
	}

	public String getContent_shape() {
		return content_shape;
	}

	public void setContent_shape(String content_shape) {
		this.content_shape = content_shape;
	}

	public String getContent_content() {
		return content_content;
	}

	public void setContent_content(String content_content) {
		this.content_content = content_content;
	}

	@Override
	public String toString() {
		return "Content_detailVO [content_seq=" + content_seq + ", detail_seq="
				+ detail_seq + ", content_title=" + content_title
				+ ", content_order=" + content_order + ", content_shape="
				+ content_shape + ", content_content=" + content_content + "]";
	}

}
