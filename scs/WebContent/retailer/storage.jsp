<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="com.scs.model.*"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    User user = (User) session.getAttribute("user");
    Relation relation = (Relation) session.getAttribute("relation");
    int roleid = relation.getRole().getRoleid();
    int currentime = Integer.parseInt(request.getParameter("currentime"));
    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>�ֿ�����</title>
</head>
<body>
<script type="text/javascript">
 function confirm1(){
    var type1 = document.getElementById("rentype").value;
     alert("��ȷ��Ҫ��"+ type1 +"��"��);
 }
 
 function confirm2(){
    var type2 = document.getElementById("buytype").value;
     alert("��ȷ��Ҫ��"+type2+"��"��);
 }

</script>
<div align="center" style="border-top: 50px">
<table bgcolor="lavender" border="0" style="height: 50px��width:60%">
  <tr height="50" >
    <th colspan="3" style="width: 234px; height: 21px">�ֿ�����</th>
  </tr>
  <form action="storageaction!rentStorage?currentime=<%=currentime %>"  method="post" >
  <tr style="height: 35px">
    <th>
        ��ֿ������    
    </th>
    <th>
      <select name="rentype" id="rentype" style="width: 83px; height: 26px">
         <option>С�ֿ�</option>
         <option>�вֿ�</option>
         <option>��ֿ�</option>
      </select>
    </th>
    <td  style="height: 28px"><input name="submit" type="submit" onclick="return confirm1();" value="ȷ��" style="width: 100px; height: 27px"/></td>
  </tr>
  </form>
  <form action="storageaction!buyStorage?currentime=<%=currentime %>"  method="post" >
   <tr style="height: 35px">
    <th>
       ��ֿ������    
    </th>
    <th>
      <select name="buytype" id="buytype" style="width: 83px; height: 26px">
         <option>С�ֿ�</option>
         <option>�вֿ�</option>
         <option>��ֿ�</option>
      </select>
    </th>
    <td style="height: 28px"><input name="submit" type="submit" onclick="confirm2();" value="ȷ��" style="width: 100px; height: 27px"/></td>
  </tr>
  </form>
</table>

</div>

<p>&nbsp;</p>
</body>
</html>
