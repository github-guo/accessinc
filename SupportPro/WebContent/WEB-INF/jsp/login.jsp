<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${basePath}bootstrap/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	var local = window.location;
	var contextPath = local.pathname.split("/")[1];
	var basePath = local.protocol + "//" + local.host + "/" + contextPath + "/";
</script>
<SCRIPT language=javascript
	src="${basePath}bootstrap/js/jquery-1.12.0.min.js"></script>
<SCRIPT language=javascript
	src="${basePath}bootstrap/js/bootstrap.min.js"></script>
<title>管理员登录页面</title>
</head>
<body>
	<div class="container">

		<form class="form-signin" action="login" method="post" id="loginForm">
			<h2 class="form-signin-heading">Please sign in</h2>
			<h4></h4>
			<label for="name" class="sr-only">Email address</label> <input
				type="email" id="name" class="form-control" name="name"
				placeholder="Email address" required autofocus> <label
				for="password" class="sr-only">Password</label> <input
				type="password" id="password" name="password" class="form-control"
				placeholder="Password" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me(in processing.please don't use)
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="button" id="submitBtn">Sign
				in</button>
		</form>

	</div>
	<!-- /container -->
	<script type="text/javascript">
	$(function(){
		$("#submitBtn").click(function(){
			$.ajax({
	            type: "POST",
	            url: "loginAs",
	            data : $("#loginForm").serialize(),
	            success: function (data) {
	            	if(data.tips=='fail'){
	            		$("h4").text('账号或者密码错误');
	            	}else{
	            		window.location.href=basePath+"/admin";
	            	}
	            },
	            error: function (XMLHttpRequest,
	                             textStatus, errorThrown) {
	                alert(errorThrown);
	            }
	        });
		});
	});
	</script>
</body>
</html>