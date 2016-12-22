//�����ȡ��Ļ�ߺͿ�
 var widths = document.body.clientWidth;
 var heighs = document.body.clientHeight;
 function $(_sId){return document.getElementById(_sId);}
 function moveStart (event, _sId, wd, hg){
   var oObj = $(_sId);
   oObj.onmousemove = mousemove;
   oObj.onmouseup = mouseup;
   oObj.setCapture ? oObj.setCapture() : function(){};
   oEvent = window.event ? window.event : event;
   var dragData = {x : oEvent.clientX, y : oEvent.clientY};
   var backData = {x : parseInt(oObj.style.top), y : parseInt(oObj.style.left)};

   function mousemove(){
    var oEvent = window.event ? window.event : event;
    var iLeft = oEvent.clientX - dragData["x"] + parseInt(oObj.style.left);   
    var iTop = oEvent.clientY - dragData["y"] + parseInt(oObj.style.top);
    if(iLeft>widths-wd)iLeft=widths-wd; //�ұ߾�
    if(iTop>heighs-hg)iTop=heighs-hg;   //�ױ߾�
    if(iLeft<0)iLeft=0;
    if(iTop<0)iTop=0;
    oObj.style.left = iLeft;
    oObj.style.top = iTop;
    dragData = {x: oEvent.clientX, y: oEvent.clientY};  
   }
   
   function mouseup(){
    var oEvent = window.event ? window.event : event;
    oObj.onmousemove = null;
    oObj.onmouseup = null;
    oObj.releaseCapture ? oObj.releaseCapture() : function(){};
   }
 }

//�������
function maxsize(w, h, winname, fulls){
    document.getElementById("outsize"+winname).style.cssText="position:absolute; top:0px; left:0px;";          //���ڶ��ߺ����λ��
    document.getElementById("fram"+winname).style.height = h;
    document.getElementById("hig"+winname).style.display = "block";      //��ʾ���ص�iframe
    document.getElementById("hidvar"+winname).value = w;
    self["oTable"+winname].width = w;
    self["hig"+winname].height = h - 26;
    document.getElementById("chpic"+winname).className="max";
    document.getElementById("minpic"+winname).className="sma";
    moveUp(winname,fulls);                                              //����Ϊ��ǰ����
}

//���ڷ�ԭ
function resize(t, l, w, h, winname, max, fulls){
  if(tdid==0){
    document.getElementById("tds"+winname).innerHTML = "";               //ȡ��ԭ��С���Ĵ���
    document.getElementById("outsize"+winname).style.display = "block";  //��ԭ�����Ĵ�����ʾ
    }
    document.getElementById("outsize"+winname).style.cssText="position:absolute; top:"+t+"px; left:"+l+"px";  //���ڶ��ߺ����λ��
    self["oTable"+winname].width = w;
    document.getElementById("hig"+winname).style.display = "block";      //��ʾ���ص�iframe
    self["hig"+winname].height = h;
    document.getElementById("fram"+winname).style.height = h+26;
    document.getElementById("fram"+winname).style.width = w;
    document.getElementById("chpic"+winname).className="min";
    document.getElementById("minpic"+winname).className="sma";           //��ԭʱ��ʾ��С��ʱͼƬ
    if(max == 0){
       document.getElementById("chpic"+winname).style.display = "block"; //��ԭʱ��ʾ���ͼƬ
    }
    document.getElementById("hidvar"+winname).value = 0;                 //0��ʾ����С��״̬
    moveUp(winname,fulls);                                               //����Ϊ��ǰ����
}

//������С��
function minsize(winname){      
    self["oTable"+winname].width = 170;
    document.getElementById("hig"+winname).style.display = "none";      //���ؼ��ص�iframe
    document.getElementById("fram"+winname).style.height = 26;
    document.getElementById("fram"+winname).style.width = 170;
    document.getElementById("chpic"+winname).className="min";
    document.getElementById("minpic"+winname).className="max";         //��С��ʱʹ����󻯰�Ť
    document.getElementById("chpic"+winname).style.display = "none";   //��С��ʱ������󻯰�Ť
    document.getElementById("hidvar"+winname).value = 1;               //1��ʾ��С��״̬
  if(tdid==0){
    var ks = document.getElementById("outsize"+winname).innerHTML;
    ks = "<div id=\"intd"+winname+"\" style=\"position:relative;top:0px;\">"+ ks +"</div>"
    document.getElementById("tds"+winname).innerHTML = ks;             //�ڵײ���ʾ��С���Ĵ���
    document.getElementById("outsize"+winname).style.display = "none"; //��ԭ�����Ĵ�������
    }
}

//���ڹر�
function closewin(winname){
    document.getElementById("outsize"+winname).style.display = "none";
    //���DIV
    var divs = document.getElementById("test"+winname);
    var pardiv = divs.parentNode;
    pardiv.removeChild(divs);
    //���INPUT
    var inps = document.getElementById("hidvar"+winname);
    var parinp = inps.parentNode;
    parinp.removeChild(inps);
    //�����Ԫ��
 if(tdid==0){
    var tdds = document.getElementById("tds"+winname);
    var partd = tdds.parentNode;
    partd.removeChild(tdds);
    }
}

//���д���˳��
var divNo = 0;
function moveUp(tid,fulls)
{
    var colordiv=document.getElementsByTagName("iframe");
    for(i in colordiv){
        if(typeof colordiv[i].id!='undefined'){
           var numb = i.replace(/\D/gi,"");
           document.getElementById("hig"+numb).style.backgroundColor="#D1D8EC";
        }
    }
    document.getElementById("hig"+tid).style.backgroundColor=colors;
    divNo++;
    if(fulls == 1)
       document.getElementById("fswin"+tid).style.zIndex=divNo;
    else
       document.getElementById("outsize"+tid).style.zIndex=divNo;
}

//����һ��DIV��INPUT��TD����ʱ��ű���
function init(numb){
  var h = heighs-26;
  var div1=document.createElement("<div>");
  div1.display="none";
  div1.id = "test"+numb;
  var inp1=document.createElement("<input type='hidden' id='hidvar"+numb+"' name='hidvar"+numb+"' value=0>");
if(tdid==0){
  var tdcol=document.createElement("<td id='tds"+numb+"'>");
  }
  document.body.appendChild(div1);
  document.body.appendChild(inp1);
if(tdid==0){
   document.getElementById("trs").appendChild(tdcol);
   tdcol=null;
  }
  div1=null;
  inp1=null;
}

//���ڱ���,��ַ,��������,�ϱ߾�,��߾�,��,��,��С��(Ϊ1����ʾ),���(Ϊ1����ʾ),������ǰ����(Ϊ1��ʾ����)
function createwin(titles,url,winname,tops,lefts,wid,hig,min,max,fulls){
  var fs="",fa="",higs="";
  if(fulls==1){
     var fs = "style=\"position:absolute;top:0;left:0;width:100%;height:96%;\"";
     var fa = "<iframe id=\"gb"+winname+"\" style=\"position:absolute;z-index:-1;top:0;left:0;width:102%;height:96%;filter:alpha(opacity=30);\" frameBorder=0></iframe>";
  }
  if(tdid==0)
     higs=hig+54;
  else
     higs=hig+26;
  var wincount = "<div id=\"fswin"+winname+"\" "+fs+" onmousedown=\"moveUp("+winname+","+fulls+")\">"+fa+"<div id=\"outsize"+winname+"\" style='position:absolute;top:"+tops+"px;left:"+lefts+"px;width:"+wid+"px;height:"+hig+"px;'>"+
             "<iframe id=\"fram"+winname+"\" style='position:absolute;z-index:-1;top:0;left:0;width:100%;height:100%;padding-top:1px;padding-left:1px;'></iframe>"+
             "<table border='0' width='100%' height='100%' cellspacing='0' cellpadding='0' id=\"oTable"+winname+"\" >"+
             "<tr><td width='6'><span class='lpic'></span></td><td height='26' width='98%' class='uder1' onmousedown=\"if(document.getElementById('hidvar"+winname+"').value==0)moveStart(event,'outsize"+winname+"',"+wid+","+higs+")\"><div class=\"tits\" title='"+titles+"'><NOBR><span class='font'>"+titles+"&nbsp;</span></NOBR></div></td><td class=\"uder\"><div class='sma' id=\"minpic"+winname+"\" onclick=\"if(document.getElementById('hidvar"+winname+"').value==1){resize("+tops+","+lefts+","+wid+","+hig+","+winname+","+max+","+fulls+");} else{minsize("+winname+");}\"></div></td><td class=\"uder\"><div id=\"chpic"+winname+"\" class=\"min\" onclick=\"if(document.getElementById('hidvar"+winname+"').value>0){resize("+tops+","+lefts+","+wid+","+hig+","+winname+","+max+","+fulls+");} else{maxsize("+widths+","+heighs+","+winname+","+fulls+");}\"></div></td><td class=\"uder\"><span class='cpic' onclick=\"closewin("+winname+")\"></span></td><td width='6'><span class='rpic'></span></td></tr>"+
             "<tr align='center'><td height='"+hig+"' id=\"hig"+winname+"\" colspan='6' class='cons'><iframe id=\"frPage"+winname+"\" src=\""+url+"?winname="+winname+"&fsid="+fulls+"\" frameborder='0' width='100%' height='100%' scrolling='no'></iframe></td></tr>"+
             "</table></div></div>";
  //�жϴ����Ƿ�Ҳ����
    var okshow=false;
    var allinp=document.getElementsByTagName("input");
        for(i in allinp){
        if(typeof allinp[i].name!='undefined' && allinp[i].type=="hidden" && allinp[i].name=="hidvar"+winname+""){
           okshow=true;
           break;
        }
    }
    if(okshow==false){
       init(winname);
       document.getElementById("test"+winname).innerHTML = wincount;
    }
    else{//����ԭ����
       resize(tops,lefts,wid,hig,winname,max,fulls);
    }
    moveUp(winname,fulls);
    if(min == 1){
       document.getElementById("minpic"+winname).style.display = "none"; //��С����Ť����
    }
    if(max == 1){
       document.getElementById("chpic"+winname).style.display = "none";  //��󻯰�Ť����
    }
 }