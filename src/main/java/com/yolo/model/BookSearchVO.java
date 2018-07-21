/**
 * 
 */
package com.yolo.model;

/**
 * @author PC15
 *
 */
public class BookSearchVO {
	
	private String selectMonth;   
	private String selectInOut;   
	private String selectContent; 
	private String searchText;
	private int chat_seq;
	
	
	public int getChat_seq() {
		return chat_seq;
	}

	public void setChat_seq(int chat_seq) {
		this.chat_seq = chat_seq;
	}

	public BookSearchVO(){
		super();
	}
	
	public BookSearchVO(String selectMonth, String selectInOut,
			String selectContent, String searchText, int chat_seq) {
		super();
		this.chat_seq = chat_seq;
		this.selectMonth = selectMonth;
		this.selectInOut = selectInOut;
		this.selectContent = selectContent;
		this.searchText = searchText;
	}
	@Override
	public String toString() {
		return "BookSearchVO [selectMonth=" + selectMonth + ", selectInOut="
				+ selectInOut + ", selectContent=" + selectContent
				+ ", searchText=" + searchText
				+ ", selectContent=" + selectContent + "]";
	}
	public String getSelectMonth() {
		return selectMonth;
	}
	public void setSelectMonth(String selectMonth) {
		this.selectMonth = selectMonth;
	}
	public String getSelectInOut() {
		return selectInOut;
	}
	public void setSelectInOut(String selectInOut) {
		this.selectInOut = selectInOut;
	}
	public String getSelectContent() {
		return selectContent;
	}
	public void setSelectContent(String selectContent) {
		this.selectContent = selectContent;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	

}
