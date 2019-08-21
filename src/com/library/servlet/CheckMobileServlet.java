package com.library.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.ReaderDao;

@WebServlet("/CheckMobileServlet")
public class CheckMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckMobileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mobile = request.getParameter("mobile");
		System.out.println("1 " + mobile);
		
		String flag = "yes";
		ReaderDao readerDao = new ReaderDao();
		ResultSet checkMobile = readerDao.checkMobile(mobile);
		if(checkMobile!=null)
			flag = "no";
		response.getWriter().write(flag);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
