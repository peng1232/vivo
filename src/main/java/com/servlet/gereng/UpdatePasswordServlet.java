package com.servlet.gereng;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UsersDAO;

/**
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet("/jsp/gereng/UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
	UsersDAO r = new UsersDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.valueOf(req.getParameter("user_id"));
		String pass = req.getParameter("password");
		r.doUpdatePassword(id, pass);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
	}

}
