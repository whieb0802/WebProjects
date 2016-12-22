 var cssUrl="../css/blue.css";
 var colors = "#3362B2";
 document.write('<link id="cssStyle" href=\"'+cssUrl+'\" rel="stylesheet" type="text/css" />'); 
 function changeStyle(sty)
 {
  if(sty=="blue")
     colors = "#3362B2";
  else
     colors = "#B4B4B4";
  document.getElementById("cssStyle").href =sty+".css";
 }

 var s = document.getElementsByTagName("script");
     s = s[s.length - 1];
 var tdid = s.getAttribute("src").split("=")[1];