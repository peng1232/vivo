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
import com.dao.Product_ImageDAO;
import com.dao.Specification_valueDAO;
import com.entity.Product_image;
import com.entity.Specification_value;

/**
 * Servlet implementation class CategorySelectAllServlet
 */
@WebServlet("/jsp/hou/ValueSelectOneServlet")
public class ValueSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Specification_valueDAO sdao = new Specification_valueDAO();
	Product_ImageDAO pdao = new Product_ImageDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer specifications_id = Integer.valueOf(request.getParameter("specifications_id"));
		List<Specification_value> selectValue = sdao.selectValue(specifications_id);
		//List<List<Product_image>> imagelist = new ArrayList<List<Product_image>>();
		List<Integer> num = new ArrayList<Integer>();
		selectValue.forEach(e->{
			num.add(pdao.selectProduct_Image_id(e.getId()).size());
		});
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("selectValue", selectValue);
		jsonObj.put("num", num);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
		
	}


}
