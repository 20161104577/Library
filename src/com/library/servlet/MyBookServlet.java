package com.library.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BookDao;

public class MyBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String b_id = request.getParameter("b_ID");
		String r_id = request.getParameter("r_id");
		System.out.println(b_id);
		BookDao bookDao = new BookDao();
		String date = bookDao.borrowBackTime(b_id);
		int rs = bookDao.isbnBook(b_id, date);
		if(rs > 0)
		{
			System.out.println("续借时间延长成功");
			response.sendRedirect("bookmanage1?type=bookmy&r_id="+r_id);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
