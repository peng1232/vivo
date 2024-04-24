package com.servlet.hou;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDAO;
import com.dao.Product_SpecificationsDAO;
import com.entity.Category;
import com.entity.Product_specifications;

/**
 * Servlet implementation class CategoryInsertServlet
 */
@WebServlet("/jsp/hou/SpecificationsUpdateServlet")
public class SpecificationsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Product_SpecificationsDAO cdao = new Product_SpecificationsDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer product_id = Integer.valueOf(request.getParameter("type"));
		String specifications = request.getParameter("name");
		Product_specifications s = new Product_specifications(id, product_id, specifications);
		cdao.updateProduct_Specifications(s);
		request.getRequestDispatcher("specifications.jsp").forward(request, response);
	}

}
