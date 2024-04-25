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
<link href="../../css/dindan.css" rel="stylesheet" />
</head>
<body>
	<%@include file="../../html/nav.jsp"%>
	<div class="container">
		<div class="menu">
			<a href="../qian/shouye.jsp">商城首页</a> <a href="grzx.html">
			<a href="../../jsp/gereng/grzx.jsp"><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a>
			<a href=""><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">我的订单</a>
		</div>
		<div class="under">
			<%@include file="../../jsp/gereng/zxzuo.jsp" %>
			<div class="right">
				<input type="hidden" class='user_id' value='${user.id }'>
				<dl data-a-1 class="order-list">
					<dt data-a-1 class="module-title">我的订单</dt>
					<ul class="ul1 clearfix">
						<li id="qbdd" class="li1">全部订单</li>
						<li id="pendingPaymentTab" class="li1">未付款</li>
						<li id="dsh" class="li1">待收货</li>
						<li id="ycw" class="li1">已完成</li>
						<li id="ygb" class="li1">已关闭</li>
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
									<c:choose>
										<c:when test="${orders.state == 2}">
											<div class="middlee">未付款</div>
				
										</c:when>
										<c:when test="${orders.state == 3}">
											<div class="middlee">已关闭</div>
										</c:when>
										<c:when test="${orders.state == 7}">
											<div class="middlee">已完成</div>
										</c:when>
										<c:otherwise>
											<div class="middlee">其他状态</div>
										</c:otherwise>
									</c:choose>
									<div class="right_11">查看订单</div>
								</div>
							</div>

						</c:forEach>
						<!-- <div class="footers clearfix">
							<div class="container_1">
								<div class="wei">
									应付金额: <span class="span_1">499999</span>
								</div>
							</div>
						</div> -->
					</div>
				</dl>
			</div>
		</div>
	</div>

	<script type="text/javascript">
    // 获取标签元素
    var allOrdersTab = document.getElementById("qbdd");
    var pendingReceiptTab = document.getElementById("dsh");
    var completedTab = document.getElementById("ycw");
    var closedTab = document.getElementById("ygb");
    var pendingPaymentTab = document.getElementById("pendingPaymentTab");

    // 监听标签的点击事件
    allOrdersTab.addEventListener("click", showAllOrders);
    pendingReceiptTab.addEventListener("click", showPendingReceiptOrders);
    completedTab.addEventListener("click", showCompletedOrders);
    closedTab.addEventListener("click", showClosedOrders);
    pendingPaymentTab.addEventListener("click", showPendingPaymentOrders);

    // 显示全部订单
    function showAllOrders() {
        var allOrders = document.querySelectorAll(".div2");
        allOrders.forEach(function(order) {
            order.style.display = "block";
        });
    }

    // 显示待收货订单
    function showPendingReceiptOrders() {
        var pendingReceiptOrders = document.querySelectorAll(".middlee");
        pendingReceiptOrders.forEach(function(order) {
            if (order.textContent.trim() === "待收货") {
                order.closest(".div2").style.display = "block";
            } else {
                order.closest(".div2").style.display = "none";
            }
        });
    }

    // 显示已完成订单
    function showCompletedOrders() {
        var completedOrders = document.querySelectorAll(".middlee");
        completedOrders.forEach(function(order) {
            if (order.textContent.trim() === "已完成") {
                order.closest(".div2").style.display = "block";
            } else {
                order.closest(".div2").style.display = "none";
            }
        });
    }

    // 显示已关闭订单
    function showClosedOrders() {
        var closedOrders = document.querySelectorAll(".middlee");
        closedOrders.forEach(function(order) {
            if (order.textContent.trim() === "已关闭") {
                order.closest(".div2").style.display = "block";
            } else {
                order.closest(".div2").style.display = "none";
            }
        });
    }

    // 显示未付款订单
    function showPendingPaymentOrders() {
        var pendingPaymentOrders = document.querySelectorAll(".middlee");
        pendingPaymentOrders.forEach(function(order) {
            if (order.textContent.trim() === "未付款") {
                order.closest(".div2").style.display = "block";
            } else {
                order.closest(".div2").style.display = "none";
            }
        });
    }
</script>
	


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