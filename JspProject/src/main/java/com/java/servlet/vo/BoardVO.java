package com.java.servlet.vo;

import java.util.Date;

public class BoardVO {
	private int b_no;
    private String title;
    private String content;
    private Date reg_date;
    private Date up_date;
    private String id;
    
    //getter setter
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getUp_date() {
		return up_date;
	}
	public void setUp_date(Date up_date) {
		this.up_date = up_date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    
	@Override
	public String toString() {
		return "BoardVO["
				+"b_no=" + b_no
				+" title=" + title
				+" content=" + content
				+" reg_date=" + reg_date
				+" up_date=" + up_date
				+" id=" + id +"]"
				;
	}
    
}
