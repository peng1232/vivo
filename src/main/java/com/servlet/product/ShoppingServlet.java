package com.servlet.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dao.CollectionDAO;
import com.dao.ProductDAO;
import com.dao.Shopping_CartDAO;
import com.entity.Product;
import com.entity.Shopping_cart;

@WebServlet("/jsp/qian/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Shopping_CartDAO sdao = new Shopping_CartDAO();
	ProductDAO pdao = new ProductDAO();
	CollectionDAO cdao = new CollectionDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer user_id = Integer.valueOf(request.getParameter("user_id"));
		List<Shopping_cart> shoppingAll = sdao.queryUser_Shopping(user_id);
		List<Product> list = new ArrayList<Product>();
		
		shoppingAll.forEach(e->{
			// 查询出对应的商品
			Product product = pdao.queryProduct(e.getProduct_id());

			JSONObject jsonObj = JSON.parseObject(e.getSku());
			int skuPrice = jsonObj.getIntValue("sku_price");
			int pageType = jsonObj.getIntValue("pageType");
			int color = jsonObj.getIntValue("color");
			// 颜色
			product.setPagTtype(cdao.specification_Value(pageType).getValue());
			product.setColor(cdao.specification_Value(color).getValue());
			product.setImage_url(pdao.queryImage_Url(pageType, color));
			product.setPrice(cdao.commodity_price(skuPrice).getPrice());
			
			list.add(product);
		});
		request.setAttribute("product", list);
		request.setAttribute("shopping", shoppingAll);
		request.getRequestDispatcher("shpping.jsp").forward(request, response);
	}

}
