
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
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
				</div>
				<div class="modal-body">在这里添加一些文本</div>
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