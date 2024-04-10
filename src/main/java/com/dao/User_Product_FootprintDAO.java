package com.dao;

import java.sql.Timestamp;
import java.util.Date;

import com.util.BaseDAO;

/**
* @Description: 
* @author: 铭
* @date 2024年4月10日 下午3:27:50
*/

public class User_Product_FootprintDAO extends BaseDAO{
	//添加用户浏览记录
	public Integer InsertFootprint(Integer user_id,Integer product_id) {
		String sql = "insert into user_product_footprint values(null,?,?,?)";
		return executeUpdate(sql, user_id,product_id,new Timestamp(new Date().getTime()));
	}
	
}
