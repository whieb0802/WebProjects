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
					<img height="14" src="skin/images/frame/book1.gif" width="20" />&nbsp;欢迎使用服务资源智能推荐系统，系统参数信息如下表所示：
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
						<td colspan="7" background="skin/images/frame/wbg.gif"
							class='title'><span>系统参数设置</span></td>
					</tr>
					<tr bgcolor="#FFFFFF">
						<td width="5%" bgcolor="#FFFFFF">ID</td>
						<td width="28%" bgcolor="#FFFFFF">名称</td>
						<td width="8%" bgcolor="#FFFFFF">数值</td>
						<td width="20%" bgcolor="#FFFFFF">类型</td>
						<td width="20%" bgcolor="#FFFFFF">描述</td>
						<td width="20%" bgcolor="#FFFFFF">更新</td>
					</tr>
					<s:iterator value="#request.configs" var="config" status="i">  
					<s:form name="form%{#i.count}" method="post" theme="simple" onsubmit="return false;">
						<tr bgcolor="#FFFFFF">
							<td><s:property value="#i.count"></s:property></td>
							<td align="left"><s:property value="#config.name"></s:property></td>
<%-- 							<td><s:textfield name="config.name" size="40" value="%{#config.name}" theme="simple"  style="border: none;"/></td> --%>
							<td><s:textfield name="config.value" size="6" value="%{#config.value}" theme="simple"  style="border: none;"/></td>
							<td><s:if test="#config.type == 0">无</s:if><s:elseif test="#config.type==1">枚举型</s:elseif>
								<s:elseif test="#config.type==2">文本型</s:elseif><s:elseif test="#config.type==3">特定格式</s:elseif>
								<s:elseif test="#config.type==4">数值型</s:elseif>
							</td>							
							<td><s:textfield name="config.description" size="56" value="%{#config.description}" theme="simple"  style="border: none;"/></td>

							<td><s:hidden name="config.name" value="%{#config.name}"></s:hidden>
							<s:hidden name="config.type" value="%{#config.type}"></s:hidden><s:submit type="button" onclick="javascript:document.form%{#i.count}.action='parameterAction!update';document.form%{#i.count}.submit()" value="更新"/></td>
						</tr>
					</s:form>
					</s:iterator>
				</table>
	</body>
</html>
