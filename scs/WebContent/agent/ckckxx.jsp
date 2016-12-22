<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="com.scs.model.*,java.util.List"%>
    <%
       Storage s = (Storage)request.getAttribute("storage");
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>查看仓库基本信息</title>
<script type="text/javascript" src="index.js"></script>
</head>
<body>

  <table width="560" height="180" align="center" bgcolor="#66FFFF" border="2">
   
    <tr>
      <th height="30" colspan="11" align="center" bgcolor="#FF0000"><h3>查看仓库基本信息</h3></th>
    </tr>
    <tr>
      <td width="36"><strong>用户编号</strong></td>
      <td width="26"><strong>时期</strong></td>
      <td width="56"><strong>现有买的小仓库</strong></td>
      <td width="37"><strong>中仓库</strong></td>
      <td width="38"><strong>大仓库</strong></td>
      <td width="63"><strong>现有租赁的小仓库</strong></td>
      <td width="53"><strong>中仓库</strong></td>
      <td width="38"><strong>大仓库</strong></td>
      <td width="55"><strong>P1最大库存量</strong></td>
      <td width="32"><strong>P2</strong></td>
      <td width="48"><strong>P3</strong></td>
    </tr>
  
    <tr>
      <td><%=s.getUser().getUserid() %></td>
      <td><%=s.getCurrentime().getCurrentime() %></td>
      <td><%=s.getBuy1count() %></td>
      <td><%=s.getBuy2count() %></td>
      <td><%=s.getBuy3count() %></td>
      <td><%=s.getRent1count() %></td>
      <td><%=s.getRent2count() %></td>
      <td><%=s.getRent3count() %></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>

<p>&nbsp;</p>
</body>
</html>