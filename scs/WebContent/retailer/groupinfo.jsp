<%@ page language="java" import="java.util.*,com.scs.model.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
   List<Relation> list = (List<Relation>)request.getAttribute("list");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>同组信息查看</title>
    
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
   <table align="center" border="1" cellpadding="1" cellspacing="1">
        <%for(Relation r:list){%>
        	<tr>
        	   <td><%=r.getRole().getRolename() %></td>
        	    <td><%=r.getUser().getUsername() %></td>
        	</tr>
       <% } %>
   </table>
   
  </body>
</html>
