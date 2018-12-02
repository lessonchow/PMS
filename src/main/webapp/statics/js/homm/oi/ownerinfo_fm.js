$(function() {
	var infoVo = $("#InfoVo").val();
	if (infoVo == "操作成功") {
		alert(infoVo);
//		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
//		parent.layer.close(index); //再执行关闭  
	} else {
		$("#alert").html("&nbsp;&nbsp;" + infoVo);
	}
});

function deleteFmByFmId(fmId, obj) {
	if (!confirm('确定要删除吗？')) {
		return false; //按取消就return false 不删除了
	}
	$.ajax({
		type : "GET",
		url : rootPath + "/homm/ownerinfo/deletefm?&fmId=" + fmId,
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