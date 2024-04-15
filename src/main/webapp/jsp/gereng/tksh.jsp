<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Refund" %>

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
			<a href="商城首页.html">商城首页</a>
			<a href="grzx.jsp"><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a>
			<a href=""><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">退款/售后</a>
		</div>
		<div class="under">
			<%@include file="zxzuo.jsp" %>
			<div class="right">
				<div class="tkgl">退款/售后查询</div>
				<div class="list-caption">
					<div class="col0">商品名称</div>
					<div class="col1">退款原因</div>
					<div class="co12">状态</div>
					<div class="col3">操作</div>
				</div>	
				<c:forEach items="${refunds}" var="refund">
		            <tr>
		               	<td>${user.user_id}</td>
						<td>${user.refund_reason}</td>
						<td>${user.state}</td>
						<td>删除</td>
		            </tr>
				</c:forEach>
			</div>
		</div>
	</div>
<%@include file="../../html/footer.jsp" %>
</body>
</html>