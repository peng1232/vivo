package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Comments;
import com.util.BaseDAO;
import com.util.Mapper;

public class CommentsDAO extends BaseDAO {
    
    public List<Comments> queryUser_Comments(Integer user_id) {
        String sql = "SELECT * FROM comments where id = ? ORDER BY id DESC";
        return this.executeQuery(sql, new Mapper<Comments>() {
            @Override
            public List<Comments> map(ResultSet rs) throws SQLException {
                List<Comments> comments = new ArrayList<>();
                while (rs.next()) {
                    Comments comment = new Comments(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("user_com"),
                        rs.getInt("product_id"),
                        rs.getInt("state"),
                        rs.getInt("com_grade")
                    );
                    comments.add(comment);
                }
                return comments;
            }
        },user_id);
    }
    
    //查询商品评论
    public List<Comments> queryProductComments(Integer product_id,Integer start,Integer end) {
    	String sql = "SELECT \r\n"
    			+ "    u.head_sculpture,\r\n"
    			+ "    u.user_nickname,\r\n"
    			+ "    c.user_com ,\r\n"
    			+ "    od.sku,c.com_grade\r\n"
    			+ "FROM \r\n"
    			+ "    comments c\r\n"
    			+ "JOIN \r\n"
    			+ "    users u ON c.user_id = u.id\r\n"
    			+ "JOIN \r\n"
    			+ "    orders o ON o.user_id = u.id\r\n"
    			+ "JOIN \r\n"
    			+ "    order_details od ON o.order_number = od.order_number\r\n"
    			+ "WHERE \r\n"
    			+ "    c.product_id = ? AND\r\n"
    			+ "    od.product_id = c.product_id\r\n"
    			+ "    AND o.state = 7 AND c.state IN (0,1)\r\n"
    			+ "    ORDER BY c.id DESC\r\n"
    			+ "    LIMIT ?,?";
    	return executeQuery(sql, new Mapper<Comments>() {

			@Override
			public List<Comments> map(ResultSet rs) throws SQLException {
				List<Comments> list = new ArrayList<Comments>();
				while(rs.next()) {
					Comments c = new Comments();
					c.setHead_sculpture(rs.getString("head_sculpture"));
					c.setUser_nickname(rs.getString("user_nickname"));
					c.setUser_com(rs.getString("user_com"));
					c.setCom_grade(rs.getInt("com_grade"));
					c.setSku(rs.getString("sku"));
					list.add(c);
				}
				return list;
			}
		}, product_id,start,end);
    }
    
    public static void main(String[] args) {
		System.out.println(new CommentsDAO().queryProductComments(1,0,10));
	}
}