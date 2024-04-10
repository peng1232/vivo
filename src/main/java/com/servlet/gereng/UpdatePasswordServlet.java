package com.servlet.gereng;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.dao.UsersDAO;
import com.entity.Users;

/**
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet("/jsp/gereng/UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
	UsersDAO r = new UsersDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		JSONArray jsonArray = new JSONArray();
		System.out.println(1);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println(jsonArray.toJSONString());
	}

}
