package com.servlet.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDAO;
import com.dao.User_Product_FootprintDAO;
import com.entity.Product;
import com.entity.Product_specifications;
import com.entity.Specification_value;
import com.entity.Users;

/**
 * Servlet implementation class XianXiSerlvet
 */
@WebServlet("/jsp/qian/XianXiSerlvet")
public class XianXiSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO pdao = new ProductDAO();
	User_Product_FootprintDAO ypfdao = new User_Product_FootprintDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询出商品信息
		Integer id = Integer.valueOf(request.getParameter("id"));
		Product product = pdao.queryProduct(id);
		//查询对用的规格，与规格值
		List<Product_specifications> Specifications = pdao.querySpecifications(id);
		List<List<Specification_value>> value = new ArrayList<List<Specification_value>>();
		Specifications.forEach(e->{
			value.add(pdao.queryValue(e.getId()));
		});
		//添加商品浏览记录
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if(user!=null) {
			ypfdao.InsertFootprint(user.getId(), id);
		}
		
		//添加商品的点击量
		pdao.queryHits(id);
		
		//查询该商品的收藏数
		Long queryCollection = pdao.queryCollection(id);

		request.setAttribute("product", product);
		request.setAttribute("Specifications", Specifications);
		request.setAttribute("value", value);
		request.setAttribute("queryCollection", queryCollection);
		request.getRequestDispatcher("xianxi.jsp").forward(request, response);
	}


}
