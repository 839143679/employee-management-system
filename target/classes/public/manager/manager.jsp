<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>员工管理系统</title>
    <link  type="text/css" rel="stylesheet" href="../../static/css/admin.css">
</head>
<body>
<section><a href="/user?action=logout">注销</a>&nbsp;&nbsp;您现在的位置：首页&gt;&gt;<a href="/pages/manager/manager.jsp">员工信息管理</a></section>
<section class="demo">
    <div class="container">
        <h1>你好,${sessionScope.login.name}</h1>
        <input type="hidden" value="${sessionScope.login.name}" name="name">
        <input type="hidden" value="${sessionScope.login.username}" name="username">
    </div>
    <div class="demo_con">
        <button type="button" class="button blue"  onclick="window.location.href = '/employee?action=sign&id=${sessionScope.login.id}'">打卡</button>
        <button type="button" class="button blue" onclick="window.location.href = '/employee?action=queryEmpId&id=${sessionScope.login.id}'">修改个人信息</button>
        <button type="button" class="button blue"  onclick="window.location.href = '/employee?action=queryAllEmp'">查看员工信息</button>
        <br/>
        <br/>
        <button type="button" class="button blue" onclick="window.location.href = '/pages/user/update.jsp'">修改密码</button>
        <button type="button" class="button blue" onclick="window.location.href = '/notice?action=queryAll'">通知</button>
        <button type="button" class="button blue" onclick="window.location.href = '/user?action=logout'">退出</button>
    </div>
</section>
</body>
</html>