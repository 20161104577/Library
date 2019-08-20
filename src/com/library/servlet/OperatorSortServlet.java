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
import com.library.dao.OperatorSortDao;


public class OperatorSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OperatorSortServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		HttpSession session1 = request.getSession();
		OperatorSortDao osdao = new OperatorSortDao();
		//id
		if("soid".equals(type))
		{
			String sql = "Select * From tb_bookinfo, tb_booktype where t_id=b_type order by b_id asc";
			List<BookBean> soib = osdao.SortOrderIdBook(sql);
			
			session1.setAttribute("BOOKSHOW", soib);
			response.sendRedirect("/Library/operator/operator_booksearch.jsp");
		}
		else if("soname".equals(type))
		{
			String sql = "Select * From tb_bookinfo, tb_booktype where t_id=b_type order by b_name asc";
			List<BookBean> soib = osdao.SortOrderIdBook(sql);
			
			session1.setAttribute("BOOKSHOW", soib);
			response.sendRedirect("/Library/operator/operator_booksearch.jsp");
		}
		else if("sonum".equals(type))
		{
			String sql = "Select * From tb_bookinfo, tb_booktype where t_id=b_type order by b_isbn asc";
			List<BookBean> soib = osdao.SortOrderIdBook(sql);
			
			session1.setAttribute("BOOKSHOW", soib);
			response.sendRedirect("/Library/operator/operator_booksearch.jsp");
		}
		else if("soauthor".equals(type))
		{
			String sql = "Select * From tb_bookinfo, tb_booktype where t_id=b_type order by b_author asc";
			List<BookBean> soib = osdao.SortOrderIdBook(sql);
			
			session1.setAttribute("BOOKSHOW", soib);
			response.sendRedirect("/Library/operator/operator_booksearch.jsp");
		}
		else if("sotranslation".equals(type))
		{
			String sql = "Select * From tb_bookinfo, tb_booktype where t_id=b_type order by b_translator asc";
			List<BookBean> soib = osdao.SortOrderIdBook(sql);
			
			session1.setAttribute("BOOKSHOW", soib);
			response.sendRedirect("/Library/operator/operator_booksearch.jsp");
		}
		else if("sokind".equals(type))
		{
			String sql = "Select * From tb_bookinfo, tb_booktype where t_id=b_type order by t_name asc";
			List<BookBean> soib = osdao.SortOrderIdBook(sql);
			
			session1.setAttribute("BOOKSHOW", soib);
			response.sendRedirect("/Library/operator/operator_booksearch.jsp");
		}
		else if("sobday".equals(type))
		{
			String sql = "Select * From tb_bookinfo, tb_booktype where t_id=b_type order by t_time asc";
			List<BookBean> soib = osdao.SortOrderIdBook(sql);
			
			session1.setAttribute("BOOKSHOW", soib);
			response.sendRedirect("/Library/operator/operator_booksearch.jsp");
		}
		else if("solocation".equals(type))
		{
			String sql = "Select * From tb_bookinfo, tb_booktype where t_id=b_type order by b_location asc";
			List<BookBean> soib = osdao.SortOrderIdBook(sql);
			
			session1.setAttribute("BOOKSHOW", soib);
			response.sendRedirect("/Library/operator/operator_booksearch.jsp");
		}
		else if("sopress".equals(type))
		{
			String sql = "Select * From tb_bookinfo, tb_booktype where t_id=b_type order by b_press asc";
			List<BookBean> soib = osdao.SortOrderIdBook(sql);
			
			session1.setAttribute("BOOKSHOW", soib);
			response.sendRedirect("/Library/operator/operator_booksearch.jsp");
		}
		else if("sostate".equals(type))
		{
			String sql = "Select * From tb_bookinfo, tb_booktype where t_id=b_type order by b_state asc";
			List<BookBean> soib = osdao.SortOrderIdBook(sql);
			
			session1.setAttribute("BOOKSHOW", soib);
			response.sendRedirect("/Library/operator/operator_booksearch.jsp");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
