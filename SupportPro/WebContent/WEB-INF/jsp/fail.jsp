<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<link rel="stylesheet" type="text/css"
	href="${basePath}bootstrap/css/bootstrap.min.css">
<script type="text/javascript">
	var local = window.location;
	var contextPath = local.pathname.split("/")[1];
	var basePath = local.protocol + "//" + local.host + "/" + contextPath + "/";
</script>
<SCRIPT language=javascript
	src="${basePath}bootstrap/js/jquery-1.12.0.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>报名失败 请重新报名</title>
</head>
<body>

<h2>抱歉，您报名失败 请<a>重试!</a></h2>

<script type="text/javascript">
$("a:first").click(function(){
	window.location.href=basePath;
});
</script>
</body>
</html>