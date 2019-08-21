package com.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.bean.UserBean;
import com.library.dao.OperatorDao;


public class ListOfOperatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListOfOperatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		OperatorDao Odao = new OperatorDao();
		HttpSession session = request.getSession();
		if("show".equals(type))
		{
			List<UserBean> showUser = Odao.showUser();
			if(showUser!=null)
			{
				//如果列表不为空，则输出管理员列表
				session.setAttribute("SHOWUSER", showUser);
				response.sendRedirect("/Library/operator/operatorList.jsp");
			}
		} else if("select".equals(type))
		{//选择对应的user加载到修改界面
			int uid = Integer.parseInt(request.getParameter("uid"));
			UserBean user = Odao.selectUser(uid);
			session.setAttribute("SELECTUSER", user);
			response.sendRedirect("/Library/operator/operator_updateUser.jsp");
			
		} else if("update".equals(type))
		{
			int uid = Integer.parseInt(request.getParameter("uid"));
			String username = request.getParameter("username");
			String pwd = request.getParameter("password");
			//然后将user数据修改
			int rs = Odao.updateUser(uid, username, pwd);
			if(rs > 0)
			{
				response.sendRedirect("operatorbookmessage?type=operator_booksearch");
			}
			
		} else if("delete".equals(type))
		{
			int uid = Integer.parseInt(request.getParameter("uid"));
			int rs = Odao.deleteUser(uid);
			if(rs > 0)
			{//删除成功
				response.sendRedirect("operatorbookmessage?type=operator_booksearch");
			}
		} else if("add".equals(type))
		{//选择对应的user加载到修改界面
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			int rs = Odao.addUser(username, password);
			if(rs > 0)
			{//添加成功
				response.sendRedirect("operatorbookmessage?type=operator_booksearch");
			}
			
			
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
