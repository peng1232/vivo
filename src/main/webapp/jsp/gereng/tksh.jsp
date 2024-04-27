<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退款售后</title>
<link rel="icon name" href="../../img/favicon.ico" />
<link href="../../css/grzx.css" rel="stylesheet" />
<link href="../../css/nav.css" rel="stylesheet" />
<link href="../../css/footer.css" rel="stylesheet" />
<script src="../../js/jquery.min.js"></script>
<script src="../../js/nav.js"></script>
</head>
<body>
<%@include file="../../html/nav.jsp" %>
	<div class="container">
		<div class="menu">
				<a href="../qian/shouye.jsp">商城首页</a>
			<a href="grzx.jsp"><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a>
			<a href=""><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">退款/售后</a>
		</div>
		<div class="under">
		    <%@include file="../../html/zxzuo.jsp" %>
		    <div class="right">
		        <div class="tkgl">退款/售后查询</div>
		        <table>
		        	<div style="margin-top: 35px;">
			            <thead>
			                <tr class="list-caption">
			                    <th class="col0">商品名称</th>
			                    <th class="col1">退款原因</th>
			                    <th class="col2">状态</th>
			                    <th class="col3">操作</th>
			                </tr>
			            </thead>
		            </div>	
		            <tbody>
		                <c:forEach items="${refundList}" var="refund">
		                    <tr>
		                        <td class="col0">${refund.user_id}</td>
		                        <td class="col1">${refund.refund_reason}</td>
		                        <td class="col2">${refund.state}</td>
		                        <td class="col3"><a href="refund?action=delete&refundId=${refund.user_id}">删除</a></td>
		                    </tr>
		                </c:forEach>
		            </tbody>
		        </table>
		    </div>
		</div>
	</div>
<%@include file="../../html/footer.jsp" %>
</body>
</html>