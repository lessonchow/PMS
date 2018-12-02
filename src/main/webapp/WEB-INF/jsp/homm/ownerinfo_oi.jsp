<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>业主信息弹框</title>
		<style>
			*{font-size: 13px;}
			.form-item{text-align: right;}
		</style>
	</head>

	<body>
		<form method="post" action="${pageContext.request.contextPath }/homm/ownerinfo/doownerinfo" id="form1" enctype="multipart/form-data">
			<input type="hidden" id="uploadFileError" value="${uploadFileError }" />
			<input type="hidden" id="success" value="${success }" />
			<input type="hidden" id="ownerId" name="ownerId" value="${ownerInfo.ownerId }" />
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td class="td_base" width="65%" height="25px">
						<span id="lbltitle">修改</span>业主信息 <font color="red" id="alert"></font>
					</td>
				</tr>
				<tr>
					<td valign="top" colspan="2">
						<table cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
							<tr>
								<td colspan="2">
									<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="form">
										<tr>
											<td class="form-item">
												<font color="red">*</font>所属公司：
											</td>
											<td>
												<select name="ldcId" id="ldcId" class="mytext" style="width:90%;">
													<option value="">请选择</option>
													<c:forEach items="${ldcList }" var="company">
														<option ${ownerInfo.ldcId==company.ldcId ? 'selected':''} value="${company.ldcId }">${company.ldcName }</option>
													</c:forEach>
												</select>
											</td>
											<td class="form-item">
												业主类型：
											</td>
											<td style="width: 30%">
												<select name="ownerType" id="ownerType" class="mytext" style="width:90%;">
													<option ${ownerInfo.ownerType==1 ? 'selected':''} value="1">正式业主</option>
													<option ${ownerInfo.ownerType==2 ? 'selected':''} value="2">临时业主</option>
												</select>
											</td>
										</tr>
										<tr>
											<td style="width: 20%" class="form-item">
												<font color="red">*</font>业主编码：
											</td>
											<td style="width: 30%">
												<input name="ownerCode" type="text" value="${ownerInfo.ownerCode}" maxlength="20" id="ownerCode" class="mytext" style="width:90%;" />
											</td>
											<td class="form-item" style="width: 20%">
												<font color="red">*</font>业主姓名：
											</td>
											<td style="width: 30%">
												<input name="ownerName" type="text" value="${ownerInfo.ownerName}" id="ownerName" class="mytext" style="width:90%;" />
											</td>
										</tr>
										<tr>
											<td class="form-item">
												性别：
											</td>
											<td>
												<select name="ownerGender" id="ownerGender" class="mytext" style="width:90%;">
													<option ${ownerInfo.ownerGender==1 ? 'selected':''} value="1">男</option>
													<option ${ownerInfo.ownerGender==2 ? 'selected':''} value="2">女</option>

												</select>
											</td>
											<td class="form-item">
												出生日期：
											</td>
											<td>
												<input name="ownerBirthday" type="text" value="<fmt:formatDate value='${ownerInfo.ownerBirthday}' pattern='yyyy-MM-dd'/>" maxlength="10" id="ownerBirthday" class="mytext" style="width:90%;" />
											</td>
										</tr>
										<tr>
											<td class="form-item">
												民族：
											</td>
											<td>
												<input name="ownerRace" type="text" value="${ownerInfo.ownerRace}" id="ownerRace" class="mytext" style="width:90%;" />
											</td>
											<td class="form-item">
												学历：
											</td>
											<td>
												<select name="ownerEducation" id="ownerEducation" class="mytext" style="width:90%;">
													<option value="">请选择</option>
													<option ${ownerInfo.ownerEducation=='小学' ? 'selected':''} value="小学">小学</option>
													<option ${ownerInfo.ownerEducation=='初中' ? 'selected':''} value="初中">初中</option>
													<option ${ownerInfo.ownerEducation=='高中' ? 'selected':''} value="高中">高中</option>
													<option ${ownerInfo.ownerEducation=='中专' ? 'selected':''} value="中专">中专</option>
													<option ${ownerInfo.ownerEducation=='职高' ? 'selected':''} value="职高">职高</option>
													<option ${ownerInfo.ownerEducation=='大专' ? 'selected':''} value="大专">大专</option>
													<option ${ownerInfo.ownerEducation=='本科' ? 'selected':''} value="本科">本科</option>
													<option ${ownerInfo.ownerEducation=='硕士研究生' ? 'selected':''} value="硕士研究生">硕士研究生</option>
													<option ${ownerInfo.ownerEducation=='博士研究生' ? 'selected':''} value="博士研究生">博士研究生</option>
													<option ${ownerInfo.ownerEducation=='其它' ? 'selected':''} value="其它">其它</option>
												</select>
											</td>
										</tr>
										<tr>
											<td class="form-item">
												国籍：
											</td>
											<td>
												<input name="ownerCountry" value="${ownerInfo.ownerCountry}" type="text" id="ownerCountry" class="mytext" style="width:90%;" />
											</td>
											<td class="form-item">
												籍贯：
											</td>
											<td>
												<input name="ownerHometown" value="${ownerInfo.ownerHometown}" type="text" id="ownerHometown" class="mytext" style="width:90%;" />
											</td>
										</tr>
										<tr>
											<td class="form-item">
												证件类型：
											</td>
											<td>
												<select name="ownerCertType" id="ownerCertType" class="mytext" style="width:90%;">
													<option ${ownerInfo.ownerCertType=='' ? 'selected':''} value="">请选择</option>
													<option ${ownerInfo.ownerCertType=='护照' ? 'selected':''} value="护照">护照</option>
													<option ${ownerInfo.ownerCertType=='驾驶证' ? 'selected':''} value="驾驶证">驾驶证 </option>
													<option ${ownerInfo.ownerCertType=='身份证' ? 'selected':''} value="身份证">身份证</option>
													<option ${ownerInfo.ownerCertType=='营业执照' ? 'selected':''} value="营业执照">营业执照</option>
													<option ${ownerInfo.ownerCertType=='职业资格证' ? 'selected':''} value="职业资格证">职业资格证</option>

												</select>
											</td>
											<td class="form-item">
												证件号码：
											</td>
											<td>
												<input name="ownerCertNo" type="text" value="${ownerInfo.ownerCertNo}" id="ownerCertNo" class="mytext" style="width:90%;" />
											</td>
										</tr>
										<tr>
											<td class="form-item">
												工作单位：
											</td>
											<td>
												<input name="ownerWork" value="${ownerInfo.ownerWork}" type="text" id="ownerWork" class="mytext" style="width:90%;" />
											</td>
											<td class="form-item">
												职务：
											</td>
											<td>
												<input name="ownerWorkPosition" value="${ownerInfo.ownerWorkPosition}" type="text" id="ownerWorkPosition" class="mytext" style="width:90%;" />
											</td>
										</tr>
										<tr>
											<td class="form-item">
												手机号码：
											</td>
											<td>
												<input name="ownerMobile" type="text" value="${ownerInfo.ownerMobile}" id="ownerMobile" class="mytext" style="width:90%;" />
											</td>
											<td class="form-item">
												邮编：
											</td>
											<td>
												<input name="ownerZipcode" type="text" value="${ownerInfo.ownerZipcode}" maxlength="6" id="ownerZipcode" class="mytext" style="width:90%;" />
											</td>
										</tr>
										<tr>
											<td class="form-item">
												联系地址：
											</td>
											<td colspan="3">
												<input name="ownerAdd" value="${ownerInfo.ownerAdd}" type="text" id="ownerAdd" class="mytext" style="width:96%;" />
											</td>
										</tr>
										<tr>
											<td class="form-item">
												紧急联系人：
											</td>
											<td>
												<input name="ownerUrgentcontact" value="${ownerInfo.ownerUrgentcontact}"  type="text" id="ownerUrgentcontact" class="mytext" style="width:90%;" />
											</td>
											<td class="form-item">
												紧急联系电话：
											</td>
											<td>
												<input name="ownerUrgentcontactPhone" value="${ownerInfo.ownerUrgentcontactPhone}"  type="text" id="ownerUrgentcontactPhone" class="mytext" style="width:90%;" />
											</td>
										</tr>
										<tr>
											<td class="form-item">
												紧急联系地址：
											</td>
											<td colspan="3">
												<input name="ownerUrgentcontactAdd" value="${ownerInfo.ownerUrgentcontactAdd}"  type="text" id="ownerUrgentcontactAdd" class="mytext" style="width:96%;" />
											</td>
										</tr>
										<tr>
											<td class="form-item">
												开户行：
											</td>
											<td>
												<input name="ownerBank" value="${ownerInfo.ownerBank}"  type="text" id="ownerBank" class="mytext" style="width:90%;" />
											</td>
											<td class="form-item">
												银行帐号：
											</td>
											<td>
												<input name="ownerBankaccount" value="${ownerInfo.ownerBankaccount}"  type="text" id="ownerBankaccount" class="mytext" style="width:90%;" />
											</td>
										</tr>
										<tr>
											<td class="form-item">
												所在派出所：
											</td>
											<td>
												<input name="ownerPolice" value="${ownerInfo.ownerPolice}"  type="text" id="ownerPolice" class="mytext" style="width:90%;" />
											</td>
											<td class="form-item">
												状态：
											</td>
											<td>
												<select name="ownerStatus" id="ownerStatus" style="width:90%;">
													<option selected="selected" value="1">正常</option>
													<option value="2">停用</option>
												</select>
											</td>
										</tr>
										<tr>
											<td class="form-item">
												备注：
											</td>
											<td>
												<textarea name="ownerRemark" rows="11" cols="20" id="ownerRemark" class="mytextarea" style="width:90%;">${ownerInfo.ownerRemark}</textarea>
											</td>
											<td colspan="2">
												<!--<img id="Image1" src="../../attach/pms/zp/no.gif" style="height:140px;width:115px;" /><br />-->
												<!--<span id="pictitle" class="aspNetDisabled"></span><br />-->
												<input type="hidden" id="ownerPicname" name="ownerPicname" value="${ownerInfo.ownerPicname }" />
												<input name="a_ownerPicname" type="file" id="a_ownerPicname" style="width: 135px;" class="mytext" />
												<!--<input type="submit" name="upload" value="上传" id="upload" class="mybtn" />
												<input type="submit" name="Button3" value="删除" id="Button3" class="mybtn" />-->
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="height: 30">
						<input type="submit" name="SaveBtn" id="SaveBtn" value="保存" class="mybtn" onclick="return confirm('确定要保存吗？')"/>
						<c:if test="${not empty ownerInfo }">
							<input type="button" name="DelBtn" id="DelBtn" value="删除" class="mybtn" onclick="deleteOwnerInfoByOwnerId(${ownerInfo.ownerId })"/>
						</c:if>
						<input type="button" name="BackBtn" id="BackBtn" value="关闭" class="mybtn" onclick="javascript: parent.layer.close(parent.layer.getFrameIndex(window.name));" />
					</td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">var rootPath = "${pageContext.request.contextPath }"</script>
		<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js?v=2.1.4"></script>
		<script src="${pageContext.request.contextPath }/statics/js/homm/oi/ownerinfo_oi.js"></script>
	</body>

</html>