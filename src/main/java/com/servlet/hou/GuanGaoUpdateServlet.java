package com.servlet.hou;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson2.JSONObject;
import com.dao.AdvertisementDAO;
import com.entity.Advertisement;
import com.entity.Product_image;

/**
 * Servlet implementation class GuanGaoUpdateServlet
 */
@WebServlet("/jsp/hou/GuanGaoUpdateServlet")
@MultipartConfig
public class GuanGaoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdvertisementDAO adao = new AdvertisementDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer product_id = Integer.valueOf(request.getParameter("product_id"));
		Integer state = Integer.valueOf(request.getParameter("state"));
		Advertisement a= new Advertisement(id, null, product_id, state);
		adao.updateAdvertisement(a);
		request.getRequestDispatcher("guangaoguanli.jsp").forward(request, response);
				
	}

}
