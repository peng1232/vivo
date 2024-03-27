package com.entity;

import java.sql.Timestamp;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:46:40
*/
//11用户商品浏览足迹(user_product_footprint)
public class User_product_footprint {
	private Integer id;//id
	private Integer user_id;//用户id
	private Integer products_id;//商品id
	private Timestamp browse_time;//浏览时间 java时间
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
	public Integer getProducts_id() {
		return products_id;
	}
	public void setProducts_id(Integer products_id) {
		this.products_id = products_id;
	}
	public Timestamp getBrowse_time() {
		return browse_time;
	}
	public void setBrowse_time(Timestamp browse_time) {
		this.browse_time = browse_time;
	}
	@Override
	public String toString() {
		return "User_product_footprint [id=" + id + ", user_id=" + user_id + ", products_id=" + products_id
				+ ", browse_time=" + browse_time + "]";
	}
	public User_product_footprint(Integer id, Integer user_id, Integer products_id, Timestamp browse_time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.products_id = products_id;
		this.browse_time = browse_time;
	}
	public User_product_footprint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
