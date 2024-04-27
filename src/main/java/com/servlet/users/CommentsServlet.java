package com.servlet.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CommentsDAO;
import com.dao.ProductDAO;
import com.entity.Comments;
import com.entity.Product;

/**
 * Servlet implementation class CommentsServlet
 */
@WebServlet("/jsp/user/CommentsServlet")
public class CommentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CommentsDAO commentsDAO = new CommentsDAO();
    private ProductDAO pdao = new ProductDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer user_id = Integer.valueOf(request.getParameter("user_id"));
    	List<Comments> commentsList = commentsDAO.queryUser_Comments(user_id);
        List<Product> plist  =new ArrayList<Product>();
        commentsList.forEach(e->{
        	plist.add(pdao.queryProduct(e.getProduct_id()));
        });
        request.setAttribute("commentsList", commentsList);
        request.setAttribute("plist", plist);
        request.getRequestDispatcher("pinglun.jsp").forward(request, response);
    }
}