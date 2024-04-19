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
        String sql = "SELECT * FROM comments where id=?";
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
    public static void main(String[] args) {
		System.out.println(new CommentsDAO().queryUser_Comments(1));
	}
}