<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>房产信息弹框</title>
		<style>
			*{font-size: 13px;}
			.form-item{text-align: right;}
		</style>
	</head>

	<body>
		<form method="post" action="${pageContext.request.contextPath }/homm/ownerinfo/doest"  id="form1">
			<input type="hidden" id="InfoVo" value="${InfoVo.msgcontent }" />
			<input type="hidden" id="ownerId" name="ownerId" value="${ownerInfo.ownerId }" />
			<input type="hidden" id="estId" name="estId" value="${estListByEstId[0].estId}" <c:if test="${empty estListByEstId }">disabled</c:if> />
			<input type="hidden"  name="roomId" value="${estListByEstId[0].roomId}" <c:if test="${empty estListByEstId }">disabled</c:if> <c:if test="${!empty estListByEstId }">id="roomId"</c:if>/>
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td class="td_base" width="65%" height="25px">
						登记
						<span id="lblname">${ownerInfo.ownerName}</span> 名下的房产信息<font color="red" id="alert"></font>
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
									<font color="red">*</font>选择房产：
								</td>
								<td width="30%">
									<select name="consId" id="consId" style="width:90%;" <c:if test="${!empty estListByEstId}">disabled</c:if> ><!--*******************************************-->
										<c:if test="${empty estListByEstId}">
											<option value=""></option>
											<c:forEach items="${consList}" var="cons" varStatus="status">
												<option value="${cons.consId }">${cons.consName }</option>
											</c:forEach>
										</c:if>
									</select>
								</td>
								<td width="20%" class="form-item">
									<font color="red">*</font>选择楼宇：
								</td>
								<td width="30%">
									<select name="bldId" id="bldId" style="width:90%;" <c:if test="${!empty estListByEstId}">disabled</c:if>>
										
									</select>
								</td>
							</tr>
							<tr>
								<td class="form-item">
									<font color="red">*</font>单元/楼层：
								</td>
								<td>
									<select name="unitId" id="unitId" style="width:90%;" <c:if test="${!empty estListByEstId}">disabled</c:if>>

									</select>
								</td>
								<td class="form-item">
									<font color="red">*</font>选择房间：
								</td>
								<td>
									<select name="roomId" class="mytext" style="width:90%;" <c:if test="${!empty estListByEstId}">disabled</c:if> <c:if test="${empty estListByEstId}">id="roomId"</c:if>>

									</select>
								</td>
							</tr>
							<tr>
								<td class="form-item">
									房产证号：
								</td>
								<td>
									<input name="estCid" value="${estListByEstId[0].estCid }" type="text" id="estCid" class="mytext" style="width:90%;" />
								</td>
								<td class="form-item">
									认购证号：
								</td>
								<td>
									<input name="estBid" value="${estListByEstId[0].estBid }" type="text" id="estBid" class="mytext" style="width:90%;" />
								</td>
							</tr>
							<tr>
								<td class="form-item">
									是否缴纳维修金：
								</td>
								<td>
									<select name="estIspay" id="estIspay" class="mytext" style="width:90%;">
										<option ${estListByEstId[0].estIspay==2 ? 'selected':''} value="2">否</option>
										<option ${estListByEstId[0].estIspay==1 ? 'selected':''} value="1">是</option>
									</select>
								</td>
								<td class="form-item">
									预缴维修金：
								</td>
								<td>
									<input name="estRepairdeposit" value="${estListByEstId[0].estRepairdeposit }" type="text" id="estRepairdeposit" class="mytext" style="width:90%;" />
								</td>
							</tr>
							<tr>
								<td class="form-item">
									装修时间：
								</td>
								<td>
									<input name="estDecodate" value="<fmt:formatDate value='${estListByEstId[0].estDecodate}' pattern='yyyy-MM-dd'/>" type="text" maxlength="10" id="estDecodate" class="mytext" onclick="SelectDate(this,&#39;yyyy-MM-dd&#39;)" style="width:90%;" />
								</td>
								<td class="form-item">
									<font color="red">*</font>主次排序号：
								</td>
								<td>
									<input name="estOrder" type="text" value="${empty estListByEstId? 1 : estListByEstId[0].estOrder }" id="estOrder" title="排序号越小越优先显示" class="mytext" style="width:90%;" />
								</td>
							</tr>
							<tr>
								<td class="form-item">
									备注：
								</td>
								<td colspan="3">
									<textarea name="estRemark" rows="3" cols="20" id="estRemark" class="mytextarea" style="width:96%;">${estListByEstId[0].estRemark }
</textarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="height: 30">
						<input type="submit" name="AddBtn" value="保 存" onclick="return confirm('确定保存吗？');" id="AddBtn" class="mybtn" />
						<input type="button" name="BackBtn" value="关 闭" class="mybtn" onclick="javascript: parent.layer.close(parent.layer.getFrameIndex(window.name));" />
					</td>
				</tr>
				<c:if test="${!empty estList}">
					<tr>
						<td colspan="2" width="100%" align="center">
							<div>
								<table class="hkgv" cellspacing="0" rules="all" border="1" id="GridView1" style="width:98%;border-collapse:collapse;">
									<tr class="hkHeadStyle">
										<th scope="col" style="width:30px;">序号</th>
										<th scope="col" style="width:30px;">修改</th>
										<th scope="col" style="width:30px;">删除</th>
										<th scope="col">房产</th>
										<th scope="col" style="width:60px;">使用状态</th>
										<th scope="col" style="width:75px;">入住时间</th>
										<th scope="col" style="width:75px;">装修时间</th>
										<th scope="col">认购证号</th>
										<th scope="col">房产证号</th>
										<th scope="col">维修金</th>
									</tr>
									<c:forEach items="${estList }" var="est" varStatus="status">
										<tr class="hkRowStyle" >
											<td align="center">
												<span id="GridView1_ctl02_Label1">${est.estOrder }</span>
											</td>
											<td align="center">
												<a href="${pageContext.request.contextPath }/homm/ownerinfo/getestates?&ownerId=${est.ownerId}&estId=${est.estId}">
													<img id="GridView1_ctl02_Image112" title="修改这条记录" src="${pageContext.request.contextPath }/statics/img/edit.gif" /></a>
											</td>
											<td align="center" onclick="deleteEstByEstId(${est.estId},${est.roomId },this);">
												<img src="${pageContext.request.contextPath }/statics/img/del.gif" alt="删除这条记录"/>
											</td>
											<td>
												${est.room.estFullName }
											</td>
											<td align="center">${est.mi.miStatus==1?'空闲':(est.mi.miStatus==2?'自住':(est.mi.miStatus==3?'出租':(est.mi.miStatus==4?'转卖':''))) }</td>
											<td align="center"><fmt:formatDate value='${est.mi.miDate}' pattern='yyyy-MM-dd'/></td>
											<td align="center"><fmt:formatDate value='${est.estDecodate}' pattern='yyyy-MM-dd'/></td>
											<td>${empty est.estBid? '&nbsp;' : est.estBid  }</td>
											<td>${empty est.estCid? '&nbsp;' : est.estCid  }</td>
											<td align="right">${est.estRepairdeposit }</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</td>
					</tr>
				</c:if>
			</table>
			<!-- <div id="ValidationSummary2" style="display:none;"></div>
			<span id="RegularExpressionValidator17" style="display:none;"></span>
			<span id="RequiredFieldValidator5" style="visibility:hidden;">&nbsp;</span>
			<span id="RegularExpressionValidator1" style="display:none;"></span>
			 -->
		</form>
		<script type="text/javascript">var rootPath = "${pageContext.request.contextPath }"</script>
		<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js?v=2.1.4"></script>
		<script src="${pageContext.request.contextPath }/statics/js/homm/oi/ownerinfo_est.js"></script>
	</body>
</html>