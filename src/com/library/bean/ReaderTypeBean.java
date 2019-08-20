package com.library.bean;

import java.io.Serializable;

public class ReaderTypeBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rt_ID, rt_num;
	private String rt_readername;
	public int getRt_ID() {
		return rt_ID;
	}
	public void setRt_ID(int rt_ID) {
		this.rt_ID = rt_ID;
	}
	public int getRt_num() {
		return rt_num;
	}
	public void setRt_num(int rt_num) {
		this.rt_num = rt_num;
	}
	public String getRt_readername() {
		return rt_readername;
	}
	public void setRt_readername(String rt_readername) {
		this.rt_readername = rt_readername;
	}
}
