<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>ownerinfo</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet"> -->
    <style>
		*{font-size: 13px;}
		.form-item{text-align: right;}
	</style>
	</head>

	<body>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<table id="wrapTable" cellspacing="0" cellpadding="0" width="98%" align="center" border="0">
						<tr>
							<td style="height: 40px">
								房间编码：<input name="roomId" type="text" id="roomId"  style="width:100px;" /> 快速检索：
								<select id="selectItem">
									<option selected="selected" value="1">业主编码</option>
									<option value="2">业主姓名</option>
									<option value="3">证件号码</option>
									<option value="4">工作单位</option>
									<option value="5">手机号码</option>
									<option value="6">联系地址</option>
									<option value="7">银行帐号</option>
									<option value="8">紧急联系人</option>
									<option value="9">备注</option>
								</select>
								<input name="ownerCode" type="text" id="ownerCode" value="" style="width:120px;" />
								<select name="ownerType" id="ownerType">
									<option selected="selected" value="">全部业主</option>
									<option value="1">正式业主</option>
									<option value="2">临时业主</option>
								</select>
								<input type="hidden" id="currpage" value="1" /><!-- 用来保存当前页码 -->
							</td>
							<td align="right">
								<input type="button" name="QueryBtn" id="QueryBtn" value="查询" class="mybtn" />
								<input type="button" name="AddBtn" id="AddBtn" value="增加" class="mybtn" />
								<input type="button" name="StopBtn" id="StopBtn" value="停用" id="StopBtn" class="mybtn" />
								<input type="button" name="PassBtn" id="PassBtn" value="恢复" id="PassBtn" class="mybtn" />
								<input type="button" name="RefBtn" id="RefBtn" value="刷新" id="RefBtn" class="mybtn" onclick="queryBtnClick();"/>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div>
									<table class="hkgv" cellspacing="0" rules="all" border="1" id="GridView1" style="width:100%;border-collapse:collapse;">
										<!-- <tr class="hkHeadStyle">
											<th scope="col" style="width:30px;">序号</th>
											<th scope="col" style="width:30px;">
												<input id="chkall" type="checkbox" onclick="chkAll();" title="全选或全不选" style="width: 16;
                                                height: 16" />
											</th>
											<th scope="col">所属公司</th>
											<th scope="col">业主编码</th>
											<th scope="col" style="width:70px;">姓名</th>
											<th scope="col" style="width:30px;">性别</th>
											<th scope="col" style="width:80px;">出生日期</th>
											<th scope="col">证件号码</th>
											<th scope="col">手机号码</th>
											<th scope="col" style="width:40px;">状态</th>
											<th scope="col" style="width:170px;">操作</th>
										</tr> -->
										<!-- <tr class="hkRowStyle" onclick="javascript:changeBg(this)">
											<td align="center">
												<span id="GridView1_ctl02_Label1">1</span>
											</td>
											<td align="center" style="height:18px;width:30px;">
												<span class="mybox"><input id="GridView1_ctl02_del" type="checkbox" name="GridView1$ctl02$del" /></span>
											</td>
											<td>海淀子公司</td>
											<td align="center">
												<a href="#" onclick="javascript:popView('Yzxx_View.aspx?id=162')" class="gvlink">
													<span id="GridView1_ctl02_Labelyjje">A11101</span></a>
											</td>
											<td>赵云</td>
											<td align="center">男</td>
											<td align="center">1969-12-31</td>
											<td>15043019500101101</td>
											<td>13811223344</td>
											<td align="center">正常</td>
											<td align="center">
												<a href="javascript:void(0)" id="fmLink">家庭成员(1)</a>&nbsp;
												<a href="#" class="gvlink" id="estLink">房产登记(4)</a>
											</td>
										</tr>
										<tr class="hkAltRowStyle" onclick="javascript:changeBg(this)">
											<td align="center">
												<span id="GridView1_ctl03_Label1">2</span>
											</td>
											<td align="center" style="height:18px;width:30px;">
												<span class="mybox"><input id="GridView1_ctl03_del" type="checkbox" name="GridView1$ctl03$del" /></span>
											</td>
											<td>海淀子公司</td>
											<td align="center">
												<a href="#" onclick="javascript:popView('Yzxx_View.aspx?id=163')" class="gvlink">
													<span id="GridView1_ctl03_Labelyjje">A11102</span></a>
											</td>
											<td>黄盖</td>
											<td align="center">男</td>
											<td align="center">1958-7-7</td>
											<td>15043019580715101</td>
											<td>13812321112</td>
											<td align="center">正常</td>
											<td align="center">
												<a href="#" onclick="javascript:popMod('Yzxx_Jtcy.aspx?ownerid=163')" class="gvlink">家庭成员(1)</a>&nbsp;
												<a href="#" onclick="javascript:popMod('Yzxx_Fcdj.aspx?ownerid=163')" class="gvlink">房产登记(2)</a>
											</td>
										</tr> -->
									</table>
								</div>
							</td>
						</tr>
						<!-- <tr>
							<td colspan="2" style="height: 22px">
								AspNetPager 7.5 Copyright:2003-2015 Webdiyer (www.webdiyer.com)
								<div id="AspNetPager1" class="page_text" ShowInputBox="Auto" InputBoxClass="pagetext">
									<div class="page_text" style="width:250px;float:left;">
										<font color='#333333'>共 20 行/每页15行 第1/2页</font>
									</div>
									<div class="page_text" style="float:left;">
										<a disabled="disabled" style="margin-right:5px;">首页</a>
										<a disabled="disabled" style="margin-right:5px;">上页</a><span style="margin-right:5px;font-weight:Bold;color:red;">1</span>
										<a href="javascript:__doPostBack('AspNetPager1','2')" style="margin-right:5px;">2</a>
										<a href="javascript:__doPostBack('AspNetPager1','2')" style="margin-right:5px;">下页</a>
										<a href="javascript:__doPostBack('AspNetPager1','2')" style="margin-right:5px;">末页</a>
									</div>
								</div>
							</td>
						</tr> -->
					</table>
				</td>
			</tr>
		</table>
		<script type="text/javascript">var rootPath = "${pageContext.request.contextPath }"</script>
		<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js?v=2.1.4"></script>
	    <script src="${pageContext.request.contextPath }/statics/js/plugins/layer/layer.min.js"></script>
	    <script src="${pageContext.request.contextPath }/statics/js/homm/oi/ownerinfo.js"></script>
	</body>
	<%-- <div style="display: none;" id="ownerinfo_oi">
		<%@ include file="ownerinfo_oi.jsp"  %>
		<jsp:include page="${pageContext.request.contextPath }/homm/ownerinfo/getownerinfobyownercode" flush="true" />
	</div> --%>
	<%-- <div style="display: none;" id="ownerinfo_fm">
		<%@ include file="ownerinfo_fm.jsp"  %>
		<jsp:include page="ownerinfo_fm.jsp" flush="true" />
	</div> --%>
	<%-- <div style="display: none;" id="ownerinfo_est">
		<%@ include file="ownerinfo_oi.jsp"  %>
	</div> --%>
</html>