package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdministratorDAO;
import com.entity.Administrator;
@WebServlet(urlPatterns = "/jsp/background/AdministratorSer")
public class AdministratorServlet extends HttpServlet {
	private AdministratorDAO administratorDAO = new AdministratorDAO();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		List<Administrator> list =administratorDAO.queryAll();
		request.setAttribute("list",list);
		try {
			request.getRequestDispatcher("guanliyuandenglu").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
