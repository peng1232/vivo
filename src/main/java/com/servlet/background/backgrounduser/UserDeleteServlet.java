package com.servlet.background.backgrounduser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.AdministratorDAO;
import com.dao.userDAO;

/**
 * Servlet implementation class glyDeleteServlet
 */
@WebServlet("/jsp/background/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 userDAO admin = new userDAO();
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Integer	id =Integer.valueOf(request.getParameter("id"));
			String	state=request.getParameter("state");
			System.out.println(id);
			System.out.println(state);
			admin.doDelet(id, state);
			JSONObject jsonObj = new JSONObject();
			response.setContentType("userDao/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(jsonObj.toJSONString());
			
		}


}
