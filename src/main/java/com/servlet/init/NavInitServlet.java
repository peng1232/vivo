package com.servlet.init;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson2.JSONObject;
import com.dao.CategoryDAO;
import com.dao.Shopping_CartDAO;
import com.entity.Category;


/**
* @Description: 
* @author: 铭
* @date 2024年4月2日 上午9:47:49
*/

@WebServlet("/jsp/navSerlvet")
public class NavInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Shopping_CartDAO sdao=  new Shopping_CartDAO();
	CategoryDAO cdao = new CategoryDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jsonObj = new JSONObject();
		String zhi = request.getParameter("id");
		if(zhi!=null&&zhi.trim().length()>0) {
			Integer id = Integer.valueOf(zhi);
			Integer shopping_Count = sdao.shopping_Count(id);
			jsonObj.put("shopping_count", shopping_Count);
			HttpSession session = request.getSession();
			session.setAttribute("shopping_count", shopping_Count);
		}

		
		List<Category> list_cate = cdao.selectAll();
		jsonObj.put("list_cate", list_cate);
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}


}