package com.entity;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:38:55
*/
//8商品规格图片（product_image）
public class Product_image {
	private Integer id;//id
	private Integer value_id;//规格值表id
	private String image_url;//图片路径
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getValue_id() {
		return value_id;
	}
	public void setValue_id(Integer value_id) {
		this.value_id = value_id;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	@Override
	public String toString() {
		return "Product_image [id=" + id + ", value_id=" + value_id + ", image_url=" + image_url + "]";
	}
	public Product_image(Integer id, Integer value_id, String image_url) {
		super();
		this.id = id;
		this.value_id = value_id;
		this.image_url = image_url;
	}
	public Product_image() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
