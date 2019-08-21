package com.library.bean;

import java.io.Serializable;

public class GiveBackBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int g_ID, g_readerID, g_bookID,b_ifBack;
	public int getB_ifBack() {
		return b_ifBack;
	}
	public void setB_ifBack(int b_ifBack) {
		this.b_ifBack = b_ifBack;
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
	public String getB_nowTime() {
		return b_nowTime;
	}
	public void setB_nowTime(String b_nowTime) {
		this.b_nowTime = b_nowTime;
	}
	private String g_backtime, g_operator, b_name,b_isbn,b_author,t_name,b_location,b_nowTime;
	
	public int getG_ID() {
		return g_ID;
	}
	public void setG_ID(int g_ID) {
		this.g_ID = g_ID;
	}
	public int getG_readerID() {
		return g_readerID;
	}
	public void setG_readerID(int g_readerID) {
		this.g_readerID = g_readerID;
	}
	public int getG_bookID() {
		return g_bookID;
	}
	public void setG_bookID(int g_bookID) {
		this.g_bookID = g_bookID;
	}
	public String getG_backtime() {
		return g_backtime;
	}
	public void setG_backtime(String g_backtime) {
		this.g_backtime = g_backtime;
	}
	public String getG_operator() {
		return g_operator;
	}
	public void setG_operator(String g_operator) {
		this.g_operator = g_operator;
	}
}
