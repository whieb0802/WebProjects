<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="com.scs.model.*"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    User user = (User) session.getAttribute("user");
    int currentime = Integer.parseInt(request.getParameter("currentime"));
    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>仓库租买</title>
<script type="text/javascript" src="index.js"></script>
</head>
<body style="font-size: 12px;">

<div align="center" style="border-top: 50px">
 <form action="growlineaction!newline?userid=<%=user.getUserid()%>&current=<%=currentime %>"  method="post" >
<table width="365" height="213" border="1" bgcolor="lavender" style="height: 50px；width:60%">
  <tr height="50" >
    <th colspan="3" style="width: 234px; height: 21px">生产线租买</th>
  <tr style="height: 35px">
    <th width="127">
        选择租生产线的类型    
    </th>
    <th width="127"><p>
      <label>
        <input type="checkbox" name="rentp1growline" value="1">
        P1生产线 </label>
      <br>
      <label>
        <input type="checkbox" name="rentp2growline" value="1">
        P2生产线 </label>
      <br>
      <label>
        <input type="checkbox" name="rentp3growline" value="1">
        P3生产线</label>
      <br>
      </p></th>
    <td width="89"  style="height: 28px"><p>&nbsp;</p></td>
  </tr>

 
         <tr style="height: 35px">
           <th>选择买生产线的类型</th>
           <th><label>
             <input type="checkbox" name="buyp1growline" value="1">
P1生产线 </label>
             <br>
             <label>
               <input type="checkbox" name="buyp2growline" value="1">
               P2生产线 </label>
             <br>
             <label>
               <input type="checkbox" name="buyp3growline" value="1">
            P3生产线 </label></th>
           <td style="height: 28px">&nbsp;</td>
         </tr>
          <tr style="height: 35px">
    <th>&nbsp;</th>
    <th>&nbsp;</th>
    <td style="height: 28px"><input type="submit" name="submit" value="提交"></td>
  </tr>
</table>
  </form>
</div>
</body>
</html>
