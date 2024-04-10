package com.entity;

import java.sql.Timestamp;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:52:12
*/
//13收藏表（collection）
public class Collection {
	private Integer id;//id
	private Integer user_id;//用户表id
	private Integer product_id;//商品表id
	private Timestamp add_time;//收藏加入时间
	private Integer state;//0：删除 1：未删除
	private String sku;//商品详细组合
	
	

	public Collection(Integer id, Integer user_id, Integer product_id, Timestamp add_time, Integer state, String sku) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.add_time = add_time;
		this.state = state;
		this.sku = sku;
	}



	@Override
	public String toString() {
		return "Collection [id=" + id + ", user_id=" + user_id + ", product_id=" + product_id + ", add_time=" + add_time
				+ ", state=" + state + ", sku=" + sku + "]";
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



	public Integer getProduct_id() {
		return product_id;
	}



	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}



	public Timestamp getAdd_time() {
		return add_time;
	}



	public void setAdd_time(Timestamp add_time) {
		this.add_time = add_time;
	}



	public Integer getState() {
		return state;
	}



	public void setState(Integer state) {
		this.state = state;
	}



	public String getSku() {
		return sku;
	}



	public void setSku(String sku) {
		this.sku = sku;
	}



	public Collection() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
