package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.bean.BookBean;
import com.library.bean.BookInfoBean;
import com.library.bean.ReaderBean;
import com.library.dao.BookDao;
import com.library.dao.ReaderDao;


public class ReaderManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReaderManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mobile = request.getParameter("mobile");
		String pwd = request.getParameter("password");
		String type = request.getParameter("type");
		
		ReaderDao readerDao = new ReaderDao();
		ReaderBean readerBean = new ReaderBean();
		
		HttpSession session = request.getSession();
		
		
		if("regist".equals(type))
		{
			String username = request.getParameter("username");
			String papertype = request.getParameter("papertype");
			String paperno = request.getParameter("paperno");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String registdate = df.format(new Date());
			int rs = readerDao.readerRegist(mobile, pwd, username, papertype, paperno, registdate);
			if(rs > 0)
			{
				response.sendRedirect("/Library/LoAndRe/readerlogin.jsp");
			} else {
				PrintWriter out=response.getWriter();

				out.print("<script language='javascript'>alert('注册失败请重新注册！');window.location.href='readerregist.jsp';</script>");
				
			}
		}
		else if("login".equals(type))
		{
			BookDao bookDao = new BookDao();
			
			readerBean = readerDao.readerLogin(mobile, pwd);
			
			List<BookBean> showBook = bookDao.showBook();
			session.setAttribute("READER", readerBean);
			session.setAttribute("BOOKSHOW", showBook);
			if(readerBean != null)
			{
				response.sendRedirect("/Library/reader/bookinfo.jsp");
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
