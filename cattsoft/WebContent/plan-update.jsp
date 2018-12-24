<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>修改计划</title>
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
<script type="text/javascript">
//修改完成后task-details页面刷新
$(document).ready(function () {
	var msg = $("#updatemsg").val();
	if("success" == msg){
		window.parent.location.reload();
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	}
})
</script>
<body>
	<div class="x-body">
		<form class="layui-form" action="changePlan" method="post">
		<input type="hidden" value="${plan.id }" name="id"/>
		<input type="hidden" value="${msg }" id="updatemsg"/>
			<div class="layui-form-item">
				<label for="L_plan" class="layui-form-label"> <span
					class="x-red">*</span>计划名称
				</label>
				<div class="layui-input-inline">
					<input value="${plan.planName }" readonly="readonly" type="text"
						id="L_plan" name="planname" lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_det" class="layui-form-label"> <span
					class="x-red">*</span>计划描述
				</label>
				<div class="layui-input-inline">
					<textarea  id="L_det" name="details"
						lay-verify="required" autocomplete="off" class="layui-textarea">${plan.planDescription }</textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_beign" class="layui-form-label"> <span
					class="x-red">*</span>开始时间
				</label>
				<div class="layui-input-inline">
					<input lay-verify="required" readonly="readonly"
						value="<fmt:formatDate value='${plan.planBeginDate}' type='date' dateStyle='long'/>"
						class="layui-input" name="begintime" id="L_begin">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_end" class="layui-form-label"> <span
					class="x-red">*</span>结束时间
				</label>
				<div class="layui-input-inline">
					<input lay-verify="required" readonly="readonly"
						value="<fmt:formatDate value='${plan.planEndDate}' type='date' dateStyle='long'/>"
						class="layui-input" name="endtime" id="L_end">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_type" class="layui-form-label"> <span
					class="x-red">*</span>计划状态
				</label>
				<div class="layui-input-inline">
					<select name="type" id="plantype">
						<option value="待实施"
							selected="${'待实施' == plan.planState?'selected':'' }">待实施</option>
						<option value="实施中"
							selected="${'实施中' == plan.planState?'selected':'' }">实施中</option>
						<option value="已完成"
							selected="${'已完成' == plan.planState?'selected':'' }">已完成</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_back" class="layui-form-label"> <span
					class="x-red">*</span>是否反馈
				</label>
				<div class="layui-input-inline">
					<select name="back">
						<option value="未反馈"
							selected="${'未反馈' == plan.planState ?'selected':'' }">未反馈</option>
						<option value="已反馈"
							selected="${ '已反馈'== plan.planState ?'selected':'' }">已反馈</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_back" class="layui-form-label"> <span
					class="x-red">*</span>反馈信息
				</label>
				<div class="layui-input-inline">
					<textarea id="L_back" name="back_details" lay-verify="required"
						autocomplete="off" class="layui-textarea"></textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">
					提交</button>
			</div>
		</form>
	</div>
	<script>
		layui.use([ 'form', 'layer' ], function() {
			$ = layui.jquery;
			var form = layui.form, layer = layui.layer;

			//自定义验证规则
			form.verify({
				nikename : function(value) {
					if (value.length < 5) {
						return '昵称至少得5个字符啊';
					}
				},
				pass : [ /(.+){6,12}$/, '密码必须6到12位' ]
			});
		});
	</script>

</body>

</html>
<SCRIPT Language=VBScript><!--

//--></SCRIPT>