$(function() {
	var infoVo = $("#InfoVo").val();
	if (infoVo == "操作成功！") {
		alert(infoVo);
//		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
//		parent.layer.close(index); //再执行关闭  
	} else {
		$("#alert").html("&nbsp;&nbsp;" + infoVo);
	}
});

//绑定change时间，一层一层地读取房产信息
$(function() {
	//第一层房产的change事件
	$("#consId").change(function() {
		if ($(this).val() == "") {
			$("#bldId").empty();
			$("#unitId").empty();
			$("#roomId").empty();
		} else {
			$.ajax({
				type : "GET",
				url : rootPath + "/homm/ownerinfo/getallbuildingname?&consId=" + $(this).val(),
				dataType:"json",
				success:function(data){
					if (data.result == "failed") {
						alert("获取房产资料失败，请重新选择");
					} else {
						var $bldNode = $("#bldId").empty();
						$bldNode.append("<option value=\"\"></option>");
						for (var i = 0; i < data.length; i++) {
							$bldNode.append("<option value='" + data[i].bldId + "'>" + data[i].bldName + "</option>");
						}
					}
				},
				error:function(data){//当访问时候，404，500 等非200的错误状态码
					alert("系统错误，请与管理员联系！");
				}//请求数据失败后的回调函数结束
			});
		}
	});
	
	//第二层楼宇的change事件
	$("#bldId").change(function() {
		if ($(this).val() == "") {
			$("#unitId").empty();
			$("#roomId").empty();
		} else {
			$.ajax({
				type : "GET",
				url : rootPath + "/homm/ownerinfo/getallbuildingname?&bldId=" + $(this).val(),
				dataType:"json",
				success:function(data){
					if (data.result == "failed") {
						alert("获取房产资料失败，请重新选择");
					} else {
						var $unitNode = $("#unitId").empty();
						$unitNode.append("<option value=\"\"></option>");
						for (var i = 0; i < data.length; i++) {
							$unitNode.append("<option value='" + data[i].unitId + "'>" + data[i].unitName + "</option>");
						}
					}
				},
				error:function(data){//当访问时候，404，500 等非200的错误状态码
					alert("系统错误，请与管理员联系！");
				}//请求数据失败后的回调函数结束
			});
		}
	});
	
	//第三层单元的change事件
	$("#unitId").change(function() {
		if ($(this).val() == "") {
			$("#roomId").empty();
		} else {
			$.ajax({
				type : "GET",
				url : rootPath + "/homm/ownerinfo/getallbuildingname?&unitId=" + $(this).val(),
				dataType:"json",
				success:function(data){
					if (data.result == "failed") {
						alert("获取房产资料失败，请重新选择");
					} else {
						var $roomNode = $("#roomId").empty();
						$roomNode.append("<option value=\"\"></option>");
						for (var i = 0; i < data.length; i++) {
							$roomNode.append("<option value='" + data[i].roomId + "'>" + data[i].roomName + "</option>");
						}
					}
				},
				error:function(data){//当访问时候，404，500 等非200的错误状态码
					alert("系统错误，请与管理员联系！");
				}//请求数据失败后的回调函数结束
			});
		}
	});
});

function deleteEstByEstId(estId,roomId, obj) {
	if (!confirm('确定要删除吗？')) {
		return false; //按取消就return false 不删除了
	}
	$.ajax({
		type : "GET",
		url : rootPath + "/homm/ownerinfo/deleteest?estId=" + estId + "&roomId=" + roomId,
		dataType:"json",
		success:function(data){
			if (data.result == "success") {
				alert("删除成功！");
				$(obj).parent().remove();
//				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
//				parent.layer.close(index); //再执行关闭  
			} else {
				alert("删除过程出现异常错误，请重试");
			}
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			alert("获取数据错误，可能已经删除成功，请检查！");
		}//请求数据失败后的回调函数结束
	}); 
}