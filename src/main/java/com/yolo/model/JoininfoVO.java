package com.yolo.model;



/**
 * JoininfoVO.java
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
public class JoininfoVO {
	
	private int join_seq;
	private String mem_id;
	private String join_certify;
	private String join_path;
	private String join_dt;
	private String join_drop;
	private String join_drop_cause;
	
	public JoininfoVO(){
		super();
	}
	
	public JoininfoVO(int join_seq, String mem_id, String join_certify,
			String join_path, String join_dt, String join_drop,
			String join_drop_cause) {
		super();
		this.join_seq = join_seq;
		this.mem_id = mem_id;
		this.join_certify = join_certify;
		this.join_path = join_path;
		this.join_dt = join_dt;
		this.join_drop = join_drop;
		this.join_drop_cause = join_drop_cause;
	}


	public int getJoin_seq() {
		return join_seq;
	}
	public void setJoin_seq(int join_seq) {
		this.join_seq = join_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getJoin_certify() {
		return join_certify;
	}
	public void setJoin_certify(String join_certify) {
		this.join_certify = join_certify;
	}
	public String getJoin_path() {
		return join_path;
	}
	public void setJoin_path(String join_path) {
		this.join_path = join_path;
	}
	public String getJoin_dt() {
		return join_dt;
	}
	public void setJoin_dt(String join_dt) {
		this.join_dt = join_dt;
	}
	public String getJoin_drop() {
		return join_drop;
	}
	public void setJoin_drop(String join_drop) {
		this.join_drop = join_drop;
	}
	public String getJoin_drop_cause() {
		return join_drop_cause;
	}
	public void setJoin_drop_cause(String join_drop_cause) {
		this.join_drop_cause = join_drop_cause;
	}
	
	@Override
	public String toString() {
		return "JoininfoVO [join_seq=" + join_seq + ", mem_id=" + mem_id
				+ ", join_certify=" + join_certify + ", join_path=" + join_path
				+ ", join_dt=" + join_dt + ", join_drop=" + join_drop
				+ ", join_drop_cause=" + join_drop_cause + "]";
	}
	
	
	

}
