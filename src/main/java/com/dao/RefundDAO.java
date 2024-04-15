package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Refund;
import com.util.BaseDAO;

public class RefundDAO extends BaseDAO {
	 public List<Refund> queryRefunds(int userId, String refundReason, int state) {
	        String sql = "SELECT * FROM refund WHERE user_id=? AND refund_reason=? AND state=?";
	        try {
	            conn = getConn();
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, userId);
	            stmt.setString(2, refundReason);
	            stmt.setInt(3, state);
	            rs = stmt.executeQuery();

	            List<Refund> refunds = new ArrayList<Refund>();
	            while (rs.next()) {
	                Refund refund = new Refund();
	                refund.setId(rs.getInt("id"));
	                refund.setUser_id(rs.getInt("user_id"));
	                refund.setOrder_number(rs.getString("order_number"));
	                refund.setRefund_amount(rs.getBigDecimal("refund_amount"));
	                refund.setRefund_reason(rs.getString("refund_reason"));
	                refund.setState(rs.getInt("state"));
	                refund.setCreate_time(rs.getTimestamp("create_time"));
	                refund.setUpdate_time(rs.getTimestamp("update_time"));
	                refund.setRemark(rs.getString("remark"));
	                refunds.add(refund);
	            }
	            return refunds;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeAll();
	        }
	        return null;
	    }	
	 
	// 删除指定id的退款记录
	 public Integer doDelete(String refundId) {
	     String sql = "DELETE FROM refund WHERE id=?";
	     try {
	         // 获取连接对象
	         conn = super.getConn();
	         // 预编译SQL语句
	         stmt = conn.prepareStatement(sql);
	         // 填充参数
	         stmt.setString(1, refundId);
	         // 执行SQL语句
	         return stmt.executeUpdate();
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         // 关闭资源
	         super.closeAll();
	     }
	     return -1; // 表示删除操作失败
	 }


}

