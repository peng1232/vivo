package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.entity.Users;
import com.util.BaseDAO;
import com.util.Mapper;

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
	
	public static void main(String[] args) {
		System.out.println(new UsersDAO().nameAdd());
	}
}
