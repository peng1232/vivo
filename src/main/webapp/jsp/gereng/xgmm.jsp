<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>密码修改</title>
<link rel="icon name" href="../../img/favicon.ico" />
<link href="../../css/grzx.css" rel="stylesheet" />
<link href="../../css/nav.css" rel="stylesheet" />
<link href="../../css/footer.css" rel="stylesheet" />
<link href="../../css/zhuce.css" rel="stylesheet"/>
<script src="../../js/zhece.js"></script>
<script src="../../js/jquery.min.js"/></script>
<script src="../../js/nav.js"></script>
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
			<div class="left">
				<img src="../../img/h.jpeg" class="tx">
				<ul id="user_muem_item">
					<li class="z">vivo34177786273</li>
						
					<li class="z">交易管理</li>
					<li class="s"><a href="#">我的订单</a></li>
					<li class="s"><a href="tksh.jsp">退款/售后</a></li>

					<li class="z">评价管理</li>
					<li class="s"><a href="#">评价晒单</a></li>

					<li class="z">我的账户</li>
					<li class="s"><a href="xgmm.jsp">修改密码</a></li>
					<li class="s"><a href="xgdh.jsp">修改电话号码</a></li>
					<li class="s"><a href="grxx.jsp">个人资料</a></li>
					<li class="s"><a href="#">收货地址</a></li>
					<li class="s"><a href="#">我的收藏</a></li>
				</ul>
			</div>
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
								<input maxlength="20" required class="inp mima" type="password"/>
								<span class="bar"></span>
								<label for="username">输入旧密码</label>
								<div class="yzm" id='biyan'>
									<svg t="1710989804028" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4259" width="24" height="24"><path d="M362.072 653.424a32.258 32.258 0 0 1-2.072 4.289l-56 96.995c-8.837 15.305-28.407 20.549-43.713 11.712-15.305-8.836-20.55-28.407-11.713-43.712l53.776-93.143a486.087 486.087 0 0 1-87.604-54.065 32.192 32.192 0 0 1-3.668 4.382l-79.196 79.196c-12.497 12.497-32.758 12.497-45.255 0-12.496-12.497-12.496-32.758 0-45.255l79.196-79.196c0.425-0.424 0.859-0.835 1.3-1.23C124.187 490.145 89.328 438.862 65 382c-4-20 7-32 19-37s28-5 51.628 37C205.327 519.083 347.71 613 512.03 613c164.32 0 306.703-93.917 376.403-231C912 344 926 342 941 348s24 19 18.061 34c-23.898 55.86-57.96 106.336-99.86 149.102a32.099 32.099 0 0 1 5.681 4.525l79.196 79.196c12.497 12.497 12.497 32.758 0 45.255s-32.758 12.497-45.255 0l-79.196-79.196a31.955 31.955 0 0 1-6.16-8.633 486.308 486.308 0 0 1-87.117 55.064l55.076 95.395c8.836 15.305 3.592 34.876-11.713 43.712-15.306 8.837-34.876 3.593-43.713-11.712l-56-96.995a32.136 32.136 0 0 1-2.705-6.042c-38.28 12.897-78.693 21.156-120.57 24.11 0.181 1.38 0.275 2.789 0.275 4.219v112c0 17.673-14.327 32-32 32-17.673 0-32-14.327-32-32V680c0-1.3 0.077-2.58 0.228-3.84-42.044-2.457-82.653-10.259-121.156-22.736z" fill="#d1d1d1" p-id="4260"></path></svg>
									<svg t="1710990477581" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5356" width="24" height="24"><path d="M512 204.8C233.984 204.8 51.2 483.84 51.2 483.84S186.368 819.2 512 819.2s460.8-335.36 460.8-335.36S790.016 204.8 512 204.8z m0 502.272A200.192 200.192 0 0 1 307.2 512a200.192 200.192 0 0 1 204.8-195.072A200.192 200.192 0 0 1 716.8 512a200.192 200.192 0 0 1-204.8 195.072zM512 409.6a102.4 102.4 0 1 0 102.4 102.4 102.4 102.4 0 0 0-102.4-102.4z" fill="#d1d1d1" p-id="5357"></path></svg>
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
							<!-- 修改 -->
							<div id="zhuce" class="btn">确认</div>
						</form>
					</div>
				</div>		
			</div>	
		</div>
	</div>
<%@include file="../../html/footer.jsp" %>
</body>
</html>