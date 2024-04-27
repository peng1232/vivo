package com.servlet.background.backgrounduser;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.dao.AdministratorDAO;
import com.dao.userDAO;
import com.entity.Administrator;
import com.entity.Users;

/**
 * Servlet implementation class selectByname
 */
@WebServlet("/jsp/background/UserselectByname")
public class UserselectByname extends HttpServlet {
	private static final long serialVersionUID = 1L;
     userDAO admin=new userDAO();
    
    public UserselectByname() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String	user_nickname=request.getParameter("user_nickname");
    	Integer	state=Integer.valueOf(request.getParameter("state"));
    	
    	System.out.println(user_nickname);
    	System.out.println(state);
    	List<Users> list=admin.selectByname(user_nickname, state);
		request.setAttribute("list", list);
		request.getRequestDispatcher("users.jsp").forward(request, response);
//		JSONObject jsonObj = new JSONObject();
//		response.setContentType("AdminstratorDAO/json");
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().println(jsonObj.toJSONString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
