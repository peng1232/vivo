<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>密码修改</title>
<link rel="icon name" href="../../img/favicon.ico" />
<script src="../../js/jquery.min.js"/></script>
<link href="../../css/grzx.css" rel="stylesheet" />
<link href="../../css/nav.css" rel="stylesheet" />
<link href="../../css/footer.css" rel="stylesheet" />
<link href="../../css/zhuce.css" rel="stylesheet"/>
<script src="../../js/zhece.js"></script>
<script src="../../js/nav.js"></script>
<script src="../../js/login.js"></script>

<style>
	#xiu{
		background-color: #456fff;
	    background-image: linear-gradient(90deg, #418eff, #4566ff);
	    color: #fff;
	    display: block;
	    font-size: 17px;
	    height: 48px;
	    line-height: 48px;
	    margin: 20px auto 0;
	    border-radius: 5px;
	}
	/* 弹窗 */
.message{
	width: 100%;
	height: 100vh;
	position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    text-align: center;
	z-index: 99999;
	display: none;
}
.zhe{
	width: 100%;
	height: 100vh;
	background-color: #000;
	opacity: 0;
	transition: 0.3s;
}
.message_box{
	width: 492px;
    padding: 35px 0 46px;
	display: inline-block;
    vertical-align: middle;
    background-color: #fff;
    border-radius: 4px;
    border: 1px solid #ebeef5;
    font-size: 18px;
    box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
    text-align: left;
    overflow: hidden;
    backface-visibility: hidden;
	position: absolute;
	top: 32%;
	left: 0;
	right: 0;
	transform: scale(0) translateY(-100%);
	transition: 0.3s;
}
.message_box_head{
	padding: 0 ;
    margin: 25px 0 15px;
    text-align: center;
    min-height: 20px;
	position: relative;
}
.message_box_head span{
	font-size: 21px;
    color: #333;
}
.guan{
	position: absolute;
	top: -45px;
    right: 15px;
	cursor: pointer;
	transition: 0.3s;
}
.guan:hover>path{
	fill: #415fff;
}
.message_box_center{
	color: #606266;
    font-size: 14px;
	padding: 0 15px 40px;
}
.message_box_footer{
	padding: 5px 15px 0;    
	text-align: center;
}
.message_box_center p{
	text-align: center;
    color: #000;
}
.message_box_footer button{
	margin-right: 0;
	border: none;
    color: #fff;
    background-image: linear-gradient(270deg, #ff0c53, #e51422);
	display: inline-block;
    width: 154px;
    height: 39px;
    line-height: 39px;
    text-align: center;
    box-sizing: border-box;
    color: #fff;
    font-size: 18px;
    border-radius: 100px;
    user-select: none;
    outline: none;
    border: none;
	cursor: pointer;
}
</style>

</head>
<body>
<%@include file="../../html/nav.jsp" %>
	<div class="container">
		<div class="menu">
			<a href="商城首页.html">商城首页</a>
			<a href="grzx.jsp"><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a>
			<a href=""><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">修改密码</a>
		</div>	
		<div class="under">
			<%@include file="zxzuo.jsp" %>
			<div class="right">
				<div class="content">
					<div class="logo">
						<div class="title_p">修改密码</div>
						<form action="" method="post" id="sub">
							<div class="form_item">
								<input required class="inp" name='phone' type="text"/>
								<span class="bar"></span>
								<label for="username">手机号</label>
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
								<input maxlength="20" name='password' required class="inp mima" type="password"/>
								<span class="bar"></span>
								<label for="username">输入新密码</label>
								<div class="yzm" id='biyan'>
									<svg t="1710989804028" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4259" width="24" height="24"><path d="M362.072 653.424a32.258 32.258 0 0 1-2.072 4.289l-56 96.995c-8.837 15.305-28.407 20.549-43.713 11.712-15.305-8.836-20.55-28.407-11.713-43.712l53.776-93.143a486.087 486.087 0 0 1-87.604-54.065 32.192 32.192 0 0 1-3.668 4.382l-79.196 79.196c-12.497 12.497-32.758 12.497-45.255 0-12.496-12.497-12.496-32.758 0-45.255l79.196-79.196c0.425-0.424 0.859-0.835 1.3-1.23C124.187 490.145 89.328 438.862 65 382c-4-20 7-32 19-37s28-5 51.628 37C205.327 519.083 347.71 613 512.03 613c164.32 0 306.703-93.917 376.403-231C912 344 926 342 941 348s24 19 18.061 34c-23.898 55.86-57.96 106.336-99.86 149.102a32.099 32.099 0 0 1 5.681 4.525l79.196 79.196c12.497 12.497 12.497 32.758 0 45.255s-32.758 12.497-45.255 0l-79.196-79.196a31.955 31.955 0 0 1-6.16-8.633 486.308 486.308 0 0 1-87.117 55.064l55.076 95.395c8.836 15.305 3.592 34.876-11.713 43.712-15.306 8.837-34.876 3.593-43.713-11.712l-56-96.995a32.136 32.136 0 0 1-2.705-6.042c-38.28 12.897-78.693 21.156-120.57 24.11 0.181 1.38 0.275 2.789 0.275 4.219v112c0 17.673-14.327 32-32 32-17.673 0-32-14.327-32-32V680c0-1.3 0.077-2.58 0.228-3.84-42.044-2.457-82.653-10.259-121.156-22.736z" fill="#d1d1d1" p-id="4260"></path></svg>
									<svg t="1710990477581" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5356" width="24" height="24"><path d="M512 204.8C233.984 204.8 51.2 483.84 51.2 483.84S186.368 819.2 512 819.2s460.8-335.36 460.8-335.36S790.016 204.8 512 204.8z m0 502.272A200.192 200.192 0 0 1 307.2 512a200.192 200.192 0 0 1 204.8-195.072A200.192 200.192 0 0 1 716.8 512a200.192 200.192 0 0 1-204.8 195.072zM512 409.6a102.4 102.4 0 1 0 102.4 102.4 102.4 102.4 0 0 0-102.4-102.4z" fill="#d1d1d1" p-id="5357"></path></svg>
								</div>
							</div>
							<div class="tishi mi"></div>
							<div class="xg" style="margin-left: 250px;">
								<a href="xgmm.jsp">切换修改方式</a>
							</div>
							<!-- 修改 -->
							<div id="xiu" class="btn">确认</div>
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
				<p class="setting">温馨提示：商品抢购数量超出限制</p>
			</div>
			<div class="message_box_footer">
				<button>确定</button>
			</div>
		</div>
	</div>
<%@include file="../../html/footer.jsp" %>
<script type="text/javascript">
	$(function(){
	    $('#xiu').click(function(){
	        var user_id = $('.user_id').val();
	        var userjiu = $('.user_password').val();
	        var rujiu = $('.jiuma').val();
	        var password = $('.xinma').val();
	        if(userjiu == rujiu){
	        	$.getJSON('UpdatePasswordServlet',{'user_id':user_id,'password':password},function(){
					$('.setting').text('密码修改成功');	
				 	kai();
				});
	        } else {  
	            $('.setting').text('用户名或密码错误');
	            kai();
	        }
	    });
	    
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