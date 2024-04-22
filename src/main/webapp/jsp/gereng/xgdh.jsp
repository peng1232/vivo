<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>电话修改</title>
<script src="../../js/jquery.min.js"/></script>
<link rel="icon name" href="../../img/favicon.ico" />
<link href="../../css/grzx.css" rel="stylesheet" />
<link href="../../css/nav.css" rel="stylesheet" />
<link href="../../css/footer.css" rel="stylesheet" />
<link href="../../css/zhuce.css" rel="stylesheet"/>
<script src="../../js/duanghua.js"></script>
<script src="../../js/nav.js"></script>
</head>
<body>
<%@include file="../../html/nav.jsp" %>
	<div class="container">
		<div class="menu">
				<a href="../qian/shouye.jsp">商城首页</a>
			<a href="grzx.jsp"><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a>
			<a href=""><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">修改电话号码</a>
		</div>
		<div class="under">
			<%@include file="zxzuo.jsp" %>
			<div class="right">
				<div class="content">
					<div class="logo">
						<div class="title_p">电话修改</div>
						<form action="" method="post" id="sub">
							<div class="form_item">
								<input required class="inp" name='phone' type="text"/>
								<span class="bar"></span>
								<label for="username">输入旧手机号</label>
							</div>
							<div class="tishi shou"></div>
							<div class="form_item">
								<input maxlength="6" required class="inp" type="text"/>
								<span class="bar"></span>
								<label for="username">验证码</label>
								<div class="yzm">
									<span class="feng"></span>
									<span id="huoqu">获取验证码</span>
								</div>
							</div>
							<div class="tishi yang"></div>
							<div class="form_item">
								<input required class="inp" name='phone' type="text"/>
								<span class="bar"></span>
								<label for="username">输入新手机号</label>
							</div>
							<div class="tishi mi"></div>
							<!-- 修改 -->
							<div id="zhuce" class="btn updatephone">确认</div>
						</form>
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
				<p class="setting">温馨提示：</p>
			</div>
			<div class="message_box_footer">
				<button>确定</button>
			</div>
		</div>
	</div>
<%@include file="../../html/footer.jsp" %>
<script type="text/javascript">
	$(function(){	
	   
	    
	    $('.message_box_footer button').click(function(){
	        guanbi();
	    });
	    $('.zhe').click(function(){
	        guanbi();
	    });
	    $('.guan').click(function(){
	        guanbi();
	    });
		
	    function kai(){
	        $('body').css('overflow', 'hidden');
	        $('.message').fadeIn();
	        $(".zhe").fadeIn().css('opacity', '0.6');
	        $('.message_box').css('transform', 'scale(1) translateY(0%)');
	    }
	    
	    function guanbi(){
	        $('body').css('overflow', 'auto');
	        $(".zhe").fadeOut();
	        $('.message_box').css('transform', 'scale(0) translateY(-100%)');
	        setTimeout(function(){
	            $('.message').fadeOut();
	        }, 300);
	    }
	});
</script>
</body>
</html>