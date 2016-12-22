<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
					<img height="14" src="skin/images/frame/book1.gif" width="20" />&nbsp;欢迎使用数字家庭智能推荐系统，您所有视频点播数据如下表所示：
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
						<td background="skin/images/frame/wbg.gif"
							class='title'><span>数据更新</span></td>
					</tr>
					<tr bgcolor="#FFFFFF">
						<td><a href='../WB/dataInitAction!run01'>关联规则计算</a></td>
					</tr>
					<tr bgcolor="#FFFFFF">
						<td><a href='../WB/dataInitAction!run02'>内容过滤计算</a></td>
					</tr>
					<tr bgcolor="#FFFFFF">
						<td><a href='../WB/dataInitAction!run03'>兴趣模型计算</a></td>
					</tr>
				</table>
</body>
</html>
