<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="com.scs.model.*,java.util.List"%>
    <%
    int userid = Integer.parseInt(request.getParameter("userid"));
    int currentime = Integer.parseInt(request.getAttribute("current").toString());
	List<Growlineinfo> growlineinfos = (List<Growlineinfo>)request.getAttribute("growlineinfos");

   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>制定下一批生产计划</title>
<link rel="stylesheet" type="text/css" href="../css/window.css">
</head>
<body>
<form name="form1" method="post" action="manufactureraction!produce?userid=<%=userid %>&current=<%=currentime %>">
  <table width="624" height="155" align="center" border="2">
   
    <tr>
      <th height="20" colspan="6" align="center" bgcolor="#CCCCCC" ><span class="newproduct">制定下一批生产计划</span></th>
    </tr>
    <tr>
      <td width="77" bgcolor="#CCCCCC"><span class="newproduct"><strong>生产线</strong></span></td>
      <td width="109" bgcolor="#CCCCCC"><span class="newproduct"><strong>本周生产数量</strong></span></td>
      <td width="93" bgcolor="#CCCCCC"><span class="newproduct"><strong>最大生产数</strong></span></td>
      <td width="99" bgcolor="#CCCCCC"><span class="newproduct"><strong>扩大产能生产数</strong></span></td>
      <td width="76" bgcolor="#CCCCCC"><span class="newproduct"><strong>扩能投资</strong></span></td>
      <td width="128" bgcolor="#CCCCCC">&nbsp;</td>
    </tr>
    <tr>
      <td bgcolor="#CCCCCC"><span class="newproduct">P1生产线1</span></td>
      <td bgcolor="#CCCCCC" ><span class="newproduct">
        <input name="countp1" type="text" id="countp1" size="6"/>
      个</span></td>
      <td bgcolor="#CCCCCC" ><span class="newproduct"><%=growlineinfos.get(0).getCapacity() %></span></td>
      <td bgcolor="#CCCCCC" ><span class="newproduct"><%=growlineinfos.get(0).getLargeredcapacity() %></span></td>
      <td bgcolor="#CCCCCC" ><span class="newproduct"><%=growlineinfos.get(0).getLargerprice() %></span></td>
      <td bgcolor="#CCCCCC" ><span class="newproduct">
        <input name="button" type="submit" id="button" value="扩大产能"/>
      </span></td>
    </tr>
    <tr>
      <td bgcolor="#CCCCCC"><span class="newproduct">P2生产线1</span></td>
      <td bgcolor="#CCCCCC"><span class="newproduct">
        <input name="countp2" type="text" id="countp2" size="6"/>
个</span></td>
      <td bgcolor="#CCCCCC" ><span class="newproduct"><%=growlineinfos.get(1).getCapacity() %></span></td>
      <td bgcolor="#CCCCCC" ><span class="newproduct"><%=growlineinfos.get(1).getLargeredcapacity() %></span></td>
      <td bgcolor="#CCCCCC" ><span class="newproduct"><%=growlineinfos.get(1).getLargerprice() %></span></td>
      <td bgcolor="#CCCCCC"><span class="newproduct">
        <input name="button2" type="submit" id="button2" value="扩大产能"/>
      </span></td>
    </tr>
    <tr>
      <td bgcolor="#CCCCCC"><span class="newproduct">P3生产线1</span></td>
      <td bgcolor="#CCCCCC"><span class="newproduct">
        <input name="countp3" type="text" id="countp3" size="6"/>
个</span></td>
      <td bgcolor="#CCCCCC" ><span class="newproduct"><%=growlineinfos.get(2).getCapacity() %></span></td>
      <td bgcolor="#CCCCCC" ><span class="newproduct"><%=growlineinfos.get(2).getLargeredcapacity() %></span></td>
      <td bgcolor="#CCCCCC" ><span class="newproduct"><%=growlineinfos.get(2).getLargerprice() %></span></td>
      <td bgcolor="#CCCCCC"><span class="newproduct">
        <input name="button3" type="submit" id="button3" value="扩大产能"/>
      </span></td>
    </tr>
    <tr>
      <td bgcolor="#CCCCCC"></td>
      <td bgcolor="#CCCCCC">&nbsp;</td>
      <td bgcolor="#CCCCCC">&nbsp;</td>
      <td bgcolor="#CCCCCC">&nbsp;</td>
      <td bgcolor="#CCCCCC">&nbsp;</td>
      <td bgcolor="#CCCCCC"><span class="newproduct">
        <input name="submit" type="submit" value="提交"/>
      </span></td>
    </tr>
  </table>
</form>
<p>&nbsp;</p>
</body>
</html>