package com.servlet.init;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDAO;
import com.entity.Product;

/**
 * Servlet implementation class ProductInitServlet
 */
@WebServlet("/jsp/qian/ProductInitServlet")
public class ProductInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO pdao = new ProductDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> product = pdao.productRecommend();
		List<Product> hits = pdao.productHits();
		request.setAttribute("product", product);
		request.setAttribute("hits", hits);
		request.getRequestDispatcher("shouye.jsp").forward(request, response);
	}


}
