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
	function submit(){
		if(checkInput())
		document.forms.login.submit();
		}
	function register(){
		window.location.href="register.jsp";
		}
</script>
<style type="text/css">
<!--
#login {
	position:absolute;
	width:448px;
	height:330px;
	z-index:1;
	left: 614px;
	top: 319px;
	background-image:url(images/10.png);
	visibility: visible;
	margin-left:-200px;
	margin-top:-150px;
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
	left:742px;
	top:405px;
	width:102px;
	height:41px;
	z-index:4;
}
#apDiv1 {
	position:absolute;
	left:411px;
	top:168px;
	width:547px;
	height:430px;
	z-index:3;
}
#apDiv2 {
	position:absolute;
	left:680px;
	top:405px;
	width:63px;
	height:36px;
	z-index:4;
}
#login9 {
    font-family: "宋体";
    font-size: 14px;
    font-weight: bold;
    color:#000;;
    text-decoration: none;
    cursor:hand;
}
-->
</style>
</head>

<body background="images/1.png">


 <style>

.intro{
position:absolute;
left:0;
top:0;
layer-background-color:yellow;
background-color:green;
border:0.1px solid yellow;
z-index:5;
}
.pt9 {  font-family: "宋体"; font-size: 9pt; text-decoration: none}
body { font-family: "宋体"; font-size: 9pt; text-decoration: none ; margin-top: 0px}

</style>
<div id="i1" class="intro"></div><div id="i2" class="intro"></div>
<script
language="JavaScript1.2">


var speed=20
var temp=new Array()
var temp2=new Array()
if (document.layers){
for (i=1;i<=2;i++){
temp[i]=eval("document.i"+i+".clip")
temp2[i]=eval("document.i"+i)
temp[i].width=window.innerWidth/2
temp[i].height=window.innerHeight
temp2[i].left=(i-1)*temp[i].width
}
}
else if (document.all){
var clipright=document.body.clientWidth/2,clipleft=0
for (i=1;i<=2;i++){
temp[i]=eval("document.all.i"+i+".style")
temp[i].width=document.body.clientWidth/2
temp[i].height=document.body.offsetHeight
temp[i].left=(i-1)*parseInt(temp[i].width)
}
}


function openit(){
window.scrollTo(0,0)
if (document.layers){
temp[1].right-=speed
temp[2].left+=speed
if (temp[2].left>window.innerWidth/2)
clearInterval(stopit)
}
else if (document.all){
clipright-=speed
temp[1].clip="rect(0 "+clipright+" auto 0)"
clipleft+=speed
temp[2].clip="rect(0 auto auto "+clipleft+")"
if (clipright<=0)
clearInterval(stopit)
}
}

function gogo(){
stopit=setInterval("openit()",100)
}
gogo()

</script>
<%--<div id="apDiv1"><img src="images/2.png" width="446" height="329"></div>--%>
<div id="login">
<form action="login" method="post" name="login">
  <table width="100%"  border="0" cellpadding="1" cellspacing="1">
  <tr>
    <td>
	<table width="101%" height="264" border="0" cellpadding="0" cellspacing="0">
    
    <tr>
      <td height="55" colspan="5"></td>
	  <td width="71%" height="55" colspan="4"></td>
    </tr>
    
    <tr>
      <td height="39" colspan="5"></td>
    </tr>
    <tr>
      <td height="68" colspan="5" class="login9">&nbsp;</td>
 <td colspan="2" id="login9"><input name="username" id="username" type="text" style= "background:Transparent;width:220px;border:none;height:26px;font-size:18px;font-weight:600;" /></td>
    </tr>
    
    <tr>
      <td height="2" colspan="2"></td>
      <td colspan="3"></td>
    </tr>
    <tr>
      <td height="52" colspan="5" class="login9">&nbsp;</td>
      <td colspan="2" id="login9"><input name="password" type="password" id="password"  style="background:Transparent;width:220px;border:none;height:26px;font-size:16px;font-weight:600" /></td>
    </tr>

    <tr>
      <td height="13" colspan="5"></td>
    </tr>
    <tr>
      <td height="13" colspan="5"></td>
      </tr>
    <tr>
      <td width="2%" height="19">&nbsp;</td>
    
    </tr>
    </table>
	</td>
  </tr>
</table>
</form>
</div>
<%--<div id="login">--%>
<%--<form action="login" method="post" name="login">--%>
<%--  <table width="100%"  border="0" cellpadding="1" cellspacing="1">--%>
<%--    <tr>--%>
<%--      <td><table width="98%" height="239" border="0" cellpadding="0" cellspacing="0">--%>
<%--        <tr>--%>
<%--          <td height="15" colspan="4"></td>--%>
<%--          <td width="0%" height="15" colspan="4"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--          <td height="38" colspan="4"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--          <td height="57" colspan="2" id="login9"><div align="right">&nbsp; </div></td>--%>
<%--          <td colspan="2" id="login9"><input name="username" id="username" type="text" style= "background:Transparent;width:220px;border:none;height:30px;font-size:18px;font-weight:600;" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--          <td height="12" colspan="2"></td>--%>
<%--          <td colspan="2"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--          <td height="56" colspan="2" id="login9"><div align="right">&nbsp;</div></td>--%>
<%--          <td colspan="2" id="login9"><input name="password" type="password" id="password"  style="background:Transparent;width:220px;border:none;height:30px;font-size:16px;font-weight:600" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--          <td height="13" colspan="4"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--          <td height="13" colspan="4"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--          <td width="2%" height="19">&nbsp;</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--          <td height="10" colspan="4" align="center">&nbsp;</td>--%>
<%--        </tr>--%>
<%--      </table></td>--%>
<%--    </tr>--%>
<%--  </table>--%>
<%--  </form>--%>
<%--  </div>--%>

<div id="Layer2">
<img src="images/submit.jpg" width="100" height="29" onClick="submit()">
</div>
<div id="apDiv2"><img src="images/4.png" width="44" height="29" onClick="register()"></div>


</body>
</html>
