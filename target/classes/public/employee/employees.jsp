<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工管理</title>
 <link href="../../static/css/table.css" rel="stylesheet" type="text/css">
 <link href="../../static/css/button.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../static/js/delete.js"></script>
</head>
<body>
<section><a href="/user?action=logout">注销</a>&nbsp;&nbsp;您现在的位置：<a href="/pages/manager/manager.jsp">首页</a>&gt;&gt;人员管理</section>
<table class="altrowstable" id="alternatecolor" style="margin:auto" >
<caption>员工信息记录表</caption>
	<form action="/employee?action=queryAllEmp">
	<tr>
		<th>员工编号</th>
		<th>员工姓名</th>
		<th>员工年龄</th>
		<th>员工性别</th>
		<th>员工电话</th>
		<th>员工部门</th>
		<th>员工工资</th>
		<th>入职时间</th>
		<th>签到</th>
		<th>签到时间</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${sessionScope.employees}" var="emp">
		<tr>
			<td>${emp.id}</td>
			<td>${emp.name}</td>
			<td>${emp.age}</td>
			<td>${emp.sex}</td>
			<td>${emp.phone}</td>
			<td>${emp.dept}</td>
			<td>${emp.salary}</td>
			<td>${emp.joinDate}</td>
			<td>${emp.signIn}</td>
			<td>${emp.signTime}</td>
			<td>
				<a href="/employee?action=delete&id=${emp.id}"onclick="javascript:return todel()">删除</a>
				<a href="/employee?action=queryEmpId&id=${emp.id}">修改</a>
			</td>
		</tr>
	</c:forEach>
	</form>
</table>
<div class="demo_con">
<button type="button" class="button blue rarrow" onclick="window.location.href = '/pages/employee/add.jsp'">添加员工</button><br>
<button type="button" class="button blue rarrow" onclick="window.location.href = '/employee?action=resetSign'">重置签到信息</button><br>
<button type="button" class="button blue larrow" onclick="window.location.href = '/pages/manager/manager.jsp'">返回首页</button><br>
</div>
</body>
</html>