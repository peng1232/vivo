package com.servlet.hou;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.Price_CombinationDAO;
import com.dao.ProductDAO;
import com.dao.Product_SpecificationsDAO;
import com.dao.Specification_valueDAO;
import com.entity.Price_combination;
import com.entity.Product_specifications;
import com.entity.Specification_value;

/**
 * Servlet implementation class CombinationSelectServlet
 */
@WebServlet("/jsp/hou/CombinationSelectServlet")
public class CombinationSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Price_CombinationDAO pdao =new Price_CombinationDAO();
    Specification_valueDAO sdao = new Specification_valueDAO();
    Product_SpecificationsDAO psdao = new Product_SpecificationsDAO();
    ProductDAO prodao = new ProductDAO();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer price_id= Integer.valueOf(request.getParameter("price_id"));
		Integer product_id= Integer.valueOf(request.getParameter("product_id"));

		
		List<Price_combination> selectAll = pdao.selectAllCombiatoin(price_id);
		List<Specification_value> va = new ArrayList<Specification_value>();
		List<Product_specifications> ps = new ArrayList<Product_specifications>();
		for(Integer i=0;i<selectAll.size();i++) {
			va.add(sdao.selectValue_id(selectAll.get(i).getValue_id()));
			ps.add(psdao.selectProduct_specifications_id(va.get(i).getSpecifications_id()));
		}
		//拿到该商品所有的规格值
		List<Product_specifications> Specifications = prodao.querySpecifications(product_id);
		List<List<Specification_value>> value = new ArrayList<List<Specification_value>>();
		Specifications.forEach(e -> {
			value.add(prodao.queryValue(e.getId()));
		});
		List<Specification_value> svalue = new ArrayList<Specification_value>();
		value.forEach(e->{
			e.forEach(q->{
				svalue.add(q);
			});
		});
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("selectAll", selectAll);
		jsonObj.put("value", va);
		jsonObj.put("ps", ps);
		jsonObj.put("svalue", svalue);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}

}
