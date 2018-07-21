package com.yolo.model;

/**
 * StarVO.java
 *
 * @author Jun
 * @since 2018. 7. 7.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 7. Jun 최초 생성
 *
 * </pre>
 */
public class StarVO implements Comparable<StarVO>{
	private int count;
	private int score_point;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getScore_point() {
		return score_point;
	}
	public void setScore_point(int score_point) {
		this.score_point = score_point;
	}
	
	@Override
	public String toString() {
		return "StarVO [count=" + count + ", score_point=" + score_point + "]";
	}
	@Override
	public int compareTo(StarVO o) {
		if (this.score_point < o.score_point) {
			return 1;
		} else {
			return -1;
		}
	}
}
