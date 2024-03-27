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
	private Integer stock_quantity;//库存数量
	private Integer is_recommended;//是否推荐商品 0不是 1是
	private Integer purchase_limit;//购买限制 默认1台
	
	public Commodity_price(Integer id, BigDecimal price, Integer stock_quantity, Integer is_recommended,
			Integer purchase_limit) {
		super();
		this.id = id;
		this.price = price;
		this.stock_quantity = stock_quantity;
		this.is_recommended = is_recommended;
		this.purchase_limit = purchase_limit;
	}

	@Override
	public String toString() {
		return "Commodity_price [id=" + id + ", price=" + price + ", stock_quantity=" + stock_quantity
				+ ", is_recommended=" + is_recommended + ", purchase_limit=" + purchase_limit + "]";
	}

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

	public Integer getStock_quantity() {
		return stock_quantity;
	}

	public void setStock_quantity(Integer stock_quantity) {
		this.stock_quantity = stock_quantity;
	}

	public Integer getIs_recommended() {
		return is_recommended;
	}

	public void setIs_recommended(Integer is_recommended) {
		this.is_recommended = is_recommended;
	}

	public Integer getPurchase_limit() {
		return purchase_limit;
	}

	public void setPurchase_limit(Integer purchase_limit) {
		this.purchase_limit = purchase_limit;
	}

	public Commodity_price() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
