package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.util.BaseDAO;

public class wfkOrdersDAO extends BaseDAO {
    public int getUnpaidOrdersCount(Integer user_id) {
        String sql = "SELECT COUNT(*) FROM orders WHERE state = ? and user_id = ?";
        int count = 0;
        try (Connection conn = getConn();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, 2); // 2 represents unpaid state
            stmt.setInt(2, user_id); // 2 represents unpaid state
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt(1); // Retrieve the count
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
        wfkOrdersDAO dao = new wfkOrdersDAO();
        int unpaidCount = dao.getUnpaidOrdersCount(3);
        System.out.println(unpaidCount);
    }
}
