package com.servlet.hou;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Product_SpecificationsDAO;
import com.entity.Product_specifications;

/**
 * Servlet implementation class CategoryInsertServlet
 */
@WebServlet("/jsp/hou/SpecificationsInsertServlet")
public class SpecificationsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Product_SpecificationsDAO pdao = new Product_SpecificationsDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer product_id = Integer.valueOf(request.getParameter("name"));
		String specifications = request.getParameter("specifications");
		Product_specifications s = new Product_specifications(null, product_id, specifications);
		pdao.insertProduct_Specifications(s);
		request.getRequestDispatcher("specifications.jsp").forward(request, response);
	}

}
