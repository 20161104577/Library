package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.bean.ReaderBean;
import com.library.bean.UserBean;
import com.library.util.DBUtil;

public class ReaderDao {

	public int readerRegist(String mobile, String pwd, String name, String papertype, String paperno, String registdate)
	{
		
		PreparedStatement pst = null;
		Connection con = null; 
		int rs = 0;
		try {
			con = DBUtil.getConnection();
			String sql = "Insert into tb_reader(r_mobile, r_pwd, r_name, r_paperType, r_paperNo, r_registdate) values(?,?,?,?,?,?);";
			pst = con.prepareStatement(sql);
			pst.setString(1, mobile);
			pst.setString(2, pwd);
			pst.setString(3, name);
			pst.setString(4, papertype);
			pst.setString(5, paperno);
			pst.setString(6, registdate);
			rs = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, null);
		}
		return rs;
	}
	
	public ReaderBean readerLogin(String mobile, String pwd)
	{
		
		PreparedStatement pst = null;
		Connection con = null; 
		ResultSet rs = null;
		ReaderBean readerBean = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select * from tb_reader where r_mobile=? and r_pwd=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, mobile);
			pst.setString(2, pwd);
			rs = pst.executeQuery();
			while(rs.next())
			{
				readerBean = new ReaderBean();
				readerBean.setR_birth(rs.getString("r_birth"));
				readerBean.setR_email(rs.getString("r_email"));
				readerBean.setR_gender(rs.getString("r_gender"));
				readerBean.setR_id(rs.getInt("r_id"));
				readerBean.setR_mobile(rs.getString("r_mobile"));
				readerBean.setR_name(rs.getString("r_name"));
				readerBean.setR_paperNo(rs.getString("r_paperNo"));
				readerBean.setR_pwd(rs.getString("r_pwd"));
				readerBean.setR_registdate(rs.getString("r_registdate"));
				readerBean.setR_type(rs.getString("r_type"));
				readerBean.setR_paperType(rs.getString("r_paperType"));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, rs);
		}
		return readerBean;
	}
	
	public ResultSet checkMobile(String mobile)
	{
		
		PreparedStatement pst = null;
		Connection con = null; 
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select * from tb_reader where r_mobile=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, mobile);
			rs = pst.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con, pst, rs);
		}
		return rs;
	}
	
	
}
