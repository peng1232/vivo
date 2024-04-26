package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.impl.NoConnectionReuseStrategy;
import org.bouncycastle.jcajce.provider.asymmetric.RSA;
import org.dom4j.io.DOMReader;

import com.entity.Comments;
import com.entity.Order_details;
import com.entity.Orders;
import com.entity.Product;
import com.util.BaseDAO;
import com.util.Mapper;

public class OrdersDAO extends BaseDAO {
	// 新增订单
	public String insertOrder(Orders o) {
		String sql = "insert INTO orders VALUES(null,?,?,?,?,?,?,?)";
		String id = orderNumber();
		executeUpdate(sql, id, o.getUser_id(), o.getConsignee(), o.getPhone(), o.getReceiving_region(),
				new Timestamp(new Date().getTime()), 2);
		return id;
	}

	// 新增纤细表
	public Integer insertOrderDetails(Order_details d) {
		String sql = "insert INTO order_details VALUES(null,?,?,?,?,?)";
		return executeUpdate(sql, d.getOrder_number(), d.getProduct_id(), d.getProduct_quantity(), d.getProduct_total(),
				d.getSku());

	}

	// 订单号自增
	public String orderNumber() {
		String sql = "select id as shu from orders order by id desc";
		try {
			stmt = getConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			String year = new Date().getYear() + 1900 + "";
			String month = new Date().getMonth() + 1 + "";
			Integer bian = rs.getInt("shu");
			return year + String.format("%02d", Integer.valueOf(month)) + String.format("%09d", ++bian);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public List<Orders> queryUserOrders(Integer id) {
		String sql = "SELECT * FROM orders where user_id = ? ORDER BY id DESC";
		return this.executeQuery(sql, new Mapper<Orders>() {

			@Override
			public List<Orders> map(ResultSet rs) throws SQLException {
				List<Orders> oreders = new ArrayList<Orders>();
				while (rs.next()) {
					Orders orders = new Orders(rs.getInt("id"), rs.getString("order_number"), rs.getInt("user_id"),
							rs.getString("consignee"), rs.getString("phone"), rs.getString("receiving_region"),
							rs.getTimestamp("order_time"), rs.getInt("state"));
					oreders.add(orders);
				}
				return oreders;
			}

		}, id);
	}
	
	
	public static void main(String[] args) {
		System.out.println(new OrdersDAO().orderNumber());

	}

	// 查询商品表
	public Product queryUser_Product(Integer id) {
		String sql = "SELECT * FROM product where id=?";
		Product proudc = null;
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, id);
			;
			rs = stmt.executeQuery();
			if (rs.next()) {
				proudc = new Product(rs.getInt("id"), rs.getString("products_name"), rs.getInt("category_id"),
						rs.getString("description"), rs.getLong("hits"), rs.getInt("purchase_limit"),
						rs.getTimestamp("listing_time"), rs.getInt("state"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return proudc;
	}

	public List<Order_details> queryUser_order_details(String number) {
	    String sql = "select * from order_details where order_number=? ";
	    List<Order_details> orderDetailsList = new ArrayList<>();
	    try {
	        stmt = getConn().prepareStatement(sql);
	        stmt.setObject(1, number);
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	            Order_details orderDetails = new Order_details(
	                    rs.getInt("id"),
	                    rs.getString("order_number"),
	                    rs.getInt("product_id"),
	                    rs.getInt("product_quantity"),
	                   
	                   
	                    rs.getBigDecimal("product_total"),
	                    rs.getString("sku")
	            );
	            orderDetailsList.add(orderDetails);
	        }
	    } catch (Exception e) {
	        // TODO: handle exception
	        e.printStackTrace(); // 添加异常处理
	    } finally {
	        closeAll();
	    }
	    return orderDetailsList; // 返回正确的类型
	}

	//删除订单
	public Integer delectOrder(String number) {
		String sql = "delete from orders where order_number = ?";
		return executeUpdate(sql, number);
	}
	//删除订单详情
	public Integer delectOrder_Details(String number) {
		String sql = "delete from order_details where order_number = ?";
		return executeUpdate(sql, number);
	}
}