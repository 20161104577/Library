package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.bean.BookBean;
import com.library.bean.BorrowBean;
import com.library.bean.GiveBackBean;
import com.library.dao.BookDao;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("search");
		String select = request.getParameter("select");
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		
		if("bookinfo".equals(type)) {
			BookDao bookDao = new BookDao();
			
			List<BookBean> showBook = bookDao.searchShowBook(name,select);
			
			session.setAttribute("BOOKSHOW", showBook);
			response.sendRedirect("/Library/reader/bookinfo.jsp");
		} else if("history".equals(type)) {
			String r_id = request.getParameter("r_id");
			String sql = "SELECT g_ID, b_name,b_isbn,b_author,t_name,b_location,g_backtime,b_ifBack\r\n" + 
					"FROM tb_bookinfo,tb_booktype,tb_borrow,tb_giveback,tb_reader\r\n" + 
					"WHERE \r\n" + 
					"tb_bookinfo.b_type = tb_booktype.t_id AND\r\n" + 
					"tb_borrow.b_bookID = tb_bookinfo.b_id and \r\n" + 
					"tb_giveback.g_bookID = tb_bookinfo.b_id AND\r\n" + 
					"tb_borrow.b_readerID = tb_reader.r_id AND\r\n" + 
					"tb_giveback.g_readerID = tb_reader.r_id and r_id="+r_id + " AND " + select + " Like ?";
			System.out.println(sql + name);
			//List<BookAppointmentBean> list = bookDao.Bookapp(r_id);
			BookDao bookDao = new BookDao();
			List<GiveBackBean> list = bookDao.searchBookHis(sql,name);
			session.setAttribute("BookBack", list);
			
			response.sendRedirect("/Library/reader/history.jsp");
		} else if("mybook".equals(type)) {
			String r_id = request.getParameter("r_id");
			String sql = "Select tb_borrow.b_ID,b_name,b_isbn,b_author,t_name,b_location,b_backtime,b_state\r\n" + 
					"From tb_bookinfo,tb_booktype,tb_reader,tb_borrow \r\n" + 
					"where tb_bookinfo.b_type = tb_booktype.t_id \r\n" + 
					"AND tb_borrow.b_bookID = tb_bookinfo.b_id AND\r\n" + 
					"tb_borrow.b_readerID = tb_reader.r_id and r_id="+r_id+" and (b_state=\"已借阅\" or b_state=\"预约成功\")  And " + select + " like ?";
			System.out.println(sql + name);
			//List<BookAppointmentBean> list = bookDao.Bookapp(r_id);
			BookDao bookDao = new BookDao();
			List<BorrowBean> list = bookDao.searchBookApp(sql, name);
			
			session.setAttribute("BookAppo", list);
			
			
			response.sendRedirect("/Library/reader/mybook.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
