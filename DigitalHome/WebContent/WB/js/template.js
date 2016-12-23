var value = new Array(); //全局变量，存放下拉菜单可选项

$(document).ready(function(){
	 $("#second").hide();
	 $.post("/DigitalHome/WB/templateAction!init",null,function(data){
		 $.each( data, function(i, n){
	      		value[i] = n;
	      	});
		var selectAll = $("select");
		var size = value.length/2;
		var option = selectAll.children().eq(0);
		for(var i=0;i<size;i++){
				option.attr("value",value[i*2]);
				option.text(value[i*2+1]);
				option.appendTo(selectAll.eq(0));
				option = option.clone(true);
		}
	 },"json");
	 message();
});

function add(){
	var size = value.length/2;
	var selectAll = $("select");
	var selSize = selectAll.size();
	if(selSize == size)
		alert("已达模版添加上限！");
	else
		{
		var count = size - selSize; //可添加选项的数量
		var id = selectAll.eq(selSize-1).val();  //注意：该行与下行交换会出现问题，怀疑是clone方法导致的
		var sel = selectAll.eq(selSize-1).clone();
		for(var i=0;i<sel.children().size();i++){
			var content = sel.children().eq(i).val();
			if(content == id)
			     sel.children().eq(i).remove();
		}
		var newSel = sel;
		var second = $("#second").clone(true);
		second.show();
		newSel.appendTo(second);
		second.appendTo($("#first"));
		}
}

function save(){
	var data = "{";
	var select = $("select");
	//判断是否有重复的选项
	for(var i=0;i<select.size();i++){
		var temp = select.eq(i).val();
	    for(var j=i+1;j<select.size();j++)
	    	if(temp == select.eq(j).val()){
	    		alert("有重复项，请重新选择！");
	    		return;
	    		}
	}
	for(var i=0;i<select.size();i++){
		data += "\""+(i+1)+"\":\""+select.eq(i).val()+"\",";
	}
	var jsonData = data.substring(0,data.length-1)+"}";
	$.post("/DigitalHome/WB/templateAction!save",{json:jsonData},function(){
		alert("业务模版定制成功！");
		message();
	},"json");
	
}

function reNew(){
   var next = $("#first");
   for(var i=2;i<next.children().size();i++)
	   next.children().eq(i).empty();
}

function message(){
	var target = $("#last");
	var value = new Array();
	var content = "";
	$.post("/DigitalHome/WB/templateAction!getSequence",null,function(data){
		 $.each(data, function(i, n){
	      		value[i] = n;
	      	});
		 if(value[0] == 0)
			 content +="业务模版还未定制";
		 else {
			 content = "已定制业务模版为："
			 for(var i=0;i<value.length;i++){
				 content += value[i];
				 if(i != value.length-1)
					 content += "-->";
			 }
		 }
		 target.text(content);
	},"json");
}