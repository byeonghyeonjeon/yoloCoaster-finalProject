package com.yolo.model;

import java.util.regex.Pattern;

/**
 * DetailinfotourVO.java
 *
 * @author JiHee
 * @since 2018. 7. 2.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 2. JiHee 최초 생성
 *
 * </pre>
 */
public class DetailinfotourVO {
	
	private String contentid;
	private String accomcount;
	private String chkbabycarriage;
	private String chkcreditcard;
	private String chkpet;
	private String expagerange;
	private String expguide;
	private String heritage1;
	private String heritage2;
	private String heritage3;
	private String infocenter;
	private String opendate;
	private String parking;
	private String restdate;
	private String useseason;
	private String usetime;
	private final Pattern p = Pattern.compile("\"");
	
	public DetailinfotourVO(){
		super();
	}
	
	public DetailinfotourVO(String contentid, String accomcount,
			String chkbabycarriage, String chkcreditcard, String chkpet,
			String expagerange, String expguide, String heritage1,
			String heritage2, String heritage3, String infocenter,
			String opendate, String parking, String restdate, String useseason,
			String usetime) {
		super();
		this.contentid = contentid;
		this.accomcount = accomcount;
		this.chkbabycarriage = chkbabycarriage;
		this.chkcreditcard = chkcreditcard;
		this.chkpet = chkpet;
		this.expagerange = expagerange;
		this.expguide = expguide;
		this.heritage1 = heritage1;
		this.heritage2 = heritage2;
		this.heritage3 = heritage3;
		this.infocenter = infocenter;
		this.opendate = opendate;
		this.parking = parking;
		this.restdate = restdate;
		this.useseason = useseason;
		this.usetime = usetime;
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
	public String getAccomcount() {
		if(accomcount == null)
			return "없음";
		if(p.matcher(accomcount).find()){
			String strSub = accomcount.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return accomcount;
	}
	public void setAccomcount(String accomcount) {
		this.accomcount = accomcount;
	}
	public String getChkbabycarriage() {
		if(chkbabycarriage == null)
			return "없음";
		if(p.matcher(chkbabycarriage).find()){
			String strSub = chkbabycarriage.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return chkbabycarriage;
	}
	public void setChkbabycarriage(String chkbabycarriage) {
		this.chkbabycarriage = chkbabycarriage;
	}
	public String getChkcreditcard() {
		if(chkcreditcard == null)
			return "없음";
		if(p.matcher(chkcreditcard).find()){
			String strSub = chkcreditcard.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return chkcreditcard;
	}
	public void setChkcreditcard(String chkcreditcard) {
		this.chkcreditcard = chkcreditcard;
	}
	public String getChkpet() {
		if(chkpet == null)
			return "없음";
		if(p.matcher(chkpet).find()){
			String strSub = chkpet.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return chkpet;
	}
	public void setChkpet(String chkpet) {
		this.chkpet = chkpet;
	}
	public String getExpagerange() {
		if(expagerange == null)
			return "없음";
		if(p.matcher(expagerange).find()){
			String strSub = expagerange.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return expagerange;
	}
	public void setExpagerange(String expagerange) {
		this.expagerange = expagerange;
	}
	public String getExpguide() {
		if(expguide == null)
			return "없음";
		if(p.matcher(expguide).find()){
			String strSub = expguide.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return expguide;
	}
	public void setExpguide(String expguide) {
		this.expguide = expguide;
	}
	public String getHeritage1() {
		if(heritage1 == null)
			return "없음";
		if(p.matcher(heritage1).find()){
			String strSub = heritage1.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return heritage1;
	}
	public void setHeritage1(String heritage1) {
		this.heritage1 = heritage1;
	}
	public String getHeritage2() {
		if(heritage2 == null)
			return "없음";
		if(p.matcher(heritage2).find()){
			String strSub = heritage2.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return heritage2;
	}
	public void setHeritage2(String heritage2) {
		this.heritage2 = heritage2;
	}
	public String getHeritage3() {
		if(heritage3 == null)
			return "없음";
		if(p.matcher(heritage3).find()){
			String strSub = heritage3.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return heritage3;
	}
	public void setHeritage3(String heritage3) {
		this.heritage3 = heritage3;
	}
	public String getInfocenter() {
		if(infocenter == null)
			return "없음";
		if(p.matcher(infocenter).find()){
			String strSub = infocenter.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return infocenter;
	}
	public void setInfocenter(String infocenter) {
		this.infocenter = infocenter;
	}
	public String getOpendate() {
		if(opendate == null)
			return "없음";
		if(p.matcher(opendate).find()){
			String strSub = opendate.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return opendate;
	}
	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}
	public String getParking() {
		if(parking == null)
			return "없음";
		if(p.matcher(parking).find()){
			String strSub = parking.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getRestdate() {
		if(restdate == null)
			return "없음";
		if(p.matcher(restdate).find()){
			String strSub = restdate.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return restdate;
	}
	public void setRestdate(String restdate) {
		this.restdate = restdate;
	}
	public String getUseseason() {
		if(useseason == null)
			return "없음";
		if(p.matcher(useseason).find()){
			String strSub = useseason.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return useseason;
	}
	public void setUseseason(String useseason) {
		this.useseason = useseason;
	}
	public String getUsetime() {
		if(usetime == null)
			return "없음";
		if(p.matcher(usetime).find()){
			String strSub = usetime.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return usetime;
	}
	public void setUsetime(String usetime) {
		this.usetime = usetime;
	}
	

}
