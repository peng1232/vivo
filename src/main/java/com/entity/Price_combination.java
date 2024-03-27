package com.entity;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:44:37
*/
//10价格组合表（price_combination）
public class Price_combination {
	private Integer id;//id
	private Integer price_id;//商品(组合)价格id
	private Integer value_id;//规格值id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPrice_id() {
		return price_id;
	}
	public void setPrice_id(Integer price_id) {
		this.price_id = price_id;
	}
	public Integer getValue_id() {
		return value_id;
	}
	public void setValue_id(Integer value_id) {
		this.value_id = value_id;
	}
	@Override
	public String toString() {
		return "Price_combination [id=" + id + ", price_id=" + price_id + ", value_id=" + value_id + "]";
	}
	public Price_combination(Integer id, Integer price_id, Integer value_id) {
		super();
		this.id = id;
		this.price_id = price_id;
		this.value_id = value_id;
	}
	public Price_combination() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
