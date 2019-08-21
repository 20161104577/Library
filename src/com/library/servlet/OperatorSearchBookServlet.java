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
import com.library.bean.BorrowBean;
import com.library.bean.UserBean;
import com.library.dao.BookDao;
import com.library.dao.OperatorBorrowBookDao;
import com.library.dao.OperatorDao;


public class OperatorSearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OperatorSearchBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("search");
		String select = request.getParameter("select");
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		
		if("searchbook".equals(type))
		{
			System.out.println("Select * From tb_bookinfo, tb_booktype where t_id=b_type and "+select+" like "+name);
			BookDao bookDao = new BookDao();
			
			List<BookBean> showBook = bookDao.searchShowBook(name,select);
			
			session.setAttribute("BOOKSHOW", showBook);
			response.sendRedirect("/Library/operator/operator_booksearch.jsp");
			
		} else if("readerborrow".equals(type)) {
			String sql = "Select tb_borrow.b_ID, tb_reader.r_name, tb_reader.r_id, tb_bookinfo.b_name, tb_bookinfo.b_id, tb_booktype.t_name, tb_borrow.b_outTime, tb_borrow.b_backTime, tb_bookinfo.b_location, tb_bookinfo.b_state\r\n" + 
					"FROM tb_bookinfo, tb_booktype, tb_borrow, tb_reader\r\n" + 
					"WHERE\r\n" + 
					"	tb_bookinfo.b_type = tb_booktype.t_id AND\r\n" + 
					"	tb_bookinfo.b_id = tb_borrow.b_bookID AND\r\n" + 
					"	tb_reader.r_id = tb_borrow.b_readerID AND "+select+" like ?";
			System.out.println(sql + name);
			OperatorBorrowBookDao obb = new OperatorBorrowBookDao();
			List<BorrowBean> ssb = obb.searchShowBook(sql,name);
			session.setAttribute("SHOWBORROWBOOK", ssb);
			response.sendRedirect("/Library/operator/operator_readerborrow.jsp");
		} else if("operatorList".equals(type)) {
			String sql = "Select * from tb_user where " + select + " like ?";
			System.out.println(sql + name);
			OperatorDao Odao = new OperatorDao();
			List<UserBean> ssu = Odao.searchShowUser(sql,name);
			session.setAttribute("SHOWUSER", ssu);
			response.sendRedirect("/Library/operator/operatorList.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
