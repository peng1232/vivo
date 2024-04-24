package com.servlet.hou;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDAO;
import com.entity.Category;

/**
 * Servlet implementation class CategoryInsertServlet
 */
@WebServlet("/jsp/hou/CategoryUpdateServlet")
public class CategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDAO cdao = new CategoryDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String cate = request.getParameter("type");
		String state = request.getParameter("state");
		Category c = new Category(Integer.valueOf(id),cate,Integer.valueOf(state));
		cdao.UpdateCategory(c);
		request.getRequestDispatcher("categoryguanli.jsp").forward(request, response);
	}

}
