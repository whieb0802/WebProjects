<%@ page pageEncoding="UTF-8"
	import="com.scs.model.Inventory,java.util.List;"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
</head>
<%
     List<Inventory> inventories = (List<Inventory>) request.getAttribute("inventories");
 %>

<body>
<table width="453" height="98" border="1" align="center">
 <tr>
    <td colspan="5" align="center"><strong>查看库存信息</strong></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#3300FF">周数</td>
    <td width="126" bgcolor="#3300FF">P1</td>
    <td width="136" bgcolor="#3300FF">P2</td>
    <td width="89" bgcolor="#3300FF">P3</td>
  </tr>
  
  <%
  for(Inventory i : inventories)
  {
  %>
    <tr>
      <td colspan="2" bgcolor="#33FF00"><%=i.getCurrentime().getCurrentime()%></td>
    <td bgcolor="#33FF00"><%=i.getCurrentp1()%></td>
    <td bgcolor="#33FF00"><%=i.getCurrentp2()%></td>
    <td bgcolor="#33FF00"><%=i.getCurrentp3()%></td>
  </tr>
   <%} %>
</table>
</body>
</html>

