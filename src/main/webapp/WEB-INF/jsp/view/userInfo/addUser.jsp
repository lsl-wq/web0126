<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.cqkj.service.UserInfoService"%>
<%@page import="com.cqkj.bean.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");

			int flag = Integer.parseInt(request.getParameter("flag"));

			UserInfo userInfo = null;
			if (flag == 1) {
				String userId = request.getParameter("userId");

				// 从Spring容器中获取Bean对象 
				ServletContext sc = this.getServletContext();
				ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);

				// 取出所需要的service层中的Bean
				UserInfoService userInfoService = (UserInfoService) ac.getBean("userInfoServiceImpl");

				userInfo = userInfoService.getUserInfoById(Integer.parseInt(userId));
			}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
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

	<div class="header">

		<h1 class="page-title">编辑用户信息</h1>
	</div>

	<ul class="breadcrumb">
		<li><a href="index" target="_top">主页</a> <span class="divider">/</span></li>
		<li><a href="userInfo">用户管理</a> <span class="divider">/</span></li>
		<li class="active">编辑用户</li>
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
						<form id="tab" action="<%=flag == 0 ? "add" : "update"%>"
							method="post">
							<label>用户类型</label> <select name="deptId" class="input-xlarge"
								id="deptId">
							</select> <label> 登录名<span>*</span>
							</label>
							<input type="text" name="loginName" class="input-xlarge" required
								id="loginName"
								value="<%=flag == 0 ? "" : userInfo.getLoginName()%>"
								<%=flag == 0 ? "" : "disabled"%>>
							<span id="spanVerification"></span> <label> 登录密码<span>*</span>
							</label>
							<input type="password" name="loginPwd" class="input-xlarge"
								required id="loginPwd"
								value="<%=flag == 0 ? "" : userInfo.getLoginPwd()%>">
							<label> 姓名<span>*</span>
							</label>
							<input type="text" name="name" class="input-xlarge" id="name"
								required value="<%=flag == 0 ? "" : userInfo.getName()%>">
							<label>性别</label> <select name="sex" id="sex"
								class="input-xlarge">
								<option value="y"
									<%=flag == 0 ? "" : userInfo.getSex().equals("y") ? "selected" : ""%>>男</option>
								<option value="x"
									<%=flag == 0 ? "" : userInfo.getSex().equals("x") ? "selected" : ""%>>女</option>
							</select> <label> 年龄<span>*</span>
							</label>
							<input type="text" name="age" class="input-xlarge" id="age"
								required value="<%=flag == 0 ? "" : userInfo.getAge()%>">
							<label>电话号码</label>
							<input type="text" name="phone" class="input-xlarge"
								value="<%=flag == 0 ? "" : userInfo.getPhone()%>">
							<label>身份证号</label>
							<input type="text" name="idCard" id="idCard" class="input-xlarge"
								value="<%=flag == 0 ? "" : userInfo.getIdCard()%>">
							<label>微信</label>
							<input type="text" name="weChat" class="input-xlarge"
								value="<%=flag == 0 ? "" : userInfo.getWeChat()%>">
							<label>地址</label>
							<input type="text" name="address" class="input-xlarge"
								value="<%=flag == 0 ? "" : userInfo.getAddress()%>">

							<!-- 隐藏的input -->
							<input type="hidden" name="userId"
								value="<%=flag == 0 ? "" : userInfo.getUserId()%>">
							<input type="hidden" name="createUser"
								value="<%=flag == 0 ? "" : userInfo.getCreateUser()%>">
							<input type="hidden" name="createDate"
								value="<%=flag == 0 ? "" : userInfo.getCreateDate().getTime()%>">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



	<script src="content/lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		var flag = true;

		$(function()
		{
			$("#tab").validate({
				rules : {
					loginName : "required",
					loginPwd : {
						required : true,
						rangelength : [ 6, 16 ]
					},
					name : "required",
					age : {
						required : true,
						digits : true,
						range : [ 0, 150 ]
					},
					idCard : {
						rangelength : [ 18, 18 ]
					}
				},
				messages : {
					loginName : "请输入登录名",
					loginPwd : {
						required : "请输入登录密码",
						rangelength : "密码长度为6-16 位"
					},
					name : "请输入姓名",
					age : {
						required : "请输入年龄",
						digits : "请输入0-150的整数",
						range : "请输入0-150的整数"
					},
					idCard : {
						rangelength : "请输入正确的18位身份证号"
					}
				},
				errorElement : "em"
			});

			$("#btnSave").click(function()
			{
				if ($("#tab").valid() && flag)
				{
					$("#loginName").attr("disabled", false);
					$("#tab").submit();
				}
			});

			$("#loginName").focus(function()
			{
				$("#spanVerification").text("");
			});

			$("#loginName").blur(initLoginName);

			initDept();
		});

		function initLoginName()
		{
			if ($.trim($(this).val()) != "")
			{
				$.ajax({
					url : "checkLoginName",
					type : "post",
					data : {
						"loginName" : $("#loginName").val()
					},
					dataType : "text",
					success : function(data)
					{
						if (data == "Y")
						{
							flag = false;
							$("#spanVerification").css("color", "red");
							$("#spanVerification").text("该用户名已被使用");
						} else
						{
							flag = true;
							$("#spanVerification").css("color", "green");
							$("#spanVerification").text("该用户名可使用");
						}
					}
				});
			}

		}

		function initDept()
		{
			$
					.ajax({
						url : "getDeptJson",
						type : "post",
						dataType : "json",
						success : function(data)
						{
							var stdept = $("#deptId");

							//得到用户的部门ID
							var deptId =
	<%=flag == 0 ? "\"\"" : userInfo.getDeptId()%>
		;

							for ( var i in data)
							{
								var option = "<option value='" + data[i].deptId
										+ "'";

								//选中用户的部门
								if (deptId == data[i].deptId)
								{
									option = option + "selected";
								}

								option = option + ">" + data[i].deptName
										+ "</option>";

								stdept.append(option);
							}
						}
					});
		}
	</script>

</body>
</html>