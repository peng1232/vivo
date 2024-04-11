package com.servlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.CollectionDAO;
import com.dao.ProductDAO;

/**
 * Servlet implementation class CollectionServlet
 */
@WebServlet("/jsp/qian/CollectionServlet")
public class CollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CollectionDAO cdao = new CollectionDAO();
	ProductDAO pdao = new ProductDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer user_id = Integer.valueOf(request.getParameter("user_id").trim());
		Integer product_id = Integer.valueOf(request.getParameter("product_id"));
		String flag = request.getParameter("flag");
		String sku = request.getParameter("sku");
		if(flag.equals("true")) {
			System.out.println("ok");
			cdao.insertCollection(user_id, product_id, sku);
		}else {
			System.out.println("no");
			cdao.deleteCollection(user_id, product_id);
		}
		
		//查询商品收藏数
		Long queryCollection = pdao.queryCollection(product_id);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("queryCollection", queryCollection);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}


}
