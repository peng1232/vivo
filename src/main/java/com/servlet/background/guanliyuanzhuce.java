package com.servlet.background;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdministratorDAO;

/**
 * Servlet implementation class guanliyuanzhuce
 */
@WebServlet("/guanliyuanzhuce")
public class guanliyuanzhuce extends HttpServlet {
	private static final long serialVersionUID = 1L;
     AdministratorDAO admin= new AdministratorDAO();  
    public guanliyuanzhuce() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String nickname =	request.getParameter("nickname");
	 String account =	request.getParameter("account");
	 String password =	request.getParameter("password");
		admin.zhuCe(nickname, account, password);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
