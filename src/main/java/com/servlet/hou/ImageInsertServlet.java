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
@WebServlet("/jsp/hou/ImageInsertServlet")
@MultipartConfig
public class ImageInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Product_ImageDAO pdao = new Product_ImageDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//拿到上传的文件对象
		Part part = request.getPart("photo");
		Integer image_value_id = Integer.valueOf(request.getParameter("image_value"));
		if(part!=null) {
			//文件对应的信息
			String file= part.getHeader("content-disposition");
			//文件名称
			String filename = file.split(";")[2].split("=")[1].replaceAll("\"", "");
			//文件后缀
			String houzui = filename.substring(filename.lastIndexOf("."),filename.length());
			//新文件名
			String newname = UUID.randomUUID().toString().toUpperCase();
			//工程路径
			String root = getServletContext().getRealPath("");
			File wen = new File(root,"img/product");
			//查看images文件夹是否存在
			if(!wen.exists()) {
				wen.mkdir();
			}
			//保存图片
			part.write(wen+"\\"+newname+houzui);
			
			Product_image p = new Product_image(null,image_value_id,newname+houzui);
			pdao.insertProduct_image(p);
			
			JSONObject jsonObj = new JSONObject();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(jsonObj.toJSONString());
		}
		
	}


}
