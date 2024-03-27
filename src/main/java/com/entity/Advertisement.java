package com.entity;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午3:12:53
*/
//18广告表（advertisement）
public class Advertisement {
	private Integer id;//id
	private String advertisement_url;//广告图片地址
	private Integer product_id;//商品表id
	private Integer state;//广告状态 0不摆放 1摆放
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdvertisement_url() {
		return advertisement_url;
	}
	public void setAdvertisement_url(String advertisement_url) {
		this.advertisement_url = advertisement_url;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Advertisement [id=" + id + ", advertisement_url=" + advertisement_url + ", product_id=" + product_id
				+ ", state=" + state + "]";
	}
	public Advertisement(Integer id, String advertisement_url, Integer product_id, Integer state) {
		super();
		this.id = id;
		this.advertisement_url = advertisement_url;
		this.product_id = product_id;
		this.state = state;
	}
	public Advertisement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
