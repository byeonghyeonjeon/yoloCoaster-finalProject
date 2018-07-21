/**
 * 
 */
package com.yolo.model;

import java.util.regex.Pattern;

/**
* RepeatInfo_ectVO.java
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
public class RepeatInfo_ectVO {		//반복정보 기타
	private String contentid;		//컨텐츠 아이디
	private String contenttypeid;
	private String fldgubun;
	private String infoname;
	private String infotext;
	private String serialnum;
	private final Pattern p = Pattern.compile("\"");
	
	public RepeatInfo_ectVO(String contentid, String contenttypeid, String fldgubun, String infoname, String infotext,
			String serialnum) {
		super();
		this.contentid = contentid;
		this.contenttypeid = contenttypeid;
		this.fldgubun = fldgubun;
		this.infoname = infoname;
		this.infotext = infotext;
		this.serialnum = serialnum;
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
	public String getFldgubun() {
		if(fldgubun == null)
			return "없음";
		if(p.matcher(fldgubun).find()){
			String strSub = fldgubun.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return fldgubun;
	}
	public void setFldgubun(String fldgubun) {
		this.fldgubun = fldgubun;
	}
	public String getInfoname() {
		if(infoname == null)
			return "없음";
		if(p.matcher(infoname).find()){
			String strSub = infoname.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return infoname;
	}
	public void setInfoname(String infoname) {
		this.infoname = infoname;
	}
	public String getInfotext() {
		if(infotext == null)
			return "없음";
		if(p.matcher(infotext).find()){
			String strSub = infotext.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return infotext;
	}
	public void setInfotext(String infotext) {
		this.infotext = infotext;
	}
	public String getSerialnum() {
		if(serialnum == null)
			return "없음";
		if(p.matcher(serialnum).find()){
			String strSub = serialnum.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return serialnum;
	}
	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}
	public RepeatInfo_ectVO() {
		super();
	}
	
	@Override
	public String toString() {
		return "RepeatInfo_ectVO [contentid=" + contentid + ", contenttypeid="
				+ contenttypeid + ", fldgubun=" + fldgubun + ", infoname="
				+ infoname + ", infotext=" + infotext + ", serialnum="
				+ serialnum + "]";
	}
	
	
	
}
