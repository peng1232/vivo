package com.servlet.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dao.CollectionDAO;
import com.entity.Collection;
import com.entity.Commodity_price;
import com.entity.Product;
import com.entity.Specification_value;

/**
 * Servlet implementation class CollectionInitServlet
 */
@WebServlet("/jsp/user/CollectionInitServlet")
public class CollectionInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CollectionDAO cdao = new CollectionDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer user_id = Integer.valueOf(request.getParameter("user_id"));
		List<Collection> queryUser_Collections = cdao.queryUser_Collections(user_id);
		queryUser_Collections.forEach(e->{
			Integer product_id = e.getProduct_id();
			JSONObject jsonObj = JSON.parseObject(e.getSku());
			int skuPrice = jsonObj.getIntValue("sku_price");
			int pageType = jsonObj.getIntValue("pageType");
			int color = jsonObj.getIntValue("color");
			
			Product queryUser_Product = cdao.queryUser_Product(product_id);
			//System.err.println(queryUser_Product.getProducts_name());

			Specification_value pageType_specifications =cdao.specification_Value(pageType);
			Specification_value color_specifications2 =cdao.specification_Value(color);
			//System.err.println(pageType_specifications.getValue());

			//System.err.println(color_specifications2.getValue());
			//System.err.println(queryUser_Product.getProducts_name());
			
			Commodity_price commodity_price = cdao.commodity_price(skuPrice);
			//System.err.println(commodity_price.getPrice());
			
			
		});
		
		
	}

}
