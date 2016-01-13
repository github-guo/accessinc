$(function() {
	$("#allPro").click(
		function() {
			$(".table.table-hover").empty();
			$.ajax({
				type : "post",
				url : "admin/getAllPro",
				dataType : "json",
				success : function(data) {
					$(".table.table-hover")
							.append(
									"<thead><tr><th>项目名称</th><th>项目提交者</th><th>审核结果</th></tr></thead>");
					for (var i = 0; i < data.length; i++) {
						$(".table.table-hover")
								.append(
										"<tr><td>"
												+ data[i].org
												+ "</td><td>"
												+ data[i].proInstroduction
												+ "</td><td>"
												+ (data[i].pass == true ? "通过"
														: "等待")
												+ "</td>"
												+ "</tr>")
					}
				},
				error : function(XMLHttpRequest,
						textStatus, errorThrown) {
					alert(errorThrown);
				}
		});
	});

	$("#waiting").click(function() {
		$(".table.table-hover").empty();
		$.ajax({
			type : "post",
			url : "admin/getWaiting",
			dataType : "json",
			success : function(data) {
				$(".table.table-hover")
						.append(
								"<thead><tr><th>项目名称</th><th>项目提交者</th><th>审核结果</th></tr></thead>");
				for (var i = 0; i < data.length; i++) {
					$(".table.table-hover")
							.append(
									"<tr><td>"
											+ data[i].org
											+ "</td><td>"
											+ data[i].proInstroduction
											+ "</td><td>"
											+ (data[i].pass == true ? "通过"
													: "等待")
											+ "</td>"
											+ "</tr>")
				}
			},
			error:function(XMLHttpRequest,
					textStatus, errorThrown) {
				alert(errorThrown);
			}
	});
	});
	
	
	$("#passed").click(function() {
		$(".table.table-hover").empty();
		$.ajax({
			type : "post",
			url : "admin/getPassed",
			dataType : "json",
			success : function(data) {
				$(".table.table-hover")
						.append(
								"<thead><tr><th>项目名称</th><th>项目提交者</th><th>审核结果</th></tr></thead>");
				for (var i = 0; i < data.length; i++) {
					$(".table.table-hover")
							.append(
									"<tr><td>"
											+ data[i].org
											+ "</td><td>"
											+ data[i].proInstroduction
											+ "</td><td>"
											+ (data[i].pass == true ? "通过"
													: "等待")
											+ "</td>"
											+ "</tr>")
				}
			},
			error:function(XMLHttpRequest,
					textStatus, errorThrown) {
				alert(errorThrown);
			}
	});
	});
});