package com.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.util.BaseDAO;

/**
* @Description: 
* @author: 铭
* @date 2024年4月10日 下午6:58:05
*/

public class CollectionDAO extends BaseDAO{
	//添加收藏
	public Integer insertCollection(Integer user_id,Integer product_id,String sku) {
		String sql = "insert into collection(user_id,product_id,sku,add_time) values(?,?,?,?)";
		return executeUpdate(sql, user_id,product_id,sku,new Timestamp(new Date().getTime()));
	}
	//删除收藏
	public Integer deleteCollection(Integer user_id,Integer product_id,String sku) {
		String sql = "update collection set state = 0 where user_id = ? and product_id = ? AND sku = ?";
		return executeUpdate(sql, user_id,product_id,sku);
	}
	
	//查看是否是收藏
	public Boolean isCollection(Integer user_id,Integer product_id,String sku) {
		String sql = "SELECT * FROM collection WHERE user_id = ? AND product_id = ? AND sku = ? AND state = 1";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, user_id);
			stmt.setObject(2, product_id);
			stmt.setObject(3, sku);
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
		System.out.println(new CollectionDAO().isCollection(1, 3, "{\"sku_price\":7,\"pageType\":11,\"color\":14,\"number\":1}"));
	}
}
