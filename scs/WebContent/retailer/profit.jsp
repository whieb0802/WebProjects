<%@ page language="java" import="java.util.*,com.scs.model.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%  
    Report report = (Report)request.getAttribute("profit");
    int currentime = Integer.parseInt(request.getAttribute("currentime").toString());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看利润表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div align="center">第<%=currentime %>期利润表
  <table width="306" border="1" cellspacing="2" cellpadding="2">
  <tr>
    <td colspan="2"><div align="center">项目</div></td>
    <td width="125">金额</td>
  </tr>
  <tr>
    <td colspan="2">销售收入</td>
    <td><%=report.getSaleincome() %></td>
  </tr>
  <tr>
    <td colspan="2">直接成本</td>
    <td><%=report.getDirectcost() %></td>
  </tr>
  <tr>
    <td colspan="2"><strong>毛利</strong></td>
    <td><%=report.getSaleincome()-report.getDirectcost() %></td>
  </tr>
  <tr>
    <td width="31" rowspan="2">综合费用</td>
    <td width="122" height="19">仓库租金</td>
    <td><%=report.getStoragerentcost() %></td>
  </tr>
  <tr>
    <td height="19">产品库存费用</td>
    <td><%=report.getProductstoragecost() %></td>
  </tr>
  <tr>
    <td colspan="2"><strong>支付利息前利润</strong></td>
    <td><%=report.getSaleincome()-report.getDirectcost()-report.getStoragerentcost()-report.getProductstoragecost() %></td>
  </tr>
  <tr>
    <td colspan="2">财务费用</td>
    <td><%=report.getFundcost() %></td>
  </tr>
  <tr>
    <td colspan="2"><strong>税前利润</strong></td>
    <td><%=report.getSaleincome()-report.getDirectcost()-report.getStoragerentcost()-report.getProductstoragecost()-report.getFundcost()%></td>
  </tr>
  <tr>
    <td colspan="2">所得税</td>
    <td><%=report.getTax() %></td>
  </tr>
  <tr>
    <td colspan="2"><strong>年度净利润</strong></td>
    <td><%=report.getSaleincome()-report.getDirectcost()-report.getStoragerentcost()-report.getProductstoragecost()-report.getFundcost()-report.getTax()%></td>
  </tr>
</table>
</div>
</body>
</html>
