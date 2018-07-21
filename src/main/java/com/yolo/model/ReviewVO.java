/**
 * 
 */
package com.yolo.model;

import java.util.List;

/**
* ReviewVOv.java
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
public class ReviewVO {

	private int review_seq;
	private String contentid;
	private String review_title;
	private String review_content;
	private String review_mem_id;
	private String review_dt;
	private String mem_profile;
	private List<File_addVO> review_imgList;
	private List<TagVO> review_tagList;
	
	public List<TagVO> getReview_tagList() {
		return review_tagList;
	}
	public void setReview_tagList(List<TagVO> review_tagList) {
		this.review_tagList = review_tagList;
	}
	public List<File_addVO> getReview_imgList() {
		return review_imgList;
	}
	public void setReview_imgList(List<File_addVO> review_imgList) {
		this.review_imgList = review_imgList;
	}
	public String getMem_profile() {
		return mem_profile;
	}
	public void setMem_profile(String mem_profile) {
		this.mem_profile = mem_profile;
	}
	public int getReview_seq() {
		return review_seq;
	}
	public void setReview_seq(int review_seq) {
		this.review_seq = review_seq;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getReview_title() {
		return review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public String getReview_mem_id() {
		return review_mem_id;
	}
	public void setReview_mem_id(String review_mem_id) {
		this.review_mem_id = review_mem_id;
	}
	public String getReview_dt() {
		return review_dt;
	}
	public void setReview_dt(String review_dt) {
		this.review_dt = review_dt;
	}
	/**
	 * Method : toString
	 * 최초작성일 : 2018. 7. 13.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return
	 * Method 설명 :
	 */
	@Override
	public String toString() {
		return "ReviewVO [review_seq=" + review_seq + ", contentid="
				+ contentid + ", review_title=" + review_title
				+ ", review_content=" + review_content + ", review_mem_id="
				+ review_mem_id + ", review_dt=" + review_dt + ", mem_profile="
				+ mem_profile + ", review_imgList=" + review_imgList
				+ ", review_tagList=" + review_tagList + "]";
	}
	
	public ReviewVO(int review_seq, String contentid, String review_title,
			String review_content, String review_mem_id, String review_dt,
			String mem_profile, List<File_addVO> review_imgList,
			List<TagVO> review_tagList) {
		super();
		this.review_seq = review_seq;
		this.contentid = contentid;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_mem_id = review_mem_id;
		this.review_dt = review_dt;
		this.mem_profile = mem_profile;
		this.review_imgList = review_imgList;
		this.review_tagList = review_tagList;
	}
	
	public ReviewVO() {
		super();
	}
	
	
	
	
}
