<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="com.scs.model.*,java.util.List"%>
    <%
List<Growline> growlines = (List<Growline>)request.getAttribute("growlines");
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>�����µĶ���</title>
<script type="text/javascript" src="index.js"></script>
</head>
<body>

  <table width="678" height="170" align="center" bgcolor="#66FFFF" border="2">
   
    <tr>
      <th height="30" colspan="8" align="center" bgcolor="#FF0000"><h3>�鿴�����߻�����Ϣ</h3></th>
    </tr>
    <tr>
      <td><strong>�û����</strong></td>
      <td><strong>ʱ��</strong></td>
      <td><strong>�����P1������</strong></td>
      <td><strong>P2</strong></td>
      <td><strong>P3</strong></td>
      <td><strong>���޵�P1������</strong></td>
      <td><strong>P2</strong></td>
      <td><strong>P3</strong></td>
    </tr>
    <%
    for(Growline g : growlines)
    {
     %>
    <tr>
      <td><%=g.getUser().getUserid() %></td>
      <td><%=g.getCurrentime().getCurrentime() %></td>
      <td><%=g.getBuyp1growline() %></td>
      <td><%=g.getBuyp2growline() %></td>
      <td><%=g.getBuyp3growline() %></td>
      <td><%=g.getRentp1growline() %></td>
      <td><%=g.getRentp2growline() %></td>
      <td><%=g.getRentp3growline() %></td>
    </tr>
  <%} %>
  </table>

<p>&nbsp;</p>
</body>
</html>