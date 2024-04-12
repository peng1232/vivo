<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>vivo ${product.products_name }</title>
<link rel="icon name" href="../../img/favicon.ico" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<link href="../../css/nav.css" rel="stylesheet"/>
<link href="../../css/xianxi.css" rel="stylesheet"/>
<script src="../../js/nav.js"></script>
<script src="../../js/xianxi.js"></script>
<link href="../../css/footer.css" rel="stylesheet" />
</head>
<body>
	<%@include file="../../html/nav.jsp" %>
	<!-- 内容体 -->
	<div id='content' class='clearfix'>
		<!-- 头 -->
		<div class='crumbs'>
			<div class='section_wrapper'>
				<a href='shouye.jsp' class='first'>商城首页</a>
				<svg t="1712546482937" class="icon jian" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4256" width="16" height="16"><path d="M347.687 144.188l-52.761 52.238 313.928 316.082-316.568 313.42 52.314 52.673 369.322-365.663z" fill="#999999" p-id="4257"></path></svg>
				<span class='p_name'>${product.products_name }</span>
			</div>
		</div>	
		<!-- 内容 -->
		<div class='base-info'>
			<div class='base-info_container clearfix'>
				<div class='base_left'>
					<ul class='img_list_big'>
						
					</ul>
					<div class='img_small'>
						<span class='opration op_left'><svg style='    transform: rotate(180deg);' t="1712546482937" class="icon jian" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4256" width="16" height="16"><path d="M347.687 144.188l-52.761 52.238 313.928 316.082-316.568 313.42 52.314 52.673 369.322-365.663z" fill="#999999" p-id="4257"></path></svg></span>
						<span class='opration op_right'><svg t="1712546482937" class="icon jian" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4256" width="16" height="16"><path d="M347.687 144.188l-52.761 52.238 313.928 316.082-316.568 313.42 52.314 52.673 369.322-365.663z" fill="#999999" p-id="4257"></path></svg></span>
						<div class='list_wrapper'>
							<ul class='img_samll ul_xiao' style='left:0px;'>
								
							</ul>
						</div>
					</div>
					<div class='collection'>
						<input class='shousku' type="hidden" sku="{}"/>
						<svg class='shouc' check='false' t="1712714193018" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4287" width="16" height="16"><path d="M979.443512 404.205268c-3.596488-11.189073-13.187122-18.681756-23.976585-20.280195L667.348293 342.165854 538.673951 81.020878c-4.89522-9.890341-14.985366-16.583805-26.673951-16.583805-11.788488 0-21.778732 6.793366-26.673951 16.583805L356.651707 342.165854 68.433171 383.925073c-10.789463 1.598439-20.380098 9.191024-23.976586 20.280195-3.69639 11.189073-0.299707 22.877659 7.492683 30.470244l208.396488 203.401366-49.152 286.919805c-1.798244 10.689561 2.297756 22.178341 11.788488 28.971707s21.678829 7.292878 31.369366 2.197854l257.748292-135.367805 257.648391 135.168c9.790439 5.095024 21.778732 4.595512 31.269463-2.197854 9.390829-6.793366 13.686634-18.182244 11.788488-28.971707l-49.251903-286.919805 208.396488-203.201561c7.892293-7.692488 11.089171-19.381073 7.492683-30.470244z" p-id="4288" fill="#acacac"></path></svg>
						<span class='text'>收藏商品（${queryCollection }人收藏）</span>
					</div>
				</div>
				<div class='base_right'>
					<input class='user_id' type="hidden" value="${user.id }">
					<input class='tit' type="hidden" value="vivo ${product.products_name }">
					<p class='name' pro='${product.id }'></p>
					<p class='intro'>${product.description }</p>
					<div class='summary'>
						<div class='summary_price'>
							<p class='sale-price'></p>
						</div>
						<div class='summary_activity'>
							<ul class='list'>
								<li class='list_item'>
									<span class='lable'>赠品</span>
									<p>有贴纸</p>
								</li>
								<li class='list_item'>
									<span class='lable'>定制</span>
									<p>免费定制服务</p>
								</li>
								<li class='list_item'>
									<span class='lable'>积分</span>
									<p>购物送积分</p>
								</li>
							</ul>
						</div>
					</div>
					<dl>
						<c:forEach items="${Specifications }" varStatus="index" var="item">
							<dt class='sku-module_title'>${ item.specifications_name}</dt>
							<dd class='sku-module_content'>
								<ul class='list_item'>
									<c:forEach items="${value[index.index] }" var="va" varStatus="x">
										<li class="sku-module_item ${x.index==0?'sku_checked': ''}" productid='${va.id }'>${va.value }</li>
									</c:forEach>
								</ul>
							</dd>
						</c:forEach>
					</dl>
					<dl>
						<dt class='sku-module_title'>数量</dt>
						<dd class='sku-module_content'>
							<div class='number_item'>
								<label class='an num_left'>-</label>
								<input type="hidden" value="${product.purchase_limit }" class='limit'>
								<span class='number'>1</span>
								<label class='an num_rigth'>+</label>
							</div>
							<span class='shu'>(仅限购${product.purchase_limit }件)</span>
						</dd>
					</dl>
					<div class='settle'>
						<div class='settle_total clearfix'>
							<p class='price'></p>
							<p class='info'></p>
						</div>
						<div class='settle_oper'>
							<input type="hidden" class='addS' sku=''>
							<button class='addshopping shop'>加入购物车</button>
							<button class='brand shop'>立即购买</button>
						</div>
					</div>
				</div>
			</div>
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
					<p class="setting">温馨提示：该商品已经添加到了购物车</p>
				</div>
				<div class="message_box_footer">
					<button>确定</button>
				</div>
			</div>
		</div>
	<%@include file="../../html/footer.jsp" %>
</body>
</html>