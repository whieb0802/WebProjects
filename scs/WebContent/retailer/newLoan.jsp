<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="com.scs.model.*,com.scs.service.RoleService,org.springframework.context.support.ClassPathXmlApplicationContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	Relation relation = (Relation)session.getAttribute("relation"); 
	Role role = relation.getRole();
	
	   User user = (User) session.getAttribute("user");
       int currentime = Integer.parseInt(request.getParameter("currentime"));
       int totaloan = Integer.parseInt(request.getParameter("totaloan"));
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>�������</title>
<link rel="stylesheet" type="text/css" href="../css/window.css">
</head>
<body>
<form name="newloan" method="post" action="fundaction!newloan? %>">
  <table border="1" align="center" id="table1">
    <tr>
      <td width="106">��ǰ������</td>
      <td width="194"><input type="hidden" name="currentime" value="<%=currentime%>"/>
          <%=currentime%></td>
    </tr>
    <tr>
      <td>�û���ţ�</td>
      <td ><%=user.getUserid() %></td>
    </tr>
    <tr>
      <td height="32">������</td>
      <td><input type="hidden" name="currentmaxloan" value="<%=role.getMaxloan() - totaloan %>"/>
          <%=role.getMaxloan() - totaloan %>Ԫ</td>
    </tr>
	  <tr>
      <td>�����</td>
      <td><label>
        <input name="currentloan" type="text" size="10">
      Ԫ</label></td>
    </tr>
	  <tr>
      <td>����������</td>
      <td><label>
        <select name="loantime">
          <option>5</option>
          <option>10</option>
          <option>15</option>
          <option>20</option>
          <option>25</option>
        </select>
        ��
      </label></td>
    </tr>

    
    <tr>
      <td></td>
      <td>
      <table width="194" border="0">
  <tr>
    <td width="188" align="right"><input name="submit"  type="submit" value="�ύ"/></td>
  </tr>
       </table>
</td>
     </tr>
  </table>
</form>
<p>&nbsp;</p>
</body>
</html>