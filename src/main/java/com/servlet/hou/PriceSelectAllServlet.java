package com.servlet.hou;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Commodity_PriceDAO;
import com.dao.ProductDAO;
import com.entity.Commodity_price;
import com.entity.Product;
import com.entity.Product_specifications;

/**
 * Servlet implementation class CategorySelectAllServlet
 */
@WebServlet("/jsp/hou/PriceSelectAllServlet")
public class PriceSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Commodity_PriceDAO sdao = new Commodity_PriceDAO();
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
		
		List<Product> productlist = pdao.productSelectAll();

		String zt = request.getParameter("name");
		String is = request.getParameter("is");
		Integer isval = null;
		Integer product_id=null;
		if (zt != null && !zt.trim().isEmpty()&&!zt.equals("null")) {
		    product_id = Integer.valueOf(zt);
		} else {
		    product_id = null;
		}
		if (is != null && !is.trim().isEmpty()&&!is.equals("null")) {
			isval = Integer.valueOf(is);
		} else {
			isval = null;
		}
		
		String sql = "name=%s&is=%s";
		sql= String.format(sql,product_id,is);
		
		Commodity_price c = new Commodity_price();
		c.setProduct_id(product_id);
		c.setIs_recommended(isval);
		
		List<Commodity_price> selectAll = sdao.Commodity_priceSelectAll(c, curpage, pagesize);
		
		int total = sdao.Commodity_priceSelectAll(c, null, null).size(); // 总记录数
		
		request.setAttribute("selectAll", selectAll);
		request.setAttribute("sql", sql);
		request.setAttribute("productlist", productlist);
		request.setAttribute("product_id", product_id);
		request.setAttribute("isval", isval);
		request.setAttribute("total", total);
		request.setAttribute("curpage", curpage);
		request.setAttribute("count", (total - 1) / pagesize + 1);
		request.getRequestDispatcher("priceguanli.jsp").forward(request, response);
	}


}
