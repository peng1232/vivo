package com.entity;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午3:14:32
*/
//19评论表（comments）
public class Comments {
	private Integer id;//id
	private Integer user_id;//用户id
	private String user_com;//用户评论
	private Integer product_id;//商品表id
	private Integer state;//0：未审核 默认 1：已审核2：审核未通过 3:已删除
	private Integer com_grade;//评论等级
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_com() {
		return user_com;
	}
	public void setUser_com(String user_com) {
		this.user_com = user_com;
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
	public Integer getCom_grade() {
		return com_grade;
	}
	public void setCom_grade(Integer com_grade) {
		this.com_grade = com_grade;
	}
	@Override
	public String toString() {
		return "Comments [id=" + id + ", user_id=" + user_id + ", user_com=" + user_com + ", product_id=" + product_id
				+ ", state=" + state + ", com_grade=" + com_grade + "]";
	}
	public Comments(Integer id, Integer user_id, String user_com, Integer product_id, Integer state,
			Integer com_grade) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.user_com = user_com;
		this.product_id = product_id;
		this.state = state;
		this.com_grade = com_grade;
	}
	
	
}
