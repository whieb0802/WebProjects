<%@ page pageEncoding="UTF-8"
	import="com.scs.model.*,java.util.List;"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
    List<Order>  orders = (List<Order>) request.getAttribute("orders");
    
  %>

<body>

   <table width="691" height="162" border="1" align="center">
     <tr>
       <td colspan="7" align="center"><span class="STYLE1">查看订单信息</span></td>
     </tr>
     <tr>
       <td width="70" align="center"><strong>当前周数</strong></td>
       <td width="70" align="center"><strong>产品名称</strong></td>
       <td width="70" align="center"><strong>上游编号</strong></td>
       <td width="70" align="center"><strong>订单数</strong></td>
       <td width="70" align="center"><strong>报价</strong></td>
       <td width="70" align="center"><strong>发货数量</strong></td>
       <td width="69" align="center">到货时间</td>
     </tr>    
  <%
  for(int i = 0;i < orders.size(); i++)
  {
  %>
      <tr>
       <td align="center" bgcolor="#99FFCC"><%=orders.get(i).getCurrentime().getCurrentime()%></td>
       <td align="center" bgcolor="#99FFCC">P1</td>
       <td align="center" bgcolor="#99FFCC"><%=orders.get(i).getOto() %></td>
       <td align="center" bgcolor="#99FFCC"><%=orders.get(i).getCountp1()%></td>
       <td align="center" bgcolor="#99FFCC"><%=orders.get(i).getP1price() %></td>
       <td align="center" bgcolor="#99FFCC"><s:if test="#request.bills.size == 0">未发货</s:if>
       <s:if test="#request.bills.size != 0"><%=bills.get(i).getCountp1() %></s:if></td>
       <td align="center" bgcolor="#99FFCC"><s:if test="#request.bills.size == 0">未发货</s:if>
       <s:if test="#request.bills.size != 0"><%=bills.get(i).getReceivetime() %></s:if></td>
     </tr>
     <tr>
       <td align="center" bgcolor="#FFFF99"><%=orders.get(i).getCurrentime().getCurrentime()%></td>
       <td align="center" bgcolor="#FFFF99">P2</td>
       <td align="center" bgcolor="#FFFF99"><%=orders.get(i).getOto() %></td>
       <td align="center" bgcolor="#FFFF99"><%=orders.get(i).getCountp1()%></td>
       <td align="center" bgcolor="#FFFF99"><%=orders.get(i).getP1price() %></td>
       <td align="center" bgcolor="#FFFF99"><s:if test="#request.bills.size == 0">未发货</s:if>
       <s:if test="#request.bills.size != 0"><%=bills.get(i).getCountp1() %></s:if></td>
       <td align="center" bgcolor="#FFFF99"><s:if test="#request.bills.size == 0">未发货</s:if>
       <s:if test="#request.bills.size != 0"><%=bills.get(i).getReceivetime() %></s:if></td>
     </tr>
     <tr>
       <td align="center" bgcolor="#FF66FF"><%=orders.get(i).getCurrentime().getCurrentime()%></td>
       <td align="center" bgcolor="#FF66FF">P3</td>
       <td align="center" bgcolor="#FF66FF"><%=orders.get(i).getOto() %></td>
       <td align="center" bgcolor="#FF66FF"><%=orders.get(i).getCountp1()%></td>
       <td align="center" bgcolor="#FF66FF"><%=orders.get(i).getP1price() %></td>
       <td align="center" bgcolor="#FF66FF"><s:if test="#request.bills.size == 0">未发货</s:if>
       <s:if test="#request.bills.size != 0"><%=bills.get(i).getCountp1() %></s:if></td>
       <td align="center" bgcolor="#FF66FF"><s:if test="#request.bills.size == 0">未发货</s:if>
       <s:if test="#request.bills.size != 0"><%=bills.get(i).getReceivetime() %></s:if></td>
     </tr>
     
    <%} %>
    </table>
</body>
</html>
