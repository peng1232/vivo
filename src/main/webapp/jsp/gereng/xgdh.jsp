<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>电话修改</title>
<link rel="icon name" href="../../img/favicon.ico" />
<link href="../../css/grzx.css" rel="stylesheet" />
<link href="../../css/nav.css" rel="stylesheet" />
<link href="../../css/footer.css" rel="stylesheet" />
<link href="../../css/zhuce.css" rel="stylesheet"/>
<script src="../../js/zhece.js"></script>
<script src="../../js/jquery.min.js"/></script>
<script src="../../js/nav.js"></script>
</head>
<body>
<%@include file="../../html/nav.jsp" %>
		<div class="container">
			<div class="menu">
				<a href="商城首页.html">商城首页</a>
				<a href="grzx.jsp"><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a>
				<a href=""><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">修改电话号码</a>
			</div>
			<div class="under">
				<div class="left">
					<img src="../../img/h.jpeg" class="tx">
					<ul id="user_muem_item">
						<li class="z">vivo34177786273</li>
						
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
					<div class="content">
					<div class="logo">
						</div>
						<div class="title_p">电话修改</div>
						<form action="" method="post" id="sub">
							<div class="form_item">
								<input required class="inp" name='phone' type="text"/>
								<span class="bar"></span>
								<label for="username">输入旧手机号</label>
							</div>
							<div class="tishi shou"></div>
							<div class="form_item">
								<input maxlength="6" required class="inp" type="text"/>
								<span class="bar"></span>
								<label for="username">验证码</label>
								<div class="yzm">
									<span class="feng"></span>
									<span id="huoqu">获取验证码</span>
								</div>
							</div>
							<div class="tishi yang"></div>
							<div class="form_item">
								<input required class="inp" name='phone' type="text"/>
								<span class="bar"></span>
								<label for="username">输入新手机号</label>
							</div>
							<div class="tishi mi"></div>
							<!-- 修改 -->
							<div id="zhuce" class="btn">确认</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<%@include file="../../html/footer.jsp" %>
</body>
</html>