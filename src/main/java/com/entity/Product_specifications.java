package com.entity;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:34:59
*/
//-- 6商品规格表(product_specifications)
public class Product_specifications {
	private Integer id;//id
	private Integer product_id;//商品表id
	private String specifications_name;//规格名称
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getSpecifications_name() {
		return specifications_name;
	}
	public void setSpecifications_name(String specifications_name) {
		this.specifications_name = specifications_name;
	}
	@Override
	public String toString() {
		return "Product_specifications [id=" + id + ", product_id=" + product_id + ", specifications_name="
				+ specifications_name + "]";
	}
	public Product_specifications(Integer id, Integer product_id, String specifications_name) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.specifications_name = specifications_name;
	}
	public Product_specifications() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
