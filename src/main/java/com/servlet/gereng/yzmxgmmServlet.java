package com.servlet.gereng;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UsersDAO;
import com.entity.Users;


@WebServlet("/jsp/gereng/yzmxgmmServlet")
public class yzmxgmmServlet extends HttpServlet {
	UsersDAO r = new UsersDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(req.getParameter("user_id"));
		String pass = req.getParameter("password");
		String phones = req.getParameter("phones");
		Integer doUpdatePassword = r.doUpdatePassword(id, pass);
		if(doUpdatePassword>0) {
			HttpSession session = req.getSession();
			Users user = (Users) session.getAttribute("user");
			user.setUser_password(pass);
			session.setAttribute("user", user);
		}
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
	}

}
