<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://www.trkj.com/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品规格管理</title>
<script src="../../js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://at.alicdn.com/t/font_1632750_204xwxiwzht.css?1583918713" />
<link rel="stylesheet" href="../../css/cebianlan.css">
<link rel="stylesheet" href="../../css/hou/specifications.css">
<script type="text/javascript" src="../../js/hou/specifications.js"></script>
<script src="../../js/hou/modal.js"></script>
<link rel="stylesheet" href="../../css/hou/modal.css">
</head>
<body>
	<%@include file="../background/cebianlan.jsp"%>
	<div class='content'>
		<div class='neirong'>
			<div class="biao clearfix">
				<form action="SpecificationsSelectAllServlet" method="get" id="sub"
					class="clearfix">
					<div class="item">
						<label>规格名称:</label> 
						<input name='specifications' value='${specifications }'/>
					</div>
					<div class="item">
						<label>商品名称:${product_id }</label>
						<select name='name'>
							<option value=' '>全部</option>
							<c:forEach items="${productlist }" var="item">
								<option value='${item.id }' ${product_id==item.id?'selected':'' }>${item.products_name }</option>
							</c:forEach>
						</select>
					</div>

					<input type="submit" class="btn" value="搜素" id="ti" />
					<!-- 隐藏yu -->
					<input name="flag" value='yes' type="hidden"> <input
						name="pagesize" value='5' type="hidden"> <input
						name="curpage" value="${param.curpage==null?1:param.curpage}"
						type="hidden">
				</form>
				<div class="context clearfix">
					<button class="btn newtype">新增商品规格</button>
				</div>
				<div class='data'>
					<div id='fe'>
						<table class="table" border="1" cellspacing='0'>
							<tr>
								<td><input type="checkbox" class='check quanxuan'></td>
								<td><b>规格id</b></td>
								<td><b>商品名称</b></td>
								<td><b>商品规格名称</b></td>
								<td><b>操作</b></td>
							</tr>
							<c:forEach items="${selectAll }" var="item" varStatus="va">
								<tr>
									<td class="ntd"><input type="checkbox" class='check ew'></td>
									<td class="ntd">${item.id }</td>
									<td class="ntd sl">
										<c:forEach items="${productlist }" var="items" varStatus="vaa">
											<c:if test="${items.id==item.product_id }">
												<span class='proid' value='${items.id }'>${items.products_name }</span>
											</c:if>
										
										</c:forEach>
									</td>
									<td class="ntd sl">${item.specifications_name }</td>
									<td class="ntd">
										<button value='${item.id}' class='an cha'>查看</button>
										<button value='${item.id}' class='an shen'>修改</button>
									</td>
								</tr>
							</c:forEach>
							<c:if test="${fn:length(selectAll)==0 }">
								<tr>
									<td colspan="5" style="text-align: center">暂无数据</td>
								</tr>
							</c:if>
						</table>
						<x:page controller='SpecificationsSelectAllServlet' pagesize="5"
							total="${total}" curpage="${curpage}" where="${sql }" />
					</div>

				</div>
			</div>
		</div>

	</div>
	
	<!-- 新增；类别 -->
	<div class='hidden'>
		<div class='xin'>
			<form action="SpecificationsInsertServlet" method="post" id="s">
				
				<p>
					<label>商品名称:${product_id }</label>
					<select name='name' class='type'>
						<c:forEach items="${productlist }" var="item">
							<option value='${item.id }' ${product_id==item.id?'selected':'' }>${item.products_name }</option>
						</c:forEach>
					</select>
				</p>
				<p>规格名称：<input type="text" class='type limit' name='specifications'/></p>
				<p><input class=' btn tij' type="submit" value='添加商品规格'/></p>
			</form>
		</div>
		<div class='update'>
			<form action="SpecificationsUpdateServlet" method="post" id="s">
			<p><span class='wz'>规格 id：</span><input class='type id' readonly name='id' /></p>
				
				<p>商品名称：
					<select name='type' class='type cate'>
						<c:forEach items="${productlist }" var="item">
							<option value='${item.id }' ${product_id==item.id?'selected':'' }>${item.products_name }</option>
						</c:forEach>
					</select>
				</p>
				<p>规格名称：<input class='type name' name='name'/></p>
				
				<p><input class=' btn tij' type="submit" value='修改'/></p>
			</form>
		</div>
		
		<div class='chile'>
			
			<div  class='clearfix'>
				<p class='leftfu'><span class='wz'>商品名称：</span><span class='pname'>2</span></p>
				<p class='leftfu'>规格名称：<span class='pvalue'></span></p>
			</div>
			<div class='xinzen'>
				<p >规格值名称：<input class='type name' name='name'/><button class='btnew btn tij' id='sdfas' style='margin-left:4vh'>新增</button></p>
			</div>	
			<div class='info'>
				<table class="table tavalue" border="1" cellspacing='0'>
					<tr>
						<td ><b>规格值id</b></td>
						<td style='width:12vh;'><b>商品规格值名称</b></td>
						<td style='width:8vh;'><b>规格值图片数量</b></td>
						<td style='width:14vh;'><b>操作</b></td>
					</tr>
					
					<c:if test="${fn:length(selectAll)==0 }">
						<tr>
							<td colspan="4" style="text-align: center">暂无数据</td>
						</tr>
					</c:if>
				</table>
			</div>	
		</div>
	</div>
	
	<!-- 弹窗？ -->
	<div class='tan'>
		<div class='container'>
			<div class='header_title'>
				<span class='modal_titel'>查看商品规格图片</span>
				<button class='modal__headerbtn'></button>
			</div>
			<div class='modal_body clearfix'>
				<div class='yulan'>
					<img alt="图片预览" src="" class='yul'  title='图片预览'>
					<p class='y'>预览图</p>
				</div>
				<div  class='clearfix'>
					<p class='leftfu'><span class='wz'>商品名称：</span><span class='pname'>2</span></p>
					<p class='leftfu'>规格值名称：<span class='pvalue_name'></span></p>
				</div>
				<div class='clearfix'><input class='btn addUrl' type="submit" value='添加规格图片'/></div>
				<div style="display: none;">
					<!-- <form action="" method="post" enctype="multipart/form-data" > -->
						 选择照片：<input type="file" name="photo" id="photo">
						 选择照片：<input type="file" name="photo2" id="photo2">
				<!-- 	</form> -->
				</div>
				<div class='info'>
					<table class="table taimage" border="1" cellspacing='0'>
						<tr>
							<td ><b>商品图片id</b></td>
							<td style='max-width:30vh;width: 30vh;'><b>商品图片</b></td>
							<td ><b>操作</b></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<c:if test="${selectAll==null}">
		<script type="text/javascript">
			location.href = "SpecificationsSelectAllServlet"
		</script>
	</c:if>
	
</body>
</html>