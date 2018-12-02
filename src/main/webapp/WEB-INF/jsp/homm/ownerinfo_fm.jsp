<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>家庭成员弹框</title>
		<style>
			*{font-size: 13px;}
			.form-item{text-align: right;}
		</style>
	</head>

	<body>
		<form method="post" action="${pageContext.request.contextPath }/homm/ownerinfo/dofm"  id="form1" enctype="multipart/form-data">
			<input type="hidden" id="InfoVo" value="${InfoVo.msgcontent }" />
			<input type="hidden" id="ownerId" name="ownerId" value="${ownerInfo.ownerId }" />
			<input type="hidden" id="fmId" name="fmId" value="${fmListByFmId[0].fmId}" <c:if test="${empty fmListByFmId }">disabled</c:if> />
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td class="td_base" width="65%" height="25px">
						维护
						<span id="lblname">${ownerInfo.ownerName}</span> 的家庭成员信息<font color="red" id="alert"></font>
					</td>
					<td class="td_base" width="35%" align="right">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<table cellspacing="0" cellpadding="0" width="100%" border="0" class="form">
							<tr>
								<td width="20%" class="form-item">
									<font color="red">*</font>成员姓名：
								</td>
								<td width="20%">
									<input name="fmName" value="${fmListByFmId[0].fmName}" type="text" id="fmName" class="mytext" style="width:90%;" />
								</td>
								<td width="20%" class="form-item">
									联系电话：
								</td>
								<td width="20%">
									<input name="fmPhone" value="${fmListByFmId[0].fmPhone}" type="text" id="fmPhone" class="mytext" style="width:90%;" />
								</td>
								<td colspan="2" rowspan="7" align="center" width="20%">
									<!--<img id="Image1" src="../../attach/pms/zp/no.gif" style="height:140px;width:115px;" /><br />
									<span id="pictitle" class="aspNetDisabled">推荐：115*140px</span><br /> &nbsp;-->
									<input type="hidden" id="fmPicname" name="fmPicname" value="${fmListByFmId[0].fmPicname}" />
									<input name="a_fmPicname" type="file" id="a_fmPicname" style="width: 135px;" class="mytext" /><br />
									<!--<input type="submit" name="upload" value="上传" id="upload" class="mybtn" />&nbsp;<input type="submit" name="Button3" value="删除" id="Button3" class="mybtn" />-->
								</td>
							</tr>
							<tr>
								<td class="form-item">
									性别：
								</td>
								<td>
									<select name="fmGender"  id="fmGender" class="mytext" style="width:90%;">
										<option ${fmListByFmId[0].fmGender==1 ? 'selected':''} value="1">男</option>
										<option ${fmListByFmId[0].fmGender==2 ? 'selected':''} value="2">女</option>
									</select>
								</td>
								<td class="form-item">
									出生日期：
								</td>
								<td>
									<input name="fmBirthday" value="<fmt:formatDate value='${fmListByFmId[0].fmBirthday}' pattern='yyyy-MM-dd'/>" type="text" maxlength="10" id="fmBirthday" class="mytext"  style="width:90%;" />
								</td>
							</tr>
							<tr>
								<td class="form-item">
									证件类型：
								</td>
								<td>
									<select name="fmCertType" id="fmCertType" class="mytext" style="width:90%;">
										<option value="">请选择</option>
										<option ${fmListByFmId[0].fmCertType=='护照' ? 'selected':''} value="护照">护照</option>
										<option ${fmListByFmId[0].fmCertType=='驾驶证' ? 'selected':''} value="驾驶证">驾驶证 </option>
										<option ${fmListByFmId[0].fmCertType=='身份证' ? 'selected':''} value="身份证">身份证</option>
										<option ${fmListByFmId[0].fmCertType=='营业执照' ? 'selected':''} value="营业执照">营业执照</option>
										<option ${fmListByFmId[0].fmCertType=='职业资格证' ? 'selected':''} value="职业资格证">职业资格证</option>

									</select>
								</td>
								<td class="form-item">
									证件号码：
								</td>
								<td>
									<input name="fmCertNo" value="${fmListByFmId[0].fmCertNo}" type="text" id="fmCertNo" class="mytext" style="width:90%;" />
								</td>
							</tr>
							<tr>
								<td class="form-item">
									与业主关系：
								</td>
								<td>
									<select name="fmRelationship" id="fmRelationship" class="mytext" style="width:90%;">
										<option value="">请选择</option>
										<option ${fmListByFmId[0].fmRelationship=='夫妻' ? 'selected':''} value="夫妻">夫妻</option>
										<option ${fmListByFmId[0].fmRelationship=='父子' ? 'selected':''} value="父子">父子</option>
										<option ${fmListByFmId[0].fmRelationship=='父女' ? 'selected':''} value="父女">父女</option>
										<option ${fmListByFmId[0].fmRelationship=='母子' ? 'selected':''} value="母子">母子</option>
										<option ${fmListByFmId[0].fmRelationship=='母女' ? 'selected':''} value="母女">母女</option>
										<option ${fmListByFmId[0].fmRelationship=='兄弟' ? 'selected':''} value="兄弟">兄弟</option>
										<option ${fmListByFmId[0].fmRelationship=='兄妹' ? 'selected':''} value="兄妹">兄妹</option>
										<option ${fmListByFmId[0].fmRelationship=='姐弟' ? 'selected':''} value="姐弟">姐弟</option>
										<option ${fmListByFmId[0].fmRelationship=='姐妹' ? 'selected':''} value="姐妹">姐妹</option>
										<option ${fmListByFmId[0].fmRelationship=='祖孙' ? 'selected':''} value="祖孙">祖孙</option>
									</select>
								</td>
								<td class="form-item">
									学历：
								</td>
								<td>
									<select name="fmEducation" id="fmEducation" class="mytext" style="width:90%;">
										<option value="">请选择</option>
										<option ${fmListByFmId[0].fmEducation=='小学' ? 'selected':''} value="小学">小学</option>
										<option ${fmListByFmId[0].fmEducation=='初中' ? 'selected':''} value="初中">初中</option>
										<option ${fmListByFmId[0].fmEducation=='高中' ? 'selected':''} value="高中">高中</option>
										<option ${fmListByFmId[0].fmEducation=='中专' ? 'selected':''} value="中专">中专</option>
										<option ${fmListByFmId[0].fmEducation=='职高' ? 'selected':''} value="职高">职高</option>
										<option ${fmListByFmId[0].fmEducation=='大专' ? 'selected':''} value="大专">大专</option>
										<option ${fmListByFmId[0].fmEducation=='本科' ? 'selected':''} value="本科">本科</option>
										<option ${fmListByFmId[0].fmEducation=='硕士研究生' ? 'selected':''} value="硕士研究生">硕士研究生</option>
										<option ${fmListByFmId[0].fmEducation=='博士研究生' ? 'selected':''} value="博士研究生">博士研究生</option>
										<option ${fmListByFmId[0].fmEducation=='其它' ? 'selected':''} value="其它">其它</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="form-item">
									工作单位：
								</td>
								<td colspan="3">
									<input name="fmWork" value="${fmListByFmId[0].fmWork}"  type="text" id="fmWork" class="mytext" style="width:96%;" />
								</td>
							</tr>
							<tr>
								<td class="form-item">
									备注：
								</td>
								<td colspan="3">
									<textarea name="fmRemark" rows="3" cols="20" id="fmRemark" class="mytextarea" style="width:96%;">${fmListByFmId[0].fmRemark}</textarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="height: 30">
						<input type="submit" name="AddBtn" value="保 存"  id="AddBtn" class="mybtn" onclick="return confirm('确定保存吗？');"/>
						<input type="button" name="BackBtn" value="关 闭" class="mybtn" onclick="javascript: parent.layer.close(parent.layer.getFrameIndex(window.name));" />
					</td>
				</tr>
				<c:if test="${!empty fmList}">
					<tr>
						<td colspan="2" width="100%" align="center">
							<div>
								<table class="hkgv" cellspacing="0" rules="all" border="1" id="GridView1" style="width:98%;border-collapse:collapse;">
									<tr class="hkHeadStyle">
										<th scope="col" style="width:25px;">序号</th>
										<th scope="col" style="width:40px;">修改</th>
										<th scope="col" style="width:40px;">删除</th>
										<th scope="col" style="width:90px;">姓名</th>
										<th scope="col" style="width:35px;">性别</th>
										<th scope="col" style="width:80px;">联系电话</th>
										<th scope="col" style="width:130px;">证件号码</th>
										<th scope="col">工作单位</th>
										<th scope="col" style="width:50px;">关系</th>
									</tr>
									<c:forEach items="${fmList }" var="fm" varStatus="status">
										<tr class="hkRowStyle">
											<td align="center">
												<span id="GridView1_ctl02_Label1">${status.index}</span>
											</td>
											<td align="center">
												<a href="${pageContext.request.contextPath }/homm/ownerinfo/getfamilymembers?&ownerId=${fm.ownerId}&fmId=${fm.fmId}">
													<img id="GridView1_ctl02_Image112" title="修改这条记录" src="${pageContext.request.contextPath }/statics/img/edit.gif" />
												</a>
											</td>
											<td align="center" onclick="deleteFmByFmId(${fm.fmId},this);">
												<img src="${pageContext.request.contextPath }/statics/img/del.gif" alt="删除这条记录" />
											</td>
											<td>${fm.fmName }</td>
											<td align="center">${fm.fmGender==1? "男":"女" }</td>
											<td>${fm.fmPhone }</td>
											<td align="center">${fm.fmCertNo }</td>
											<td>${fm.fmWork }&nbsp;</td>
											<td align="center">${fm.fmRelationship }</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</td>
					</tr>
				</c:if>
			</table>
		</form>
		<script type="text/javascript">var rootPath = "${pageContext.request.contextPath }"</script>
		<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js?v=2.1.4"></script>
		<script src="${pageContext.request.contextPath }/statics/js/homm/oi/ownerinfo_fm.js"></script>
	</body>

</html>