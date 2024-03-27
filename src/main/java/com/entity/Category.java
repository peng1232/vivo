package com.entity;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:27:40
*/
//4商品类别表（category） 
public class Category {
	private Integer id;//id
	private String category_type;//商品型号类别
	private Integer state;//0:不可用 1:可用
	
	public Category() {
		super();
	}
	public Category(Integer id, String category_type, Integer state) {
		super();
		this.id = id;
		this.category_type = category_type;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", category_type=" + category_type + ", state=" + state + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory_type() {
		return category_type;
	}
	public void setCategory_type(String category_type) {
		this.category_type = category_type;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
