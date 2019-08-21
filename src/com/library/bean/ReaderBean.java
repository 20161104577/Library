package com.library.bean;

import java.io.Serializable;

public class ReaderBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int r_id;
	private String r_paperType, r_name,r_pwd, r_gender, r_type, r_birth, r_paperNo, r_registdate, r_mobile, r_email;
	public String getR_pwd() {
		return r_pwd;
	}
	public String getR_paperType() {
		return r_paperType;
	}
	public void setR_paperType(String r_paperType) {
		this.r_paperType = r_paperType;
	}
	public void setR_pwd(String r_pwd) {
		this.r_pwd = r_pwd;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_gender() {
		return r_gender;
	}
	public void setR_gender(String r_gender) {
		this.r_gender = r_gender;
	}
	
	public String getR_type() {
		return r_type;
	}
	public void setR_type(String r_type) {
		this.r_type = r_type;
	}
	public String getR_birth() {
		return r_birth;
	}
	public void setR_birth(String r_birth) {
		this.r_birth = r_birth;
	}
	public String getR_paperNo() {
		return r_paperNo;
	}
	public void setR_paperNo(String r_paperNo) {
		this.r_paperNo = r_paperNo;
	}
	public String getR_registdate() {
		return r_registdate;
	}
	public void setR_registdate(String r_registdate) {
		this.r_registdate = r_registdate;
	}
	public String getR_mobile() {
		return r_mobile;
	}
	public void setR_mobile(String r_mobile) {
		this.r_mobile = r_mobile;
	}
	public String getR_email() {
		return r_email;
	}
	public void setR_email(String r_email) {
		this.r_email = r_email;
	}
	
}
