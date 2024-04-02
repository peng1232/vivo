package com.servlet.init;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson2.JSONObject;
import com.dao.Shopping_CartDAO;
import com.dao.User_Login_TimeDAO;
import com.dao.UsersDAO;
import com.entity.Users;
import com.qita.Yzm;

/**
* @Description: 
* @author: 铭
* @date 2024年4月2日 上午9:47:49
*/

@WebServlet("/jsp/navSerlvet")
public class NavInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Shopping_CartDAO sdao=  new Shopping_CartDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jsonObj = new JSONObject();
		System.out.println(request.getParameter("id"));
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}


}