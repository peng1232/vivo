<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的评论</title>
<link rel="icon name" href="../../img/favicon.ico" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script src="../../js/hou/modal.js"></script>
<link href="../../css/nav.css" rel="stylesheet"/>
<link href="../../css/hou/modal.css" rel="stylesheet"/>
<script src="../../js/nav.js"></script>
<link href="../../css/pinglun.css" rel="stylesheet" />
<link href="../../css/footer.css" rel="stylesheet" />
</head>
<body>
	
	
</body>
	<%@include file="../../html/nav.jsp" %>
		 <div class="container">
        <div class="menu">
            <a href="../qian/shouye.jsp">商城首页</a>
            <a href="../../jsp/gereng/grzx.jsp"><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a>
			<a href=""><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">我的评论</a>
        </div>
		<div class="under">
			<%@include file="../../html/zxzuo.jsp" %>
			<input type="hidden" class='user_id' value='${user.id }'>
			<div class="right" style='    padding-bottom: 40px;'>
					<div class="div1">我的评论</div>
					<div class="div2">
						<table>
							<thead class="thead1">
								<th class="xuhao">序号</th>
								<th class="wodepinglun">我的评论</th>
								<th class="mingzi">商品</th>
								<th class="spzhuangtai">状态</th>
								<th class="caozuo">评论等级</th>
								<th class="caozuo">操作</th> 
							</thead>
							<tbody class="tbody">
								<c:forEach items="${commentsList}" var="comment" varStatus="va">
									<tr>
										<td><a class="a1">${comment.id}</a></td>
										<td><a class="a1 s1">${comment.user_com}</a></td>
										<td><a class="a1"  href='../qian/XianXiSerlvet?id=${comment.product_id }'>${plist[va.index].products_name}</a></td>
										<td>
								            <c:choose>
								                <c:when test="${comment.state == 0}">待审核</c:when>
								                <c:when test="${comment.state == 1}">已审核</c:when>
								                <c:when test="${comment.state == 2}">审核未通过</c:when>
								                <c:otherwise>-</c:otherwise>
								            </c:choose>
       									</td>
										
										<td> <c:choose>
							                <c:when test="${comment.com_grade == 1}">★</c:when>
							                <c:when test="${comment.com_grade == 2}">★★</c:when>
							                <c:when test="${comment.com_grade == 3}">★★★</c:when>
							                <c:when test="${comment.com_grade == 4}">★★★★</c:when>
							                <c:when test="${comment.com_grade == 5}">★★★★★</c:when>
							                <c:otherwise>-</c:otherwise>
          								  </c:choose></td>
										<td>
											<button class="delete"  comment_id = ${comment.id }>删除</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
			</div>
		</div>
		</div>
		</div>
		
		<script type="text/javascript">
    	$(function(){
    		$('.delete').click(function(){
    			var num = $(this).attr('comment_id');
    			var mModal1 = new mModal({
    				top: "30vh",
    				width: "30%",
    				title: "提醒",
    				content: "<p>确认要删除此评论吗</p>",
    				confirm: function() {
    					$.getJSON('CommentsDeleteServlet',{'id':num},function(){
    	    				location.reload();
    	    			})
    					mModal1.close();
    				},
    			});
    			mModal1.renderDom();
    		})
    	})
    </script>
		
	<%@include file="../../html/footer.jsp" %>
	<c:if test="${user==null }">
		<script type="text/javascript">
			location.href = '../login/login.jsp'
		</script>
	</c:if>
	<c:if test="${commentsList==null}">
		<script type="text/javascript">
			$(function() {
				var user_id = $('.user_id').val();
				location.href = 'CommentsServlet?user_id=' + user_id;
			})
		</script>

    </c:if>
</html>