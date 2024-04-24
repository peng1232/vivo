package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.entity.Shopping_cart;
import com.util.BaseDAO;
import com.util.Mapper;



public class Shopping_CartDAO extends BaseDAO {

	// 查询购物车数量
	public Integer shopping_Count(Integer user_id) {
		String sql = "SELECT COUNT(*) as sum FROM shopping_cart where user_id=? and state = 0 ";
		Integer count = 0;
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, user_id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return count;
	}

	// 添加购物车
	public Integer insertShopping(Shopping_cart s) {
		Integer sid = null;
		String sql = "insert into shopping_cart(user_id,product_id,sku,quantity,add_time) values(?,?,?,?,?)";
		try {
			stmt = getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, s.getUser_id());
			stmt.setInt(2, s.getProduct_id());
			stmt.setString(3, s.getSku());
			stmt.setInt(4, s.getQuantity());
			stmt.setTimestamp(5, s.getAdd_time());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				sid = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return sid;

	}

	// 查看是否有该购物车
	public Boolean isShopping(Integer user_id, Integer product_id) {
		String sql = "SELECT * FROM shopping_cart WHERE user_id = ? AND product_id = ? AND state = 0";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, user_id);
			stmt.setObject(2, product_id);
			rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return false;
	}

	// 根据购物车id查询对应信息
	public Shopping_cart queryShopping(Integer shopping_id) {
		Shopping_cart s = null;
		String sql = "select * from shopping_cart where id = ?";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, shopping_id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				s = new Shopping_cart(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("product_id"),
						rs.getInt("quantity"), rs.getTimestamp("add_time"), rs.getInt("state"), rs.getString("sku"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return s;
	}

	// 查询该用户的购物车
	public List<Shopping_cart> queryUser_Shopping(Integer user_id) {
		String sql = "SELECT *  FROM shopping_cart where user_id=? and state = 0 order by add_time desc";
		return executeQuery(sql, new Mapper<Shopping_cart>() {

			@Override
			public List<Shopping_cart> map(ResultSet rs) throws SQLException {
				List<Shopping_cart> list = new ArrayList<Shopping_cart>();
				while(rs.next()) {
					list.add(new Shopping_cart(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("product_id"),
							rs.getInt("quantity"), rs.getTimestamp("add_time"), rs.getInt("state"), rs.getString("sku")));
				}
				return list;
			}
		}, user_id);
	}
	
	//修改购物车数量
	public String updateShoppingNumber(Integer user_id,Integer shopping_id,Integer sum) {
		String sql = "update shopping_cart set quantity = ?,sku = JSON_REPLACE(sku, '$.number', ?) where id=? and user_id = ?";
		executeUpdate(sql, sum,sum,shopping_id,user_id);
		sql = "select * from shopping_cart where id = ?";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, shopping_id);
			rs = stmt.executeQuery();
			rs.next();
			String sku = rs.getString("sku");
			String trimmedJsonString = sku.replaceAll("\\s", "");
			sql = "update shopping_cart set quantity = ?,sku = ? where id=? and user_id = ?";
			executeUpdate(sql, sum,trimmedJsonString,shopping_id,user_id);
			return trimmedJsonString;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//修改购物车状态
	public Integer updateShoppingState(Integer user_id,List<Integer> shopping_id,Integer state) {
		StringBuffer sb = new StringBuffer("(");
		for(int i=0;i<shopping_id.size();i++) {
			sb.append("?,");
		}
		sb.delete(sb.length()-1, sb.length());
		sb.append(")");
		String sql = "update shopping_cart set state=? where id in "+sb.toString()+" and user_id = ?";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, state);
			for(int i=0;i<shopping_id.size();i++) {
				stmt.setObject(i+2, shopping_id.get(i));
			}
			stmt.setObject(shopping_id.size()+2, user_id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	
	//删除购物车
	public Integer deleteShopping(List<Integer> shopping_id) {
		StringBuffer sql =new StringBuffer("update shopping_cart set state=1 where id in (");
		shopping_id.forEach(e->{
			sql.append(e+",");
		});
		sql.delete(sql.length()-1, sql.length());
		sql.append(")");
		return executeUpdate(sql.toString());
		
	}

	public static void main(String[] args) {
		System.out.println(new Shopping_CartDAO().deleteShopping(Arrays.asList(19,12,1)));
	}
}
