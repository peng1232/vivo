package com.servlet.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.CommentsDAO;
import com.entity.Comments;

/**
 * Servlet implementation class CommentsServlet
 */
@WebServlet("/jsp/user/CommentsInsertServlet")
public class CommentsInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CommentsDAO commentsDAO = new CommentsDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer user_id = Integer.valueOf(request.getParameter("user_id"));
    	String user_com = request.getParameter("user_com");
    	Integer product_id = Integer.valueOf(request.getParameter("product_id"));
    	Integer com_grade = Integer.valueOf(request.getParameter("com_grade"));
    	Comments c = new Comments(null, user_id, user_com, product_id, 0, com_grade);
    	commentsDAO.insertComments(c);
    	JSONObject jsonObj = new JSONObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
    }
}