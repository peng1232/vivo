package com.servlet.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.CollectionDAO;

/**
 * Servlet implementation class IsShouServlet
 */
@WebServlet("/jsp/qian/IsShouServlet")
public class IsShouServlet extends HttpServlet {
	CollectionDAO cdao = new CollectionDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer user_id = Integer.valueOf(request.getParameter("user_id").trim());
		Integer product_id = Integer.valueOf(request.getParameter("product_id"));
		String sku = request.getParameter("sku");
		Boolean collection = cdao.isCollection(user_id, product_id, sku);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("collection", collection);
		System.err.println(jsonObj.toString());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}

}
