package com.servlet.background;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dao.CollectionDAO;
import com.dao.ProductDAO;
import com.entity.Collection;
import com.entity.Commodity_price;
import com.entity.Product;
import com.entity.Specification_value;

/**
 * Servlet implementation class CollectionInitServlet
 * CollectionInitServlet类用于初始化用户的收藏数据，并将其转发到'shoucang.jsp'页面。
 */
@WebServlet("/jsp/background/CollectionInitServlet")
public class CollectionInitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CollectionDAO cdao = new CollectionDAO();
	ProductDAO pdao = new ProductDAO();
    
    /**
     * 处理HTTP GET请求。
     * 获取用户的收藏，处理数据，并将数据转发到'shoucang.jsp'页面。
     * @param request  HttpServletRequest对象，用于接收客户端请求数据。
     * @param response HttpServletResponse对象，用于向客户端发送响应数据。
     * @throws ServletException 如果无法处理请求
     * @throws IOException      处理请求时发生输入或输出错误
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	
    	
    	// 从请求参数中获取用户ID
        Integer user_id = Integer.valueOf(request.getParameter("user_id"));
        
        // 查询用户的收藏记录
        List<Collection> queryUser_Collections = cdao.queryUser_Collections(user_id);
        
        // 创建一个用于存储产品信息的列表
        List<Product> list = new ArrayList<Product>();
        
        // 遍历用户的收藏记录
        queryUser_Collections.forEach(e -> {
            // 获取收藏记录中的产品ID和SKU信息
            Integer product_id = e.getProduct_id();
            JSONObject jsonObj = JSON.parseObject(e.getSku());
            int skuPrice = jsonObj.getIntValue("sku_price");
            int pageType = jsonObj.getIntValue("pageType");
            int color = jsonObj.getIntValue("color");

            // 查询产品信息
            Product queryUser_Product = cdao.queryUser_Product(product_id);

            // 查询产品的规格信息和价格信息
            Specification_value pageType_specifications = cdao.specification_Value(pageType);
            Specification_value color_specifications2 = cdao.specification_Value(color);
            Commodity_price commodity_price = cdao.commodity_price(skuPrice);

            // 设置产品的规格和价格信息，并将产品添加到列表中
            queryUser_Product.setPagTtype(pageType_specifications.getValue());
            queryUser_Product.setColor(color_specifications2.getValue());
            queryUser_Product.setPrice(commodity_price.getPrice());
            queryUser_Product.setImage_url(pdao.queryImage_Url(pageType_specifications.getId(), color_specifications2.getId()));
            list.add(queryUser_Product);
        });

        // 将用户的收藏记录和产品信息设置为请求属性，并转发到'shoucang.jsp'页面
        request.setAttribute("collection", queryUser_Collections);
        request.setAttribute("product", list);
        request.getRequestDispatcher("jibenbiao.jsp").forward(request, response);
    }

}