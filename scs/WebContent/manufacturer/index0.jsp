<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK" import="com.scs.model.*,java.util.List,com.scs.service.*,org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	   ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
       FundService fundService  = (FundService)ctx.getBean("fundService");
       CurrentimeService currentimeService  = (CurrentimeService)ctx.getBean("currentimeService");
       
	   
	   User user = (User) session.getAttribute("user");
	   List<Currentime> list2 = currentimeService.findCurrentime("from Currentime");
	   Currentime currenTime = list2.get(list2.size()-1);
	   Relation relation = (Relation)session.getAttribute("relation");
       int roleid = relation.getRole().getRoleid();
	   List<Fund> funds = fundService.findFund("from Fund f where f.user = ? and f.currentime = ?",new Object[]{user,currenTime});
	   Fund fund = funds.get(0);
	   
	   int currentime = currenTime.getCurrentime();
	   int userid = user.getUserid();
	   int upstream = relation.getUpstream();
	   int currentmoney = fund.getCurrentmoney();
	   String username = user.getUsername();
%>
<head>
<title>代理商</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link type="text/css" href="../css/retailerindex.css" rel="stylesheet"/>
<script type="text/javascript" src="../js/index.js"></script>	
<script type="text/javascript">

function winOpen(strURL,strName,width,height)
{
    theWindow = window.open(strURL,strName,"width="+width+" height="+height+" scrollbars=yes left="+(1024-width)/2+" top="+(768-height)/2);	
    if (theWindow.opener == null) theWindow.opener = window;
    if (window.focus) theWindow.focus();
}
function bzjsConfirm(){
	if(confirm('是否结束本周并且扣除费用（如贷款利息、仓库租金，库存成本等）?')) 
	  { 
	    winOpen('useraction!dqjs?userid=<%=userid%>&roleid=<%=roleid%>','列表','450','300');
	  } 
	  return false; 
	} 
function bzksConfirm(){
	if(confirm('是否开始本周?')) 
	  { 
	    winOpen('useraction!dqks?userid=<%=userid%>','列表','0','0');
	  } 
	  return false; 
	} 
</script>
</head>
	<body onLoad="onload();">
	
	
		<div class="container">
			<div id="banner"><img src="../images/banner.jpg" width="100%" height="91"></div>
			<div id="header">
				<div id="active">
					<ul class="topnav">
						<li>
							<a href="#">当前期数：<strong style=" font-size:14px;color:#FF0000"><%=currentime%></strong></a>
						</li>
						<li></li>
						<li>
							<a href="#">编&nbsp;号&nbsp;<strong style=" font-size:14px;color:#FF0000"><%=userid%></strong></a>
						</li>
						<li></li>
						<li>
							<a href="#">Welcome, <strong style=" font-size:14px;color:#FF0000"><%=username%></strong></a>
						</li>
						<li></li>
						<li>
							<a href="../login.jsp">退&nbsp;出&nbsp;</a>
						</li>
					</ul>
			  </div>
				<div id="actor">
					<p><span class="STYLE2" style="cursor: hand">角色：生产商</span></p>
					<p><span class="STYLE2" style="cursor: hand">当前资金：<strong style=" font-size:20px;color:#FF0000"><%=currentmoney%></strong></span> </p>
				</div>
				<div id="body">
					<div id="navigation">
<div class="box">
<ul id="tabMenu">
  <li class="posts selected"></li>
  <li class="comments"></li>
  <li class="category"></li>
  <li class="famous">&nbsp;</li>
  <li class="random">&nbsp;</li>
</ul>
<div class="boxTop"></div>

<div class="boxBody">
  
  <div class="show">
    <ul>
	   <li class="STYLE4"><input type="submit"  onClick="bzksConfirm()" value="本周开始"/>
	   </li>
       <li class="STYLE4"><font>&nbsp;&nbsp;&nbsp;&nbsp;↓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;↓</font></li>
	   <li class="STYLE4">
	     <input type="button" onClick="javaScript:winOpen('newLoan.jsp?currentime=<%=currentime%>&totaloan=<%=fund.getTotaloan() %>','列表',450,200)" value="申请贷款"/>
	     </li>
       <li class="STYLE4"><font>&nbsp;&nbsp;&nbsp;&nbsp;&darr;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&darr;</font></li>
       <li class="STYLE4">
         <input name="button" type="button" onClick="javaScript:winOpen('manufactureraction!factoryinfo?roleid=<%=roleid%>&current=<%=currentime %>','列表',650,500)" value="厂房租买"/>
	     <br>
	     </li>
	   <li class="STYLE4"><font>&nbsp;&nbsp;&nbsp;&nbsp;↓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;↓</font></li>
	   <li class="STYLE4">
	     <input type="button" onClick="javaScript:winOpen('newGrowline.jsp?currentime=<%=currentime%>','列表',600,500)" value="生产线租买"/>
	     </li>
       <li class="STYLE4"><font>&nbsp;&nbsp;&nbsp;&nbsp;&darr;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&darr;</font></li>
       <li class="STYLE4"><input name="button2" type="button" onClick="javaScript:winOpen('inventoryaction!retailerincome?current=<%=currentime%>&userid=<%=userid%>&roleid=<%=roleid%>&upstream=<%=upstream%>','列表',450,200)" value="商品入库"/>
       </li>
	   <li class="STYLE4"><font>&nbsp;&nbsp;&nbsp;&nbsp;↓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;↓</font></li>
	   <li class="STYLE4">
	     <input name="button5" type="button" onClick="javaScript:winOpen('growlineaction!large?current=<%=currentime%>&userid=<%=userid %>','列表',800,700)" value="下一批生产"/>
	     </li>
	   <li class="STYLE4"><font>&nbsp;&nbsp;&nbsp;&nbsp;↓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;↓</font></li>
	   <li class="STYLE4">
	     <input type="button" onClick="javaScript:winOpen('agentaction!outcome?current=<%=currentime%>&userid=<%=userid %>','列表',450,200)" value="商品出售"/>
	   </li>
	   <li class="STYLE4"><font>&nbsp;&nbsp;&nbsp;&nbsp;↓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;↓</font></li>
	   <li class="STYLE4"><input type="button" onClick="javaScript:winOpen('agentaction!addfund?current=<%=currentime%>&userid=<%=userid%>&roleid=<%=roleid%>','列表',450,300)" value="更新应收款"/></li>
       <li class="STYLE4"><font>&nbsp;&nbsp;&nbsp;&nbsp;↓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;↓</font></li>
	   <li class="STYLE4"> <input type="button"  onClick="bzjsConfirm()" value="本周结束"></li>
	</ul>
  </div> 
</div>
</div></div>
<div class="boxBottom"></div> 
    <div id="do"></div>
	<div id="dd"></div>
	<div id="test"></div>
</div>
</div>
		</div>

	<div id="Layer1">
	  <ul class="topnav2">
	
	    <p>
	      <input type="button" onClick="javaScript:winOpen('manufactureraction!info?userid=<%=userid%>&current=<%=currentime %>','列表',700,600)" value="查看厂房信息"/>
        </p>
	    <p>
	      <input type="button" onClick="javaScript:winOpen('growlineaction!info?userid=<%=userid%>&current=<%=currentime %>','列表',700,600)" value="查看生产线信息"/>
        </p>
	    <p>
	      <input type="button" onClick="javaScript:winOpen('orderaction!selectOrder?userid=<%=userid%>&current=<%=currentime %>&upstream=<%=upstream %>','列表',700,600)" value="查看生产信息"/>
        </p>
	    <p>
	      <input name="button3" type="button" onClick="javaScript:winOpen('billaction!selectBill?userid=<%=userid%>&current=<%=currentime %>','列表',700,600)" value="查看销售信息"/>
</p>
	    <p>    
	    <input type="button" onClick="javaScript:winOpen('inventoryaction!findall?userid=<%=userid%>','列表',450,300)" value="查看库存信息"/>
	  </p>
	   <p>
	    <input type="button" onClick="javaScript:winOpen('profitaction?userid=<%=userid%>&currentime=<%=currentime %>&roleid=<%=roleid %>','列表',450,300)" value="查看利润表"/>
       </p>
        <p>
	    <input type="button" onClick="javaScript:winOpen('equityaction?userid=<%=userid%>&currentime=<%=currentime %>&roleid=<%=roleid %>','列表',450,300)" value="查看权益表"/>
       </p>
	    <p>
          <input name="button4" type="button" onClick="javaScript:winOpen('rules.jsp','列表',800,650)" value="规则说明"/>
          <s:debug/>
      </p>
	  </ul>
	</div>
	</body>
</html>
