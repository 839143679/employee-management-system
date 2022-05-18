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
<section><a href="/user?action=logout">注销</a>&nbsp;&nbsp;您现在的位置：<a href="/pages/manager/manager.jsp">首页</a>&gt;&gt;<a href="/pages/employee/employees.jsp">人员管理</a>&gt;&gt;添加员工</section>
<div id="form" style=" height: 500px; margin-top: 70px;" class="form">
<form action="/employee?action=add" method="post">
	<p><label>员工编号&nbsp;&nbsp;</label><input type="text" name="id" required/></p>
	<p><label>姓名</label><input type="text" name="name" required/></p>
	<p><label>年龄</label><input type="text" name="age" required/></p>
	<p><label>性别</label><input type="text" name="sex" required/></p>
	<p><label>手机号</label><input type="text" name="phone" required/></p>
	<p><label>所在部门</label><input type="text" name="dept" required/></p>
	<p><label>工资</label><input type="text" name="salary" /> </p>
	<p><label>用户名</label><input type="text" name="username"/></p>
	<p><label>密码</label><input type="text" name="password"/></p>
	<input type="hidden" name="method" value="add"/>
	<p class="submit"><input type="submit"class="bluebuttoncss" value="提交"/></p>
</form>
</div>
<div class="demo_con">
<button type="button" class="button blue larrow" onclick="window.location.href = '/pages/manager/manager.jsp'">返回首页</button>
</div>
</body>
</html>