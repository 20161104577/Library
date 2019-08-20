package com.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.bean.BorrowBean;
import com.library.dao.OperatorBorrowBookDao;


public class OperatorBorrowBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OperatorBorrowBookInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		OperatorBorrowBookDao obb = new OperatorBorrowBookDao();
		
		List<BorrowBean> showBook = obb.showBook();
		session.setAttribute("SHOWBORROWBOOK", showBook);
	//	response.sendRedirect("OperatorBorrowBookInfo");
		response.sendRedirect("/Library/operator/operator_readerborrow.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
