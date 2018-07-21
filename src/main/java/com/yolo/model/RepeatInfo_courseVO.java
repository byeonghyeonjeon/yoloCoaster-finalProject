/**
 * 
 */
package com.yolo.model;

import java.util.regex.Pattern;

/**
* Repeatinfo_courseVO.java
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
public class RepeatInfo_courseVO {		//반복정보 여행코스
	private String contentid;			//반복정보 시퀀시
	private String contenttypeid;		//컨텐츠 타입
	private String subcontentid;		//서브 컨텐츠 아이디
	private String subdetailalt;		
	private String subdetailimg;
	private String subdetailoverview;
	private String subname;
	private String subnum;
	private final Pattern p = Pattern.compile("\"");
	
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
	public String getContenttypeid() {
		if(contenttypeid == null)
			return "없음";
		if(p.matcher(contenttypeid).find()){
			String strSub = contenttypeid.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return contenttypeid;
	}
	public void setContenttypeid(String contenttypeid) {
		this.contenttypeid = contenttypeid;
	}
	public String getSubcontentid() {
		if(subcontentid == null)
			return "없음";
		if(p.matcher(subcontentid).find()){
			String strSub = subcontentid.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return subcontentid;
	}
	public void setSubcontentid(String subcontentid) {
		this.subcontentid = subcontentid;
	}
	public String getSubdetailalt() {
		if(subdetailalt == null)
			return "없음";
		if(p.matcher(subdetailalt).find()){
			String strSub = subdetailalt.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return subdetailalt;
	}
	public void setSubdetailalt(String subdetailalt) {
		this.subdetailalt = subdetailalt;
	}
	public String getSubdetailimg() {
		if(subdetailimg == null)
			return "없음";
		if(p.matcher(subdetailimg).find()){
			String strSub = subdetailimg.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return subdetailimg;
	}
	public void setSubdetailimg(String subdetailimg) {
		this.subdetailimg = subdetailimg;
	}
	public String getSubdetailoverview() {
		if(subdetailoverview == null)
			return "없음";
		if(p.matcher(subdetailoverview).find()){
			String strSub = subdetailoverview.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return subdetailoverview;
	}
	public void setSubdetailoverview(String subdetailoverview) {
		this.subdetailoverview = subdetailoverview;
	}
	public String getSubname() {
		if(subname == null)
			return "없음";
		if(p.matcher(subname).find()){
			String strSub = subname.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getSubnum() {
		if(subnum == null)
			return "없음";
		if(p.matcher(subnum).find()){
			String strSub = subnum.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return subnum;
	}
	public void setSubnum(String subnum) {
		this.subnum = subnum;
	}
	@Override
	public String toString() {
		return "Repeatinfo_courseVO [contentid=" + contentid + ", contenttypeid=" + contenttypeid + ", subcontentid="
				+ subcontentid + ", subdetailalt=" + subdetailalt + ", subdetailimg=" + subdetailimg
				+ ", subdetailoverview=" + subdetailoverview + ", subname=" + subname + ", subnum=" + subnum + "]";
	}
	public RepeatInfo_courseVO(String contentid, String contenttypeid, String subcontentid, String subdetailalt,
			String subdetailimg, String subdetailoverview, String subname, String subnum) {
		super();
		this.contentid = contentid;
		this.contenttypeid = contenttypeid;
		this.subcontentid = subcontentid;
		this.subdetailalt = subdetailalt;
		this.subdetailimg = subdetailimg;
		this.subdetailoverview = subdetailoverview;
		this.subname = subname;
		this.subnum = subnum;
	}
	
	public RepeatInfo_courseVO() {
		super();
	}
}
