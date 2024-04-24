package com.servlet.hou;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDAO;
import com.dao.ProductDAO;
import com.entity.Product;

/**
 * Servlet implementation class CategoryInsertServlet
 */
@WebServlet("/jsp/hou/ProductInsertServlet")
public class ProductInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO pdao = new ProductDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		Integer type = Integer.valueOf(request.getParameter("type"));
		String miao = request.getParameter("miao");
		Integer limit = Integer.valueOf(request.getParameter("limit"));
		Product p = new Product();
		p.setProducts_name(name);
		p.setCategory_id(type);
		p.setDescription(miao);
		p.setPurchase_limit(limit);
		p.setListing_time(new Timestamp(new Date().getTime()));
		pdao.insertProduct(p);
		
		
		request.getRequestDispatcher("productguanli.jsp").forward(request, response);
	}

}
