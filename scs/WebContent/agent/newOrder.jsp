<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="com.scs.model.*"%>
    <%
User user = (User) session.getAttribute("user");
Relation relation = (Relation)session.getAttribute("relation");
int roleid = relation.getRole().getRoleid();
int currentime0 = Integer.parseInt(request.getParameter("currentime"));
 
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>发出新的订单</title>
<script type="text/javascript" src="index.js"></script>
<link rel="stylesheet" type="text/css" href="../css/window.css">
</head>
<body>
<form name="newOrder" method="post" action="orderaction!newOrder?roleid=<%=roleid %>">
  <table width="400" height="170" align="center" bgcolor="#66FFFF" border="2" id="table1">
    <tr>
      <td width="97">当前期数：</td>
      <td id="redfont"><input type="hidden" name="current" value="<%=currentime0%>"/><%=currentime0%></td>
    </tr>
    <tr>
      <td>用户编号：</td>
      <td id="redfont"><input type="hidden" name="order.ofrom" value="<%=((User)session.getAttribute("user")).getUserid() %>"/><%=((User)session.getAttribute("user")).getUserid() %></td>
    </tr>
    <tr>
      <td>上游编号：</td>
      <td id="redfont"><input type="hidden" name="order.oto" value="<%=((Relation)session.getAttribute("relation")). getUpstream()%>"/><%=((Relation)session.getAttribute("relation")). getUpstream()%></td>
    </tr>
    <tr>
      <td><strong>产品</strong></td>
      <td width="125"><strong>数量</strong></td>
      <td width="162"><strong>单价</strong></td>
    </tr>
    <tr>
      <td>产品1</td>
      <td ><input name="order.countp1" type="text" id="order.countp1" size="4"/>
      个</td>
      <td ><input name="order.p1price" type="text" id="order.p1price" size="6"/>
元</td>
    </tr>
    <tr>
      <td>产品2</td>
      <td><input name="order.countp2" type="text" id="order.countp2" size="4"/>
个</td>
      <td><input name="order.p2price" type="text" id="order.p2price" size="6"/>
      元</td>
    </tr>
    <tr>
      <td>产品3</td>
      <td><input name="order.countp3" type="text" id="order.countp3" size="4"/>
个</td>
      <td><input name="order.p3price" type="text" id="order.p3price" size="6"/>
元</td>
    </tr>
    <tr>
      <td bgcolor="#FFFFFF"></td>
      <td bgcolor="#FFFFFF">&nbsp;</td>
      <td bgcolor="#FFFFFF"><input name="submit" type="submit" value="提交"/></td>
    </tr>
  </table>
</form>
<p>&nbsp;</p>
</body>
</html>