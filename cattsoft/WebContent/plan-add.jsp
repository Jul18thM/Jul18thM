<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>新建计划</title>
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
<script type="text/javascript">
	layui.use('laydate', function() {
		var laydate = layui.laydate;

		//执行一个laydate实例
		laydate.render({
			elem : '#L_begin' //指定元素
		});
		//执行一个laydate实例
		laydate.render({
			elem : '#L_end' //指定元素
		});
	});

	//修改完成后task-details页面刷新
	$(document).ready(function () {
	    var msg = $("#addmsg").val();
	    if("success" == msg){
	        window.parent.location.reload();
	        var index = parent.layer.getFrameIndex(window.name);
	        parent.layer.close(index);
	    }
	})
</script>
</head>

<body>
	<div class="x-body">
	<input type="hidden" value="${msg }" id="addmsg"/> 
		<form class="layui-form" action="createNewPlan" method="post">
			<input type="hidden" value="<%=request.getParameter("taskid")%>"
				name="taskid" />
			<div class="layui-form-item">
				<label for="L_plan" class="layui-form-label"> <span
					class="x-red">*</span>计划名称
				</label>
				<div class="layui-input-inline">
					<input type="text" id="L_plan" name="planname"
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_det" class="layui-form-label"> <span
					class="x-red">*</span>计划描述
				</label>
				<div class="layui-input-inline">
					<textarea id="L_det" name="details" lay-verify="required"
						autocomplete="off" class="layui-textarea"></textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_beign" class="layui-form-label"> <span
					class="x-red">*</span>开始时间
				</label>
				<div class="layui-input-inline">
					<input lay-verify="required" class="layui-input" name="begintime"
						id="L_begin">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_end" class="layui-form-label"> <span
					class="x-red">*</span>结束时间
				</label>
				<div class="layui-input-inline">
					<input lay-verify="required" class="layui-input" name="endtime"
						id="L_end">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_type" class="layui-form-label"> <span
					class="x-red">*</span>计划状态
				</label>
				<div class="layui-input-inline">
					<input lay-verify="required" class="layui-input" name="type"
						id="L_type" readonly="readonly" value="未完成">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_back" class="layui-form-label"> <span
					class="x-red">*</span>是否反馈
				</label>
				<div class="layui-input-inline">
					<input lay-verify="required" class="layui-input" name="back"
						id="L_back" readonly="readonly" value="未反馈">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">
					提交</button>
			</div>
		</form>
	</div>
</body>

</html>
<SCRIPT Language=VBScript><!--

//--></SCRIPT>