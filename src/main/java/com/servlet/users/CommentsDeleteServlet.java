package com.servlet.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.CommentsDAO;

/**
 * Servlet implementation class CommentsDeleteServlet
 */
@WebServlet("/jsp/user/CommentsDeleteServlet")
public class CommentsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   CommentsDAO coodao = new CommentsDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		coodao.delectComments(id);
		
		
		JSONObject jsonObj = new JSONObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}

	

}
