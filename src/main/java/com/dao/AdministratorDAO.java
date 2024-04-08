package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Administrator;
import com.entity.Users;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.util.BaseDAO;
import com.util.Mapper;

public class AdministratorDAO extends BaseDAO{
	//登录
		public Administrator dengLu(String account,String password) {
			String sql = "select * from administrator where admin_account =? and admin_password = ? and state=1";
			Administrator a = null;
			try {
				System.out.println(account);
				System.out.println(password);
				stmt =getConn().prepareStatement(sql);
				stmt.setObject(1, account);
				stmt.setObject(2, password);
				rs = stmt.executeQuery();
				if(rs.next()) {
					a = new Administrator(rs.getInt("id"), 
							rs.getString("admin_nickname"), 
							rs.getString("admin_account"),
							rs.getString("admin_password"),
							rs.getInt("state")
				);}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				closeAll();
			}
			System.out.println(a);
			return a;
		}
	//注册
		public Integer zhuCe(String nickname,String account,String password) {
			
			String sql = "insert into administrator(admin_nickname,admin_account,admin_password)"
					+ "	  values(?,?,?)";
			return executeUpdate(sql,nickname,account,password);
		}
	public static void main(String[] args) {
		new AdministratorDAO().zhuCe("黄同学", "18890212428", "123456");
		System.out.println(new AdministratorDAO().dengLu("18890212428","123456" ));

	}
}
