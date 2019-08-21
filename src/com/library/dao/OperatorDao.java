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

public class OperatorDao {
	public int AddBook(String bookname, String booknumber, String bookauthor, String booktranslation, String bookstand,String inttime, String operator, String press, String price,
			String state,String kind,String borrowday)
	{
		BookTypeBean btb = new BookTypeBean();
		PreparedStatement pst = null;
		int t_time = Integer.parseInt(borrowday);
		Connection con = null; 
		int rs = 0;
		try {
				con = DBUtil.getConnection();
			    String sql1 = "UPDATE tb_booktype SET t_time=? WHERE t_name=?";
			    pst = con.prepareStatement(sql1);
			    pst.setInt(1, t_time);
			    pst.setString(2, kind);
			    rs = pst.executeUpdate();
			    
			    String sql3 = "select t_id from tb_booktype where t_name=?;";
				PreparedStatement pst2 = con.prepareStatement(sql3);
				pst2.setString(1,kind);
				ResultSet rs1 = pst2.executeQuery();
				while(rs1.next())
				{
					btb.setT_id(rs1.getInt("t_id"));
				}
			    String sql2 = "Insert into tb_bookinfo(b_name, b_author, b_translator, b_isbn, b_price, b_press,b_location,b_intime,b_operator,b_state,b_type) values(?,?,?,?,?,?,?,?,?,?,?);";
				PreparedStatement pst1 = con.prepareStatement(sql2);
				pst1.setString(1, bookname);
				pst1.setString(2, bookauthor);
				pst1.setString(3, booktranslation);
				pst1.setString(4, booknumber);
				pst1.setString(5, price);
				pst1.setString(6, press);
				pst1.setString(7, bookstand);
				pst1.setString(8, inttime);
				pst1.setString(9, operator);
				pst1.setString(10, state);
				pst1.setInt(11, btb.getT_id());
				rs = pst1.executeUpdate();
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.closeDB(con, pst, null);
			}
			return rs;
	}
	public UserBean operatorLogin(int uid, String pwd)
	{
		PreparedStatement pst = null;
		Connection con = null; 
		ResultSet rs = null;
		UserBean userBean = null;
		try {
			con = DBUtil.getConnection();
			String sql = "Select * from tb_user where u_ID=? and u_pwd=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, uid);
			pst.setString(2, pwd);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				userBean = new UserBean();
				userBean.setU_ID(rs.getInt("u_ID"));
				userBean.setU_name(rs.getString("u_name"));
				userBean.setU_pwd(rs.getString("u_pwd"));
				/*
				 * System.out.println("id is " + userBean.getU_ID());
				 * System.out.println("name is " +userBean.getU_name());
				 */
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, null);
		}
		return userBean;
	}
	public List<UserBean> showUser() {
		PreparedStatement pst = null;
		List<UserBean> list = new ArrayList<UserBean>();
		Connection con = null; 
		ResultSet rs = null;
		UserBean userBean = null;
		try {
			con = DBUtil.getConnection();
			String sql = "Select * from tb_user";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				userBean = new UserBean();
				userBean.setU_ID(rs.getInt("u_ID"));
				userBean.setU_name(rs.getString("u_name"));
				userBean.setU_pwd(rs.getString("u_pwd"));
				list.add(userBean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, rs);
		}
		return list;
	}
	
	public List<UserBean> searchShowUser(String sql, String name) {
		PreparedStatement pst = null;
		List<UserBean> list = new ArrayList<UserBean>();
		Connection con = null; 
		ResultSet rs = null;
		UserBean userBean = null;
		try {
			con = DBUtil.getConnection();
			
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+name+"%");
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				userBean = new UserBean();
				userBean.setU_ID(rs.getInt("u_ID"));
				userBean.setU_name(rs.getString("u_name"));
				userBean.setU_pwd(rs.getString("u_pwd"));
				list.add(userBean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, rs);
		}
		return list;
	}
	
	public UserBean selectUser(int id) {
		PreparedStatement pst = null;
		Connection con = null; 
		ResultSet rs = null;
		UserBean userBean = new UserBean();
		try {
			con = DBUtil.getConnection();
			String sql = "Select * from tb_user where u_ID=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				userBean.setU_ID(rs.getInt("u_ID"));
				userBean.setU_name(rs.getString("u_name"));
				userBean.setU_pwd(rs.getString("u_pwd"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, rs);
		}
		return userBean;
	}
	
	public int updateUser(int uid, String username, String pwd) {
		PreparedStatement pst = null;
		Connection con = null; 
		int rs = 0;
		try {
			con = DBUtil.getConnection();
			String sql = "Update tb_user set u_name=?,u_pwd=? where u_ID=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, pwd);
			pst.setInt(3, uid);
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, null);
		}
		return rs;
	}
	
	public int deleteUser(int id) {
		PreparedStatement pst = null;
		Connection con = null; 
		int rs = 0;
		try {
			con = DBUtil.getConnection();
			String sql = "Delete From tb_user where u_ID=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, null);
		}
		return rs;
	}
	
	public int addUser(String name, String pwd) {
		PreparedStatement pst = null;
		Connection con = null; 
		int rs = 0;
		try {
			con = DBUtil.getConnection();
			String sql = "Insert into tb_user(u_name,u_pwd) values(?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, pwd);
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, null);
		}
		return rs;
	}
}
