<%@ page pageEncoding="UTF-8"
	import="com.scs.model.Inventory,java.util.List;"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>查看库存信息</title>
</head>
<%
     List<Inventory> inventories = (List<Inventory>) request.getAttribute("inventories");
 %>

<body>
<table width="576" height="187" border="1" align="center">
 <tr>
    <td colspan="11" align="center"><strong>查看库存信息</strong></td>
  </tr>
  <tr>
    <td width="20" bgcolor="#3300FF">时期</td>
    <td width="40" bgcolor="#3300FF">P1现存量</td>
    <td width="40" bgcolor="#3300FF">P2现存量</td>
    <td width="40" bgcolor="#3300FF">P3现存量</td>
    <td width="40" bgcolor="#3300FF">P1入库量</td>
    <td width="40" bgcolor="#3300FF">P2入库量</td>
    <td width="40" bgcolor="#3300FF">P3入库量</td>
    <td width="40" bgcolor="#3300FF">P1出库量</td>
    <td width="40" bgcolor="#3300FF">P2出库量</td>
    <td width="40" bgcolor="#3300FF">P3出库量</td>
  </tr>
  
  <%
  for(Inventory i : inventories)
  {
  %>
    <tr>
    <td width="20" bgcolor="#33FF00"><%=i.getCurrentime().getCurrentime()%></td>
    <td bgcolor="#33FF00"><%=i.getCurrentp1()%></td>
    <td bgcolor="#33FF00"><%=i.getCurrentp2()%></td>
    <td bgcolor="#33FF00"><%=i.getCurrentp3()%></td>
    <td bgcolor="#33FF00"><%=i.getP1in()%></td>
    <td bgcolor="#33FF00"><%=i.getP2in()%></td>
    <td bgcolor="#33FF00"><%=i.getP3in()%></td>
    <td bgcolor="#33FF00"><%=i.getP1out() %></td>
    <td bgcolor="#33FF00"><%=i.getP2out() %></td>
    <td bgcolor="#33FF00"><%=i.getP3out() %></td>
  </tr>
   <%} %>
</table>
</body>
</html>

