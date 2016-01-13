$(function() {
	$("#regForm").validate({
		rules : {
			name : "required",
			telPhone : "required",
			wechatOrQQ : "required",
			orgInstroduction : "required",
			proInstroduction : "required"
		},
		messages : {
			name : "请输入姓名",
			telPhone : "请输入电话号码",
			wechatOrQQ : "请填写微信/QQ",
			orgInstroduction : "请填写机构/项目名称",
			proInstroduction : "请填写项目介绍"
		}
	});
	/*
	 * $("#regSubmit").click(function() { $.ajax({ type : "post", url : basePath +
	 * "regist", dataType : "json", data : $("#regForm").serialize(), success :
	 * function(data) { if (data.result == true) { alert('恭喜您报名成功');
	 * window.location = basePath + "result"; } else { alert('报名失败，请重新提交') } },
	 * error : function(XMLHttpRequest, textStatus, errorThrown) {
	 * alert(errorThrown); } }); });
	 */

});// end of starting.
