<%@ page language="java" import="java.util.*,com.scs.model.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.scs.util.page.*" %>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List<Demand> list = (List<Demand>)request.getAttribute("list");
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
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">市场需求设置 </SPAN><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hr.gif); WIDTH: 60px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
        <TD 
    style="BACKGROUND-POSITION: 50% bottom; BACKGROUND-IMAGE: url(images/main_rc.gif)" 
    width=10></TD>
      </TR>
      <TR>
        <TD style="BACKGROUND-IMAGE: url(images/main_ls.gif)">&nbsp;</TD>
        <TD 
    style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; COLOR: #566984; PADDING-TOP: 10px; BACKGROUND-COLOR: white" 
    vAlign=top align=center>
          <DIV>
            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
      style="WIDTH: 90%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
      border=1>
      
              <TBODY>
                <TR>
                
                  <TH class=gridViewHeader scope=col>周期</TH>
                  <TH class=gridViewHeader scope=col>p1最小需求</TH>
                  <TH class=gridViewHeader scope=col>p1最大需求</TH>
                  <TH class=gridViewHeader scope=col>p2最小需求</TH>
                  <TH class=gridViewHeader scope=col>p2最大需求</TH>
                  <TH class=gridViewHeader scope=col>p3最小需求</TH>
                  <TH class=gridViewHeader scope=col>p3最大需求</TH>
                  <TH class=gridViewHeader scope=col></TH>
                
                </TR>
               <%for(int i=0;i<10;i++){ %>
                <form action="" name="f<%=i %>" method="post">
                <TR>
                   <input type="hidden" name="demandid" value="<%=i+1 %>"/>
                  <TD class=gridViewItem>
                  <%=(i+1)%>-<%=(i+5) %>
                  </TD>
                  <TD class=gridViewItem><input type="text" name="p1mindemand" size="4" value="<%=list.get(i).getP1mindemand()%>"/>&nbsp;个</TD>
                  <TD class=gridViewItem><input type="text" name="p1maxdemand" size="4" value="<%=list.get(i).getP1maxdemand() %>"/>&nbsp;个</TD>
                  <TD class=gridViewItem><input type="text" name="p2mindemand" size="4" value="<%=list.get(i).getP2mindemand() %>"/>&nbsp;个</TD>
                  <TD class=gridViewItem><input type="text" name="p2maxdemand" size="4" value="<%=list.get(i).getP2maxdemand() %>"/>&nbsp;个</TD>
                  <TD class=gridViewItem><input type="text" name="p3mindemand" size="4" value="<%=list.get(i).getP3mindemand()%>"/>&nbsp;个</TD>
                  <TD class=gridViewItem><input type="text" name="p3maxdemand" size="4" value="<%=list.get(i).getP3maxdemand()%>"/>&nbsp;个</TD>
                  <TD class=gridViewItem><input type="button" onclick="javascript:document.f<%=i %>.action='demandUpdate';document.f<%=i %>.submit()" class=cmdField 
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
<SCRIPT type=text/javascript>

</SCRIPT>
</BODY>
</HTML>

</html>
