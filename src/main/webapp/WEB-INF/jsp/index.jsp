<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
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

<!-- Demo page code -->

<style type="text/css">
.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}

#dropOut {
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
	user-select: none;
}
</style>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
	<!--<![endif]-->
	<!-- 标题栏 -->
	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav pull-right">
				<li id="fat-menu" class="dropdown"><a href="#" role="button"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-user"></i> ${loginName} <i class="icon-caret-down"></i>
				</a>

					<ul class="dropdown-menu">
						<!-- <li><a tabindex="-1" href="login.jsp">注销</a></li>
						<li class="divider"></li> -->
						<!-- 隐藏设置 -->
						<!-- <li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
						<li class="divider visible-phone"></li> -->
						<li><a tabindex="-1" id="dropOut">退出</a></li>
					</ul></li>

			</ul>
			<a class="brand" href="index"><span class="first">池泉教务</span>
				<span class="second">管理系统</span></a>
		</div>
	</div>

	<!-- 左菜单栏 -->
	<div class="sidebar-nav">
		<c:if test="${deptCode == \"system\"}">
			<a href="#user-menu" class="nav-header" data-toggle="collapse"><i
				class="icon-dashboard"></i>系统管理 <i class="icon-chevron-up"></i></a>
			<ul id="user-menu" class="nav nav-list in collapse">
				<li><a data-href="userInfo">用户管理</a></li>
				<li><a data-href="deptInfo">用户类型管理</a></li>
			</ul>
			<a href="#others" class="nav-header collapsed" data-toggle="collapse"><i
				class="icon-dashboard"></i>教务管理<i class="icon-chevron-up"></i></a>
			<ul id="others" class="nav nav-list collapse">
				<li><a data-href="course">课程管理</a></li>
				<li><a data-href="score">成绩管理</a></li>
				<li><a data-href="scCount">选课统计</a></li>
			</ul>
		</c:if>
		<c:if test="${deptCode == \"teacher\"}">
			<a href="#others" class="nav-header" data-toggle="collapse"><i
				class="icon-dashboard"></i>教务管理 <i class="icon-chevron-up"></i></a>
			<ul id="others" class="nav nav-list in collapse">
				<li><a data-href="score">成绩管理</a></li>
			</ul>
		</c:if>
		<c:if test="${deptCode == \"student\"}">
			<a href="#others" class="nav-header" data-toggle="collapse"><i
				class="icon-dashboard"></i>教务管理 <i class="icon-chevron-up"></i></a>
			<ul id="others" class="nav nav-list in collapse">
				<li><a data-href="sc">学生选课</a></li>
			</ul>
		</c:if>
	</div>

	<div class="content">
		<div
			style="position: absolute; left: 0px; top: 0px; bottom: 0px; right: 0px; padding: 0px">
			<iframe id="contextFrame" name="contextFrame" src="welcome"
				width="100%" height="100%"></iframe>
		</div>
	</div>

	<script src="content/lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function()
		{
			$('.demo-cancel-click').click(function()
			{
				return false;
			});

			// 初始化菜单点击事件
			$(".collapse li").each(function(index)
			{
				var curUrl = $(this).find("a").attr("data-href");
				$(this).click(function()
				{
					$("#contextFrame").attr("src", curUrl);
				});

				$(this).css("cursor", "pointer");
			});

			$("#dropOut").click(function()
			{
				window.location.href = "dropOutDo";
			});
		});
	</script>

</body>
</html>