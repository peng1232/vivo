<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<DOCTYPE html>
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
            <a href="grzx.html"><img class="arrow" src="../../img/向右箭头.png" alt="../../右箭头">个人中心</a>
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
					<li data-a-3  class="li1">全部订单</li>
					<li class="li1">待付款</li>
					<li class="li1">待收货</li>
					<li class="li1">已完成</li>
					<li class="li1">已关闭</li>
				</ul>
				<div class="da">
					<div class="div1">
						<div  class="col col1">商品</div>
						<div  class="clo col2">数量</div>
						<div class="clo col3">价格</div>
						<div class="col col4">商品操作</div>
						<div class="col col5">状态</div>
						<div  class="col col6">操作</div>
					</div>
					<div>
						<div class="head">
							<div class="leftt">订单号:
							<a class="link">1561895618456</a></div>
							<div class="middle">成交时间: 2024-04-01 08:13:42</div>
							<div class="rightt">删除订单</div>
						</div>
						
						<div class="mian" > <img src="../../img/头像.jpg" class="sj">
							<div class="left_1">
								<div class="order-item">
									<div class="order-wrap">
										<div class="order-item-left"></div>
										<div class="order-item-right">
											<div class="top">
												<div class="name">
													<a class="link"> vivo X Fold3 Pro 16GB+512GB</a></div>
													<div class="num">10</div>
													<div class="price"><span>100</span></div>
											</div>
										</div>
											<div class="sole-action"></div>
											<div class="middle_1">已取消</div>
											<div class="aa"><div class="zuihou">查看订单</div></div>
									</div>
								</div>
							</div>
						</div>
					
						
						
						<div class="container_1 clearfix">
							
							<div class="left_2">应付金额:<span class="span_2">4999</span>
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

<%@include file="../../html/footer.jsp" %>
</body>
</html>