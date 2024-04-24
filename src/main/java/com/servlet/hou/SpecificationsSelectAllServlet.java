package com.servlet.hou;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDAO;
import com.dao.Product_SpecificationsDAO;
import com.entity.Category;
import com.entity.Product;
import com.entity.Product_specifications;

/**
 * Servlet implementation class CategorySelectAllServlet
 */
@WebServlet("/jsp/hou/SpecificationsSelectAllServlet")
public class SpecificationsSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Product_SpecificationsDAO sdao = new Product_SpecificationsDAO();
	ProductDAO pdao = new ProductDAO();
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
		
		List<Product> productlist = pdao.productSelectAll();

		String specifications = request.getParameter("specifications");
		Integer product_id=null;
		String zt = request.getParameter("name");
		if (zt != null && !zt.trim().isEmpty()&&!zt.equals("null")) {
		    product_id = Integer.valueOf(zt);
		} else {
		    product_id = null;
		}
		if (specifications != null && !specifications.trim().isEmpty()&&!specifications.equals("null")) {
		    
		} else {
			specifications = null;
		}
		
		String sql = "name=%s&specifications=%s";
		sql= String.format(sql,product_id,specifications);
		
		Product_specifications s = new Product_specifications();
		s.setProduct_id(product_id);
		s.setSpecifications_name(specifications);
		
		List<Product_specifications> selectAll = sdao.specificationsSelectAll(s, curpage, pagesize);
		
		int total = sdao.specificationsSelectAll(s, null, null).size(); // 总记录数
		
		request.setAttribute("selectAll", selectAll);
		request.setAttribute("sql", sql);
		request.setAttribute("productlist", productlist);
		request.setAttribute("product_id", product_id);
		request.setAttribute("specifications", specifications);
		request.setAttribute("total", total);
		request.setAttribute("curpage", curpage);
		request.setAttribute("count", (total - 1) / pagesize + 1);
		request.getRequestDispatcher("specifications.jsp").forward(request, response);
	}


}
