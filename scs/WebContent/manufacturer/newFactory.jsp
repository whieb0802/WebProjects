<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="GBK" import="com.scs.model.*,java.util.List"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    User user = (User) session.getAttribute("user");
	int currentime = Integer.parseInt(request.getAttribute("currentime").toString());
    List<Storageinfo> list = (List<Storageinfo>)request.getAttribute("storageinfos"); 
    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��������</title>

<link rel="stylesheet" type="text/css" href="../css/window.css">
<style type="text/css">
body,td,th {
	font-size: 12px;
}
</style>
</head>
<body>
<script type="text/javascript">
 function confirm1(){
    var type1 = document.getElementById("rentype").value;
     alert("��ȷ��Ҫ��"+ type1 +"��"��);
 }
 
 function confirm2(){
    var type2 = document.getElementById("buytype").value;
     alert("��ȷ��Ҫ��"+type2+"��"��);
 }

</script>
<div align="center" style="border-top: 50px">
  <form action="manufactureraction!addfactory?userid=<%=user.getUserid()%>&current=<%=currentime %>"  method="post" >
  <tr style="height: 35px">
<table width="421" height="338" border="2" bgcolor="lavender" style="height: 50px��width:60% font-size: 14px; font-size: 12px;">
  <tr height="50" >
    <th colspan="5" style="width: 234px; height: 21px">��������</th>
  </tr>
  <tr height="50" >
    <th width="85"  style="width: 60px; height: 21px">����ʽ</th>
    <th width="97" align="right" style="width: 80px; height: 21px">��������</th>
    <th width="67" style="width: 50px; height: 21px">������P1����������</th>
    <th width="67" style="width: 50px; height: 21px">������P2����������</th>
    <th width="69" style="width: 50px; height: 21px">������P3����������</th>
    </tr>

    <th  rowspan="3">
        ��ֿ�    
    </th>
    <th><p>
      <label>
        <input type="checkbox" name="storage.rent3count" value="1">
        �󳧷�</label>
      <br>
    </p></th>
    <th><%=list.get(2).getP1count() %></th>
    <th><%=list.get(2).getP2count() %></th>
    <th><%=list.get(2).getP3count() %></th>
    </tr>
  <tr style="height: 35px">
    <th><input type="checkbox" name="storage.rent2count" value="1">
�г���</th>
    <th><%=list.get(1).getP1count() %></th>
    <th><%=list.get(1).getP2count() %></th>
    <th><%=list.get(1).getP3count() %></th>
    </tr>
  <tr style="height: 35px">
    <th><label>
      <input type="checkbox" name="storage.rent1count" value="1">
      С����</label></th>
    <th><%=list.get(0).getP1count() %></th>
    <th><%=list.get(0).getP2count() %></th>
    <th><%=list.get(0).getP3count() %></th>
    </tr>

  
   <tr style="height: 35px">
    <th rowspan="3">
      ��ֿ�    
    </th>
        <th><p>
      <label>
        <input type="checkbox" name="storage.buy3count" value="1" >
        �󳧷�</label>
      <br>
    </p></th>
    <th><%=list.get(2).getP1count() %></th>
    <th><%=list.get(2).getP2count() %></th>
    <th><%=list.get(2).getP3count() %></th>
    </tr>
  <tr style="height: 35px">
    <th><input type="checkbox" name="storage.buy2count" value="1">
�г���</th>
    <th><%=list.get(1).getP1count() %></th>
    <th><%=list.get(1).getP2count() %></th>
    <th><%=list.get(1).getP3count() %></th>
    </tr>
  <tr style="height: 35px">
    <th><label>
      <input type="checkbox" name="storage.buy1count" value="1">
      С����</label></th>
    <th><%=list.get(0).getP1count() %></th>
    <th><%=list.get(0).getP2count() %></th>
    <th><%=list.get(0).getP3count() %></th>
    </tr>
  </table>

<table  width="500" border="0">
  <tr>
    <td width="1003">&nbsp;</td>
    <td width="162">
      <input type="submit" name="button" id="button" value="�ύ">
   </td>
  </tr>
</table>
</form>
</div>

<p>&nbsp;</p>
</body>
</html>
