package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.bean.BookBean;
import com.library.bean.UserBean;
import com.library.dao.BookDao;
import com.library.dao.OperatorDao;


public class OperatorManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OperatorManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pwd = request.getParameter("password");
		String type = request.getParameter("type");
		OperatorDao operatorDao = new OperatorDao();
		UserBean userBean = new UserBean();
		HttpSession session = request.getSession();
		
		
		if("regist".equals(type))
		{
			
		} else if("login".equals(type))
		{
			BookDao bookDao = new BookDao();
			int uid = Integer.valueOf(request.getParameter("uid"));
			System.out.println(uid);
			System.out.println(pwd);
			userBean = operatorDao.operatorLogin(uid, pwd);
			List<BookBean> showBook = bookDao.showBook();
			session.setAttribute("BOOKSHOW", showBook);
			
			if(userBean != null)
			{
				session.setAttribute("USERBEAN", userBean);
				
				response.sendRedirect("/Library/operator/operator_booksearch.jsp");
			} else {
				PrintWriter out=response.getWriter();

				out.print("<script language='javascript'>alert('登录已失效请重新登陆');window.location.href='readerlogin.jsp';</script>");
				
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
