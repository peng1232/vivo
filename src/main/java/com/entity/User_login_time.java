package com.entity;

import java.sql.Timestamp;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:23:43
*/
//3用户登录时间表（user_login_time）
public class User_login_time {
	private Integer id;//id
	private Integer user_id;//用户id 外键
	private Timestamp login_time;//登录时间 那java里面拿时间
	
	
	public User_login_time() {
		super();
	}
	public User_login_time(Integer id, Integer user_id, Timestamp login_time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.login_time = login_time;
	}
	@Override
	public String toString() {
		return "User_login_time [id=" + id + ", user_id=" + user_id + ", login_time=" + login_time + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Timestamp getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Timestamp login_time) {
		this.login_time = login_time;
	}
}
