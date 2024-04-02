package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Administrator;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.util.BaseDAO;
import com.util.Mapper;

public class AdministratorDAO extends BaseDAO{
	//查询所有
	public List<Administrator> queryAll(){
		String sql="select * from administrator order by id dese";
		List<Administrator> list = this.executeQuery(sql, new Mapper<Administrator>() {

			@Override
			public List<Administrator> map(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				List<Administrator> list =new ArrayList();
				while (rs.next()) {
					list.add(new Administrator(rs.getInt("id"), rs.getString("admin_nickname"),
							rs.getString("admin_account"),rs.getString("admin_password"),
							rs.getInt("state")
							));
				}
				return list;
			}
		});
		return list;
	}
	public Administrator DengLu(String name,String password) {
		String sql = "SELECT * FROM administrator where admin_account=? and admin_password =?";
		Administrator admin = null;
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, name);
			stmt.setObject(2, password);
			rs = stmt.executeQuery();
			if(rs.next()) {
				admin = new Administrator(rs.getInt("id"), rs.getString("admin_nickname"),
						rs.getString("admin_account"),rs.getString("admin_password"),
						rs.getInt("state"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	} 
	public static void main(String[] args) {
		System.out.println(new AdministratorDAO().DengLu("123", "123"));

	}
}
