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
	href="${basePath}appcss/index.css">
<script type="text/javascript">
	var local = window.location;
	var contextPath = local.pathname.split("/")[1];
	var basePath = local.protocol + "//" + local.host + "/" + contextPath + "/";
</script>
<SCRIPT language=javascript
	src="${basePath}bootstrap/js/jquery-1.12.0.min.js"></script>
<SCRIPT language=javascript
	src="${basePath}bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath }appjs/register.js"></script>
<script type="text/javascript"
	src="${basePath }bootstrap/js/jquery.validate.min.js"></script>

<title>大学生公益创新大赛-预报名</title>
</head>
<body>
	<h3 class="text-center">大学生公益创新大赛-预报名</h3>
	<div class="row">
		<div class="col-xs-2"></div>

		<div class="col-xs-8">

			<form action="${basePath }regist" method="post" id="regForm"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="name">姓名：</label> <input type="text"
						class="form-control" name="name" />
				</div>
				<div class="form-group">
					<label for="telPhone">手机：</label> <input type="text"
						class="form-control" name="telPhone" placeholder="telPhone" />
				</div>

				<div class="form-group">
					<label for="email">邮箱：</label> <input type="email"
						class="form-control" id="email" name="email" placeholder="Email">
				</div>
				<div class="form-group">
					<label for="org">机构/项目名称</label> <input type="text"
						class="form-control" name="org" placeholder="org">
				</div>
				<div class="form-group">
					<label for="wechatOrQQ">QQ/微信：</label> <input type="text"
						class="form-control" name="wechatOrQQ" placeholder="wechatOrQQ">
				</div>

				<div class="form-group">
					<label for="orgInstroduction">机构/个人简介</label>
					<textarea class="form-control" rows="3" title="机构/个人简介"
						name="orgInstroduction"></textarea>
				</div>
				<div class="form-group">
					<label for="proInstroduction">项目介绍</label>
					<textarea class="form-control" rows="3" name="proInstroduction"></textarea>
				</div>
				<div class="form-group">
					<label for="picLoc">该项目是否有相关图片</label> <input type="file"
						name="pic">
					<p class="help-block">请上传相关图片</p>
				</div>
				<label>希望我们给您提供什么样的帮助</label>
				<textarea class="form-control" rows="3" name="remark"></textarea>
				<div class="row">
					<div class="col-xs-4"></div>
					<div class="col-xs-4">
						<button class="btn btn-danger" id="regSubmit">提交</button>
					</div>
					<div class="col-xs-4"></div>
				</div>
			</form>
		</div>
		<div class="col-xs-2"></div>
	</div>
</body>
</html>