package com.servlet.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dao.CollectionDAO;
import com.dao.OrdersDAO;
import com.dao.ProductDAO;
import com.entity.Order_details;
import com.entity.Orders;
import com.entity.Product;

/**
 * Servlet implementation class ordersServlet
 */
@WebServlet("/jsp/user/ordersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrdersDAO orders = new OrdersDAO();
    private ProductDAO pdao = new ProductDAO ();
    private CollectionDAO cdao = new CollectionDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer user_id = Integer.valueOf(request.getParameter("user_id"));
		List<Orders> ordersList =orders.queryUserOrders(user_id);
		List<List<Order_details>> details = new ArrayList<List<Order_details>>();
		List<List<Product> > product = new ArrayList<List<Product>>();
		ordersList.forEach(e->{
			details.add(orders.queryUser_order_details(e.getOrder_number()));
			
		});
		details.forEach(e->{
			List<Product> Product =new ArrayList<Product>();
			e.forEach(q->{
				JSONObject jsonObj = JSON.parseObject(q.getSku());
				int skuPrice = jsonObj.getIntValue("sku_price");
				int pageType = jsonObj.getIntValue("pageType");
				int color = jsonObj.getIntValue("color");
				// 查询出对应的商品
				Product p = pdao.queryProduct(q.getProduct_id());
				// 颜色
				p.setPagTtype(cdao.specification_Value(pageType).getValue());
				p.setColor(cdao.specification_Value(color).getValue());
				p.setImage_url(pdao.queryImage_Url(pageType, color));
				p.setPrice(cdao.commodity_price(skuPrice).getPrice());
				p.setHits(Long.valueOf(q.getProduct_quantity()));
				Product.add(p);
				
			});
			product.add(Product);
		});
		request.setAttribute("ordersList", ordersList);
		request.setAttribute("details", details);
		request.setAttribute("product", product);
		request.getRequestDispatcher("dindan.jsp").forward(request, response);
	}



}