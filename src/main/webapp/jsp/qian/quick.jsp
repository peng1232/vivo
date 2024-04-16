<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算</title>
<link rel="icon name" href="../../img/favicon.ico" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<link href="../../css/nav.css" rel="stylesheet" />
<script src="../../js/nav.js"></script>
<link href="../../css/quick.css " rel="stylesheet" />
<script src="../../js/quick.js"></script>
<link href="../../css/footer.css" rel="stylesheet" />
</head>
<body>
	<%@include file="../../html/nav.jsp"%>
	<!-- 购物车 -->
	<div id="content" class="clearfix">
		<input class='user' type="hidden" value='${user.id }'>
		<div class="neir">
			<div class="nei_top">
				<span>核对订单信息</span>
			</div>
			<div class="cart_head">
				<table>
					<tr>
						<th class="golds_col">商品名称</th>
						<th class="price_col">价格(元)</th>
						<th>数量</th>
						<th>小计(元)</th>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<c:if test="${empty user }">
		<script type="text/javascript">
			location.href = '../login/login.jsp'
		</script>
	</c:if>
	<%-- <c:if test="${product==null }">
		<script type="text/javascript">
			location.href='ShoppingServlet?user_id='+${user.id }
		</script>
	</c:if> --%>
	<%@include file="../../html/footer.jsp"%>
</body>
</html>