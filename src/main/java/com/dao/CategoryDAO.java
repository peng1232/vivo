package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Category;
import com.util.BaseDAO;
import com.util.Mapper;

import ch.qos.logback.core.joran.action.NewRuleAction;

/**
* @Description: 
* @author: 铭
* @date 2024年4月2日 下午3:01:14
*/

public class CategoryDAO extends BaseDAO{
	//查询所有类别
	public List<Category> selectAll(){
		String sql = "select * from category where state = 1";
		return executeQuery(sql, new Mapper<Category>() {

			@Override
			public List<Category> map(ResultSet rs) throws SQLException {
				List<Category> list = new ArrayList<Category>();
				while(rs.next()) {
					list.add(new Category(rs.getInt("id"), rs.getString("category_type"), rs.getInt("state")));
				}
				return list;
			}
		});
	}
	
	public List<Category> selectAll(Integer state,Integer curpage, Integer pagesize){
		List<Category> list = new ArrayList<Category>();
		String sql = "select * from category where 1=1";
		if(state!=null) {
			sql+=" and state = ? ";
		}
		sql += " ORDER BY id DESC limit " + ((curpage - 1) * pagesize) + ", " + (pagesize) + " ";
		try {
			stmt = getConn().prepareStatement(sql);
			if(state!=null) {
				stmt.setObject(1, state);
			}
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(new Category(rs.getInt("id"), rs.getString("category_type"), rs.getInt("state")));
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
		System.out.println(new CategoryDAO().selectAll(null,1,2));
	}
}
