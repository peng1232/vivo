<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<link rel="icon name" href="../../img/favicon.ico" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<link href="../../css/nav.css" rel="stylesheet"/>
<script src="../../js/nav.js"></script>
<link href="../../css/shpping.css " rel="stylesheet" />
<script src="../../js/shpping.js"></script>
<link href="../../css/footer.css" rel="stylesheet" />
</head>
<body>
	<%@include file="../../html/nav.jsp" %>
	<!-- 购物车 -->
		<div id="content" class="clearfix">
			<input class='user' type="hidden" value='${user.id }'>
			<div class="neir">
				<div class="nei_top">
					<span>我的购物车</span>
					<a href ='shouye.jsp' style='text-decoration: none;'>
						继续购物 <b>></b>
					</a>
				</div>
				<div class="cart_head">
					<table>
						<tr>
							<th class="col_check">
								<label>
									<input type="checkbox" class="check_input check_sum" />
									<span>全部</span>
								</label>
							</th>
							<th class="golds_col">商品名称</th>
							<th class="price_col">价格(元)</th>
							<th>数量</th>
							<th>小计(元)</th>
							<th>操作</th>
						</tr>
					</table>
				</div>
				<!-- 购物车项 -->
				
				<c:if test="${fn:length(product) > 0}" var="fou">
			   		<c:forEach items="${product }" var ='item' varStatus="va">
						<div class="shop_cart_item">
							<div class="cart_item_info">
								<table>
									<tr>
										<td class="col_check che">
											<label><input type="checkbox" class="check_input check_item" shopping_id='${shoppingId[va.index] }'/></label>
										</td>
										<td class="prod-pic">
											<a href='XianXiSerlvet?id=${item.id }&shoppingId=${shoppingId[va.index] }'>
												<div class="figure"><img src="../../img/product/${item.image_url }" /></div>
											</a>
										</td>
										<td class="golds_col pro_col">
											<a href='XianXiSerlvet?id=${item.id }&shoppingId=${shoppingId[va.index] }' class="golds_link">vivo ${item.products_name } ${item.pagTtype } ${item.color }</a>
											<br />
											<span> ${item.color } </span>
										</td>
										<td class="price_col">${item.price }</td>
										<td class="number-box">
											<a class="reduce-num num_shu">-</a>
											<span class="prod-num" max = '${item.purchase_limit }'  shopping_id='${shoppingId[va.index] }'>${shopping[va.index].quantity }</span>
											<a class="add-num num_shu">+</a>
										</td>
										<td class="total_price column"></td>
										<td class="zaozuo">
											<!-- <a class="favorite" href="#">加入到购物车</a><br /> -->
											<a href="#" class='del' shopping_id='${shoppingId[va.index] }' index='${va.index}'>删除</a>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</c:forEach>
					<!-- 总结页 -->
					<div class="cart_toolbar_wrap">
						<div class="cart_toolbar_wrap">
							<div class="toolbar_wrapper">
								<div class="cart_toolbar_inner">
									<ul class="clearfix option_list">
										<li>
											<label>
												<input type="checkbox" class="check_input check_sum" />
												<span class="quan wei">全选</span>
											</label>
										</li>
										<li>
											<span class="delshop wei">删除选中的商品</span>
										</li>
										<!-- <li>
											<span class="shou wei">移入收藏夹</span>
										</li> -->
									</ul>
									<div class="total_right">
										<table>
											<tr>
												<td>
													<p class="wenzi">
														已选商品 <span id="number">0</span> 件，合计（不含运费）：<b class="price">￥<span
																id="jin">0.00</span></b>
													</p>
												</td>
												<td class="yshi">
													<button id="jiesuan">去结算</button>
												</td>
											</tr>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${!fou }">
					<div class='no_result'>
						<div>
							<img src='../../img/product/nogou.png' class='nogou'>
						</div>
						<div class='wenzi_title'>哎呀，购物车为空！</div>
						<div class='no_container'>
							<button class='btn_an ggou'><a href='shouye.jsp'>去选购逛逛</a></button>
							<button class='btn_an gshou'><a href='#'>我的收藏</a></button>
						</div>
					</div>
				</c:if>
			</div>
		</div>


		<!-- 弹窗 -->
		<div class="message">
			<div class="zhe"></div>
			<div class="message_box">
				<div class="message_box_head">
					<span>提醒信息</span>
					<svg class="guan" t="1710744510048" class="icon" viewBox="0 0 1024 1024" version="1.1"
						xmlns="http://www.w3.org/2000/svg" p-id="7727" width="16" height="16">
						<path
							d="M590.7456 508.416 1016.832 934.5024 938.0864 1009.664 512 583.5776 78.7456 1024 0 941.6704l433.2544-440.4224L7.168 75.1616 85.9136 0 512 426.0864 938.0864 0 1016.832 82.3296 590.7456 508.416z"
							p-id="7728" fill="#242933"></path>
					</svg>
				</div>
				<div class="message_box_center">
					<p class="setting">温馨提示：商品抢购数量超出限制</p>
				</div>
				<div class="message_box_footer">
					<button class='guanque'>确定</button>
					<button class='delque' style='display:none'>确定</button>
					<button id='xuxiao'>取消</button>
				</div>
			</div>
		</div>
	<c:if test="${empty user }">
		<script type="text/javascript">
			location.href='../login/login.jsp'
		</script>
	</c:if>
	<c:if test="${product==null }">
		<script type="text/javascript">
			location.href='ShoppingServlet?user_id='+${user.id }
		</script>
	</c:if>
	<%@include file="../../html/footer.jsp" %>
</body>
</html>