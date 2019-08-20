package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.bean.BookTypeBean;
import com.library.bean.UserBean;
import com.library.util.DBUtil;

public class OperatorAddBookDao {
	public List<String> traverseBookType() 
	{
		PreparedStatement pst = null;
		List<String> list = new ArrayList<String>();
		Connection con = null; 
		ResultSet rs = null;
		UserBean userBean = new UserBean();
		try {
			con = DBUtil.getConnection();
			String sql = "Select * from tb_booktype";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				String s = rs.getString("t_name");
				list.add(s);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, null);
		}
		return list;
	}
}
