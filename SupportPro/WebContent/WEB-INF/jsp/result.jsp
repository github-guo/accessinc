<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>恭喜您报名成功</title>
<link rel="stylesheet" type="text/css"
	href="${basePath}bootstrap/css/bootstrap.min.css">
<SCRIPT language=javascript
	src="${basePath}bootstrap/js/jquery-1.12.0.min.js"></script>
<SCRIPT language=javascript
	src="${basePath}bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class=".container-fluid">
<div class="row">
<%-- <div>
<img src="${basePath }image/regSuc.jpg" class="img-responsive" alt="Responsive image">
</div> --%>
</div>
<h1>well done .恭喜您报名成功，请等待下一步通知,留意邮件通知</h1>
</div>
</body>
</html>