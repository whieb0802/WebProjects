<%@ page language="java" import="java.util.*,com.scs.model.*" pageEncoding="GB18030"%>
<%@ page import="com.scs.util.page.*" %>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	List<Role> list = (List<Role>)request.getAttribute("list");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<HTML>
<HEAD>
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css> 
{
	FONT-SIZE: 12px
}
.gridView {
	BORDER-RIGHT: #bad6ec 1px; BORDER-TOP: #bad6ec 1px; BORDER-LEFT: #bad6ec 1px; COLOR: #566984; BORDER-BOTTOM: #bad6ec 1px; FONT-FAMILY: Courier New
}
.gridViewHeader {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BACKGROUND-IMAGE: url(images/bg_th.gif); BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 27px; BORDER-BOTTOM: #bad6ec 1px solid
}
.gridViewItem {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 32px; BORDER-BOTTOM: #bad6ec 1px solid; TEXT-ALIGN: center
}
.cmdField {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(images/bg_rectbtn.png); OVERFLOW: hidden; BORDER-LEFT: 0px; WIDTH: 67px; COLOR: #364c6d; LINE-HEIGHT: 27px; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 27px; BACKGROUND-COLOR: transparent; TEXT-DECORATION: none
}
.buttonBlue {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(images/bg_button_blue.gif); BORDER-LEFT: 0px; WIDTH: 78px; COLOR: white; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 21px
}
</STYLE>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>
<BODY 
style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(images/bg.gif); BACKGROUND-REPEAT: repeat-x">

<DIV>
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR 
  style="BACKGROUND-IMAGE: url(images/bg_header.gif); BACKGROUND-REPEAT: repeat-x" 
  height=47>
        <TD width=10><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
        <TD><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN><SPAN 
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">角色参数设置</SPAN><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hr.gif); WIDTH: 60px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
        <TD 
    style="BACKGROUND-POSITION: 50% bottom; BACKGROUND-IMAGE: url(images/main_rc.gif)" 
    width=10></TD>
      </TR>
      <TR>
        <TD style="BACKGROUND-IMAGE: url(images/main_ls.gif)">&nbsp;</TD>
        <TD 
    style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; COLOR: #566984; PADDING-TOP: 10px; BACKGROUND-COLOR: white" 
    vAlign=top align="center">
          <DIV>
          
            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
      style="WIDTH:100%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
      border=1>
              <TBODY>
                <TR>
                
                  <TH class=gridViewHeader style="WIDTH: 50px" scope=col>角色</TH>
                  <TH class=gridViewHeader scope=col>初始资金</TH>
                  <TH class=gridViewHeader scope=col>初始p1</TH>
                  <TH class=gridViewHeader scope=col>初始p2</TH>
                  <TH class=gridViewHeader scope=col>初始p3</TH>
                  <TH class=gridViewHeader scope=col>小厂房</TH>
                  <TH class=gridViewHeader scope=col>中厂房</TH>
                  <TH class=gridViewHeader scope=col>大厂房</TH>
                  <TH class=gridViewHeader scope=col>p1生产线</TH>
                  <TH class=gridViewHeader scope=col>p2生产线</TH>
                  <TH class=gridViewHeader scope=col>p3生产线</TH>
                  <TH class=gridViewHeader scope=col>最大贷款</TH>
                   <TH class=gridViewHeader scope=col>利率</TH>
                   <TH class=gridViewHeader scope=col></TH>
                
                </TR>
               <%for(int i=0;i<3;i++){ %>
                <form action="" name="f<%=i %>" method="post">
                <TR>
                   <input type="hidden" name="roleid" value="<%=i+1 %>"/>
                  <TD class=gridViewItem ><%=list.get(i).getRolename()%></TD>
                  <TD class=gridViewItem><input type="text" name="initialmoney" size="4" value="<%=list.get(i).getInitialmoney()%>"/>&nbsp;个</TD>
                  <TD class=gridViewItem><input type="text" name="initialp1" size="4" value="<%=list.get(i).getInitialp1() %>"/>&nbsp;个</TD>
                  <TD class=gridViewItem><input type="text" name="initialp2" size="4" value="<%=list.get(i).getInitialp2() %>"/>&nbsp;个</TD>
                  <TD class=gridViewItem><input type="text" name="initialp3" size="4" value="<%=list.get(i).getInitialp3() %>"/>&nbsp;个</TD>
                  <TD class=gridViewItem><input type="text" name="smallStorage" size="4" value="<%=list.get(i).getSmallStorage()%>"/>&nbsp;个</TD>
                  <TD class=gridViewItem><input type="text" name="middleStorage" size="4" value="<%=list.get(i).getMiddleStorage() %>"/>&nbsp;个</TD>
                  <TD class=gridViewItem><input type="text" name="bigStorage" size="4" value="<%=list.get(i).getBigStorage() %>"/>&nbsp;个</TD>
                  <TD class=gridViewItem><input type="text" name="p1growline" size="4" value="<%=list.get(i).getP1growline()%>"/>&nbsp;条</TD>
                  <TD class=gridViewItem><input type="text" name="p2growline" size="4" value="<%=list.get(i).getP2growline() %>"/>&nbsp;条</TD>
                  <TD class=gridViewItem><input type="text" name="p3growline" size="4" value="<%=list.get(i).getP3growline() %>"/>&nbsp;条</TD>
                  <TD class=gridViewItem><input type="text" name="maxloan" size="6" value="<%=list.get(i).getMaxloan() %>"/>&nbsp;元</TD>
                  <TD class=gridViewItem><input type="text" name="interestrate" size="6" value="<%=list.get(i).getInterestrate()%>"/></TD>
                  <TD class=gridViewItem><input type="button" onclick="javascript:document.f<%=i %>.action='roleParamUpdate';document.f<%=i %>.submit()" class=cmdField 
            id=ctl00_ContentPlaceHolder2_GridView1_ctl02_LinkButton1 value="设置" /></TD>  
                </TR> </form>
                <%} %>
              </TBODY>
            </TABLE>
          </DIV>
        </TD>
        <TD style="BACKGROUND-IMAGE: url(images/main_rs.gif)"></TD>
      </TR>
      <TR 
  style="BACKGROUND-IMAGE: url(images/main_fs.gif); BACKGROUND-REPEAT: repeat-x" 
  height=10>
        <TD style="BACKGROUND-IMAGE: url(images/main_lf.gif)"></TD>
        <TD style="BACKGROUND-IMAGE: url(images/main_fs.gif)"></TD>
        <TD 
style="BACKGROUND-IMAGE: url(images/main_rf.gif)"></TD>
      </TR>
    </TBODY>
  </TABLE>
</DIV>

</BODY>
</HTML>

</html>
