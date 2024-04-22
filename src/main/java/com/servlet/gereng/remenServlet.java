package com.servlet.gereng;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDAO;
import com.entity.Product;
@WebServlet("/jsp/gereng/remenServlet")
public class remenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO pdao = new ProductDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> product = pdao.productRecommend();
		List<Product> hits = pdao.productHits();
		request.setAttribute("product", product);
		request.setAttribute("hits", hits);
		request.getRequestDispatcher("grzx.jsp").forward(request, response);
	}


}
