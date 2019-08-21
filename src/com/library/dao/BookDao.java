package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import com.library.bean.BookBean;
import com.library.bean.BookInfoBean;
import com.library.bean.BorrowBean;
import com.library.bean.GiveBackBean;

import com.library.util.DBUtil;


public class BookDao {
	
	
	public List<BookBean> showBook()
	{
		
		List<BookBean> list = new ArrayList<BookBean>();
		Connection con = null;
		PreparedStatement pst = null;
		BookBean book = null;
		try {
			con = DBUtil.getConnection();
			String sql = "Select * From tb_bookinfo, tb_booktype where t_id=b_type";
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
	
	public BookBean searchIDShowBook(String id)
	{
		System.out.println("searchIDShowBook");
		Connection con = null;
		PreparedStatement pst = null;
		BookBean book = new BookBean();
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = "Select * From tb_bookinfo, tb_booktype where t_id=b_type and b_id=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			while(rs.next())
			{
				System.out.println("2");
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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DBUtil.closeDB(con, pst, rs);
		}
		return book;
	}
	
	public List<BookBean> searchShowBook(String name, String select)
	{
		List<BookBean> list = new ArrayList<BookBean>();
		Connection con = null;
		PreparedStatement pst = null;
		BookBean book = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = "Select * From tb_bookinfo, tb_booktype where t_id=b_type and "+select+" like ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+name+"%");
			rs = pst.executeQuery();
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
				System.out.println(book.getB_id());
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DBUtil.closeDB(con, pst, rs);
		}
		return list;
	}
	
	public int appBook(String b_id, String r_id)
	{
		Connection conn = null;
		PreparedStatement pst = null;
		int rs = 0;
		try {
			//获取两小时之后的系统时间nowTime
			long currentTime = System.currentTimeMillis() + 120 * 60 * 1000;
			Date date = new Date(currentTime);
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
			String nowTime = s.format(date);
			
			conn = DBUtil.getConnection();
			String sql = "Insert into tb_borrow(b_readerID, b_bookID, b_nowTime,b_ifBack) values(?,?,?,?);";
			pst = conn.prepareStatement(sql);
			pst.setString(1, r_id);
			pst.setString(2, b_id);
			pst.setString(3, nowTime);
			pst.setInt(4, 0);
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(conn, pst, null);
		}
		return rs;
	}
	
	public int updateBook(String id, String bookname, String booknumber, String bookauthor, String booktranslation, String bookstand, String inttime, String operator, String press, String price, String kind, String borrowday)
	{
		Connection conn = null;
		PreparedStatement pst = null;
		int rs = 0;
		System.out.println("id he borrowday he price"+borrowday+id+price);
		int i = Integer.parseInt(borrowday);
		int j = Integer.parseInt(id);
		Double pri = Double.parseDouble(price);
		try {
			
			conn = DBUtil.getConnection();
			String sql = "UPDATE tb_bookinfo,tb_booktype SET b_name=?, b_author=?, b_translator=?, b_isbn=?, b_press=?,b_location=?,b_intime=?,b_operator=?,b_type=t_id, t_time=?, b_price=? WHERE t_name=? AND b_id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, bookname);
			pst.setString(2, bookauthor);
			pst.setString(3, booktranslation);
			pst.setString(4, booknumber);
			pst.setString(5, press);
			pst.setString(6, bookstand);
			pst.setString(7, inttime);
			pst.setString(8, operator);
			pst.setInt(9, i);
			pst.setDouble(10, pri);
			pst.setString(11, kind);
			pst.setInt(12, j);
			
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(conn, pst, null);
		}
		return rs;
	}
	
	public int updateSubBook(String b_id, String state)
	{
		Connection conn = null;
		PreparedStatement pst = null;
		int rs = 0;
		try {
			
			conn = DBUtil.getConnection();
			String sql = "update tb_bookinfo set b_state=? where b_id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, state);
			pst.setString(2, b_id);
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(conn, pst, null);
		}
		return rs;
	}
	
	public int deleteBook(String id)
	{
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		int i = Integer.parseInt(id);
		try {
			con = DBUtil.getConnection();
			String sql = "DELETE from tb_bookinfo where b_id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, i);
			rs = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, null);
		}
		return rs;
	}
	
	
	public List<BorrowBean> Bookapp(String r_id, String sql)
	{
		List<BorrowBean> list = new ArrayList<BorrowBean>();
		Connection con = null;
		PreparedStatement pst = null;
		BorrowBean book = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			
			pst = con.prepareStatement(sql);
			pst.setString(1, r_id);
			rs = pst.executeQuery();
			while(rs.next())
			{
				book = new BorrowBean();
				book.setB_ID(rs.getInt("tb_borrow.b_ID"));
				book.setB_backTime(rs.getString("b_backTime"));
				book.setB_author(rs.getString("b_author"));
				book.setB_isbn(rs.getString("b_isbn"));
				book.setB_location(rs.getString("b_location"));
				book.setB_name(rs.getString("b_name"));
				book.setB_state(rs.getString("b_state"));
				book.setT_name(rs.getString("t_name"));
				
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, rs);
		}
		return list;
	}
	
	public List<BorrowBean> searchBookApp(String sql, String name)
	{
		List<BorrowBean> list = new ArrayList<BorrowBean>();
		Connection con = null;
		PreparedStatement pst = null;
		BorrowBean book = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+name+"%");
			rs = pst.executeQuery();
			while(rs.next())
			{
				book = new BorrowBean();
				book.setB_ID(rs.getInt("tb_borrow.b_ID"));
				book.setB_backTime(rs.getString("b_backTime"));
				book.setB_author(rs.getString("b_author"));
				book.setB_isbn(rs.getString("b_isbn"));
				book.setB_location(rs.getString("b_location"));
				book.setB_name(rs.getString("b_name"));
				book.setB_state(rs.getString("b_state"));
				book.setT_name(rs.getString("t_name"));
				
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, rs);
		}
		return list;
	}
	
	public List<GiveBackBean> Bookhis(String r_id)
	{
		List<GiveBackBean> list = new ArrayList<GiveBackBean>();
		Connection con = null;
		PreparedStatement pst = null;
		GiveBackBean book = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = "SELECT g_ID, b_name,b_isbn,b_author,t_name,b_location,g_backtime,b_ifBack\r\n" + 
					"FROM tb_bookinfo,tb_booktype,tb_borrow,tb_giveback,tb_reader\r\n" + 
					"WHERE \r\n" + 
					"tb_bookinfo.b_type = tb_booktype.t_id AND\r\n" + 
					"tb_borrow.b_bookID = tb_bookinfo.b_id and \r\n" + 
					"tb_giveback.g_bookID = tb_bookinfo.b_id AND\r\n" + 
					"tb_borrow.b_readerID = tb_reader.r_id AND\r\n" + 
					"tb_giveback.g_readerID = tb_reader.r_id and r_id=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, r_id);
			rs = pst.executeQuery();
			while(rs.next())
			{
				book = new GiveBackBean();
				book.setG_ID(rs.getInt("g_ID"));
				book.setB_name(rs.getString("b_name"));
				book.setB_isbn(rs.getString("b_isbn"));
				book.setB_author(rs.getString("b_author"));
				book.setT_name(rs.getString("t_name"));
				book.setB_location(rs.getString("b_location"));
				book.setG_backtime(rs.getString("g_backtime"));
				book.setB_ifBack(rs.getInt("b_ifBack"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, rs);
		}
		return list;
	}
	
	public List<GiveBackBean> searchBookHis(String sql, String name)
	{
		List<GiveBackBean> list = new ArrayList<GiveBackBean>();
		Connection con = null;
		PreparedStatement pst = null;
		GiveBackBean book = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+name+"%");
			rs = pst.executeQuery();
			while(rs.next())
			{
				book = new GiveBackBean();
				book.setG_ID(rs.getInt("g_ID"));
				book.setB_name(rs.getString("b_name"));
				book.setB_isbn(rs.getString("b_isbn"));
				book.setB_author(rs.getString("b_author"));
				book.setT_name(rs.getString("t_name"));
				book.setB_location(rs.getString("b_location"));
				book.setG_backtime(rs.getString("g_backtime"));
				book.setB_ifBack(rs.getInt("b_ifBack"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, rs);
		}
		return list;
	}
	
	public String borrowBackTime(String b_id)
	{
		Connection conn = null;
		int id = Integer.parseInt(b_id);
		PreparedStatement pst = null;
		String date = null;
		//获得归还日期
		try {
			conn = DBUtil.getConnection();
			String sql = "Select b_backTime from tb_borrow where b_ID=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				date = rs.getString("b_backTime");
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	//通过b_id号查找书籍将借阅时间加长
	public int isbnBook(String b_id, String str)
	{
		//获得当前系统一个月后的时间date
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
		Calendar rightNow = Calendar.getInstance();  
		rightNow.setTime(date);  
        rightNow.add(Calendar.MONTH, 1);  
        Date dt1 = rightNow.getTime();  
        String reStr = s.format(dt1); 
		System.out.println(reStr);
		
		Connection conn = null;
		PreparedStatement pst = null;
		int rs = 0;
		try {
			
			conn = DBUtil.getConnection();
			String sql = "update tb_borrow set b_backTime=? where b_ID=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, reStr);
			pst.setString(2, b_id);
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(conn, pst, null);
		}
		return rs;
	}

}
