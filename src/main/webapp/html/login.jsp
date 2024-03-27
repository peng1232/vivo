<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/login.css" rel="stylesheet" />
<script src="../js/jquery.min.js"></script>
<script src="../js/login.js"></script>
</head>
<body>
	<div class="content">
			<div class="cont">
				<img  src="../img/vivo.jpg"/>
				<a class="logo" href="#">
					<svg t="1710484912269" class="icon" viewBox="0 0 3955 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="18945" width="105" height="35"><path d="M3527.00666668 662.45955316H3190.66785071c-189.062619 0-205.860947-155.884759-205.86094698-203.44124301 0-47.603017 16.798328-203.44124299 205.86094698-203.44124298h336.33881597c189.062619 0 205.90748 155.83822602 205.90748006 203.44124298 0 47.603017-16.84486 203.44124299-205.90748006 203.44124303z m7.30564405-577.47159797h-337.827865c-351.08970301 0-382.313187 286.502227-382.31318702 374.03035496 0 87.528129 31.223485 374.030355 382.31318702 374.03035499h337.827865c351.136236 0 382.35971999-286.502227 382.35971998-374.03035499 0-87.528129-31.27001699-374.076888-382.35971998-374.07688796zM2746.65221771 111.18590121h-109.53812599c-46.90502599 0-56.53730801 7.91056999-74.63855299 34.38771194-18.14777799 26.477143-331.35981101 498.22630199-331.35981102 498.22630204-10.00454401 14.51822199-20.61401401 20.38135098-33.78278601 20.38135098-13.21530501 0-23.77824201-5.863128-33.78278702-20.38135098 0 0-313.305099-471.74915902-331.406343-498.22630204-18.054712-26.523675-27.733527-34.38771201-74.63855295-34.38771194h-109.53812598c-25.17422499 0-36.760883 19.45069501-20.89321101 43.18240494l374.16995299 560.39407401C2059.31676373 798.98668218 2101.89424276 833.04866514 2197.33294172 833.04866514c95.39216599 0 138.016177-34.06198301 196.08906602-118.28628498l374.12342099-560.39407401c15.82114-23.73170998 4.327547-43.18240499-20.89321102-43.182405z m-1441.817686 45.78823892c0-32.80559801 12.79650999-45.78824002 45.13678102-45.78823898h80.40861602c32.29373799 0 45.090248 13.02917398 45.09024794 45.78823898v630.28628606c0 32.80559801-12.79650999 45.78824002-45.09024794 45.78823895h-80.45514904c-32.29373799 0-45.090248-13.02917398-45.090248-45.78823895V156.97414013z m-6.70071797-199.71862198c-26.058348-26.058348-26.058348-46.67236199 0-72.73070997L1353.78699974-171.12837685c26.058348-26.058348 46.67236199-26.058348 72.73071 0l55.699718 55.65318503c26.01181504 26.058348 26.01181504 46.67236199 0 72.73070997l-55.699718 55.65318604c-26.058348 26.058348-46.67236199 26.058348-72.73071 0L1298.18034675-42.69794882z m-166.401163 153.930383h-109.398528c-46.85849302 0-56.53730801 7.91056999-74.59202003 34.387712-18.101245 26.477143-331.03408201 498.22630199-331.03408196 498.22630204-9.958011 14.47169001-20.56748199 20.38135098-33.73625305 20.38135094s-23.73170998-5.90966105-33.73625398-20.38135094c0 0-312.932836-471.795692-330.98754897-498.22630204-18.101245-26.477143-27.733527-34.38771201-74.59202001-34.38771194H34.25741677c-28.105789 0-36.760883 19.45069501-20.89321101 43.18240494l373.75115899 560.39407401C445.0951887 798.98668218 487.67266671 833.04866514 583.01829973 833.04866514c95.252567 0 137.83004599-34.06198301 195.80986999-118.28628498l373.75115899-560.39407401c15.82114-23.73170998 7.25911101-43.18240499-20.84667797-43.182405z" fill="#fff" p-id="18946"  class="logo"></path></svg>
				</a>
				
				<div class="from">
					<div class="form_info">
						<div class="info_top clearfix">
							<span class="avtive dian border">短信验证码登录</span>
							<span class="avtive">密码登录</span>
						</div>
						<div class="an_xian" value='0'></div>
						
						<div class="biaodan">
							<!-- 手机号码 -->
							<div class="info_phone">
								
								<div class="form_item">
									<input required class="inp" type="text"/>
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
								
							</div>
							<!-- 密码 -->
							<div class="info_name">
								<div class="form_item">
									<input required class="inp" type="text"/>
									<span class="bar"></span>
									<label for="username">手机号</label>
								</div>
								<div class="tishi ji"></div>
								<div class="form_item">
									<input maxlength="20" required class="inp mima" type="password"/>
									<span class="bar"></span>
									<label for="username">密码</label>
									<div class="yzm" id='biyan'>
										<svg t="1710989804028" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4259" width="24" height="24"><path d="M362.072 653.424a32.258 32.258 0 0 1-2.072 4.289l-56 96.995c-8.837 15.305-28.407 20.549-43.713 11.712-15.305-8.836-20.55-28.407-11.713-43.712l53.776-93.143a486.087 486.087 0 0 1-87.604-54.065 32.192 32.192 0 0 1-3.668 4.382l-79.196 79.196c-12.497 12.497-32.758 12.497-45.255 0-12.496-12.497-12.496-32.758 0-45.255l79.196-79.196c0.425-0.424 0.859-0.835 1.3-1.23C124.187 490.145 89.328 438.862 65 382c-4-20 7-32 19-37s28-5 51.628 37C205.327 519.083 347.71 613 512.03 613c164.32 0 306.703-93.917 376.403-231C912 344 926 342 941 348s24 19 18.061 34c-23.898 55.86-57.96 106.336-99.86 149.102a32.099 32.099 0 0 1 5.681 4.525l79.196 79.196c12.497 12.497 12.497 32.758 0 45.255s-32.758 12.497-45.255 0l-79.196-79.196a31.955 31.955 0 0 1-6.16-8.633 486.308 486.308 0 0 1-87.117 55.064l55.076 95.395c8.836 15.305 3.592 34.876-11.713 43.712-15.306 8.837-34.876 3.593-43.713-11.712l-56-96.995a32.136 32.136 0 0 1-2.705-6.042c-38.28 12.897-78.693 21.156-120.57 24.11 0.181 1.38 0.275 2.789 0.275 4.219v112c0 17.673-14.327 32-32 32-17.673 0-32-14.327-32-32V680c0-1.3 0.077-2.58 0.228-3.84-42.044-2.457-82.653-10.259-121.156-22.736z" fill="#d1d1d1" p-id="4260"></path></svg>
										<svg t="1710990477581" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5356" width="24" height="24"><path d="M512 204.8C233.984 204.8 51.2 483.84 51.2 483.84S186.368 819.2 512 819.2s460.8-335.36 460.8-335.36S790.016 204.8 512 204.8z m0 502.272A200.192 200.192 0 0 1 307.2 512a200.192 200.192 0 0 1 204.8-195.072A200.192 200.192 0 0 1 716.8 512a200.192 200.192 0 0 1-204.8 195.072zM512 409.6a102.4 102.4 0 1 0 102.4 102.4 102.4 102.4 0 0 0-102.4-102.4z" fill="#d1d1d1" p-id="5357"></path></svg>
									</div>
								</div>
								<div class="tishi mi"></div>
							</div>
						</div>
						
						<div class="state">
							<span>
								<label>
									<input  type="checkbox"/>
									两周内自动登录
								</label>
							</span>
							<span class="furight">
								<a href="#">登录遇到了问题</a>
							</span>
						</div>
						
						<!-- 登录 -->
						<div id="denglu" class="btn">登录</div>
						<!-- 注册 -->
						<div id="zhuce" class="btn">注册vivo账号</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>