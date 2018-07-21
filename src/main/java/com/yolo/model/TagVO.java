/**
 * 
 */
package com.yolo.model;

/**
* TagVO.java
*
* @author PC09
* @since 2018. 6. 13.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 6. 13. PC09 최초 생성
*
* </pre>
*/
public class TagVO {
	private int tag_seq;
	private int main_board_seq;
	private String contentid;
	private String tag_content;
	
	@Override
	public String toString() {
		return "TagVO [tag_seq=" + tag_seq + ", main_board_seq="
				+ main_board_seq + ", contentid=" + contentid
				+ ", tag_content=" + tag_content + "]";
	}
	public int getTag_seq() {
		return tag_seq;
	}
	public void setTag_seq(int tag_seq) {
		this.tag_seq = tag_seq;
	}
	public int getMain_board_seq() {
		return main_board_seq;
	}
	public void setMain_board_seq(int main_board_seq) {
		this.main_board_seq = main_board_seq;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getTag_content() {
		return tag_content;
	}
	public void setTag_content(String tag_content) {
		this.tag_content = tag_content;
	}
	/**
	 * 
	 */
	public TagVO() {
		super();
	}
	public TagVO(int tag_seq, int main_board_seq, String contentid, String tag_content) {
		super();
		this.tag_seq = tag_seq;
		this.main_board_seq = main_board_seq;
		this.contentid = contentid;
		this.tag_content = tag_content;
	}
	
	
	
}
