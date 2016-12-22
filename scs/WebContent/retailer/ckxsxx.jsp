<%@ page pageEncoding="UTF-8"
	import="com.scs.model.Bill,com.scs.model.User,java.util.List;"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
.STYLE1 {
	color: #FF0000;
	font-size: 18px;
	font-weight: bold;
}
-->
</style>
</head>
<%
   
    int id = ((User)session.getAttribute("user")).getUserid(); 
    List<Bill>  bills = (List<Bill>) request.getAttribute("bills");
  %>

<body>

   <table width="644" height="134" border="1" align="center">
     <tr>
       <td colspan="6" align="center"><span class="STYLE1">查看销售信息</span></td>
     </tr>
     <tr>
       <td width="106" align="center"><strong>当前周数</strong></td>
       <td width="94" align="center"><strong>产品名称</strong></td>
       <td width="148" align="center"><strong>需求数</strong></td>
       <td width="131" align="center"><strong>销售数</strong></td>
       <td width="142" align="center"><strong>卖价</strong></td>
     </tr>    
  <%
  for(Bill b : bills)
  {
  %>
      <tr>
       <td align="center" bgcolor="#FF00FF"><%=b.getCurrentime().getCurrentime() %></td>
       <td align="center" bgcolor="#FF00FF">P1</td>
       <td align="center" bgcolor="#FF00FF"><%=b.getCountp1()+b.getP1lack()%></td>
       <td align="center" bgcolor="#FF00FF"><%=b.getCountp1() %></td>
       <td align="center" bgcolor="#FF00FF"><%=b.getP1price() %></td>
     </tr>
     <tr>
       <td align="center" bgcolor="#FFFF99"><%=b.getCurrentime().getCurrentime() %></td>
       <td align="center" bgcolor="#FFFF99">P2</td>
       <td align="center" bgcolor="#FFFF99"><%=b.getCountp2()+b.getP2lack()%></td>
       <td align="center" bgcolor="#FFFF99"><%=b.getCountp2() %></td>
       <td align="center" bgcolor="#FFFF99"><%=b.getP2price() %></td>
     </tr>
     <tr>
       <td align="center" bgcolor="#99FFCC"><%=b.getCurrentime().getCurrentime() %></td>
       <td align="center" bgcolor="#99FFCC">P3</td>
       <td align="center" bgcolor="#99FFCC"><%=b.getCountp3()+b.getP3lack()%></td>
       <td align="center" bgcolor="#99FFCC"><%=b.getCountp3() %></td>
       <td align="center" bgcolor="#99FFCC"><%=b.getP3price() %></td>
     </tr>
     
    <%} %>
</table>
</body>
</html>
