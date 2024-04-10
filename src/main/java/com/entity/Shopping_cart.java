package com.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:49:00
*/
//12购物车(shopping_cart)
public class Shopping_cart {
	private Integer id;//id
	private Integer user_id;//用户表id
	private Integer product_id;//商品表id
	private Integer quantity;//购买数量
	private BigDecimal total_price;//总价
	private Timestamp add_time;//加入购物车时间 java
	private Integer state;//0：未结算 1：已结算 2：已删除
	private String sku;//商品详细组合
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotal_price() {
		return total_price;
	}
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
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
	@Override
	public String toString() {
		return "Shopping_cart [id=" + id + ", user_id=" + user_id + ", product_id=" + product_id + ", quantity="
				+ quantity + ", total_price=" + total_price + ", add_time=" + add_time + ", state=" + state + ", sku="
				+ sku + "]";
	}
	public Shopping_cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shopping_cart(Integer id, Integer user_id, Integer product_id, Integer quantity, BigDecimal total_price,
			Timestamp add_time, Integer state, String sku) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.total_price = total_price;
		this.add_time = add_time;
		this.state = state;
		this.sku = sku;
	}
	
	
	
}
