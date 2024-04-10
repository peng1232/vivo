package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Administrator;
import com.entity.Users;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.util.BaseDAO;
import com.util.Mapper;

public class AdvertisementDAO extends BaseDAO{
	
		public Integer insert(String id,String advertisement_url,String product_id,  String state) {
			
			String sql = "insert into advertisement(id,advertisement_url,product_id,state)"
					+ "	  values(?,?,?,?)";
			return executeUpdate(sql,id,advertisement_url,product_id,state);
		}
	public static void main(String[] args) {
		new AdvertisementDAO().insert("10","xxxxxx","5","0");

	}
}
