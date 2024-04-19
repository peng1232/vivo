<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算</title>
<link rel="icon name" href="../../img/favicon.ico" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<link href="../../css/nav.css" rel="stylesheet" />
<script src="../../js/nav.js"></script>
<link href="../../css/quick.css " rel="stylesheet" />
<script src="../../js/duolian.js"></script>
<script src="../../js/quick.js"></script>
<link href="../../css/footer.css" rel="stylesheet" />
</head>
<body>
	<%@include file="../../html/nav.jsp"%>
	<!-- 核对订单信息 -->
	<div id="content" class="clearfix">
		<input class='user' type="hidden" value='${user.id }'>
		<div class="neir">
			<div class="nei_top">
				<span>核对订单信息</span>
			</div>

			<!-- 收货地址 -->
			<div class='dizhi'>
				<div class='module_title'>收货人信息</div>
				<ul class='adress_list'>

				</ul>
			</div>

			<div class='dizhi' style='padding: 25px 0 0 0 !important;'>
				<div class='module_title' style='padding: 0 35px;'>
					确认商品<a class='continue_shopping' href='shpping.jsp'>返回购物车修改 ></a>
				</div>
				<div class='products_header'>
					<div class='goods_col' style='width: 430px;'>商品名称</div>
					<div class='price_col' style='width: 155px; text-align: right;'>价格（元）</div>
					<div class='quantity_col' style='width: 226px;'>数量</div>
					<div class='sum_col' style='width: 123px;'>小计（元）</div>
				</div>
				<c:forEach items="${product }" var="item" varStatus="va">
					<div class='product_info' sku='${skulist[va.index] }'  product_id='${item.id }'>
						<div class='prod_list_wrap'>
							<div class='prod_pic'>
								<a  lu ='XianXiSerlvet?id=${item.id }&sku=' sku= ${skulist[va.index] }' class='tiao'><img src='../../img/product/${item.image_url }' /></a>
							</div>
							<div class='col goods_col'>
								<a lu ='XianXiSerlvet?id=${item.id }&sku=' sku= ${skulist[va.index] }' class='name tiao'> <span class='w'>${item.products_name } ${item.pagTtype } ${item.color }</span>
								</a> <span class='w'>${item.color }</span>
							</div>
							<div class='col price_col'>￥${item.price }</div>
							<div class='col quantity_col'>${number[va.index] }</div>
							<div class='col total_col'>￥${item.price*number[va.index] }</div>
						</div>
					</div>
				</c:forEach>
				

			</div>
			<div class='confirm_module confirm_submit'>
				<div class='confirm_info'>
					<div class='real_price_box'>
						<label>应付总额：</label>
						<span class='real_price red'>￥3247.00</span>
					</div>
					<div class='address'>
						<div class='row'>
							<span class='names'>收件人：</span>
							<span class='value'>1 193****2312</span>
						</div>
						<div class='row'>
							<div class='names'>配送地址：</div>
							<div class='value'>贵州省毕节市黔西市</div>
						</div>
					</div>
					<div class='confirm_btn_box'>
						<div class='btn_submit'>提交订单</div>
					</div>
				</div>
			</div>
		</div>
		
		
	</div>
	

	<div class="message">
		<div class="zhe"></div>
		<div class="message_box">
			<div class="message_box_head">
				<span class='mess_title'>xxxxx</span>
				<svg class="guan" t="1710744510048" class="icon"
					viewBox="0 0 1024 1024" version="1.1"
					xmlns="http://www.w3.org/2000/svg" p-id="7727" width="16"
					height="16">
									<path
						d="M590.7456 508.416 1016.832 934.5024 938.0864 1009.664 512 583.5776 78.7456 1024 0 941.6704l433.2544-440.4224L7.168 75.1616 85.9136 0 512 426.0864 938.0864 0 1016.832 82.3296 590.7456 508.416z"
						p-id="7728" fill="#242933"></path>
								</svg>
			</div>
			<div class="item">
				<span class="das">收货人:</span> <input type="text" class="enter" /> <span
					class="error-tip"></span>
				<p class='tishi' flag='true'>请填写收件人姓名！</p>
			</div>

			<div class="item">
				<span class="das">手机号码:</span> <input type="text" class="enter" />
				<span class="error-tip"></span>
				<p class='tishi' flag='true'>请输入手机号码！</p>
			</div>

			<div class="item">
				<span class="das">收货地区:</span> <select id="province">
					<option value=''>请选择</option>
				</select> <select id="city">
					<option value=''>请选择</option>
				</select> <select id="district">
					<option value=''>请选择</option>
				</select>
				<p class='tishi' flag='true'>请选中收货地区！</p>
			</div>

			<div class="item">
				<span class="das">详细地址:</span> <input type="text" class="enter" />
				<span class="error-tip"></span>
				<p class='tishi' flag='true'>请填写详细地址！</p>
			</div>

			<div class="item_1">
				<label> <input type="checkbox" name="interest" value="music"
					class='mou'> <span class="agreement_text">设为默认地址</span>
				</label>
			</div>
			<div class="message_box_footer">
				<button class='' id='hao'>保存</button>
			</div>
		</div>
	</div>

	<c:if test="${empty user }">
		<script type="text/javascript">
			location.href = '../login/login.jsp'
		</script>
	</c:if>
	<%-- <c:if test="${product==null }">
		<script type="text/javascript">
			location.href='ShoppingServlet?user_id='+${user.id }
		</script>
	</c:if> --%>
	<%@include file="../../html/footer.jsp"%>
</body>
</html>