package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Collection;
import com.entity.Comments;
import com.entity.Commodity_price;
import com.entity.Product;
import com.entity.Product_specifications;
import com.entity.Specification_value;
import com.util.BaseDAO;
import com.util.Mapper;

/**
* @Description: 
* @author: 铭
* @date 2024年4月10日 下午6:58:05
*/

public class CollectionDAO extends BaseDAO{
	//添加收藏
	public Integer insertCollection(Integer user_id,Integer product_id,String sku) {
		String sql = "insert into collection(user_id,product_id,sku,add_time) values(?,?,?,?)";
		return executeUpdate(sql, user_id,product_id,sku,new Timestamp(new Date().getTime()));
	}
	//删除收藏
	public Integer deleteCollection(Integer user_id,Integer product_id,String sku) {
		String sql = "update collection set state = 0 where user_id = ? and product_id = ? AND sku = ?";
		return executeUpdate(sql, user_id,product_id,sku);
	}
	
	//查看是否是收藏
	public Boolean isCollection(Integer user_id,Integer product_id,String sku) {
		String sql = "SELECT * FROM collection WHERE user_id = ? AND product_id = ? AND sku = ? AND state = 1";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, user_id);
			stmt.setObject(2, product_id);
			stmt.setObject(3, sku);
			rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}
	
	//查询该用户的所有收藏
	public List<Collection> queryUser_Collections(Integer user_id) {
        String sql = "SELECT * FROM collection WHERE user_id = ? AND state=1";
        return this.executeQuery(sql, new Mapper<Collection>() {
            @Override
            public List<Collection> map(ResultSet rs) throws SQLException {
                List<Collection> collection = new ArrayList<>();
                while (rs.next()) {
                	Collection collectio = new Collection(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("product_id"),
                        rs.getTimestamp("add_time"),
                        rs.getInt("state"),
                        rs.getString("sku")
                    );
                    collection.add(collectio);
                }
                return collection;
            }
        },user_id);
    }
	//查询商品表
	public Product queryUser_Product(Integer id){
		String sql ="SELECT * FROM product where id=?";
		Product proudc=null;
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, id);;
			rs = stmt.executeQuery();
			if(rs.next()) {
				proudc = new Product(
						rs.getInt("id"),
						rs.getString("products_name"),
						rs.getInt("category_id"),
						rs.getString("description"),
						rs.getLong("hits"),
						rs.getInt("purchase_limit"),
						rs.getTimestamp("listing_time"),
						rs.getInt("state")
								);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return proudc;
	}
		//查询商品规格值表（specification_value）
	public Specification_value specification_Value(Integer id){
		String sql ="SELECT * FROM specification_value where id=?";
		Specification_value product_specifications=null;
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, id);;
			rs = stmt.executeQuery();
			if(rs.next()) {
				product_specifications = new Specification_value(
						rs.getInt("id"),
						rs.getInt("specifications_id"),
						rs.getString("value")
						
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return product_specifications;
	}
	//查询价格表
	public Commodity_price commodity_price(Integer id) {
		String sql="SELECT * FROM commodity_price where id=?";
		Commodity_price commodity_price=null;
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, id);;
			rs = stmt.executeQuery();
			if(rs.next()) {
				commodity_price = new Commodity_price (
						rs.getInt("id"),
						rs.getBigDecimal("price"),
						rs.getInt("product_id"),
						rs.getInt("is_recommended")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return commodity_price;
	}
	
	
	
	
	

	public static void main(String[] args) {
		System.out.println(new CollectionDAO().queryUser_Product(2));
	}
}
