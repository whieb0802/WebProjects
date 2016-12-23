$(document).ready(function(){
	var value = new Array();
	var jsonData = "{\"page\":\""+0+"\"}";
	$.post("/DigitalHome/WB/templateAction!getAllItem",{json:jsonData},function(data){
		$.each( data, function(i, n){
      		value[i] = n;
      	});
		showLeftItem(value);
		var div = $("#second").children().eq(0);
		introduction(div);
	},"json");
	
});

//显示左边电影条目
function showLeftItem(value){
	var tr = $("#left").children().children();
	for(var i=0;i<10;i++){
		var nowTr = tr.eq(i+1);
		var td = nowTr.children();
		td.eq(0).text(value[i*3+0]);
		td.eq(1).children().attr("id",value[i*3+0]);
		td.eq(1).children().text(value[i*3+1]);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		td.eq(2).text(value[i*3+2]);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	}
}

//上一页下一页点击事件
function page(num){
	var value = new Array();
	var page ;
	if(num == 0){
		 page = $("#first").text() - 11;
		 if(page == 1)
			 page = 0;
			 }
	else 
		 page = $("#last").text();
	
	var jsonData = "{\"page\":\""+page+"\"}";
	$.post("/DigitalHome/WB/templateAction!getAllItem",{json:jsonData},function(data){
		$.each( data, function(i, n){
      		value[i] = n;
      	});
		showLeftItem(value);
	},"json");
}

function introduction(div){
	var itemId = $(div).attr("id");
	var jsonData = "{\"id\":\""+ itemId +"\"}";
	var value = new Array();
	$.post("/DigitalHome/WB/templateAction!getNextData",{json:jsonData},function(data){
		$.each( data, function(i, n){
      		value[i] = n;
      	});
		showRightItem(value);
	},"json");
}

function showRightItem(value){
	var tb = $("#right");
	var trAll = tb.children().children();
	var num = trAll.size();
	if(value[0] == 0){
		for(var i=1;i<num;i++)
			trAll.eq(i).remove();
		alert("抱歉，没有结果可以推荐！");
		}
	else
	{
		var sum = value.length/3;
		var tr = trAll.eq(0);
		if( num > 2){
			for(var i=1;i<num;i++)
				trAll.eq(i).remove();
		}
		for(var i=0;i<sum;i++){
			var nowTr = tr.clone();
			var td = nowTr.children();
			td.eq(0).text(value[i*3+0]);
			td.eq(1).children().text(value[i*3+1]);
			td.eq(2).children().text(value[i*3+2]);
			nowTr.appendTo(tb);
		}
		}
	}