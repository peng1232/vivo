package com.servlet.background.backgrounduser;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.userDAO;
import com.entity.Users;
/**
 * Servlet implementation class AdministratorServlet
 */
@WebServlet("/jsp/background/userselectAllServlet")
public class UserselectAllServlet extends HttpServlet {
	private  static final long serialVersionUID = 1L;
	userDAO admin =new userDAO();
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
		
		
		String	user_nickname=request.getParameter("user_nickname");
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
		Users u = new Users();
		u.setUser_nickname(user_nickname);
		u.setState(state);
		
		String sql = "user_nickname=%s&state=%s";
		sql= String.format(sql,user_nickname,state);
		List<Users> list=admin.selectAlluse(u,curpage,pagesize);
		
		int total =  admin.selectAlluse(new Users(), null, null).size(); // 总记录数
		
		request.setAttribute("list", list);
		request.setAttribute("user_nickname", user_nickname);
		request.setAttribute("state", state);
		request.setAttribute("sql", sql);
		request.setAttribute("total", total);
		request.setAttribute("curpage", curpage);
		request.setAttribute("count", (total - 1) / pagesize + 1);
		request.getRequestDispatcher("users.jsp").forward(request, response);
	}
	
	
}
