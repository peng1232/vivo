package com.servlet.product;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dao.Shopping_CartDAO;
import com.entity.Shopping_cart;

/**
 * Servlet implementation class ShoppingInsertServlet
 */
@WebServlet("/jsp/qian/ShoppingInsertServlet")
public class ShoppingInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Shopping_CartDAO sdao = new Shopping_CartDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sku = request.getParameter("sku");
		Integer user_id = Integer.valueOf(request.getParameter("user_id"));
		Integer product_id = Integer.valueOf(request.getParameter("product_id"));
		JSONObject jsonObj = JSON.parseObject(sku);
		int number = jsonObj.getIntValue("number");
		Shopping_cart s = new Shopping_cart(null, user_id, product_id, number, new Timestamp(new Date().getTime()), null, sku);
		Integer shoppingid = sdao.insertShopping(s);
		jsonObj.put("shoppingid", shoppingid);
		Integer shopping_Count = sdao.shopping_Count(user_id);
		jsonObj.put("shopping_count", shopping_Count);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}

}
