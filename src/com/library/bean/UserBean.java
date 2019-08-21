package com.library.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int u_ID;
	private String u_name, u_pwd;
	public int getU_ID() {
		return u_ID;
	}
	public void setU_ID(int u_ID) {
		this.u_ID = u_ID;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	
}
