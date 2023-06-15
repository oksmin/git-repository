package com.java.servlet.vo;

public class MemberVO {
	private int m_no;
	private String name;
	private String jumin;
	private String id;
	private String pwd;
	
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return "m_no=" +  this.m_no
				+ " name=" + this.name
				+ " jumin=" + this.jumin
				+ " id=" + this.id
				+ " pwd=" + this.pwd
				;
	}
	
	
}
