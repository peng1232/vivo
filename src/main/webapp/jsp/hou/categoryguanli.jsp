<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://www.trkj.com/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品类别管理</title>
<script src="../../js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://at.alicdn.com/t/font_1632750_204xwxiwzht.css?1583918713" />
<link rel="stylesheet" href="../../css/cebianlan.css">
<link rel="stylesheet" href="../../css/hou/categoryguanli.css">
<script type="text/javascript" src="../../js/hou/categoryguanli.js"></script>
<script src="../../js/hou/modal.js"></script>
<link rel="stylesheet" href="../../css/hou/modal.css">
</head>
<body>
	<%@include file="../../html/cebianlan.jsp"%>
	<div class='content'>
		<div class='neirong'>
			<div class="biao clearfix">
				<form action="CategorySelectAllServlet" method="get" id="sub"
					class="clearfix">

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
						name="pagesize" value='5' type="hidden"> <input
						name="curpage" value="${param.curpage==null?1:param.curpage}"
						type="hidden">
				</form>
				<div class="context clearfix">
					<button class="btn newtype">新增类别</button>
				</div>
				<div class='data'>
					<div id='fe'>
						<table class="table" border="1" cellspacing='0'>
							<tr>
								<td><input type="checkbox" class='check quanxuan'></td>
								<td><b>类别id</b></td>
								<td><b>类别名称</b></td>
								<td><b>状态</b></td>
								<td><b>操作</b></td>
							</tr>
							<c:forEach items="${category }" var="item">
								<tr>
									<td class="ntd"><input type="checkbox" class='check ew'></td>
									<td class="ntd">${item.id }</td>
									<td class="ntd">${item.category_type }</td>
									<td class="ntd" val='${item.state }'>${item.state ==0?'不可用':'可用' }</td>
									<td class="ntd">
										<button value='${item.id}' class='an shen'>修改</button>
										<%-- <button value='${item.id}' class='an del'>删除</button> --%>
									</td>
								</tr>
							</c:forEach>
							<c:if test="${fn:length(category)==0 }">
								<tr>
									<td colspan="5" style="text-align: center">暂无数据</td>
								</tr>
							</c:if>
						</table>
						<x:page controller='CategorySelectAllServlet' pagesize="5"
							total="${total}" curpage="${curpage}" where="${sql }" />
					</div>

				</div>
			</div>
		</div>

	</div>
	
	<!-- 新增；类别 -->
	<div class='hidden'>
		<div class='xin'>
			<form action="CategoryInsertServlet" method="post" id="s">
				<p>类别名称：<input class='type' name='type'/></p>
				<p><input class=' btn tij' type="submit" value='新增'/></p>
			</form>
		</div>
		<div class='update'>
			<form action="CategoryUpdateServlet" method="post" id="s">
				<p><span class='wz'>类别 id：</span><input class='type id' readonly name='id' /></p>
				<p>类别名称：<input class='type cate' name='type'/></p>
				<p>类别状态：
					 <select class='type statevalue' name='state'>
						<option value='1'>可用</option>
						<option value='0'>不可用</option>
					</select>
				</p>
				<p><input class=' btn tij' type="submit" value='修改'/></p>
			</form>
		</div>
	</div>
	<c:if test="${category==null}">
		<script type="text/javascript">
			location.href = "CategorySelectAllServlet"
		</script>
	</c:if>
</body>
</html>