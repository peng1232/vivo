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
            <a href="../../jsp/gereng/grzx.jsp"><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a>
			<a href=""><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">我的评论</a>
        </div>
		<div class="under">
			<%@include file="../../jsp/gereng/zxzuo.jsp" %>
			<div class="right">
					<div class="div1">我的评论</div>



					<div class="div2">
						

						
						<div class="search-box">
							<input type="text" placeholder="请输入搜索内容">
							<div class="search-icon">
								<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
									stroke="currentColor" width="24" height="24">
									<path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
										d="M21 21l-4.35-4.35M15 11a4 4 0 11-8 0 4 4 0 018 0z" />
								</svg>
							</div>
						</div>




						<table>
							<thead class="thead1">
								<th class="xuhao">序号</th>
								<th class="yonghumingcheng">用户名称</th>
								<th class="wodepinglun">我的评论</th>
								<th class="mingzi">商品</th>
								<th class="spzhuangtai">状态</th>
								<th class="caozuo">评论等级</th>
								<th class="caozuo">操作</th> 
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
										<td>
											<button class="delete" onclick="deleteComment()">删除</button>
											<button class="edit" onclick="editComment()">修改</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>





						</table>
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