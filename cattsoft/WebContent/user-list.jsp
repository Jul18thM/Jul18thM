<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>人员列表</title>
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
	<input type="hidden" id="page" value="${page }" />
	<div class="x-body">
		<xblock>
		<button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon"></i>批量删除
		</button>
		<button class="layui-btn"
			onclick="x_admin_show('新建用户','user-add.jsp',600,400)">
			<i class="layui-icon"></i>添加人员
		</button>
		<span class="x-right" style="line-height: 40px">共有数据：${sum } 条</span>
		</xblock>
		<form action="deleteUser" method="post" id="deleteUser">
			<table class="layui-table">
				<thead>
					<tr>
						<th>
							<div class="layui-unselect header layui-form-checkbox"
								lay-skin="primary">
								<i class="layui-icon">&#xe605;</i>
							</div>
						</th>
						<th>姓名</th>
						<th>性别</th>
						<th>入职时间</th>
						<th>职位</th>
						<th>操作</th>
				</thead>
				<tbody>
					<c:forEach items="${userList }" var="u" varStatus="st">
						<c:if test="${u.flag != 1 }">
							<tr>
								<td>
									<div class="layui-unselect layui-form-checkbox"
										lay-skin="primary" data-id='${u.username }'>
										<i class="layui-icon">&#xe605;</i>
									</div>
								</td>
								<td>${u.name }</td>
								<td>${u.sex }</td>
								<td><fmt:formatDate value="${u.hiredate }" type="date"
										dateStyle="long" /></td>
								<td>${u.position }</td>
								<td class="td-manage"><a title="人员详细信息"
									onclick="x_admin_show('人员详细信息','userDetail?username=${u.username}',600,400)"
									href="javascript:;"> <i class="layui-icon">&#xe60a;</i>
								</a></td>
							</tr>
						</c:if>
						<c:if test="${u.flag == 1 }">
							<tr>
								<td>
									<div class="layui-unselect layui-form-checkbox"
										lay-skin="primary" data-id='2'></div>
								</td>
								<td>${u.name }</td>
								<td>${u.sex }</td>
								<td><fmt:formatDate value="${u.hiredate }" type="date"
										dateStyle="long" /></td>
								<td>${u.position }</td>
								<td class="td-manage"><a title="人员详细信息"
									onclick="x_admin_show('人员详细信息','userDetail?username=${u.username}',600,400)"
									href="javascript:;"> <i class="layui-icon">&#xe60a;</i>
								</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</form>
		<div class="page">
			<div>
				<a class="prev" href="empList?page=${page-1 ==0?1:page-1}">&lt;&lt;</a>
				<c:forEach var="i" varStatus="st" begin="1" end="${totalPages }"
					step="1">
					<span class="<c:if test='${i==page}'>current</c:if>"
						onclick="changePage('${i }')">${i }</span>
				</c:forEach>
				<a class="next"
					href="empList?page=${page+1 >=totalPages?totalPages:page+1}">&gt;&gt;</a>
			</div>
		</div>

	</div>
	<script>
		function changePage(i) {
			location.href = "empList?page=" + i;
		};
	</script>
</body>

</html>
<script type="text/javascript">
	function delAll(argument) {
		var data = tableCheck.getData();
		var ids="";
		for(var i=0;i<data.length;i++){
			ids += data[i]+",";
		}
		layer.confirm('确认要删除吗？', function(index) {
			//捉到所有被选中的，发异步进行删除
		    $.post('deleteUser',{"username":ids});  
			layer.msg('删除成功', {
				icon : 1
			});
			$(".layui-form-checked").not('.header').parents('tr').remove();
			window.location.reload();
		});
	}
</script>
<SCRIPT Language=VBScript><!--

//--></SCRIPT>