package com.servlet.hou;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.Price_CombinationDAO;
import com.dao.ProductDAO;
import com.dao.Product_SpecificationsDAO;
import com.dao.Specification_valueDAO;
import com.entity.Price_combination;
import com.entity.Product_specifications;
import com.entity.Specification_value;

/**
 * Servlet implementation class CombinationSelectServlet
 */
@WebServlet("/jsp/hou/CombinationInsertServlet")
public class CombinationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Price_CombinationDAO pdao =new Price_CombinationDAO();
    ProductDAO prodao = new ProductDAO();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer price_id= Integer.valueOf(request.getParameter("price_id"));
		Integer value_id= Integer.valueOf(request.getParameter("value_id"));
		Price_combination p = new Price_combination(null, price_id, value_id);
		pdao.insert_Price_Combination(p);
		
		
		JSONObject jsonObj = new JSONObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}

}
