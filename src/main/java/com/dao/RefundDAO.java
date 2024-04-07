//package com.dao;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.util.BaseDAO;
//
//
//public class RefundDAO extends BaseDAO {
//	// 查询所有 1、selectAll() :List<实体类>
//	public List<Record> selectAll() {
//		String sql = "select * from refund";
//		try {
//			// 2、获取连接对象
//			conn = getConn();
//			// 3、预编译SQL语句
//			stmt = conn.prepareStatement(sql);
//			// 4、填充参数
//			// 5、执行SQL语句，返回到结果集中
//			rs = stmt.executeQuery();
//			// 6、将结果集中的数据转存到集合中
//			List<Record> list = null;
//			if (rs != null) {
//				list = new ArrayList<Record>();
//				while (rs.next()) {
//					// 调用rs.getXXX("列名") 获取游标指向行的数据
//					Integer id = rs.getInt("id");
//					String refund_reason = rs.getString("refund_reason");
//					Integer state = rs.getInt("state");
//					// 将获取到的数据，封装到实体类对象中
//					// 一行记录--->一个对象
//					Record obj=new Record(id, refund_reason,state);
//					// 将对象添加到集合中
//					list.add(obj);
//				}
//			}
//			return list;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//}
