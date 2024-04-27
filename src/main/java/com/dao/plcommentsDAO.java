package com.dao;

import com.util.BaseDAO;

public class plcommentsDAO extends BaseDAO {
    // 获取评论和回复数量
    public long getCommentsAndRepliesCount() {
        String sql = "SELECT COUNT(*) FROM comments";
        Long count = (Long) singleObject(sql);
        return count != null ? count.longValue() : 0;
    }

    public static void main(String[] args) {
        plcommentsDAO dao = new plcommentsDAO();
        long commentCount = dao.getCommentsAndRepliesCount();
        System.out.println(commentCount);
    }
}
