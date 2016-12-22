<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/Untitled-4.css" rel="stylesheet" type="text/css" />
<title>用户注册</title>
<script type="text/javascript">
	
	function checkInput()
	{
		
		var name=document.getElementById("username").value;
		var pwd=document.getElementById("password").value;
		var pwd1=document.getElementById("password2").value;
		var realname = document.getElementById("realname").value;

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

			if(pwd.length<1||pwd.length>16){
				alert("密码格式为1-16位！");
				return false;
			}
		
		   if(pwd1==null||pwd1==""){
			alert("请输入确认密码！");
			document.getElementById("password2").focus();
			return false;
		}
		
		if(pwd!=null&&pwd1!=""){
			if(pwd!=pwd1){
				alert("确认密码输入有误！");
				document.getElementById("password2").focus();
				return false;
			}
		}
		if(realname==null||realname==""){
			alert("请输入真实姓名！");
			document.getElementById("realname").focus();
			return false;
		}
		
		else
		
		return true;
	}
	
</script>
</head>
<body bgcolor="#FFFFFF">
<form id="registerform"  name="registerform" method="post" action="register" onSubmit="return checkInput()">
	<input type="hidden" name="userid" id="userid" />
	<input type="hidden" name="path" id="path" value=<%=request.getContextPath()%> />
	<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0" id="__01">
		<tr>
			<td height="124" colspan="4"><img src="images/banner.jpg" width="1000" height="124" /></td>
		</tr>
		<tr>
		  <td height="61" colspan="4"><img src="images/yonghuzhucexiaoren.gif" width="1000" height="61" /></td>
	  </tr>
		<tr>
			<td width="12" height="372" align="left" valign="top" background="images/zuoshuxian.gif" bgcolor="#FFFFFF">&nbsp;</td>
		    <td width="764" height="372" align="center" valign="top" bgcolor="#FFFFFF"><table width="572" height="357" border="0" align="center" cellspacing="0">
	          <tr>
	            <td width="190" align="right" class="td">用 户 名：</td>
	            <td colspan="4" align="left"><input name="username" id="username"  type="text" class="01input" /></td>
	            <td width="78" align="left" class="hongxing">*</td>
	          </tr>
	          <tr>
	            <td align="right" class="td">密 &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;码：</td>
	            <td colspan="4" align="left"><input name="password" id="password" type="password" class="01input" /></td>
	            <td align="left"><span class="hongxing">*</span></td>
	          </tr>
	          <tr>
	            <td align="right" class="td">确认密码：</td>
	            <td colspan="4" align="left"><input name="password2" id="password2" type="password" class="01input" /></td>
	            <td align="left"><span class="hongxing">*</span></td>
	          </tr>
	         
	          <tr>
	            <td align="right" class="td">真实姓名：</td>
	            <td colspan="4" align="left"><input name="realname" id="realname" type="text" class="01input" /></td>
	            <td align="left"><span class="hongxing">*</span>
	          </tr>
	          <tr>
	            <td>&nbsp;</td>
    <td height="40" colspan="3" align="left"><input type="image" src="images/tijiao.gif"/> 
	</td>
	            <td width="196" align="left"><img style="cursor:pointer" src="images/guanbi.gif" width="75" height="29" border="0" onclick="window.close()"/></td>
	            <td>&nbsp;</td>
	          </tr>
          </table></td>
		    <td width="214" height="372" bgcolor="#FFFFFF">&nbsp;</td>
		    <td width="10" height="372" align="right" background="images/youshuxian.gif" bgcolor="#FFFFFF">&nbsp;</td>
		</tr>
		
		<tr>
			<td width="12" background="images/zhuce_04.gif">
				<img id="zhuce_03" src="images/zhuce_03.gif" width="12" height="99" alt="" /></td>
			<td colspan="2" align="right" valign="top" background="images/zhuce_04.gif">&nbsp;</td>
			<td width="10" align="right" background="images/zhuce_04.gif">
				<img id="zhuce_06" src="images/zhuce_06.gif" width="10" height="99" alt="" /></td>
		</tr>
	</table>
</form>
</body>
</html>