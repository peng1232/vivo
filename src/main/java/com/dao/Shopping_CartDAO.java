package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.City;
import com.entity.Shopping_cart;
import com.util.BaseDAO;
import com.util.Mapper;

/**
 * @Description:
 * @author: 铭
 * @date 2024年3月29日 上午8:21:20
 */

public class Shopping_CartDAO extends BaseDAO {
	
	//查询购物车数量
	public Integer shopping_Count(Integer user_id) {
		String sql = "SELECT COUNT(*) as sum FROM shopping_cart where user_id=? and state = 0 ";
		Integer count = 0;
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, user_id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return count;
	}
	
	//添加购物车
	public Integer insertShopping(Shopping_cart s) {
		String sql = "insert into shopping_cart(user_id,product_id,sku,quantity,add_time) values(?,?,?,?,?)";
		return executeUpdate(sql, s.getUser_id(),s.getProduct_id(),s.getSku(),s.getQuantity(),s.getAdd_time());
	}
	
	//查看是否有该购物车
	public Boolean isShopping(Integer user_id,Integer product_id) {
		String sql = "SELECT * FROM shopping_cart WHERE user_id = ? AND product_id = ? AND state = 0";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, user_id);
			stmt.setObject(2, product_id);
			rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new Shopping_CartDAO().isShopping(1,2));
	}
}
