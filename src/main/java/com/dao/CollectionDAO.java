package com.dao;

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
	public Integer deleteCollection(Integer user_id,Integer product_id) {
		String sql = "update collection set state = 0 where user_id = ? and product_id = ?";
		return executeUpdate(sql, user_id,product_id);
	}
	
	
}
