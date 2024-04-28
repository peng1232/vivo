package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.log.Log;
import com.util.BaseDAO;

public class plcommentsDAO extends BaseDAO {
	// 获取评论和回复数量
	public long getCommentsAndRepliesCount(Integer user_id) {
		Long count = 0l;
		String sql = "SELECT COUNT(*) as sum FROM comments where state in(0,1) and user_id =?";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, user_id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count=rs.getLong("sum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return count;
	}

	public static void main(String[] args) {
		plcommentsDAO dao = new plcommentsDAO();
		long commentCount = dao.getCommentsAndRepliesCount(2);
		System.out.println(commentCount);
	}
}
