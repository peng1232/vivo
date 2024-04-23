package com.servlet.background;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.AdministratorDAO;

/**
 * Servlet implementation class glyDeleteServlet
 */
@WebServlet("/jsp/background/glyDeleteServlet")
public class glyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 AdministratorDAO admin = new AdministratorDAO();
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Integer	id =Integer.valueOf(request.getParameter("id"));
			String	state=request.getParameter("state");
			System.out.println(id);
			System.out.println(state);
			admin.doDelet(id, state);
			JSONObject jsonObj = new JSONObject();
			response.setContentType("AdminstratorDAO/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(jsonObj.toJSONString());
			
		}


}
