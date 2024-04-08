package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.City;
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
		String sql = "SELECT COUNT(*) as sum FROM shopping_cart";
		Integer count = 0;
		try {
			stmt = getConn().prepareStatement(sql);
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
	
	

	public static void main(String[] args) {
		System.out.println(new Shopping_CartDAO().shopping_Count(1));
	}
}
