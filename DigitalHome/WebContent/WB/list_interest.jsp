<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="com.whieb.digitalhome.model.MyInterest"%>
<%@page import="com.whieb.digitalhome.model.MyAttribute"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>资源推荐页</title>
<base target="_self">
	<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
	<link rel="stylesheet" type="text/css" href="skin/css/main.css" />
</head>
<body leftmargin="8" topmargin='8'>
	<table width="98%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><div style='float: left'>
					<img height="14" src="skin/images/frame/book1.gif" width="20" />&nbsp;欢迎使用服务资源智能推荐系统，系统为您计算出的兴趣模型如下：
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
	<table width="98%" align="center" border="1" cellpadding="0" cellspacing="0">
		<tr bgcolor="#FFFFFF">
			<td height="30" align="center" valign="bottom">
				<table width="98%" align="center" border="1" cellpadding="0"
					cellspacing="0" >
					<tr bgcolor="#EEF4EA">
						<td colspan="7" background="skin/images/frame/wbg.gif"
							class='title'><span>用户兴趣模型查看</span></td>
					</tr>
					<tr height="20px;">

						<th bgcolor="#FFFFFF">属性</th>
						<th bgcolor="#FFFFFF">属性权重</th>
						<th bgcolor="#FFFFFF">属性值</th>
						<th bgcolor="#FFFFFF">属性值权重</th>
					</tr>

					<%
						Map<Integer, List> allinterest = (Map<Integer, List>) request.getAttribute("allinterest");
						for (int i = 0; i < allinterest.size() / 2; i++) {
							MyAttribute ma = (MyAttribute) allinterest.get(0).get(i);
							List<MyInterest> mi = (List<MyInterest>) allinterest.get(2 * i + 1);
					%>
					<tr>
						<td><%=ma.getAttribute()%></td>
						<td style="color:red;"><%=ma.getWeight()%></td>
						<td align="center">	<table border="0" cellpadding="0"	cellspacing="0">
					<%
							for(int k=0;k<mi.size();k++) {
							MyInterest m = mi.get(k);
					%>
					<tr align="center"><td><%=m.getSubject()%></td></tr>
							<%}%>
						</table>
						</td>
						<td align="center">	<table border="0" cellpadding="0"	cellspacing="0">
					<%
							for(int k=0;k<mi.size();k++) {
							MyInterest m = mi.get(k);
					%>
					<tr align="center"><td style="color:red;"><%=m.getWeight()%></td></tr>
							<%}%>
						</table>
						</td>
					</tr>
					<%}%>

				</table> 
</body>
</html>

