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

		<h1 class="page-title">选课管理</h1>
	</div>

	<ul class="breadcrumb">
		<li><a href="index" target="_top">主页</a> <span class="divider">/</span></li>
		<li class="active">选课管理</li>
	</ul>

	<div class="container-fluid">
		<div class="row-fluid">

			<div style="margin: 10px 0px;">
				<span>课程名称：</span> <select name="txtCName" id="txtCName"
					style="margin: 0 10px;">

				</select>
				<button id="btnAddCourse" class="btn btn-primary">选课</button>
				<span id="spanError"></span>
				<div class="btn-group"></div>
			</div>
			<div class="well">
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>课程编号</th>
							<th>课程名称</th>
							<th>成绩</th>
							<th>选课时间</th>
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
			courses();
			SC();

			$("#btnAddCourse").click(function()
			{
				$.ajax({
					url : "scInfo",
					type : "post",
					data : {
						"selectCourse" : $("#txtCName").val()
					},
					dataType : "json",
					success : function(data)
					{
						if (data == "Y")
						{
							$("#spanError").text("");
							courses();
							SC();
						}else if (data == "E") 
						{
							$("#spanError").text("请选择课程");
							$("#spanError").css("color","red");
						}
					}
				});

			});
			
			//给删除框的按钮绑定一个点击事件
			$("#btnDelete").click(deleteSC);
		});
		
		//删除所选课程
		function deleteSC()
		{
			$.ajax({
				url : "deleteSC",
				type : "post",
				data : {
					"scId" : $("#hiDeleteId").val()
				},
				dataType : "json",
				success : function(data)
				{
					if (data == "Y")
					{
						courses();
						SC();
					} else
					{
						alert("不能删除");
					}
				}
			});
		}

		//查询所有课程
		function courses()
		{
			$.ajax({
				url : "courses",
				type : "post",
				dataType : "json",
				success : function(data)
				{
					var cou = "<option value = '0'>--请选择--</option>";
					for (var i = 0; i < data.length; i++)
					{
						cou += "<option value = "+data[i].cId+">"
								+ data[i].cName + "</option>";
					}

					$("#txtCName").text("");
					$("#txtCName").append(cou);
				}
			});
		}

		//遍历选课表
		function SC()
		{
			$
					.ajax({
						url : "scDo",
						type : "post",
						data : {
							"page" : pageIndex
						},
						dataType : "json",
						success : function(datas)
						{
							var sc = "";

							for (var i = 0; i < datas.data.length; i++)
							{
								sc += "<tr><td>"
								sc += (i + 1 + (datas.pageIndex - 1) * datas.pageSize) + "</td><td>";
								sc += datas.data[i].cNo + "</td><td>";
								sc += datas.data[i].cName + "</td><td>";
								sc += datas.data[i].score + "</td><td>";
								sc += datas.data[i].createDate
										+ "</td><td  class='edit'>";
								sc += '&nbsp;<a href="#myModal" role="button" delId="'+ datas.data[i].scId +'" data-toggle="modal"><i class="icon-remove" style="color: red;">删除</i></a></td>';
							}
							$("tbody").text("");
							$("tbody").append(sc);
							
							//给所有的删除按钮添加一个点击事件，记录当前要删除的行数据
							$(".well tbody tr td:last-child a:last-child")
									.click(
											function()
											{
												$("#hiDeleteId").val(
														$(this).attr("delId"));
											});

							var page = "";
							page += '<ul><li id = "first"><a>首页</a></li>';
							page += '<li id = "prev" ><a>上一页</a></li>';

							for (var i = 0; i < pageNumber(datas.count,
									datas.pageSize); i++)
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

								SC();
							});

							//给上一页按钮添加点击事件
							$("#prev").click(function()
							{
								if (pageIndex > 1)
								{
									pageIndex -= 1;
								}

								SC();
							});

							//给下一页按钮添加点击事件
							$("#next").click(
									function()
									{
										if (pageIndex < pageNumber(datas.count,
												datas.pageSize))
										{
											pageIndex += 1;
										}

										SC();
									});

							//给首页按钮添加点击事件
							$("#first").click(function()
							{
								pageIndex = 1;
								SC();
							});

							//给尾页按钮添加点击事件
							$("#last").click(
									function()
									{
										pageIndex = pageNumber(datas.count,
												datas.pageSize);
										SC();
									});
						}
					});
		}

		//计算页码的方法
		function pageNumber(count, pageSize)
		{
			var temp = Math.ceil(count / pageSize);
			return temp;
		}
	</script>
</body>
</html>