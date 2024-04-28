<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<link rel="icon name" href="../../img/favicon.ico" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<link href="../../css/nav.css" rel="stylesheet" />
<script src="../../js/nav.js"></script>
<link href="../../css/footer.css" rel="stylesheet" />
<link href="../../css/dindan.css" rel="stylesheet" />
<script src="../../js/hou/modal.js"></script>
<link rel="stylesheet" href="../../css/hou/modal.css">
</head>
<body>
	<%@include file="../../html/nav.jsp"%>
	<div class="container">
		<div class="menu">
			<a href="../qian/shouye.jsp">商城首页</a> <a
				href="../../jsp/gereng/grzx.jsp"><img class="arrow"
				src="../../img/向右箭头.png" alt="右箭头">个人中心</a> <a href=""><img
				class="arrow" src="../../img/向右箭头.png" alt="右箭头">我的订单</a>
		</div>
		<div class="under">
			<%@include file="../../html/zxzuo.jsp"%>
			<div class="right">
				<input type="hidden" class='user_id' value='${user.id }'>
				<dl data-a-1 class="order-list">
					<dt data-a-1 class="module-title">我的订单</dt>
					<ul class="ul1 clearfix">
						<li id="qbdd" class="li1">全部订单</li>
						<li id="pendingPaymentTab" class="li1">未付款</li>
						<li id="dsh" class="li1">已付款</li>
						<li id="ycw" class="li1">已完成</li>
						<li id="ygb" style='display: none;' class="li1">已关闭</li>
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
									<div class="rightt del" order=${orders.order_number }>删除订单</div>
								</div>
								<div class="mian">
									<div class="left_1">
										<c:forEach items="${product[va.index]}" var="items">
											<div class="order-item" product_id='${items.id}'>
												<div class="order-wrap">
													<div class="order-item-left">
														<a><img src="../../img/product/${items.image_url }" class="tp"></a>
													</div>
													<div class="order-item-right">
														<div class="top">
															<div class="name">
																<a>vivo ${items.products_name } ${items.pagTtype }
																	${items.color }</a>
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


											<div class="right_11">
												<span>查看订单</span> <span id="fukuang"
													num='${orders.order_number}'>付款</span>
											</div>
										</c:when>
										<c:when test="${orders.state == 1}">
											<div class="middlee">已付款</div>
											<div class="right_11">
												<span>查看订单</span> <span id='quer'
													num='${orders.order_number}'>确认收货</span>
											</div>
										</c:when>
										<c:when test="${orders.state == 3}">
											<div class="middlee">已关闭</div>
											<div class="right_11">查看订单</div>
										</c:when>

										<c:when test="${orders.state == 7}">
											<div class="middlee">已完成</div>
											<div class="right_11">
												<span>查看订单</span> <span class="qpx" >去评论</span>
											</div>
										</c:when>
										<c:otherwise>
											<div class="middlee">其他状态</div>
											<div class="right_11">查看订单</div>
										</c:otherwise>

									</c:choose>


									<!-- <div class="right_11">查看订单</div> -->
								</div>
							</div>
						</c:forEach>
					</div>
				</dl>
			</div>
		</div>
	</div>

		<div class="message">
						<div class="zhe"></div>
						<div class="message_box">
							<div class="message_box_head">
								<span>我的评论</span>
								<svg class="guan" t="1710744510048" class="icon" viewBox="0 0 1024 1024" version="1.1"
									xmlns="http://www.w3.org/2000/svg" p-id="7727" width="16" height="16">
									<path
										d="M590.7456 508.416 1016.832 934.5024 938.0864 1009.664 512 583.5776 78.7456 1024 0 941.6704l433.2544-440.4224L7.168 75.1616 85.9136 0 512 426.0864 938.0864 0 1016.832 82.3296 590.7456 508.416z"
										p-id="7728" fill="#242933"></path>
								</svg>
							</div>
							<div class="item_1">
				<textarea class='com' rows="7" cols="70"></textarea>
			</div>
							<div class="item_1">

								<ul class="rating">
								    <li class='active'>★</li>
								    <li class='active'>★</li>
								    <li class='active'>★</li>
								    <li class='active'>★</li>
								    <li class='active'>★</li>
								</ul>
							</div>
							<div class="message_box_footer">
								<button id='ping'>确认评论</button>
							</div>
						</div>
					</div>

	<script>
						<!-- 弹窗 -->
				$(function(){
					var product_id ;
					$('.qpx').click(function(){
						kai();
						product_id = $(this).parent().parent().find('.order-item').eq(0).attr('product_id');
					})
					//弹窗点击时间
					$('#ping').click(function(){
						var context = $('.com').val().trim();
						var user_id = $('.user_id').attr('value')
						var com_grade = $('.active').length;
						$.getJSON('CommentsInsertServlet',{
							'user_id':user_id,
							'user_com':context,
							'product_id':product_id,
							'com_grade':com_grade
						},function(){
							location.reload();
						})
					})
					$('.zhe').click(function(){
						guanbi();
					})
					$('.guan').click(function(){
						guanbi();
					})
					//开启弹窗
					function kai(){
						$('body').css('overflow-x',"hidden").css("overflow-y",'hidden')
						$('.message').css('display','block');
						$(".zhe").animate({
							opacity: 0.6
						},100)
						$('.message_box').css('transform','scale(1) translateY(0%)');
					}
					
					//关闭弹窗
					function guanbi(){
						$('body').css('overflow-x',"auto").css("overflow-y",'auto')
						$(".zhe").animate({
							opacity: 0
						},100)
						$('.message_box').css('transform','scale(0) translateY(-100%)');
						setTimeout(function(){
							$('.message').css('display','none');
						},300)
						
					}
				})
				
			</script>

	<!-- 星星 -->
	<script>
					    const stars = document.querySelectorAll('.rating li');
					    stars.forEach((star, index) => {
					        star.addEventListener('click', () => {
					            stars.forEach((s, i) => {
					                if (i <= index) {
					                    s.classList.add('active');
					                } else {
					                    s.classList.remove('active');
					                }
					            });
					        });
					    });
					</script>

	<script type="text/javascript">
    	$(function(){
    		$('.del').click(function(){
    			var num = $(this).attr('order');
    			var mModal1 = new mModal({
    				top: "30vh",
    				width: "30%",
    				title: "新增商品价格",
    				content: "<p>确认要删除此订单吗</p>",
    				confirm: function() {
    					$.getJSON('OrederDeleteServlet',{'number':num},function(){
    	    				location.reload();
    	    			})
    					mModal1.close();
    				},
    			});
    			mModal1.renderDom();
    		})
    		
    		$('#fukuang').click(function(){
    			var num = $(this).attr('num');
    			var state = 1;
    			$.getJSON('OrederUpdaateServlet',{'number':num,'state':state},function(){
    				location.reload();
    			})
    		})

    		$('#quer').click(function(){
    			var num = $(this).attr('num');
    			var state = 7;
    			var mModal1 = new mModal({
    				top: "30vh",
    				width: "30%",
    				title: "新增商品价格",
    				content: "<p>确认要收货吗</p>",
    				confirm: function() {
    					$.getJSON('OrederUpdaateServlet',{'number':num,'state':state},function(){
    	    				location.reload();
    	    			})
    					mModal1.close();
    				},
    			});
    			mModal1.renderDom();
    			
    		})
    	})
    </script>
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
            if (order.textContent.trim() === "已付款") {
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