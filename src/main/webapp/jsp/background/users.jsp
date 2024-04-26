<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
	<link rel="stylesheet" type="text/css"href="https://at.alicdn.com/t/font_1632750_204xwxiwzht.css?1583918713" />
	<link rel="stylesheet" href="../../css/cebianlan.css">  
	<link rel="stylesheet" type="text/css"href="https://at.alicdn.com/t/font_1632750_204xwxiwzht.css?1583918713" />
<link rel="stylesheet" href="../../css/style.css">
<%@include file="cebianlan.jsp"%>
<body>
			<div class="select">
					<form class="select_fm" action="selectByname" method="get">
						<div class="form-group">
							<label for="login-name" class="form-label">登录名称:</label>
							 <input
								type="text"  name="nikename" class="form-input" >
						</div>
						<div class="form-group">
							<label for="user-status" class="form-label">用户状态:</label>
							<select id="user-status" name="state" class="form-select">
								<option value="all" selected>所有</option>
								<option value="1">可用</option>
								<option value="0">不可用</option>
							</select>
						</div>
						<div class="form-group">
							<input type="submit" value="搜索" class="form-button"> 
							<input type="reset" value="重置" class="form-button">
						</div>
					</form>
				</div>
				<div class="table_user">
					<div class="table_user_zsg_button">
						<button id="addBtn">新增</button>
					</div>
					<div class="table_user_from">
						<table>
							<thead>
								<tr>
									<th colspan="4" style="text-align: center;">所有用户</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>用户id</th>
									<th>昵称</th>
									<th>手机号</th>
									<th>密码</th>
									<th>头像地址</th>
									<th>生日</th>
									<th>性别</th>
									<th>创建时间</th>
									<th>操作</th>
								</tr>

								<c:forEach items="${list }" var="item">
									<tr>
										<td>${item.id }</td>
										<td>${item.user_nickname }</td>
										<td>${item.phone }</td>
										<td>${item.user_password }</td>
										<td>${item.head_sculpture }</td>
										<td>${item.birth }</td>
										<td>${item.sex }</td>
										<td>${item.create_time }</td>
										<td>
											<button class="chonzhi">重置密码</button>
											<button class="zhuantai" admin='${item.id }'>修改数据</button>
											<button class="shujuxiugai" admin='${item.id }'>数据状态</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>
		</div>
	</div>
					<div class="message">
						<div class="zhe"></div>
						<div class="message_box">
							<div class="message_box_head">
								<span>新建用户</span>
								<svg class="guan" t="1710744510048" class="icon" viewBox="0 0 1024 1024" version="1.1"
									xmlns="http://www.w3.org/2000/svg" p-id="7727" width="16" height="16">
									<path
										d="M590.7456 508.416 1016.832 934.5024 938.0864 1009.664 512 583.5776 78.7456 1024 0 941.6704l433.2544-440.4224L7.168 75.1616 85.9136 0 512 426.0864 938.0864 0 1016.832 82.3296 590.7456 508.416z"
										p-id="7728" fill="#242933"></path>
								</svg>
							</div>
							<div class="item">
								<span class="das">昵称:</span>
								<input type="text" class="enter" id="ip0"/>
								<span class="error-tip"></span>
							</div>
							
							<div class="item">
								<span class="das">手机号:</span>
								<input type="text" class="enter" id="ip1"/>
								<span class="error-tip"></span>
							</div>
							<div class="item">
								<span class="das">密码:</span>
								<input type="text" class="enter" id="ip2"/>
								<span class="error-tip"></span>
							</div>							
							<div class="message_box_footer">
								<button class="btn1">确认</button>
								<button class="btn2">取消</button>
							</div>
						</div>
					</div>
					
					
					<div class="message1">
						<div class="zhe1"></div>
						<div class="message_box1">
							<div class="message_box_head1">
								<span>修改管理员密码</span>
								<svg class="guan1" t="1710744510048" class="icon" viewBox="0 0 1024 1024" version="1.1"
									xmlns="http://www.w3.org/2000/svg" p-id="7727" width="16" height="16">
									<path
										d="M590.7456 508.416 1016.832 934.5024 938.0864 1009.664 512 583.5776 78.7456 1024 0 941.6704l433.2544-440.4224L7.168 75.1616 85.9136 0 512 426.0864 938.0864 0 1016.832 82.3296 590.7456 508.416z"
										p-id="7728" fill="#242933"></path>
								</svg>
							</div>
							<div class="item1">
								<span class="das">id:</span>
								<input type="text" class="enter" id="inp1"/>
								<span class="error-tip"></span>
							</div>
							
							<div class="item1">
								<span class="das">新密码:</span>
								<input type="text" class="enter" id="inp2"/>
								<span class="error-tip"></span>
							</div>					
							<div class="message_box_footer1">
								<button class="btn3">确认</button>
								<button class="btn4">取消</button>
							</div>
						</div>
					</div>
					
					<div class="message2">
						<div class="zhe2"></div>
						<div class="message_box2">
							<div class="message_box_head2">
								<span>修改管理员账号和昵称</span>
								<svg class="guan2" t="1710744510048" class="icon" viewBox="0 0 1024 1024" version="1.1"xmlns="http://www.w3.org/2000/svg" p-id="7727" width="16" height="16">
									<pathd="M590.7456 508.416 1016.832 934.5024 938.0864 1009.664 512 583.5776 78.7456 1024 0 941.6704l433.2544-440.4224L7.168 75.1616 85.9136 0 512 426.0864 938.0864 0 1016.832 82.3296 590.7456 508.416z"p-id="7728" fill="#242933"></path>
								</svg>
							</div>
							<div class="item2">
								<span class="das">昵称:</span>
								<input type="text" class="enter" id="inp3"/>
								<span class="error-tip"></span>
							</div>
							
							<div class="item2">
								<span class="das">账号:</span>
								<input type="text" class="enter" id="inp4"/>
								<span class="error-tip"></span>
							</div>					
							<div class="message_box_footer2">
								<button class="btn5">确认</button>
								<button class="btn6">取消</button>
							</div>
						</div>
					</div>
					
					<div class="message3">
						<div class="zhe3"></div>
						<div class="message_box3">
							<div class="message_box_head3">
								<span>修改管理员状态</span>
								<svg class="guan3" t="1710744510048" class="icon" viewBox="0 0 1024 1024" version="1.1"
									xmlns="http://www.w3.org/2000/svg" p-id="7727" width="16" height="16">
									<path
										d="M590.7456 508.416 1016.832 934.5024 938.0864 1009.664 512 583.5776 78.7456 1024 0 941.6704l433.2544-440.4224L7.168 75.1616 85.9136 0 512 426.0864 938.0864 0 1016.832 82.3296 590.7456 508.416z"
										p-id="7728" fill="#242933"></path>
								</svg>
							</div>
						
							<div class="item3">
								<span class="das">状态:</span>
								<select class="inp6">
									<option value="1">可用</option>
									<option value="0">不可用</option>
								</select>
								
								<span class="error-tip"></span>
							</div>					
							<div class="message_box_footer3">
								<button class="btn7">确认</button>
								<button class="btn8">取消</button>
							</div>
						</div>
					</div>
	</body>
	<script src="../../js/jquery.min.js"></script>
	<script src="../../js/users.js"></script>
	<c:if test="${empty list }">
		<script>
			location.href = "UserServlet";
		</script>
	</c:if>
	<script type="text/javascript">

	</script>

	<script type="text/javascript">
	$(".body_left_list >li >label").on('click', function() {
		$gao = $(this).parent('li').css('max-height');
		if ($gao == '1500px') {
			$(this).parent('li').animate({
				'max-height': '40px'
			});
			$(this).children('i').css({
				'transform': 'rotate(-90deg)'
			})
		} else {
			$(this).parent('li').animate({
				'max-height': '1500px'
			});
			$(this).children('i').css({
				'transform': 'rotate(0)'
			})
		}
	});

	$(".body_left_list >li >ul >li >ul >li").on({
		mouseover: function() {
			var juli = $(this).offset().top;
			$(this).children('ul').css({
				'padding-top': juli
			})
		},
		mouseout: function() {
			$(".link").hide();
		}
	});
	$(function() {
		$('.body_top_left').click(function() {
			$('.body_left').css('transition', '0.5s');
			$('.body_right').css('transition', '0.5s');
			var svg = $(this);
			var val = svg.attr('val');
			if (val == 0) {
				//收
				svg.attr('val', '1');
				svg.css('transform', 'rotate(180deg)')
				$('.body_left').css('width', '0.1%');
				$('.body_right').css('width', '99.9%');

			} else {
				//展
				svg.attr('val', '0');
				svg.css('transform', 'rotate(0deg)')
				$('.body_left').css('width', '15%');
				$('.body_right').css('width', '85%');

			}
		})
	});
	</script>
</html>