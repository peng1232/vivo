<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的收藏</title>
<link rel="icon name" href="../../img/favicon.ico" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script src="../../js/hou/modal.js"></script>
<link href="../../css/nav.css" rel="stylesheet"/>
<link href="../../css/hou/modal.css" rel="stylesheet"/>
<script src="../../js/nav.js"></script>
<link href="../../css/footer.css" rel="stylesheet" />
<link href="../../css/shoucang.css" rel="stylesheet" />
</head>
<body>
</body>
<%@include file="../../html/nav.jsp" %>
	  <div class="container">
        <div class="menu">
            <a href="../qian/shouye.jsp">商城首页</a>
           <a href="../../jsp/gereng/grzx.jsp"><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a>
			<a href=""><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">我的收藏</a>
        </div>
		<div class="under">
			<%@include file="../../html/zxzuo.jsp" %>
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
									<td><a href='../qian/XianXiSerlvet?id=${product[x.index].id }&ssku=${va.sku}'><img src="../../img/product/${ product[x.index].image_url}" class="tp"></a></td>
									<td><a href='../qian/XianXiSerlvet?id=${product[x.index].id }&ssku=${va.sku}'>${ product[x.index].products_name} ${ product[x.index].pagTtype} <br /> ${ product[x.index].color}</a></td>
									<td><a class="a1"> ${ product[x.index].price}</a></td>
									<td><a class="a1">${ product[x.index].listing_time}</a></td>
									<td><a class="a1">有货</a></td>
									<td>
										<div><a class="a2" href='../qian/XianXiSerlvet?id=${product[x.index].id }&ssku=${va.sku}'>去购买</a></div>
										<div><a class="a2 del" shou=${va.id }>删除收藏</a></div>
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
    	$(function(){
    		$('.del').click(function(){
    			var num = $(this).attr('shou');
    			var mModal1 = new mModal({
    				top: "30vh",
    				width: "30%",
    				title: "新增商品价格",
    				content: "<p>确认要删除此收藏吗</p>",
    				confirm: function() {
    					$.getJSON('CollectionDeleteServlet',{'number':num},function(){
    	    				location.reload();
    	    			})
    					mModal1.close();
    				},
    			});
    			mModal1.renderDom();
    		})
    	})
    </script>
				
		<input type="hidden" class='user' value='${user.id }'>	
		<c:if test="${empty user }">
			<script type="text/javascript">
				location.href= '../login/login.jsp';
			</script>
		</c:if>
		<c:if test="${ collection==null }">
			<script type="text/javascript">
				$(function(){
					var user_id = $('.user').val();
					location.href= 'CollectionInitServlet?user_id='+user_id;
				})
			</script>
		</c:if>
<%@include file="../../html/footer.jsp" %>
	
</html>