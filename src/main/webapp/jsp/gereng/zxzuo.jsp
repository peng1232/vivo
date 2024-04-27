<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon name" href="../../img/favicon.ico" />
<link href="../../css/grzx.css" rel="stylesheet" />
<link href="../../css/nav.css" rel="stylesheet" />
<link href="../../css/footer.css" rel="stylesheet" />
<script src="../../js/jquery.min.js"></script>
</head>
<body>
	<div class="left">
				<input type="hidden" class='user_id' value='${user.id }'>
				<input type="hidden" class='phone' value='${user.phone }'>
				<input type="hidden" class='user_password' value='${user.user_password }'>
				<img src="../../img/${user.head_sculpture }" class="tx">
				<ul id="user_muem_item">
					<li class="z">${user.user_nickname }</li>
						
					<li class="z">交易管理</li>
					<li class="s"><a href="#">我的订单</a></li>
					<!-- <li class="s"><a href="tksh.jsp">退款/售后</a></li> -->

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
</body>
</html>