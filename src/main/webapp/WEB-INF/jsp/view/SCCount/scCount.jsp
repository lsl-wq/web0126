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
<script src="content/lib/jquery.validate.min.js"></script>
<script src="content/lib/messages_zh.js"></script>
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

		<h1 class="page-title">选课统计</h1>
	</div>

	<ul class="breadcrumb">
		<li><a href="index" target="_top">主页</a> <span
			class="divider">/</span></li>
		<li class="active">选课统计</li>
	</ul>

	<div class="container-fluid">
		<div class="row-fluid">
			<div style="margin: 10px 0;">
				<span>学生：</span> <select name="stStuName" id="stStuName" required
					style="margin: 0 10px;">

				</select>
				<button id="btnSubmit" class="btn btn-primary">查&nbsp;询</button>
				<span id="spanPrompt" style="color: red;margin-left: 10px;"></span>
				<div
					style="float: right; font-size: 15px; margin-right: 80px; color: red;">
					<span>总成绩：</span> <span id="sum">0</span>
				</div>
				<!-- <div class="btn-group"></div> -->
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
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
			<div class="pagination"></div>

		</div>
	</div>

	<script src="content/lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
			var pageIndex = 1;
			var sum = 0;
			
			$(function()
			{
				getStudent();

				$("#btnSubmit").click(function() 
				{
					selectScore();
				});
				
			});

			function selectScore()
			{
				sum = 0;
				if($("#stStuName").val() > 0)
				{
					$("#spanPrompt").text("");
					
					$.ajax(
					{
						url: "selectScore",
						type: "post",
						data:
						{
							"pageIndex": pageIndex,
							"stuId": $("#stStuName").val()
						},
						dataType: "json",
						success: function(datas)
						{
							var score = "";

							for(var i = 0; i < datas.data.length; i++)
							{
								score += "<tr><td>"
								score += (i + 1 + (datas.pageIndex - 1) * datas.pageSize) + "</td><td>";
								score += datas.data[i].cNo + "</td><td>";
								score += datas.data[i].cName + "</td><td>";
								score += datas.data[i].score + "</td><td>";
								score += datas.data[i].createDate + "</td>";
								sum += datas.data[i].score;
							}
							
							$("#sum").text(sum);

							$("tbody").text("");
							$("tbody").append(score);

							var page = "";
							page += '<ul><li id = "first"><a>首页</a></li>';
							page += '<li id = "prev" ><a>上一页</a></li>';

							for(var i = 0; i < pageNumber(datas.count,
									datas.pageSize); i++)
							{
								page += '<li class = "list"><a>' + (i + 1) +
									'</a></li>';
							}

							page += '<li id = "next"><a>下一页</a></li>';
							page += '<li id = "last"><a>尾页</a></li></ul>';

							$(".pagination").text("");
							$(".pagination").append(page);

							//给生成的页码按钮添加点击事件
							$(".list").click(function()
							{
								pageIndex = $(this).text();

								selectScore();
							});

							//给上一页按钮添加点击事件
							$("#prev").click(function()
							{
								if(pageIndex > 1)
								{
									pageIndex -= 1;
								}

								selectScore();
							});

							//给下一页按钮添加点击事件
							$("#next").click(
								function()
								{
									if(pageIndex < pageNumber(datas.count,
											datas.pageSize))
									{
										pageIndex += 1;
									}

									selectScore();
								});

							//给首页按钮添加点击事件
							$("#first").click(function()
							{
								pageIndex = 1;
								selectScore();
							});

							//给尾页按钮添加点击事件
							$("#last").click(
								function()
								{
									pageIndex = pageNumber(datas.count,
										datas.pageSize);
									selectScore();
								});
						}

					});
				}else 
				{
					$("#spanPrompt").text("请选择学生");
					$("#sum").text("0");
					$("tbody").text("");
					$(".pagination").text("");
				}
			}

			function getStudent()
			{
				$.ajax(
				{
					url: "getStu",
					type: "post",
					dataType: "json",
					success: function(data)
					{
						var stuName = "<option value = '0'>--请选择--</option>";

						for(var i = 0; i < data.length; i++)
						{
							stuName += "<option value = " + data[i].userId + ">" +
								data[i].name + "</option>";
						}

						$("#stStuName").text("");
						$("#stStuName").append(stuName);

					}
				});
			}

			function pageNumber(count, pageSize)
			{
				var temp = Math.ceil(count / pageSize);
				return temp;
			}
		</script>
</body>

</html>