package com.library.bean;

import java.io.Serializable;

public class BookInfoBean  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int b_id, b_type;
	private String b_name, b_state, b_author, b_translator, b_isbn, b_press, b_location, b_intime, b_operator;
	private double b_price;
	
	
	
	public int getB_id() {
		return b_id;
	}



	public void setB_id(int b_id) {
		this.b_id = b_id;
	}



	public int getB_type() {
		return b_type;
	}



	public void setB_type(int b_type) {
		this.b_type = b_type;
	}



	public String getB_name() {
		return b_name;
	}



	public void setB_name(String b_name) {
		this.b_name = b_name;
	}



	public String getB_state() {
		return b_state;
	}



	public void setB_state(String b_state) {
		this.b_state = b_state;
	}



	public String getB_author() {
		return b_author;
	}



	public void setB_author(String b_author) {
		this.b_author = b_author;
	}



	public String getB_translator() {
		return b_translator;
	}



	public void setB_translator(String b_translator) {
		this.b_translator = b_translator;
	}



	public String getB_isbn() {
		return b_isbn;
	}



	public void setB_isbn(String b_isbn) {
		this.b_isbn = b_isbn;
	}



	public String getB_press() {
		return b_press;
	}



	public void setB_press(String b_press) {
		this.b_press = b_press;
	}



	public String getB_location() {
		return b_location;
	}



	public void setB_location(String b_location) {
		this.b_location = b_location;
	}



	public String getB_intime() {
		return b_intime;
	}



	public void setB_intime(String b_intime) {
		this.b_intime = b_intime;
	}



	public String getB_operator() {
		return b_operator;
	}



	public void setB_operator(String b_operator) {
		this.b_operator = b_operator;
	}



	public double getB_price() {
		return b_price;
	}



	public void setB_price(double b_price) {
		this.b_price = b_price;
	}



	public BookInfoBean() {
		super();
	}
	
}
