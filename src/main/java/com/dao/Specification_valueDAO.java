package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Specification_value;
import com.util.BaseDAO;

public class Specification_valueDAO extends BaseDAO{
	//根据商品id，价格id，查询对应的规格和规格id
	public List<Specification_value> queryValue(Integer product_id,Integer price_id) {
		List<Specification_value> list = new ArrayList<Specification_value>();
		String sql = "SELECT ps.specifications_name, MIN(sv.value) AS VALUE,MIN(sv.id) AS value_id\r\n"
				+ "FROM product_specifications ps\r\n"
				+ "JOIN specification_value sv ON ps.id = sv.specifications_id\r\n"
				+ "JOIN price_combination pc ON sv.id = pc.value_id\r\n"
				+ "WHERE ps.product_id = ? AND pc.price_id = ? \n"
				+ "GROUP BY ps.specifications_name";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, product_id);
			stmt.setObject(2, price_id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add( new Specification_value(rs.getInt("value_id"), null, rs.getString("VALUE")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.println(new Specification_valueDAO().queryValue(1, 2));
	}
}
