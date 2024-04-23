package com.servlet.background;

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
import com.entity.Administrator;

/**
 * Servlet implementation class selectByname
 */
@WebServlet("/jsp/background/selectByname")
public class selectByname extends HttpServlet {
	private static final long serialVersionUID = 1L;
     AdministratorDAO admin=new AdministratorDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectByname() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String	nikename=request.getParameter("nikename");
    	String	state=request.getParameter("state");
    	
    	System.out.println(nikename);
    	System.out.println(state);
    	List<Administrator> list=admin.selectpart(nikename, state);
		request.setAttribute("list", list);
		request.getRequestDispatcher("backgroundcenter.jsp").forward(request, response);
		JSONObject jsonObj = new JSONObject();
		response.setContentType("AdminstratorDAO/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
