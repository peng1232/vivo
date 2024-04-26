package com.servlet.product;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Commodity_PriceDAO;
import com.dao.ProductDAO;
import com.dao.Specification_valueDAO;
import com.entity.Product;
import com.entity.Specification_value;

/**
 * Servlet implementation class SearchSetlvet
 */
@WebServlet("/jsp/qian/SearchSetlvet")
public class SearchSetlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO pdao = new ProductDAO();
	Specification_valueDAO sdao = new Specification_valueDAO();
	Commodity_PriceDAO cdao = new Commodity_PriceDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		String st = request.getParameter("start");
		String en = request.getParameter("end");
		List<Product> querySearch = pdao.querySearch(search);
		List<Integer> pricelist = new ArrayList<Integer>();
		List<String> sku = new ArrayList<String>();
		Integer start=null;
		Integer end=null;
		if(st!=null&&en!=null) {
			start = Integer.valueOf(st);
			end = Integer.valueOf(en);
		}else {
			start=0;
			end =8;
		}
		if(end>querySearch.size()) {
			end = querySearch.size();
		}
		querySearch= querySearch.subList(start, end);
		querySearch.forEach(e->{
			pricelist.add(Integer.valueOf(e.getPrice()+""));
			List<Specification_value> queryValue = sdao.queryValue(e.getId(),Integer.valueOf(e.getPrice()+""));
			e.setPagTtype(queryValue.get(0).getValue());
			e.setColor(queryValue.get(1).getValue());
			String formattedString = String.format("{\"sku_price\":%d,\"pageType\":%d,\"color\":%d}",Integer.valueOf(e.getPrice()+""), queryValue.get(0).getId(), queryValue.get(1).getId());
			sku.add( URLEncoder.encode(formattedString));
			e.setPrice(cdao.queryPrice(Integer.valueOf(e.getPrice()+"")));
			e.setImage_url(pdao.queryImage_Url(queryValue.get(0).getId(), queryValue.get(1).getId()));
			
			
		});
		request.setAttribute("querySearch", querySearch);
		request.setAttribute("tatol", pdao.querySearch(search).size());
		request.setAttribute("pricelist", pricelist);
		request.setAttribute("search", search);
		request.setAttribute("sku", sku);
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}
}