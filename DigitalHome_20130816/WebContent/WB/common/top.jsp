<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>top</title>
<link href="../skin/css/base.css" rel="stylesheet" type="text/css">
<script language='javascript'>
var preFrameW = '206,*';
var FrameHide = 0;
var curStyle = 1;
var totalItem = 9;
function ChangeMenu(way){
	var addwidth = 10;
	var fcol = top.document.all.btFrame.cols;
	if(way==1) addwidth = 10;
	else if(way==-1) addwidth = -10;
	else if(way==0){
		if(FrameHide == 0){
			preFrameW = top.document.all.btFrame.cols;
			top.document.all.btFrame.cols = '0,*';
			FrameHide = 1;
			return;
		}else{
			top.document.all.btFrame.cols = preFrameW;
			FrameHide = 0;
			return;
		}
	}
	fcols = fcol.split(',');
	fcols[0] = parseInt(fcols[0]) + addwidth;
	top.document.all.btFrame.cols = fcols[0]+',*';
}

</script>
<style>
body { padding:0px; margin:0px; }
#tpa {
	color: #009933;
	margin:0px;
	padding:0px;
	float:right;
	padding-right:10px;
}

#tpa dd {
	margin:0px;
	padding:0px;
	float:left;
	margin-right:2px;
}

#tpa dd.ditem {
	margin-right:8px;
}

#tpa dd.img {
  padding-top:6px;
}

.rmain {
  padding-left:10px;
  /* background:url(../skin/images/frame/toprightbg.gif) no-repeat; */
}
</style>
</head>
<body bgColor='#ffffff'>
<table width="100%" border="0" cellpadding="0" cellspacing="0" background="../skin/images/frame/topbg.gif">
  <tr>
    <td width='30%' height="60" align="center"><img src="../skin/images/frame/logo4.png" /></td>
<!--     <td width='20%' height="60" align="center"><font  style="font-size:22px;color:#004000">数字家庭智能推荐系统</font></td> -->
    <td width='70%' align="right" valign="bottom">
    	<table  border="0" cellspacing="0" cellpadding="0">
      <tr>
      <td colspan="2" align="right" height="26" style="padding-right:10px;line-height:26px;">
        	
      </td>
      </tr>
      <tr>
        <td align="right" height="34" class="rmain">
		<dl id="tpa">
			<dd class='img'><a href="javascript:ChangeMenu(-1);"><img vspace="5" src="../skin/images/frame/arrl.gif" border="0" width="5" height="8" alt="缩小左框架"  title="缩小左框架" /></a></dd>
			<dd class='img'><a href="javascript:ChangeMenu(0);"><img vspace="3" src="../skin/images/frame/arrfc.gif" border="0" width="12" height="12" alt="显示/隐藏左框架" title="显示/隐藏左框架" /></a></dd>
		<dd class='img' style="margin-right:10px;"><a href="javascript:ChangeMenu(1);"><img vspace="5" src="../skin/images/frame/arrr.gif" border="0" width="5" height="8" alt="增大左框架" title="增大左框架" /></a></dd></dl>
		</td>
        <td align="right" height="26" style="padding-right:10px;line-height:26px;">您好：<span class="username" style="color:red;"><s:property value="#session.user.name"/></span>，欢迎使用服务资源智能推荐系统
        	[<a href="" target="">修改密码</a>]
        	[<a href="../userAction!logout" target="_top">注销退出</a>]&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>