package com.library.servlet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 30);
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
		String nowdate = s.format(new Date());
		String date = s.format(cal.getTime());
		System.out.println(nowdate+date);
	}

}
