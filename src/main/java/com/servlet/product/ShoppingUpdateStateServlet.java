package com.servlet.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.dao.Shopping_CartDAO;

/**
 * Servlet implementation class ShoppingUpdateNumberServlet
 */
@WebServlet("/jsp/qian/ShoppingUpdateStateServlet")
public class ShoppingUpdateStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Shopping_CartDAO sdao = new Shopping_CartDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsonStr = request.getParameter("shopping_id");

		// 使用fastjson2的parseArray方法将JSON字符串转换为JSONArray对象
		JSONArray jsonArray = JSONArray.parseArray(jsonStr);

		// 遍历JSONArray对象并打印每个元素
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < jsonArray.size(); i++) {
			// 如果需要将字符串转换为数字，可以使用以下代码
			int number = Integer.parseInt(jsonArray.getString(i));
			list.add(number);
		}

		Integer state = Integer.valueOf(request.getParameter("state").trim());
		Integer user_id = Integer.valueOf(request.getParameter("user_id").trim());

		Integer zhi = sdao.updateShoppingState(user_id, list, state);

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("zhi", zhi);
		Integer shopping_Count = sdao.shopping_Count(user_id);
		jsonObj.put("shopping_count", shopping_Count);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());

	}

}
