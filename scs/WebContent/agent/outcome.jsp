<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@page import="java.sql.*,java.util.List" %>
<%@page import="com.scs.model.*,com.scs.service.*" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�ޱ����ĵ�</title>
<style type="text/css">
<!--
#form1 td {
	font-family: "����";
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
        
       
		<h2 align="center">���������̶������۳�����Ʒ</h2>
          <table width="687" height="162" border="1" align="center">
            <tr>
              <th align="center"><strong>����ʱ��</strong></th>
              <th align="center"><strong>�û����</strong></th>
              <th align="center"><strong>P1����</strong></th>
              <th align="center"><strong>P1����</strong></th>
              <th align="center"><strong>P1���۸���</strong></th>
              <th align="center"><strong>P2����</strong></th>
              <th align="center"><strong>P2����</strong></th>
              <th align="center"><strong>P2���۸���</strong></th>
              <th align="center"><strong>P3����</strong></th>
              <th align="center"><strong>P3����</strong></th>
              <th align="center"><strong>P3���۸���</strong></th>
              <th align="center">�ύ          </th>     
            </tr>
            
            <s:if test="#request.orders.size == 0"> 
 			<tr>
          		 <th colspan="12" align="center">������û�п��Դ���Ķ���</th>
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
��</td>
              <td align="center"><%=orders.get(i).getCountp2() %></td>
              <td align="center"><%=orders.get(i).getP2price() %></td>
              <td align="center"><input name="countp2"  type="text" size="5" />
��</td>
              <td align="center"><%=orders.get(i).getCountp3() %></td>
              <td align="center"><%=orders.get(i).getP3price() %></td>
              <td align="center"><input name="countp3"  type="text" size="5" />
                ��</td>
              <td align="center"><label>
                <input type="submit" name="Submit" value="ȷ��" />
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
