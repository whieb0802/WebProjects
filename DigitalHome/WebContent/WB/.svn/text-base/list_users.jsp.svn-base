<%@ page contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
						<td colspan="4" background="skin/images/frame/wbg.gif"
							class='title'><span>用户信息</span></td>
					</tr>
					<tr bgcolor="#FFFFFF">
						<td width="12%" bgcolor="#FFFFFF">序号</td>
						<td width="12%" bgcolor="#FFFFFF">ID</td>
						<td width="18%" bgcolor="#FFFFFF">姓名</td>
						<td width="20%" bgcolor="#FFFFFF">密码</td>
					</tr>
					<s:iterator value="#request.pageView.records" var="user" status="st">
						<tr bgcolor="#FFFFFF">
							<td><s:property value="#st.count" /></td>
							<td><s:property value="#user.key" /></td>
							<td><s:property value="#user.name" /></td>
							<td><s:property value="#user.password" /></td>
						</tr>
					</s:iterator>
					<tr align="right" bgcolor="#EEF4EA">

						<td height="16" colspan="4" align="center">
							<p align="right">
								<a href="userAction!listAll?page=1">第一页</a>&nbsp;
								&nbsp;&nbsp;&nbsp; <a
									href="userAction!listAll?page=<s:if test='#request.pageView.currentPage-1 > 0'><s:property value='#request.pageView.currentPage-1'/></s:if><s:else>1</s:else>">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								当前第&nbsp;
								<s:if test="#request.pageView.currentPage < 1">1</s:if>
								<s:else>
									<s:property value="#request.pageView.currentPage" />
								</s:else>
								&nbsp;页 &nbsp;共&nbsp;
								<s:property value="#request.pageView.totalPage" />
								&nbsp;页&nbsp; <a
									href="userAction!listAll?page=<s:if test='#request.pageView.currentPage+1 > #request.pageView.totalPage'><s:property value='#request.pageView.totalPage'/></s:if><s:else><s:property value='#request.pageView.currentPage+1'/></s:else>">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a
									href="userAction!listAll?page=<s:property value='#request.pageView.totalPage'/>">最后一页</a>&nbsp;&nbsp;&nbsp;
							</p>
						</td>
					</tr>
				</table>
</body>
</html>
