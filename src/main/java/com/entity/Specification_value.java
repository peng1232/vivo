package com.entity;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:37:02
*/
//7商品规格值表（specification_value）
public class Specification_value {
	private Integer id;//id
	private Integer specifications_id;//规格表id
	private String value;//规格值
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSpecifications_id() {
		return specifications_id;
	}
	public void setSpecifications_id(Integer specifications_id) {
		this.specifications_id = specifications_id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Specification_value [id=" + id + ", specifications_id=" + specifications_id + ", value=" + value + "]";
	}
	public Specification_value(Integer id, Integer specifications_id, String value) {
		super();
		this.id = id;
		this.specifications_id = specifications_id;
		this.value = value;
	}
	public Specification_value() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
