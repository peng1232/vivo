/*
 * package com.servlet.background;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import javax.jws.WebService; import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import com.dao.AdministratorDAO; import com.entity.Administrator; import
 * com.qita.Yzm;
 * 
 * @WebServlet(urlPatterns = "/jsp/background/glydenglu")
 * 
 * public class guanliyuandengluServlet extends HttpServlet {
 * 
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { String account =
 * request.getParameter("username"); String password =
 * request.getParameter("password");
 * 
 * AdministratorDAO administratorDAO = new AdministratorDAO(); Administrator
 * administrator = administratorDAO.dengLu(account, password);
 * System.out.println(administrator); if (administrator != null) { HttpSession
 * session = request.getSession(); session.setAttribute("administrator",
 * administrator); response.sendRedirect("backgroundcenter.jsp"); } else {
 * response.sendRedirect("guanliyuandenglu.jsp?error=1"); } }
 * 
 * }
 */