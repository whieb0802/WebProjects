<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,com.scs.model.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
   User user = (User) request.getAttribute("user");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
测试页面dddddddddd<%=user.getPassword() %>
</body>
</html>