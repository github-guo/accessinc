<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${basePath}bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}appcss/admin.css">
<SCRIPT language=javascript
	src="${basePath}bootstrap/js/jquery-1.12.0.min.js"></script>
<SCRIPT language=javascript
	src="${basePath}bootstrap/js/bootstrap.min.js"></script>
<SCRIPT language=javascript src="${basePath}appjs/admin.js"></script>
<title></title>
</head>
<body>



	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation"><a id="allPro">所有项目</a></li>
			<li role="presentation"><a href="#">待审核</a></li>
			<li role="presentation"><a href="#">已审核通过</a></li>
		</ul>
	</div>
	<h3></h3>
	<div class=".container-fluid">
		<div class="row">
			<div class="col-xs-2"></div>
			<div class="col-xs-8" id="proInfo">
				<table class="table table-hover" title="项目审批" id="allPro_table">
					<thead>
						<tr>
							<th>项目名称</th>
							<th>项目提交者</th>
						</tr>
					</thead>
					<tr>
						<td>testing pro name</td>
						<td>testing pro owner</td>
					</tr>
				</table>
			</div>
			<div class="col-xs-2"></div>
		</div>
	</div>
</body>
</html>