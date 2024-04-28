package com.servlet.background;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdvertisementDAO;
import com.entity.Administrator;
import com.entity.Advertisement;

/**
 * Servlet implementation class AdvertisementServlet
 */
@WebServlet("/jsp/background/AdvertisementServlet")
public class AdvertisementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AdvertisementDAO admin=new AdvertisementDAO(); 
    public AdvertisementServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Advertisement> list=admin.queryAdvertisement();
		request.setAttribute("list", list);
		request.getRequestDispatcher("jibenbiao.jsp").forward(request, response);
		
	}



}
