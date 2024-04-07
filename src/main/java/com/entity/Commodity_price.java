package com.entity;

import java.math.BigDecimal;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:41:27
*/
//9价格表（commodity_price）
public class Commodity_price {
	private Integer id;//id
	private BigDecimal price;//价格
	private Integer product_id;//商品表id
	private Integer is_recommended;//是否推荐商品 0不是 1是
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getIs_recommended() {
		return is_recommended;
	}
	public void setIs_recommended(Integer is_recommended) {
		this.is_recommended = is_recommended;
	}
	@Override
	public String toString() {
		return "Commodity_price [id=" + id + ", price=" + price + ", product_id=" + product_id + ", is_recommended="
				+ is_recommended + "]";
	}
	public Commodity_price(Integer id, BigDecimal price, Integer product_id, Integer is_recommended) {
		super();
		this.id = id;
		this.price = price;
		this.product_id = product_id;
		this.is_recommended = is_recommended;
	}
	public Commodity_price() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
