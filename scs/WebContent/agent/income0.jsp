<%@ page contentType="text/html; charset=gb2312" language="java" 
import="java.sql.*,com.scs.model.Bill" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
   Bill bill = (Bill) request.getAttribute("bill");
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
function winOpen(strURL,strName,width,height)
{
    theWindow = window.open(strURL,strName,"width="+width+" height="+height+" scrollbars=yes left="+(1024-width)/2+" top="+(768-height)/2);	
    if (theWindow.opener == null) theWindow.opener = window;
    if (window.focus) theWindow.focus();
}


function billConfrim4(){
	opener.location.reload();
	  window.close(); 
}


function billConfrim2()
{
	window.opener.location.href = window.opener.location.href;     
if (window.opener.progressWindow)    
   {       
	window.opener.progressWindow.close();     
	}   
  window.close(); 
}

</script>
<script type="text/javascript">
function billConfirm000(){
	winOpen('inventoryaction!rbillconfirm?userid=<%=bill.getBto()%>&currentime=<%=bill.getCurrentime().getCurrentime()%>&upstream=<%=bill.getBfrom()%>','�б�',450,300);
}
</script>
</head>
<body>
     <table width="302"  border="1" align="center">
            <tr>
              <td width="71">��Ʒ��</td>
              <td width="95">����</td>
              <td width="114">����</td>
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
              <td width="67"><input type="button" onclick="billConfrim000()" value="ȷ��" /></td>
            </tr>
          </table>

</body>
</html>
