<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="项目描述">
<meta name="author" content="作者">

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

body {
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

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="../assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
	<!--<![endif]-->

	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav pull-right">

			</ul>
			<a class="brand"><span class="first">池泉教务</span>
				<span class="second">管理系统</span></a>
		</div>
	</div>
	<div class="row-fluid">
		<div class="dialog">
			<div class="block">
				<p class="block-heading">用户登陆</p>
				<div class="block-body">
					<form id="form1" method="post" action="loginDo">
						<label>用户名</label> <input type="text" class="span12"
							name="loginName" id="loginName"> <label>密码</label> <input
							type="password" class="span12" name="loginPwd" id="loginPwd">
						<a class="btn btn-primary pull-right" id="btnlogin">登陆</a> 
						<span style="display: none; color: red;" id="spanShowName">用户名不能为空</span>
						<span style="display: none; color: red;" id="spanShowPwd">密码不能为空</span>
						<div class="clearfix" style="color: red;"><%=request.getAttribute("msg") == null ? "" : "Error：用户名或密码错误！"%></div>
					</form>
				</div>
			</div>
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

			$("#btnlogin").click(function()
			{
				//判断用户名或密码是否为空，若为空则提示用户重新输入
				if ($("#loginName").val() == "")
				{
					$(".clearfix").text("");
					$("#spanShowName").css("display", "block");
					$("#spanShowPwd").css("display", "none");
				} else
				{
					if ($("#loginPwd").val() == "")
					{
						$(".clearfix").text("");
						$("#spanShowName").css("display", "none");
						$("#spanShowPwd").css("display", "block");
					}
					else 
					{
						//若用户名密码不为空，则将ID为form1的表单提交
						$("#form1").submit();
					}
					
				}
			});
		});
	</script>

</body>
</html>