package com.servlet.background.backgrounduser;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.userDAO;
import com.entity.Users;
/**
 * Servlet implementation class AdministratorServlet
 */
@WebServlet("/jsp/background/userselectAllServlet")
public class UserselectAllServlet extends HttpServlet {
	private  static final long serialVersionUID = 1L;
	userDAO admin =new userDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Users> list=admin.selectAlluse();
		request.setAttribute("list", list);
		request.getRequestDispatcher("users.jsp").forward(request, response);
	}
	
	
}
