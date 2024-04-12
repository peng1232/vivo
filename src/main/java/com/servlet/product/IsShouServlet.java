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
		String zhi = request.getParameter("user_id");
		if(zhi!=null&&zhi.length()>0&&zhi!=" ") {
			Integer user_id = Integer.valueOf(zhi.trim());
			Integer product_id = Integer.valueOf(request.getParameter("product_id"));
			String sku = request.getParameter("sku");
			Boolean collection = cdao.isCollection(user_id, product_id, sku);
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("collection", collection);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(jsonObj.toJSONString());
		}
		
	}

}
