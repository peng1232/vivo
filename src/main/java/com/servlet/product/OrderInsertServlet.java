package com.servlet.product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.dao.OrdersDAO;
import com.dao.Shopping_CartDAO;
import com.entity.Order_details;
import com.entity.Orders;
import com.entity.Product;

@WebServlet("/jsp/qian/OrderInsertServlet")
public class OrderInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	OrdersDAO odao = new OrdersDAO();
	Shopping_CartDAO sdao = new Shopping_CartDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer user_id = Integer.valueOf(request.getParameter("user_id"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String details = request.getParameter("details");
		Orders o = new Orders(null, null, user_id, name, phone, address, null, null);
		String oid = odao.insertOrder(o);
		JSONArray jsonArray = JSONArray.parseArray(details);
		// 遍历JSONArray对象并打印每个元素
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObj = JSON.parseObject(jsonArray.getString(i));
			int number = jsonObj.getIntValue("number");
			int product_id = jsonObj.getIntValue("product_id");
			String sku = jsonObj.getString("sku");
			int total = jsonObj.getIntValue("total");
			Order_details od = new Order_details(null, oid, product_id, number, new BigDecimal(total), sku);
			odao.insertOrderDetails(od);
		}
		HttpSession session = request.getSession();
		List<Integer> shoppinglist = (List<Integer>) session.getAttribute("shoppinglist");
		if(shoppinglist!=null&&shoppinglist.size()>0) {
			sdao.deleteShopping(shoppinglist);
			session.setAttribute("shoppinglist", "");
		}
		
		
		JSONObject jsonObj = new JSONObject();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}

}
