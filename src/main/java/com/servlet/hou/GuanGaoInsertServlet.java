package com.servlet.hou;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson2.JSONObject;
import com.dao.AdvertisementDAO;
import com.dao.Price_CombinationDAO;
import com.dao.ProductDAO;
import com.dao.Product_SpecificationsDAO;
import com.dao.Specification_valueDAO;
import com.entity.Advertisement;
import com.entity.Price_combination;
import com.entity.Product_specifications;
import com.entity.Specification_value;

/**
 * Servlet implementation class CombinationSelectServlet
 */
@WebServlet("/jsp/hou/GuanGaoInsertServlet")
@MultipartConfig
public class GuanGaoInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdvertisementDAO adao = new AdvertisementDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer product_id = Integer.valueOf(request.getParameter("product_id"));
		request.setCharacterEncoding("utf-8");
		// 拿到上传的文件对象
		Part part = request.getPart("photo");
		if (part != null) {
			// 文件对应的信息
			String file = part.getHeader("content-disposition");
			// 文件名称
			String filename = file.split(";")[2].split("=")[1].replaceAll("\"", "");
			// 文件后缀
			String houzui = filename.substring(filename.lastIndexOf("."), filename.length());
			// 新文件名
			String newname = UUID.randomUUID().toString().toUpperCase();
			// 工程路径
			String root = getServletContext().getRealPath("");
			File wen = new File(root, "img/lun");
			// 查看images文件夹是否存在
			if (!wen.exists()) {
				wen.mkdir();
			}
			// 保存图片
			 part.write(wen+"\\"+newname+houzui);
			Advertisement a = new Advertisement(null, newname+houzui, product_id, null);
			adao.insertAdvertisement(a);
			request.getRequestDispatcher("guangaoguanli.jsp").forward(request, response);
		}
	}

}
