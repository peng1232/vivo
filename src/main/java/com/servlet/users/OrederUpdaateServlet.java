package com.servlet.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.OrdersDAO;

/**
 * Servlet implementation class OrederDeleteServlet
 */
@WebServlet("/jsp/user/OrederUpdaateServlet")
public class OrederUpdaateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    OrdersDAO odao = new OrdersDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String number = request.getParameter("number");
		Integer state = Integer.valueOf(request.getParameter("state"));
		odao.updateOrder(number, state);
		
		JSONObject jsonObj = new JSONObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}


}
