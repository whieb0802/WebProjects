<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript">
	
	function checkInput()
	{
		
		var cp1=document.getElementById("bill.countp1").value;
		var cp2=document.getElementById("bill.countp2").value;
		var cp3=document.getElementById("bill.countp3").value;
		var rd1=document.getElementById("random1").value;
		var rd2=document.getElementById("random2").value;
		var rd3=document.getElementById("random3").value;
		
		if(cp1 > rd1 ||cp2 > rd2|| cp3 > rd3){
			alert("出库量不能大于需求量！");
			document.getElementById("bill.countp1").focus();
			return false;
		}
		else
		    return true;
	}	
</script>





<script type="text/javascript">
	
	function checkInput()
	{
		
		var cp1=document.getElementById("bill.countp1").value;
		var cp2=document.getElementById("bill.countp2").value;
		var cp3=document.getElementById("bill.countp3").value;
		var rd1=document.getElementById("random1").value;
		var rd2=document.getElementById("random2").value;
		var rd3=document.getElementById("random3").value;
		
		if(cp1 > rd1 ||cp2 > rd2 ){
			alert("P1出库量不能大于需求量！");
			document.getElementById("bill.countp1").focus();
			return false;
		}

	    if(){
			alert("P2出库量不能大于需求量！");
			document.getElementById("bill.countp2").focus();
			return false;
		}

		if(cp3 > rd3){
			alert("P3出库量不能大于需求量！");
			document.getElementById("bill.countp3").focus();
			return false;
		}
		else
		    return true;
	}	
</script>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'outcomejs.jsp' starting page</title>
    
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
    This is my JSP page. <br>
  </body>
</html>
