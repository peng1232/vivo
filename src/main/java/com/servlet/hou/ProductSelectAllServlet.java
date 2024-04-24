package com.servlet.hou;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

		String type = request.getParameter("type");
		String productname = request.getParameter("product");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		Integer state;
		String zt = request.getParameter("state");
		if(zt ==null|| zt.equals("quan")||zt.equals("null") ) {
			state = null;
		}else {
			state = Integer.valueOf(zt);
		}

		if (type == null||type.length()==0) {
			type = "";
	    }
		if (productname == null||productname.length()==0) {
			productname = "";
	    }
		if (start == null||start.length()==0) {
			start = "";
	    }
		if (end == null||end.length()==0) {
			end = "";
	    }
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

		// 将时间字符串解析为LocalDateTime对象
		Timestamp starttime = null;
		Timestamp endtime = null;

		if (!start.isEmpty() && !end.isEmpty()) {
		    LocalDateTime startTime = LocalDateTime.parse(start, formatter);
		    LocalDateTime endTime = LocalDateTime.parse(end, formatter);

		    // 将LocalDateTime对象转换为Timestamp对象
		    starttime = Timestamp.valueOf(startTime);
		    endtime = Timestamp.valueOf(endTime);
		}
		
		
		
		
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
		
		
		String sql = "state=%s&end=%s&start=%s&productname=%s&type=%s";
		sql= String.format(sql,state,end,start,productname,type);

		//List<Category> selectAll = pdao.productSelectAll(state,curpage,pagesize);
		Product p = new Product();
		if (type != null&&type.length()!=0) {
			p.setCategory_id(Integer.valueOf(type));
	    }else {
	    	p.setCategory_id(null);
	    }
		p.setState(state);
		p.setProducts_name(productname);
		List<Product> selectAll =  pdao.productSelectAll(p,starttime,endtime,curpage,pagesize);
	
		List<Category> category = new ArrayList<Category>();
		List<Category> categorys = cdao.selectAll();
		selectAll.forEach(e->{
			category.add(cdao.queryCategory(e.getCategory_id()));
		});
		
		int total =  pdao.productSelectAll(p,starttime,endtime,null,null).size(); // 总记录数

		request.setAttribute("product", selectAll);
		request.setAttribute("category", category);
		request.setAttribute("categorys", categorys);
		request.setAttribute("sql", sql);
		request.setAttribute("starttime", starttime);
		request.setAttribute("endtime", endtime);
		request.setAttribute("productname", productname);
		request.setAttribute("type", type);
		request.setAttribute("state", state);
		request.setAttribute("total", total);
		request.setAttribute("curpage", curpage);
		request.setAttribute("count", (total - 1) / pagesize + 1);
		request.getRequestDispatcher("productguanli.jsp").forward(request, response);
	}


}
