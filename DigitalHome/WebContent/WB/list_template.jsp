<%@ page contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>业务模版</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="skin/css/main.css" />
</head>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="js/template.js"></script>
<body>
请定制您的业务模版：<br />
<div id="first">第一步：
<select name="">
     <option id=""></option>
      </select>
 <div id="second">下一步：</div>
</div>
<button name="add" id="add" onClick="add()">添加</button>
<button name="save" id="save" onClick="save()">保存</button>
<button name="new" id="new" onClick="reNew()">初始话</button>

<div id=last>
</div>
</body>
</html>