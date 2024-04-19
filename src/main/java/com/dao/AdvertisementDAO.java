package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Administrator;
import com.entity.Advertisement;
import com.entity.Users;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.util.BaseDAO;
import com.util.Mapper;

public class AdvertisementDAO extends BaseDAO {
	// 插入
	public Integer insert(String id, String advertisement_url, String product_id, String state) {

		String sql = "insert into advertisement(id,advertisement_url,product_id,state)" + "	  values(?,?,?,?)";
		return executeUpdate(sql, id, advertisement_url, product_id, state);
	}
	
	//查询广告
	public List<Advertisement> queryAdvertisement() {
		String sql = "SELECT * FROM advertisement WHERE state =1";
		return executeQuery(sql, new Mapper<Advertisement>() {

			@Override
			public List<Advertisement> map(ResultSet rs) throws SQLException {
				List<Advertisement> list = new ArrayList<Advertisement>();
				while(rs.next()) {
					list.add(new Advertisement(rs.getInt("id"), rs.getString("advertisement_url"), rs.getInt("product_id"), rs.getInt("state")));
				}
				return list;
			}
		});
	}

	public static void main(String[] args) {
		System.out.println(new AdvertisementDAO().queryAdvertisement());	}
}
