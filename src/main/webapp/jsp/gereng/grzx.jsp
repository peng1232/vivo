
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.entity.User_product_footprint" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

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

.tt {
    text-align: center;
    padding: 160px 0;
}
.t {
    text-align: center;
    padding: 90px 0;
}
.t {
    width: 151px;
    height: 138px;
    background: url(https://shopstatic.vivo.com.cn/vivoshop/spaweb/static/img/no-order-icon.0f9eeb2f.png) no-repeat 50%;
}
</style>


</head>
<body>
<%@include file="../../html/nav.jsp" %>
	<div class="container">
		<div class="menu">
			<a href="../qian/shouye.jsp">商城首页</a>
			<a href="grzx.jsp"><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a>
		</div>
		<div class="under">
			<%@include file="zxzuo.jsp" %>
			<div class="right">
				<div>
					<div class="jrgrzx">您好，${user.user_nickname }，欢迎进入个人中心！</div>
					<br>
					<!--  --><span class="dlsj">最近一次登录时间：
				        <c:if test="${lastLoginTime != null}">
				            ${lastLoginTime}
				        </c:if>
				        <c:if test="${lastLoginTime == null}">
				            无法获取最近登录时间
				        </c:if>
				    </span>
					<br>
					<span class="xang">————————————————————————————————————————————————————</span>
				</div>
				<br>
				<div>
					<ul>
						<li class="item">未付款订单<a>${unpaidOrdersCount}</a></li>
				    </ul>
					<ul>
						<li class="item eee ">评论和回复<a>${unpaidcommentsCount}</a></li>
					</ul>
				</div>
				<div>
					<div class="zjdd">最近的订单</div> 
					<c:if test="${ fn:length(Orders)==0}" var="fla">
						<div  class="t">
							<i class="t"></i>
							<div class="tt">您还没有订单</div>
						</div>
					</c:if>
					<c:if test="${!fla }">
						<table>
				        	<div style="margin-top: 20px;">
					            <thead>
					                <tr class="list-caption">
					                    <th class="col0">订单号</th>
					                    <th class="col1">金额</th>
					                    <th class="col2">下单日期</th>
					                    <th class="col3">状态</th>
					                </tr>
					            </thead>
					            <c:forEach items="${ Orders}" var="item" varStatus="va">
					       		   <tr class="list-caption">
					                    <td class="col0">${item.order_number }</td>
					                    <td class="col1">${price[va.index] }</td>
					                    <td class="col2">
					                    <fmt:formatDate value="${item.order_time }" pattern="yyyy-MM-dd HH:mm:ss" var="formattedDate" />${ formattedDate}
					                    </td>
					                   <c:choose>
										    <c:when test="${item.state == 1}">
										        <td class="col3">已付款</td>
										    </c:when>
										    <c:when test="${item.state == 2}">
										        <td class="col3">未付款</td>
										    </c:when>
										    <c:when test="${item.state == 3}">
										        <td class="col3">已收货</td>
										    </c:when>
										    <c:when test="${item.state == 7}">
										        <td class="col3">已完成</td>
										    </c:when>
										</c:choose>
					                </tr>
					            </c:forEach>
				            </div>	
				        </table>
					</c:if>
			      
					
				</div>
				
			</div>
		</div>
	</div>
<%@include file="../../html/footer.jsp" %>
	<c:if test="${user==null }">
		<script>
			location.href="../login/login.jsp";
		</script>
	</c:if>
	<c:if test="${product==null }">
		<script>
			location.href="remenServlet";
		</script>
	</c:if>
</body>
</html>
