package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.bean.BookBean;
import com.library.util.DBUtil;

public class OperatorSortDao {
	public List<BookBean> SortOrderIdBook(String sql)
	{
		
		List<BookBean> list = new ArrayList<BookBean>();
		Connection con = null;
		PreparedStatement pst = null;
		BookBean book = null;
		try {
			con = DBUtil.getConnection();
//			String sql = "Select * From tb_bookinfo, tb_booktype where t_id=b_type order by b_name desc";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				book = new BookBean();
				
				book.setB_id(rs.getInt("b_id"));
				book.setB_type(rs.getInt("b_type"));
				book.setB_author(rs.getString("b_author"));
				book.setB_intime(rs.getString("b_intime"));
				book.setB_isbn(rs.getString("b_isbn"));
				book.setB_location(rs.getString("b_location"));
				book.setB_name(rs.getString("b_name"));
				book.setB_operator(rs.getString("b_operator"));
				book.setB_press(rs.getString("b_press"));
				book.setB_price(rs.getDouble("b_price"));
				book.setB_translator(rs.getString("b_translator"));
				book.setB_state(rs.getString("b_state"));
				book.setT_name(rs.getString("t_name"));
				book.setT_time(rs.getString("t_time"));
				list.add(book);
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
