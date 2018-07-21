/**
 * 
 */
package com.yolo.model;

import java.util.regex.Pattern;


/**
 * BasicinfoVO.java
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
public class BasicinfoVO {
	
	private String contentid;
	private String contenttypeid;
	private String title;
	private String areacode;
	private String sigungucode;
	private String tel;
	private String cat1;
	private String cat2;
	private String cat3;
	private String addr1;
	private String addr2;
	private String firstimage;
	private String firstimage2;
	private String mapx;
	private String mapy;
	private String mlevel;
	private String dist;
	private String eventstartdate;
	private String eventenddate;
	private String zipcode;
	private String homepage;
	private String overview;
	private int goodCount;
	private int reviewCount;
	
	
	private final Pattern p = Pattern.compile("\"");
	
	public BasicinfoVO(){
		super();
	}
	
	public BasicinfoVO(String contentid, String contenttypeid, String title,
			String areacode, String sigungucode, String tel, String cat1,
			String cat2, String cat3, String addr1, String addr2,
			String firstimage, String firstimage2, String mapx, String mapy,
			String mlevel, String dist, String eventstartdate,
			String eventenddate, String zipcode, String homepage,
			String overview, int goodCount, int reviewCount) {
		super();
		this.contentid = contentid;
		this.contenttypeid = contenttypeid;
		this.title = title;
		this.areacode = areacode;
		this.sigungucode = sigungucode;
		this.tel = tel;
		this.cat1 = cat1;
		this.cat2 = cat2;
		this.cat3 = cat3;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.firstimage = firstimage;
		this.firstimage2 = firstimage2;
		this.mapx = mapx;
		this.mapy = mapy;
		this.mlevel = mlevel;
		this.dist = dist;
		this.eventstartdate = eventstartdate;
		this.eventenddate = eventenddate;
		this.zipcode = zipcode;
		this.homepage = homepage;
		this.overview = overview;
		this.goodCount = goodCount;
		this.reviewCount = reviewCount;
	}


	public int getGoodCount() {
		return goodCount;
	}
	public void setGoodCount(int goodCount) {
		this.goodCount = goodCount;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
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
	public String getTitle() {
		if(title == null)
			return "없음";
		if(p.matcher(title).find()){
			String strSub = title.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAreacode() {
		if(areacode == null)
			return "없음";
		if(p.matcher(areacode).find()){
			String strSub = areacode.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getSigungucode() {
		if(sigungucode == null)
			return "없음";
		if(p.matcher(sigungucode).find()){
			String strSub = sigungucode.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return sigungucode;
	}
	public void setSigungucode(String sigungucode) {
		this.sigungucode = sigungucode;
	}
	public String getTel() {
		if(tel == null)
			return "없음";
		if(p.matcher(tel).find()){
			String strSub = tel.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCat1() {
		if(cat1 == null)
			return "없음";
		if(p.matcher(cat1).find()){
			String strSub = cat1.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return cat1;
	}
	public void setCat1(String cat1) {
		this.cat1 = cat1;
	}
	public String getCat2() {
		if(cat2 == null)
			return "없음";
		if(p.matcher(cat2).find()){
			String strSub = cat2.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return cat2;
	}
	public void setCat2(String cat2) {
		this.cat2 = cat2;
	}
	public String getCat3() {
		if(cat3 == null)
			return "없음";
		if(p.matcher(cat3).find()){
			String strSub = cat3.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return cat3;
	}
	public void setCat3(String cat3) {
		this.cat3 = cat3;
	}
	public String getAddr1() {
		if(addr1 == null)
			return "없음";
		if(p.matcher(addr1).find()){
			String strSub = addr1.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		if(addr2 == null)
			return "없음";
		if(p.matcher(addr2).find()){
			String strSub = addr2.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getFirstimage() {
		if(firstimage == null)
			return "없음";
		if(p.matcher(firstimage).find()){
			String strSub = firstimage.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return firstimage;
	}
	public void setFirstimage(String firstimage) {
		this.firstimage = firstimage;
	}
	public String getFirstimage2() {
		if(firstimage2 == null)
			return "없음";
		if(p.matcher(firstimage2).find()){
			String strSub = firstimage2.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return firstimage2;
	}
	public void setFirstimage2(String firstimage2) {
		this.firstimage2 = firstimage2;
	}
	public String getMapx() {
		if(mapx == null)
			return "없음";
		if(p.matcher(mapx).find()){
			String strSub = mapx.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return mapx;
	}
	public void setMapx(String mapx) {
		this.mapx = mapx;
	}
	public String getMapy() {
		if(mapy == null)
			return "없음";
		if(p.matcher(mapy).find()){
			String strSub = mapy.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return mapy;
	}
	public void setMapy(String mapy) {
		this.mapy = mapy;
	}
	public String getMlevel() {
		if(mlevel == null)
			return "없음";
		if(p.matcher(mlevel).find()){
			String strSub = mlevel.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return mlevel;
	}
	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}
	public String getDist() {
		if(dist == null)
			return "없음";
		if(p.matcher(dist).find()){
			String strSub = dist.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
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
	public String getZipcode() {
		if(zipcode == null)
			return "없음";
		if(p.matcher(zipcode).find()){
			String strSub = zipcode.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getHomepage() {
		if(homepage == null)
			return "없음";
		if(p.matcher(homepage).find()){
			String strSub = homepage.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getOverview() {
		if(overview == null)
			return "없음";
		if(p.matcher(overview).find()){
			String strSub = overview.substring(1);
			strSub = strSub.substring(0, strSub.length()-1);
			return strSub;
		}
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
}
