package com.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.entity.Users;
import com.util.BaseDAO;

/**
* @Description: 
* @author: 铭
* @date 2024年4月1日 上午9:29:04
*/

public class UsersDAO extends BaseDAO{
	//判断改账号是否注册过
	public Boolean isZhuCe(String phone) {
		Boolean pan = true;
		String sql = "select * from users where phone = ?";
		try {
			stmt =getConn().prepareStatement(sql);
			stmt.setObject(1, phone);
			rs = stmt.executeQuery();
			if(rs.next()) {
				pan = false;
			}
			return pan;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return pan;
	}
	//注册
	public Integer zhuCe(String phone,String password) {
		
		String sql = "insert into users(user_nickname,phone,user_password,head_sculpture,create_time)"
				+ "	  values(?,?,?,?,?)";
		return executeUpdate(sql, nameAdd(),phone,password,"favicon.ico",new Timestamp(new Date().getTime()));
	}
	//昵称自增
	public String nameAdd() {
		Integer sum = nickName();
		String head ="vivo_";
		Integer footer = ++sum;
		String vid = head + String.format("%08d", footer);
		return vid;
	}
	//默认昵称
	public Integer nickName() {
		//vivo_00000001
		String sql = "select count(*) as sum from users";
		try {
			Integer nickname = 0;
			stmt =getConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				nickname = rs.getInt("sum");
			}
			return nickname;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//登录
	public Users dengLv(String phone,String password) {
		String sql = "select * from users where phone = ? and user_password =? and state = 1";
		Users u = null;
		try {
			stmt =getConn().prepareStatement(sql);
			stmt.setObject(1, phone);
			stmt.setObject(2, password);
			rs = stmt.executeQuery();
			if(rs.next()) {
				u = new Users(rs.getInt("id"), 
						rs.getString("user_nickname"), 
						rs.getString("user_password"), 
						rs.getString("phone"),
						rs.getString("head_sculpture"), 
						rs.getDate("birth"), 
						rs.getInt("sex"), 
						rs.getTimestamp("create_time"), 
						rs.getInt("state"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return u;
	}
	public Users dengLv(String phone) {
		String sql = "select * from users where phone = ? and state = 1";
		Users u = null;
		try {
			stmt =getConn().prepareStatement(sql);
			stmt.setObject(1, phone);
			rs = stmt.executeQuery();
			if(rs.next()) {
				u = new Users(rs.getInt("id"), 
						rs.getString("user_nickname"), 
						rs.getString("user_password"), 
						rs.getString("phone"),
						rs.getString("head_sculpture"), 
						rs.getDate("birth"), 
						rs.getInt("sex"), 
						rs.getTimestamp("create_time"), 
						rs.getInt("state"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return u;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new UsersDAO().dengLv("19374234036","6666466"));
	}
	
	// 修改密码
	public Integer doUpdatePassword(Integer user_id,String password) {
		String sql = "update users set user_password=? where id=?";
		return executeUpdate(sql, password,user_id);
	}
	
}
