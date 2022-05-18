<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加员工</title>
<link href="../../static/css/form.css" rel="stylesheet" type="text/css">
<link href="../../static/css/button.css" rel="stylesheet" type="text/css">
</head>
<body>
<section><a href="/user?action=logout">注销</a>&nbsp;&nbsp;您现在的位置：<a href="/pages/manager/manager.jsp">首页</a>&gt;&gt;<a href="/pages/notice/notice.jsp">通知</a>&gt;&gt;添加通知</section>
<div id="form" style=" height: 500px; margin-top: 70px;" class="form">
<form action="/notice?action=add" method="post">
	<p><label>发件人</label><input type="text" name="sendname"  value="${sessionScope.login.name}" required/></p>
	<p><label>收件人</label><input type="text" name="getname" required/></p>
	<p><label>信息</label><input type="text" name="message" required/></p>
	<input type="hidden" name="method" value="add"/>
	<p class="submit"><input type="submit"class="bluebuttoncss" value="提交"/></p>
</form>
</div>
<div class="demo_con">
	<button type="button" class="button blue larrow" onclick="window.location.href = '/notice?action=queryAll'">返回通知</button>
	<button type="button" class="button blue larrow" onclick="window.location.href = '/pages/manager/manager.jsp'">返回首页</button>
</div>
</body>
</html>