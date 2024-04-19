package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.impl.NoConnectionReuseStrategy;
import org.bouncycastle.jcajce.provider.asymmetric.RSA;
import org.dom4j.io.DOMReader;

import com.entity.Comments;
import com.entity.Orders;
import com.entity.Product;
import com.util.BaseDAO;
import com.util.Mapper;

public class ordersDAO extends BaseDAO{
	public List<Orders> queryUserOrders(Integer id){
		String sql= "SELECT * FROM orders where user_id = ? ORDER BY id DESC";
		return this.executeQuery(sql, new Mapper<Orders>() {

			@Override
			public List<Orders> map(ResultSet rs) throws SQLException {
				List<Orders> oreders =new ArrayList<Orders>();
				while (rs.next()) {
					Orders orders = new Orders(
							rs.getInt("id"),
							rs.getString("order_number"),
							rs.getInt("user_id"),
							rs.getString("consignee"),
							rs.getString("phone"),
							rs.getString("receiving_region"),
							rs.getTimestamp("order_time"),
							rs.getInt("state")
							);
					oreders.add(orders);
				}
				return oreders;
			}
			
		},id);
	}

	//查询商品表
	public Product queryUser_Product(Integer id){
		String sql ="SELECT * FROM product where id=?";
		Product proudc=null;
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, id);;
			rs = stmt.executeQuery();
			if(rs.next()) {
				proudc = new Product(
						rs.getInt("id"),
						rs.getString("products_name"),
						rs.getInt("category_id"),
						rs.getString("description"),
						rs.getLong("hits"),
						rs.getInt("purchase_limit"),
						rs.getTimestamp("listing_time"),
						rs.getInt("state")
								);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return proudc;
	}
	
}
