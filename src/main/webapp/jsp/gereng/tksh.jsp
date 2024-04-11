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
			<a href="商城首页.html">商城首页</a>
			<a href="grzx.jsp"><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a>
			<a href=""><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">退款/售后</a>
		</div>
		<div class="under">
			<div class="left">
				<img src="../../img/${user.head_sculpture }" class="tx">
				<ul id="user_muem_item">
					<li class="z">${user.user_nickname }</li>

					<li class="z">交易管理</li>
					<li class="s"><a href="#">我的订单</a></li>
					<li class="s"><a href="tksh.jsp">退款/售后</a></li>

					<li class="z">评价管理</li>
					<li class="s"><a href="#">评价晒单</a></li>

					<li class="z">我的账户</li>
					<li class="s"><a href="xgmm.jsp">修改密码</a></li>
					<li class="s"><a href="xgdh.jsp">修改电话号码</a></li>
					<li class="s"><a href="grxx.jsp">个人资料</a></li>
					<li class="s"><a href="#">收货地址</a></li>
					<li class="s"><a href="#">我的收藏</a></li>
				</ul>
			</div>
			<div class="right">
				<div class="tkgl">退款/售后查询</div>
				<div class="list-caption">
					<div class="col0">商品名称</div>
					<div class="col1">退款原因</div>
					<div class="co12">状态</div>
					<div class="col3">操作</div>
					<tr>
						<td>${user.user_id}</td>
						<td>${user.refund_reason}</td>
						<td>${user.state}</td>
						<td></td>
					</tr>
				</div>	
			</div>
		</div>
	</div>
<%@include file="../../html/footer.jsp" %>
</body>
</html>