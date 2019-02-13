<%@page import="com.cqkj.bean.TCourse"%>
<%@page import="com.cqkj.bean.PageList"%>
<%@page import="java.util.List"%>
<%@page import="com.cqkj.service.UserInfoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
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

<script src="content/lib/jquery-1.8.1.min.js" type="text/javascript"></script>
<style type="text/css">
.pagination {
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
	user-select: none;
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

		<h1 class="page-title">课程管理</h1>
	</div>

	<ul class="breadcrumb">
		<li><a href="index" target="_top">主页</a> <span class="divider">/</span></li>
		<li class="active">课程管理</li>
	</ul>

	<div class="container-fluid">
		<div class="row-fluid">

			<div class="btn-toolbar">
				<button id="btnAddUser" class="btn btn-primary">
					<i class="icon-plus"></i> 新增课程
				</button>
				<input type="text" name="txtCName" id="txtCName"
					style="margin: 0 10px;" />
				<input type="hidden" id="txtSaveCName">
				<button class="btn" id="btnSearch">查&nbsp;询</button>
				<div class="btn-group"></div>
			</div>
			<div class="well">
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>课程编号</th>
							<th>课程名称</th>
							<th>创建日期</th>
							<th style="width: 100px;">操作</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
			<div class="pagination"></div>

			<div class="modal small hide fade" id="myModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">删除确认</h3>
				</div>
				<div class="modal-body">
					<p class="error-text">
						<i class="icon-warning-sign modal-icon"></i>您确定要删除该课程吗？
					</p>
				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
					<button class="btn btn-danger" data-dismiss="modal" id="btnDelete">删除</button>
				</div>
			</div>

		</div>
	</div>

	<input type="hidden" id="hiDeleteId" value="" />

	<script src="content/lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		var pageIndex = 1;

		$(function()
		{
			//初始化查询结果
			selectCourse();

			//动态生成页码信息
			totalPages();

			// 控制菜单跳转
			$("#btnAddUser").click(function()
			{
				window.location.href = "addCourse?flag=0"
			});

			//给查询按钮添加点击事件
			$("#btnSearch").click(function()
			{
				$("#txtSaveCName").val($("#txtCName").val());
				selectCourse();
			});

			//给删除框的按钮绑定一个点击事件
			$("#btnDelete").click(deleteCourse);

		});

		//删除的方法
		function deleteCourse()
		{
			$.ajax({
				url : "deleteCourse",
				type : "post",
				data : {
					"cId" : $("#hiDeleteId").val()
				},
				dataType : "json",
				success : function(data)
				{
					if (data == "Y")
					{
						selectCourse(1);
						totalPages();
					} else
					{
						alert("该课程有学生选择，不能删除");
					}
				}
			});
		}

		//查询的方法
		function selectCourse()
		{
			$
					.ajax({
						url : "selectAllCourse",
						type : "post",
						data : {
							"cName" : $.trim($("#txtSaveCName").val()),
							"pageIndex" : pageIndex
						},
						dataType : "json",
						success : function(datas)
						{
							var course = "";

							for (var i = 0; i < datas.data.length; i++)
							{
								course += "<tr><td>"
								course += (i + 1 + (datas.pageIndex - 1) * datas.pageSize) + "</td><td>";
								course += datas.data[i].cNo + "</td><td>";
								course += datas.data[i].cName + "</td><td>";
								course += datas.data[i].createDate
										+ "</td><td  class='edit'>";
								course += '<a href="addCourse?flag=1&cId='
										+ datas.data[i].cId
										+ '"><i class="icon-pencil">编辑</i></a>&nbsp;';
								course += '&nbsp;<a href="#myModal" role="button" delId="'+ datas.data[i].cId +'" data-toggle="modal"><i class="icon-remove" style="color: red;">删除</i></a></td>';
							}

							$("tbody").text("");
							$("tbody").append(course);

							//给所有的删除按钮添加一个点击事件，记录当前要删除的行数据
							$(".well tbody tr td:last-child a:last-child")
									.click(
											function()
											{
												$("#hiDeleteId").val(
														$(this).attr("delId"));
											});
						
							totalPages();
						}
					});
		}

		//动态生成总的页数
		function totalPages()
		{
			$.ajax({
				url : "courseCountPage",
				type : "post",
				data : {
					"cName" : $.trim($("#txtSaveCName").val())
				},
				dataType : "json",
				async : "false",
				success : function(data)
				{
					var page = "";
					page += '<ul><li id = "first"><a>首页</a></li>';
					page += '<li id = "prev" ><a>上一页</a></li>';

					for (var i = 0; i < data; i++)
					{
						page += '<li class = "list"><a>' + (i + 1)
								+ '</a></li>';
					}

					page += '<li id = "next"><a>下一页</a></li>';
					page += '<li id = "last"><a>尾页</a></li></ul>';

					$(".pagination").text("");
					$(".pagination").append(page);

					//给生成的页码按钮添加点击事件
					$(".list").click(function()
					{
						pageIndex = $(this).text();

						selectCourse();
					});

					//给上一页按钮添加点击事件
					$("#prev").click(function()
					{
						if (pageIndex > 1)
						{
							pageIndex -= 1;
						}

						selectCourse();
					});

					//给下一页按钮添加点击事件
					$("#next").click(function()
					{
						if (pageIndex < data)
						{
							pageIndex += 1;
						}

						selectCourse();
					});

					//给首页按钮添加点击事件
					$("#first").click(function()
					{
						pageIndex = 1;
						selectCourse();
					});

					//给尾页按钮添加点击事件
					$("#last").click(function()
					{
						pageIndex = data;
						selectCourse();
					});
				}
			});

		}
	</script>
</body>
</html>