/**
 * 
 */
package com.yolo.model;

/**
 * AreaVO.java
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
public class AreaVO {
	
	private String areacode;
	private String areaname;
	
	public AreaVO(){
		super();
	}
	
	public AreaVO(String areacode, String areaname) {
		super();
		this.areacode = areacode;
		this.areaname = areaname;
	}

	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	
	
	@Override
	public String toString() {
		return "AreaVO [areacode=" + areacode + ", areaname=" + areaname + "]";
	}
	
	
	

}
