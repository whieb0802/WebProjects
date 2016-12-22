<%@ page language="java" import="java.util.*,com.scs.model.*" pageEncoding="GB18030"%>
<%@ page import="com.scs.util.page.*" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
 PageView<User> pageView = (PageView<User>) request.getAttribute("pageView");
 List<Role> role = (List<Role>)request.getAttribute("role");
 List<Area> area = (List<Area>)request.getAttribute("area");
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
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">�û��б� </SPAN><SPAN 
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
      style="WIDTH: 90%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
      border=1>
<%--      ��ɫ<select value="" >--%>
<%--      <%for(Role r:role){ %>--%>
<%--        <option selected="selected"><%=r.getRolename() %></option>--%>
<%--      <%} %>--%>
<%--       </select>--%>
<%--       --%>
<%--  ����<select value="" >--%>
<%--      <%for(Area a:area){ %>--%>
<%--        <option selected="selected"><%=a.getAreaname() %></option>--%>
<%--      <%} %>--%>
<%--       </select>--%>
      
              <TBODY>
                <TR>
                  <TH class=gridViewHeader style="WIDTH: 50px" scope=col>&nbsp;</TH>
                  <TH class=gridViewHeader scope=col>�û�Id</TH>
                  <TH class=gridViewHeader scope=col>��¼��</TH>
                  <TH class=gridViewHeader scope=col>��ʵ����</TH>
                  <TH class=gridViewHeader scope=col>����</TH>
                  <TH class=gridViewHeader scope=col>��ɫ</TH>
                  <TH class=gridViewHeader scope=col>����</TH>
                  <TH class=gridviewHeader scope=col>״̬</TH>
                </TR>
                <%for(int i=0;i<pageView.getRecords().size();i++){ %>
                <TR>
                  <TD class=gridViewItem style="WIDTH: 50px"><IMG 
            src="index.files/57.png"> </TD>
                  <TD class=gridViewItem><%=pageView.getRecords().get(i).getUserid() %></TD>
                  <TD class=gridViewItem><%=pageView.getRecords().get(i).getUsername()%></TD>
                  <TD class=gridViewItem><%=pageView.getRecords().get(i).getRealname() %></TD>
                  <TD class=gridViewItem><%=pageView.getRecords().get(i).getPassword() %></TD>
                  <TD class=gridViewItem>1</TD>
                  <TD class=gridViewItem>2</TD>
                  <TD class=gridViewItem><%=pageView.getRecords().get(i).getIscomplete() %></TD>
                </TR>
                <%} %>
              </TBODY>
              
            </TABLE>
  <p align="right"><a href="<%=basePath %>manager/userList?page=1"> ��һҳ    </a> 
                                   ��ǰ��<%=pageView.getCurrentPage()<1?1:pageView.getCurrentPage()%>ҳ    
  <a href="<%=basePath %>manager/userList?page=<%=pageView.getCurrentPage()-1%>"> ��һҳ   </a>
 <a href="<%=basePath %>manager/userList?page=<%=(pageView.getCurrentPage()+1)>pageView.getTotalPage()?pageView.getTotalPage():(pageView.getCurrentPage()+1)%>"> ��һҳ </a>
    <a href="<%=basePath %>manager/userList?page=<%=pageView.getTotalPage()%>">���һҳ</a></p>
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
