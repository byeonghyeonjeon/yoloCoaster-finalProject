package com.yolo.model;
/**
 * TagCountVO.java
 *
 * @author Jun
 * @since 2018. 7. 9.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 9. Jun 최초 생성
 *
 * </pre>
 */
public class TagCountVO {
	private String tag_content;
	private int tag_count;
	
	public String getTag_content() {
		return tag_content;
	}
	public void setTag_content(String tag_content) {
		this.tag_content = tag_content;
	}
	public int getTag_count() {
		return tag_count;
	}
	public void setTag_count(int tag_count) {
		this.tag_count = tag_count;
	}
	
	@Override
	public String toString() {
		return "TagCountVO [tag_content=" + tag_content + ", tag_count="
				+ tag_count + "]";
	}
}
