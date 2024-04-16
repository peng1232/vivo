package com.servlet.background;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdministratorDAO;
import com.entity.Administrator;

/**
 * Servlet implementation class AdministratorServlet
 */
@WebServlet("/AdministratorServlet")
public class glyselectAllServlet extends HttpServlet {
	private  static final long serialVersionUID = 1L;
	AdministratorDAO admin =new AdministratorDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Administrator> list=admin.selectAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("AdministratorServlet").forward(request, response);
	}
	
	
}
