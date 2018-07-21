/**
 * 
 */
package com.yolo.model;

import java.util.regex.Pattern;


/**
 * Detailinfo_courseVO.java
 *
 * @author KGY
 * @since 2018. 6. 14.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 14. KGY 최초 생성
 *
 * </pre>
 */
public class Detailinfo_courseVO {

	private String contentid;
	private String distance;
	private String infocentertourcourse;
	private String schedule;
	private String taketime;
	private String theme;
	private final Pattern p = Pattern.compile("\"");
	
	public Detailinfo_courseVO(){
		super();
	}
	
	public Detailinfo_courseVO(String contentid, String distance,
			String infocentertourcourse, String schedule, String taketime,
			String theme) {
		super();
		this.contentid = contentid;
		this.distance = distance;
		this.infocentertourcourse = infocentertourcourse;
		this.schedule = schedule;
		this.taketime = taketime;
		this.theme = theme;
	}

	public String getContentid() {
		if(contentid == null)
			return "없음";
		if(p.matcher(contentid).find()){
			String strSub = contentid.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getDistance() {
		if(distance == null)
			return "없음";
		if(p.matcher(distance).find()){
			String strSub = distance.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getInfocentertourcourse() {
		if(infocentertourcourse == null)
			return "없음";
		if(p.matcher(infocentertourcourse).find()){
			String strSub = infocentertourcourse.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return infocentertourcourse;
	}
	public void setInfocentertourcourse(String infocentertourcourse) {
		this.infocentertourcourse = infocentertourcourse;
	}
	public String getSchedule() {
		if(schedule == null)
			return "없음";
		if(p.matcher(schedule).find()){
			String strSub = schedule.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getTaketime() {
		if(taketime == null)
			return "없음";
		if(p.matcher(taketime).find()){
			String strSub = taketime.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return taketime;
	}
	public void setTaketime(String taketime) {
		this.taketime = taketime;
	}
	public String getTheme() {
		if(theme == null)
			return "없음";
		if(p.matcher(theme).find()){
			String strSub = theme.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}

}
