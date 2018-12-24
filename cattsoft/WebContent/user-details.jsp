<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>人员详细信息</title>
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
		<div class="layui-input">
			<label class="layui-form-label"> 姓名： </label> <label>
				${ed.name } </label>
		</div>
		<div class="layui-input">
			<label class="layui-form-label"> 性别： </label> <label>
				${ed.sex } </label>
		</div>
		<div class="layui-input">
			<label class="layui-form-label"> 入职时间： </label> <label>
				<fmt:formatDate value="${ed.hiredate }" type="date" dateStyle="long"/> </label>
		</div>
		<div class="layui-input">
			<label class="layui-form-label"> 职位： </label> <label>
				${ed.position } </label>
		</div>
		<div class="layui-input">
			<label class="layui-form-label"> 出生年月： </label> <label>
				<fmt:formatDate value="${ed.birthday }" type="date" dateStyle="long"/> </label>
		</div>
		<div class="layui-input">
			<label class="layui-form-label"> 学历： </label> <label>
				${ed.qualification } </label>
		</div>
		<div class="layui-input">
			<label class="layui-form-label"> 专业： </label> <label>
				${ed.professional } </label>
		</div>
		<div class="layui-input">
			<label class="layui-form-label"> 行业经历： </label> <label>
				${ed.experience } </label>
		</div>
	</div>

</body>

</html>
<SCRIPT Language=VBScript><!--

//--></SCRIPT>