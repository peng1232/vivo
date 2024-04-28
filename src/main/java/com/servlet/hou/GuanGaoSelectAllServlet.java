package com.servlet.hou;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdvertisementDAO;
import com.dao.ProductDAO;
import com.entity.Advertisement;
import com.entity.Product;

/**
 * Servlet implementation class CategorySelectAllServlet
 */
@WebServlet("/jsp/hou/GuanGaoSelectAllServlet")
public class GuanGaoSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdvertisementDAO adao = new AdvertisementDAO();
	ProductDAO pdao = new ProductDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curpageStr = request.getParameter("curpage");
		String pagesizeStr = request.getParameter("pagesize");
		String flag = request.getParameter("flag");
		int curpage;
		int pagesize;
		if ((curpageStr == null||curpageStr.equals(" ")) &&( pagesizeStr == null||pagesizeStr.equals(" "))) {
			curpage = 1;
			pagesize = 8;
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
		Integer product_id = null;
		String pid = request.getParameter("product_id");
		if(pid ==null|| pid.equals("quan")||zt.equals("null") ) {
			pid = null;
		}else {
			product_id = Integer.valueOf(pid);
		}
		
		String sql = "product_id=%s&state=%s";
		sql= String.format(sql,product_id,state);
		
		Advertisement a= new Advertisement(null, null, product_id, state);
		
		List<Advertisement> selectAll = adao.selectAll(a, curpage, pagesize);
		List<Product> productlist = pdao.productSelectAll();
		int total =  adao.selectAll(a, null, null).size(); // 总记录数

		request.setAttribute("advertisement", selectAll);
		request.setAttribute("productlist", productlist);
		request.setAttribute("product_id", product_id);
		request.setAttribute("sql", sql);
		request.setAttribute("state", state);
		request.setAttribute("total", total);
		request.setAttribute("curpage", curpage);
		request.setAttribute("count", (total - 1) / pagesize + 1);
		request.getRequestDispatcher("guangaoguanli.jsp").forward(request, response);
	}


}
