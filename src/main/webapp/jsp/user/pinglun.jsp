<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link href="../../css/pinglun.css" rel="stylesheet" />
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
				<div class="div1">我的评论</div>
				
					<div class="div2">
						<table>
						<thead class="thead1">
							
							<th class="xuhao">序号</th>
							<th class="yonghumingcheng">用户名称</th>
							<th class="wodepinglun">我的评论</th>
							<th class="mingzi">商品</th>
							<th class="spzhuangtai">状态</th>
							<th class="caozuo">评论等级</th>
						</thead>
						
						<tbody class="tbody">
							<c:forEach items="${commentsList}" var="comment">
						            <tr>
						                <td><a class="a1">${comment.id}</a></td>
						                <td><a class="a1">${comment.user_id}</a></td>
						                <td><a class="a1">${comment.user_com}</a></td>
						                <td><a class="a1">${comment.product_id}</a></td>
						                <td><a class="a1">${comment.state}</a></td>
						                <td><a class="a1">${comment.com_grade}</a></td>
						            </tr>
					      	  </c:forEach>
						</tbody>
						</table>
						
					</div>
					
					</div>
			</div>
		</div>
		
		
	<%@include file="../../html/footer.jsp" %>
	<c:if test="${commentsList==null}">
	
    	<script type="text/javascript">
    		location.href = "CommentsServlet?id=${user.id}";
    	</script>
    </c:if>
</html>