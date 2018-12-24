<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script type="text/javascript">
     layui.use('laydate', function(){
        var laydate = layui.laydate;
     
        //执行一个laydate实例
        laydate.render({
          elem: '#L_begin' //指定元素
        });
         //执行一个laydate实例
        laydate.render({
          elem: '#L_end' //指定元素
        });
      });
    
    $(document).ready(function () {
		var msg = $("#updatemsg").val();
		if("success" == msg){
			window.parent.location.reload();
		};
	});
    </script>
</head>

<body>
	<div class="x-body">
		<form class="layui-form" action="updateUnDoPlanById" method="post">
		<input type="hidden" value="${td.id }" name="id">
		<input type="hidden" value="${msg }" id="updatemsg">
		<input type="hidden" value="${emp.username }" name="emp_id">
			<div class="layui-form-item">
				<label for="L_task" class="layui-form-label"> <span
					class="x-red">*</span>任务名称
				</label>
				<div class="layui-input-inline">
					<input type="text" id="L_task" name="taskname"
						lay-verify="required" autocomplete="off" class="layui-input" value="${td.taskName }">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_det" class="layui-form-label"> <span
					class="x-red">*</span>任务描述
				</label>
				<div class="layui-input-inline">
					<textarea id="L_det" name="details" lay-verify="required"
						autocomplete="off" class="layui-textarea">${td.taskDescription }</textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_beign" class="layui-form-label"> <span
					class="x-red">*</span>开始时间
				</label>
				<div class="layui-input-inline">
					<input value="<fmt:formatDate value='${td.taskBeginTime }' pattern='yyyy-MM-dd'/>" lay-verify="required" class="layui-input"
						name="begintime" id="L_begin">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_end" class="layui-form-label"> <span
					class="x-red">*</span>结束时间
				</label>
				<div class="layui-input-inline">
					<input value="<fmt:formatDate value='${td.taskEndTime }' pattern='yyyy-MM-dd'/>" lay-verify="required" class="layui-input"
						name="endtime" id="L_end">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"> <span class="x-red">*</span>实施人
				</label>
				<div class="layui-input-inline">
					<input lay-verify="required" class="layui-input" name="name"
						id="L_type" readonly="readonly" value="${name }">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_type" class="layui-form-label"> <span
					class="x-red">*</span>任务状态
				</label>
				<div class="layui-input-inline">
					<input lay-verify="required" class="layui-input" name="type"
						id="L_type" readonly="readonly" value="未实施">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"> <span class="x-red">*</span>更改实施人
				</label>
				<div class="layui-input-inline">
					<select name="staff_id" class="valid">
                        <c:forEach items="${sn }" var="sn" varStatus="st">
                            <option value="${sn.username }">${sn.name }</option>
                        </c:forEach>
                    </select>
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
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
          });
        });
    </script>

</body>

</html>
<SCRIPT Language=VBScript><!--

//--></SCRIPT>