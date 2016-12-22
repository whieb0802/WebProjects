<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/rule.css" rel="stylesheet" type="text/css" />
<link href="css/font.css" rel="stylesheet" type="text/css">
<link href="css/label.css" rel="stylesheet" type="text/css">
</head>

<body topmargin="0" leftmargin="0">
<table width="64%" height="379" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td class="rule3"><div align="center">3C产品供应链模拟规则说明</div></td>
  </tr>
  <tr>
    <td><span class="rule1">3、融资</span></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="1" cellspacing="1" class="ruletab" bgcolor="#00CCFF">
      <tr>
        <td width="12%" bgcolor="#FFFFFF" class="ruletab"><div align="center">贷款类型</div></td>
        <td width="13%" bgcolor="#FFFFFF" class="ruletab"><div align="center">贷款时间</div></td>
        <td width="15%" bgcolor="#FFFFFF" class="ruletab"><div align="center">贷款额度</div></td>
        <td width="31%" bgcolor="#FFFFFF" class="ruletab"><div align="center">利息</div></td>
        <td width="29%" bgcolor="#FFFFFF" class="ruletab"><div align="center">还款方式</div></td>
        </tr>
      <tr>
        <td bgcolor="#FFFFFF" class="ruletab"><div align="center">长期贷款</div></td>
        <td bgcolor="#FFFFFF" class="ruletab"><div align="center">每年年初</div></td>
        <td rowspan="2" bgcolor="#FFFFFF" class="ruletab"><div align="center">和为权益三倍</div>          <div align="center"></div></td>
        <td bgcolor="#FFFFFF" class="ruletab"><div align="center">10%</div></td>
        <td bgcolor="#FFFFFF" class="ruletab"><div align="center">年初付息，到期还本，10倍数</div></td>
        </tr>
      <tr>
        <td bgcolor="#FFFFFF" class="ruletab"><div align="center">短期贷款</div></td>
        <td bgcolor="#FFFFFF" class="ruletab"><div align="center">每季度初</div></td>
        <td bgcolor="#FFFFFF" class="ruletab"><div align="center">5%</div></td>
        <td bgcolor="#FFFFFF" class="ruletab"><div align="center">到期一次还本付息，20倍数</div></td>
        </tr>
      <tr>
        <td bgcolor="#FFFFFF" class="ruletab"><div align="center">资金贴现</div></td>
        <td bgcolor="#FFFFFF" class="ruletab"><div align="center">任何时间</div></td>
        <td bgcolor="#FFFFFF" class="ruletab"><div align="center">视应收款额</div></td>
        <td bgcolor="#FFFFFF" class="ruletab"><div align="center">1/8（3季，4季），1/10（1季，2季）</div></td>
        <td bgcolor="#FFFFFF" class="ruletab"><div align="center">变现时贴息</div></td>
        </tr>
      <tr>
        <td bgcolor="#FFFFFF" class="ruletab"><div align="center">拍卖库存</div></td>
        <td colspan="4" bgcolor="#FFFFFF" class="ruletab"><div align="left">原材料八折，成品原价</div></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><span class="rule1">12、实际选单从第2年起，市场预测表中第1年需求量及价格数据仅仅起占位作用，实际有效预测数据从第2年开始。</span></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><span class="rule1">13、按订单交货可以提前，但不可以推后，违约收回订单并扣违约金。</span></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><span class="rule1">14、取整规则：违约金扣除——向下取整；库存拍卖所得现金——向下取整；贴现费用——向上取整；扣税——向下取整。</span></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><span class="rule1">15、库存折价拍卖，生产线变卖，紧急采购，订单违约记入其他损失。</span></td>
  </tr>
</table>
</body>
</html>
