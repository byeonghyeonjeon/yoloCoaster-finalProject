/**
 * 
 */
package com.yolo.model;

import java.util.regex.Pattern;

public class Detailinfo_eventVO {

	private String playtime;
	private String program;
	private String spendtimefestival;
	private String sponsor1;
	private String sponsor1tel;
	private String sponsor2;
	private String sponsor2tel;
	private String subevent;
	private String usetimefestival;
	private String contentid;
	private String agelimit;
	private String bookingplace;
	private String discountinfofestival;
	private String eventstartdate;
	private String eventenddate;
	private String eventhomepage;
	private String eventplace;
	private String festivalgrade;
	private String placeinfo;
	private final Pattern p = Pattern.compile("\"");
	
	
	public Detailinfo_eventVO(){
		super();
	}
	
	public Detailinfo_eventVO(String playtime, String program,
			String spendtimefestival, String sponsor1, String sponsor1tel,
			String sponsor2, String sponsor2tel, String subevent,
			String usetimefestival, String contentid, String agelimit,
			String bookingplace, String discountinfofestival,
			String eventstartdate, String eventenddate, String eventhomepage,
			String eventplace, String festivalgrade, String placeinfo) {
		super();
		this.playtime = playtime;
		this.program = program;
		this.spendtimefestival = spendtimefestival;
		this.sponsor1 = sponsor1;
		this.sponsor1tel = sponsor1tel;
		this.sponsor2 = sponsor2;
		this.sponsor2tel = sponsor2tel;
		this.subevent = subevent;
		this.usetimefestival = usetimefestival;
		this.contentid = contentid;
		this.agelimit = agelimit;
		this.bookingplace = bookingplace;
		this.discountinfofestival = discountinfofestival;
		this.eventstartdate = eventstartdate;
		this.eventenddate = eventenddate;
		this.eventhomepage = eventhomepage;
		this.eventplace = eventplace;
		this.festivalgrade = festivalgrade;
		this.placeinfo = placeinfo;
	}


	public String getPlaytime() {
		if(playtime == null)
			return "없음";
		if(p.matcher(playtime).find()){
			String strSub = playtime.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return playtime;
	}
	public void setPlaytime(String playtime) {
		this.playtime = playtime;
	}
	public String getProgram() {
		if(program == null)
			return "없음";
		if(p.matcher(program).find()){
			String strSub = program.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getSpendtimefestival() {
		if(spendtimefestival == null)
			return "없음";
		if(p.matcher(spendtimefestival).find()){
			String strSub = spendtimefestival.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return spendtimefestival;
	}
	public void setSpendtimefestival(String spendtimefestival) {
		this.spendtimefestival = spendtimefestival;
	}
	public String getSponsor1() {
		if(sponsor1 == null)
			return "없음";
		if(p.matcher(sponsor1).find()){
			String strSub = sponsor1.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return sponsor1;
	}
	public void setSponsor1(String sponsor1) {
		this.sponsor1 = sponsor1;
	}
	public String getSponsor1tel() {
		if(sponsor1tel == null)
			return "없음";
		if(p.matcher(sponsor1tel).find()){
			String strSub = sponsor1tel.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return sponsor1tel;
	}
	public void setSponsor1tel(String sponsor1tel) {
		this.sponsor1tel = sponsor1tel;
	}
	public String getSponsor2() {
		if(sponsor2 == null)
			return "없음";
		if(p.matcher(sponsor2).find()){
			String strSub = sponsor2.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return sponsor2;
	}
	public void setSponsor2(String sponsor2) {
		this.sponsor2 = sponsor2;
	}
	public String getSponsor2tel() {
		if(sponsor2tel == null)
			return "없음";
		if(p.matcher(sponsor2tel).find()){
			String strSub = sponsor2tel.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return sponsor2tel;
	}
	public void setSponsor2tel(String sponsor2tel) {
		this.sponsor2tel = sponsor2tel;
	}
	public String getSubevent() {
		if(subevent == null)
			return "없음";
		if(p.matcher(subevent).find()){
			String strSub = subevent.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return subevent;
	}
	public void setSubevent(String subevent) {
		this.subevent = subevent;
	}
	public String getUsetimefestival() {
		if(usetimefestival == null)
			return "없음";
		if(p.matcher(usetimefestival).find()){
			String strSub = usetimefestival.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return usetimefestival;
	}
	public void setUsetimefestival(String usetimefestival) {
		this.usetimefestival = usetimefestival;
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
	public String getAgelimit() {
		if(agelimit == null)
			return "없음";
		if(p.matcher(agelimit).find()){
			String strSub = agelimit.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return agelimit;
	}
	public void setAgelimit(String agelimit) {
		this.agelimit = agelimit;
	}
	public String getBookingplace() {
		if(bookingplace == null)
			return "없음";
		if(p.matcher(bookingplace).find()){
			String strSub = bookingplace.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return bookingplace;
	}
	public void setBookingplace(String bookingplace) {
		this.bookingplace = bookingplace;
	}
	public String getDiscountinfofestival() {
		if(discountinfofestival == null)
			return "없음";
		if(p.matcher(discountinfofestival).find()){
			String strSub = discountinfofestival.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return discountinfofestival;
	}
	public void setDiscountinfofestival(String discountinfofestival) {
		this.discountinfofestival = discountinfofestival;
	}
	public String getEventstartdate() {
		if(eventstartdate == null)
			return "없음";
		if(p.matcher(eventstartdate).find()){
			String strSub = eventstartdate.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return eventstartdate;
	}
	public void setEventstartdate(String eventstartdate) {
		this.eventstartdate = eventstartdate;
	}
	public String getEventenddate() {
		if(eventenddate == null)
			return "없음";
		if(p.matcher(eventenddate).find()){
			String strSub = eventenddate.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return eventenddate;
	}
	public void setEventenddate(String eventenddate) {
		this.eventenddate = eventenddate;
	}
	public String getEventhomepage() {
		if(eventhomepage == null)
			return "없음";
		if(p.matcher(eventhomepage).find()){
			String strSub = eventhomepage.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return eventhomepage;
	}
	public void setEventhomepage(String eventhomepage) {
		this.eventhomepage = eventhomepage;
	}
	public String getEventplace() {
		if(eventplace == null)
			return "없음";
		if(p.matcher(eventplace).find()){
			String strSub = eventplace.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return eventplace;
	}
	public void setEventplace(String eventplace) {
		this.eventplace = eventplace;
	}
	public String getFestivalgrade() {
		if(festivalgrade == null)
			return "없음";
		if(p.matcher(festivalgrade).find()){
			String strSub = festivalgrade.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return festivalgrade;
	}
	public void setFestivalgrade(String festivalgrade) {
		this.festivalgrade = festivalgrade;
	}
	public String getPlaceinfo() {
		if(placeinfo == null)
			return "없음";
		if(p.matcher(placeinfo).find()){
			String strSub = placeinfo.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return placeinfo;
	}
	public void setPlaceinfo(String placeinfo) {
		this.placeinfo = placeinfo;
	}
	
}
