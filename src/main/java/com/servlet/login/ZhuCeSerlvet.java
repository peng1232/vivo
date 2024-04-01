package com.servlet.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UsersDAO;

/**
 * Servlet implementation class ZhuCeSerlvet
 */
@WebServlet("/jsp/login/ZhuCeSerlvet")
public class ZhuCeSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersDAO udao = new UsersDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String yzm = request.getParameter("yzm");
		String password = request.getParameter("password");
		if(udao.isZhuCe(phone)) {
			//注册
			udao.zhuCe(phone, password);
			response.sendRedirect("login.jsp");
		}else {
			//跳转回去，说改手机已注册
			request.setAttribute("phone", phone);
			request.setAttribute("flag", true);
			request.setAttribute("password", password);
			request.getRequestDispatcher("zhuce.jsp").forward(request, response);
		}
	}

}
