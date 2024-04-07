package com.servlet.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CommentsDAO;

/**
 * Servlet implementation class CommentsServlet
 */
@WebServlet("/jsp/user/CommentsServlet")
public class CommentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CommentsDAO commentsDAO = new CommentsDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CommentsDAO> list = commentsDAO.querALL();
        request.setAttribute("list", list); // 设置请求属性名为 "list"
        request.getRequestDispatcher("Comments.jsp").forward(request, response); // 转发请求
    }

}