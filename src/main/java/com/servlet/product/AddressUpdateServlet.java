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
@WebServlet("/jsp/qian/AddressUpdateServlet")
public class AddressUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddressDAO adao = new AddressDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer address_id = Integer.valueOf(request.getParameter("address_id"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String shou = request.getParameter("shou");
		String xianxi = request.getParameter("xianxi");
		String mou = request.getParameter("mou");
		boolean b = Boolean.valueOf(mou);
		
		Address a = new Address(address_id, null, name, phone, shou, 2, xianxi, 1);
		adao.UpdateAddress(a);
		adao.updateDefault(null, 2);
		if(b) {
			//设置默认
			adao.updateDefault(address_id,1);
		}
		
		
		
		JSONObject jsonObj = new JSONObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}

}
