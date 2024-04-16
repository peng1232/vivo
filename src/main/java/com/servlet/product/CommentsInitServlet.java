package com.servlet.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dao.CollectionDAO;
import com.dao.CommentsDAO;
import com.entity.Comments;

/**
 * Servlet implementation class CommentsInitServlet
 */
@WebServlet("/jsp/qian/CommentsInitServlet")
public class CommentsInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CommentsDAO cdao = new CommentsDAO();
	CollectionDAO ctdao = new CollectionDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer start = Integer.valueOf(request.getParameter("start"));
		Integer end = Integer.valueOf(request.getParameter("end"));
		Integer product_id = Integer.valueOf(request.getParameter("product_id"));
		List<Comments> commentList = cdao.queryProductComments(product_id, start, end);
		commentList.forEach(e->{
			JSONObject jsonObj = JSON.parseObject(e.getSku());
			int pageType = jsonObj.getIntValue("pageType");
			int color = jsonObj.getIntValue("color");
			String bb = ctdao.specification_Value(pageType).getValue();
			String ys = ctdao.specification_Value(color).getValue();
			e.setSku(bb+" "+ys);
		});
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("commentList", commentList);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());
	}


}
