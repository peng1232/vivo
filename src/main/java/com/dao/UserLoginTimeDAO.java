package com.dao;

import java.sql.SQLException;
import java.sql.Timestamp;

import com.util.BaseDAO;

public class UserLoginTimeDAO extends BaseDAO {
    
    public Timestamp selectLastLoginTime(int userId) {
        String sql = "SELECT login_time FROM user_login_time WHERE user_id = ? ORDER BY login_time DESC LIMIT 1";
        try {
            conn = getConn();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getTimestamp("login_time");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, stmt, conn);
        }
        return null;
    }
    public static void main(String[] args) {
		System.out.println(new UserLoginTimeDAO().selectLastLoginTime(1));
	}
}
