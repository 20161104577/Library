package com.library.servlet;

import java.io.IOException;
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
import com.library.dao.BookDao;
import com.library.dao.OperatorAddBookDao;

public class UpdateBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateBookInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String type = request.getParameter("type");
		String id = request.getParameter("b_id");
		BookDao bookDao = new BookDao();
		System.out.println(type);
		if("look".equals(type))
		{
			OperatorAddBookDao OAB = new OperatorAddBookDao();
			List<String> list = OAB.traverseBookType();
			session.setAttribute("BOOKTYPE", list);
			BookBean book = bookDao.searchIDShowBook(id);
			session.setAttribute("BOOKLOAD", book);
			response.sendRedirect("/Library/operator/operator_update.jsp");
		} else if("update".equals(type))
		{
			System.out.println("servlet id" + id);
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
			int rs = bookDao.updateBook(id, bookname, booknumber, bookauthor, booktranslation, bookstand, inttime, operator, press, price, kind, borrowday);
			if(rs > 0)
			{
				System.out.println("修改完成");
				response.sendRedirect("operatorbookmessage?type=operator_booksearch");
			}
		}  else if("delete".equals(type))
		{
			int rs = bookDao.deleteBook(id);
			if(rs > 0)
			{
				System.out.println("删除完成");
				response.sendRedirect("operatorbookmessage?type=operator_booksearch");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
