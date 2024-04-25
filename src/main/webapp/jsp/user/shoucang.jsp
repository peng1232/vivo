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
            <a href="../qian/shouye.jsp">商城首页</a>
           <a href="../../jsp/gereng/grzx.jsp"><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a>
			<a href=""><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">我的收藏</a>
        </div>
		<div class="under">
			<%@include file="../../jsp/gereng/zxzuo.jsp" %>
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
						<c:forEach items="${collection}" var="va" varStatus="x">
							
								<tr class="tr2">
									<td><img src="../../img/${ product[x.index].image_url}" class="tp"></td>
									<td><a>${ product[x.index].products_name} ${ product[x.index].pagTtype} <br /> ${ product[x.index].color}</a></td>
									<td><a class="a1"> ${ product[x.index].price}</a></td>
									<td><a class="a1">${ product[x.index].listing_time}</a></td>
									<td><a class="a1">有货</a></td>
									<td><a class="a2">购买</a>
										<a class="a1">删除</a>
									</td>
								</tr>	
						</c:forEach>
						</tbody>
						</table>
					</div>
					</div>
			</div>
		</div>
				
				<script type="text/javascript">
    		// JavaScript 代码
  		 // 获取所有删除按钮
		var deleteButtons = document.querySelectorAll('.a1');

			// 遍历每个删除按钮，添加点击事件监听器
		deleteButtons.forEach(function(button) {
   		 button.addEventListener('click', function(event) {
        // 阻止默认行为，即点击链接时不跳转
        event.preventDefault();

        // 弹出确认提示框，询问用户是否要删除
        var confirmDelete = confirm("确定要删除吗？");

        // 如果用户确认删除，则执行删除操作
        if (confirmDelete) {
            // 获取当前要删除的行（父节点是<tr>）
            var row = button.closest('tr');
            
            // 执行删除操作，可以发送Ajax请求到服务器，或者直接在前端删除该行
            row.remove();
        }
    });
})
</script>
				
		<input type="hidden" class='user' value='${user.id }'>	
		<c:if test="${ collection==null }">
			<script type="text/javascript">
				$(function(){
					var user_id = $('.user').val();
					location.href= 'CollectionInitServlet?user_id='+user_id;
				})
			</script>
		</c:if>
		<c:if test="${empty user }">
			<script type="text/javascript">
				location.href= '../login/login.jsp';
			</script>
		</c:if>
<%@include file="../../html/footer.jsp" %>
	
</html>