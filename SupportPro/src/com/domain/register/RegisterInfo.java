package com.domain.register;

public class RegisterInfo {
	
	private String name;
	private String telPhone;
	private String email;
	private String wechatOrQQ;
	private String org;
	private String orgInstroduction;
	private String proInstroduction;
	private String remark;
	private String picLoc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWechatOrQQ() {
		return wechatOrQQ;
	}

	public void setWechatOrQQ(String wechatOrQQ) {
		this.wechatOrQQ = wechatOrQQ;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getProDesc() {
		return orgInstroduction;
	}

	public void setProDesc(String proDesc) {
		this.orgInstroduction = proDesc;
	}

	public String getRemarkHelp() {
		return proInstroduction;
	}

	public void setRemarkHelp(String remarkHelp) {
		this.proInstroduction = remarkHelp;
	}

	public String getPicLoc() {
		return picLoc;
	}

	public void setPicLoc(String picLoc) {
		this.picLoc = picLoc;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
