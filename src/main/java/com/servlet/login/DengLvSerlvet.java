package com.servlet.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UsersDAO;
import com.entity.Users;

/**
 * Servlet implementation class DengLvSerlvet
 */
@WebServlet("/jsp/login/DengLvSerlvet")
public class DengLvSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersDAO udao = new UsersDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		if(!udao.isZhuCe(phone)) {
			//有
			if(password==null) {
				//手机验证码登录
				
			}else {
				//账号密码登录
				Users user = udao.dengLv(phone, password);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				System.out.println(user);
			}
		}else {
			//没有
			request.setAttribute("phone", phone);
			request.setAttribute("flag", true);
			request.setAttribute("password", password);
			request.getRequestDispatcher("zhuce.jsp").forward(request, response);
		}
	}


}
