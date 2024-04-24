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
import com.dao.Specification_valueDAO;
import com.entity.Category;
import com.entity.Specification_value;

/**
 * Servlet implementation class CategorySelectAllServlet
 */
@WebServlet("/jsp/hou/ValueSelectOneServlet")
public class ValueSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Specification_valueDAO sdao = new Specification_valueDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer specifications_id = Integer.valueOf(request.getParameter("specifications_id"));
		List<Specification_value> selectValue = sdao.selectValue(specifications_id);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("selectValue", selectValue);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
		
	}


}
