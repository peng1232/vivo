package com.servlet.hou;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson2.JSONObject;
import com.dao.Product_ImageDAO;
import com.entity.Product_image;

/**
 * Servlet implementation class CategorySelectAllServlet
 */
@WebServlet("/jsp/hou/ImageDelectServlet")
@MultipartConfig
public class ImageDelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Product_ImageDAO pdao = new Product_ImageDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer image_id = Integer.valueOf(request.getParameter("image_id"));
		String image_url = request.getParameter("image_url");
		
		String root = getServletContext().getRealPath("");
		File wen = new File(root,"img/product");
		 // 创建 File 对象，传入文件路径作为参数
        File file = new File(wen+"\\"+image_url);
        
        if (file.delete()) {
           pdao.delectProduct_image(image_id);
        } else {
            System.out.println("文件删除失败");
        }
		
		JSONObject jsonObj = new JSONObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(jsonObj.toJSONString());

	}

}
