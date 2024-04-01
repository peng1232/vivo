package com.servlet.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson2.JSONObject;
import com.dao.UsersDAO;
import com.entity.Users;

/**
 * Servlet implementation class DengLvSerlvet
 */
@WebServlet("/jsp/login/isphone")
public class IsPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersDAO udao = new UsersDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		JSONObject jsonObj = new JSONObject();
		if(!udao.isZhuCe(phone)) {
			//有 true
	        jsonObj.put("flag", "true");
		}else {
			//没有 false
			jsonObj.put("flag", "false");
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}


}
