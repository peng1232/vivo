package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Specification_value;
import com.util.BaseDAO;
import com.util.Mapper;

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
	
	//根据规格id查对应的规格值
	public List<Specification_value> selectValue(Integer specifications_id) {
		String sql = "SELECT * FROM specification_value WHERE specifications_id = ? order by id desc";
		return executeQuery(sql, new Mapper<Specification_value>() {

			@Override
			public List<Specification_value> map(ResultSet rs) throws SQLException {
				 List<Specification_value> list = new ArrayList<Specification_value>();
				 while(rs.next()) {
					 list.add(new Specification_value(rs.getInt("id"), rs.getInt("specifications_id"), rs.getString("value")));
				 }
				 return list;
			}
		}, specifications_id);
	}
	
	//修改规格值
	public Integer updateValue(Specification_value s) {
		String sql = "update specification_value set `value`=? where id =?";
		return executeUpdate(sql, s.getValue(),s.getId());
	}
	
	//添加规格值
	public Integer insertValue(Specification_value s) {
		String sql = "insert into specification_value value(null,?,?)";
		return executeUpdate(sql, s.getSpecifications_id(),s.getValue());
	}
	
	//根据规格值id查规格
	public Specification_value selectValue_id(Integer value_id) {
		Specification_value s = null;
		String sql = "SELECT * FROM specification_value WHERE id = ? order by id desc";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, value_id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				s = new Specification_value(rs.getInt("id"), rs.getInt("specifications_id"), rs.getString("value"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println(new Specification_valueDAO().selectValue_id( 2));
	}
}
