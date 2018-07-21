/**
 * 
 */
package com.yolo.model;

/**
* PboardVO.java
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
public class PboardVO {
	
	private int pboard_seq;		//게시판 시퀀시
	private String pboard_name;	//게시판 이름
	private String pboard_st;	//게시판 사용여부
	
	public PboardVO() {
		super();
	}
	
	public PboardVO(int pboard_seq, String pboard_name, String pboard_st) {
		super();
		this.pboard_seq = pboard_seq;
		this.pboard_name = pboard_name;
		this.pboard_st = pboard_st;
	}
	@Override
	public String toString() {
		return "PboardVO [pboard_seq=" + pboard_seq + ", pboard_name=" + pboard_name + ", pboard_st=" + pboard_st + "]";
	}
	public int getPboard_seq() {
		return pboard_seq;
	}
	public void setPboard_seq(int pboard_seq) {
		this.pboard_seq = pboard_seq;
	}
	public String getPboard_name() {
		return pboard_name;
	}
	public void setPboard_name(String pboard_name) {
		this.pboard_name = pboard_name;
	}
	public String getPboard_st() {
		return pboard_st;
	}
	public void setPboard_st(String pboard_st) {
		this.pboard_st = pboard_st;
	}
	
}
