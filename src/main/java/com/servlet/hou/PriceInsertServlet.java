package com.servlet.hou;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Commodity_PriceDAO;
import com.entity.Commodity_price;

/**
 * Servlet implementation class CategoryInsertServlet
 */
@WebServlet("/jsp/hou/PriceInsertServlet")
public class PriceInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Commodity_PriceDAO cdao = new Commodity_PriceDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer product_id = Integer.valueOf(request.getParameter("name"));
		BigDecimal price = new BigDecimal(request.getParameter("price")).setScale(2, RoundingMode.HALF_UP);;
		Integer is = Integer.valueOf(request.getParameter("is").trim());
		Commodity_price s = new Commodity_price(null,price,product_id,is);
		cdao.insertPrice(s);
		request.getRequestDispatcher("priceguanli.jsp").forward(request, response);
	}

}
