/**
 * 
 */
package com.yolo.model;

/**
* Star_scoreVO.java
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
public class Star_scoreVO {
	private int score_seq;
	private String contentid;
	private int score_point;
	private String score_mem_id;
	
	public int getScore_seq() {
		return score_seq;
	}
	public void setScore_seq(int score_seq) {
		this.score_seq = score_seq;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public int getScore_point() {
		return score_point;
	}
	public void setScore_point(int score_point) {
		this.score_point = score_point;
	}
	public String getScore_mem_id() {
		return score_mem_id;
	}
	public void setScore_mem_id(String score_mem_id) {
		this.score_mem_id = score_mem_id;
	}
	public Star_scoreVO() {
		super();
	}
	
	@Override
	public String toString() {
		return "Star_scoreVO [score_seq=" + score_seq + ", contentid="
				+ contentid + ", score_point=" + score_point
				+ ", score_mem_id=" + score_mem_id + "]";
	}	
	
	
}
