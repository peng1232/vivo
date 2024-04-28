package com.servlet.background;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdministratorDAO;
import com.entity.Administrator;
import com.entity.Users;

/**
 * Servlet implementation class AdministratorServlet
 */
@WebServlet("/jsp/background/AdministratorServlet")
public class glyselectAllServlet extends HttpServlet {
	private  static final long serialVersionUID = 1L;
	AdministratorDAO admin =new AdministratorDAO();
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
		
		
		String	user_nickname=request.getParameter("nikename");
		String zt = request.getParameter("state");
		Integer state = null;
		if(user_nickname==null||user_nickname.trim().length()<=0||user_nickname.equals(" ")) {
			user_nickname = null;
		}
		if(zt ==null|| zt.equals("quan")||zt.equals("null") ) {
			state = null;
		}else {
			state = Integer.valueOf(zt);
		}
		
		String sql = "nikename=%s&state=%s";
		sql= String.format(sql,user_nickname,state);
		Administrator a = new Administrator(null, user_nickname, null, null, state);
		List<Administrator> list=admin.selectAll(a,curpage,pagesize);
		
		int total =  admin.selectAll(new Administrator(), null, null).size(); // 总记录数
		request.setAttribute("list", list);
		request.setAttribute("user_nickname", user_nickname);
		request.setAttribute("state", state);
		request.setAttribute("sql", sql);
		request.setAttribute("total", total);
		request.setAttribute("curpage", curpage);
		request.setAttribute("count", (total - 1) / pagesize + 1);
		request.getRequestDispatcher("backgroundcenter.jsp").forward(request, response);
	}
	
	
}
