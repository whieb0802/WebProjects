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
	
	//股东资本
	int initialMoney = report.getInitialcapital();;
	//应收款
	int receivable = report.getReceivableMoney();
	//机械设备
	int machine = report.getGrowlinevalue();
	//流动资产合计
	int flowMoney = currentMoney + productMoney + receivable;
	//固定资产合计
	int fixedMoney = storageMoney + machine;
	//资产总计
	int totalfund = flowMoney + fixedMoney;
	//负债合计
	int loan = totaloan + tax;
	//所有者权益合计
	int totalequity = initialMoney + profitleft + profit;
	//负债和权益合计
	int loanAndequity = totalequity + loan;
	

 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看资产负债表</title>
    
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
    <td colspan="4"><div align="center">第<%=currentime %>期资产负债表</div></td>
  </tr>
  <tr>
    <td width="250">现金</td>
    <td width="100"><%=currentMoney %></td>
    <td width="250">负债</td>
    <td width="100"><%=totaloan %></td>
  </tr>
  <tr>
    <td>应收款</td>
    <td><%=receivable %></td>
    <td>所得税</td>
    <td><%=tax %></td>
  </tr>
  <tr>
    <td>成产品</td>
    <td><%=productMoney %></td>
    <td><strong>负债合计</strong></td>
    <td><%=loan %></td>
  </tr>
  <tr>
    <td><strong>流动资产合计</strong></td>
    <td><%=flowMoney %></td>
    <td>股东资本</td>
    <td><%=initialMoney %></td>
  </tr>
  <tr>
    <td>仓库</td>
    <td><%=storageMoney %></td>
    <td>利润留存</td>
    <td><%=profitleft %></td>
  </tr>
  <tr>
    <td>机械设备</td>
    <td><%=machine %></td>
    <td>本期净利</td>
    <td><%=profit %></td>
  </tr>
  <tr>
    <td><strong>固定资产合计</strong></td>
    <td><%=fixedMoney %></td>
    <td><strong>所有者权益合计</strong></td>
    <td><%=totalequity %></td>
  </tr>
  <tr>
    <td><strong>资产总计</strong></td>
    <td><%=totalfund %></td>
    <td><strong>负债和权益总计</strong></td>
    <td><%=loanAndequity %></td>
  </tr>
</table>
  </body>
</html>
