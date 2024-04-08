<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>vivo ${product.products_name }</title>
<link rel="icon name" href="../../img/favicon.ico" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<link href="../../css/nav.css" rel="stylesheet"/>
<link href="../../css/xianxi.css" rel="stylesheet"/>
<script src="../../js/nav.js"></script>
<script src="../../js/xianxi.js"></script>
<link href="../../css/footer.css" rel="stylesheet" />
</head>
<body>
	<%@include file="../../html/nav.jsp" %>
	
	<!-- 内容体 -->
	<div id='content' class='clearfix'>
		<!-- 头 -->
		<div class='crumbs'>
			<div class='section_wrapper'>
				<a href='shouye.jsp' class='first'>商城首页</a>
				<svg t="1712546482937" class="icon jian" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4256" width="16" height="16"><path d="M347.687 144.188l-52.761 52.238 313.928 316.082-316.568 313.42 52.314 52.673 369.322-365.663z" fill="#999999" p-id="4257"></path></svg>
				<span class='p_name'>${product.products_name }</span>
			</div>
		</div>	
		<!-- 内容 -->
		<div class='base-info'>
			<div class='base-info_container clearfix'>
				<div class='base_left'></div>
				<div class='base_right'>
					<h1 class='name'>${product.products_name }</h1>
					<p class='intro'>${product.description }</p>
					<div class='summary'>
						<div class='summary_price'>
							<p class='sale-price'>￥2399.00(si)</p>
						</div>
						<div class='summary_activity'>
							<ul class='list'>
								<li class='list_item'>
									<span class='lable'>赠品</span>
									<p>有贴纸</p>
								</li>
								<li class='list_item'>
									<span class='lable'>定制</span>
									<p>免费定制服务</p>
								</li>
								<li class='list_item'>
									<span class='lable'>积分</span>
									<p>购物送积分</p>
								</li>
							</ul>
						</div>
					</div>
					<dl>
						<c:forEach items="${Specifications }" varStatus="index" var="item">
							<dt class='sku-module_title'>${ item.specifications_name}</dt>
							<dd class='sku-module_content'>
								<ul class='list_item'>
									<c:forEach items="${value[index.index] }" var="va" varStatus="x">
										<li class="sku-module_item ${x.index==0?'sku_checked': ''}">${va.value }</li>
									</c:forEach>
								</ul>
							</dd>
						</c:forEach>
					</dl>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="../../html/footer.jsp" %>
</body>
</html>