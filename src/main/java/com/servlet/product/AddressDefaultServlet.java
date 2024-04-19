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
import com.dao.AddressDAO;
import com.entity.Address;
import com.entity.Shopping_cart;

/**
 * Servlet implementation class ShoppingInsertServlet
 */
@WebServlet("/jsp/qian/AddressDefaultServlet")
public class AddressDefaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddressDAO adao = new AddressDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer address_id = Integer.valueOf(request.getParameter("address_id"));
		//设置默认
		adao.updateDefault(null, 2);
		adao.updateDefault(address_id,1);

		
		JSONObject jsonObj = new JSONObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}

}
