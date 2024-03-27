<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/nav.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script src="../js/nav.js"></script>
</head> -->
<body>
	<header id="head">
		<div class="vp_head">
			<div class="head_top">
				<div>
					<ul class="head_navs">
						<li><a href="#" class="navs">品牌</a></li>
						<li><a href="#" class="navs">OriginOS</a></li>
						<li><a href="#" class="navs">体验店</a></li>
						<li><a href="#" class="navs">官网社区</a></li>
					</ul>
					<div class="head_top_right">
						<div class="fl">
							<a class="navs">购物车(2)</a>
						</div>
						<div class="fl wei">
							<span class="navs">个人中心</span>
							<div class="user_meun">
								<div class="nav_nr"></div>
								<div class="menu_item">
									<a href="#"> <span class="svg"> <svg
												t="1710472561959" class="icon" viewBox="0 0 1024 1024"
												version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4303"
												width="16" height="16">
												<path
													d="M760.3 79H277.1c-56.6 0-102.4 45.8-102.4 102.4l-60 665.6c0 56.5 45.8 102.4 102.4 102.4h603.2c56.6 0 102.4-45.8 102.4-102.4l-60-665.6c0-56.6-45.9-102.4-102.4-102.4z m112.4 768c0 28.9-23.5 52.4-52.4 52.4H217.1c-28.9 0-52.4-23.5-52.4-52.4l60-665.6c0-28.9 23.5-52.4 52.4-52.4h483.2c28.9 0 52.4 23.5 52.4 52.4l60 665.6z"
													p-id="4304" fill="#242933"></path>
												<path
													d="M363.5 325.2m-42 0a42 42 0 1 0 84 0 42 42 0 1 0-84 0Z"
													p-id="4305" fill="#242933"></path>
												<path
													d="M674 325.2m-42 0a42 42 0 1 0 84 0 42 42 0 1 0-84 0Z"
													p-id="4306" fill="#242933"></path>
												<path
													d="M642.9 336.1c-4.4 25.9-16.8 49.8-36 68.6-23.2 22.7-54.5 35.7-87 36-34.1 0.3-66.3-12.8-90.3-36.9-18.7-18.7-30.8-42.3-35.1-67.8-2.1-12.2-12.5-21.3-24.9-21.3h-1.5c-15.7 0-27.5 14.1-24.9 29.6 14.1 84.2 87.3 148.4 175.6 148.4 88.2 0 161.5-64.2 175.6-148.4 2.6-15.5-9.2-29.6-24.9-29.6H668c-12.6 0.1-23 9.1-25.1 21.4z"
													p-id="4307" fill="#242933"></path></svg>
									</span> <span>我的商城</span>
									</a>
								</div>
								<div class="menu_item">
									<a href="#"> <span class="svg"> <svg
												t="1710473283052" class="icon" viewBox="0 0 1024 1024"
												version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5465"
												width="16" height="16">
												<path
													d="M688.028165 744.730319H289.417241c-18.245619 0-33.419272 10.379523-33.419272 23.272474s14.708203 23.272473 33.419272 23.272473h398.610924c18.245619 0 33.419272-10.379523 33.419272-23.272473s-15.173653-23.272473-33.419272-23.272474z"
													fill="#242933" p-id="5466"></path>
												<path
													d="M679.650075 0.104261v1.023989c-4.189045 0-22.527754-1.535983-68.653797-1.023989H207.125775C131.117877 0.104261 69.818182 60.519602 69.818182 134.758792v754.586677C69.818182 963.584659 131.117877 1024 207.125775 1024h609.738803c76.007898 0 137.307593-60.415341 137.307593-134.654531V269.366778L679.650075 0.150806z m207.962822 271.357039l-139.867565-2.047977h4.701039c-31.929833 0-76.985342-30.254215-76.985342-67.071269l-1.070533-139.26248 213.222401 208.381726z m7.354101 627.612063c0 37.887587-31.417839 69.119246-70.189779 69.119246H199.213134c-38.771941 0-70.18978-30.719665-70.18978-69.119246V125.542892c0-37.887587 31.417839-69.119246 70.18978-69.119246h412.853678a4386.395785 4386.395785 0 0 0 1.023989 137.726498c0 76.287168 62.882223 137.726498 140.938099 137.726497h140.938098v567.196722z"
													fill="#242933" p-id="5467"></path>
												<path
													d="M688.028165 513.727748H289.417241c-18.245619 0-33.419272 10.007164-33.419272 22.38812 0 12.427501 14.708203 22.434664 33.419272 22.434664h398.610924c18.245619 0 33.419272-10.007164 33.419272-22.434664 0-12.380956-15.173653-22.388119-33.419272-22.38812zM524.422677 325.825798h-247.619117C265.074234 325.825798 255.997969 335.832962 255.997969 348.260463c0 12.380956 9.12281 22.388119 20.759046 22.388119h247.665662c11.636237 0 20.759046-10.007164 20.759046-22.388119 0-12.427501-9.12281-22.434664-20.759046-22.434665z"
													fill="#242933" p-id="5468"></path></svg>
									</span> <span>我的订单</span>
									</a>
								</div>
								<div class="menu_item">
									<a href="#"> <span class="svg"> <svg
												t="1710473512978" class="icon" viewBox="0 0 1024 1024"
												version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6781"
												width="16" height="16">
												<path
													d="M640 542.72c76.8-44.8 128-128 128-217.6 0-140.8-115.2-256-256-256s-256 108.8-256 249.6c0 96 51.2 172.8 128 217.6-166.4 51.2-281.6 204.8-288 384 0 25.6 12.8 38.4 32 38.4s32-12.8 32-32c6.4-192 160-345.6 352-345.6s345.6 153.6 352 345.6c0 19.2 12.8 32 32 32s32-12.8 32-32c-6.4-179.2-121.6-332.8-288-384z m-320-224c0-108.8 83.2-192 192-192s192 83.2 192 192-83.2 192-192 192-192-83.2-192-192z"
													fill="#242933" p-id="6782"></path></svg>
									</span> <span>账号中心</span>
									</a>
								</div>
								<div class="menu_item">
									<a href="#"> <span class="svg"> <svg
												t="1710484307108" class="icon" viewBox="0 0 1024 1024"
												version="1.1" xmlns="http://www.w3.org/2000/svg"
												p-id="16517" width="16" height="16">
												<path
													d="M511.338 421.875l-221.281 238.02 64.44 60 110.79-119.221v336.521h92.16v-336.47l110.795 119.17 64.432-60z"
													fill="#242933" p-id="16518"></path>
												<path
													d="M882.262 86.803H141.739C63.463 86.803 0.007 150.259 0.007 228.535v566.929c0 78.276 63.456 141.732 141.732 141.732h157.663v-80H141.739c-34.039 0-61.732-27.693-61.732-61.732V228.536c0-34.04 27.693-61.732 61.732-61.732h740.522c34.04 0 61.732 27.693 61.732 61.732v566.929c0 34.039-27.692 61.732-61.732 61.732H724.6v80h157.662c78.276 0 141.732-63.456 141.732-141.732V228.536c0-78.277-63.456-141.733-141.732-141.733z"
													fill="#242933" p-id="16519"></path></svg>
									</span> <span>登录</span>
									</a>
								</div>
								<div class="menu_item">
									<a href="#"> <span class="svg"> <svg
												t="1710484374112" class="icon" viewBox="0 0 1024 1024"
												version="1.1" xmlns="http://www.w3.org/2000/svg"
												p-id="17807" width="16" height="16">
												<path
													d="M752.779277 614.774544c22.772498 0 41.198849-18.466262 41.198849-41.195779 0-13.119284-6.122673-24.787464-15.663319-32.329517l0.212856-0.25993c-31.702207-24.541861-66.94621-44.657755-105.004413-59.222002 48.439015-41.559066 79.256028-103.114295 79.256028-171.951647 0-125.12133-101.463639-226.585993-226.585993-226.585993-125.123377 0-226.587016 101.464663-226.587016 226.585993 0 68.837352 30.818036 130.392581 79.257051 171.951647-154.571154 59.301823-264.565398 208.763415-264.646242 384.297793l0 0.079821c0.080844 22.689607 18.507195 41.118004 41.198849 41.118004 22.770451 0 41.116981-18.428398 41.196802-41.118004 0-181.727662 147.894851-329.58158 329.58158-329.58158 74.497474 0 143.081036 25.128238 198.294595 66.945187C731.868244 610.484682 741.817205 614.774544 752.779277 614.774544zM526.193284 454.008059c-79.498561 0-144.190342-64.692805-144.190342-144.192389 0-79.498561 64.693828-144.191366 144.190342-144.191366 79.498561 0 144.191366 64.692805 144.191366 144.191366S605.691845 454.008059 526.193284 454.008059zM909.926191 752.851423 848.129453 752.851423l0-61.798785c0.001023-17.057115-13.839719-30.897857-30.897857-30.897857-17.099073 0-30.897857 13.840742-30.897857 30.897857l0 61.798785-61.796738 0c-17.097026 0-30.896834 13.838695-30.896834 30.897857 0 17.057115 13.799808 30.897857 30.896834 30.897857l61.796738 0 0 61.796738c0 17.059162 13.798785 30.895811 30.897857 30.895811 17.058139 0 30.897857-13.836649 30.897857-30.895811l0-61.796738 61.796738 0c17.058139 0 30.897857-13.840742 30.897857-30.897857C940.824049 766.691142 926.985353 752.851423 909.926191 752.851423z"
													fill="#242933" p-id="17808"></path></svg>
									</span> <span>注册</span>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="head_buttom">
				<div class="buttom_div">
					<div class="buttom_left" style="z-index: 999;">
						<svg t="1710484912269" class="icon" viewBox="0 0 3955 1024"
							version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="18945"
							width="105" height="35">
							<path
								d="M3527.00666668 662.45955316H3190.66785071c-189.062619 0-205.860947-155.884759-205.86094698-203.44124301 0-47.603017 16.798328-203.44124299 205.86094698-203.44124298h336.33881597c189.062619 0 205.90748 155.83822602 205.90748006 203.44124298 0 47.603017-16.84486 203.44124299-205.90748006 203.44124303z m7.30564405-577.47159797h-337.827865c-351.08970301 0-382.313187 286.502227-382.31318702 374.03035496 0 87.528129 31.223485 374.030355 382.31318702 374.03035499h337.827865c351.136236 0 382.35971999-286.502227 382.35971998-374.03035499 0-87.528129-31.27001699-374.076888-382.35971998-374.07688796zM2746.65221771 111.18590121h-109.53812599c-46.90502599 0-56.53730801 7.91056999-74.63855299 34.38771194-18.14777799 26.477143-331.35981101 498.22630199-331.35981102 498.22630204-10.00454401 14.51822199-20.61401401 20.38135098-33.78278601 20.38135098-13.21530501 0-23.77824201-5.863128-33.78278702-20.38135098 0 0-313.305099-471.74915902-331.406343-498.22630204-18.054712-26.523675-27.733527-34.38771201-74.63855295-34.38771194h-109.53812598c-25.17422499 0-36.760883 19.45069501-20.89321101 43.18240494l374.16995299 560.39407401C2059.31676373 798.98668218 2101.89424276 833.04866514 2197.33294172 833.04866514c95.39216599 0 138.016177-34.06198301 196.08906602-118.28628498l374.12342099-560.39407401c15.82114-23.73170998 4.327547-43.18240499-20.89321102-43.182405z m-1441.817686 45.78823892c0-32.80559801 12.79650999-45.78824002 45.13678102-45.78823898h80.40861602c32.29373799 0 45.090248 13.02917398 45.09024794 45.78823898v630.28628606c0 32.80559801-12.79650999 45.78824002-45.09024794 45.78823895h-80.45514904c-32.29373799 0-45.090248-13.02917398-45.090248-45.78823895V156.97414013z m-6.70071797-199.71862198c-26.058348-26.058348-26.058348-46.67236199 0-72.73070997L1353.78699974-171.12837685c26.058348-26.058348 46.67236199-26.058348 72.73071 0l55.699718 55.65318503c26.01181504 26.058348 26.01181504 46.67236199 0 72.73070997l-55.699718 55.65318604c-26.058348 26.058348-46.67236199 26.058348-72.73071 0L1298.18034675-42.69794882z m-166.401163 153.930383h-109.398528c-46.85849302 0-56.53730801 7.91056999-74.59202003 34.387712-18.101245 26.477143-331.03408201 498.22630199-331.03408196 498.22630204-9.958011 14.47169001-20.56748199 20.38135098-33.73625305 20.38135094s-23.73170998-5.90966105-33.73625398-20.38135094c0 0-312.932836-471.795692-330.98754897-498.22630204-18.101245-26.477143-27.733527-34.38771201-74.59202001-34.38771194H34.25741677c-28.105789 0-36.760883 19.45069501-20.89321101 43.18240494l373.75115899 560.39407401C445.0951887 798.98668218 487.67266671 833.04866514 583.01829973 833.04866514c95.252567 0 137.83004599-34.06198301 195.80986999-118.28628498l373.75115899-560.39407401c15.82114-23.73170998 7.25911101-43.18240499-20.84667797-43.182405z"
								fill="#242933" p-id="18946" class="logo"></path></svg>
					</div>
					<div class="buttom_center">
						<ul class="c_type">
							<li><a href="#">类别1</a></li>
							<li><a href="#">类别2</a></li>
							<li><a href="#">类别3</a></li>
							<li><a href="#">类别4</a></li>
						</ul>
					</div>
					<div class="buttom_right" id="search">
						<span> <svg t="1710490274077" class="icon"
								viewBox="0 0 1024 1024" version="1.1"
								xmlns="http://www.w3.org/2000/svg" p-id="13018" width="24"
								height="24">
								<path
									d="M953.474215 908.234504l-152.576516-163.241391c61.92508-74.48211 95.81186-167.36973 95.81186-265.073744 0-229.294809-186.63531-415.930119-416.102133-415.930119-229.294809 0-415.930119 186.63531-415.930119 415.930119s186.63531 415.930119 415.930119 415.930119c60.032925 0 118.00168-12.55703 172.186125-37.327062 16.169326-7.396607 23.221905-26.318159 15.825298-42.315471-7.396607-16.169326-26.318159-23.221905-42.315471-15.825298-45.927768 20.813707-94.951789 31.478582-145.695952 31.478582-194.031917 0-351.94087-157.908953-351.94087-351.94087 0-194.031917 157.908953-351.94087 351.94087-351.94087 194.031917 0 351.94087 157.908953 351.94087 351.94087 0 91.339493-34.918864 177.86259-98.048043 243.743995-12.213002 12.729044-11.868974 33.026709 0.860071 45.239711 1.032085 0.860071 2.236183 1.204099 3.268268 2.064169 0.860071 1.204099 1.376113 2.752226 2.408198 3.956325l165.477574 177.00252c6.192508 6.70855 14.793214 10.148833 23.393919 10.148833 7.912649 0 15.653284-2.92424 21.845792-8.600706C964.827146 941.433227 965.515202 921.135562 953.474215 908.234504z"
									fill="#242933" p-id="13019" class="logo"></path></svg>
						</span>
					</div>
					<svg id="close" t="1710744510048" class="icon"
						viewBox="0 0 1024 1024" version="1.1"
						xmlns="http://www.w3.org/2000/svg" p-id="7727" width="18"
						height="18">
						<path
							d="M590.7456 508.416 1016.832 934.5024 938.0864 1009.664 512 583.5776 78.7456 1024 0 941.6704l433.2544-440.4224L7.168 75.1616 85.9136 0 512 426.0864 938.0864 0 1016.832 82.3296 590.7456 508.416z"
							p-id="7728" fill="#242933"></path></svg>
				</div>
				<!-- 显示手机 -->
				<div class="bukuai_phone bukuai">
					<div>
						<div class="phone_top">
							<ul class="phone_total">
								<li><a href="#">
										<div class="item_images">
											<img
												src="https://wwwstatic.vivo.com.cn/vivoportal/files/image/navi/20231107/2a92e3c64088906138bfbacfd1fe2015.png" />
										</div>
										<p>商品名称1</p>
								</a></li>
								<li><a href="#">
										<div class="item_images">
											<img
												src="https://wwwstatic.vivo.com.cn/vivoportal/files/image/navi/20231107/2a92e3c64088906138bfbacfd1fe2015.png" />
										</div>
										<p>商品名称1</p>
								</a></li>
								<li><a href="#">
										<div class="item_images">
											<img
												src="https://wwwstatic.vivo.com.cn/vivoportal/files/image/navi/20231107/2a92e3c64088906138bfbacfd1fe2015.png" />
										</div>
										<p>商品名称1</p>
								</a></li>
								<li><a href="#">
										<div class="item_images">
											<img
												src="https://wwwstatic.vivo.com.cn/vivoportal/files/image/navi/20231107/2a92e3c64088906138bfbacfd1fe2015.png" />
										</div>
										<p>商品名称1</p>
								</a></li>
								<li><a href="#">
										<div class="item_images">
											<img
												src="https://wwwstatic.vivo.com.cn/vivoportal/files/image/navi/20231107/2a92e3c64088906138bfbacfd1fe2015.png" />
										</div>
										<p>商品名称1</p>
								</a></li>
								<li><a href="#">
										<div class="item_images">
											<img
												src="https://wwwstatic.vivo.com.cn/vivoportal/files/image/navi/20231107/2a92e3c64088906138bfbacfd1fe2015.png" />
										</div>
										<p>商品名称1</p>
								</a></li>
							</ul>
							<ul class="phone_total">
								<li><a href="#">
										<div class="item_images">
											<img
												src="https://wwwstatic.vivo.com.cn/vivoportal/files/image/navi/20231107/2a92e3c64088906138bfbacfd1fe2015.png" />
										</div>
										<p>商品名称2</p>
								</a></li>
								<li><a href="#">
										<div class="item_images">
											<img
												src="https://wwwstatic.vivo.com.cn/vivoportal/files/image/navi/20231107/2a92e3c64088906138bfbacfd1fe2015.png" />
										</div>
										<p>商品名称2</p>
								</a></li>
								<li><a href="#">
										<div class="item_images">
											<img
												src="https://wwwstatic.vivo.com.cn/vivoportal/files/image/navi/20231107/2a92e3c64088906138bfbacfd1fe2015.png" />
										</div>
										<p>商品名称2</p>
								</a></li>
								<li><a href="#">
										<div class="item_images">
											<img
												src="https://wwwstatic.vivo.com.cn/vivoportal/files/image/navi/20231107/2a92e3c64088906138bfbacfd1fe2015.png" />
										</div>
										<p>商品名称2</p>
								</a></li>
								<li><a href="#">
										<div class="item_images">
											<img
												src="https://wwwstatic.vivo.com.cn/vivoportal/files/image/navi/20231107/2a92e3c64088906138bfbacfd1fe2015.png" />
										</div>
										<p>商品名称2</p>
								</a></li>
							</ul>
							<ul class="phone_total">
								<li><a href="#">
										<div class="item_images">
											<img
												src="https://wwwstatic.vivo.com.cn/vivoportal/files/image/navi/20231107/2a92e3c64088906138bfbacfd1fe2015.png" />
										</div>
										<p>商品名称3</p>
								</a></li>
							</ul>
							<ul class="phone_total">
								<li><a href="#">
										<div class="item_images">
											<img
												src="https://wwwstatic.vivo.com.cn/vivoportal/files/image/navi/20231107/2a92e3c64088906138bfbacfd1fe2015.png" />
										</div>
										<p>商品名称4</p>
								</a></li>
							</ul>
						</div>
						<div class="mune_buttom">
							<a href="#"><svg t="1710728535432" class="icon"
									viewBox="0 0 1024 1024" version="1.1"
									xmlns="http://www.w3.org/2000/svg" p-id="6470" width="20"
									height="20">
									<path
										d="M123.974 92.196h335.692c17.893 0 32.317 14.423 32.317 32.084v335.713c0 17.872-14.423 32.296-32.317 32.296h-335.692c-17.427 0-32.084-14.423-32.084-32.296v-335.713c0-17.661 14.657-32.084 32.084-32.084v0zM427.349 156.809v0h-270.846v271.1h270.847v-271.1h-0.001zM866.422 156.809v0h-270.867v271.1h270.867v-271.1zM563.47 92.196v0h335.481c17.893 0 32.55 14.423 32.55 32.084v335.714c0 17.872-14.657 32.296-32.55 32.296h-335.481c-17.872 0-32.528-14.423-32.528-32.296v-335.714c0-17.661 14.657-32.084 32.528-32.084v0zM156.504 866.961v0h270.847v-270.849h-270.847v270.849zM459.667 931.574v0h-335.692c-17.427 0-32.084-14.423-32.084-32.296v-335.713c0-17.407 14.657-32.317 32.084-32.317h335.692c17.893 0 32.317 14.911 32.317 32.317v335.713c0 17.871-14.423 32.296-32.317 32.296v0zM898.95 931.574v0h-335.481c-17.872 0-32.528-14.423-32.528-32.296v-335.714c0-17.407 14.657-32.317 32.528-32.317h335.481c17.893 0 32.55 14.911 32.55 32.317v335.713c0 17.872-14.657 32.297-32.55 32.297v0zM595.555 866.961v0h270.867v-270.849h-270.867v270.849z"
										fill="#333841" p-id="6471"></path></svg>全部（类型）机型</a>
						</div>
					</div>
				</div>
				<!-- 搜索框 -->
				<div class="bukuai bukuai_search">
					<div>
						<div class="search_input">
							<input placeholder="请输入内容" />
							<div class="xian"></div>
						</div>
						<div style="height: 100px; width: 100%;">快捷搜索</div>
					</div>
				</div>
			</div>
		</div>
	</header>
<!-- </body>
</html> -->