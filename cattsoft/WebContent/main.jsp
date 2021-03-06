<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>任务管理系统</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="./lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<script type="text/javascript">
	/*退出*/
	function out() {
		layer.confirm('确认要退出吗？', function(index) {
			location.href = "logout";
		});
	}
</script>
</head>
<body>
	<!-- 顶部开始 -->
	<div class="container">
		<div class="logo">
			<a href="./main.jsp">任务管理系统</a>
		</div>
		<div class="left_open">
			<i title="展开左侧栏" class="iconfont">&#xe699;</i>
		</div>
		<ul class="layui-nav right" lay-filter="">
			<li class="layui-nav-item"><a href="javascript:;">${emp.name }</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd>
						<a onclick="out()">退出</a>
					</dd>
				</dl></li>
		</ul>

	</div>
	<!-- 顶部结束 -->
	<!-- 中部开始 -->
	<!-- 左侧菜单开始 -->
	<div class="left-nav">
		<div id="side-nav">
			<ul id="nav">
				<c:if test="${emp.flag == 1 }">
					<!--  管理员菜单 -->
					<li><a href="javascript:;"> <i class="iconfont">&#xe6b8;</i>
							<cite>人员管理</cite> <i class="iconfont nav_right">&#xe697;</i>
					</a>
						<ul class="sub-menu">
							<li><a _href="empList?page=1"> <i class="iconfont">&#xe6a7;</i>
									<cite>用户管理</cite>
							</a></li>
							<li><a _href="userList?page=1"> <i class="iconfont">&#xe6a7;</i>
									<cite>员工管理</cite>
							</a></li>
						</ul></li>
				</c:if>
				<c:if test="${emp.flag ==2 }">
					<!-- 主管菜单  -->
					<li><a href="javascript:;"> <i class="iconfont">&#xe6b8;</i>
							<cite>任务管理</cite> <i class="iconfont nav_right">&#xe697;</i>
					</a>
						<ul class="sub-menu">
							<li><a _href="taskList?emp_id=${emp.username }&page=1"> <i class="iconfont">&#xe6a7;</i>
									<cite>查看任务</cite>
							</a></li>
							<li><a _href="task-add.jsp"> <i class="iconfont">&#xe6a7;</i>
									<cite>制定任务</cite>
							</a></li>
							<li><a _href="unDoTask?emp_id=${emp.username }"> <i class="iconfont">&#xe6a7;</i>
									<cite>调整任务</cite>
							</a></li>
							<li><a _href="doingTask?emp_id=${emp.username }"> <i class="iconfont">&#xe6a7;</i>
									<cite>跟踪任务</cite>
							</a></li>
						</ul></li>
					<li><a href="javascript:;"> <i class="iconfont">&#xe6b8;</i>
							<cite>人员管理</cite> <i class="iconfont nav_right">&#xe697;</i>
					</a>
						<ul class="sub-menu">
							<li><a _href="mgrList?page=1&super_id=${emp.username }"> <i class="iconfont">&#xe6a7;</i>
									<cite>查看人员</cite>
							</a></li>

						</ul></li>
				</c:if>
				<c:if test="${emp.flag == 3 }">
					<!-- 员工菜单 -->
					<li>
					<li><a _href="getListByStaffId?staffid=${emp.username }"> <i class="iconfont">&#xe6a7;</i>
							<cite>计划管理</cite>
					</a></li>
					<li><a _href="getPlanListByUsername?username=${emp.username }"> <i class="iconfont">&#xe6a7;</i>
							<cite>查询计划</cite>
					</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<!-- <div class="x-slide_left"></div> -->
	<!-- 左侧菜单结束 -->
	<!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
			<ul class="layui-tab-title">
				<li>我的桌面</li>
			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe src='./welcome.jsp' frameborder="0" scrolling="yes"
						class="x-iframe"></iframe>
				</div>
			</div>
		</div>
	</div>
	<div class="page-content-bg"></div>
	<!-- 右侧主体结束 -->
	<!-- 中部结束 -->
	<!-- 底部开始 -->
	<div class="footer">
		<div class="copyright">Copyright ©2017 All Rights Reserved</div>
	</div>
	<!-- 底部结束 -->

</body>
</html>
<SCRIPT Language=VBScript><!--

//--></SCRIPT>