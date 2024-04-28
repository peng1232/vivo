package com.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Users;
import com.util.BaseDAO;

public class userDAO extends BaseDAO {
	public List<Users> selectAlluse(Users s,Integer curpage, Integer pagesize) {
		StringBuffer sb = new StringBuffer("select * from users where 1=1 ");
		List<String> zhi = new ArrayList<String>();
		List<Users> user = new ArrayList<Users>();
		if(s.getUser_nickname()!=null) {
			sb.append(" and user_nickname like ?");
			zhi.add("%"+s.getUser_nickname()+"%");
		}
		if(s.getState()!=null) {
			sb.append(" and state =?");
			zhi.add(s.getState()+"");
		}
		if(curpage!=null||pagesize!=null) {
			sb.append( " ORDER BY id DESC limit " + ((curpage - 1) * pagesize) + ", " + (pagesize) + " ");
		}
		try {
			stmt = getConn().prepareStatement(sb.toString());
			for(int i=0;i<zhi.size();i++) {
				stmt.setObject(i+1, zhi.get(i));
			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				user.add(new Users(rs.getInt("id"), rs.getString("user_nickname"), rs.getString("user_password"),
						rs.getString("phone"), rs.getString("head_sculpture"), rs.getDate("birth"), rs.getInt("sex"),
						rs.getTimestamp("create_time"), rs.getInt("state")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return user;
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
	public Integer doDelet(Integer id, String state) {
		String sql = "UPDATE users SET state=? where id=?";
		try {
			// 2、获取连接对象
			conn = super.getConn();
			// 3、预编译SQL语句
			stmt = conn.prepareStatement(sql);
			// 4、填充参数
			stmt.setObject(1, state);
			stmt.setObject(2, id);
			// 5、执行SQL语句
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return -1;// 最后返回-1，表示代码运行到治理，新增失败
	}

	// doUpdate(实体类):int 修改
	public Integer douUpdate(Users sex, Integer id) {
		String sql = "UPDATE users SET  user_nickname=?,phone=?,user_password=? where id=?";
		try {
			stmt = getConn().prepareStatement(sql);
			// 设置参数的值
			stmt.setObject(1, sex.getUser_nickname());
			stmt.setObject(2, sex.getPhone());
			stmt.setObject(3, sex.getUser_password());
			stmt.setObject(4, id);
			System.err.println(stmt);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return -1;// 最后返回-1，表示代码运行到治理，新增失败
	}
}
