package com.dao;

import java.sql.SQLException;
import java.sql.Statement;

import com.entity.Shopping_cart;
import com.util.BaseDAO;

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
		Integer sid = null;
		String sql = "insert into shopping_cart(user_id,product_id,sku,quantity,add_time) values(?,?,?,?,?)";
		try {
			stmt = getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, s.getUser_id());
	        stmt.setInt(2, s.getProduct_id());
	        stmt.setString(3, s.getSku());
	        stmt.setInt(4, s.getQuantity());
	        stmt.setTimestamp(5, s.getAdd_time());
	        stmt.executeUpdate();
	        rs = stmt.getGeneratedKeys();
	        if (rs.next()) {
	            sid = rs.getInt(1);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return sid;
        
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
	
	//根据购物车id查询对应信息
	public Shopping_cart queryShopping(Integer shopping_id) {
		Shopping_cart s = null;
		String sql = "select * from shopping_cart where id = ?";
		try {
			stmt= getConn().prepareStatement(sql);
			stmt.setObject(1, shopping_id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				s = new Shopping_cart(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("product_id"), rs.getInt("quantity"), rs.getTimestamp("add_time"), rs.getInt("state"), rs.getString("sku"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(new Shopping_CartDAO().queryShopping(13));
	}
}
