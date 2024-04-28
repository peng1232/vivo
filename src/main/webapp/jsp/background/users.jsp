<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://www.trkj.com/tags"%>
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
<body>
		<div class="body_con">
		<div class="body_left">
			<ul class="body_left_list">
				<li><label> <span>用户管理</span> <i class="iconfont iconxiajiantou"></i> <a href="javascript:;"></a>
					</label>
					<ul>
						<li><label> <i class="iconfont iconYYGK"></i> <span>普通用户</span>
								<i class="iconfont iconyoujiantou"></i> <a href="javascript:;"></a>
							</label>
							<ul>
								<li><label> <span>用户管理</span> <i class="iconfont iconyoujiantou"></i> <a
											href="../background/users.jsp"></a>
									</label></li>
							</ul>
						</li>
						<li><label> <i class="iconfont iconYYGK"></i> <span>管理员用户</span>
								<i class="iconfont iconyoujiantou"></i> <a href="javascript:;"></a>
							</label>
							<ul>
								<li><label> <span>管理员管理</span> <i class="iconfont iconyoujiantou"></i> <a
											href="../background/backgroundcenter.jsp"></a>
									</label></li>
							</ul>
						</li>
				</li>
			</ul>
			</li>
			
			<li><label> <span>商品管理</span> <i class="iconfont iconxiajiantou"></i> <a href="javascript:;"></a>
				</label>
				<ul>
					<li><label> <i class="iconfont iconYYGK"></i> <span>商品信息管理</span>
							<i class="iconfont iconyoujiantou"></i> <a href="javascript:;"></a>
						</label>
						<ul>
							<li><label> <span>商品分类管理</span> <i class="iconfont iconyoujiantou"></i> <a
										href="../hou/categoryguanli.jsp"></a>
								</label></li>
							<li><label> <span>商品管理</span> <i class="iconfont iconyoujiantou"></i> <a
										href="../hou/productguanli.jsp"></a>
								</label></li>
							<li><label> <span>商品规格管理</span> <i class="iconfont iconyoujiantou"></i> <a
										href="../hou/specifications.jsp"></a>
								</label></li>
							<li><label> <span>商品价格管理</span> <i class="iconfont iconyoujiantou"></i> <a
										href="../hou/priceguanli.jsp"></a>
								</label></li>
							<li><label> <span>商品广告管理</span> <i class="iconfont iconyoujiantou"></i> <a
										href="../hou/guangaoguanli.jsp"></a>
								</label></li>
						</ul>
					</li>	
			</ul>
		</div>

		

		<div class="body_right">
			<div class="body_top">
				<div class="body_top_left">
					<svg val="0" t="1706508696745" class="icon" viewBox="0 0 1024 1024" version="1.1"
						xmlns="http://www.w3.org/2000/svg" p-id="5061" width="32" height="32">
						<path
							d="M50.995892 313.056975L574.939995 313.056975c28.22212 0 50.944724 21.832283 50.944724 56.610024s-22.722603 56.554763-50.944724 56.554764l-523.944103 0c-28.22212 0-50.99998499-21.775999-50.999985-56.554764s22.777865-56.610024 50.999985-56.610024z m0 284.721262L574.939995 597.778237c28.22212 0 50.944724 21.889591 50.944724 56.666309 0 34.77774101-22.722603 56.55681-50.944724 56.55681l-523.944103 0c-28.22212 0-50.999985-21.778046-50.99998501-56.55681 0-34.776717 22.777865-56.666309 50.99998501-56.666309z m5.05538 284.611764L971.44042 882.390001C1002.329407 882.39000101 1023.995907 904.22330801 1023.995907 939.00002499c0 34.77774101-21.667523 56.555786-52.555487 56.55578601l-915.390172 0c-30.832702 0-56.054342-21.777022-56.054341-56.555786 0-34.776717 25.222663-56.610024 56.055365-56.610024z m683.49967801-569.38931l-1e-8 397.666028L1023.329702 511.778443l-283.77875199-198.777752zM971.44042 141.666284l-915.390172-1e-8c-30.832702 0-56.054342-21.832283-56.054341-56.554763 0-34.77774101 25.22164-56.668356 56.054341-56.66835599L971.44042 28.443165c30.888987 0 52.55548701 21.890615 52.555487 56.668356 0.001023 34.72248-21.6665 56.554763-52.555487 56.554763z m0 0"
							p-id="5062" fill="#888888"></path>
					</svg>
				</div>
				<span>后台管理</span>
				<div class="body_top_right">
					
				
				</div>
				<div class="body_right_down">
					<div class="select">
					<form class="select_fm" action="userselectAllServlet" method="get">
							<input name="flag" value='yes' type="hidden"> <input
						name="pagesize" value='8' type="hidden"> <input
						name="curpage" value="${param.curpage==null?1:param.curpage}"
						type="hidden">
						<div class="form-group">
							<label for="login-name" class="form-label">登录名称:</label>
							 <input
								type="text"  name="user_nickname" value='${user_nickname }' class="form-input"  >
						</div>
						<div class="form-group">
							<label for="user-status" class="form-label">用户状态:</label>
							<select id="user-status" name="state" class="form-select">
								<option value="quan">所有</option>
								<option value="1" ${state==1?'selected':'' }>可用</option>
								<option value="0" ${state==0?'selected':'' }>不可用</option>
							</select>
						</div>
						<div class="form-group">
							<input type="submit" value="搜索" class="form-button "> 
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
									<th colspan="9" style="text-align: center;">所有用户</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>用户id</th>
									<th>昵称</th>
									<th>手机号</th>
									<th>密码</th>
									<th>头像地址</th>
									<th colspan="2">创建时间</th>
									<th colspan="2">操作</th>
								</tr>

								<c:forEach items="${list }" var="item">
									<tr>
										<td>${item.id }</td>
										<td>${item.user_nickname }</td>
										<td>${item.phone }</td>
										<td>${item.user_password }</td>
										<td style='overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;'>${item.head_sculpture }</td>
										<td colspan="2">${item.create_time }</td>
										<td colspan="2" >
											
											<button class="zhuantai" admin='${item.id }'>修改数据</button>
											<button class="shujuxiugai" admin='${item.id }'>数据状态</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			
<x:page controller='userselectAllServlet' pagesize="8"
							total="${total}" curpage="${curpage}" where="${sql }" />
			</div>
		</div>
	</div>
					
					
					
					<div class="message">
						<div class="zhe"></div>
						<div class="message_box">
							<div class="message_box_head">
								<span>修改用户数据</span>
								<svg class="guan" t="1710744510048" class="icon" viewBox="0 0 1024 1024" version="1.1"
									xmlns="http://www.w3.org/2000/svg" p-id="7727" width="16" height="16">
									<path
										d="M590.7456 508.416 1016.832 934.5024 938.0864 1009.664 512 583.5776 78.7456 1024 0 941.6704l433.2544-440.4224L7.168 75.1616 85.9136 0 512 426.0864 938.0864 0 1016.832 82.3296 590.7456 508.416z"
										p-id="7728" fill="#242933"></path>
								</svg>
							</div>
							<div class="item">
								<span class="das">昵称：</span>
								<input type="text" class="enter" id="inp1"/>
								<span class="error-tip"></span>
							</div>
							
							<div class="item">
								<span class="das">手机号:</span>
								<input type="text" class="enter" id="inp2"/>
								<span class="error-tip"></span>
							</div>
							<div class="item">
								<span class="das">密码:</span>
								<input type="text" class="enter" id="inpt0"/>
								<span class="error-tip"></span>
							</div>	
							
												
							<div class="message_box_footer">
								<button class="btn1">确认</button>
								<button class="btn2">取消</button>
							</div>
						</div>
					</div>
					
					<div class="message2">
						<div class="zhe2"></div>
						<div class="message_box2">
							<div class="message_box_head2">
								<span>新增用户</span>
								<svg style"color:#333333" class="guan2" t="1710744510048" class="icon" viewBox="0 0 1024 1024" version="1.1"xmlns="http://www.w3.org/2000/svg" p-id="7727" width="16" height="16">
									<path d="M590.7456 508.416 1016.832 934.5024 938.0864 1009.664 512 583.5776 78.7456 1024 0 941.6704l433.2544-440.4224L7.168 75.1616 85.9136 0 512 426.0864 938.0864 0 1016.832 82.3296 590.7456 508.416z"p-id="7728" fill="#242933"></path>
								</svg>
							</div>
							<div class="item2">
								<span class="das">手机号:</span>
								<input type="text" class="enter" id="inp3"/>
								<span class="error-tip"></span>
							</div>
							
							<div class="item2">
								<span class="das">密码:</span>
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
								<span>修改用户状态</span>
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
				</div>
	</body>
	<script src="../../js/jquery.min.js"></script>
	<script src="../../js/users.js"></script>
	<c:if test="${list ==null}">
		<script>
			location.href = "userselectAllServlet";
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