<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.cqkj.service.DeptInfoService"%>
<%@page import="com.cqkj.bean.DeptInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");

			int flag = Integer.parseInt(request.getParameter("flag"));

			DeptInfo deptInfo = null;
			if (flag == 1) {
				String deptId = request.getParameter("deptId");

				// 从Spring容器中获取Bean对象 
				ServletContext sc = this.getServletContext();
				ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);

				// 取出所需要的service层中的Bean
				DeptInfoService deptInfoService = (DeptInfoService) ac.getBean("deptInfoServiceImpl");

				deptInfo = deptInfoService.getDeptInfoById((Integer.parseInt(deptId)));
			}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加部门</title>
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

		<h1 class="page-title">编辑用户类型信息</h1>
	</div>

	<ul class="breadcrumb">
		<li><a href="index" target="_top">主页</a> <span
			class="divider">/</span></li>
		<li><a href="deptInfo">用户类型管理</a> <span class="divider">/</span></li>
		<li class="active">编辑用户类型</li>
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
							action="<%=flag == 0 ? "addDeptInfo" : "updateDeptInfo"%>"
							method="post">
							<label>用户类型编号<span>*</span></label>
							<input type="text" name="deptCode" class="input-xlarge" required
								id="deptCode"
								value="<%=flag == 0 ? "" : deptInfo.getDeptCode()%>">
							<label>用户类型名称<span>*</span>
							</label>
							<input type="text" name="deptName" class="input-xlarge" required
								id="deptName"
								value="<%=flag == 0 ? "" : deptInfo.getDeptName()%>">

							<!-- 隐藏的input -->
							<input type="hidden" name="deptId"
								value="<%=flag == 0 ? "" : deptInfo.getDeptId()%>">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



	<script src="content/lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$(function()
		{
			$("#tab").validate({
				rules : {
					deptCode : "required",
					deptName : "required"
				},
				messages : {
					deptCode : "请输入用户类型编号",
					deptName : "请输入用户类型名称"
				},
				errorElement : "em"
			});

			$("#btnSave").click(function()
			{
				if ($("#tab").valid())
				{
					$("#tab").submit();
				}
			});
		});
	</script>

</body>
</html>