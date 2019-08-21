package com.library.bean;

import java.io.Serializable;

public class BorrowBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int b_ID, b_readerID, b_bookID, b_ifBack, binfo_id, r_id;
	private String b_outTime, b_backTime, b_operator,b_nowTime,b_name, r_name, b_isbn,b_author,t_name,b_location,b_state;
	public int getBinfo_id() {
		return binfo_id;
	}
	public void setBinfo_id(int binfo_id) {
		this.binfo_id = binfo_id;
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
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_isbn() {
		return b_isbn;
	}
	public void setB_isbn(String b_isbn) {
		this.b_isbn = b_isbn;
	}
	public String getB_author() {
		return b_author;
	}
	public void setB_author(String b_author) {
		this.b_author = b_author;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getB_location() {
		return b_location;
	}
	public void setB_location(String b_location) {
		this.b_location = b_location;
	}
	public String getB_state() {
		return b_state;
	}
	public void setB_state(String b_state) {
		this.b_state = b_state;
	}
	public String getB_nowTime() {
		return b_nowTime;
	}
	public void setB_nowTime(String b_nowTime) {
		this.b_nowTime = b_nowTime;
	}
	public BorrowBean() {
		super();
	}
	public int getB_ID() {
		return b_ID;
	}
	public void setB_ID(int b_ID) {
		this.b_ID = b_ID;
	}
	public int getB_readerID() {
		return b_readerID;
	}
	public void setB_readerID(int b_readerID) {
		this.b_readerID = b_readerID;
	}
	public int getB_bookID() {
		return b_bookID;
	}
	public void setB_bookID(int b_bookID) {
		this.b_bookID = b_bookID;
	}
	public int getB_ifBack() {
		return b_ifBack;
	}
	public void setB_ifBack(int b_ifBack) {
		this.b_ifBack = b_ifBack;
	}
	public String getB_outTime() {
		return b_outTime;
	}
	public void setB_outTime(String b_outTime) {
		this.b_outTime = b_outTime;
	}
	public String getB_backTime() {
		return b_backTime;
	}
	public void setB_backTime(String b_backTime) {
		this.b_backTime = b_backTime;
	}
	public String getB_operator() {
		return b_operator;
	}
	public void setB_operator(String b_operator) {
		this.b_operator = b_operator;
	}
	
	
}
