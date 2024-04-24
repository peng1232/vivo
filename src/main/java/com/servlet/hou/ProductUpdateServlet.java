package com.servlet.hou;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDAO;
import com.entity.Product;

/**
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/jsp/hou/ProductUpdateServlet")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductDAO pdao = new ProductDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		Integer type = Integer.valueOf(request.getParameter("type"));
		String miao = request.getParameter("miao");
		Integer limit = Integer.valueOf(request.getParameter("limit"));
		Integer state = Integer.valueOf(request.getParameter("state"));
		Product p = new Product();
		p.setId(id);
		p.setProducts_name(name);
		p.setCategory_id(type);
		p.setDescription(miao);
		p.setPurchase_limit(limit);
		p.setState(state);
		pdao.updateProduct(p);
		request.getRequestDispatcher("productguanli.jsp").forward(request, response);
	}

}
