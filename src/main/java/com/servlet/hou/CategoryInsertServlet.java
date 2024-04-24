package com.servlet.hou;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDAO;

/**
 * Servlet implementation class CategoryInsertServlet
 */
@WebServlet("/jsp/hou/CategoryInsertServlet")
public class CategoryInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDAO cdao = new CategoryDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		Integer insertCategory = cdao.insertCategory(type);
		request.getRequestDispatcher("categoryguanli.jsp").forward(request, response);
	}

}
