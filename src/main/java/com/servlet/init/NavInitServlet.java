package com.servlet.init;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson2.JSONObject;
import com.dao.Shopping_CartDAO;
import com.dao.User_Login_TimeDAO;
import com.dao.UsersDAO;
import com.entity.Users;
import com.qita.Yzm;

/**
* @Description: 
* @author: 铭
* @date 2024年4月2日 上午9:47:49
*/

@WebServlet("/jsp/navSerlvet")
public class NavInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Shopping_CartDAO sdao=  new Shopping_CartDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jsonObj = new JSONObject();
		String zhi = request.getParameter("id");
		if(zhi!=null&&zhi.trim().length()>0) {
			Integer id = Integer.valueOf(zhi);
			Integer shopping_Count = sdao.shopping_Count(id);
			jsonObj.put("shopping_count", shopping_Count);
			HttpSession session = request.getSession();
			session.setAttribute("shopping_count", shopping_Count);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(jsonObj.toJSONString());
		}
	}


}