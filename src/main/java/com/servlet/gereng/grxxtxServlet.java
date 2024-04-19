package com.servlet.gereng;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.UsersDAO;
import com.entity.Users;

@WebServlet("/jsp/gereng/grxxtxServlet")
@MultipartConfig
public class grxxtxServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UsersDAO userDao = new UsersDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		//拿到上传的文件对象
		Part part = request.getPart("photo");
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
			File wen = new File(root,"img");
			//查看images文件夹是否存在
			if(!wen.exists()) {
				wen.mkdir();
			}
			//保存图片
			part.write(wen+"\\"+newname+houzui);
			//更改库中路径
			HttpSession session = request.getSession();
			Users user = (Users) session.getAttribute("user");
			userDao.headUpdate(user.getId(),newname+houzui );
			//刷新数据
			user.setHead_sculpture(newname+houzui);
			session.setAttribute("user", user);
			request.getRequestDispatcher("grxx.jsp").forward(request, response);
		}

    }
}
