package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Product;
import com.util.BaseDAO;
import com.util.Mapper;

/**
* @Description: 
* @author: 铭
* @date 2024年4月3日 上午10:11:39
*/

public class ProductDAO extends BaseDAO{
	//根据类别查询对应的商品
	public List<Product> type_Product(Integer type_id,Integer curpage,Integer pagesize){

		

		String sql = "select * from product where category_id = ? and state = 1 limit ?,?";
		List<Product> list =  executeQuery(sql, new Mapper<Product>() {

			@Override
			public List<Product> map(ResultSet rs) throws SQLException {
				List<Product> list = new ArrayList<Product>();
				while(rs.next()) {
					list.add(new Product(rs.getInt("id"),
										rs.getString("products_name"),
										rs.getInt("category_id"),
										rs.getString("description"),
										rs.getLong("hits"),
										rs.getInt("purchase_limit"),
										rs.getTimestamp("listing_time"),
										rs.getInt("state")));
				}
				return list;
			}
		}, type_id,curpage,pagesize);
		
		String sql2 = "	SELECT pi.image_url FROM product p\r\n"
				+ "JOIN product_specifications ps ON p.id = ps.product_id\r\n"
				+ "JOIN specification_value sv ON ps.id = sv.specifications_id\r\n"
				+ "JOIN product_image PI ON sv.id = pi.value_id\r\n"
				+ "WHERE p.id = ? LIMIT 1;";
		 conn = getConn();
		list.forEach(e->{
			try {
				stmt =conn.prepareStatement(sql2);
				stmt.setObject(1, e.getId());
				rs = stmt.executeQuery();
				if(rs.next()) {
					e.setImage_url(rs.getString("image_url"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		closeAll();
		return list;
	}
	public static void main(String[] args) {
		System.out.println(new ProductDAO().type_Product(1, 0, 6).get(1));
	}
}
