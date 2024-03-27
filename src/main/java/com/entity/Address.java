package com.entity;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午2:54:24
*/
//14收货地址(address） 
public class Address {
	private Integer id;//id
	private Integer user_id;//用户表id
	private String consignee;//收货人
	private String phone;//手机号
	private String receiving_region;//收货地址
	private Integer default_address;//默认地址 1默认 2不是默认
	private String detailed_region;//详细地址
	private Integer state;//0：不可用 1：可以
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
	public Integer getDefault_address() {
		return default_address;
	}
	public void setDefault_address(Integer default_address) {
		this.default_address = default_address;
	}
	public String getDetailed_region() {
		return detailed_region;
	}
	public void setDetailed_region(String detailed_region) {
		this.detailed_region = detailed_region;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", user_id=" + user_id + ", consignee=" + consignee + ", phone=" + phone
				+ ", receiving_region=" + receiving_region + ", default_address=" + default_address
				+ ", detailed_region=" + detailed_region + ", state=" + state + "]";
	}
	public Address(Integer id, Integer user_id, String consignee, String phone, String receiving_region,
			Integer default_address, String detailed_region, Integer state) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.consignee = consignee;
		this.phone = phone;
		this.receiving_region = receiving_region;
		this.default_address = default_address;
		this.detailed_region = detailed_region;
		this.state = state;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
