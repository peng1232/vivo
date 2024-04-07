<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<link rel="icon name" href="../../img/favicon.ico" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<link href="../../css/shouye.css " rel="stylesheet" />
<script src="../../js/LoopSlider.js"></script>
<script src="../../js/shouye.js"></script>
<link href="../../css/nav.css" rel="stylesheet"/>
<script src="../../js/nav.js"></script>
<link href="../../css/footer.css" rel="stylesheet" />
</head>
<body>
	<%@include file="../../html/nav.jsp" %>
	<!-- 轮播 -->
	<div class="lun">
		<div class="lunbo clearfix">
			<img src="../../img/lun/lun1.png">
			<img src="../../img/lun/lun3.png">
			<img src="../../img/lun/lun2.jpg">
			<img src="https://www.jq22.com/img/cs/500x300-4.png">
		</div>
	</div>
	
	<!-- 内容区 -->
	<div class='wrapper'>
		<ul class='floor-list'>
			<!-- 推荐商品 -->
			<li class='floor'>
				<div class='info'>
					<p class='subject'>推荐商品</p>
				</div>
				<ul class='box-list'>
					<li class='box'>
						<a href="#" target="_blank">
							<img src='../../../img/product/X Fold3 Pro.png'/>
						</a>
						<div class='prodinfo'>
							<p class='name'>iQOO Neo8</p>
							<p class='feature'>自研芯片</p>
							<p class='price rmb-symbol'>￥ 2299.00</p>
						</div>
					</li>
					
				</ul>
			</li>
			<!-- 热门商品 -->
			
		</ul>
	</div>
	<%@include file="../../html/footer.jsp" %>
	
	<c:if test="${product==null }">
		<script>
		</script>
	</c:if>
</body>
</html>