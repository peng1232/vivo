package com.servlet.login;

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

/**
 * Servlet implementation class DengLvSerlvet
 */
@WebServlet("/jsp/login/DengLvSerlvet")
public class DengLvSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersDAO udao = new UsersDAO();
	User_Login_TimeDAO tdao = new User_Login_TimeDAO();
	Shopping_CartDAO sdao=  new Shopping_CartDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		JSONObject jsonObj = new JSONObject();
		Users user =null;
		if(password==null) {
			//手机验证码登录
			user = udao.dengLv(phone);
		}else {
			//账号密码登录
			user = udao.dengLv(phone, password);
		}
		//判断是否登录成功
		if(user!=null) {
			HttpSession session = request.getSession();
			//添加用户登录时间表
			tdao.insertUserTime(user.getId());
			//查询用户的购物车数量

			session.setAttribute("user", user);
			jsonObj.put("flag", "true");
		}else {
			jsonObj.put("flag", "false");
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}


}
