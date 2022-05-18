<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部门管理</title>
 <link href="../../static/css/table.css" rel="stylesheet" type="text/css">
 <link href="../../static/css/button.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../static/js/delete.js"></script>
</head>
<body>
<section><a href="/user?action=logout">注销</a>&nbsp;&nbsp;您现在的位置：<a href="/pages/manager/manager.jsp">首页</a>>>通知</section>
<table class="altrowstable" id="alternatecolor" style="margin:auto" >
<caption>通知</caption>
	<tr>
		<th>id</th>
		<th>发件者</th>
		<th>收件人</th>
		<th>信息</th>
		<th>发送时间</th>
		<th>已读</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${sessionScope.notices}" var="notice">
		<tr>
			<td>${notice.id}</td>
			<td>${notice.sendName}</td>
			<td>${notice.getName}</td>
			<td>${notice.message}</td>
			<td>${notice.time}</td>
			<td>${notice.saw}</td>
			<td>
				<a href="/notice?action=delete&id=${notice.id}"onclick="javascript:return todel()">删除</a>
				<a href="/notice?action=update&id=${notice.id}">已读</a>
			</td>
		</tr>
	</c:forEach>
</table>
<div class="demo_con">
	<button type="button" class="button blue rarrow" onclick="window.location.href = '/pages/notice/add.jsp'">创建通知</button><br>
	<button type="button" class="button blue larrow" onclick="window.location.href = '/pages/manager/manager.jsp'">返回首页</button><br>
</div>
</body>
</html>