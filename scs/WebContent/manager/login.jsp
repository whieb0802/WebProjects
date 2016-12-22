<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<script type="text/javascript">
	
	function checkInput()
	{
		var name=document.getElementById("manager").value;
		var pwd=document.getElementById("password").value;

		if(name==null||name==""){
			alert("请输入用户名！");
			document.getElementById("manager").focus();
			return false;
		}

		if(pwd==null||pwd==""){
			alert("请输入密码！");
			document.getElementById("password").focus();
			return false;
		}		
		else
		  return true;
	}
	-->
</script>
<html>
	<head>
		<title>管理员登陆</title>
		<script type="text/javascript" src="register.js"></script>

	    <style type="text/css">
<!--
#Layer1 {
	position:absolute;
	left:383px;
	top:310px;
	width:285px;
	height:246px;
	z-index:1;
}
#Layer2 {
	position:absolute;
	left:572px;
	top:455px;
	width:172px;
	height:51px;
	z-index:2;
}
-->
        </style>
</head>

	<body background="../images/manager_login.jpg">
	<div id="Layer1">
	  <form action="managerLogin" method="post"onSubmit="return checkInput()">
	  <table width="260" height="200" align="center">
				<tr>
					<td width="265" height="50"></td>
					<td width="250"><input name="manager" type="text" id="manager" style="background:Transparent;border:none;width:277px;height:36px;font-size:20px;font-weight:600; " ></td>
					<td width="100"></td>
				</tr>
				<tr>
					<td height="101">					</td>
					<td><input name="password" type="password" id="password" style="background:Transparent;border:none;width:278px;height:37px;font-size:20px;font-weight:600"  /></td>
					<td></td>
				</tr>
				<tr>
					<td height="55">					</td>
					<td>
		</table>
		</div>
		 <div id="Layer2"><input type="image" src="images/login2.jpg"  width="100" height="40" border="0" usemap="#Map">
		<map name="Map"><area shape="rect" coords="-2,4,166,51"></map>
       </div>
	  </form>
	
	</body>
</html>
