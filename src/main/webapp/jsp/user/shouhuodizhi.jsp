<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon name" href="../../img/favicon.ico" />
<title>收货地址</title>
</head>

<body>
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<link href="../../css/nav.css" rel="stylesheet"/>
<script src="../../js/nav.js"></script>
<link href="../../css/footer.css" rel="stylesheet" />
<link href="../../css/shouhuodizhi.css" rel="stylesheet" />

</body>

<%@include file="../../html/nav.jsp" %>

 <div class="container">
        <div class="menu">
            <a href="商城首页.html">商城首页</a>
            <a href="grzx.html"><img class="arrow" src="img/../../向右箭头.png" alt="../../右箭头">个人中心</a>
        </div>
		<div class="under">
			<%@include file="../../html/zxzuo.jsp" %>
			<div class="right">
				<div class="title">
					<span class="num">收货地址</span>
					<span class="tip">(最多可添加20个收货地址)</span>
				</div>
				
				<div class="address-info">
					<ul class="adress-list">
						<li class="address-itemn new_address"><label class="inner">添加新地址</label></li>
						<li class="address-itemn">
							<div class="z1">
							<span class="z2">默认地址</span>
							<span class="z2">删除</span>
							<span class="z3">编辑</span>
							</div>
							<div class="item-top">
								<span class="w1">大土豆</span>
								<span class="w2">12345678900</span>
							</div>
							<div class="c1">
								<div class="mlellipsis">
									<p > 湖南省 株洲市 石峰区 人民北路 </p>
								</div>
							</div>
						</li>
						
				</div>
			</div>
		</div>
    </div>
	
	
			<div class="message">
				<div class="zhe"></div>
				<div class="message_box">
					<div class="message_box_head">
						<span>新建收货地址</span>
						<svg class="guan" t="1710744510048" class="icon" viewBox="0 0 1024 1024" version="1.1"
							xmlns="http://www.w3.org/2000/svg" p-id="7727" width="16" height="16">
							<path
								d="M590.7456 508.416 1016.832 934.5024 938.0864 1009.664 512 583.5776 78.7456 1024 0 941.6704l433.2544-440.4224L7.168 75.1616 85.9136 0 512 426.0864 938.0864 0 1016.832 82.3296 590.7456 508.416z"
								p-id="7728" fill="#242933"></path>
						</svg>
					</div>
					<div class="item">
						<span class="das">收货人:</span>
						<input type="text" class="enter"/>
						<span class="error-tip"></span>
					</div>
					
					<div class="item">
						<span class="das">手机号码:</span>
						<input type="text" class="enter"/>
						<span class="error-tip"></span>
					</div>
					
					<div class="item">
						<span class="das">收货地区:</span>
						<select id="province">
								<option>请选择</option>
							</select>
							<select id="city">
								<option>请选择</option>
								<option>请选择</option>
								<option>请选择</option>
								<option>请选择</option>
								
							</select>
							<select id="district">
								<option>请选择</option>
							</select>
					</div>
					
					<div class="item">
						<span class="das">详细地址:</span>
						<input type="text" class="enter"/>
						<span class="error-tip"></span>
					</div>
					
					<div class="item_1">
						<input type="checkbox" name="interest" value="music">
						<span class="agreement_text">设为默认地址</span>
					</div>
					<div class="message_box_footer">
						<button>保存</button>
					</div>
				</div>
			</div>
			<script>
				$(function(){
					$('.new_address').click(function(){
						kai();
						
					})
					//弹窗点击时间
					$('.message_box_footer button').click(function(){
						guanbi();
					})
					$('.zhe').click(function(){
						guanbi();
					})
					$('.guan').click(function(){
						guanbi();
					})
					//开启弹窗
					function kai(){
						$('body').css('overflow-x',"hidden").css("overflow-y",'hidden')
						$('.message').css('display','block');
						$(".zhe").animate({
							opacity: 0.6
						},100)
						$('.message_box').css('transform','scale(1) translateY(0%)');
					}
					
					//关闭弹窗
					function guanbi(){
						$('body').css('overflow-x',"auto").css("overflow-y",'auto')
						$(".zhe").animate({
							opacity: 0
						},100)
						$('.message_box').css('transform','scale(0) translateY(-100%)');
						setTimeout(function(){
							$('.message').css('display','none');
						},300)
						
					}
				})
				
			</script>
			
			
			
			
					<div class="message">
						<div class="zhe"></div>
						<div class="message_box">
							<div class="message_box_head">
								<span>修改收货地址</span>
								<svg class="guan" t="1710744510048" class="icon" viewBox="0 0 1024 1024" version="1.1"
									xmlns="http://www.w3.org/2000/svg" p-id="7727" width="16" height="16">
									<path
										d="M590.7456 508.416 1016.832 934.5024 938.0864 1009.664 512 583.5776 78.7456 1024 0 941.6704l433.2544-440.4224L7.168 75.1616 85.9136 0 512 426.0864 938.0864 0 1016.832 82.3296 590.7456 508.416z"
										p-id="7728" fill="#242933"></path>
								</svg>
							</div>
							<div class="item">
								<span class="das">收货人:</span>
								<input type="text" class="enter"/>
								<span class="error-tip"></span>
							</div>
							
							<div class="item">
								<span class="das">手机号码:</span>
								<input type="text" class="enter"/>
								<span class="error-tip"></span>
							</div>
							
							<div class="item">
								<span class="das">收货地区:</span>
								<select id="province">
										<option>请选择</option>
									</select>
									<select id="city">
										<option>请选择</option>
										<option>请选择</option>
										<option>请选择</option>
										<option>请选择</option>
										
									</select>
									<select id="district">
										<option>请选择</option>
									</select>
							</div>
							
							<div class="item">
								<span class="das">详细地址:</span>
								<input type="text" class="enter"/>
								<span class="error-tip"></span>
							</div>
							
							<div class="item_1">
								<input type="checkbox" name="interest" value="music">
								<span class="agreement_text">设为默认地址</span>
							</div>
							<div class="message_box_footer">
								<button>保存</button>
							</div>
						</div>
					</div>
					<script>
						$(function(){
							$('.z3').click(function(){
								kai();
								
							})
							//弹窗点击时间
							$('.message_box_footer button').click(function(){
								guanbi();
							})
							$('.zhe').click(function(){
								guanbi();
							})
							$('.guan').click(function(){
								guanbi();
							})
							//开启弹窗
							function kai(){
								$('body').css('overflow-x',"hidden").css("overflow-y",'hidden')
								$('.message').css('display','block');
								$(".zhe").animate({
									opacity: 0.6
								},100)
								$('.message_box').css('transform','scale(1) translateY(0%)');
							}
							
							//关闭弹窗
							function guanbi(){
								$('body').css('overflow-x',"auto").css("overflow-y",'auto')
								$(".zhe").animate({
									opacity: 0
								},100)
								$('.message_box').css('transform','scale(0) translateY(-100%)');
								setTimeout(function(){
									$('.message').css('display','none');
								},300)
								
							}
						})
						
					</script>

	<%@include file="../../html/footer.jsp" %>

</html>