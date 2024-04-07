<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<link rel="icon name" href="../../img/favicon.ico" />
<link href="../../css/grzx.css" rel="stylesheet" />
<link href="../../css/nav.css" rel="stylesheet" />
<link href="../../css/footer.css" rel="stylesheet" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/duolian.js"></script>

<script src="../../js/nav.js"></script>
</head>
<body>
<%@include file="../../html/nav.jsp" %>
	<div class="container">
		<div class="menu">
			<a href="商城首页.html">商城首23页</a> <a href="grzx.jsp"><img
				class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a> <a
				href=""><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人资料</a>
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
				<div class="tkgl">个人资料</div>
				<div class="grxx_tx">
					<div class="zltx">当前头像：</div>
					<img src="../../img/h.jpeg" class="tx2">
					<div class="gender-section">
						<div>性别：</div>
						<label><input type="radio" name="gender" value="male">
							男</label> <label><input type="radio" name="gender" value="female">
							女</label>
					</div>
					<div class="birthday-section">
						<div>生日：</div>
						<select name="year" id="year">
							<option value="2000">2000年</option>
							<option value="2001">2001年</option>
							<option value="2002">2002年</option>
							<option value="2003">2003年</option>
							<option value="2004">2004年</option>
							<option value="2005">2005年</option>
							<option value="2006">2006年</option>
							<option value="2007">2007年</option>
							<option value="2008">2008年</option>
							<option value="2009">2009年</option>
							<option value="2010">2010年</option>
							<option value="2011">2011年</option>
							<option value="2012">2012年</option>
							<option value="2013">2013年</option>
							<option value="2014">2014年</option>
							<option value="2015">2015年</option>
							<option value="2016">2016年</option>
							<option value="2017">2017年</option>
							<option value="2018">2018年</option>
							<option value="2019">2019年</option>
							<option value="2020">2020年</option>
							<option value="2021">2021年</option>
							<option value="2022">2022年</option>
							<option value="2023">2023年</option>
							<option value="2024" selected>2024年</option>
						</select> <select name="month" id="month" onchange="updateDays()">
							<option value="1" selected>1月</option>
							<option value="2">2月</option>
							<option value="3">3月</option>
							<option value="4">4月</option>
							<option value="5">5月</option>
							<option value="6">6月</option>
							<option value="7">7月</option>
							<option value="8">8月</option>
							<option value="9">9月</option>
							<option value="10">10月</option>
							<option value="11">11月</option>
							<option value="12">12月</option>
						</select> <select name="day" id="day">
							<!-- 这里将通过 JavaScript 动态生成该月份的默认天数选项 -->
						</select>

						<script>
							// 动态生成默认月份的天数
							function updateDays() {
								const monthSelect = document
										.getElementById('month');
								const daysSelect = document
										.getElementById('day');
								const selectedMonth = Number(monthSelect.value);
								daysSelect.innerHTML = '';

								let daysInMonth;
								if ([ 1, 3, 5, 7, 8, 10, 12 ]
										.includes(selectedMonth)) {
									daysInMonth = 31;
								} else if (selectedMonth === 2) {
									// 判断闰年与平年
									const selectedYear = Number(document
											.getElementById('year').value);
									daysInMonth = (selectedYear % 4 === 0 && (selectedYear % 100 !== 0 || selectedYear % 400 === 0)) ? 29
											: 28;
								} else {
									daysInMonth = 30;
								}

								for (let i = 1; i <= daysInMonth; i++) {
									const dayOption = document
											.createElement('option');
									dayOption.value = i;
									dayOption.text = i + '日';
									if (i === 1) {
										dayOption.selected = true; // 设置默认选中的日期
									}
									daysSelect.add(dayOption);
								}
							}
							// 初始化页面时生成默认天数
							updateDays();
						</script>
					</div>
					<div class="regional-submissions">
						<div>居住地：</div>
						<div>
							<select id="province">
								<option>请选择</option>
							</select>
							<select id="city">
								<option>请选择</option>
							</select>
							<select id="district">
								<option>请选择</option>
							</select>

						</div>
					</div>
					<button class="button">保存</button>
				</div>
			</div>
		</div>
	</div>
<%@include file="../../html/footer.jsp" %>
</body>
</html>