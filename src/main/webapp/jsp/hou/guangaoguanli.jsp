<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://www.trkj.com/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品广告管理</title>
<script src="../../js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://at.alicdn.com/t/font_1632750_204xwxiwzht.css?1583918713" />
<link rel="stylesheet" href="../../css/cebianlan.css">
<link rel="stylesheet" href="../../css/hou/guangaoguanli.css">
<script type="text/javascript" src="../../js/hou/guangaoguanli.js"></script>
<script src="../../js/hou/modal.js"></script>
<link rel="stylesheet" href="../../css/hou/modal.css">
</head>
<body>
	<%@include file="../../html/cebianlan.jsp"%>
	<div class='content'>
		<div class='neirong'>
			<div class="biao clearfix">
				<form action="GuanGaoSelectAllServlet" method="get" id="sub"
					class="clearfix">

					<div class="item">
						<label>商品名称:</label>
						<select name='product_id'>
							<option value='quan'>全部</option>
							<c:forEach items="${productlist }" var="item">
								<option value='${item.id }' ${product_id==item.id?'selected':'' }>${item.products_name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="item">
						<label>状态</label> <select name='state'>
							<option value='quan'>全部</option>
							<option value='1' ${state==1?'selected':'' }>可用</option>
							<option value='0' ${state==0?'selected':'' }>不可用</option>
						</select>
					</div>

					<input type="submit" class="btn" value="搜素" id="ti" />
					<!-- 隐藏yu -->
					<input name="flag" value='yes' type="hidden"> <input
						name="pagesize" value='8' type="hidden"> <input
						name="curpage" value="${param.curpage==null?1:param.curpage}"
						type="hidden">
				</form>
				<div class="context clearfix">
					<button class="btn newtype">新增商品广告</button>
				</div>
			<!-- 	<form action="" method="post" id='sctu' enctype="multipart/form-data" style='display:none' > 
					选择照片：<input type="file" name="photo" id="photo">
				</form> -->
				<div class='data'>
					<div id='fe'>
						<table class="table" border="1" cellspacing='0'>
							<tr>
								<td><input type="checkbox" class='check quanxuan'></td>
								<td><b>商品广告id</b></td>
								<td><b>商品广告路径</b></td>
								<td><b>商品名称</b></td>
								<td><b>状态</b></td>
								<td><b>操作</b></td>
							</tr>
							<c:forEach items="${advertisement }" var="item">
								<tr>
									<td class="ntd"><input type="checkbox" class='check ew'></td>
									<td class="ntd">${item.id }</td>
									<td class="ntd s1">${item.advertisement_url }</td>
									<td class="ntd">
										<c:forEach items="${productlist }" var="items" varStatus="vaa">
											<c:if test="${items.id==item.product_id }">
												<span class='proid' value='${items.id }'>${items.products_name }</span>
											</c:if>
										
										</c:forEach>
									</td>
									<td class="ntd" val='${item.state }'>${item.state ==0?'不可用':'可用' }</td>
									<td class="ntd">
										<input type="file" name="photo" id="photoss" style='display:none' >
										<button value='${item.id}' class='an shen'>修改</button>
										<button value='${item.id}' class='an del'>更换图片</button> 
									</td>
								</tr>
							</c:forEach>
							<c:if test="${fn:length(advertisement)==0 }">
								<tr>
									<td colspan="6" style="text-align: center">暂无数据</td>
								</tr>
							</c:if>
						</table>
						<x:page controller='GuanGaoSelectAllServlet' pagesize="8"
							total="${total}" curpage="${curpage}" where="${sql }" />
					</div>

				</div>
			</div>
		</div>

	</div>
	
	<!-- 新增；类别 -->
	<div class='hidden'>
		<div class='xin'>
			<form action="GuanGaoInsertServlet" method="post" id="s" enctype="multipart/form-data">
				<p>
					<label>商品名称:</label>
					<select name='product_id' class='type'>
						<c:forEach items="${productlist }" var="item">
							<option value='${item.id }' ${product_id==item.id?'selected':'' }>${item.products_name }</option>
						</c:forEach>
					</select>
				</p>
				<p>图片广告： <input type="file" name="photo" id="photo" class='scwen'></p>
				<p><input class=' btn tij' type="submit" value='新增'/></p>
			</form>
		</div>
		<div class='update'>
			<form action="GuanGaoUpdateServlet" method="post" id="s" enctype="multipart/form-data">
				<p><span class='wz'>广告id：</span><input class='type id' readonly name='id' /></p>
				<p>商品名称：
					<select name='product_id'  class='type product_name'>
						<c:forEach items="${productlist }" var="item">
							<option value='${item.id }' ${product_id==item.id?'selected':'' }>${item.products_name }</option>
						</c:forEach>
					</select>
				</p>
				<p>广告状态：
					 <select class='type state' name='state'>
						<option value='1'>可用</option>
						<option value='0'>不可用</option>
					</select>
				</p>
				<p><input class=' btn tij' type="submit" value='修改'/></p>
			</form>
		</div>
	</div>
	<c:if test="${advertisement==null}">
		<script type="text/javascript">
			location.href = "GuanGaoSelectAllServlet"
		</script>
	</c:if>
</body>
</html>