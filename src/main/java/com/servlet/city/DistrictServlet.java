package com.servlet.city;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CityDAO;


@WebServlet("/jsp/district")
public class DistrictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CityDAO c = new CityDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
