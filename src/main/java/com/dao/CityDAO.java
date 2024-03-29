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

public class CityDAO extends BaseDAO {
	// 查询省份
	public List<City> selectProvince() {
		String sql = "SELECT * FROM city WHERE leveltype = 1";
		List<City> list = new ArrayList<City>();
		executeQuery(sql, new Mapper<City>() {

			@Override
			public List<City> map(ResultSet rs) throws SQLException {
				while (rs.next()) {
					list.add(new City(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getInt(11)));
				}
				return list;
			}
		});
		return list;
	}
	// 查询城市
	public List<City> selectCity(Integer province) {
		String sql = "SELECT * FROM `city` WHERE leveltype = 2 AND parentid = ?";
		List<City> list = new ArrayList<City>();
		executeQuery(sql, new Mapper<City>() {

			@Override
			public List<City> map(ResultSet rs) throws SQLException {
				while (rs.next()) {
					list.add(new City(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getInt(11)));
				}
				return list;
			}
		},province);
		return list;
	}
	// 查询区
	public List<City> selectDistrict(Integer district) {
		String sql = "SELECT * FROM `city` WHERE leveltype = 3 AND parentid = ?";
		List<City> list = new ArrayList<City>();
		executeQuery(sql, new Mapper<City>() {

			@Override
			public List<City> map(ResultSet rs) throws SQLException {
				while (rs.next()) {
					list.add(new City(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getInt(11)));
				}
				return list;
			}
		},district);
		return list;
	}

	public static void main(String[] args) {
		System.err.println(new CityDAO().selectDistrict(430200));
	}
}
