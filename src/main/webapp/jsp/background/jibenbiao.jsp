<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- Begin page -->
		<header class="am-topbar am-topbar-fixed-top">		
			<div class="am-topbar-left am-hide-sm-only">
                <a href="index.html" class="logo"><span>Admin<span>to</span></span><i class="zmdi zmdi-layers"></i></a>
            </div>
	
			<div class="contain">
				<ul class="am-nav am-navbar-nav am-navbar-left">

					<li><h4 class="page-title">基本表格</h4></li>
				</ul>
				
				<ul class="am-nav am-navbar-nav am-navbar-right">
					<li class="inform"><i class="am-icon-bell-o" aria-hidden="true"></i></li>
					<li class="hidden-xs am-hide-sm-only">
                        <form role="search" class="app-search">
                            <input type="text" placeholder="Search..." class="form-control">
                            <a href=""><img src="../assets/img/search.png"></a>
                        </form>
                    </li>
				</ul>
			</div>
		</header>
		<!-- end page -->
		
		
		<div class="admin">
			<!--<div class="am-g">-->
		<!-- ========== Left Sidebar Start ========== -->
		<!--<div class="left side-menu am-hide-sm-only am-u-md-1 am-padding-0">
			<div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 548px;">
				<div class="sidebar-inner slimscrollleft" style="overflow: hidden; width: auto; height: 548px;">-->
                  <!-- sidebar start -->
				  <div class="admin-sidebar am-offcanvas  am-padding-0" id="admin-offcanvas">
				    <div class="am-offcanvas-bar admin-offcanvas-bar">
				    	<!-- User -->
						<div class="user-box am-hide-sm-only">
	                        <div class="user-img">
	                            <img src="../assets/img/avatjpg" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
	                            <div class="user-status offline"><i class="am-icon-dot-circle-o" aria-hidden="true"></i></div>
	                        </div>
	                        <h5><a href="#">Mat Helme</a> </h5>
	                        <ul class="list-inline">
	                            <li>
	                                <a href="#">
	                                    <i class="am-icon-cog" aria-hidden="true"></i>
	                                </a>
	                            </li>
	
	                            <li>
	                                <a href="#" class="text-custom">
	                                    <i class="am-icon-cog" aria-hidden="true"></i>
	                                </a>
	                            </li>
	                        </ul>
	                    </div>
	                    <!-- End User -->
	            
						 <ul class="am-list admin-sidebar-list">
						    <li><a href="../index.html"><span class="am-icon-home"></span> 首页</a></li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span> 表格 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
						        <li><a href="table_basic.html" class="am-cf"> 基本表格</span></a></li>
						        <li><a href="table_complete.html">完整表格</a></li>
						      </ul>
						    </li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><i class="am-icon-line-chart" aria-hidden="true"></i> 统计图表 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
						        <li><a href="chart_line.html" class="am-cf"> 折线图</span></a></li>
						        <li><a href="chart_columnar.html" class="am-cf"> 柱状图</span></a></li>
						        <li><a href="chart_pie.html" class="am-cf"> 饼状图</span></a></li>
						      </ul>
						    </li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-file"></span> 表单 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav5">
						        <li><a href="form_basic.html" class="am-cf"> 基本表单</a></li>
						        <li><a href="form_validate.html">表单验证</a></li>   
						      </ul>
						    </li>
						  </ul>
				</div>
				  </div>
				  <!-- sidebar end -->
    
				<!--</div>
			</div>
		</div>-->
		<!-- ========== Left Sidebar end ========== -->
		
		
		
	<!--	<div class="am-g">-->
		<!-- ============================================================== -->
		<!-- Start right Content here -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="am-g">
					<!-- Row start -->
						<div class="am-u-sm-6">
							<div class="card-box">
								<!-- col start -->
								<table class="am-table">
								    <thead>
								        <tr>
								            <th>网站名称</th>
								            <th>网址</th>
								            <th>创建时间</th>
								        </tr>
								    </thead>
								    <tbody>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								    </tbody>
								</table>
								<!-- col end -->
							</div>
						</div>
						
						<div class="am-u-sm-6">
							<div class="card-box">
								<!-- col start -->
									<table class="am-table  am-table-hover">
								    <thead>
								        <tr>
								            <th>网站名称</th>
								            <th>网址</th>
								            <th>创建时间</th>
								        </tr>
								    </thead>
								    <tbody>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								    </tbody>
								</table>
								<!-- col end -->
							</div>
						</div>
					<!-- Row end -->
				</div>
			
				<!-- row start -->
				<div class="am-g">
					<!-- col start -->
					<div class="am-u-md-6">
						<div class="card-box">
							<table class="am-table am-table-bordered">
								    <thead>
								        <tr>
								            <th>网站名称</th>
								            <th>网址</th>
								            <th>创建时间</th>
								        </tr>
								    </thead>
								    <tbody>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								    </tbody>
								</table>
						</div>
					</div>
					<!-- col end -->
					
					<!-- col start -->
					<div class="am-u-md-6">
						<div class="card-box">
							<table class="am-table  am-table-striped">
								    <thead>
								        <tr>
								            <th>网站名称</th>
								            <th>网址</th>
								            <th>创建时间</th>
								        </tr>
								    </thead>
								    <tbody>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								        <tr>
								            <td>Amaze UI</td>
								            <td>http://amazeui.org</td>
								            <td>2012-10-01</td>
								        </tr>
								    </tbody>
								</table>
						</div>
					</div>
					<!-- col end -->
				</div>
				<!-- row end -->

				
			</div>
		</div>
		<!-- end right Content here -->
		<!--</div>-->
		</div>
		</div>
		
		<!-- navbar -->
		<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>
		
		<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="../assets/js/amazeui.min.js"></script>
		<script type="text/javascript" src="../assets/js/app.js" ></script>
		<script type="text/javascript" src="../assets/js/blockUI.js" ></script>



	</body>
</html>