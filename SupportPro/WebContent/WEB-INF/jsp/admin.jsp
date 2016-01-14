
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${basePath}bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}appcss/admin.css">
<SCRIPT src="${basePath}bootstrap/js/jquery-1.12.0.min.js"></script>
<SCRIPT src="${basePath}bootstrap/js/bootstrap.min.js"></script>
<script src="${basePath }appjs/RegisterInfoModal.js"></script>
<SCRIPT src="${basePath}appjs/admin.js"></script>

<title></title>
</head>
<body>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">项目详细信息</h4>
				</div>
				<div class="modal-body">
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
						<label for="picLoc">该项目是否有相关图片</label>
					</div>
					<label>希望我们给您提供什么样的帮助</label>
					<textarea class="form-control" rows="3" name="remark"></textarea>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary">提交更改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation"><a id="allPro">所有项目</a></li>
			<li role="presentation"><a id="waiting">待审核</a></li>
			<li role="presentation"><a id="passed">已审核通过</a></li>
		</ul>

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

					</table>
				</div>
				<div class="col-xs-2"></div>
			</div>
		</div>
	</div>
</body>
</html>