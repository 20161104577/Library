package com.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.bean.BookBean;
import com.library.dao.BookDao;

/**
 * Servlet implementation class OperatorBookSearch
 */
/* @WebServlet("/OperatorBookSearch") */
public class OperatorBookMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OperatorBookMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		BookDao bookDao = new BookDao();
		
		if("operator_booksearch".equals(type))
		{
			
			List<BookBean> showBook = bookDao.showBook();
			
			session.setAttribute("BOOKSHOW", showBook);
			response.sendRedirect("/Library/operator/operator_booksearch.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
