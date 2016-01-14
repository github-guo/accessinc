var Reg = (function() {
	var getInfo = function(id, pro) {
		for (var i = 0; i < pro.length; i++) {
			if (pro[i].id == id) {
				console.log(id + ',' + pro[i].name);
				$("[name=name]").val(pro[i].name);
				$("[name=telPhone]").val(pro[i].telPhone);
				$("[name=email]").val(pro[i].email);
				$("[name=org]").val(pro[i].org);
				$("[name=wechatOrQQ]").val(pro[i].wechatOrQQ);
				$("[name=orgInstroduction]").val(pro[i].orgInstroduction);
				$("[name=proInstroduction]").val(pro[i].proInstroduction);
				$("[name=remark]").val(pro[i].remark);
			}
		}
	};
	return {
		get : getInfo
	}
})();
