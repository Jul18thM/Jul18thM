<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>调整任务</title>
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
	<input type="hidden" value="${emp.username }" id="username"/>
		<xblock>
		<button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon"></i>批量删除
		</button>
		</xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th>任务名称</th>
					<th>实施人</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>任务状态</th>
					<th>操作</th>
			</thead>
			<tbody>
			<c:forEach items="${udt }" var="udt" varStatus="st">
				<tr>
					<td>
						<div class="layui-unselect layui-form-checkbox" lay-skin="primary"
							data-id='${udt.id }'>
							<i class="layui-icon">&#xe605;</i>
						</div>
					</td>
					<td>${udt.taskName }</td>
					<td>${udt.emp.name }</td>
					<td><fmt:formatDate value="${udt.taskBeginTime }" type="date" dateStyle="long"/></td>
					<td><fmt:formatDate value="${udt.taskEndTime }" type="date" dateStyle="long"/></td>
					<td>${udt.taskState }</td>

					<td class="td-manage"><a title="调整任务信息"
						onclick="x_admin_show('调整任务信息','udtDetail?id=${udt.id}',600,400)"
						href="javascript:;"> <i class="layui-icon">&#xe60a;</i>
					</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
<script>
      function delAll (argument) {
        var data = tableCheck.getData();
        var ids="";
        for(var i=0;i<data.length;i++){
            ids += data[i]+",";
        }
        var emp_id = $("#username").val();
        layer.confirm('确认要删除吗？',function(index){
            //捉到所有被选中的，发异步进行删除
             $.post('deleteTaskById',{"id":ids,"emp_id":emp_id});
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
    </script>
<SCRIPT Language=VBScript><!--

//--></SCRIPT>