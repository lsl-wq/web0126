<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.cqkj.service.TCourseService"%>
<%@page import="com.cqkj.bean.TCourse"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");

			int flag = Integer.parseInt(request.getParameter("flag"));

			TCourse tCourse = null;
			if (flag == 1) {
				String cId = request.getParameter("cId");

				// 从Spring容器中获取Bean对象 
				ServletContext sc = this.getServletContext();
				ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
				
				// 取出所需要的service层中的Bean
				TCourseService tCourseService = (TCourseService) ac.getBean("tCourseServiceImpl");
				
				tCourse = tCourseService.getTCourseById((Integer.parseInt(cId)));
			}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加课程</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="content/lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css"
	href="content/stylesheets/theme.css">
<link rel="stylesheet"
	href="content/lib/font-awesome/css/font-awesome.css">

<script src="content/lib/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="content/lib/jquery.validate.min.js"></script>
<script src="content/lib/messages_zh.js"></script>
<!-- Demo page code -->

<style type="text/css">
#tab label span {
	color: red;
}

.error {
	color: red;
}
</style>
</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
	<!--<![endif]-->

	<div class="header">

		<h1 class="page-title">编辑课程信息</h1>
	</div>

	<ul class="breadcrumb">
		<li><a href="index" target="_top">主页</a> <span
			class="divider">/</span></li>
		<li><a href="course">课程管理</a> <span class="divider">/</span></li>
		<li class="active">编辑课程</li>
	</ul>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="btn-toolbar">
				<button class="btn btn-primary" id="btnSave">
					<i class="icon-save"></i> 保存
				</button>
			</div>
			<div class="well">
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane active in" id="home">
						<form id="tab"
							action="<%=flag == 0 ? "addTCourse" : "updateCourse"%>"
							method="post">
							<label>课程编号<span>*</span></label>
							<input type="text" name="cNo" class="input-xlarge" required
								id="cNo" value="<%=flag == 0 ? "" : tCourse.getcNo()%>">
							<span id="spanVerification"></span> <label>课程名称<span>*</span>
							</label>
							<input type="text" name="cName" class="input-xlarge" required
								id="cName" value="<%=flag == 0 ? "" : tCourse.getcName()%>">

							<!-- 隐藏的input -->
							<input type="hidden" name="cId"
								value="<%=flag == 0 ? "" : tCourse.getcId()%>">
							<input type="hidden" name="createDate"
								value="<%=flag == 0 ? "" : tCourse.getCreateDate().getTime()%>">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



	<script src="content/lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		var flag = true;
		var cNo = $("#cNo").val();

		$(function()
		{
			$("#tab").validate({
				rules : {
					cNo : "required",
					cName : "required"
				},
				messages : {
					cNo : "请输入课程编号",
					cName : "请输入课程名称"
				},
				errorElement : "em"
			});

			$("#btnSave").click(function()
			{
				if ($("#tab").valid() && flag)
				{
					$("#tab").submit();
				}
			});

			$("#cNo").blur(function()
			{
				if ($("#cNo").val() != cNo)
				{
					initCNo();
				} else if ($.trim($("#cNo").val()) != "")
				{
					flag = true;
					$("#spanVerification").css("color", "green");
					$("#spanVerification").text("该课程编号可以使用！");
				}
			});

			$("#cNo").focus(function()
			{
				$("#spanVerification").text("");
			});
		});

		function initCNo()
		{
			if ($.trim($("#cNo").val()) != "")
			{
				$.ajax({
					url : "checkCNo",
					type : "post",
					data : {
						"cNo" : $("#cNo").val()
					},
					dataType : "json",
					success : function(data)
					{
						if (data == 'Y')
						{
							flag = false;
							$("#spanVerification").css("color", "red");
							$("#spanVerification").text("该课程编号已被使用！");
						} else
						{
							flag = true;
							$("#spanVerification").css("color", "green");
							$("#spanVerification").text("该课程编号可以使用！");
						}
					}

				});
			}
		}
	</script>

</body>
</html>