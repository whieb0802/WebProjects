<%@ page contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>列表模版</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="skin/css/main.css" />
</head>
<body leftmargin="8" topmargin='8'>
	<table width="98%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><div style='float: left'>
					<img height="14" src="skin/images/frame/book1.gif" width="20" />&nbsp;欢迎使用服务资源智能推荐系统，系统所有视频点播数据如下表所示：
				</div>
				<div style='float: right; padding-right: 8px;'>
					<!--  //保留接口  -->
				</div></td>
		</tr>
		<tr>
			<td height="1" background="skin/images/frame/sp_bg.gif"
				style='padding: 0px'></td>
		</tr>
	</table>
	<table width="98%" align="center" border="0" cellpadding="4"
		cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px">
		<tr bgcolor="#FFFFFF">
			<td height="30" align="center" valign="bottom">
				<table width="98%" align="center" border="0" cellpadding="4"
					cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px">
					<tr bgcolor="#EEF4EA">
						<td colspan="8" background="skin/images/frame/wbg.gif"
							class='title'><span>项目信息</span></td>
					</tr>
					<tr bgcolor="#FFFFFF">
						<td width="5%" bgcolor="#FFFFFF">ID</td>
						<td width="15%" bgcolor="#FFFFFF">片名</td>
						<td width="8%" bgcolor="#FFFFFF">类型</td>
						<td width="8%" bgcolor="#FFFFFF">出品地区</td>
						<td width="8%" bgcolor="#FFFFFF">导演</td>
						<td width="9%" bgcolor="#FFFFFF">主演</td>
						<td width="25%" bgcolor="#FFFFFF">简介</td>
						<td width="12%" bgcolor="#FFFFFF">上传时间</td>
<!-- 						<td width="10%" bgcolor="#FFFFFF">可选分值</td> -->
<!-- 						<td width="10%" bgcolor="#FFFFFF">打分</td> -->
					</tr>
					<s:iterator value="#request.pageView.records" var="item" status="i">
						<s:form name="form%{#i.count}" method="post" theme="simple" onsubmit="return false;">
						<tr bgcolor="#FFFFFF">
							<td><s:property value="#item.key" /></td>
							<td><s:property value="#item.title" /></td>
							<td><s:property value="#item.type" /></td>
							<td><s:property value="#item.publisharea" /></td>
							<td><s:property value="#item.director" /></td>
							<td><s:property value="#item.starring" /></td>
					<%-- 		<td><s:select list="{5,4,3,2,1}" theme="simple"></s:select> </td>
							<td>
							<s:hidden name="rating." value="%{#config.type}"></s:hidden>
							<s:hidden name="config.type" value="%{#config.type}"></s:hidden>
							<s:submit theme="simple" type="button" onclick="javascript:document.form%{#i.count}.action='itemAction!addRating';document.form%{#i.count}.submit()" value="更新"/></td>
						</tr> --%>
							<td><s:property value="#item.info" /></td>
							<td><fmt:formatDate value="${item.issuedate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</s:form>
					</s:iterator>
					<tr align="right" bgcolor="#EEF4EA">

						<td height="26" colspan="8" align="center">
							<p align="right">
								<a href="itemAction!listAll?page=1">第一页</a>&nbsp;
								&nbsp;&nbsp;&nbsp; <a
									href="itemAction!listAll?page=<s:if test='#request.pageView.currentPage-1 > 0'><s:property value='#request.pageView.currentPage-1'/></s:if><s:else>1</s:else>">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								当前第&nbsp;
								<s:if test="#request.pageView.currentPage < 1">1</s:if>
								<s:else>
									<s:property value="#request.pageView.currentPage" />
								</s:else>
								&nbsp;页 &nbsp;共&nbsp;
								<s:property value="#request.pageView.totalPage" />
								&nbsp;页&nbsp; <a
									href="itemAction!listAll?page=<s:if test='#request.pageView.currentPage+1 > #request.pageView.totalPage'><s:property value='#request.pageView.totalPage'/></s:if><s:else><s:property value='#request.pageView.currentPage+1'/></s:else>">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a
									href="itemAction!listAll?page=<s:property value='#request.pageView.totalPage'/>">最后一页</a>&nbsp;&nbsp;&nbsp;
							</p>
						</td>
					</tr>
				</table>
</body>
</html>
