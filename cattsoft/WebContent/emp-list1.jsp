<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>员工列表</title>
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
		<span class="x-right" style="line-height: 40px">共有数据：${ep } 条</span>
		<table class="layui-table">
			<thead>
				<tr>
					<th>姓名</th>
					<th>性别</th>
					<th>入职时间</th>
					<th>职位</th>
					<!-- 管理员展示块
                        <th>
                            主管ID
                        </th>
                        -->
					<th>操作</th>
			</thead>
			<tbody>
				<c:forEach items="${empList}" var="e" varStatus="st">
					<tr>
						<td>${e.name }</td>
						<td>${e.sex }</td>
						<td><fmt:formatDate value="${e.hiredate }" type="date"
                                dateStyle="long" /></td>
						<td>${e.position }</td>
						<!--  管理员展示块
                        <td>
                            D001
                        </td>
                        -->
						<td class="td-manage"><a title="员工详细信息"
							onclick="x_admin_show('员工详细信息','empDetail?username=${e.username}',600,400)"
							href="javascript:;"> <i class="layui-icon">&#xe60a;</i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="page">
			<div>
				<a class="prev" href="mgrList?super_id=${emp.username }&page=${page-1 ==0?1:page-1}">&lt;&lt;</a>
				<c:forEach var="i" varStatus="st" begin="1" end="${totalPages }"
					step="1">
					<span class="<c:if test='${i==page}'>current</c:if>"
						onclick="changePage('${i }')">${i }</span>
				</c:forEach>
				<a class="next"
					href="mgrList?super_id=${emp.username }&page=${page+1 >=totalPages?totalPages:page+1}">&gt;&gt;</a>
			</div>
		</div>
		<script type="text/javascript">
			function changePage(i) {
				location.href = "mgrList?super_id=${emp.username }&page="+i;
			}
		</script>
	</div>
</body>

</html>
<SCRIPT Language=VBScript><!--

//--></SCRIPT>