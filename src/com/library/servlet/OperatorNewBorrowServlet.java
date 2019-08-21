package com.library.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.OperatorBorrowBookDao;

public class OperatorNewBorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OperatorNewBorrowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int readerID = Integer.parseInt(request.getParameter("readerID"));
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		String operator = request.getParameter("mans");
		OperatorBorrowBookDao OBB = new OperatorBorrowBookDao();
		//判断读者是否已借最大
		System.out.println("servlet");
		int num = OBB.borrowBookMax(readerID);
		if(num >= 5)
		{
			//已经达到最大借书次数，不能借阅
			System.out.println("num > 5");
		}
		else
		{
			System.out.println("num < 5");
			//判断书籍状态可否借阅
			boolean state = OBB.borrowBookState(bookID);
			
			if(state)
			{
				//可节约
				//借阅
				System.out.println("state is " + state);
				int rs = OBB.borrowBook(readerID,bookID,operator);
				if(rs > 0)
				{
					//一会加一个弹窗，借阅成功
					String sql = "update tb_bookinfo set b_state='已借阅' where b_id=?";
					int i = OBB.updateBorrowBook(bookID, sql);
					if(i > 0)
					{
						response.sendRedirect("operatorbookmessage?type=operator_booksearch");
					}
					
				}
			} else {
				
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
