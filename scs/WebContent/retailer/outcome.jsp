<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="java.sql.*,java.util.List" %>
<%@page import="com.scs.model.*,com.scs.service.*" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
#form1 td {
	font-family: "宋体";
	font-size: 12px;
}
.STYLE1 {color: #FF0000}
-->
</style>
<link rel="stylesheet" type="text/css" href="../css/window.css">
</head>
<%
Consume consume = (Consume)request.getAttribute("consume");  
int p1price = Integer.parseInt(request.getAttribute("p1price").toString());
int p2price = Integer.parseInt(request.getAttribute("p2price").toString());
int p3price = Integer.parseInt(request.getAttribute("p3price").toString());
%>
<body>
        
        <form action="inventoryaction!retaileroutcome?current=<%=consume.getCurrentime().getCurrentime() %>" method="post" name="form1" id="form1">
         
         <input name="p1price" type="hidden" size="6" value="<%=p1price %>" />
         <input name="p2price" type="hidden" size="6" value="<%=p2price %>" />
         <input name="p3price" type="hidden" size="6" value="<%=p3price %>" />
          
          <table width="381" height="114" border="1" align="center"id="table1">
             <tr align="center">
              <td width="44" align="center">产品名</td>
              <td width="98" align="center">需求量</td>
              <td width="96" align="center">出库量</td>
              <td width="100" align="center">统一价</td>
            </tr>
            <tr>
              <td align="center">P1</td>
              <td align="center"><span style="color:#FF0000"><input type="hidden" name="p1lack"  value="<%=consume.getP1demand()%>" /><%=consume.getP1demand()%></span>
                个</td>
              <td align="center"><input name="countp1" id="bill.countp1" type="text" size="5" />
                个</td>
              <td align="center"><span class="STYLE1">            
              <%=p1price %>
              元</span></td>
            </tr>
           
           
            <tr>
              <td align="center">P2</td>
              <td align="center"><span style="color:#FF0000"><input type="hidden" value="<%=consume.getP2demand()%>" name="p2lack"  /><%=consume.getP2demand()%></span>
                个</td>
              <td align="center"><input name="countp2"  type="text" size="5" />
                个</td>
              <td align="center"><span class="STYLE1">
            
              <%=p2price%>
              元</span></td>
            </tr>
            
            
            <tr>
              <td align="center">P3</td>
              <td align="center"><span style="color:#FF0000"><input type="hidden" name="p3lack"  value="<%=consume.getP3demand()%>" /><%=consume.getP3demand()%></span>
                个</td>
              <td align="center"><input name="countp3" type="text" size="5" />
                个</td>
              <td align="center"><span class="STYLE1">
   
              <%=p3price %>
              元</span></td>
            </tr>
          </table>
          <table width="372" border="0" align="center">
            <tr>
              <td width="28" height="25"><input name="" type="hidden"/></td>
              <td width="334" align="right">销售总金额：</td>
            </tr>
          </table>
          <table width="369" height="31" border="0" align="center">
            <tr>
              <td width="25" height="25"></td>
              <td width="334" align="right"><input type="submit" name="Submit2"  value="提交" /></td>
            </tr>
          </table>
          <p>&nbsp;</p>
        </form>

</body>
</html>
