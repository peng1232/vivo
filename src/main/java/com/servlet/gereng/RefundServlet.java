package com.servlet.gereng;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.dao.RefundDAO;
import com.entity.Refund;

@WebServlet("/jsp/refund")
public class RefundServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	RefundDAO r = new RefundDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Refund> city = r.selectRec();
		JSONArray jsonArray = new JSONArray();
		city.forEach(e->{
			JSONObject jsonObj = new JSONObject();
            jsonObj.put("id", e.getId());
            jsonObj.put("refund_reason",e.getRefund_reason());
            jsonObj.put("state", e.getState());
            jsonArray.add(jsonObj);
		});
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println(jsonArray.toJSONString());
	}
}
