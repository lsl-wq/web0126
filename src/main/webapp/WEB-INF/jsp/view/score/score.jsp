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

		<h1 class="page-title">成绩管理</h1>
	</div>

	<ul class="breadcrumb">
		<li><a href="index" target="_top">主页</a> <span
			class="divider">/</span></li>
		<li class="active">成绩管理</li>
	</ul>

	<div class="container-fluid">
		<div class="row-fluid">
			<div style="margin: 10px 0;">
				<span>学生：</span> <select name="stStuName" id="stStuName"
					style="margin: 0 5px;width: 150px;">

				</select> <span>课程：</span> <select name="stCName" id="stCName"
					style="margin: 0 5px;width: 150px;">

				</select> <span>成绩：</span>
				<input type="text" id="txtScore" name="txtScore"
					style="margin: 0 5px;width: 150px;" />
				<button id="btnSubmit" class="btn btn-primary">保&nbsp;存</button>
				<span style="font-size: 15px;margin-left: 5px;color: red;" id="spanPrompt"></span>
				<!-- <div class="btn-group"></div> -->
			</div>
			<div class="well">
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>姓名</th>
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
		var reg = /^((\d|[1-9]\d)(\.\d+)?|100)$/;

		$(function()
		{
			getStudent();

			$("#stStuName").click(function()
			{
				$("#stCName").text("");
				getCourse();
			});

			$("#btnSubmit").click(function()
			{
				if ($("#stStuName").val() < 1)
				{
					$("#spanPrompt").text("请选择学生姓名");
				}else 
				{
					if ($("#stCName").val() < 1)
					{
						$("#spanPrompt").text("请选择课程姓名");
					} else 
					{
						if ($("#txtScore").val() == "")
						{
							$("#spanPrompt").text("请填写成绩");
						} else 
						{
							if (!reg.test($("#txtScore").val()))
							{
								$("#spanPrompt").text("请输入正确的成绩(0-100保留两位小数)");
							}else 
							{
								$("#spanPrompt").text("");
								updateScore();
								$("#stStuName").text("");
								getStudent();
								$("#stCName").text("");
								$("#txtScore").val("");
							}
						}
					}
				}
			});
			
			selectScore();

		});

		function selectScore()
		{
			$.ajax({
				url : "selectScore",
				type : "post",
				data : {
					"pageIndex" : pageIndex
				},
				dataType : "json",
				success : function(datas)
				{
					var score = "";

					for (var i = 0; i < datas.data.length; i++)
					{
						score += "<tr><td>"
						score += (i + 1 + (datas.pageIndex - 1) * datas.pageSize) + "</td><td>";
						score += datas.data[i].name + "</td><td>";
						score += datas.data[i].cNo + "</td><td>";
						score += datas.data[i].cName + "</td><td>";
						score += datas.data[i].score + "</td><td>";
						score += datas.data[i].createDate + "</td>";
					}
					
					$("tbody").text("");
					$("tbody").append(score);
					
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

						selectScore();
					});

					//给上一页按钮添加点击事件
					$("#prev").click(function()
					{
						if (pageIndex > 1)
						{
							pageIndex -= 1;
						}

						selectScore();
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
		}

		function updateScore()
		{
			$.ajax({
				url : "updateScore",
				type : "post",
				data : {
					"stuId" : $("#stStuName").val(),
					"cId" : $("#stCName").val(),
					"score" : $("#txtScore").val()
				},
				dataType : "json",
				success : function(data)
				{
					if(data == "Y")
					{
						selectScore();
					}else
					{
						alert("修改失败");
					}
				}
			});
		}
		
		function getStudent()
		{
			$.ajax({
				url : "getStu",
				type : "post",
				dataType : "json",
				success : function(data)
				{
					var stuName = "<option value = '0'>--请选择--</option>";

					for (var i = 0; i < data.length; i++)
					{
						stuName += "<option value = "+data[i].userId+">"
								+ data[i].name + "</option>";
					}

					$("#stStuName").text("");
					$("#stStuName").append(stuName);

				}
			});
		}

		function getCourse()
		{
			$.ajax({
				url : "getCou",
				type : "post",
				data : {
					"stuId" : $("#stStuName").val()
				},
				dataType : "json",
				success : function(data)
				{
					var cName = "<option value = '0'>--请选择--</option>";

					for (var i = 0; i < data.length; i++)
					{
						cName += "<option value = "+data[i].cId+">"
								+ data[i].cName + "</option>";
					}

					$("#stCName").text("");
					$("#stCName").append(cName);
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