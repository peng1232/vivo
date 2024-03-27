package com.entity;

import java.math.BigDecimal;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:59:54
*/
//16订单详细表（order_details）
public class Order_details {
	private Integer id;//id
	private String order_number;//订单号 外联
	private Integer product_id;//商品表id
	private Integer price_id;//价格表的id
	private Integer product_quantity;//商品数量
	private BigDecimal product_total;//商品总价
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getPrice_id() {
		return price_id;
	}
	public void setPrice_id(Integer price_id) {
		this.price_id = price_id;
	}
	public Integer getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}
	public BigDecimal getProduct_total() {
		return product_total;
	}
	public void setProduct_total(BigDecimal product_total) {
		this.product_total = product_total;
	}
	@Override
	public String toString() {
		return "Order_details [id=" + id + ", order_number=" + order_number + ", product_id=" + product_id
				+ ", price_id=" + price_id + ", product_quantity=" + product_quantity + ", product_total="
				+ product_total + "]";
	}
	public Order_details(Integer id, String order_number, Integer product_id, Integer price_id,
			Integer product_quantity, BigDecimal product_total) {
		super();
		this.id = id;
		this.order_number = order_number;
		this.product_id = product_id;
		this.price_id = price_id;
		this.product_quantity = product_quantity;
		this.product_total = product_total;
	}
	public Order_details() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
