package com.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Users;
import com.util.BaseDAO;

public class userDAO extends BaseDAO{
	public List<Users> selectAlluse() {
		// 1、查询category表的所有记录，并按照主键倒序
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
			List<Users> list = null;
			if (rs != null) {
				list = new ArrayList<Users>();
				while (rs.next()) {
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
					Users obj = new Users(id, user_nickname, user_password, phone, head_sculpture, birth, id,
							create_time, state);
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

	public List<Users> selectByname(String name, Integer state) {
		// 1、查询category表的所有记录，并按照主键倒序
		String sql = "select * from users where user_nickname=? and state=? ";
		try {
			 stmt = getConn().prepareStatement(sql);
			// 4、填充参数
			 stmt.setObject(1, name);
		     stmt.setObject(2, state);
		        
		      System.out.println(name);
		      System.out.println(state);
			// 5、执行SQL语句，返回到结果集中
			rs = stmt.executeQuery();
			// 6、将结果集中的数据转存到集合中
			List<Users> list = null;
			if (rs != null) {
				list = new ArrayList<Users>();
				while (rs.next()) {
					Integer id = rs.getInt("id");
					String user_nickname = rs.getString("user_nickname");
					String user_password = rs.getString("user_password");
					String phone = rs.getString("phone");
					String head_sculpture = rs.getString("head_sculpture");
					Date birth = rs.getDate("birth");
					String sex = rs.getString("sex");
					Timestamp create_time = rs.getTimestamp("create_time");
					Integer stata = rs.getInt("state");

					// 将获取到的数据，封装到实体类对象中
					// 一行记录--->一个对象
					Users obj = new Users(id, user_nickname, user_password, phone, head_sculpture, birth, id,
							create_time, state);
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
	public Integer zhuCe(String phone, String password) {
		String sql = "insert into users(user_nickname,phone,user_password,head_sculpture,create_time)"
				+ "	  values(?,?,?,?,?)";
		return executeUpdate(sql, nameAdd(), phone, password, "favicon.ico", new Timestamp(new Date().getTime()));
	}
	public String nameAdd() {
		Integer sum = nickName();
		String head = "vivo_";
		Integer footer = ++sum;
		String vid = head + String.format("%08d", footer);
		return vid;
	}
	public Integer nickName() {
		// vivo_00000001
		String sql = "select count(*) as sum from users";
		try {
			Integer nickname = 0;
			stmt = getConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				nickname = rs.getInt("sum");
			}
			return nickname;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	// doUpdate(实体类):int 修改可用状态
	public Integer doDelet(Integer id, String state){
		String sql = "UPDATE users SET state=? where id=?";
		try {
			//2、获取连接对象
			conn = super.getConn();
			//3、预编译SQL语句
			stmt = conn.prepareStatement(sql);
			//4、填充参数
			stmt.setObject(1,state);
			stmt.setObject(2, id);
			//5、执行SQL语句
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.closeAll();
		}
		return -1;//最后返回-1，表示代码运行到治理，新增失败
	}

	// doUpdate(实体类):int 修改
	public Integer douUpdate(Users sex, Integer id) {
		String sql = "UPDATE users SET  user_nickname=?,phone=?,user_password=? where id=?";
		try {
			stmt = getConn().prepareStatement(sql);
			// 设置参数的值
			stmt.setObject(1,sex.getUser_nickname() );
			stmt.setObject(2,sex.getPhone() );
			stmt.setObject(3,sex.getUser_password() );
			stmt.setObject(4,id);
			System.err.println(stmt);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.closeAll();
		}
		return -1;//最后返回-1，表示代码运行到治理，新增失败
	}
}
