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
<title>价格管理</title>
<script src="../../js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://at.alicdn.com/t/font_1632750_204xwxiwzht.css?1583918713" />
<link rel="stylesheet" href="../../css/cebianlan.css">
<link rel="stylesheet" href="../../css/hou/priceguanli.css">
<script type="text/javascript" src="../../js/hou/priceguanli.js"></script>
<script src="../../js/hou/modal.js"></script>
<link rel="stylesheet" href="../../css/hou/modal.css">
</head>
<body>
	<%@include file="../background/cebianlan.jsp"%>
	<div class='content'>
		<div class='neirong'>
			<div class="biao clearfix">
				<form action="PriceSelectAllServlet" method="get" id="sub"
					class="clearfix">
					<div class="item">
						<label>商品名称:</label>
						<select name='name'>
							<option value=' '>全部</option>
							<c:forEach items="${productlist }" var="item">
								<option value='${item.id }' ${product_id==item.id?'selected':'' }>${item.products_name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="item">
						<label>是否推荐:</label>
						<select name='is'>
							<option value=' '>全部</option>
							<option value='1' ${isval==1?'selected':'' }>推荐</option>
							<option value='0'  ${isval==0?'selected':'' }>不推荐</option>
							
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
					<button class="btn newtype">新增价格</button>
				</div>
				<div class='data'>
					<div id='fe'>
						<table class="table" border="1" cellspacing='0'>
							<tr>
								<td><input type="checkbox" class='check quanxuan'></td>
								<td><b>价格id</b></td>
								<td><b>商品名称</b></td>
								<td><b>价格</b></td>
								<td  style='width:10vh'><b>是否推荐</b></td>
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
									<td class="ntd sl">${item.price }</td>
									<td class="ntd" iss='${item.is_recommended }'>${item.is_recommended==1?'推荐':'不推荐' }</td>
									<td class="ntd">
										<button value='${item.id}' class='an cha'>查看</button>
										<button value='${item.id}' class='an shen'>修改</button>
									</td>
								</tr>
							</c:forEach>
							<c:if test="${fn:length(selectAll)==0 }">
								<tr>
									<td colspan="11" style="text-align: center">暂无数据</td>
								</tr>
							</c:if>
						</table>
						<x:page controller='PriceSelectAllServlet' pagesize="5"
							total="${total}" curpage="${curpage}" where="${sql }" />
					</div>

				</div>
			</div>
		</div>

	</div>
	
	<!-- 新增；类别 -->
	<div class='hidden'>
		<div class='xin'>
			<form action="PriceInsertServlet" method="post" id="s">
				
				<p>
					<label>商品名称：</label>
					<select name='name' class='type'>
						<c:forEach items="${productlist }" var="item">
							<option value='${item.id }' ${product_id==item.id?'selected':'' }>${item.products_name }</option>
						</c:forEach>
					</select>
				</p>
				<p>商品价格：<input type="number" class='type' name='price'/></p>
				<p>是否推荐：
					<select name='is' class='type'>
						<option value='0'  ${isval==0?'selected':'' }>不推荐</option>
						<option value='1' ${isval==1?'selected':'' }>推荐</option>
					</select>
				</p>
				<p><input class=' btn tij' type="submit" value='添加商品价格'/></p>
			</form>
		</div>
		<div class='update'>
			<form action="PriceUpdateServlet" method="post" id="s">
				<p><span class='wz'>价格 id：</span><input class='type id' readonly name='id' /></p>
				
				<p>商品名称：<input class='type name' readonly  /></p>
				<input type="hidden" name='product_name' class='product_id'/>
				<p>商品价格：<input type='number' class='type price_value' name='price'/></p>
				<p>是否推荐：
					<select name='is' class='type is'>
						<option value='0'>不推荐</option>
						<option value='1'>推荐</option>
					</select>
				</p>
				<p><input class=' btn tij' type="submit" value='修改'/></p>
			</form>
		</div>
		
		<div class='chile'>
			
			<div  class='clearfix'>
				<p class='leftfu'><span class='wz'>商品名称：</span><span class='pname'>2</span></p>
				<p class='leftfu'>商品价格：<span class='pvalue'></span></p>
			</div>
			<div class='xinzen'>
				<p >规格值名称：
				<select class='type product_name'>
				
				</select>
				<button class='btnew btn tij' id='sdfas' style='margin-left:4vh'>新增</button></p>
			</div>	
			<div class='info'>
				<table class="table tavalue" border="1" cellspacing='0'>
					<tr>
						<td><b>规格值id</b></td>
						<td><b>规格名称</b></td>
						<td><b>规格值名称</b></td>
						<td style='width:8vh;'><b>操作</b></td>
					</tr>
					
					<c:if test="${fn:length(selectAll)==0 }">
						<tr>
							<td colspan="11" style="text-align: center">暂无数据</td>
						</tr>
					</c:if>
				</table>
			</div>	
		</div>
	</div>
	<c:if test="${selectAll==null}">
		<script type="text/javascript">
			location.href = "PriceSelectAllServlet"
		</script>
	</c:if>
	
</body>
</html>