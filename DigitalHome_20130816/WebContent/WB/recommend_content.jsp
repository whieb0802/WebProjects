<%@ page contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="skin/css/main.css" />
</head>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="js/recommend_content.js"></script>

<body leftmargin="8" topmargin='8'>
	<table width="98%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><div style='float: left'>
					<img height="14" src="skin/images/frame/book1.gif" width="20" />&nbsp;欢迎使用基于内容过滤的推荐：
				</div>
				<div style='float: right; padding-right: 8px;'>
					<!--  //保留接口  -->
				</div></td>
		</tr>
		<tr>
			<td height="1" background="skin/images/frame/sp_bg.gif"
				style='padding: 0px'></td>
		</tr>
	</table>
	<table width="98%" align="center" border="0" cellpadding="4"
		cellspacing="1" bgcolor="#FFFFFF" style="margin-bottom: 8px">
		<tr bgcolor="#EEF4EA">
			<td colspan="2" background="skin/images/frame/wbg.gif" class='title' align="center"><span>基于内容过滤的推荐</span></td>
		</tr>
        
        <tr>
			<td  align="center"><span>可供点播资源列表</span></td>
            <td  align="center"><span>资源推荐列表</span></td>
		</tr>
		<tr>
			<td width="50%" align="center">
<!-- 				<table width="200" border="0" cellpadding="4" id="left" cellspacing="1"  style="margin-bottom: 8px"> -->
					<table width="300" align="center" border="0" cellpadding="4"
		cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px" id="left">
					<tr bgcolor="#FAFAF1">
						<td width="40">编号</td>
						<td>片名</td>
					</tr>
					<tr bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
						<td id="first">&nbsp;</td>
						<td id="second" style="cursor:pointer"><div onClick="introduction(this)"></div></td>
					</tr>
					<tr bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
						<td>&nbsp;</td>
						<td style="cursor:hand"><div onClick="introduction(this)"></div></td>
					</tr>
					<tr bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
						<td>&nbsp;</td>
						<td style="cursor:hand"><div onClick="introduction(this)"></div></td>
					</tr>
					<tr bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
						<td>&nbsp;</td>
						<td style="cursor:hand"><div onClick="introduction(this)"></div></td>
					</tr>
					<tr bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';"> 
						<td>&nbsp;</td>
						<td style="cursor:hand"><div onClick="introduction(this)"></div></td>
					</tr>
					<tr bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
						<td>&nbsp;</td>
						<td style="cursor:hand"><div onClick="introduction(this)"></div></td>
					</tr>
					<tr bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';"> 
						<td>&nbsp;</td>
						<td style="cursor:hand"><div onClick="introduction(this)"></div></td>
					</tr>
					<tr bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
						<td>&nbsp;</td>
						<td style="cursor:hand"><div onClick="introduction(this)"></div></td>
					</tr>
					<tr bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
						<td>&nbsp;</td>
						<td style="cursor:hand"><div onClick="introduction(this)"></div></td>
					</tr>
					<tr bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
						<td id="last">&nbsp;</td>
						<td style="cursor:hand"><div onClick="introduction(this)"></div></td>
					</tr>
				</table>

			</td>
			<td width="50%" align="center">

				<table width="300" align="center" border="0" cellpadding="4"
		cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px" id="right">
					<tr bgcolor="#FAFAF1">
						<td width="40">编号</td>
						<td><div>片名</div></td>
						<td><div>置信度</div></td>
					</tr>
				</table>

			</td>

		</tr>
		<tr>
			<td  align="center"><button onClick="page(0)">上一页</button>
				&nbsp;&nbsp;&nbsp;&nbsp;<button onClick="page(1)">下一页</button></td>
			<td></td>

		</tr>
	</table>



</body>
</html>