package com.servlet.gereng;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.dao.UsersDAO;
import com.entity.Users;

@WebServlet("/jsp/users")
public class grxxServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	UsersDAO r = new UsersDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * List<Users> city = r.selectAll(); JSONArray jsonArray = new JSONArray();
		 * city.forEach(e->{ JSONObject jsonObj = new JSONObject();
		 * jsonObj.put("id",e.getId());
		 * jsonObj.put("user_nickname",e.getUser_nickname()); jsonObj.put("phone",
		 * e.getPhone()); jsonObj.put("head_sculpture",e.getHead_sculpture());
		 * jsonObj.put("birth",e.getBirth()); jsonObj.put("sex",e.getSex());
		 * jsonArray.add(jsonObj); });
		 */
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println(jsonArray.toJSONString());
	}
}
