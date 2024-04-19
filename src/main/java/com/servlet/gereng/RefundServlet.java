package com.servlet.gereng;

import com.dao.RefundDAO;
import com.entity.Refund;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/jsp/gereng/RefundServlet")
public class RefundServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RefundDAO refundDAO = new RefundDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String refundReason = request.getParameter("refundReason");
        List<Refund> refundList = refundDAO.queryRefunds(0, refundReason, 0);
        request.setAttribute("refundList", refundList); 
        request.getRequestDispatcher("tksh.jsp").forward(request, response); 
    }
}
