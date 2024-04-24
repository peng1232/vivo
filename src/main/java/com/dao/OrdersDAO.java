package com.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.entity.Order_details;
import com.entity.Orders;
import com.util.BaseDAO;

/**
* @Description: 
* @author: 铭
* @date 2024年4月18日 下午7:41:14
*/

public class OrdersDAO extends BaseDAO{
	//新增订单
	public String insertOrder(Orders o) {
		String sql = "insert INTO orders VALUES(null,?,?,?,?,?,?,?)";
		String id = orderNumber();
		executeUpdate(sql, id,o.getUser_id(),o.getConsignee(),o.getPhone(),o.getReceiving_region(),new Timestamp(new Date().getTime()),2);
		return id;
	}
	//新增纤细表
	public Integer insertOrderDetails(Order_details d) {
		String sql = "insert INTO order_details VALUES(null,?,?,?,?,?)";
		return executeUpdate(sql,d.getOrder_number(),d.getProduct_id(),d.getProduct_quantity(),d.getProduct_total(),d.getSku());
	
	}
	
	//订单号自增
	public String orderNumber() {
		String sql = "select count(*) as shu from orders";
		try {
			stmt = getConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			String year = new Date().getYear()+1900+"";
			String month = new Date().getMonth()+1+"";
			Integer bian = rs.getInt("shu");
			return year+String.format("%02d", Integer.valueOf(month))+ String.format("%09d", ++bian);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//删除购物车
	
	
	public static void main(String[] args) {
		System.out.println(new OrdersDAO().orderNumber());
	}
}
