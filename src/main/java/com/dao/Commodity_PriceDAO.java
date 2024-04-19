package com.dao;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.util.BaseDAO;

/**
* @Description: 
* @author: 铭
* @date 2024年4月19日 下午4:11:11
*/

public class Commodity_PriceDAO extends BaseDAO{
	//根据价格id查询价格
	public BigDecimal queryPrice(Integer price_id) {
		BigDecimal price = null;
		String sql = "select price from commodity_price where id=?";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, price_id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				price = new BigDecimal(rs.getString("price"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return price;
	}
	public static void main(String[] args) {
		System.out.println(new Commodity_PriceDAO().queryPrice(1));
	}
}
