<%@ page contentType="text/html; charset=gb2312" language="java" 
import="java.sql.*,com.scs.model.Bill,com.scs.model.Relation" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
   Bill bill = (Bill) request.getAttribute("bill");
   int currentime = Integer.parseInt(request.getAttribute("current").toString());
%>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�ޱ����ĵ�</title>
<style type="text/css">
<!--
#form1 td {
	font-family: "����";
	font-size: 10px;
}
-->
</style>
	
<script type="text/javascript">

function bill(){
	window.location.href="inventoryaction!rbillconfirm?billtime=<%=bill.getCurrentime().getCurrentime()%>&current=<%=currentime%>";
}

</script>
<link rel="stylesheet" type="text/css" href="../css/window.css"/>
</head>
<body>
     <table  id="table1" width="302"  border="1" align="center">
            <tr>
              <td width="71">��Ʒ��</td>
              <td width="95">����</td>
              <td width="114">ֱ�ӳɱ�</td>
            </tr>
            <tr>
              <td>P1</td>
              <td ><span style="color:#FF0000"><%=bill.getCountp1()%></span>��</td>
              <td><span style="color:#FF0000"><%=bill.getP1price()%></span>
Ԫ</td>
            </tr>
            <tr>
              <td>P2</td>
              <td><span style="color:#FF0000"><%=bill.getCountp2()%></span>
                ��</td>
              <td><span style="color:#FF0000"><%=bill.getP2price()%></span>
Ԫ</td>
            </tr>
            <tr>
              <td>P3</td>
              <td><span style="color:#FF0000"><%=bill.getCountp3()%></span>
��</td>
              <td><span style="color:#FF0000"><%=bill.getP3price()%></span>
Ԫ</td>
            </tr>
          </table>
          <table width="244" border="0" align="center">
            <tr>
              <td width="161" height="25">&nbsp;</td>
              <td width="67"><input type="button" onclick="bill()" value="ȷ��" /></td>
            </tr>
          </table>

</body>
</html>
