package com.entity;

import java.sql.Timestamp;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:57:01
*/
//15订单表(orders）
public class Orders {
	private Integer id;//id
	private String order_number;//订单号 dd00000000001
	private Integer user_id;//用户表id
	private String consignee;//收货人
	private String phone;//手机号
	private String receiving_region;//收货地址
	private Timestamp order_time;//订单时间
	private Integer state;//订单状态 1:已付款2：未付款 半小时未付款，就取消3：已取消4：退款款5：已退款6：已发货7：已完成
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
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getReceiving_region() {
		return receiving_region;
	}
	public void setReceiving_region(String receiving_region) {
		this.receiving_region = receiving_region;
	}
	public Timestamp getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Timestamp order_time) {
		this.order_time = order_time;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", order_number=" + order_number + ", user_id=" + user_id + ", consignee="
				+ consignee + ", phone=" + phone + ", receiving_region=" + receiving_region + ", order_time="
				+ order_time + ", state=" + state + "]";
	}
	public Orders(Integer id, String order_number, Integer user_id, String consignee, String phone,
			String receiving_region, Timestamp order_time, Integer state) {
		super();
		this.id = id;
		this.order_number = order_number;
		this.user_id = user_id;
		this.consignee = consignee;
		this.phone = phone;
		this.receiving_region = receiving_region;
		this.order_time = order_time;
		this.state = state;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
