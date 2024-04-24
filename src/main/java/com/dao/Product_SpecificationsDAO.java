package com.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.entity.Product;
import com.entity.Product_specifications;
import com.util.BaseDAO;

/**
* @Description: 
* @author: 铭
* @date 2024年4月24日 上午8:47:59
*/

public class Product_SpecificationsDAO extends BaseDAO{
	//分页查询所有的商品规格
	public List<Product_specifications> specificationsSelectAll(Product_specifications s, Integer curpage,Integer pagesize){
		StringBuffer sb = new StringBuffer("select * from product_specifications where 1=1 ");
		List<String> l = new ArrayList<String>();
		List<Product_specifications> list = new ArrayList<Product_specifications>();
		if(s!=null) {
			if (s.getProduct_id() != null ) {
				sb.append(" and product_id = ? ");
				l.add(s.getProduct_id()+"");
			}
			if (s.getSpecifications_name() != null &&s.getSpecifications_name().length()>0) {
				sb.append(" and specifications_name like ? ");
				l.add("%"+s.getSpecifications_name()+"%");
			}
		}
		
		if(curpage!=null||pagesize!=null) {
			sb.append("ORDER BY id DESC limit " + ((curpage - 1) * pagesize) + ", " + (pagesize) + " ");
		}
		
		try {
			stmt = getConn().prepareStatement(sb.toString());
			for(int i=0;i<l.size();i++) {
				stmt.setObject(i+1, l.get(i));
			}
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(new Product_specifications(rs.getInt("id"), rs.getInt("product_id"), rs.getString("specifications_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	
	//新增规格
	public Integer insertProduct_Specifications(Product_specifications p) {
		String sql= "insert into product_specifications(product_id,specifications_name) values(?,?) ";
		return executeUpdate(sql, p.getProduct_id(),p.getSpecifications_name());
	}
	
	//修改规格
	public Integer updateProduct_Specifications(Product_specifications p) {
		String sql ="update product_specifications set product_id=?,specifications_name=? where id = ?";
		return executeUpdate(sql, p.getProduct_id(),p.getSpecifications_name(),p.getId());
	}
	
	public static void main(String[] args) {
		System.out.println(new Product_SpecificationsDAO().specificationsSelectAll(new Product_specifications(1, null, "版"), 1, 1));
	}
}
