<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜索</title>
<link rel="icon name" href="../../img/favicon.ico" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<link href="../../css/nav.css" rel="stylesheet" />
<script src="../../js/nav.js"></script>
<script src="../../js/search.js"></script>
<link href="../../css/footer.css" rel="stylesheet" />
<link href="../../css/search.css" rel="stylesheet" />
</head>
<body>
	<%@include file="../../html/nav.jsp"%>

	<div class='page_search_result_header'>
		<div>
			<div class='page_search_result_input_wrapper'>
				<input id='js_headerInput' placeholder="请输入搜索内容" value='${search }' />
				<span id='js_headerSearch'></span>
			</div>
		</div>
	</div>
	<div class='page_search_result_wrapper'>
		<div class='search_result_content_box'>

			<c:if test="${fn:length(querySearch)>0}" var="flag">
				<div class='search_result_content_title clearfix'>
					<span>商品</span>
					<p>搜到${tatol}条结果</p>
				</div>
				<div class='page_search_result_content clearfix'>
					<c:forEach items="${querySearch }" var="item" varStatus="va">
						<div class='content_item ${va.index%4==3?"yi":"" } '
							} product="${item.id }">
							<img class='result_pic'
								src="../../img/product/${item.image_url }">
							<p class='result_title'>${item.products_name }
								${item.pagTtype } ${item.color }</p>
							<span class='result_text'>${item.description }</span>
							<p class='result_price'>
								<span class='result_price_new'> ￥${item.price } </span>
							</p>
							<a href='XianXiSerlvet?id=${item.id }'></a>
						</div>
					</c:forEach>
				</div>
				<div class='dibu'>
					<c:if test="${ fn:length(querySearch)>=8}" var="f">
						<span id = 'jiazai'>加载更多</span>
					</c:if>
					<c:if test="${!f }">
						<p >没有更多了！</p>
					</c:if>
					<p id='meile'>没有更多了！</p>
				</div>
			</c:if>
			<c:if test="${!flag }">
				<div class='page-search-result-other'>
					<p>抱歉，没搜索到相关内容，请换个词试下吧～</p>
				</div>
			</c:if>
		</div>
	</div>
	<%@include file="../../html/footer.jsp"%>
</body>
</html>