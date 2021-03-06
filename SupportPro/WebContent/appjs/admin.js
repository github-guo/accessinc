$(function() {
    var allPro;
    var waitingPro;
    var passedPro;
    
    $("#allPro").click(function() {
        $(".table.table-hover").empty();
        $.ajax({
            type: "post",
            url: "admin/getAllPro",
            dataType: "json",
            success: function(data) {
                allPro = data;
                /* console.log(allPro[0].id); */

                $(".table.table-hover").append("<thead><tr><th>编号</th><th>项目名称</th><th>项目提交者</th><th>审核结果</th></tr></thead>");
                for (var i = 0; i < data.length; i++) {
                    $(".table.table-hover").append("<tr><td id="+data[i].id+">" + data[i].id + "</td><td>" + data[i].org + "</td><td>" + data[i].proInstroduction + "</td><td>" + (data[i].pass == true ? "通过": "等待") + "</td>" + "</tr>");
                    $("tr:last").click(function() {
                        Reg.get($(this).find("td:first").text(), allPro);
                        $("#myModal").modal("toggle");
                    });
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            }
        });
    });

    $("#waiting").click(function() {
        $(".table.table-hover").empty();
        $.ajax({
            type: "post",
            url: "admin/getWaiting",
            dataType: "json",
            success: function(data) {
                waitingPro = data;
                $(".table.table-hover").append("<thead><tr><th>编号</th><th>项目名称</th><th>项目提交者</th><th>审核结果</th></tr></thead>");
                for (var i = 0; i < data.length; i++) {
                    $(".table.table-hover").append("<tr><td id="+data[i].id+">" + data[i].id + "</td><td>" + data[i].org + "</td><td>" + data[i].proInstroduction + "</td><td>" + (data[i].pass == true ? "通过": "等待") + "</td>" + "</tr>");
                    $("tr:last").click(function() {
                    	Reg.get($(this).find("td:first").text(), allPro);
                        $("#myModal").modal("toggle");
                    });
                }

            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            }
        });
    });

    $("#passed").click(function() {
        $(".table.table-hover").empty();
        $.ajax({
            type: "post",
            url: "admin/getPassed",
            dataType: "json",
            success: function(data) {
                passedPro = data;
                $(".table.table-hover").append("<thead><tr><th>编号</th><th>项目名称</th><th>项目提交者</th><th>审核结果</th></tr></thead>");
                for (var i = 0; i < data.length; i++) {
                    $(".table.table-hover").append("<tr><td id="+data[i].id +">" + data[i].id + "</td><td>" + data[i].org + "</td><td>" + data[i].proInstroduction + "</td><td>" + (data[i].pass == true ? "通过": "等待") + "</td>" + "</tr>");
                    $("tr:last").click(function() {
                    	Reg.get($(this).find("td:first").text(), allPro);
                        $("#myModal").modal("toggle");
                    });
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            }
        });
    });

    $("#subChange").click(function() {
    	var id=$("#id").val();
    	$.ajax({
            type: "post",
            url: "updateRegInfo",
            data:{
            	id:id,
            	pass:$("#passSelect").val()
            },
            success: function(data) {
                if(data.result=='success'){
                	if(data.selected=='passed'){
                		$("[id="+id+"]").parent().find("td:last").text("通过");
                	}else{
                		$("[id="+id+"]").parent().find("td:last").text("否决");
                	}
                	
                	console.log('updated');
                }else{
                	alert('更新失败 ，请重试！');
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            }
        });
    });
});