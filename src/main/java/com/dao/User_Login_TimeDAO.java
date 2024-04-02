package com.dao;

import java.sql.Timestamp;
import java.util.Date;

import com.util.BaseDAO;

/**
* @Description: 
* @author: 铭
* @date 2024年4月2日 上午8:38:36
*/

public class User_Login_TimeDAO extends BaseDAO{
	//记录用户登录时间
	public Integer insertUserTime(Integer user_id) {
		String sql = "insert into user_login_time(user_id,login_time) values(?,?)";
		return executeUpdate(sql, user_id,new Timestamp(new Date().getTime()));
	}
}
