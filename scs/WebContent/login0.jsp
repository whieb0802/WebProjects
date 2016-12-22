<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>用户登陆</title>
		
<script type="text/javascript">
	
	function checkInput()
	{
		
		var name=document.getElementById("username").value;
		var pwd=document.getElementById("password").value;

		if(name==null||name==""){
			alert("请输入用户名！");
			document.getElementById("username").focus();
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

	    <style type="text/css">
<!--
#login {
	position:absolute;
	left:588px;
	top:272px;
	width:317px;
	height:151px;
	z-index:1;
	overflow: visible;
}
#Layer1 {
	position:absolute;
	left:598px;
	top:333px;
	width:266px;
	height:216px;
	z-index:1;
}
#Layer2 {
	position:absolute;
	left:832px;
	top:512px;
	width:172px;
	height:51px;
	z-index:2;
}

-->
        </style>
</head>

	<body background="images/login.jpg">
	
	
<form action="login" method="post" name="login" onSubmit="return checkInput()">
<div id="login">
  <table width="100%"  border="0" cellpadding="1" cellspacing="1">
  <tr>
    <td>
	<table width="98%" height="283" border="0" cellpadding="0" cellspacing="0">
    
    <tr>
      <td height="23" colspan="4"></td>
	  <td width="0%" height="23" colspan="4"></td>
    </tr>
    
    <tr>
      <td height="29" colspan="4"></td>
    </tr>
    <tr>
      <td height="84" colspan="2" class="login9"><div align="right">&nbsp; </div></td>
      <td colspan="2"><input name="username" id="username" type="text" style= "background:Transparent;width:250px;border:none;height:40px;font-size:18px;font-weight:600" /></td>
    </tr>
    
    <tr>
      <td height="19" colspan="2"></td>
      <td colspan="2"></td>
    </tr>
    <tr>
      <td height="56" colspan="2" class="login9"><div align="right">&nbsp;</div></td>
      <td colspan="2"><input name="password" type="password" id="password"  style="background:Transparent;width:250px;border:none;height:40px;font-size:16px;font-weight:600" /></td>
    </tr>

    <tr>
      <td height="13" colspan="4"></td>
    </tr>
    <tr>
      <td height="13" colspan="4"></td>
      </tr>
    <tr>
      <td width="2%" height="19">&nbsp;</td>
    
    </tr>
    <tr>
      <td height="10" colspan="4" align="center"><a href="register.jsp">注册</a> <a href="manager/login.jsp">后台管理</a>  </td>
      </tr>
  </table>
	</td>
  </tr>
</table>
</div>
	    <div id="Layer2"><input type="image" src="images/submit.jpg"  width="173" height="51" border="0" usemap="#Map">
		<map name="Map"><area shape="rect" coords="-2,4,166,51"></map>
 </div>
      </form>
	</body>
</html>
