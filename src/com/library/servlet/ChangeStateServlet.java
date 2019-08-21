package com.library.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.BorrowBean;
import com.library.dao.OperatorBorrowBookDao;

@WebServlet("/ChangeStateServlet")
public class ChangeStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangeStateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		int id = Integer.parseInt(request.getParameter("id"));
		OperatorBorrowBookDao OBB = new OperatorBorrowBookDao();
		
		if("one".equals(type))
		{
			String sql = "update tb_bookinfo set b_state='预约成功' where b_id=?";
			int rs = OBB.updateBorrowBook(id, sql);
			if(rs > 0)
			{
				response.sendRedirect("OperatorBorrowBookInfo");
			}
		} else if("two".equals(type))
		{
			int boid = Integer.parseInt(request.getParameter("boid"));
			String operator = request.getParameter("op");
			//先将借阅信息写入
			int rs = OBB.updateBorrowBookAndTime(boid,operator);
			//再将state改变
			String sql = "update tb_bookinfo set b_state='已借阅' where b_id=?";
			rs = OBB.updateBorrowBook(id, sql);
			if(rs > 0)
			{
				response.sendRedirect("OperatorBorrowBookInfo");
			}
		} else if("three".equals(type))
		{
			System.out.println("three");
			//首先将书籍状态更新为可预约
			String sql = "update tb_bookinfo set b_state='可预约' where b_id=?";
			int b_id = Integer.parseInt(request.getParameter("b_id"));
			int rs = OBB.updateBorrowBook(id, sql);
			if(rs > 0)
			{
				//先将ifback值修改为1证明已经归还
				OBB.updateBorrowIfback(b_id);
				System.out.println("b_ID" + b_id);
				//更改成功后将归还表写入数据
				BorrowBean borrow = OBB.getBorrowBook(b_id);
				
				//如果ifback为1说明已归还，不欠费
				System.out.println(borrow.getB_ID()+ "is"+borrow.getB_ifBack());
				if(borrow.getB_ifBack()==1)
				{
					System.out.println("borrow.getB_ifBack()==1");
					//将borrow表中借阅信息删除
					OBB.deleteBorrow(b_id);
				}
				int i = OBB.giveBackBook(borrow);
				if(i > 0)
				{
					response.sendRedirect("OperatorBorrowBookInfo");
				}
				
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
