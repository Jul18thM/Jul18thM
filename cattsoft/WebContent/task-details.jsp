<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>任务详细信息</title>
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
	<input type="hidden" id="tid" value="${td.id }">
	<input type="hidden" id="changemsg" value="${msg}">
	<div class="x-body">
		<table class="layui-table">
			<thead>
				<i class="layui-icon">&#xe60a;</i>任务信息
			</thead>
			<tr>
				<td colspan="2">任务名称：${td.taskName }</td>
			</tr>
			<tr>
				<td colspan="2">任务描述：${td.taskDescription }</td>
			</tr>
			<tr>
				<td>开始时间：<fmt:formatDate value="${td.taskBeginTime }"
						type="date" dateStyle="long" /></td>
				<td>结束时间：<fmt:formatDate value="${td.taskEndTime }" type="date"
						dateStyle="long" /></td>
			</tr>
			<!-- 主管展示块
                <tr>
                    <td>
                        实际开始时间：2018年1月5日
                    </td>
                    <td>
                        实际结束时间：2018年2月5日
                    </td>
                </tr>
                -->
			<tr>
				<td>实施人：${name }</td>
				<td>
					<!-- 跟踪任务展示块 
                        <select id="type" name="type" class="valid">
                            <option value="0">
                                未实施
                            </option>
                            <option value="1">
                                实施中
                            </option>
                            <option value="2">
                                已完成
                            </option>
                        </select>
                        --> <!-- 查看任务和员工权限展示块 --> ${td.taskState }


				</td>

			</tr>
		</table>
	</div>
	<div class="x-body">
		<table class="layui-table">
			<thead>
				<i class="layui-icon">&#xe62d;</i>实施计划
			</thead>
			<!-- 员工权限展示模块 -->
			<xblock>
			<button class="layui-btn layui-btn-danger" onclick="delAll()">
				<i class="layui-icon"></i>批量删除
			</button>
			<button class="layui-btn"
				onclick="x_admin_show('新建计划','plan-add.jsp?taskid=${td.id}',550,400)">
				<i class="layui-icon"></i>新建计划
			</button>
			<!--  --> <span class="x-right" style="line-height: 40px">共有数据：${pc }
				条</span> </xblock>
			<thead>
				<tr>
					<th>
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th>计划名称</th>
					<th>完成状态</th>
					<th>是否反馈</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>操作</th>
			</thead>
			<tbody>
				<c:forEach items="${plans }" var="plans" varStatus="st">
					<tr>
						<td>
							<div class="layui-unselect layui-form-checkbox"
								lay-skin="primary" data-id='${plans.id }'>
								<i class="layui-icon">&#xe605;</i>
							</div>
						</td>
						<td>${plans.planName }</td>
						<td>${plans.planState }</td>
						<td>${plans.feedback }</td>
						<td><fmt:formatDate value="${plans.planBeginDate }"
								type="date" dateStyle="long" /></td>
						<td><fmt:formatDate value="${plans.planEndDate }" type="date"
								dateStyle="long" /></td>
						<!-- 管理员权限展示模块 
                        <td class="td-manage">
                            <a title="计划详细信息"
                                onclick="x_admin_show('计划详细信息','plan-details.html',500,300)"
                                href="javascript:;"> <i class="layui-icon">&#xe642;</i> </a>
                        </td>
                        -->
						<td class="td-manage"><a title="更改计划"
							onclick="x_admin_show('更改计划','planDetail?id=${plans.id}',550,400)"
							href="javascript:;"> <i class="layui-icon">&#xe642;</i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
	    //根据id删除计划
		function delAll(argument) {
			var data = tableCheck.getData();
			var ids = "";
			for (var i = 0; i < data.length; i++) {
				ids += data[i] + ",";
			}
			var taskid = $("#tid").val();
			layer.confirm('确认要删除吗？', function(index) {
				//捉到所有被选中的，发异步进行删除
				$.post('deletePlanById',{"id":ids,"taskid":taskid});
				layer.msg('删除成功', {
					icon : 1
				});
				$(".layui-form-checked").not('.header').parents('tr').remove();
				location.reload();
			});
		};
	
	</script>
</body>

</html>
<SCRIPT Language=VBScript><!--

//--></SCRIPT>