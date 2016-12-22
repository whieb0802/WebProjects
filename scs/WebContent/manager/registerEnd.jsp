<%@ page language="java" import="java.util.*,com.scs.model.*"
	pageEncoding="GB18030"%>
<%@ page import="com.scs.util.page.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<HTML>
		<HEAD>
			<TITLE>Untitled Page</TITLE>
			<META http-equiv=Content-Type content="text/html; charset=utf-8">
			<STYLE type=text/css>
{
FONT-SIZE:12px
}
.gridView {
	BORDER-RIGHT: #bad6ec 1px;
	BORDER-TOP: #bad6ec 1px;
	BORDER-LEFT: #bad6ec 1px;
	COLOR: #566984;
	BORDER-BOTTOM: #bad6ec 1px;
	FONT-FAMILY: Courier New
}

.gridViewHeader {
	BORDER-RIGHT: #bad6ec 1px solid;
	BORDER-TOP: #bad6ec 1px solid;
	BACKGROUND-IMAGE: url(images/bg_th.gif);
	BORDER-LEFT: #bad6ec 1px solid;
	LINE-HEIGHT: 27px;
	BORDER-BOTTOM: #bad6ec 1px solid
}

.gridViewItem {
	BORDER-RIGHT: #bad6ec 1px solid;
	BORDER-TOP: #bad6ec 1px solid;
	BORDER-LEFT: #bad6ec 1px solid;
	LINE-HEIGHT: 32px;
	BORDER-BOTTOM: #bad6ec 1px solid;
	TEXT-ALIGN: center
}

.cmdField {
	BORDER-RIGHT: 0px;
	BORDER-TOP: 0px;
	BACKGROUND-IMAGE: url(images/bg_rectbtn.png);
	OVERFLOW: hidden;
	BORDER-LEFT: 0px;
	WIDTH: 67px;
	COLOR: #364c6d;
	LINE-HEIGHT: 27px;
	BORDER-BOTTOM: 0px;
	BACKGROUND-REPEAT: repeat-x;
	HEIGHT: 27px;
	BACKGROUND-COLOR: transparent;
	TEXT-DECORATION: none
}

.buttonBlue {
	BORDER-RIGHT: 0px;
	BORDER-TOP: 0px;
	BACKGROUND-IMAGE: url(images/bg_button_blue.gif);
	BORDER-LEFT: 0px;
	WIDTH: 78px;
	COLOR: white;
	BORDER-BOTTOM: 0px;
	BACKGROUND-REPEAT: no-repeat;
	HEIGHT: 21px
}
</STYLE>
			<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
		</HEAD>
		<BODY
			style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(images/bg.gif); BACKGROUND-REPEAT: repeat-x">
			<DIV>
				<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%"
					border=0>
					<TBODY>
						<TR style="BACKGROUND-IMAGE: url(images/bg_header.gif); BACKGROUND-REPEAT: repeat-x" height=47>
							<TD width=10>
								<SPAN
									style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN>
							</TD>
							<TD>
								<SPAN
									style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN><SPAN
									style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0 px: ">用户注册结束
								</SPAN><SPAN
									style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hr.gif); WIDTH: 60px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN>
							</TD>
							<TD
								style="BACKGROUND-POSITION: 50% bottom; BACKGROUND-IMAGE: url(images/main_rc.gif)"
								width=10></TD>
						</TR>
						<TR>
							<TD style="BACKGROUND-IMAGE: url(images/main_ls.gif)">
								&nbsp;
							</TD>
							<TD
								style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; COLOR: #566984; PADDING-TOP: 10px; BACKGROUND-COLOR: white"
								vAlign=top align="middle">
								<DIV>
								<br><br><br><br><br><br>点击注册结束后，用户就不能再进行注册
								<br><A class=cmdField 
                      id=ctl00_ContentPlaceHolder2_GridView1_ctl02_LinkButton1 
            onclick="return confirm('确定要结束吗？');" 
            href="registerEnd1?currentime=0">注册结束</A> 
								</DIV>
							</TD>
							<TD style="BACKGROUND-IMAGE: url(images/main_rs.gif)"></TD>
						</TR>
						<TR
							style="BACKGROUND-IMAGE: url(images/main_fs.gif); BACKGROUND-REPEAT: repeat-x"
							height=10>
							<TD style="BACKGROUND-IMAGE: url(images/main_lf.gif)"></TD>
							<TD style="BACKGROUND-IMAGE: url(images/main_fs.gif)"></TD>
							<TD style="BACKGROUND-IMAGE: url(images/main_rf.gif)"></TD>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
		</BODY>
	</HTML>

</html>

