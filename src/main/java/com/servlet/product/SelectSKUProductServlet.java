package com.servlet.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.dao.CollectionDAO;
import com.dao.ProductDAO;
import com.dao.Shopping_CartDAO;
import com.entity.Product;

@WebServlet("/jsp/qian/SelectSKUProductServlet")
public class SelectSKUProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Shopping_CartDAO sdao = new Shopping_CartDAO();
	ProductDAO pdao = new ProductDAO();
	CollectionDAO cdao = new CollectionDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("user_id");
		String productId = request.getParameter("product_id");
		String jsonStr = request.getParameter("sku");
		String shopping_id = request.getParameter("shopping_id");
		JSONArray jsonArray = JSONArray.parseArray(jsonStr);
		JSONArray jsonArray2 = JSONArray.parseArray(productId);
		JSONArray jsonArray3 =null;
		if(shopping_id!=null&&shopping_id.length()>0) {
			jsonArray3 = JSONArray.parseArray(shopping_id);
		}
		List<Product> list = new ArrayList<Product>();
		List<Integer> num = new ArrayList<Integer>();
		List<String> skulist = new ArrayList<String>();
		List<Integer> shoppinglist = new ArrayList<Integer>();
		// 遍历JSONArray对象并打印每个元素
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObj = JSON.parseObject(jsonArray.getString(i));
			JSONObject jsonObj2 = JSON.parseObject(jsonArray2.getString(i));
			if(jsonArray3!=null) {
				JSONObject jsonObj3 = JSON.parseObject(jsonArray3.getString(i));
				shoppinglist.add(jsonObj3.getIntValue("shopping"));
			}
			
			skulist.add(jsonArray.getString(i));
			int skuPrice = jsonObj.getIntValue("sku_price");
			int pageType = jsonObj.getIntValue("pageType");
			int color = jsonObj.getIntValue("color");
			int number = jsonObj.getIntValue("number");
			// 查询出对应的商品
			Product product = pdao.queryProduct(Integer.valueOf(jsonObj2.getIntValue("product_id")));
			num.add(number);
			// 颜色
			product.setPagTtype(cdao.specification_Value(pageType).getValue());
			product.setColor(cdao.specification_Value(color).getValue());
			product.setImage_url(pdao.queryImage_Url(pageType, color));
			product.setPrice(cdao.commodity_price(skuPrice).getPrice());

			list.add(product);
		}
		HttpSession session = request.getSession();
		session.setAttribute("shoppinglist", shoppinglist);
		request.setAttribute("product", list);
		request.setAttribute("number", num);
		request.setAttribute("skulist", skulist);
		request.getRequestDispatcher("quick.jsp").forward(request, response);
	}

}
