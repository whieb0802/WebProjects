<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="java.sql.*,java.util.List" %>
<%@page import="com.scs.model.*,com.scs.service.*" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�ޱ����ĵ�</title>
<style type="text/css">
<!--
#form1 td {
	font-family: "����";
	font-size: 12px;
}
.STYLE1 {color: #FF0000}
-->
</style>
</head>
<%
Consume consume = (Consume)request.getAttribute("consume");   
%>
<body>
        
        <form action="consumeaction!receiveConfirm"  method="post" name="form1" id="form1">
         
          
          <table width="257" height="130" border="1" align="center">
             <tr align="center">
               <td width="44">��Ʒ��</td>
               <td width="64">����ʱ��</td>
              <td width="78" align="center">������</td>
            </tr>
            <tr>
              <td align="center">P1</td>
              <td align="center"><%=consume.getCurrentime().getCurrentime()%></td>
              <td align="center"><span style="color:#FF0000"><%=consume.getP1demand()%></span>
                ��</td>
            </tr>
           
           
            <tr>
              <td align="center">P2</td>
              <td align="center"><%=consume.getCurrentime().getCurrentime()%></td>
              <td align="center"><span style="color:#FF0000"><%=consume.getP2demand()%></span>
                ��</td>
            </tr>
            
            
            <tr>
              <td align="center">P3</td>
              <td align="center"><%=consume.getCurrentime().getCurrentime()%></td>
              <td align="center"><span style="color:#FF0000"><%=consume.getP3demand()%></span>
                ��</td>
            </tr>
          </table>
          <table width="294" height="38" border="0" align="center">
            <tr>
              <td width="79" height="25"></td>
              <td width="54" align="right"><input type="submit" name="Submit2"  value="ȷ��" /></td>
            </tr>
          </table>
          <p>&nbsp;</p>
        </form>

</body>
</html>
