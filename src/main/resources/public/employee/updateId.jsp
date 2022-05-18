<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改信息</title>
<link href="../../static/css/button.css" rel="stylesheet" type="text/css">
<link href="../../static/css/form.css" rel="stylesheet" type="text/css">
</head>
<body>
<section><a href="/user?action=logout">注销</a>&nbsp;&nbsp;您现在的位置：<a href="/pages/manager/manager.jsp">首页</a>&gt;&gt;修改个人信息</section>
<div id="form" style=" height: 500px; margin-top: 70px;">
<form action="/employee?action=update" method="post">
<%--	<c:forEach items="${sessionScope.queryEmpId}" var="employee">--%>
	<p><label>员工编号</label><input type="text" name="id" value="${sessionScope.queryEmpId.id}" /></p>
	<p><label>姓名</label><input type="text" name="name"value="${sessionScope.queryEmpId.name}"/></p>
	<p><label>年龄</label><input type="text" name="age"value="${sessionScope.queryEmpId.age}"/></p>
	<p><label>性别</label><input type="text" name="sex"value="${sessionScope.queryEmpId.sex}"/></p>
	<p><label>电话</label><input type="text" name="phone"value="${sessionScope.queryEmpId.phone}"/></p>
	<p><label>部门</label><input type="text" name="dept"value="${sessionScope.queryEmpId.dept}"/></p>
	<p><label>工资</label><input type="text" name="salary"value="${sessionScope.queryEmpId.salary}"/></p>
	<p><label>入职时间</label><input type="text" name="joinDate"value="${sessionScope.queryEmpId.joinDate}"/></p>
	<input type="hidden" name="method" value="update"/>
<p class="submit"><input type="submit"class="bluebuttoncss" value="修改" /></p>
<%--	</c:forEach>--%>
</form>
</div>
<div class="demo_con">
<button type="button" class="button blue larrow" onclick="window.location.href = '/pages/manager/manager.jsp'">返回首页</button>
</div>
</body>
</html>