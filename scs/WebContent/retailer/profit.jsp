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
    
    <title>�鿴�����</title>
    
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
  <div align="center">��<%=currentime %>�������
  <table width="306" border="1" cellspacing="2" cellpadding="2">
  <tr>
    <td colspan="2"><div align="center">��Ŀ</div></td>
    <td width="125">���</td>
  </tr>
  <tr>
    <td colspan="2">��������</td>
    <td><%=report.getSaleincome() %></td>
  </tr>
  <tr>
    <td colspan="2">ֱ�ӳɱ�</td>
    <td><%=report.getDirectcost() %></td>
  </tr>
  <tr>
    <td colspan="2"><strong>ë��</strong></td>
    <td><%=report.getSaleincome()-report.getDirectcost() %></td>
  </tr>
  <tr>
    <td width="31" rowspan="2">�ۺϷ���</td>
    <td width="122" height="19">�ֿ����</td>
    <td><%=report.getStoragerentcost() %></td>
  </tr>
  <tr>
    <td height="19">��Ʒ������</td>
    <td><%=report.getProductstoragecost() %></td>
  </tr>
  <tr>
    <td colspan="2"><strong>֧����Ϣǰ����</strong></td>
    <td><%=report.getSaleincome()-report.getDirectcost()-report.getStoragerentcost()-report.getProductstoragecost() %></td>
  </tr>
  <tr>
    <td colspan="2">�������</td>
    <td><%=report.getFundcost() %></td>
  </tr>
  <tr>
    <td colspan="2"><strong>˰ǰ����</strong></td>
    <td><%=report.getSaleincome()-report.getDirectcost()-report.getStoragerentcost()-report.getProductstoragecost()-report.getFundcost()%></td>
  </tr>
  <tr>
    <td colspan="2">����˰</td>
    <td><%=report.getTax() %></td>
  </tr>
  <tr>
    <td colspan="2"><strong>��Ⱦ�����</strong></td>
    <td><%=report.getSaleincome()-report.getDirectcost()-report.getStoragerentcost()-report.getProductstoragecost()-report.getFundcost()-report.getTax()%></td>
  </tr>
</table>
</div>
</body>
</html>
