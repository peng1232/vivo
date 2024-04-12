package com.servlet.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.CollectionDAO;
import com.dao.Shopping_CartDAO;

/**
 * Servlet implementation class IsShouServlet
 */
@WebServlet("/jsp/qian/IsShopping")
public class IsShopping extends HttpServlet {
	Shopping_CartDAO sdao = new Shopping_CartDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String zhi = request.getParameter("user_id");
		if(zhi!=null&&zhi.length()>0&&zhi!=" ") {
			Integer user_id = Integer.valueOf(zhi.trim());
			Integer product_id = Integer.valueOf(request.getParameter("product_id"));
			String sku = request.getParameter("sku");
			Boolean Shopp = sdao.isShopping(user_id, product_id);
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("Shopp", Shopp);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(jsonObj.toJSONString());
		}
		
	}

}
