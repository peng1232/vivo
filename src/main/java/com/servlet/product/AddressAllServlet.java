package com.servlet.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.AddressDAO;
import com.entity.Address;

/**
 * Servlet implementation class AddressAllServlet
 */
@WebServlet("/jsp/qian/AddressAllServlet")
public class AddressAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	AddressDAO adao = new AddressDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer user_id = Integer.valueOf(request.getParameter("user_id"));
		List<Address> queryAddress = adao.queryAddress(user_id);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("Address", queryAddress);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}


}
