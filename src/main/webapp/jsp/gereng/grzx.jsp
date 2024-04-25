<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.entity.User_product_footprint" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人中心</title>
<link rel="icon name" href="../../img/favicon.ico" />
<link href="../../css/grzx.css" rel="stylesheet" />
<link href="../../css/nav.css" rel="stylesheet" />
<link href="../../css/footer.css" rel="stylesheet" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script src="../../js/nav.js"></script>
<link href="../../css/grzxrmsp.css " rel="stylesheet" />
<link href="../../css/dindan.css" rel="stylesheet" />

<style>

</style>
<script>
    function updateLoginTime() {
        var currentTime = new Date();
        var year = currentTime.getFullYear();
        var month = currentTime.getMonth() + 1;
        var day = currentTime.getDate();
        var hours = currentTime.getHours();
        var minutes = currentTime.getMinutes();
        var seconds = currentTime.getSeconds();
        var formattedTime = year + '-' + month + '-' + day + ' ' + hours + ':' + minutes + ':' + seconds;
        // 保存登录时间到本地存储
        localStorage.setItem('lastLoginTime', formattedTime);

        // 更新页面显示的登录时间
        document.getElementById('loginTime').textContent = formattedTime;
    }

    window.onload = function() {
        // 页面加载时从本地存储获取登录时间
        var lastLoginTime = localStorage.getItem('lastLoginTime');
        if (lastLoginTime) {
            document.getElementById('loginTime').textContent = lastLoginTime;
        } else {
            updateLoginTime(); // 如果没有保存的登录时间，则更新时间并保存
        }
    };
</script>

</head>
<body>
<%@include file="../../html/nav.jsp" %>
	<div class="container">
		<div class="menu">
			<a href="../qian/shouye.jsp">商城首页</a>
			<a href="grzx.jsp"><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a>
		</div>
		<div class="under">
			<%@include file="zxzuo.jsp" %>
			<div class="right">
				<div>
					<div class="jrgrzx">您好，${user.user_nickname }，欢迎进入个人中心！</div>
					<br>
					<span class="dlsj"> 最近一次登录时间：<span id="loginTime"></span>
					<br>
					<span class="xang">————————————————————————————————————————————————————</span>
				</div>
				<br>
				<div>
					<ul>
						<li class="item">未付款订单<a>0</a></li>
					</ul>
					<ul>
						<li class="item eee ">评论和回复<a>0</a></li>
					</ul>
				</div>
				<div class="zjdd">最近的订单</div>
				 
				<div>
				
										<div class="da">
						<div class="div1">
							<div class="col col1">商品</div>
							<div class="clo col2">数量</div>
							<div class="clo col3">价格</div>
							<div class="col col4">商品操作</div>
							<div class="col col5">状态</div>
							<div class="col col6">操作</div>
						</div>
						<c:forEach items="${ordersList}" var="orders" varStatus="va">

							<div class="div2">
								<div class="head">
									<div class="leftt">
										订单号: <a class="link">${orders.order_number}</a>
									</div>
									<div class="middle">成交时间: ${orders.order_time}</div>
									<div class="rightt">删除订单</div>
								</div>
									<div class="mian">
									<div class="left_1">
										<c:forEach items="${product[va.index]}" var="items">
											<div class="order-item">
												<div class="order-wrap">
													<div class="order-item-left">
														<a><img src="../../img/${items.image_url }" class="tp"></a>
													</div>
													<div class="order-item-right">
														<div class="top">
															<div class="name">
																<a>vivo ${items.products_name } ${items.pagTtype }  ${items.color }</a>
															</div>
															<div class="num">${items.hits }</div>
															<div class="price">${items.price }</div>
														</div>
													</div>
													<div class="sole-action"></div>
												</div>
											</div>
										</c:forEach>
									</div>
									<div class="middlee">已取消</div>
									<div class="right_11">查看订单</div>
								</div>
							</div>

						</c:forEach>
						<div class="footers clearfix">
							<div class="container_1">
								<div class="wei">
									应付金额: <span class="span_1">499999</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<%@include file="../../html/footer.jsp" %>
	<c:if test="${product==null }">
		<script>
			location.href="remenServlet";
		</script>
	</c:if>
</body>
</html>