<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript" src="../../js/jquery.min.js"></script>
<link href="../../css/nav.css" rel="stylesheet"/>
<script src="../../js/nav.js"></script>
<link href="../../css/footer.css" rel="stylesheet" />
<link href="../../css/shoucang.css" rel="stylesheet" />
</body>
<%@include file="../../html/nav.jsp" %>
	  <div class="container">
        <div class="menu">
            <a href="商城首页.html">商城首页</a>
            <a href="grzx.html"><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a>
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
				<div class="div1">我的收藏</div>
					<div class="div2">
						<table>
						<thead class="thead1">
							<th class="img"></th>
							<th class="mingzi">商品名称</th>
							<th class="jinge">价格</th>
							<th class="scshijian">收藏时间</th>
							<th class="spzhuangtai">商品状态</th>
							<th class="caozuo">操作</th>
						</thead>
						
						<tbody class="tbody">
							<tr>
								<td><img src="../../img/vivo x100.webp" class="tp"></td>
								<td><a>vivo x100Pro 16G+256G <br />白白白白</a></td>
								<td><a class="a1">￥4999</a></td>
								<td><a class="a1">2024-3-15 08:12:00</a></td>
								<td><a class="a1">有货</a></td>
								<td><a class="a2">购买</a>
									<a class="a1">删除</a>
								</td>
							</tr>
						</tbody>
						
						<tbody class="tbody">
							<tr class="tr2">
								<td><img src="../../img/vivo x100.webp" class="tp"></td>
								<td><a>vivo x100Pro 16G+256G <br />白白白白</a></td>
								<td><a class="a1">￥4999</a></td>
								<td><a class="a1">2024-3-15 08:12:00</a></td>
								<td><a class="a1">有货</a></td>
								<td><a class="a2">购买</a>
									<a class="a1">删除</a>
								</td>
							</tr>
						</tbody>
						</table>
					</div>
					
					</div>
			</div>
		</div>

		<c:if test="${empty collection }">
			<script type="text/javascript">
				location.href= 'CollectionInitServlet';
			</script>
		</c:if>
<%@include file="../../html/footer.jsp" %>

</html>