<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加购物车</title>
<link rel="icon name" href="../../img/favicon.ico" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<link href="../../css/nav.css" rel="stylesheet"/>
<link href="../../css/cartAddSuccess.css" rel="stylesheet"/>
<script src="../../js/nav.js"></script>
<link href="../../css/footer.css" rel="stylesheet" />
</head>
<body>
	<%@include file="../../html/nav.jsp" %>
	
	<!-- 内容体 -->
	<div class='content clearfix'>
		<div class='wrapper'>
			<div class='add_success_container'>
				<div class='add_success_title'>
					<img src='../../img/product/dagou.png'/>
					<span>商品已经成功添加到购物车！</span>
				</div>
				<div class='add_success-_ontent clearfix'>
					<div class='product_info'>
						<div class='product_img'>
							<img src='../../img/product/${product.image_url }'/>
						</div>
						<div class='product_des'>
							<div class='product_name'>${product.products_name } ${product.pagTtype }${product.color }</div>
							<div class='product_tag'>颜色：${product.color }</div>
							<div class='product_tag'>版本：${product.pagTtype }</div>
							<div class='product_tag'>数量：${shopping.quantity }</div>
						</div>
					</div>
					<div class='product_action'>
						<a href='XianXiSerlvet?id=${product.id }'>
							<button class='btn shop'>查看商品详情</button>
						</a>
						<a href='#'>
							<button class='btn go'>去购物车结算</button>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="../../html/footer.jsp" %>
</body>
</html>