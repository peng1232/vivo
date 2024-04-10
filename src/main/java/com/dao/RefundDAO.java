package com.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.entity.Refund;
import com.util.BaseDAO;


public class RefundDAO extends BaseDAO {
	// 查询所有
    public List<Refund> selectRec() {
        String sql = "SELECT * FROM refund";
        try {
            conn = getConn();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<Refund> list = new ArrayList<>();
            if (rs != null) {
                while (rs.next()) {
                    Integer id = rs.getInt("id");
                    Integer userId = rs.getInt("user_id");
                    String orderNumber = rs.getString("order_number");
                    Double refundAmount = rs.getDouble("refund_amount");
                    String refundReason = rs.getString("refund_reason");
                    Integer state = rs.getInt("state");
                    Timestamp createTime = rs.getTimestamp("create_time");
                    Timestamp updateTime = rs.getTimestamp("update_time");
                    String remark = rs.getString("remark");

                    // 创建 Refund 对象并添加到列表中
                    Refund refund = new Refund(id, userId, orderNumber, null, refundReason, state, createTime, updateTime, remark);
                    list.add(refund);
                }
            }
            return list;
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
