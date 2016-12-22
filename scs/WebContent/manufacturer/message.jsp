<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <style type="text/css">
    .msg{ margin-left: 400px;margin-top: 150px; font-size: 30; color: red}
    </style>

  </head>
  
  <body>
  	 <%--<div class="msg">
     <s:property value="#request.message"/><br/>
     <input type="button" name="sure" value="确 定" onclick="javascript:window.location.href='<s:property value="#request.siteurl"/>' " />
     </div>
    --%>
    <script language="javascript">
    	alert("<s:property escape="false" value='#request.message'/>");
    	parent.location.reload();
	    window.close(); 
    	
    </script>
     
  </body>
</html>
