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
			<a href="商城首页.html">商城首页</a>
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
					<div class="zjll">热门商品</div> 
						<div class='wrapper'>
						<ul class='floor-list'>
							<!-- 热门商品 -->
							<li class='floor xiao'>
								<ul class='box-list'>
									<c:forEach items="${hits }" var="item">
										<li class='box'>
											<a href="../qian/XianXiSerlvet?id=${item.id }" target="_blank">
												<img src="../../img/product/${ item.image_url}?id=${item.id }"/>
											</a>
											<div class='prodinfo'>
												<p class='name'>${item.products_name }</p>
												<p class='feature'>${item.description }</p>
												<p class='price rmb-symbol'>￥ ${item.price }</p>
											</div>
										</li>
									</c:forEach>
								</ul>
							</li>
						</ul>
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