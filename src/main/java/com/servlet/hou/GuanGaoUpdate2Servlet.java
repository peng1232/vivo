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
import com.dao.AdvertisementDAO;
import com.entity.Advertisement;
import com.entity.Product_image;

/**
 * Servlet implementation class GuanGaoUpdateServlet
 */
@WebServlet("/jsp/hou/GuanGaoUpdate2Servlet")
@MultipartConfig
public class GuanGaoUpdate2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdvertisementDAO adao = new AdvertisementDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		String image_url_value = request.getParameter("url");
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
			File file2 = new File(wen + "\\" + image_url_value);
			file2.delete();
			// 保存图片
			part.write(wen + "\\" + newname + houzui);

			Product_image p = new Product_image(id, null, newname + houzui);
			adao.updateAdvertisement(newname + houzui, id);

			JSONObject jsonObj = new JSONObject();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(jsonObj.toJSONString());
		}

	}

}
