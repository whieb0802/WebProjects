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
					<img height="14" src="skin/images/frame/book1.gif" width="20" />&nbsp;欢迎使用服务资源智能推荐系统，您所有视频点播数据如下表所示：
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
							class='title'><span>历史消费信息</span></td>
					</tr>
					<tr bgcolor="#FFFFFF">
						<th width="5%" align="left">序号</th>
						<th width="5%" align="left">资源编号</th>
						<th width="10%" align="left">资源名称</th>
						<th width="5%" align="left">类型</th>
						<th width="5%" align="left">地区</th>
						<th width="5%" align="left">导演</th>
						<th width="15%" align="left">主演</th>
						<th width="10%" align="left">上传时间</th>
					</tr>
					<s:iterator value="#request.pageView.records" var="item" status="st">
						<tr bgcolor="#FFFFFF">
							<td><s:property value="#st.count" /></td>
							<td><s:property value="#item.key" /></td>
							<td  align="left"><s:property value="#item.title" /></td>
							<td  align="left"><s:property value="#item.type" /></td>
							<td><s:property value="#item.publisharea" /></td>
							<td><s:property value="#item.director" /></td>
							<td  align="left"><s:property value="#item.starring" /></td>
							<td><fmt:formatDate value="${item.issuedate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
					</s:iterator>
					<tr align="right" bgcolor="#EEF4EA">

						<td height="26" colspan="8" align="center">
							<p align="right">
								<a href="itemAction!showHistory?page=1">第一页</a>&nbsp;
								&nbsp;&nbsp;&nbsp; <a
									href="itemAction!showHistory?page=<s:if test='#request.pageView.currentPage-1 > 0'><s:property value='#request.pageView.currentPage-1'/></s:if><s:else>1</s:else>">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								当前第&nbsp;
								<s:if test="#request.pageView.currentPage < 1">1</s:if>
								<s:else>
									<s:property value="#request.pageView.currentPage" />
								</s:else>
								&nbsp;页 &nbsp;共&nbsp;
								<s:property value="#request.pageView.totalPage" />
								&nbsp;页&nbsp; <a
									href="itemAction!showHistory?page=<s:if test='#request.pageView.currentPage+1 > #request.pageView.totalPage'><s:property value='#request.pageView.totalPage'/></s:if><s:else><s:property value='#request.pageView.currentPage+1'/></s:else>">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a
									href="itemAction!showHistory?page=<s:property value='#request.pageView.totalPage'/>">最后一页</a>&nbsp;&nbsp;&nbsp;
							</p>
						</td>
					</tr>
				</table>
</body>
</html>
