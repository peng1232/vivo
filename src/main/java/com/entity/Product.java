package com.entity;

import java.sql.Timestamp;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:30:31
*/
//5商品表（product）
public class Product {
	private Integer id;//id
	private String products_name;//商品名称
	private Integer category_id;//类别表id
	private String description;//商品描述
	private Long hits;//点击量
	private Integer purchase_limit;//购买限制
	private Timestamp listing_time;//上架时间 当状态变成1的时候，就更改
	private Integer state;//0：待上架 1：上架 2：下架/缺货
	
	
	//临时字段
	private String image_url;//图片地址
	
	
	
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProducts_name() {
		return products_name;
	}
	public void setProducts_name(String products_name) {
		this.products_name = products_name;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getHits() {
		return hits;
	}
	public void setHits(Long hits) {
		this.hits = hits;
	}
	public Integer getPurchase_limit() {
		return purchase_limit;
	}
	public void setPurchase_limit(Integer purchase_limit) {
		this.purchase_limit = purchase_limit;
	}
	public Timestamp getListing_time() {
		return listing_time;
	}
	public void setListing_time(Timestamp listing_time) {
		this.listing_time = listing_time;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", products_name=" + products_name + ", category_id=" + category_id
				+ ", description=" + description + ", hits=" + hits + ", purchase_limit=" + purchase_limit
				+ ", listing_time=" + listing_time + ", state=" + state + "]";
	}
	public Product(Integer id, String products_name, Integer category_id, String description, Long hits,
			Integer purchase_limit, Timestamp listing_time, Integer state) {
		super();
		this.id = id;
		this.products_name = products_name;
		this.category_id = category_id;
		this.description = description;
		this.hits = hits;
		this.purchase_limit = purchase_limit;
		this.listing_time = listing_time;
		this.state = state;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}
