<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.cqkj.service.DeptInfoService"%>
<%@page import="com.cqkj.bean.DeptInfo"%>
<%@page import="com.cqkj.bean.PageList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%!int pageCount = 1;%>
<%
    request.setCharacterEncoding("utf-8");

			PageList<DeptInfo> pageList = new PageList<DeptInfo>();

			if (request.getParameter("pageIndex") != null) {
				pageCount = Integer.parseInt(request.getParameter("pageIndex"));
			}

			pageList.setPageIndex(pageCount);

			// 从Spring容器中获取Bean对象 
			ServletContext sc = this.getServletContext();
			ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);

			// 取出所需要的service层中的Bean
			DeptInfoService deptInfoService = (DeptInfoService) ac.getBean("deptInfoServiceImpl");

			deptInfoService.selectPage(pageList);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门信息</title>
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

</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
	<!--<![endif]-->

	<div class="header">

		<h1 class="page-title">用户类型信息</h1>
	</div>

	<ul class="breadcrumb">
		<li><a href="index" target="_top">主页</a> <span class="divider">/</span></li>
		<li class="active">用户类型管理</li>
	</ul>

	<div class="container-fluid">
		<div class="row-fluid">

			<div class="btn-toolbar">
				<button id="btnAddDept" class="btn btn-primary">
					<i class="icon-plus"></i> 新增用户类型
				</button>
				<div class="btn-group"></div>
			</div>
			<div class="well">
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>用户类型编号</th>
							<th>用户类型名称</th>
							<th style="width: 100px;">操作</th>
						</tr>
					</thead>
					<tbody>
						<%
						    pageContext.setAttribute("depts", pageList, pageContext.PAGE_SCOPE);
						%>
						<c:forEach var="dept" items="${depts.data}" varStatus="i">
							<tr>
								<td>${i.index + 1 + depts.getFirstSeq()}</td>
								<td>${dept.deptCode}</td>
								<td>${dept.deptName}</td>
								<td class="edit"><a
									href="addDept?flag=1&deptId=${dept.deptId}"><i
										class="icon-pencil">编辑</i></a>&nbsp; <a href="#myModal"
									role="button" delId="${dept.deptId}" data-toggle="modal"><i
										class="icon-remove" style="color: red;">删除</i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="pagination">
				<ul>
					<li><a href="deptInfo?pageIndex=1">首页</a></li>
					<li><a
						href="deptInfo?pageIndex=<%=pageCount == 1 ? 1 : (pageCount - 1)%>">上一页</a></li>
					<%
					    for (int i = 0; i < pageList.getPageCount(); i++) {
					%>
					<li><a href="deptInfo?pageIndex=<%=i + 1%>"><%=i + 1%></a></li>

					<%
					    }
					%>
					<li><a
						href="deptInfo?pageIndex=<%=pageCount == pageList.getPageCount() ? pageList.getPageCount() : (pageCount + 1)%>">下一页</a></li>
					<li><a href="deptInfo?pageIndex=<%=pageList.getPageCount()%>">尾页</a></li>
				</ul>
			</div>

			<div class="modal small hide fade" id="myModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">删除确认</h3>
				</div>
				<div class="modal-body">
					<p class="error-text">
						<i class="icon-warning-sign modal-icon"></i>您确定要删除该用户类型吗？
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
		$("[rel=tooltip]").tooltip();
		$(function()
		{
			$('.demo-cancel-click').click(function()
			{
				return false;
			});

			// 控制菜单跳转
			$("#btnAddDept").click(function()
			{
				window.location.href = "addDept?flag=0"
			});

			//给所有的删除按钮添加一个点击事件，记录当前要删除的行数据
			$(".well tbody tr td:last-child a:last-child").click(function()
			{
				$("#hiDeleteId").val($(this).attr("delId"));
			});

			//给删除框的按钮绑定一个点击事件
			$("#btnDelete").click(
					function()
					{
						window.location.href = "deleteDeptInfo?deptId="
								+ $("#hiDeleteId").val();
					});

		});
	</script>

</body>
</html>