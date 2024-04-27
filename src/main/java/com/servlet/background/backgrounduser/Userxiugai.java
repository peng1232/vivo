package com.servlet.background.backgrounduser;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.AdministratorDAO;
import com.dao.userDAO;
import com.entity.Users;

@WebServlet("/jsp/background/Userxiugai")
public class Userxiugai extends HttpServlet {
	private static final long serialVersionUID = 1L;
    userDAO admin = new userDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer	id =Integer.valueOf(request.getParameter("id"));
		String	user_nickname=request.getParameter("user_nickname");
		String	phone=request.getParameter("phone");
		String	user_password=request.getParameter("user_password");
		Users users=new Users(id, user_nickname, user_password, phone, null, null, null, null, null);
		admin.douUpdate(users,id);
		JSONObject jsonObj = new JSONObject();
		response.setContentType("userDAO/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
		
	}

}
