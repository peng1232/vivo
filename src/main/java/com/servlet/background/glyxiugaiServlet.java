package com.servlet.background;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.AdministratorDAO;

@WebServlet("/jsp/background/glyxiugaiServlet")
public class glyxiugaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdministratorDAO admin = new AdministratorDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer	id =Integer.valueOf(request.getParameter("id"));
		String	password=request.getParameter("password");
		System.out.println(id);
		System.out.println(password);
		admin.douUpdate(id, password);
		JSONObject jsonObj = new JSONObject();
		response.setContentType("AdminstratorDAO/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
		
	}

}
