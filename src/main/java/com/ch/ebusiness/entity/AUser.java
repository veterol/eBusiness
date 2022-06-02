package com.ch.ebusiness.entity;
public class AUser {
	private String aname;
	private String apwd;
	//标识管理员1和销售员0
	private int asym;
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public int getAsym(){
		return asym;
	}
	public void setAsym(int asym){
		this.asym = asym;
	}
}
