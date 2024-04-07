package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.BaseDAO;
import com.util.Mapper;

public class CommentsDAO extends BaseDAO{
	public List<CommentsDAO> querALL(){
		String sql="select * from ECommerceDB order by comments desc";
		List<CommentsDAO> list = this.executeQuery(sql, new Mapper<CommentsDAO>() {

			@Override
			public List<CommentsDAO> map(ResultSet rs) throws SQLException {
				List<CommentsDAO> list = new ArrayList();
				while (rs.next()) {
					list.add(new CommentsDAO(rs.getInt("id"),
							rs.getInt("user_id"),
							rs.getString("user_com"),
							rs.getInt("product_id"),	
							rs.getInt("state"),
							rs.getInt("com_grade")));
				}
			
				// TODO Auto-generated method stub
				return list;
		
		}
		
		});
					return list;
	}
}

