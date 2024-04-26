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
import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONObject;
import com.dao.ProductDAO;
import com.dao.Shopping_CartDAO;
import com.dao.User_Product_FootprintDAO;
import com.entity.Product;
import com.entity.Product_specifications;
import com.entity.Shopping_cart;
import com.entity.Specification_value;
import com.entity.Users;

/**
 * Servlet implementation class XianXiSerlvet
 */
@WebServlet("/jsp/qian/XianXiSerlvet")
public class XianXiSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO pdao = new ProductDAO();
	Shopping_CartDAO sdao = new Shopping_CartDAO();
	User_Product_FootprintDAO ypfdao = new User_Product_FootprintDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 查询出商品信息
		Integer id = Integer.valueOf(request.getParameter("id"));
		Product product = pdao.queryProduct(id);
		// 查询对用的规格，与规格值
		List<Product_specifications> Specifications = pdao.querySpecifications(id);
		List<List<Specification_value>> value = new ArrayList<List<Specification_value>>();
		Specifications.forEach(e -> {
			value.add(pdao.queryValue(e.getId()));
		});
		// 添加商品浏览记录
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if (user != null) {
			ypfdao.InsertFootprint(user.getId(), id);
		}

		// 添加商品的点击量
		pdao.queryHits(id);

		// 查询该商品的收藏数
		Long queryCollection = pdao.queryCollection(id);

		String sgid = request.getParameter("shoppingId");
		if (sgid != null && sgid.trim().length() > 0) {
			Integer shoppingId = Integer.valueOf(sgid);
			Shopping_cart queryShopping = sdao.queryShopping(shoppingId);
			String sku = queryShopping.getSku();
			JSONObject jsonObj = JSON.parseObject(sku);
			int skuPrice = jsonObj.getIntValue("sku_price");
			int pageType = jsonObj.getIntValue("pageType");
			int color = jsonObj.getIntValue("color");
			int number = jsonObj.getIntValue("number");
			request.setAttribute("skuPrice", skuPrice);
			request.setAttribute("pageType", pageType);
			request.setAttribute("color", color);
			// request.setAttribute("number", number);
			request.setAttribute("number", queryShopping.getQuantity());
			request.setAttribute("flag", true);
		}
		
		
		String ssku = request.getParameter("sku");
		if (ssku != null && ssku.trim().length() > 0) {
		    // 去除多余的单引号和可能的非打印字符
		    ssku = ssku.trim().replaceAll("['\\x00-\\x1F\\x7F]+", "");  // 正则移除所有控制字符
		    ssku = ssku.replaceAll("[\\\\]", "");
		    ssku = ssku.substring(1,ssku.length()-1);
		    try {
		        JSONObject jsonObj = JSON.parseObject(ssku);
		        int skuPrice = jsonObj.getIntValue("sku_price");
		        int pageType = jsonObj.getIntValue("pageType");
		        int color = jsonObj.getIntValue("color");
		        int number = jsonObj.getIntValue("number");
		        request.setAttribute("skuPrice", skuPrice);
		        request.setAttribute("pageType", pageType);
		        request.setAttribute("color", color);
		        request.setAttribute("number", number);
		        request.setAttribute("flag", true);
		    } catch (JSONException e) {
		        e.printStackTrace();  // 打印完整的异常信息以便进一步分析
		        request.setAttribute("flag", false);
		    }
		}
		String sssku = request.getParameter("ssku");
		if (sssku != null && sssku.trim().length() > 0) {
			
		    try {
		        JSONObject jsonObj = JSON.parseObject(sssku);
		        int skuPrice = jsonObj.getIntValue("sku_price");
		        int pageType = jsonObj.getIntValue("pageType");
		        int color = jsonObj.getIntValue("color");
		        int number = jsonObj.getIntValue("number");
		        request.setAttribute("skuPrice", skuPrice);
		        request.setAttribute("pageType", pageType);
		        request.setAttribute("color", color);
		        request.setAttribute("number", number);
		        request.setAttribute("flag", true);
		    } catch (JSONException e) {
		        e.printStackTrace();  // 打印完整的异常信息以便进一步分析
		        request.setAttribute("flag", false);
		    }
		}
		
		
		request.setAttribute("product", product);
		request.setAttribute("Specifications", Specifications);
		request.setAttribute("value", value);
		request.setAttribute("queryCollection", queryCollection);
		request.getRequestDispatcher("xianxi.jsp").forward(request, response);
	}

}
