package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Refund;
import com.entity.Users;
import com.util.BaseDAO;
import com.util.Mapper;

/**
* @Description: 
* @author: 铭
* @date 2024年4月1日 上午9:29:04
*/

public class UsersDAO extends BaseDAO{
	//判断改账号是否注册过
	public Boolean isZhuCe(String phone) {
		Boolean pan = true;
		String sql = "select * from users where phone = ?";
		try {
			stmt =getConn().prepareStatement(sql);
			stmt.setObject(1, phone);
			rs = stmt.executeQuery();
			if(rs.next()) {
				pan = false;
			}
			return pan;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return pan;
	}
	//注册
	public Integer zhuCe(String phone,String password) {
		
		String sql = "insert into users(user_nickname,phone,user_password,head_sculpture,create_time)"
				+ "	  values(?,?,?,?,?)";
		return executeUpdate(sql, nameAdd(),phone,password,"favicon.ico",new Timestamp(new Date().getTime()));
	}
	//昵称自增
	public String nameAdd() {
		Integer sum = nickName();
		String head ="vivo_";
		Integer footer = ++sum;
		String vid = head + String.format("%08d", footer);
		return vid;
	}
	//默认昵称
	public Integer nickName() {
		//vivo_00000001
		String sql = "select count(*) as sum from users";
		try {
			Integer nickname = 0;
			stmt =getConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				nickname = rs.getInt("sum");
			}
			return nickname;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//登录
	public Users dengLv(String phone,String password) {
		String sql = "select * from users where phone = ? and user_password =? and state = 1";
		Users u = null;
		try {
			stmt =getConn().prepareStatement(sql);
			stmt.setObject(1, phone);
			stmt.setObject(2, password);
			rs = stmt.executeQuery();
			if(rs.next()) {
				u = new Users(rs.getInt("id"), 
						rs.getString("user_nickname"), 
						rs.getString("user_password"), 
						rs.getString("phone"),
						rs.getString("head_sculpture"), 
						rs.getDate("birth"), 
						rs.getInt("sex"), 
						rs.getTimestamp("create_time"), 
						rs.getInt("state"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return u;
	}
	public Users dengLv(String phone) {
		String sql = "select * from users where phone = ? and state = 1";
		Users u = null;
		try {
			stmt =getConn().prepareStatement(sql);
			stmt.setObject(1, phone);
			rs = stmt.executeQuery();
			if(rs.next()) {
				u = new Users(rs.getInt("id"), 
						rs.getString("user_nickname"), 
						rs.getString("user_password"), 
						rs.getString("phone"),
						rs.getString("head_sculpture"), 
						rs.getDate("birth"), 
						rs.getInt("sex"), 
						rs.getTimestamp("create_time"), 
						rs.getInt("state"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return u;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new UsersDAO().dengLv("19374234036","6666466"));
	}
	
	
	// 4、doUpdate(实体类):int 修改
	public Integer doupdate(Users obj) {
		// 1、准备修改sql语句
		String sql = "update users set user_password=? where user_nickname=?";
		try {
			// 2、获取连接对象
			conn = super.getConn();
			// 3、预编译SQL语句
			stmt = conn.prepareStatement(sql);
			// 4、填充参数
			stmt.setObject(1, obj.getUser_password());
			stmt.setObject(2, obj.getUser_nickname());
			// 5、执行SQL语句
			return stmt.executeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return -1;// 最后返回-1，表示代码运行到这里，新增失败
	}
	// 查询所有 1、selectAll() :List<实体类>
	public List<Users> selectAll() {
		String sql = "select * from users";
		try {
			// 2、获取连接对象
			conn = getConn();
			// 3、预编译SQL语句
			stmt = conn.prepareStatement(sql);
			// 4、填充参数
			// 5、执行SQL语句，返回到结果集中
			rs = stmt.executeQuery();
			// 6、将结果集中的数据转存到集合中
			List<Users> list = new ArrayList<>();
			if (rs != null) {
				while (rs.next()) {
					// 调用rs.getXXX("列名") 获取游标指向行的数据
					Integer id = rs.getInt("id");
					String user_nickname = rs.getString("user_nickname");
					String user_password = rs.getString("user_password");
					String phone = rs.getString("phone");
					String head_sculpture = rs.getString("head_sculpture");
					Date birth = rs.getDate("birth");
					String sex = rs.getString("sex");
					Timestamp create_time = rs.getTimestamp("create_time");
					Integer state = rs.getInt("state");
					// 将获取到的数据，封装到实体类对象中
					// 一行记录--->一个对象
					Users obj=new Users(id, user_nickname, user_password, phone, head_sculpture, birth, id, create_time, state);
					// 将对象添加到集合中
					list.add(obj);
				}
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
