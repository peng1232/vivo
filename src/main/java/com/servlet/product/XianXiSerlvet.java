package com.servlet.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDAO;
import com.entity.Product;

/**
 * Servlet implementation class XianXiSerlvet
 */
@WebServlet("/jsp/qian/XianXiSerlvet")
public class XianXiSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO pdao = new ProductDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询出商品信息
		Integer id = Integer.valueOf(request.getParameter("id"));
		Product product = pdao.queryProduct(id);
		
		//添加商品浏览记录
		
		//添加商品的点击量
		
		request.setAttribute("product", product);;
		request.getRequestDispatcher("xianxi.jsp").forward(request, response);
	}


}
