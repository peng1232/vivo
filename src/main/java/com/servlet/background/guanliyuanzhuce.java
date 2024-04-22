package com.servlet.background;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.AdministratorDAO;


@WebServlet("/jsp/background/guanliyuanzhuce")
public class guanliyuanzhuce extends HttpServlet {
	private static final long serialVersionUID = 1L;
     AdministratorDAO admin= new AdministratorDAO();  
    public guanliyuanzhuce() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String nikename =	request.getParameter("nikename");
	 String account =	request.getParameter("account");
	 String password =	request.getParameter("password");
		System.out.println(admin.zhuCe(nikename, account, password));
		JSONObject jsonObj = new JSONObject();
		response.setContentType("AdminstratorDAO/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
