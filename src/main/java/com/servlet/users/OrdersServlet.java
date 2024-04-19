package com.servlet.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OrdersDAO;
import com.entity.Orders;
import com.entity.Product;

/**
 * Servlet implementation class ordersServlet
 */
@WebServlet("/jsp/user/ordersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrdersDAO orders = new OrdersDAO ();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Orders> ordersList =orders.queryUserOrders(1);
		
		
		
		
		System.out.println(ordersList);
		
		
		
		
		
		request.setAttribute("ordersList", ordersList);
		request.getRequestDispatcher("dingdang.jsp").forward(request, response);
	}



}
