package com.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.entity.Commodity_price;
import com.entity.Product;
import com.util.BaseDAO;

/**
* @Description: 
* @author: 铭
* @date 2024年4月19日 下午4:11:11
*/

public class Commodity_PriceDAO extends BaseDAO{
	//根据价格id查询价格
	public BigDecimal queryPrice(Integer price_id) {
		BigDecimal price = null;
		String sql = "select price from commodity_price where id=?";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, price_id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				price = new BigDecimal(rs.getString("price"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return price;
	}
	
	//查询所有的价格
	public List<Commodity_price> Commodity_priceSelectAll(Commodity_price c,Integer curpage, Integer pagesize){
		StringBuffer sb = new StringBuffer("select * from commodity_price where 1=1 ");
		List<String> l = new ArrayList<String>();
		if(c!=null) {
			if (c.getProduct_id() != null ) {
				sb.append(" and product_id = ? ");
				l.add(c.getProduct_id() +"");
			}
			if (c.getIs_recommended()!=null) {
				sb.append(" and is_recommended like ? ");
				l.add(c.getIs_recommended()+"");
			}
		}
		sb.append(" ORDER BY id DESC");
		if(curpage!=null||pagesize!=null) {
			sb.append(" limit " + ((curpage - 1) * pagesize) + ", " + (pagesize) + " ");
		}
		
		List<Commodity_price> list = new ArrayList<Commodity_price>();
		try {
			stmt = getConn().prepareStatement(sb.toString());
			for(int i=0;i<l.size();i++) {
				stmt.setObject(i+1, l.get(i));
			}
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(new Commodity_price(rs.getInt("id"),rs.getBigDecimal("price"),rs.getInt("product_id"),rs.getInt("is_recommended")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	
	//添加价格表
	public Integer insertPrice(Commodity_price c) {
		String sql = "insert into commodity_price values(null,?,?,?)";
		return executeUpdate(sql, c.getPrice(),c.getIs_recommended(),c.getProduct_id());
	}
	
	//修改价格
	public Integer updatePrice(Commodity_price c) {
		String sql = "update commodity_price set price=?,product_id=?,is_recommended=? where id =?";
		return executeUpdate(sql, c.getPrice(),c.getProduct_id(),c.getIs_recommended(),c.getId());
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Commodity_PriceDAO().Commodity_priceSelectAll(new Commodity_price(1,null,1,1),1,2));
	}
}
