<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<link href="../../css/nav.css" rel="stylesheet" />
<script src="../../js/nav.js"></script>
<link href="../../css/footer.css" rel="stylesheet" />
<link href="../../css/dingdang.css" rel="stylesheet" />
</head>
<body>
	<%@include file="../../html/nav.jsp"%>

	<div class="container">
		<div class="menu">
			<a href="商城首页.html">商城首页</a> <a href="grzx.html">
			<a href="grzx.jsp"><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a>
			<a href=""><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">退款/售后</a>
		</div>
		<div class="under">
			<div class="left">
				<img src="../../img/头像.jpg" class="tx">
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
				<dl data-a-1 class="order-list">
					<dt data-a-1 class="module-title">我的订单</dt>
					<ul data-a-1 data-a-2 class="ul1 clearfix">
						<li data-a-3 class="li1">全部订单</li>
						<li class="li1">待付款</li>
						<li class="li1">待收货</li>
						<li class="li1">已完成</li>
						<li class="li1">已关闭</li>
					</ul>
					<div class="da">
						<div class="div1">
							<div class="col col1">商品</div>
							<div class="clo col2">数量</div>
							<div class="clo col3">价格</div>
							<div class="col col4">商品操作</div>
							<div class="col col5">状态</div>
							<div class="col col6">操作</div>
						</div>
						<div>
						${product[1] }
							<input type="hidden" class='user_id' value='${user.id }'>
							<c:forEach items="${ordersList}" var="orders" varStatus="va">
								<div class="head">
									<div class="leftt">
										订单号: <a class="link">${orders.order_number}</a>
									</div>
									<div class="middle">成交时间:${orders.order_time}</div>
									<div class="rightt">删除订单</div>
								</div>
								<c:forEach items="${details[va.index]}" var="item" varStatus="a">
									<div class="mian">
										<c:forEach items="${product[a.index]}" var="items">
											<img src="../../img/${items.image_url }" class="sj">
										<div class="left_1">
											<div class="order-item">
												<div class="order-wrap">
													<div class="order-item-left"></div>
													<div class="order-item-right">
														<div class="top">
															<div class="name">
																<a class="link"> vivo ${items.products_name } ${items.pagTtype }  ${items.color }</a>
															</div>
															<div class="num">${items.hits }  </div>
															<div class="price">
																<span>${items.price }</span>
															</div>
														</div>
													</div>
													<div class="sole-action"></div>
													<div class="middle_1">${orders.state}</div>
													<div class="aa">
														<div class="zuihou">查看订单</div>
													</div>
												</div>
											</div>
										</div>
										</c:forEach>
									</div>
								</c:forEach>
							</c:forEach>


							<div class="container_1 clearfix">

								<div class="left_2">
									应付金额:<span class="span_2">4999</span>
									<div class='right_2'>立即支付</div>
								</div>

							</div>



						</div>

					</div>
				</dl>
			</div>
		</div>
	</div>
	</div>
	<c:if test="${user==null }">
		<script type="text/javascript">
			location.href = '../login/login.jsp'
		</script>
	</c:if>
	<c:if test="${ordersList==null }">
		<script type="text/javascript">
			$(function() {
				var user_id = $('.user_id').val();
				location.href = 'ordersServlet?user_id=' + user_id;
			})
		</script>
	</c:if>
	<%@include file="../../html/footer.jsp"%>
</body>
</html>