package com.servlet.hou;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDAO;
import com.dao.ProductDAO;
import com.entity.Category;
import com.entity.Product;

/**
 * Servlet implementation class CategorySelectAllServlet
 */
@WebServlet("/jsp/hou/ProductSelectAllServlet")
public class ProductSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO pdao = new ProductDAO();
	CategoryDAO cdao = new CategoryDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curpageStr = request.getParameter("curpage");
		String pagesizeStr = request.getParameter("pagesize");
		String flag = request.getParameter("flag");
		int curpage;
		int pagesize;
		if ((curpageStr == null||curpageStr.equals(" ")) &&( pagesizeStr == null||pagesizeStr.equals(" "))) {
			curpage = 1;
			pagesize = 5;
		} else {
			curpage = Integer.parseInt(curpageStr);
			pagesize = Integer.parseInt(pagesizeStr);
		}
		if(flag!=null) {
			curpage=1;
		}
		Integer state;
		String zt = request.getParameter("state");
		if(zt ==null|| zt.equals("quan")||zt.equals("null") ) {
			state = null;
		}else {
			state = Integer.valueOf(zt);
		}
		
		String sql = "can=%s&jin=%s&lai=%s&state=%s&start=%s&end=%s";
		//sql= String.format(sql,state);

		//List<Category> selectAll = pdao.productSelectAll(state,curpage,pagesize);
		List<Product> selectAll = pdao.productSelectAll();
		List<Category> category = new ArrayList<Category>();
		selectAll.forEach(e->{
			category.add(cdao.queryCategory(e.getCategory_id()));
		});
		
		int total =  pdao.productSelectAll().size(); // 总记录数

		request.setAttribute("product", selectAll);
		request.setAttribute("category", category);
		request.setAttribute("sql", sql);
		request.setAttribute("state", state);
		request.setAttribute("total", total);
		request.setAttribute("curpage", curpage);
		request.setAttribute("count", (total - 1) / pagesize + 1);
		request.getRequestDispatcher("productguanli.jsp").forward(request, response);
	}


}
