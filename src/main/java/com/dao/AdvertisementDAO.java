package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Administrator;
import com.entity.Advertisement;
import com.entity.Category;
import com.entity.Users;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.util.BaseDAO;
import com.util.Mapper;

public class AdvertisementDAO extends BaseDAO {
	// 插入
	public Integer insertAdvertisement(Advertisement a) {
		String sql = "insert into advertisement(advertisement_url,product_id) values(?,?)";
		return executeUpdate(sql, a.getAdvertisement_url(), a.getProduct_id());
	}

	// 查询广告
	public List<Advertisement> queryAdvertisement() {
		String sql = "SELECT * FROM advertisement WHERE state =1";
		return executeQuery(sql, new Mapper<Advertisement>() {

			@Override
			public List<Advertisement> map(ResultSet rs) throws SQLException {
				List<Advertisement> list = new ArrayList<Advertisement>();
				while (rs.next()) {
					list.add(new Advertisement(rs.getInt("id"), rs.getString("advertisement_url"),
							rs.getInt("product_id"), rs.getInt("state")));
				}
				return list;
			}
		});
	}

	public List<Advertisement> selectAll(Advertisement a, Integer curpage, Integer pagesize) {
		List<Advertisement> list = new ArrayList<Advertisement>();
		List<String> zhi = new ArrayList<String>();
		String sql = "select * from advertisement where 1=1";
		if (a.getProduct_id() != null) {
			sql += " and product_id = ? ";
			zhi.add(a.getProduct_id() + "");
		}
		if (a.getState() != null) {
			sql += " and state = ? ";
			zhi.add(a.getState() + "");
		}
		if (curpage != null || pagesize != null) {
			sql += " ORDER BY id DESC limit " + ((curpage - 1) * pagesize) + ", " + (pagesize) + " ";
		}
		try {
			stmt = getConn().prepareStatement(sql);
			for (Integer i = 0; i < zhi.size(); i++) {
				stmt.setObject(i + 1, zhi.get(i));
			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Advertisement(rs.getInt("id"), rs.getString("advertisement_url"), rs.getInt("product_id"),
						rs.getInt("state")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}
	
	//修改广告
	public Integer updateAdvertisement(String url,Integer id) {
		String sql = "update advertisement set advertisement_url=? where id=?";
		return executeUpdate(sql, url,id);
		
	}
	public Integer updateAdvertisement(Advertisement a) {
		String sql = "update advertisement set product_id=?,state=? where id=?";
		return executeUpdate(sql, a.getProduct_id(),a.getState(),a.getId());
	}

	public static void main(String[] args) {
		System.out.println(new AdvertisementDAO().queryAdvertisement());
	}
}
