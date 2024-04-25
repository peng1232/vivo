package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Price_combination;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import com.util.BaseDAO;
import com.util.Mapper;

/**
 * @Description:
 * @author: 铭
 * @date 2024年4月25日 下午2:24:24
 */

public class Price_CombinationDAO extends BaseDAO {
	// 根据价格id查询规格
	public List<Price_combination> selectAllCombiatoin(Integer price_id) {
		String sql = "SELECT * FROM price_combination WHERE price_id = ?";
		return executeQuery(sql, new Mapper<Price_combination>() {

			@Override
			public List<Price_combination> map(ResultSet rs) throws SQLException {
				List<Price_combination> list = new ArrayList<Price_combination>();
				while (rs.next()) {
					list.add(new Price_combination(rs.getInt("id"), rs.getInt("price_id"), rs.getInt("value_id")));
				}
				return list;
			}
		}, price_id);
	}

	// 新增价格组合
	public Integer insert_Price_Combination(Price_combination p) {
		String sql = "INSERT INTO price_combination (price_id,value_id) VALUES (?,?)";
		return executeUpdate(sql, p.getPrice_id(), p.getValue_id());
	}

	// 删除价格组合表
	public Integer deltePrice(Integer id) {
		String sql = "delete from price_combination where id =?";
		return executeUpdate(sql, id);
	}

	public static void main(String[] args) {
		System.out.println(new Price_CombinationDAO().selectAllCombiatoin(1));
	}
}
