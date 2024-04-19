package com.servlet.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CommentsDAO;
import com.entity.Comments;

/**
 * Servlet implementation class CommentsServlet
 */
@WebServlet("/jsp/user/CommentsServlet")
public class CommentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CommentsDAO commentsDAO = new CommentsDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Comments> commentsList = commentsDAO.queryUser_Comments(1);
        request.setAttribute("commentsList", commentsList);
        request.getRequestDispatcher("pinglun.jsp").forward(request, response);
    }
}