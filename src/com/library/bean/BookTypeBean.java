package com.library.bean;

import java.io.Serializable;

public class BookTypeBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int t_id;
	private String t_name;
	private double t_time;
	
	public BookTypeBean() {
		super();
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public double getT_time() {
		return t_time;
	}

	public void setT_time(double t_time) {
		this.t_time = t_time;
	}
	
	
}
