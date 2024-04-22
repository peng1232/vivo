package com.servlet.gereng;

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

@WebServlet("/jsp/gereng/phoneServlet")
public class phoneServlet extends HttpServlet {
	UsersDAO r = new UsersDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(req.getParameter("user_id"));
		String phones = req.getParameter("phones");
		Integer doUpdatePhone = r.doUpdatePhone(id, phones);
		if(doUpdatePhone>0) {
			HttpSession session = req.getSession();
			Users user = (Users) session.getAttribute("user");
			user.setPhone(phones);
			session.setAttribute("user", user);
		}
		JSONObject jsonObj = new JSONObject();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println(jsonObj.toJSONString());
	}

}
