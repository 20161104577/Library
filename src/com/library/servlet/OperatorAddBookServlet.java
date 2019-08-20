package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.bean.BookBean;
import com.library.bean.ReaderBean;
import com.library.bean.UserBean;
import com.library.dao.OperatorDao;
import com.library.dao.BookDao;
import com.library.dao.ReaderDao;


public class OperatorAddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OperatorAddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OperatorDao operatordao = new OperatorDao();
		UserBean userbean = new UserBean();
		HttpSession session = request.getSession();
		String bookname = request.getParameter("bookname");
		String booknumber = request.getParameter("booknumber");
		String borrowday = request.getParameter("borrowday");
		String bookauthor = request.getParameter("bookauthor");
		String booktranslation= request.getParameter("booktranslation");
		String kind = request.getParameter("kind");
		String bookstand = request.getParameter("bookstand");
		String operator = request.getParameter("operator");
		String press = request.getParameter("press");
		String price = request.getParameter("price");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String inttime = df.format(new Date());
		String state = "可预约";
		int rs = operatordao.AddBook(bookname, booknumber, bookauthor, booktranslation, bookstand, inttime, operator, press, price, state,kind,borrowday);
		if(rs > 0)
		{
			response.sendRedirect("operatorbookmessage?type=operator_booksearch");
		} else {
			PrintWriter out=response.getWriter();

			out.print("<script language='javascript'>alert('注册失败请重新注册！');window.location.href='readerregist.jsp';</script>");
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
