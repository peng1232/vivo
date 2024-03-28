<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<link href="../../css/nav.css" rel="stylesheet"/>
<script src="../../js/nav.js"></script>
<link href="../../css/footer.css" rel="stylesheet" />
<link href="../../css/dingdang.css" rel="stylesheet" />
</head>
<body>
<%@include file="../../html/nav.jsp" %>

<div class="container">
        <div class="menu">
            <a href="商城首页.html">商城首页</a>
            <a href="grzx.html"><img class="arrow" src="img/向右箭头.png" alt="右箭头">个人中心</a>
        </div>
		<div class="under">
			<div class="left">
				<img src="img/头像.jpg" class="tx">
				<ul>
					<li class="z">vivo34177786273</li>
					
					<li class="z">交易管理</li>
					<li class="s"><a href="">我的订单</a></li>
					<li class="s"><a href="tksh.html">退款/售后</a></li>

					<li class="z">评价管理</li>
					<li class="s"><a href="">评价晒单</a></li>
					
					<li class="z">我的账户</li>
					<li class="s"><a href="">修改密码</a></li>
					<li class="s"><a href="">修改电话号码</a></li>
					<li class="s"><a href="">个人资料</a></li>
					<li class="s"><a href="">收货地址</a></li>
					<li class="s"><a href="">我的收藏</a></li>
				</ul>
			</div>
			<div class="right">
				<div class="div1">我的订单</div>
				<div class="div2">
					<ul class="ul1">
						<li class="li1"><a class="a1">全部订单</a></li>
						<li class="li1"><a class="a1">待付款</a></li>
						<li class="li1"><a class="a1">待收货</a></li>
						<li class="li1"><a class="a1">已完成</a></li>
						<li class="li1"><a class="a1">已关闭</a></li>	
					</ul>
					</div>
					<div class="div3">
						<ul class="ul2">
							<li class="li2">
								<a class="a2">商品</a>
								<a class="a3">型号</a>
								<a class="a4">数量</a>
								<a class="a3">价格</a>
								<a class="a3">状态</a>
								<a class="a5">操作</a>
							</li>
						</ul>
					</div>
					<div class="div4">
						<ul class="ul3">
							<li class="li3">
								<a class="q1">订单编号号:1231231232</a>
								<a class="q2">成交时间:2024-03-18 11:12:00</a>
								<img src="img/垃圾桶.png" class="sc">
								<a class="q3">删除</a>
							</li>
						</ul>
					</div>
					<div class="div5">
					 <table>
					        <tr>
					            <th class="th1"><img src="img/vivo.webp" class="sj"></th>
					            <th class="th2"><a class="xinhao"> x100Pro</a>
												<a class="shuliang">1</a>
												<a class="jiage">5498</a>
								</th>
								<th class="th3"><a class="a9">待支付</a></th>
								<th class="th3"><a class="a7">查看订单</a></th>
					        </tr>
					        <tr>
					            <th class="th1"><img src="img/vivo.webp" class="sj"></th>
					            <th class="th2"><a class="xinhao"> x100Pro</a>
					            				<a class="shuliang">1</a>
					            				<a class="jiage">5498</a>
					            </th>
					          <th class="th3"><a class="a9">待支付</a></th>
					            <th class="th3"><a class="a7">查看订单</a></th>
					        </tr>
							
							<tr>
							    <th class="th1"><img src="img/vivo.webp" class="sj"></th>
							    <th class="th2"><a class="xinhao"> x100Pro</a>
												<a class="shuliang">1</a>
												<a class="jiage">5498</a>
								</th>
								<th class="th3"><a class="a9">待支付</a></th>
								<th class="th3"><a class="a7">查看订单</a></th>
							</tr>
							
							<tr>
							    <th class="th1"><img src="img/vivo x100.webp"" class="sj"></th>
							    <th class="th2"><a class="xinhao"> x100Pro</a>
												<a class="shuliang">1</a>
												<a class="jiage">5498</a>
								</th>
								<th class="th3"><a class="a9">待支付</a></th>
								<th class="th3"><a class="a7">查看订单</a></th>
							</tr>
							
							
					    </table>
						<div class="div6">
							<span class="span1">应付总金额:</span>
							<a class="a8">4999</a>
							<a class="ljzf">立即支付</a>
						</div>
						</div>
					</div>
			</div>
		</div>
    </div>

<%@include file="../../html/footer.jsp" %>
</body>
</html>