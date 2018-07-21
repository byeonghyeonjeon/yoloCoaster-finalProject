package com.yolo.model;

import java.util.regex.Pattern;


/**
 * Detailinfo_leportsVO.java
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
public class Detailinfo_leportsVO {
	
	private String contentid;
	private String accomcountleports;
	private String chkbabycarriageleports;
	private String chkcreditcardleports;
	private String chkpetleports;
	private String expagerangeleports;
	private String infocenterleports;
	private String openperiod;
	private String parkingfeeleports;
	private String parkingleports;
	private String reservation;
	private String restdateleports;
	private String scaleleports;
	private String usefeeleports;
	private String usetimeleports;
	private final Pattern p = Pattern.compile("\"");
	
	
	public Detailinfo_leportsVO(){
		super();
	}
	
	public Detailinfo_leportsVO(String contentid, String accomcountleports,
			String chkbabycarriageleports, String chkcreditcardleports,
			String chkpetleports, String expagerangeleports,
			String infocenterleports, String openperiod,
			String parkingfeeleports, String parkingleports,
			String reservation, String restdateleports, String scaleleports,
			String usefeeleports, String usetimeleports) {
		super();
		this.contentid = contentid;
		this.accomcountleports = accomcountleports;
		this.chkbabycarriageleports = chkbabycarriageleports;
		this.chkcreditcardleports = chkcreditcardleports;
		this.chkpetleports = chkpetleports;
		this.expagerangeleports = expagerangeleports;
		this.infocenterleports = infocenterleports;
		this.openperiod = openperiod;
		this.parkingfeeleports = parkingfeeleports;
		this.parkingleports = parkingleports;
		this.reservation = reservation;
		this.restdateleports = restdateleports;
		this.scaleleports = scaleleports;
		this.usefeeleports = usefeeleports;
		this.usetimeleports = usetimeleports;
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
	public String getAccomcountleports() {
		if(accomcountleports == null)
			return "없음";
		if(p.matcher(accomcountleports).find()){
			String strSub = accomcountleports.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return accomcountleports;
	}
	public void setAccomcountleports(String accomcountleports) {
		this.accomcountleports = accomcountleports;
	}
	public String getChkbabycarriageleports() {
		if(chkbabycarriageleports == null)
			return "없음";
		if(p.matcher(chkbabycarriageleports).find()){
			String strSub = chkbabycarriageleports.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return chkbabycarriageleports;
	}
	public void setChkbabycarriageleports(String chkbabycarriageleports) {
		this.chkbabycarriageleports = chkbabycarriageleports;
	}
	public String getChkcreditcardleports() {
		if(chkcreditcardleports == null)
			return "없음";
		if(p.matcher(chkcreditcardleports).find()){
			String strSub = chkcreditcardleports.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return chkcreditcardleports;
	}
	public void setChkcreditcardleports(String chkcreditcardleports) {
		this.chkcreditcardleports = chkcreditcardleports;
	}
	public String getChkpetleports() {
		if(chkpetleports == null)
			return "없음";
		if(p.matcher(chkpetleports).find()){
			String strSub = chkpetleports.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return chkpetleports;
	}
	public void setChkpetleports(String chkpetleports) {
		this.chkpetleports = chkpetleports;
	}
	public String getExpagerangeleports() {
		if(expagerangeleports == null)
			return "없음";
		if(p.matcher(expagerangeleports).find()){
			String strSub = expagerangeleports.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return expagerangeleports;
	}
	public void setExpagerangeleports(String expagerangeleports) {
		this.expagerangeleports = expagerangeleports;
	}
	public String getInfocenterleports() {
		if(infocenterleports == null)
			return "없음";
		if(p.matcher(infocenterleports).find()){
			String strSub = infocenterleports.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return infocenterleports;
	}
	public void setInfocenterleports(String infocenterleports) {
		this.infocenterleports = infocenterleports;
	}
	public String getOpenperiod() {
		if(openperiod == null)
			return "없음";
		if(p.matcher(openperiod).find()){
			String strSub = openperiod.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return openperiod;
	}
	public void setOpenperiod(String openperiod) {
		this.openperiod = openperiod;
	}
	public String getParkingfeeleports() {
		if(parkingfeeleports == null)
			return "없음";
		if(p.matcher(parkingfeeleports).find()){
			String strSub = parkingfeeleports.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return parkingfeeleports;
	}
	public void setParkingfeeleports(String parkingfeeleports) {
		this.parkingfeeleports = parkingfeeleports;
	}
	public String getParkingleports() {
		if(parkingleports == null)
			return "없음";
		if(p.matcher(parkingleports).find()){
			String strSub = parkingleports.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return parkingleports;
	}
	public void setParkingleports(String parkingleports) {
		this.parkingleports = parkingleports;
	}
	public String getReservation() {
		if(reservation == null)
			return "없음";
		if(p.matcher(reservation).find()){
			String strSub = reservation.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return reservation;
	}
	public void setReservation(String reservation) {
		this.reservation = reservation;
	}
	public String getRestdateleports() {
		if(restdateleports == null)
			return "없음";
		if(p.matcher(restdateleports).find()){
			String strSub = restdateleports.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return restdateleports;
	}
	public void setRestdateleports(String restdateleports) {
		this.restdateleports = restdateleports;
	}
	public String getScaleleports() {
		if(scaleleports == null)
			return "없음";
		if(p.matcher(scaleleports).find()){
			String strSub = scaleleports.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return scaleleports;
	}
	public void setScaleleports(String scaleleports) {
		this.scaleleports = scaleleports;
	}
	public String getUsefeeleports() {
		if(usefeeleports == null)
			return "없음";
		if(p.matcher(usefeeleports).find()){
			String strSub = usefeeleports.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return usefeeleports;
	}
	public void setUsefeeleports(String usefeeleports) {
		this.usefeeleports = usefeeleports;
	}
	public String getUsetimeleports() {
		if(usetimeleports == null)
			return "없음";
		if(p.matcher(usetimeleports).find()){
			String strSub = usetimeleports.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return usetimeleports;
	}
	public void setUsetimeleports(String usetimeleports) {
		this.usetimeleports = usetimeleports;
	}
	
	
	@Override
	public String toString() {
		return "Detailinfo_leportsVO [contentid=" + contentid
				+ ", accomcountleports=" + accomcountleports
				+ ", chkbabycarriageleports=" + chkbabycarriageleports
				+ ", chkcreditcardleports=" + chkcreditcardleports
				+ ", chkpetleports=" + chkpetleports + ", expagerangeleports="
				+ expagerangeleports + ", infocenterleports="
				+ infocenterleports + ", openperiod=" + openperiod
				+ ", parkingfeeleports=" + parkingfeeleports
				+ ", parkingleports=" + parkingleports + ", reservation="
				+ reservation + ", restdateleports=" + restdateleports
				+ ", scaleleports=" + scaleleports + ", usefeeleports="
				+ usefeeleports + ", usetimeleports=" + usetimeleports + "]";
	}
	
	

}
