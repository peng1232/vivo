package com.servlet.background.backgrounduser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bouncycastle.jcajce.provider.asymmetric.RSA;

import com.alibaba.fastjson2.JSONObject;
import com.dao.AdministratorDAO;
import com.dao.userDAO;

@WebServlet("/jsp/background/backgrounduser/Userzhuce")
public class Userzhuce extends HttpServlet {
	private static final long serialVersionUID = 1L;
    userDAO admin = new userDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		System.out.println(phone);
		System.out.println(password);
		admin.zhuCe(phone, password);
		JSONObject jsonObj = new JSONObject();
		response.setContentType("userDAO/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
