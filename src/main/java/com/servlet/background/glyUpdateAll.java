package com.servlet.background;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.alibaba.fastjson2.JSONObject;
import com.dao.AdministratorDAO;

@WebServlet("/jsp/background/glyUpdateAll")
public class glyUpdateAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdministratorDAO admin = new AdministratorDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer	id =Integer.valueOf(request.getParameter("id"));
		String	nikename=request.getParameter("nikename");
		String  account=request.getParameter("account");
		System.out.println(id);
		System.out.println(nikename);
		System.out.println(account);
		admin.douUpdateAll(id, nikename,account);
		JSONObject jsonObj = new JSONObject();
		response.setContentType("AdminstratorDAO/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
