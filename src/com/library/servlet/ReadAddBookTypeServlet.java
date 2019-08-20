package com.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.bean.BookTypeBean;
import com.library.dao.OperatorAddBookDao;

public class ReadAddBookTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ReadAddBookTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OperatorAddBookDao OAB = new OperatorAddBookDao();
		List<String> list = OAB.traverseBookType();
		HttpSession session = request.getSession();
		session.setAttribute("BOOKTYPE", list);
//		for(String b :list)
//		{
//			
//		}
		response.sendRedirect("/Library/operator/operator_addbook.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
