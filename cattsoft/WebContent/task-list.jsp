<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>任务列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="./lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="x-body">
		<span class="x-right" style="line-height: 40px">共有数据：${tc } 条</span>
		<table class="layui-table">
			<thead>
				<tr>
					<th>任务名称</th>
					<!--  主管展示块
                        <th>
                            实施人
                        </th>
                        -->
					<!-- 员工展示块 -->
					<th>指定人</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>任务状态</th>
					<th>操作</th>
			</thead>
			<tbody>
				<c:forEach items="${taskList}" var="tl" varStatus="st">
					<tr>
						<td>${tl.taskName }</td>
						<td>${emp.name }</td>
						<td><fmt:formatDate value="${tl.taskBeginTime }" type="date" dateStyle="long"/></td>
						<td><fmt:formatDate value="${tl.taskEndTime }" type="date" dateStyle="long"/></td>
						<td>${tl.taskState }</td>

						<!--  主管展示块
                        <td class="td-manage">
                            <a title="任务详细信息"
                                onclick="x_admin_show('任务详细信息','task-details.html',700,400)"
                                href="javascript:;"> <i class="layui-icon">&#xe60a;</i> </a>
                        </td>
                        -->
						<!-- 员工展示块 -->
						<td class="td-manage"><a title="制定计划"
							onclick="x_admin_show('制定计划','taskDetail?id=${tl.id}',700,450)"
							href="javascript:;"> <i class="layui-icon">&#xe60a;</i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>