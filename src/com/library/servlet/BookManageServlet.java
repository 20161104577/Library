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
import com.library.bean.BorrowBean;
import com.library.bean.GiveBackBean;
import com.library.dao.BookDao;
import com.library.dao.OperatorBorrowBookDao;


public class BookManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BookManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		BookDao bookDao = new BookDao();
		
		if("bookinfo".equals(type))
		{
			String b_id = request.getParameter("sub_id");
			String r_id = request.getParameter("re_id");
			int readerID = Integer.parseInt(r_id);
			OperatorBorrowBookDao OBB = new OperatorBorrowBookDao();
			//判断读者是否已借最大
			int num = OBB.borrowBookMax(readerID);
			if(num >= 5)
			{
				System.out.println("==============");
				PrintWriter out = response.getWriter();
				//如果成功弹出登陆成功并跳到下一个页面
				out.print("alert('登录成功!');");
				//超过五本不可借阅
			} else {
				List<BookBean> showBook = bookDao.showBook();
				if(b_id != null)
				{
					bookDao.updateSubBook(b_id, "预约中");
					int rs = bookDao.appBook(b_id, r_id);
					if(rs > 0)
					{
						showBook = bookDao.showBook();
					} else {
						//状态操作失败时运行
					}
				}
				session.setAttribute("BOOKSHOW", showBook);
				
			}
			response.sendRedirect("/Library/reader/bookinfo.jsp");
			
		} else if("bookapp".equals(type))
		{
			String sql = "Select tb_borrow.b_ID,b_name,b_isbn,b_author,t_name,b_location,b_backtime,b_state\r\n" + 
		"From tb_bookinfo,tb_booktype,tb_reader,tb_borrow \r\n" + 
		"where tb_bookinfo.b_type = tb_booktype.t_id \r\n" + 
		"AND tb_borrow.b_bookID = tb_bookinfo.b_id AND\r\n" + 
		"tb_borrow.b_readerID = tb_reader.r_id and r_id=? and (b_state=\"预约中\" or b_state=\"预约成功\")";
			String r_id = request.getParameter("r_id");
			List<BorrowBean> list = bookDao.Bookapp(r_id, sql);
			
			session.setAttribute("BookAppo", list);
			
			response.sendRedirect("/Library/reader/appointment.jsp");
		} else if("bookhis".equals(type))
		{
			
			String r_id = request.getParameter("r_id");
			//List<BookAppointmentBean> list = bookDao.Bookapp(r_id);
			List<GiveBackBean> list = bookDao.Bookhis(r_id);
			session.setAttribute("BookBack", list);
			
			response.sendRedirect("/Library/reader/history.jsp");
		} else if("bookmy".equals(type))
		{
			String sql = "Select tb_borrow.b_ID,b_name,b_isbn,b_author,t_name,b_location,b_backtime,b_state\r\n" + 
					"From tb_bookinfo,tb_booktype,tb_reader,tb_borrow \r\n" + 
					"where tb_bookinfo.b_type = tb_booktype.t_id \r\n" + 
					"AND tb_borrow.b_bookID = tb_bookinfo.b_id AND\r\n" + 
					"tb_borrow.b_readerID = tb_reader.r_id and r_id=? and (b_state=\"已借阅\" or b_state=\"预约成功\")";
			String r_id = request.getParameter("r_id");
			//List<BookAppointmentBean> list = bookDao.Bookapp(r_id);
			List<BorrowBean> list = bookDao.Bookapp(r_id, sql);
			
			session.setAttribute("BookAppo", list);
			
			
			response.sendRedirect("/Library/reader/mybook.jsp");
		} else if("login".equals(type))
		{
			
			
			
			
			List<BookBean> showBook = bookDao.showBook();
			
			session.setAttribute("BOOKSHOW", showBook);
			if(showBook != null)
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
