package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qita.yzm;

/**
 * Servlet implementation class yzmServler
 */
@WebServlet("/jsp/login/yzmServler")
public class yzmServler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		yzm.message(phone);
	}

}
