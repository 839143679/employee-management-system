<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/1/12
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改密码</title>

    <link rel="stylesheet" type="text/css" href="/static/css/styles.css">
    <style type="text/css">
        body,td,th { font-family: "Source Sans Pro", sans-serif; }
        body { background-color: #2B2B2B; }
    </style>
</head>
<body>


<div class="wrapper">

    <div class="container">
        <h1>修改密码</h1>
        <form class="form" action="/user?action=update" method="post">
            <input type="text" placeholder="用户名" name="username" value="${cookie.username.value}" id="username_text">
            <input type="password" placeholder="密码" name="password">
            <button type="submit" id="update-button" >修改</button>
            <button type="button" onclick="window.location.href = '/pages/manager/manager.jsp'">返回</button>
        </form>
    </div>

    <ul class="bg-bubbles">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>

</div>

<script type="text/javascript" src="/static/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
    $(function () {
        $("#update-button").click(function () {

            //验证密码,必须由字母,数字下划线组成,并且长度5-12位
            //获取用户名输入框内容
            let passwordText = $("#password").val();
            let passwordRege = /^\w{5,12}$/;
            //使用test验证
            if (!passwordRege.test(passwordText)) {
                //提示用户结果
                $("span.errorMsg").text("密码不合法");
                return false;
            }
        })
    });
    $("#username_text").click(function () {
        $("#username_text").setAttribute("readonly","readonly");

    })
</script>

</body>
</html>
