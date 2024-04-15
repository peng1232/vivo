package com.servlet.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.Shopping_CartDAO;

/**
 * Servlet implementation class ShoppingUpdateNumberServlet
 */
@WebServlet("/jsp/qian/ShoppingUpdateNumberServlet")
public class ShoppingUpdateNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Shopping_CartDAO sdao = new Shopping_CartDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer shopping_id = Integer.valueOf(request.getParameter("shopping_id").trim());
		Integer sum = Integer.valueOf(request.getParameter("sum").trim());
		Integer user_id = Integer.valueOf(request.getParameter("user_id").trim());
		Integer zhi = sdao.updateShoppingNumber(user_id, shopping_id, sum);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("zhi", zhi);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}

}
