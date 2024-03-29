package com.servlet.city;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.dao.CityDAO;
import com.entity.City;


@WebServlet("/jsp/city")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CityDAO c = new CityDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer parentid = Integer.valueOf(request.getParameter("parentid"));
		List<City> city = c.selectCity(parentid);
		JSONArray jsonArray = new JSONArray();
		
		city.forEach(e->{
			JSONObject jsonObj = new JSONObject();
            jsonObj.put("id", e.getId());
            jsonObj.put("name",e.getName());
            jsonArray.add(jsonObj);
		});
		System.out.println(jsonArray.toJSONString());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonArray.toJSONString());
	}

}
