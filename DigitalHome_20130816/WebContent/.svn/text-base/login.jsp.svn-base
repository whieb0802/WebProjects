<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<script type="text/javascript"> 
function login(){ 
if(document.oform.logname.value.length<1){ 
alert("请输入用户名!");return false;
} 
if(document.oform.password.length<1){ 
alert("请输入密码!");return false;
} 

else return true;

} 
</script>
<script language="javascript" type="text/javascript">   
     var code ; //在全局 定义验证码
     function createCode()
     { 
       code = "";
       var codeLength = 4;//验证码的长度
       var checkCode = document.getElementById("checkCode");
       var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');//所有候选组成验证码的字符，当然也可以用中文的
        
       for(var i=0;i<codeLength;i++)
       {
      
        
       var charIndex = Math.floor(Math.random()*62);
       code +=selectChar[charIndex];
       
       
       }
//       alert(code);
       if(checkCode)
       {
         checkCode.className="code";
         checkCode.value = code;
       }
       
     }
     
      function checkSend(oform)
     {
       var inputCode = document.getElementById("input1").value;
       if(inputCode.length <=0)
       {
           alert("请输入验证码！");
           oform.input1.focus(); //焦点放到输入名字的地方
           return false;
       }
       else if(inputCode != code )
       {
          alert("验证码输入错误！请重新输入！");
          createCode();//刷新验证码
           oform.input1.focus(); //焦点放到输入名字的地方
           return false;
       }
       else
       {
         return true;
       }     
       }      
    </script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎使用服务资源智能推荐系统</title>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 11pt;
	font-weight: bold;
}
a {text-transform:none;text-decoration:none;}         
a:hover {text-decoration:underline}      
-->
</style>
</head>

<body  onload="createCode()" style="background-image:url(WB/images/admin_login_bg.gif); margin:0 auto; width:500px;">

<div style="background-image:url(WB/images/admin_login3.png); width:500px; height:200px; margin-top:130px;">
  <form id="oform" name="oform" method="post" action="WB/userAction!login" onSubmit="login();return checkSend(this)">
    <table width="500" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="250">&nbsp;</td>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td height="40"><div align="right" class="STYLE1">用户名：</div></td>
        <td height="40" colspan="2"><input type="text" name="name" id="logname" style="height:25px; width:200px; font-size:15pt; font-weight:bold;" /></td>
      </tr>
      <tr>
        <td height="40"><div align="right" class="STYLE1">密&nbsp;&nbsp;码：</div></td>
        <td height="40" colspan="2"><input type="password" name="password" name="password" style="height:25px; width:200px; font-size:15pt; font-weight:bold;" /></td>
      </tr>
      <tr>
        <td height="40"><div align="right" class="STYLE1">验证码：</div></td>
        <td width="100" height="40"><input type="text" id="input1"  name="txtSN" style="height:25px; width:85px; font-size:15pt; font-weight:bold;" /></td>
        <td width="150"><input name="" type="text" id="checkCode" style="width: 40px;background-color:#A2D5F0; color:#FF0000;align:center"  />  
        <a id="LinkButton1" href="#" onclick="createCode()" style="font-size:12px;">再来一张</a></td>
      </tr>
      <tr>
        <td height="40">&nbsp;</td>
        <td height="40" colspan="2"><input type="submit" onclick="login()" name="Submit" value="" style="width:130px; height:30px; background-image:url(WB/images/admin_login_button.png); border:0; background-color: transparent; "/></td>
      </tr>
    </table>
  </form>
</div>
<div style="margin-top:80px;text-align:center;font-size:14px;color:#434342">Copyright©2013     武汉理工大学电子商务与智能服务研究中心</div>
</body>
</html>
