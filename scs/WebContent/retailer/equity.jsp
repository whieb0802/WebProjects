<%@ page language="java" import="java.util.*,com.scs.model.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%  

Report report = (Report)request.getAttribute("profit");
    int currentime = Integer.parseInt(request.getAttribute("currentime").toString());
    int currentMoney = report.getCurrentmoney();
    int totaloan = report.getTotalloan();
    int productMoney = report.getProductstoragevalue();
	int storageMoney = report.getStoragevalue();
	int profitleft = report.getProfitleft();
	int tax = report.getTax();
	int profit = report.getCurrentmoney();
	
	//�ɶ��ʱ�
	int initialMoney = report.getInitialcapital();;
	//Ӧ�տ�
	int receivable = report.getReceivableMoney();
	//��е�豸
	int machine = report.getGrowlinevalue();
	//�����ʲ��ϼ�
	int flowMoney = currentMoney + productMoney + receivable;
	//�̶��ʲ��ϼ�
	int fixedMoney = storageMoney + machine;
	//�ʲ��ܼ�
	int totalfund = flowMoney + fixedMoney;
	//��ծ�ϼ�
	int loan = totaloan + tax;
	//������Ȩ��ϼ�
	int totalequity = initialMoney + profitleft + profit;
	//��ծ��Ȩ��ϼ�
	int loanAndequity = totalequity + loan;
	

 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�鿴�ʲ���ծ��</title>
    
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
    <table width="400" border="1" cellspacing="2" cellpadding="2">
  <tr>
    <td colspan="4"><div align="center">��<%=currentime %>���ʲ���ծ��</div></td>
  </tr>
  <tr>
    <td width="250">�ֽ�</td>
    <td width="100"><%=currentMoney %></td>
    <td width="250">��ծ</td>
    <td width="100"><%=totaloan %></td>
  </tr>
  <tr>
    <td>Ӧ�տ�</td>
    <td><%=receivable %></td>
    <td>����˰</td>
    <td><%=tax %></td>
  </tr>
  <tr>
    <td>�ɲ�Ʒ</td>
    <td><%=productMoney %></td>
    <td><strong>��ծ�ϼ�</strong></td>
    <td><%=loan %></td>
  </tr>
  <tr>
    <td><strong>�����ʲ��ϼ�</strong></td>
    <td><%=flowMoney %></td>
    <td>�ɶ��ʱ�</td>
    <td><%=initialMoney %></td>
  </tr>
  <tr>
    <td>�ֿ�</td>
    <td><%=storageMoney %></td>
    <td>��������</td>
    <td><%=profitleft %></td>
  </tr>
  <tr>
    <td>��е�豸</td>
    <td><%=machine %></td>
    <td>���ھ���</td>
    <td><%=profit %></td>
  </tr>
  <tr>
    <td><strong>�̶��ʲ��ϼ�</strong></td>
    <td><%=fixedMoney %></td>
    <td><strong>������Ȩ��ϼ�</strong></td>
    <td><%=totalequity %></td>
  </tr>
  <tr>
    <td><strong>�ʲ��ܼ�</strong></td>
    <td><%=totalfund %></td>
    <td><strong>��ծ��Ȩ���ܼ�</strong></td>
    <td><%=loanAndequity %></td>
  </tr>
</table>
  </body>
</html>
