<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="com.scs.model.*,java.util.List"%>
    <%
List<Storage> storages = (List<Storage>)request.getAttribute("storages");
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>发出新的订单</title>
<script type="text/javascript" src="index.js"></script>
</head>
<body>

  <table width="678" height="170" align="center" bgcolor="#66FFFF" border="2">
   
    <tr>
      <th height="30" colspan="8" align="center" bgcolor="#FF0000"><h3>查看厂房基本信息</h3></th>
    </tr>
    <tr>
      <td><strong>用户编号</strong></td>
      <td><strong>时期</strong></td>
      <td><strong>现有的小厂房</strong></td>
      <td><strong>中厂房</strong></td>
      <td><strong>大厂房</strong></td>
      <td><strong>租赁的小厂房</strong></td>
      <td><strong>中厂房</strong></td>
      <td><strong>大厂房</strong></td>
    </tr>
    <%
    for(Storage s : storages)
    {
     %>
    <tr>
      <td><%=s.getUser().getUserid() %></td>
      <td><%=s.getCurrentime().getCurrentime() %></td>
      <td><%=s.getBuy1count() %></td>
      <td><%=s.getBuy2count() %></td>
      <td><%=s.getBuy3count() %></td>
      <td><%=s.getRent1count() %></td>
      <td><%=s.getRent2count() %></td>
      <td><%=s.getRent3count() %></td>
    </tr>
  <%} %>
  </table>

<p>&nbsp;</p>
</body>
</html>