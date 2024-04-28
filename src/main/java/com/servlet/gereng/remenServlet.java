package com.servlet.gereng;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OrdersDAO;
import com.dao.ProductDAO;
import com.dao.UserLoginTimeDAO;
import com.dao.plcommentsDAO;
import com.dao.wfkOrdersDAO;
import com.entity.Orders;
import com.entity.Product;
import com.entity.Users;

@WebServlet("/jsp/gereng/remenServlet")
public class remenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO pdao = new ProductDAO();
	UserLoginTimeDAO userLoginTimeDAO = new UserLoginTimeDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> product = pdao.productRecommend();
		List<Product> hits = pdao.productHits();
		List<BigDecimal> price = new ArrayList<BigDecimal>();
		Users u = (Users) request.getSession().getAttribute("user");
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		Timestamp lastLoginTime = userLoginTimeDAO.selectLastLoginTime(u.getId());
		// 打印日志以确认获取到的最近登录时间
		if (lastLoginTime != null) {
			System.out.println("获取到的最近登录时间：" + lastLoginTime.toString());
		} else {
			System.out.println("无法获取最近登录时间。");
		}
		
        // 创建 OrdersDAO 实例
        wfkOrdersDAO wfkordersDAO = new wfkOrdersDAO();
        // 获取未付款订单数量
        int unpaidOrdersCount = wfkordersDAO.getUnpaidOrdersCount(u.getId());
        // 将未付款订单数量存入 request 属性中
        request.setAttribute("unpaidOrdersCount", unpaidOrdersCount);
        
     // 创建 OrdersDAO 实例
        plcommentsDAO plcommentsDAO = new plcommentsDAO();
        // 获取未付款订单数量
        long unpaidcommentsCount = plcommentsDAO.getCommentsAndRepliesCount(u.getId());
        // 将未付款订单数量存入 request 属性中
        request.setAttribute("unpaidcommentsCount", unpaidcommentsCount);
        
        OrdersDAO ordersDAO = new OrdersDAO();
        
        List<Orders> Orders = ordersDAO.queryUserOrders(u.getId());
        if(Orders.size()>=5) {
        	 Orders = Orders.subList(0, 5);
        }
        Orders.forEach(e->{
        	price.add(ordersDAO.queryPrice(e.getOrder_number()));
        });
        
		request.setAttribute("lastLoginTime", sdf.format(lastLoginTime));
		request.setAttribute("product", product);
		request.setAttribute("Orders", Orders);
		request.setAttribute("hits", hits);
		request.setAttribute("price", price);
		request.getRequestDispatcher("grzx.jsp").forward(request, response);
	}

}
