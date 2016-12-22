<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.scs.model.*,java.util.List,com.scs.service.*,
	com.opensymphony.xwork2.ActionContext,org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<% 
	  Fund fund = (Fund)request.getAttribute("fund");
	  Currentime currenTime = (Currentime)request.getAttribute("currentime");
	  Relation relation = (Relation)session.getAttribute("relation");
	  User user = (User)session.getAttribute("user");
	   int roleid = relation.getRole().getRoleid();
	   int currentime = currenTime.getCurrentime();
	   int userid = user.getUserid();
	   int upstream = relation.getUpstream();
	   int currentmoney = fund.getCurrentmoney();
	   String username = user.getUsername();
%>
<head>
<title>3CProduct供应链虚拟平台</title>
<script id="script" type="text/javascript" src="../javascript/winhead.js?id=0"></script>
<script type="text/javascript">
<!--
function bzjsConfirm(){
	if(confirm('是否结束本周并且扣除费用（如贷款利息、仓库租金，库存成本等）?')) 
	  { 
	    createwin('测试的窗口3','useraction!dqjs?userid=<%=userid%>&roleid=<%=roleid%>&currentime=<%=currentime%>',17,heighs/2-450/2,widths/2-750/2,400,250,0,0,0);
	  } 
	  return false; 
	} 
function bzksConfirm(){
	if(confirm('是否开始本周?')) 
	  { 
	    createwin('测试的窗口3','useraction!dqks?userid=<%=userid%>&roleid=<%=roleid%>',18,heighs/2-450/2,widths/2-750/2,400,250,0,0,0);
	  } 
	  return false; 
	} 
-->
</script>
<link href="../css/label.css" rel="stylesheet" type="text/css">
<link href="../css/font.css" rel="stylesheet" type="text/css">
<link href="../css/layers.css" rel="stylesheet" type="text/css">
</head>
<body scroll="no" style="border:none;" ondragstart="return false" onSelectStart="return false" onResize="return false" >
<object   id="max"   type="application/x-oleobject"   classid="clsid:adb880a6-d8ff-11cf-9377-00aa003b7a11">     <param   name="Command"   value="Maximize">
</object> 
<script id="script" type="text/javascript" src="../javascript/winbody.js"></script>

<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#CCCCCC">
  <tr>
    <td colspan="3" height="90"><img src="../images/index_top_bg.png" width="100%" height="90" /></td>
  </tr>
  <tr>
    <td colspan="3" valign="top" height="40"><img src="../images/top_line.png" width="100%" height="40"></td>
  </tr>
  <tr>
    <td valign="top" width="322"><img src="../images/left_bg.gif" width="322" height="578"></td>
    <td valign="top" bgcolor="#EEEEEE">
    <table width="680" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
    <br></td>
    <td width="400" valign="top"  bgcolor="#EEEEEE">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><img src="../images/icon01.gif" width="84" height="84"  ondblclick="createwin('查看历史订单信息','orderaction!selectOrder?userid=<%=userid%>&roleid=<%=roleid%>&upstream=<%=upstream %>&current=<%=currentime %>&my=3',1,heighs/2-450/2,widths/2-750/2,800,500,0,0,0)"></td>
        <td>&nbsp;</td>
        <td><img src="../images/icon02.gif" alt="" width="84" height="84"  ondblclick="createwin('查看每周库存信息','inventoryaction!findall?userid=<%=userid%>&error=3',2,heighs/2-450/2,widths/2-750/2,800,500,0,0,0)"></td>
        <td>&nbsp;</td>
        <td><img src="../images/icon03.gif" width="84" height="84"  ondblclick="createwin('测试的窗口3','testwin.jsp',3,heighs/2-450/2,widths/2-750/2,800,500,0,0,0)"></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td align="center" class="right01">订单信息</td>
        <td>&nbsp;</td>
        <td align="center" class="right01">库存信息</td>
        <td>&nbsp;</td>
        <td align="center" class="right01">市场预测</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="30">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><img src="../images/icon04.gif" width="84" height="84"  ondblclick="createwin('测试的窗口4','testwin.jsp',4,heighs/2-450/2,widths/2-750/2,800,500,0,0,0)"></td>
        <td>&nbsp;</td>
        <td><img src="../images/icon05.gif" alt="" width="84" height="84"  ondblclick="createwin('查看本周利润表','profitaction?userid=<%=userid%>&currentime=<%=currentime %>&roleid=<%=roleid %>&error=3',5,heighs/2-450/2,widths/2-750/2,800,500,0,0,0)"></td>
        <td>&nbsp;</td>
        <td><img src="../images/icon06.gif" width="84" height="84"  ondblclick="createwin('查看仓库信息','storageaction!info?userid=<%=userid%>&currentime=<%=currentime %>&error=3',6,heighs/2-450/2,widths/2-750/2,800,500,0,0,0)"></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td align="center" class="right01">同组信息</td>
        <td>&nbsp;</td>
        <td align="center" class="right01">利润表</td>
        <td>&nbsp;</td>
        <td align="center" class="right01">仓库信息</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="30">&nbsp;</td>
        <td>&nbsp;</td>
        <td align="center" class="right01">&nbsp;</td>
        <td>&nbsp;</td>
        <td align="center" class="right01">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><img src="../images/icon07.gif" width="84" height="84"  ondblclick="createwin('查看历史销售信息','billaction!selectBill?userid=<%=userid%>&current=<%=currentime %>&error=3',7,heighs/2-450/2,widths/2-750/2,800,500,0,0,0)"></td>
        <td>&nbsp;</td>
        <td><img src="../images/icon08.gif" alt="" width="84" height="84"  ondblclick="createwin('查看资产负债表','equityaction?userid=<%=userid%>&currentime=<%=currentime %>&roleid=<%=roleid %>&error=3',8,heighs/2-450/2,widths/2-750/2,800,500,0,0,0)"></td>
        <td>&nbsp;</td>
        <td><img src="../images/icon09.gif" width="84" height="84"  ondblclick="createwin('查看规则','rules.jsp',9,heighs/2-450/2,widths/2-750/2,800,500,0,0,0)"></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td align="center" class="right01">销售信息</td>
        <td>&nbsp;</td>
        <td align="center" class="right01">权益表</td>
        <td>&nbsp;</td>
        <td align="center" class="right01">规则说明</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
<div id="top01"><img src="../images/logo_top.png" width="223" height="108"></div>
<div id="top02"><img src="../images/title_top.png" width="284" height="47"></div>
<div id="left01"><img src="../images/left_01.gif" width="88" height="88"></div>
<div id="left02"><img src="../images/left_02.gif" width="176" height="53"></div>
<div id="left03"><img src="../images/left_03.gif" width="309" height="54" border="0" usemap="#Map">
  <map name="Map">
    <area shape="rect" coords="90,14,211,48" href="#">
  </map>
</div>
<div id="left04" class="left01"><div align="center"><%=username %></div></div>
<div id="left05" class="left01"><div align="center">代理商</div></div>
<div id="left06" class="left01"><div align="center"><strong style=" font-size:20px;color:#FF0000"><%=currentmoney%></strong>&nbsp;元</div></div>
<div id="left07" class="left01">
  <div align="center">第&nbsp;&nbsp;<strong style=" font-size:14px;color:#FF0000"><%=currentime%></strong>&nbsp;&nbsp;周</div></div>
<div id="main01" class="left01"><img src="../images/main_bg.png" width="332" height="428"></div>
<div id="main00" class="left01"><img src="../images/00_2.gif" width="98" height="98"></div>
<div id="main02" class="left01"><img src="../images/01_1.png" width="98" height="98" onDblClick="createwin('申请贷款','newLoan.jsp?totaloan=<%=fund.getTotaloan()%>&currentime=<%=currentime%>&error=3',11,heighs/2-250/2,widths/2-550/2,400,250,0,0,0)"></div>
<div id="main03" class="left01"><img src="../images/02_1.png" width="98" height="98" onDblClick="createwin('仓库租买','storage.jsp?currentime=<%=currentime%>&error=3',12,heighs/2-250/2,widths/2-550/2,400,250,0,0,0)"></div>
<div id="main04" class="left01"><img src="../images/03_1.png" width="98" height="98" onDblClick="createwin('商品入库','inventoryaction!retailerincome?current=<%=currentime%>&userid=<%=userid%>&roleid=<%=roleid%>&up=<%=upstream%>&error=zkz',13,heighs/2-250/2,widths/2-550/2,400,250,0,0,0)"></div>
<div id="main05" class="left01"><img src="../images/04_1.png" width="98" height="98" onDblClick="createwin('商品出售','agentaction!outcome?current=<%=currentime%>&userid=<%=userid %>&error=3',15,heighs/2-250/2,widths/2-550/2,800,550,0,0,0)"></div>
<div id="main06" class="left01"><img src="../images/05_1.png" width="98" height="98" onDblClick="createwin('更新应收款','agentaction!addfund?current=<%=currentime%>&userid=<%=userid%>&roleid=<%=roleid%>&error=3',14,heighs/2-250/2,widths/2-550/2,400,250,0,0,0)"></div>
<div id="main07" class="left01"><img src="../images/06_1.png" width="98" height="98" onDblClick="createwin('发出订单','newOrder.jsp?currentime=<%=currentime%>&upstream=<%=upstream%>',16,heighs/2-250/2,widths/2-550/2,400,250,0,0,0)"></div>
<div id="main08" class="left01"><img src="../images/07_1.png" width="98" height="98" onDblClick="bzjsConfirm()" ></div>
<div id="main09" class="left01"><img src="../images/start.png"  onDblClick="bzksConfirm()" ></div>


<div id="smenu" class='smenu'>
  <table cellpadding="0" cellspacing="0" border="0" style="padding-top:2px;" height="100%">
  <tr>
   <td><img src='../images/btn-left.gif' border='0' onClick="document.getElementById('minkang').scrollLeft-=170" style="cursor:hand"><img src='../images/btn-right.gif' border='0' onClick="document.getElementById('minkang').scrollLeft+=170" style="cursor:hand"></td>
   <td><div style="position:relative;width:expression(document.body.clientWidth-53);overflow-y:hidden;overflow-x:hidden;" id="minkang"><table cellpadding="0" cellspacing="0" border="0"><tr id="trs"><td></td></tr></table></div></td>
  </tr>
 </table>
</div>
</body>
</html>
