package com.servlet.hou;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.CategoryDAO;
import com.dao.Specification_valueDAO;
import com.entity.Specification_value;

/**
 * Servlet implementation class CategoryInsertServlet
 */
@WebServlet("/jsp/hou/ValueInsertServlet")
public class ValueInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Specification_valueDAO sdao = new Specification_valueDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer id = Integer.valueOf(request.getParameter("id"));
		String value = request.getParameter("value");
		Specification_value s = new Specification_value(null,id,value);
		sdao.insertValue(s);
		JSONObject jsonObj = new JSONObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}

}
