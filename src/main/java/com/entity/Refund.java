package com.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
* @Description: 
* @author: 铭
* @date 2024年3月27日 下午3:07:40
*/
//17退款表（refund）
public class Refund {
	private Integer id;//id
	private Integer user_id;//用户表id
	private String order_number;//订单号
	private BigDecimal refund_amount;//退款金额
	private String refund_reason;//退款原因
	private Integer state;//退款状态 0:待审核（退款中默认）1：审核通过2：审核拒绝3：已取消
	private Timestamp create_time;//退款时间
	private Timestamp update_time;//更新时间
	private String remark;//备注
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
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public BigDecimal getRefund_amount() {
		return refund_amount;
	}
	public void setRefund_amount(BigDecimal refund_amount) {
		this.refund_amount = refund_amount;
	}
	public String getRefund_reason() {
		return refund_reason;
	}
	public void setRefund_reason(String refund_reason) {
		this.refund_reason = refund_reason;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Refund [id=" + id + ", user_id=" + user_id + ", order_number=" + order_number + ", refund_amount="
				+ refund_amount + ", refund_reason=" + refund_reason + ", state=" + state + ", create_time="
				+ create_time + ", update_time=" + update_time + ", remark=" + remark + "]";
	}
	public Refund(Integer id, Integer user_id, String order_number, BigDecimal refund_amount, String refund_reason,
			Integer state, Timestamp create_time, Timestamp update_time, String remark) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.order_number = order_number;
		this.refund_amount = refund_amount;
		this.refund_reason = refund_reason;
		this.state = state;
		this.create_time = create_time;
		this.update_time = update_time;
		this.remark = remark;
	}
	public Refund() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
