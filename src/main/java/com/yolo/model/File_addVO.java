package com.yolo.model;


/**
 * File_addVO.java
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
public class File_addVO {
	
	private int add_seq;
	private int parent_seq;
	private String add_oriname;
	private String add_newname;
	private String add_mem_id;
	private String add_dt;
	private String add_ex;
	private String add_path;
	private String add_sort;
	
	public File_addVO(){
		super();
	}
	
	public String getAdd_sort() {
		return add_sort;
	}

	public void setAdd_sort(String add_sort) {
		this.add_sort = add_sort;
	}

	public File_addVO(int add_seq, int parent_seq, String add_oriname,
			String add_newname, String add_mem_id, String add_dt,
			String add_ex, String add_path) {
		super();
		this.add_seq = add_seq;
		this.parent_seq = parent_seq;
		this.add_oriname = add_oriname;
		this.add_newname = add_newname;
		this.add_mem_id = add_mem_id;
		this.add_dt = add_dt;
		this.add_ex = add_ex;
		this.add_path = add_path;
	}



	public int getAdd_seq() {
		return add_seq;
	}
	public void setAdd_seq(int add_seq) {
		this.add_seq = add_seq;
	}
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
	public String getAdd_oriname() {
		return add_oriname;
	}
	public void setAdd_oriname(String add_oriname) {
		this.add_oriname = add_oriname;
	}
	public String getAdd_newname() {
		return add_newname;
	}
	public void setAdd_newname(String add_newname) {
		this.add_newname = add_newname;
	}
	public String getAdd_mem_id() {
		return add_mem_id;
	}
	public void setAdd_mem_id(String add_mem_id) {
		this.add_mem_id = add_mem_id;
	}
	public String getAdd_dt() {
		return add_dt;
	}
	public void setAdd_dt(String add_dt) {
		this.add_dt = add_dt;
	}
	public String getAdd_ex() {
		return add_ex;
	}
	public void setAdd_ex(String add_ex) {
		this.add_ex = add_ex;
	}
	public String getAdd_path() {
		return add_path;
	}
	public void setAdd_path(String add_path) {
		this.add_path = add_path;
	}
	
	@Override
	public String toString() {
		return "File_addVO [add_seq=" + add_seq + ", parent_seq=" + parent_seq
				+ ", add_oriname=" + add_oriname + ", add_newname="
				+ add_newname + ", add_mem_id=" + add_mem_id + ", add_dt="
				+ add_dt + ", add_ex=" + add_ex + ", add_path=" + add_path
				+ "]";
	}
	


}
