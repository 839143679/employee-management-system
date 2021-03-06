<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>注册</title>

<link rel="stylesheet" type="text/css" href="/static/css/styles.css">
<style type="text/css">
body,td,th { font-family: "Source Sans Pro", sans-serif; }
body { background-color: #2B2B2B; }
</style>
</head>
<body>


<div class="wrapper">

	<div class="container">
		<h1>Welcome</h1>
		<form class="form" action="/user?action=register" method="post">
			<input type="text" placeholder="用户名" name="username">
			<input type="password" placeholder="密码" name="password">
			<input type="password" placeholder="确认密码" name="repwd">
			<button type="submit" id="register-button">注册</button>
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

<script type="text/javascript" src="/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("#register-button").click(function () {
			//验证用户名,必须由字母,数字下划线组成,并且长度5-12位
			//获取用户名输入框内容
			let usernameText = $("#username").val();
			//创建正则表达式
			let usernameRege = /^\w{5,12}$/;
			//使用test方法验证
			if (!usernameRege.test(usernameText)){
				//提示用户结果
				$("span.errorMsg").text("用户名不合法");
				return false;
			}

			//验证密码,必须由字母,数字下划线组成,并且长度5-12位
			//获取用户名输入框内容
			let passwordText = $("#password").val();
			let passwordRege = /^\w{5,12}$/;
			//使用test验证
			if (!passwordRege.test(passwordText)){
				//提示用户结果
				$("span.errorMsg").text("密码不合法");
				return false;
			}

			//验证确认密码:和密码相同
			let repwdText = $("#repwd").val();
			//和新密码进行比较
			if (repwdText !== passwordText){
				$("span.errorMsg").text("密码输入不一致!");
				return false;
			}
	})
</script>

</body>
</html>