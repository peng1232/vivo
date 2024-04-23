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