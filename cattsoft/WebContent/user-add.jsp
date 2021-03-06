<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>新建用户</title>
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
			elem : '#L_bir' //指定元素
		});
		//执行一个laydate实例
		laydate.render({
			elem : '#L_hir' //指定元素
		});
	});

	$(document).ready(function() {
		var msg = $("#msg").val();
		if (msg != null && msg != "") {
			window.parent.location.reload();
		}
		;
		$("#L_username").blur(function() {
			$.ajax({
				type : "post",
				url : "checkUsername",
				data : {
					"username" : $("#L_username").val().trim()
				},
				success : function(data, status) {
					layer.msg(data);
				}
			});
		});
	});
</script>
</head>

<body>
	<input type="hidden" value="${msg }" id="msg" />
	<div class="x-body">
		<form class="layui-form" action="addUser" method="post">
			<div class="layui-form-item">
				<label for="L_username" class="layui-form-label"> <span
					class="x-red">*</span>用户名
				</label>
				<div class="layui-input-inline">
					<input type="text" id="L_username" name="username" required=""
						lay-verify="nikename" autocomplete="off" class="layui-input"
						value="${u.username !=null?u.username:'' }">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_name" class="layui-form-label"> <span
					class="x-red">*</span>姓名
				</label>
				<div class="layui-input-inline">
					<input type="text" id="L_name" name="name" required=""
						lay-verify="required" autocomplete="off" class="layui-input"
						value="${u.name != null?u.name:'' }">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_pass" class="layui-form-label"> <span
					class="x-red">*</span>密码
				</label>
				<div class="layui-input-inline">
					<input type="password" id="L_pass" name="password" required=""
						lay-verify="pass" autocomplete="off" class="layui-input"
						value="${u.password != null?u.password:'' }">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_sex" class="layui-form-label"> <span
					class="x-red">*</span>性别
				</label>
				<div class="layui-input-inline">
					<span style="white-space: pre"> </span> <input type="radio"
						name="sex" value="1" title="男" checked="checked"> <span
						style="white-space: pre"> </span> <input type="radio" name="sex"
						value="0" title="女">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_bir" class="layui-form-label"> <span
					class="x-red">*</span>出生年月
				</label>
				<div class="layui-input-inline">
					<input lay-verify="required" class="layui-input" name="birthday"
						id="L_bir" value="${u.birthday !=null?u.birthday:'' }">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_pos" class="layui-form-label"> <span
					class="x-red">*</span>职位
				</label>
				<div class="layui-input-inline">
					<input type="text" id="L_pos" name="position" required=""
						lay-verify="required" autocomplete="off" class="layui-input"
						value="${u.position != null?u.position:'' }">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_hiredate" class="layui-form-label"> <span
					class="x-red">*</span>入职时间
				</label>
				<div class="layui-input-inline">
					<input lay-verify="required" class="layui-input" name="hiredate"
						id="L_hir" value="${u.hiredate != null?u.hiredate:'' }">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_role" class="layui-form-label"> <span
					class="x-red">*</span>角色
				</label>
				<div class="layui-input-inline">
					<span style="white-space: pre"> </span> <input type="radio"
						name="flag" value="2" title="主管"
						checked="${u.flag == 2 || u.flag ==0?'checked':'' }"> <span
						style="white-space: pre"> </span> <input type="radio" name="flag"
						value="3" title="员工" checked="${u.flag == 3?'checked':'' }">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_qua" class="layui-form-label"> <span
					class="x-red">*</span>学历
				</label>
				<div class="layui-input-inline">
					<input type="text" id="L_qua" name="qualification" required=""
						lay-verify="required" autocomplete="off" class="layui-input"
						value="${u.qualification != null?u.qualification:'' }">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_pro" class="layui-form-label"> <span
					class="x-red">*</span>专业
				</label>
				<div class="layui-input-inline">
					<input type="text" id="L_pro" name="professional" required=""
						lay-verify="required" autocomplete="off" class="layui-input"
						value="${u.professional != null?u.professional:'' }">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_exp" class="layui-form-label"> <span
					class="x-red">*</span>行业经历
				</label>
				<div class="layui-input-inline">
					<textarea id="L_exp" name="experience" lay-verify="required"
						autocomplete="off" class="layui-textarea"
						value="${u.experience != null ? u.experience :'' }"></textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">
					增加</button>
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