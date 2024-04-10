package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.entity.Commodity_price;
import com.entity.Product;
import com.entity.Product_specifications;
import com.entity.Specification_value;
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
					list. add(new Product(rs.getInt("id"),
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
	
	//查询商品的图片集
	public List<String> queryUrl_image(Integer product,Integer value_id){
		String sql = "SELECT pi.image_url FROM product p\r\n"
				+ "JOIN product_specifications ps ON p.id = ps.product_id\r\n"
				+ "JOIN specification_value sv ON ps.id = sv.specifications_id\r\n"
				+ "JOIN product_image PI ON sv.id = pi.value_id\r\n"
				+ "WHERE p.id = ? AND sv.id = ?";
		return executeQuery(sql, new Mapper<String>() {

			@Override
			public List<String> map(ResultSet rs) throws SQLException {
				List<String> list = new ArrayList<String>();
				while(rs.next()) {
					list.add(rs.getString("image_url"));
				}
				return list;
			}
		}, product,value_id);
	}
	
	//根据商品id查出对应的数据
	public Product queryProduct(Integer product_id) {
		String sql = "select * from product where id = ?";
		Product p = null;
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, product_id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				p = new Product(rs.getInt("id"),
						rs.getString("products_name"),
						rs.getInt("category_id"),
						rs.getString("description"),
						rs.getLong("hits"),
						rs.getInt("purchase_limit"),
						rs.getTimestamp("listing_time"),
						rs.getInt("state"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return p;
	}

	//查出该商品的规格
	public List<Product_specifications> querySpecifications(Integer product_id) {
		String sql = "SELECT * FROM product_specifications WHERE product_id = ?";
		return executeQuery(sql, new Mapper<Product_specifications>() {

			@Override
			public List<Product_specifications> map(ResultSet rs) throws SQLException {
				List<Product_specifications> list = new ArrayList<Product_specifications>();
				while(rs.next()) {
					list.add(new Product_specifications(rs.getInt("id"), rs.getInt("product_id"), rs.getString("specifications_name")));
				}
				return list;
			}
		}, product_id);
	}
	//查出该商品的规格值
	public List<Specification_value> queryValue(Integer specifications_id) {
		String sql = "SELECT * FROM specification_value WHERE specifications_id = ?";
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
	
	//根据规格id查询价格
	public Commodity_price queryPrice(List<Integer> specifications_id) {
		Commodity_price c = null;
		StringBuffer sb = new StringBuffer();
		specifications_id.forEach(e->{
			sb.append("?,");
		});
		sb.delete(sb.length()-1, sb.length());
		String sql = "SELECT cp.price,cp.id\r\n"
				+ "FROM commodity_price cp\r\n"
				+ "INNER JOIN price_combination pc ON cp.id = pc.price_id\r\n"
				+ "WHERE pc.value_id IN ("+sb.toString()+")\r\n"
				+ "GROUP BY cp.price,cp.id\r\n"
				+ "HAVING COUNT(DISTINCT pc.value_id) = "+specifications_id.size();
		try {
			stmt = getConn().prepareStatement(sql);
			for(int i=0;i<specifications_id.size();i++) {
				stmt.setObject(i+1, specifications_id.get(i));
			}
			rs = stmt.executeQuery();
			if(rs.next()) {
				c = new Commodity_price();
				c.setId(rs.getInt("id"));
				c.setPrice(rs.getBigDecimal("price"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			closeAll();
		}
		return c;
	}
	
	//添加点击量
	public Integer queryHits(Integer product_id) {
		String sql = "UPDATE product, (SELECT hits FROM product WHERE id = ?) AS temp_table\r\n"
				+ "SET product.hits = temp_table.hits + 1\r\n"
				+ "WHERE product.id = ?";
		return executeUpdate(sql, product_id,product_id);
	}
	
	//查询商品的收藏数量
	public Long queryCollection(Integer product) {
		Long collection_count = 0L;
		String sql = "SELECT COUNT(*) as collection_count\r\n"
				+ "FROM collection\r\n"
				+ "WHERE state = 1 AND product_id = ?\r\n"
				+ "GROUP BY product_id;";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, product);
			rs = stmt.executeQuery();
			if(rs.next()) {
				collection_count = rs.getLong("collection_count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return collection_count;
	};
	
	public static void main(String[] args) {
		System.out.println(new ProductDAO().queryCollection(1));
	}
}
