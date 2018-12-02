$(function() {
	
	getOwnerInfoList(1); //主动载入全部业主信息，入参1代表页码
	
  	//当快速检索条件改变时，id为ownerCode的input的name属性值也相应改变
  	$("#selectItem").change(function() {
  		var selectVal = $(this).val();
  		if (selectVal == "1") {
			$("#ownerCode").attr("name","ownerCode")
		} else if (selectVal == "2") {
			$("#ownerCode").attr("name","ownerName")
		} else if (selectVal == "3") {
			$("#ownerCode").attr("name","ownerCertNo")
		} else if (selectVal == "4") {
			$("#ownerCode").attr("name","ownerWork")
		} else if (selectVal == "5") {
			$("#ownerCode").attr("name","ownerMobile")
		} else if (selectVal == "6") {
			$("#ownerCode").attr("name","ownerAdd")
		} else if (selectVal == "7") {
			$("#ownerCode").attr("name","ownerBankaccount")
		} else if (selectVal == "8") {
			$("#ownerCode").attr("name","ownerUrgentcontact")
		} else if (selectVal == "9") {
			$("#ownerCode").attr("name","ownerRemark")
		}
  	});
  	
  	//绑定查询按钮的点击事件，获取全部业主信息或者根据条件获取业主信息
  	$("#QueryBtn").click(queryBtnClick = function(){ //queryBtnClick是全局函数
//  		alert("测试");
  		getOwnerInfoList(Number.parseInt($("#currpage").val()));
  	}); 
  	
  	//这是业主个人信息的弹框代码
	$('#AddBtn').on('click', function(){
		layer.open({
			type: 2,
			area: ['600px','90%'],
			shadeClose: true, //点击遮罩关闭
			skin: 'layui-layer-rim',
			/*content: $("#ownerinfo_oi"),*/
			content: rootPath + '/homm/ownerinfo/getownerinfobyownercode',
			title :'业主信息',
			end : function() {
				$("#QueryBtn").click(); //弹框关闭后，即新增业主信息成功后，点击查询按钮
			}
		});
	});
	
	//这是绑定停用按钮的单击事件的代码
	$("#StopBtn").click(function() {
		if (confirm("确认要执行停用吗？")) {
			var $allCheckBox = $("[name=ownerId]:checked");
			if ($allCheckBox.length == 0) {
				alert("请选择要修改的业主！");
				return;
			}
			$allCheckBox.each(function() {
				var $currNode = $(this);
				var queryString = $currNode.serialize();
				$.ajax({
					type : "GET",
					url : rootPath + "/homm/ownerinfo/updateownerstatus",
					data : queryString + "&ownerStatus=2",
					dataType:"json",
					success:function(data){
						if (data.result == "success") {
							$currNode.removeAttr("checked").parents("#oiLine").css("color","red").children(".dynStatus").html("停用");
						} else {
							alert("更新过程出现异常错误，请重试");
						}
					},
					error:function(data){//当访问时候，404，500 等非200的错误状态码
						return false;//如果其中一个失败，return false可以提早停止循环
					}//请求数据失败后的回调函数结束
				}); 
			});
//			$("#QueryBtn").click();
		}
	});
	//这是绑定恢复按钮的单击事件的代码
	$("#PassBtn").click(function() {
		if (confirm("确认要执行恢复吗？")) {
			var $allCheckBox = $("[name=ownerId]:checked");
			if ($allCheckBox.length == 0) {
				alert("请选择要修改的业主！");
				return;
			}
			$allCheckBox.each(function() {
				var $currNode = $(this);
				var queryString = $currNode.serialize();
				$.ajax({
					type : "GET",
					url : rootPath + "/homm/ownerinfo/updateownerstatus",
					data : queryString + "&ownerStatus=1",
					dataType:"json",
					success:function(data){
						if (data.result == "success") {
							$currNode.removeAttr("checked").parents("#oiLine").removeAttr("style").children(".dynStatus").html("正常");
						} else {
							alert("更新过程出现异常错误，请重试");
						}
					},
					error:function(data){//当访问时候，404，500 等非200的错误状态码
						return false; //如果其中一个失败，return false可以提早停止循环
					}//请求数据失败后的回调函数结束
				});
			});
//			$("#QueryBtn").click();
		}
	});
});

function getOwnerInfoList(currpage) { //如果要写成全局函数变量那样，就要放到JQ的美元符号范围里的最开始，不然说函数未定义，不能一开始就调用。很奇怪，可能JQ还是有些不同
//	if (currpage == null) {
//		currpage = 1;
//	}
	$("#currpage").val(currpage);//储存当前页码，用在刷新页面功能
	var $allQueryConditions = $("#QueryBtn").parent().prev().children("[name]");
	var paramArray = $allQueryConditions.serializeArray();
	if (paramArray[0].value != "" && isNaN(paramArray[0].value)) {
		alert("请输入数字！");
	} else {
		var queryString = $.param(paramArray);
		$.ajax({
			type : "POST",//请求类型
			url : rootPath + "/homm/ownerinfo/getownerinfolist",
			data : queryString + "&currpage=" + currpage,
			dataType:"json",
			success:function(data){
				var $gridNode = $("#GridView1").empty();
				if (data.list.length == 0) {
					$gridNode.append("<tr height='70'><td colspan='6' style=\"font-family:'Microsoft YaHei'; border-bottom:0;\">" +
					"没有查到符合条件的数据！</td></tr>");
				} else {
					$gridNode.append(//拼接表格的头部
						"<tr class=\"hkHeadStyle\">" +
							"<th scope=\"col\" style=\"width:30px;\">序号</th>" +
							"<th scope=\"col\" style=\"width:30px;\">" +
								"<input id=\"chkall\" type=\"checkbox\" title=\"全选或全不选\" style=\"width: 16;height: 16\" />" +
							"</th>" +
							"<th scope=\"col\">所属公司</th>" +
							"<th scope=\"col\">业主编码</th>" +
							"<th scope=\"col\" style=\"width:70px;\">姓名</th>" +
							"<th scope=\"col\" style=\"width:30px;\">性别</th>" +
							"<th scope=\"col\" style=\"width:80px;\">出生日期</th>" +
							"<th scope=\"col\">证件号码</th>" +
							"<th scope=\"col\">手机号码</th>" +
							"<th scope=\"col\" style=\"width:40px;\">状态</th>" +
							"<th scope=\"col\" style=\"width:170px;\">操作</th>" +
						"</tr>"		
					);//一个append拼接的结束
					for (var i = 0; i < data.list.length; i++) {//用for循环拼接业主信息
						$gridNode.append(
								"<tr id='oiLine'" + (data.list[i].ownerStatus == 1? "":" style='color:red;'") + ">" +
								"<td align=\"center\">" + 
								"<span>" + (i + 1) + "</span>" +
								"</td>" +
								"<td align=\"center\" style=\"height:18px;width:30px;\">" +
								"<span class=\"mybox\"><input id=\"ownerId\" type=\"checkbox\" name=\"ownerId\" value=" + data.list[i].ownerId + " /></span>" + 
								"</td>" + 
								"<td>" + data.list[i].ldcName + "</td>" + 
								"<td align=\"center\" onclick=\"getOwnerInfobyOwnerCode('" + data.list[i].ownerCode + "');\">" + 
								"<a href=\"javascript:void(0)\" class=\"gvlink\">" + 
								"<span id=\"GridView1_ctl02_Labelyjje\">" + data.list[i].ownerCode + "</span></a>" + 
								"</td>" + 
								"<td>" + data.list[i].ownerName + "</td>" + 
								"<td align=\"center\">" + (data.list[i].ownerGender == 1? "男":"女") + "</td>" + 
								"<td align=\"center\">" + data.list[i].ownerBirthday + "</td>" + 
								"<td>" + data.list[i].ownerCertNo + "</td>" + 
								"<td>" + data.list[i].ownerMobile + "</td>" + 
								"<td class='dynStatus' align=\"center\">" + (data.list[i].ownerStatus == 1? "正常":"停用") + "</td>" + 
								"<td align=\"center\">" + 
								"<a href=\"javascript:getFmbyOwnerId(" + (data.list[i].ownerId) + ")\" class=\"fmLink\">家庭成员(" + data.list[i].fmCount + ")</a>&nbsp;" + 
								"<a href=\"javascript:getEstbyOwnerId(" + (data.list[i].ownerId) + ")\" class=\"gvlink\" id=\"estLink\">房产登记(" + data.list[i].estCount + ")</a>" + 
								"</td>" +
								"</tr>"
						);//一个append拼接的结束
					} //for循环拼接业主信息的结束
					//在拼接页面导航前去掉原来的导航信息
					var $pageNav = $("#pageNav");
					$pageNav.remove();
					//拼接页面导航
					if (Number.parseInt(data.totalrecord) > 5) { //如果总记录数没有大于5条，就不显示页面导航信息
						var $pageNode = $("#wrapTable");
						var navStr = "<tr id='pageNav'>" + 
										"<td colspan=\"2\" style=\"height: 22px\">" + 
										"<div id=\"AspNetPager1\" ShowInputBox=\"Auto\" InputBoxClass=\"pagetext\">" + 
										"<div style=\"width:250px;float:left;\">" + 
										"<font color='#333333'>共"  + data.totalrecord +  "行/每页5行 第" + data.currpage + "/" + data.totalpage + "页</font>" + 
										"</div>" + 
										"<div class=\"page_text\" style=\"float:left;\">" + 
										"<a href=\"javascript:getOwnerInfoList(1)\" style=\"margin-right:5px;\">首页</a>" + 
										"<a href=\"javascript:getOwnerInfoList(" + (data.currpage-1) + ")\" style=\"margin-right:5px;\">上页</a>";	
						for (var i = Number.parseInt(data.startnav); i <= data.endnav; i++) {
							if (i == Number.parseInt(data.currpage)) { //把当前页的页码变红，并且普通的span标签不能点击
								navStr += "<span style=\"margin-right:5px;font-weight:Bold;color:red;\">" + i + "</span>"
								continue;
							}
							navStr += "<a href=\"javascript:getOwnerInfoList(" + i + ")\" style=\"margin-right:5px;\">" + i + "</a>"
						}
						navStr += "<a href=\"javascript:getOwnerInfoList(" + (data.currpage+1) + ")\" style=\"margin-right:5px;\">下页</a>" + 
  									"<a href=\"javascript:getOwnerInfoList(" + data.totalpage + ")\" style=\"margin-right:5px;\">末页</a>" + 
  									"</div>" + 
  									"</div>" + 
  									"</td>" + 
  									"</tr>"
  						$pageNode.append(navStr);
					} //拼接页面导航结束
				}//内层else代码块结束
				
				//这是页面分页导航栏的附加操作
		  		if (Number.parseInt(data.currpage) == 1) {
		  			var $test = $(".page_text a:lt(2)");
		  			$(".page_text a:lt(2)").removeAttr("href").attr("disabled","disabled");
		  		} else if (data.currpage == data.totalpage) {
		  			$(".page_text a:last").removeAttr("href").attr("disabled","disabled").prev().removeAttr("href").attr("disabled","disabled");
		  		}
		  		
		  		//这是绑定全选按钮的单击事件
		  		$("#chkall").click(function() {
		  			if (this.checked) {
		  				$("[name=ownerId]").each(function(){
		  					if (!this.checked) {
								$(this).click();
							}
		  				});
					} else {
						$("[name=ownerId]").each(function(){
		  					if (this.checked) {
								$(this).click();
							}
		  				});
					}
		  		});
		  		
			},//这里是请求数据成功后的回调函数结束
			
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				var $gridNode = $("#GridView1").empty();
				$gridNode.append("<tr height='70'><td colspan='6' style=\"font-family:'Microsoft YaHei'; border-bottom:0;\">" +
				"查询失败，请联系管理员！</td></tr>");
			}//请求数据失败后的回调函数结束
		}); //AJAX的结束
	}//最外层的else代码块结束
}//获取业主信息的函数的结束
	
//这是点击业主编码后的弹框代码
function getOwnerInfobyOwnerCode(ownerCode){
	layer.open({
		type: 2,
		area: ['600px','90%'],
		shadeClose: true, //点击遮罩关闭
		skin: 'layui-layer-rim',
		/*content: $("#ownerinfo_oi"),*/
		content: rootPath + '/homm/ownerinfo/getownerinfobyownercode?ownerCode='+ownerCode,
		title :'业主信息',
		end : function() {
			$("#QueryBtn").click(); //弹框关闭后，即更新业主信息成功后，点击查询按钮
		}
	});
}

//这是业主家庭成员信息的弹框代码
function getFmbyOwnerId(ownerId){
	layer.open({
		type: 2,
		area: ['800px','90%'],
		shadeClose: true, //点击遮罩关闭
		skin: 'layui-layer-rim',
		/*content: $("#ownerinfo_fm"),*/
		content: rootPath + '/homm/ownerinfo/getfamilymembers?ownerId=' + ownerId,
		title :'家庭成员',
		end : function() {
			$("#QueryBtn").click(); //弹框关闭后，即更新业主信息成功后，点击查询按钮
		}
	});
}

//这是业主房产信息的弹框代码
function getEstbyOwnerId(ownerId){
	layer.open({
		type: 2,
		area: ['800px','90%'],
		shadeClose: true, //点击遮罩关闭
		skin: 'layui-layer-rim',
		/*content: $("#ownerinfo_fm"),*/
		content: rootPath + '/homm/ownerinfo/getestates?ownerId=' + ownerId,
		title :'家庭成员',
		end : function() {
			$("#QueryBtn").click(); //弹框关闭后，即更新业主信息成功后，点击查询按钮
		}
	});
}

