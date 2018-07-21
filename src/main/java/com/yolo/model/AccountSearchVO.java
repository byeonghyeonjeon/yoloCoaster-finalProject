/**
 * 
 */
package com.yolo.model;

/**
 * @author PC15
 *
 */
/**
 * @author PC15
 *
 */
public class AccountSearchVO {
	private int chat_seq;
	private String accountSearchStart;
	private String accountSearchEnd;
	private String selectContent;
	private String searchAccountText;
	@Override
	public String toString() {
		return "AccountSearchVO [chat_seq=" + chat_seq
				+ ", accountSearchStart=" + accountSearchStart
				+ ", accountSearchEnd=" + accountSearchEnd + ", selectContent="
				+ selectContent + ", searchAccountText=" + searchAccountText
				+ "]";
	}
	/**
	 * @return the chat_seq
	 */
	public int getChat_seq() {
		return chat_seq;
	}
	/**
	 * @param chat_seq the chat_seq to set
	 */
	public void setChat_seq(int chat_seq) {
		this.chat_seq = chat_seq;
	}
	/**
	 * @return the accountSearchStart
	 */
	public String getAccountSearchStart() {
		return accountSearchStart;
	}
	/**
	 * @param accountSearchStart the accountSearchStart to set
	 */
	public void setAccountSearchStart(String accountSearchStart) {
		this.accountSearchStart = accountSearchStart;
	}
	/**
	 * @return the accountSearchEnd
	 */
	public String getAccountSearchEnd() {
		return accountSearchEnd;
	}
	/**
	 * @param accountSearchEnd the accountSearchEnd to set
	 */
	public void setAccountSearchEnd(String accountSearchEnd) {
		this.accountSearchEnd = accountSearchEnd;
	}
	public String getSelectContent() {
		return selectContent;
	}
	/**
	 * @param selectContent the selectContent to set
	 */
	public void setSelectContent(String selectContent) {
		this.selectContent = selectContent;
	}
	/**
	 * @return the searchAccountText
	 */
	public String getSearchAccountText() {
		return searchAccountText;
	}
	/**
	 * @param searchAccountText the searchAccountText to set
	 */
	public void setSearchAccountText(String searchAccountText) {
		this.searchAccountText = searchAccountText;
	}
	/**
	 * @param chat_seq
	 * @param accountSearchStart
	 * @param accountSearchEnd
	 * @param selectContent
	 * @param searchAccountText
	 */
	public AccountSearchVO(int chat_seq, String accountSearchStart,
			String accountSearchEnd, String selectContent,
			String searchAccountText) {
		super();
		this.chat_seq = chat_seq;
		this.accountSearchStart = accountSearchStart;
		this.accountSearchEnd = accountSearchEnd;
		this.selectContent = selectContent;
		this.searchAccountText = searchAccountText;
	}
	
	public AccountSearchVO(){
		super();
	};
	

}
