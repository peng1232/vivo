package com.servlet.init;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson2.JSONObject;
import com.dao.CategoryDAO;
import com.dao.ProductDAO;
import com.dao.Shopping_CartDAO;
import com.entity.Category;
import com.entity.Product;


/**
* @Description: 
* @author: 铭
* @date 2024年4月2日 上午9:47:49
*/

@WebServlet("/jsp/navSerlvet2")
public class NavProInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Shopping_CartDAO sdao=  new Shopping_CartDAO();
	CategoryDAO cdao = new CategoryDAO();
	ProductDAO pdao = new ProductDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		JSONObject jsonObj = new JSONObject();
		List<Category> list_cate = cdao.selectAll();
		List<List<Product>> list = new ArrayList<List<Product>>();

		//根据类别id查询出对应的商品
		list_cate.forEach(e->{
			list.add( pdao.type_Product(e.getId(), 0, 6)) ;
		});
		System.out.println(list);
		jsonObj.put("product", list);
		jsonObj.put("list_cate", list_cate);

		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}


}