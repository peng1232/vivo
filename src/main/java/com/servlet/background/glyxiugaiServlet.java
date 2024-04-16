package com.servlet.background;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdministratorDAO;

@WebServlet("/glyxiugaiServlet")
public class glyxiugaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdministratorDAO admin = new AdministratorDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("id");
		request.getParameter("password");
		
	}

}
