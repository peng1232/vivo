package com.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:11:15
*/

public class Users {
	private Integer id;//id
	private String user_nickname;//昵称
	private String user_password;//密码
	private String phone;//手机号
	private String head_sculpture;//头像地址
	private Date birth;//生日
	private Integer sex;//性别 0:男 默认为0 1:女
	private Timestamp create_time;//创建时间 那java里面的时间，比如会取值的时候会比现实中慢8小时
	private Integer state;//'0:不可用 1:可用'
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHead_sculpture() {
		return head_sculpture;
	}
	public void setHead_sculpture(String head_sculpture) {
		this.head_sculpture = head_sculpture;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", user_nickname=" + user_nickname + ", user_password=" + user_password + ", phone="
				+ phone + ", head_sculpture=" + head_sculpture + ", birth=" + birth + ", sex=" + sex + ", create_time="
				+ create_time + ", state=" + state + "]";
	}
	public Users(Integer id, String user_nickname, String user_password, String phone, String head_sculpture,
			Date birth, Integer sex, Timestamp create_time, Integer state) {
		super();
		this.id = id;
		this.user_nickname = user_nickname;
		this.user_password = user_password;
		this.phone = phone;
		this.head_sculpture = head_sculpture;
		this.birth = birth;
		this.sex = sex;
		this.create_time = create_time;
		this.state = state;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
