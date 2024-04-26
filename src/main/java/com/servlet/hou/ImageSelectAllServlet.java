package com.servlet.hou;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.CategoryDAO;
import com.dao.Product_ImageDAO;
import com.dao.Specification_valueDAO;
import com.entity.Category;
import com.entity.Product_image;
import com.entity.Specification_value;

/**
 * Servlet implementation class CategorySelectAllServlet
 */
@WebServlet("/jsp/hou/ImageSelectAllServlet")
public class ImageSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Product_ImageDAO pdao = new Product_ImageDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("value_id"));
		List<Product_image> Product_Image = pdao.selectProduct_Image_id(id);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("Product_Image", Product_Image);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
		
	}


}
