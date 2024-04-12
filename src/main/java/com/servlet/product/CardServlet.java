package com.servlet.product;

import java.io.IOException;

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

/**
 * Servlet implementation class CardServlet
 */
@WebServlet("/jsp/qian/CardServlet")
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Shopping_CartDAO sdao = new Shopping_CartDAO();
	ProductDAO pdao = new ProductDAO();
	CollectionDAO cdao = new CollectionDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer shopping_id = Integer.valueOf(request.getParameter("shopping_id"));
		//根据购物车查询商品信息
		Shopping_cart shopping = sdao.queryShopping(shopping_id);
		//查询出对应的商品
		Product product = pdao.queryProduct(shopping.getProduct_id());
		
		JSONObject jsonObj = JSON.parseObject(shopping.getSku());
		int pageType = jsonObj.getIntValue("pageType");
		int color = jsonObj.getIntValue("color");
		//颜色
		product.setPagTtype(cdao.specification_Value(pageType).getValue());
		product.setColor(cdao.specification_Value(color).getValue());
		product.setImage_url(pdao.queryImage_Url(pageType,color));

		request.setAttribute("shopping", shopping);
		request.setAttribute("product", product);
		request.getRequestDispatcher("cartAddSuccess.jsp").forward(request, response);
	}


}
