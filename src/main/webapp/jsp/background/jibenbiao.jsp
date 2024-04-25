<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<link rel="stylesheet" href="https://www.jq22.com/jquery/font-awesome.4.6.0.css">
		<link rel="stylesheet" href="../../css/amazeui.css" />
		<link rel="stylesheet" href="../../css/core.css" />
		<link rel="stylesheet" href="../../css/menu.css" />
		<link rel="stylesheet" href="../../css/admin.css" />
		<link rel="stylesheet" href="../../css/page/typography.css" />
		<link rel="stylesheet" href="../../css/page/form.css" />
		<link rel="stylesheet" href="../../css/component.css" />
</head>
<body>
		<!-- Begin page -->
		<header class="am-topbar am-topbar-fixed-top">		
			
	
			<div class="contain">
				<ul class="am-nav am-navbar-nav am-navbar-left">

					<li><h4 class="page-title">表格</h4></li>
				</ul>
			</div>
		</header>
		<!-- end page -->
		
		
		<div class="admin">
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="am-g">
					<!-- Row start -->
						<div class="am-u-sm-6">
							<div class="card-box">
								<!-- col start -->
								<table class="am-table">
								    <thead>
								        <tr>
								            <th>序号</th>
								            <th>用户名称</th>
								            <th>我的评论</th>
								            <th>商品</th>
								            <th>状态</th>
								            <th>评论等级</th>
								            <th>操作</th>
								        </tr>
								    </thead>
								    <tbody>
								   <c:forEach items="${list }" var="item"> 
								        <tr>
								            <td></td>
								            <td></td>
								            <td></td>
								            <td></td>
								            <td></td>
								            <td></td>
								            <td>
								            	<button class="chonzhi">添加数据</button>
												<button class="chonzhi">重置密码</button>
												<button class="zhuantai" admin='${item.id }'>修改数据</button>
												<button class="shujuxiugai" admin='${item.id }'>数据状态</button>
											</td>
								        </tr>
								       <!-- </c:forEach> -->
								    </tbody>
								</table>
								<!-- col end -->
							</div>
						</div>
						
						<div class="am-u-sm-6">
							<div class="card-box">
								<!-- col start -->
									<table class="am-table  am-table-hover">
								    <thead>
								        <tr>
								            <th>商品名称</th>
								            <th>收藏时间</th>
								            <th>商品状态</th>
								            <th>操作</th>
								        </tr>
								    </thead>
								    <tbody>
								       <c:forEach items="${list }" var="item">
								        <tr>
								            <td></td>
								            <td></td>
								            <td></td>
								            <td>
								            	<button class="chonzhi">添加数据</button>
												<button class="chonzhi">重置密码</button>
												<button class="zhuantai" admin='${item.id }'>修改数据</button>
												<button class="shujuxiugai" admin='${item.id }'>数据状态</button>
											</td>
								        </tr>
								        </c:forEach> 
								    </tbody>
								</table>
								<!-- col end -->
							</div>
						</div>
					<!-- Row end -->
				</div>
			
				<!-- row start -->
				<div class="am-g">
					<!-- col start -->
					<div class="am-u-md-6">
						<div class="card-box">
							<table class="am-table am-table-bordered">
								    <thead>
								        <tr>
								            <th>商品</th>
								            <th>数量</th>
								            <th>价格</th>
								            <th>操作</th>
								        </tr>
								    </thead>
								    <tbody>
								       <c:forEach items="${list }" var="item">
								        <tr>
								            <td></td>
								            <td></td>
								            <td></td>
								            <td>
								            	<button class="chonzhi">添加数据</button>
												<button class="chonzhi">重置密码</button>
												<button class="zhuantai" admin='${item.id }'>修改数据</button>
												<button class="shujuxiugai" admin='${item.id }'>数据状态</button>
											</td>
								        </tr>
								        </c:forEach>								       
								    </tbody>
								</table>
						</div>
					</div>
					<!-- col end -->
					
					<!-- col start -->
					<div class="am-u-md-6">
						<div class="card-box">
							<table class="am-table  am-table-striped">
								    <thead>
								        <tr>
								            <th>id</th>
								            <th>广告图片地址</th>
								            <th>商品id</th>								     
								            <th>操作</th>
								        </tr>
								    </thead>
								    <tbody>
								        <c:forEach items="${list }" var="item"> 
								        <tr>
								            <td></td>
								            <td></td>
								            <td></td>
								            <td>
								            	<button class="chonzhi">添加数据</button>
												<button class="chonzhi">重置密码</button>
												<button class="zhuantai" admin='${item.id }'>修改数据</button>
												<button class="shujuxiugai" admin='${item.id }'>数据状态</button>
											</td>
								        </tr>
								       </c:forEach> 
								        
								    </tbody>
								</table>
						</div>
					</div>
					<!-- col end -->
				</div>

				
			</div>
		</div>
		</div>
		
		
		<!-- navbar -->
		<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>
	</body>
		<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="../../js/amazeui.min.js"></script>
		<script type="text/javascript" src="../../js/app.js" ></script>
		<script type="text/javascript" src="../../js/blockUI.js" ></script>
		<%-- <c:if test="${empty list }">
			<script>
				location.href = "";
			</script>
		</c:if>
 --%>

	
</html>