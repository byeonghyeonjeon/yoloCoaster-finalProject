package com.yolo.model;

import java.util.regex.Pattern;

/**
 * DetailinfocultureVO.java
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
public class DetailinfocultureVO {
	
	private String contentid;
	private String accomcountculture;
	private String chkbabycarriageculture;
	private String chkcreditcardculture;
	private String chkpetculture;
	private String discountinfo;
	private String infocenterculture;
	private String parkingculture;
	private String parkingfee;
	private String restdateculture;
	private String usefee;
	private String usetimeculture;
	private String scale;
	private String spendtime;
	private final Pattern p = Pattern.compile("\"");
	
	public DetailinfocultureVO(){
		super();
	}
	
	public DetailinfocultureVO(String contentid, String accomcountculture,
			String chkbabycarriageculture, String chkcreditcardculture,
			String chkpetculture, String discountinfo,
			String infocenterculture, String parkingculture, String parkingfee,
			String restdateculture, String usefee, String usetimeculture,
			String scale, String spendtime) {
		super();
		this.contentid = contentid;
		this.accomcountculture = accomcountculture;
		this.chkbabycarriageculture = chkbabycarriageculture;
		this.chkcreditcardculture = chkcreditcardculture;
		this.chkpetculture = chkpetculture;
		this.discountinfo = discountinfo;
		this.infocenterculture = infocenterculture;
		this.parkingculture = parkingculture;
		this.parkingfee = parkingfee;
		this.restdateculture = restdateculture;
		this.usefee = usefee;
		this.usetimeculture = usetimeculture;
		this.scale = scale;
		this.spendtime = spendtime;
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
	public String getAccomcountculture() {
		if(accomcountculture == null)
			return "없음";
		if(p.matcher(accomcountculture).find()){
			String strSub = accomcountculture.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return accomcountculture;
	}
	public void setAccomcountculture(String accomcountculture) {
		this.accomcountculture = accomcountculture;
	}
	public String getChkbabycarriageculture() {
		if(chkbabycarriageculture == null)
			return "없음";
		if(p.matcher(chkbabycarriageculture).find()){
			String strSub = chkbabycarriageculture.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return chkbabycarriageculture;
	}
	public void setChkbabycarriageculture(String chkbabycarriageculture) {
		this.chkbabycarriageculture = chkbabycarriageculture;
	}
	public String getChkcreditcardculture() {
		if(chkcreditcardculture == null)
			return "없음";
		if(p.matcher(chkcreditcardculture).find()){
			String strSub = chkcreditcardculture.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return chkcreditcardculture;
	}
	public void setChkcreditcardculture(String chkcreditcardculture) {
		this.chkcreditcardculture = chkcreditcardculture;
	}
	public String getChkpetculture() {
		if(chkpetculture == null)
			return "없음";
		if(p.matcher(chkpetculture).find()){
			String strSub = chkpetculture.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return chkpetculture;
	}
	public void setChkpetculture(String chkpetculture) {
		this.chkpetculture = chkpetculture;
	}
	public String getDiscountinfo() {
		if(discountinfo == null)
			return "없음";
		if(p.matcher(discountinfo).find()){
			String strSub = discountinfo.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return discountinfo;
	}
	public void setDiscountinfo(String discountinfo) {
		this.discountinfo = discountinfo;
	}
	public String getInfocenterculture() {
		if(infocenterculture == null)
			return "없음";
		if(p.matcher(infocenterculture).find()){
			String strSub = infocenterculture.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return infocenterculture;
	}
	public void setInfocenterculture(String infocenterculture) {
		this.infocenterculture = infocenterculture;
	}
	public String getParkingculture() {
		if(parkingculture == null)
			return "없음";
		if(p.matcher(parkingculture).find()){
			String strSub = parkingculture.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return parkingculture;
	}
	public void setParkingculture(String parkingculture) {
		this.parkingculture = parkingculture;
	}
	public String getParkingfee() {
		if(parkingfee == null)
			return "없음";
		if(p.matcher(parkingfee).find()){
			String strSub = parkingfee.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return parkingfee;
	}
	public void setParkingfee(String parkingfee) {
		this.parkingfee = parkingfee;
	}
	public String getRestdateculture() {
		if(restdateculture == null)
			return "없음";
		if(p.matcher(restdateculture).find()){
			String strSub = restdateculture.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return restdateculture;
	}
	public void setRestdateculture(String restdateculture) {
		this.restdateculture = restdateculture;
	}
	public String getUsefee() {
		if(usefee == null)
			return "없음";
		if(p.matcher(usefee).find()){
			String strSub = usefee.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return usefee;
	}
	public void setUsefee(String usefee) {
		this.usefee = usefee;
	}
	public String getUsetimeculture() {
		if(usetimeculture == null)
			return "없음";
		if(p.matcher(usetimeculture).find()){
			String strSub = usetimeculture.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return usetimeculture;
	}
	public void setUsetimeculture(String usetimeculture) {
		this.usetimeculture = usetimeculture;
	}
	public String getScale() {
		if(scale == null)
			return "없음";
		if(p.matcher(scale).find()){
			String strSub = scale.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getSpendtime() {
		if(spendtime == null)
			return "없음";
		if(p.matcher(spendtime).find()){
			String strSub = spendtime.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return spendtime;
	}
	public void setSpendtime(String spendtime) {
		this.spendtime = spendtime;
	}
	
	
}
