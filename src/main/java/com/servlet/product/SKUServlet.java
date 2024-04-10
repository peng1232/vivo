package com.servlet.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.dao.ProductDAO;
import com.entity.Commodity_price;

@WebServlet("/jsp/qian/SKUServlet")
public class SKUServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO pdao = new ProductDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取传递过来的JSON字符串
		String jsonData = request.getParameter("data");
		Integer proid = Integer.valueOf(request.getParameter("proid"));
		// 使用fastjson2的parseArray方法将JSON字符串转换为JSONArray对象
		JSONArray jsonArray = JSONArray.parseArray(jsonData);

		// 遍历JSONArray对象并打印每个元素
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < jsonArray.size(); i++) {
			// 如果需要将字符串转换为数字，可以使用以下代码
			int number = Integer.parseInt(jsonArray.getString(i));
			list.add(number);
		}
		Commodity_price price = pdao.queryPrice(list);
		
		//读取图片
		List<String> url_image = pdao.queryUrl_image(proid,list.get(list.size()-1) );
		
		JSONObject jsonObj = new JSONObject();
		//存价格
		jsonObj.put("price", price);
		jsonObj.put("url_image", url_image);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}

}
