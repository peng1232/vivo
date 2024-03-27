package com.entity;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:19:34
*/
//2管理员信息表（administrator）
public class Administrator {
	private Integer id;//id
	private String admin_nickname;//昵称
	private String admin_account;//账号
	private String admin_password;//密码
	private Integer state;//0:不可用 1:可用
	
	
	public Administrator() {
		super();
	}
	public Administrator(Integer id, String admin_nickname, String admin_account, String admin_password,
			Integer state) {
		super();
		this.id = id;
		this.admin_nickname = admin_nickname;
		this.admin_account = admin_account;
		this.admin_password = admin_password;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", admin_nickname=" + admin_nickname + ", admin_account=" + admin_account
				+ ", admin_password=" + admin_password + ", state=" + state + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdmin_nickname() {
		return admin_nickname;
	}
	public void setAdmin_nickname(String admin_nickname) {
		this.admin_nickname = admin_nickname;
	}
	public String getAdmin_account() {
		return admin_account;
	}
	public void setAdmin_account(String admin_account) {
		this.admin_account = admin_account;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
}
