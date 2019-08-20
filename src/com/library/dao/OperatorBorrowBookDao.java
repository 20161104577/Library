package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import com.library.bean.BorrowBean;
import com.library.util.DBUtil;

public class OperatorBorrowBookDao {
	public List<BorrowBean> showBook()
	{
		
		List<BorrowBean> list = new ArrayList<BorrowBean>();
		Connection con = null;
		PreparedStatement pst = null;
		BorrowBean book = null;
		try {
			con = DBUtil.getConnection();
			String sql = "Select tb_borrow.b_ID, tb_reader.r_name, tb_reader.r_id, tb_bookinfo.b_name, tb_bookinfo.b_id, tb_booktype.t_name, tb_borrow.b_outTime, tb_borrow.b_backTime, tb_bookinfo.b_location, tb_bookinfo.b_state\r\n" + 
					"FROM tb_bookinfo, tb_booktype, tb_borrow, tb_reader\r\n" + 
					"WHERE\r\n" + 
					"	tb_bookinfo.b_type = tb_booktype.t_id AND\r\n" + 
					"	tb_bookinfo.b_id = tb_borrow.b_bookID AND\r\n" + 
					"	tb_reader.r_id = tb_borrow.b_readerID\r\n" + 
					"";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				book = new BorrowBean();
				book.setB_ID(rs.getInt("tb_borrow.b_ID"));
				book.setR_name(rs.getString("tb_reader.r_name"));
				book.setR_id(rs.getInt("tb_reader.r_id"));
				book.setB_name(rs.getString("tb_bookinfo.b_name"));
				book.setBinfo_id(rs.getInt("tb_bookinfo.b_id"));
				book.setT_name(rs.getString("tb_booktype.t_name"));
				book.setB_outTime(rs.getString("tb_borrow.b_outTime"));
				book.setB_backTime(rs.getString("tb_borrow.b_backTime"));
				book.setB_location(rs.getString("tb_bookinfo.b_location"));
				book.setB_state(rs.getString("tb_bookinfo.b_state"));
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
	
	public List<BorrowBean> searchShowBook(String sql, String name)
	{
		
		List<BorrowBean> list = new ArrayList<BorrowBean>();
		Connection con = null;
		PreparedStatement pst = null;
		BorrowBean book = null;
		try {
			con = DBUtil.getConnection();
			
					
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+name+"%");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				System.out.println("获得了rs");
				book = new BorrowBean();
				book.setB_ID(rs.getInt("tb_borrow.b_ID"));
				book.setR_name(rs.getString("tb_reader.r_name"));
				book.setR_id(rs.getInt("tb_reader.r_id"));
				book.setB_name(rs.getString("tb_bookinfo.b_name"));
				book.setBinfo_id(rs.getInt("tb_bookinfo.b_id"));
				book.setT_name(rs.getString("tb_booktype.t_name"));
				book.setB_outTime(rs.getString("tb_borrow.b_outTime"));
				book.setB_backTime(rs.getString("tb_borrow.b_backTime"));
				book.setB_location(rs.getString("tb_bookinfo.b_location"));
				book.setB_state(rs.getString("tb_bookinfo.b_state"));
				
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
	
	
	
	public int updateBorrowBook(int b_id, String sql)
	{
		Connection conn = null;
		PreparedStatement pst = null;
		int rs = 0;
		try {
			
			conn = DBUtil.getConnection();
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, b_id);
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(conn, pst, null);
		}
		return rs;
	}
	
	public int borrowBookMax(int b_id)
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int num = 0;
		try {
			
			conn = DBUtil.getConnection();
			String sql = "Select b_ID from tb_borrow where tb_borrow.b_readerID = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, b_id);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				num++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(conn, pst, null);
		}
		return num;
	}

	public int borrowBook(int readerID, int bookID, String operator) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		int rs = 0;
		//获取当前系统时间
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
		String outTime = s.format(new Date());
		//获取一个月以后的系统时间
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 30);
		s = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
		
		String backTime = s.format(cal.getTime());
		
		try {
			
			conn = DBUtil.getConnection();
			String sql = "Insert into tb_borrow(b_readerID, b_bookID, b_outTime, b_backTime, b_operator, b_ifBack) values(?,?,?,?,?,?);";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, readerID);
			pst.setInt(2, bookID);
			pst.setString(3, outTime);
			pst.setString(4, backTime);
			pst.setString(5, operator);
			pst.setInt(6, 0);
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(conn, pst, null);
		}
		return rs;
	}
	public boolean borrowBookState(int b_id)
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String state = null;
		try {
			
			conn = DBUtil.getConnection();
			String sql = "Select b_state from tb_bookinfo where b_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, b_id);
			rs = pst.executeQuery();
			while(rs.next())
			{
				state = rs.getString("b_state");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(conn, pst, null);
		}
		if("可预约".equals(state))
		{
			return true;
		}
		else {
			return false;
		}
	}



	public int updateBorrowBookAndTime(int id, String op) {
		// TODO Auto-generated method stub
		//设置当前系统时间和一个月以后系统时间
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 30);
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
		String nowdate = s.format(new Date());
		String date = s.format(cal.getTime());
		
		Connection conn = null;
		PreparedStatement pst = null;
		int rs = 0;
		try {
			System.out.println("进入TRY");
			conn = DBUtil.getConnection();
			String sql = "update tb_borrow set b_outTime=?,b_backTime=?,b_operator=? where b_ID=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, nowdate);
			pst.setString(2, date);
			pst.setString(3, op);
			pst.setInt(4, id);
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(conn, pst, null);
		}
		return rs;
	}

	public BorrowBean getBorrowBook(int b_id) {
		System.out.println("进入getBorrowBook");
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		BorrowBean borrow = new BorrowBean();
		try {
			
			conn = DBUtil.getConnection();
			String sql = "Select * from tb_borrow where b_ID = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, b_id);
			rs = pst.executeQuery();
			while(rs.next())
			{
				
				borrow.setB_ID(rs.getInt("b_ID"));
				borrow.setB_readerID(rs.getInt("b_readerID"));
				borrow.setB_bookID(rs.getInt("b_bookID"));
				borrow.setB_backTime(rs.getString("b_backTime"));
				borrow.setB_outTime(rs.getString("b_outTime"));
				borrow.setB_operator(rs.getString("b_operator"));
				borrow.setB_ifBack(rs.getInt("b_ifBack"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(conn, pst, rs);
		}
		System.out.println("ID is " +borrow.getB_ID());
		return borrow;
	}

	public int giveBackBook(BorrowBean borrow) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		int rs = 0;
		//获取当前系统时间
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
		String nowdate = s.format(new Date());
		try {
			
			conn = DBUtil.getConnection();
			String sql = "Insert into tb_giveback(g_readerID,g_bookID,g_backtime,g_operator) values(?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, borrow.getB_readerID());
			pst.setInt(2, borrow.getB_bookID());
			pst.setString(3, nowdate);
			pst.setString(4, borrow.getB_operator());
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(conn, pst, null);
		}
		return rs;
	}

	public void deleteBorrow(int b_id) {
		// TODO Auto-generated method stub
		System.out.println("deleteBorrow");
		Connection conn = null;
		PreparedStatement pst = null;
		int rs = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "Delete from tb_borrow where b_ID=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, b_id);
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(conn, pst, null);
		}
	}

	public void updateBorrowIfback(int b_id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		int rs = 0;
		System.out.println("updateBorrowIfback");
		try {
			
			conn = DBUtil.getConnection();
			String sql = "UPDATE tb_borrow set b_ifBack=1 where b_ID=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, b_id);
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(conn, pst, null);
		}
	}
}

