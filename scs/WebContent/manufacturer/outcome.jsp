<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@page import="java.sql.*,java.util.List" %>
<%@page import="com.scs.model.*,com.scs.service.*" %>
<%@taglib prefix="s" uri="/struts-tags"%>
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
-->
</style>
<link href="../css/agent.css" rel="stylesheet" type="text/css" />
</head>
<%
User user = (User) session.getAttribute("user");
Relation relation = (Relation)session.getAttribute("relation");   
List<Order> orders = (List<Order>)request.getAttribute("orders");   
List<Bill> bills = (List<Bill>)request.getAttribute("bills");   
%>
<body>
        
       
		<h2 align="center">根据零售商订单报价出售商品</h2>
          <table width="687" height="162" border="1" align="center">
            <tr>
              <th align="center"><strong>订单时间</strong></th>
              <th align="center"><strong>用户编号</strong></th>
              <th align="center"><strong>P1数量</strong></th>
              <th align="center"><strong>P1报价</strong></th>
              <th align="center"><strong>P1出售个数</strong></th>
              <th align="center"><strong>P2数量</strong></th>
              <th align="center"><strong>P2报价</strong></th>
              <th align="center"><strong>P2出售个数</strong></th>
              <th align="center"><strong>P3数量</strong></th>
              <th align="center"><strong>P3报价</strong></th>
              <th align="center"><strong>P3出售个数</strong></th>
              <th align="center">提交          </th>     
            </tr>
            
            <s:if test="#request.orders.size == 0"> 
 			<tr>
          		 <th colspan="12" align="center">本周已没有可以处理的订单</th>
           </tr>
          </s:if>                 
   <s:elseif test="#request.orders.size != 0">  
            
   <%
  for(int i = 0;i < orders.size(); i++)
  {
  %>
            <form action="agentaction!outcome2?bfrom=<%=user.getUserid()%>&bto=<%=orders.get(i).getOfrom()%>&current=<%=orders.get(i).getCurrentime().getCurrentime()+1 %>&roleid=<%=relation.getRole().getRoleid() %>" method="post" name="form1" id="form1">
            <input type="hidden" name="p1price" value="<%=orders.get(i).getP1price() %>"/>
            <input type="hidden" name="p2price" value="<%=orders.get(i).getP2price() %>"/>
            <input type="hidden" name="p3price" value="<%=orders.get(i).getP3price() %>"/>
            <input type="hidden" name="p1lack" value="<%=orders.get(i).getCountp1() %>"/>
            <input type="hidden" name="p2lack" value="<%=orders.get(i).getCountp2() %>"/>
            <input type="hidden" name="p3lack" value="<%=orders.get(i).getCountp3() %>"/>
           
            <tr>
              <td align="center"><%=orders.get(i).getCurrentime().getCurrentime() %></td>
              <td align="center"><%=orders.get(i).getOfrom() %></td>
              <td align="center"><%=orders.get(i).getCountp1() %></td>
              <td align="center"><%=orders.get(i).getP1price() %></td>
              <td align="center"><input name="countp1"  type="text" size="5" />
个</td>
              <td align="center"><%=orders.get(i).getCountp2() %></td>
              <td align="center"><%=orders.get(i).getP2price() %></td>
              <td align="center"><input name="countp2"  type="text" size="5" />
个</td>
              <td align="center"><%=orders.get(i).getCountp3() %></td>
              <td align="center"><%=orders.get(i).getP3price() %></td>
              <td align="center"><input name="countp3"  type="text" size="5" />
                个</td>
              <td align="center"><label>
                <input type="submit" name="Submit" value="确定" />
              </label></td>
            </tr>
             </form>
       
       
           
                    <%
          
          }
            %>
        </s:elseif>  
          </table>
          
             <p>&nbsp;</p>


</body>
</html>
