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
           	<a href="../qian/shouye.jsp">商城首页</a> <a href="grzx.jsp"><img
                class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人中心</a> <a
                href=""><img class="arrow" src="../../img/向右箭头.png" alt="右箭头">个人资料</a>
        </div>
        <div class="under">
            <%@include file="../../html/zxzuo.jsp" %>
            <div class="right">
                <div class="tkgl">个人资料</div>
                <div class="grxx_tx">
                	<div class="xgtpmz">
	                	<div class="zltx">当前头像：</div>
	                    <!-- 添加点击头像修改图片的链接 -->
	                    <a href="javascript:void(0);" onclick="document.getElementById('photo').click();">
	                        <img src="../../img/${user.head_sculpture }" class="tx2" id="avatar" style="cursor: pointer;">
	                    </a>
	                    <!-- 上传头像的表单 -->
						<form action="grxxtxServlet" method="post" enctype="multipart/form-data" style="display: none;">
						    选择照片：<input type="file" name="photo" id="photo" onchange="this.form.submit();">
						</form>
                	</div>
                    <!-- 显示其他个人信息 -->
                    <form action="grxxServlet" method="post">
                        <input type="hidden" value='${user.id }' name='user_id'>
                         <div class="gender-section">
                            <div>昵称：</div>
                           <input type="text" value='${user.user_nickname }' name='nicenane' />
                           
                        </div>
                        <div class="gender-section">
                            <div>性别：</div>
                            <label><input type="radio" name='gender' value="0" ${user.sex == 0 ? 'checked' : ''}>男</label>
                            <label><input type="radio" name='gender' value="1" ${user.sex == 1 ? 'checked' : ''}>女</label>
                        </div>

                        <div class="gender-section">
                            <div>生日：</div>
                            
                            <select name="year" id="year">
                                <!-- 年份选项将由 JavaScript 动态填充 -->
                            </select>
                            <select name="month" id="month" onchange="updateDays()">
                                <!-- 月份选项将由 JavaScript 动态填充 -->
                            </select>
                            <select name="day" id="day">
                                <!-- 日选项将由 JavaScript 动态填充 -->
                            </select>
                            
                            <script>
                                // 动态生成默认月份的天数
                                function updateDays() {
                                    const monthSelect = document.getElementById('month');
                                    const daysSelect = document.getElementById('day');
                                    const selectedMonth = Number(monthSelect.value);
                                    const yearSelect = document.getElementById('year');
                                    const selectedYear = Number(yearSelect.value);
                                    daysSelect.innerHTML = '';
                                    
                                    let daysInMonth;
                                    if ([1, 3, 5, 7, 8, 10, 12].includes(selectedMonth)) {
                                        daysInMonth = 31;
                                    } else if (selectedMonth === 2) {
                                        daysInMonth = (selectedYear % 4 === 0 && (selectedYear % 100 !== 0 || selectedYear % 400 === 0)) ? 29 : 28;
                                    } else {
                                        daysInMonth = 30;
                                    }
                                    
                                    for (let i = 1; i <= daysInMonth; i++) {
                                        const dayOption = document.createElement('option');
                                        dayOption.value = i;
                                        dayOption.text = i + '日';
                                        daysSelect.add(dayOption);
                                    }
                                }
                                
                                // 初始化页面时生成默认天数
                                window.onload = function() {
                                    // 填充年份选项
                                    const yearSelect = document.getElementById('year');
                                    const currentYear = new Date().getFullYear();
                                    for (let year = currentYear; year >= 1900; year--) {
                                        const option = document.createElement('option');
                                        option.value = year;
                                        option.text = year + '年';
                                        yearSelect.add(option);
                                    }
                                    
                                    // 填充月份选项
                                    const monthSelect = document.getElementById('month');
                                    for (let month = 1; month <= 12; month++) {
                                        const option = document.createElement('option');
                                        option.value = month;
                                        option.text = month + '月';
                                        monthSelect.add(option);
                                    }
                                    
                                    // 初始化日选项
                                    updateDays();
                                    
                                    // 获取用户生日信息并设置选中状态
                                    const userBirthday = new Date('${user.birth}'); // 获取用户生日信息
                                    const userYear = userBirthday.getFullYear(); // 获取用户生日的年份
                                    const userMonth = userBirthday.getMonth() + 1; // 获取用户生日的月份
                                    const userDay = userBirthday.getDate(); // 获取用户生日的日期
                                    
                                    yearSelect.value = userYear; // 设置年份选项的值
                                    monthSelect.value = userMonth; // 设置月份选项的值
                                    updateDays(); // 更新日选项
                                    document.getElementById('day').value = userDay; // 设置日期选项的值
                                };
                            </script>
                        </div>

                        <!--
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
                        -->
                        <input type="submit" class="button">
                    </form>
                </div>
            </div>
        </div>
    </div>
<%@include file="../../html/footer.jsp" %>
</body>
</html>
