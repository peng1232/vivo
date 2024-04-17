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
@WebServlet("/jsp/qian/AddressInsertServlet")
public class AddressInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddressDAO adao = new AddressDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer user_id = Integer.valueOf(request.getParameter("user_id"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String shou = request.getParameter("shou");
		String xianxi = request.getParameter("xianxi");
		String mou = request.getParameter("mou");
		boolean b = Boolean.valueOf(mou);
		Integer defaultadd = b?1:2; 
		Address a = new Address(null, user_id, name, phone, shou, 2, xianxi, 1);
		Integer address_id = adao.addAddress(a);
		if(b) {
			//设置默认
			adao.updateDefault(null, 2);
			adao.updateDefault(address_id,1);
		}
		
		
		
		JSONObject jsonObj = new JSONObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}

}
