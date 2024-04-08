package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	//查出推荐商品
	public List<Product> productRecommend(){
		String sql = "SELECT \r\n"
				+ "    p.id, \r\n"
				+ "    p.products_name, \r\n"
				+ "    p.description, \r\n"
				+ "    cp.price,\r\n"
				+ "    (SELECT image_url \r\n"
				+ "     FROM product_image PI \r\n"
				+ "     JOIN specification_value sv ON pi.value_id = sv.id\r\n"
				+ "     JOIN product_specifications ps ON sv.specifications_id = ps.id\r\n"
				+ "     WHERE ps.product_id = p.id\r\n"
				+ "     LIMIT 1) AS image_url\r\n"
				+ "FROM \r\n"
				+ "    product p\r\n"
				+ "JOIN commodity_price cp ON p.id = cp.product_id\r\n"
				+ "WHERE \r\n"
				+ "    cp.is_recommended = 1\r\n"
				+ "ORDER BY p.id DESC LIMIT 3;";
		return executeQuery(sql, new Mapper<Product>() {

			@Override
			public List<Product> map(ResultSet rs) throws SQLException {
				List<Product> list = new ArrayList<Product>();
				while(rs.next()) {
					Product p = new Product();
					p.setId(rs.getInt("id"));
					p.setProducts_name(rs.getString("products_name"));
					String miao = rs.getString("description");
					String[] split = miao.split("\\|");
					p.setDescription(split[(int) (Math.random()*split.length)]);
					p.setPrice(rs.getBigDecimal("price"));
					p.setImage_url(rs.getString("image_url"));
					list.add(p);
				}
				return list;
			}
		});
	} 
	
	//查询点击量最多的八个商品
	public List<Product> productHits(){
		String sql ="SELECT \r\n"
				+ "    p.id,\r\n"
				+ "    p.products_name,\r\n"
				+ "    p.description,\r\n"
				+ "    p.hits,\r\n"
				+ "    (SELECT MIN(cp.price) \r\n"
				+ "     FROM commodity_price cp \r\n"
				+ "     WHERE cp.product_id = p.id) AS price,\r\n"
				+ "    (SELECT pi.image_url \r\n"
				+ "     FROM product_image PI \r\n"
				+ "     JOIN specification_value sv ON pi.value_id = sv.id\r\n"
				+ "     JOIN product_specifications ps ON sv.specifications_id = ps.id \r\n"
				+ "     WHERE ps.product_id = p.id \r\n"
				+ "     LIMIT 1) AS image_url\r\n"
				+ "FROM \r\n"
				+ "    product p\r\n"
				+ "ORDER BY p.hits DESC LIMIT 8;\r\n"
				+ "";
		return executeQuery(sql, new Mapper<Product>() {

			@Override
			public List<Product> map(ResultSet rs) throws SQLException {
				List<Product> list = new ArrayList<Product>();
				while(rs.next()) {
					Product p = new Product();
					p.setId(rs.getInt("id"));
					p.setProducts_name(rs.getString("products_name"));
					String miao = rs.getString("description");
					String[] split = miao.split("\\|");
					p.setDescription(split[(int) (Math.random()*split.length)]);
					p.setPrice(rs.getBigDecimal("price"));
					p.setImage_url(rs.getString("image_url"));
					list.add(p);
				}
				return list;
			}
		});
	}
	
	public static void main(String[] args) {
		System.out.println(new ProductDAO().productHits().get(0));
	}
}
