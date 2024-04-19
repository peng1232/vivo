package com.servlet.gereng;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UsersDAO;
import com.entity.Users;

@WebServlet("/jsp/gereng/grxxServlet")
public class grxxServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UsersDAO usersDAO = new UsersDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        int sex = Integer.parseInt(request.getParameter("gender"));
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String ss =(year+"-"+month+"-"+day);
        java.sql.Date birth =java.sql.Date.valueOf(ss);
        
        Users u = new Users();
        u.setBirth(birth);
        u.setSex(sex);
        u.setId(user_id);
        
        try {
            usersDAO.updateUser(u);
            
            // 更新会话中的用户信息
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("user");
            user.setBirth(birth);
            user.setSex(sex);
            session.setAttribute("user", user);
            
            // 重定向到 grxx.jsp
            response.sendRedirect("grxx.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            // 处理异常
        }
    }
}

