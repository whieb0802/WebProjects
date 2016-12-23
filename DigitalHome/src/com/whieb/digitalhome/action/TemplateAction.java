package com.whieb.digitalhome.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.whieb.digitalhome.model.Connection;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.service.ConnectionService;
import com.whieb.digitalhome.service.TemplateService;
import com.whieb.digitalhome.util.DataTranslateUtil;
import com.whieb.digitalhome.util.Transfer;

@Component("templateAction")
@Scope("prototype")
public class TemplateAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private ConnectionService cs;
	private TemplateService ts;
	private JSONObject jsonObj;
	private String json; // 接收js传输过来的参数
	private HttpServletResponse response = ServletActionContext.getResponse();
	private DataTranslateUtil dtu;
	
	
	public DataTranslateUtil getDtu() {
		return dtu;
	}
    @Resource(name = "dataTranslateUtil")
	public void setDtu(DataTranslateUtil dtu) {
		this.dtu = dtu;
	}

	public TemplateService getTs() {
		return ts;
	}
	
	@Resource(name = "templateService")
	public void setTs(TemplateService ts) {
		this.ts = ts;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	
	public ConnectionService getCs() {
		return cs;
	}

	@Resource(name = "connectionService")
	public void setCs(ConnectionService cs) {
		this.cs = cs;
	}
	
	//初始话下拉菜单内容
	public void init() throws Exception{
		Map<Integer,String> content = new HashMap<Integer,String>();
		content = ts.getType();
		jsonObj = dtu.contentToJson(content);
		Transfer.responseOut(response, jsonObj.toString());
	}
	
	//保存定制的业务模版
	public void save(){
		jsonObj = JSONObject.fromObject(json); // 将JSON格式的字符串构造成JSON对象
		List<Integer> sequence = dtu.jsonToSequence(jsonObj);
		ts.save(sequence);  
	}
    
	//取出之前定制的业务模版
	public void getSequence() throws Exception{
		String[] message = ts.getSequence();
		jsonObj = dtu.sequenceToJson(message);
		Transfer.responseOut(response, jsonObj.toString());
	}
	
	public String show(){
		return "success";
	}
	
	//得到所有条目信息
	public void getAllItem() throws Exception {
		int firstIndex = 0;
		jsonObj = JSONObject.fromObject(json); // 将JSON格式的字符串构造成JSON对象
		firstIndex = jsonObj.getInt("page");
		List<Item> item = cs.getItemDao().findItem(Item.class, firstIndex, 10);
		jsonObj = dtu.allItemToJson(item);
		Transfer.responseOut(response, jsonObj.toString());
	}
	
	//得到模版推荐结果
	public void getNextData() throws Exception{
		jsonObj = JSONObject.fromObject(json); // 将JSON格式的字符串构造成JSON对象
		Long itemId = jsonObj.getLong("id");
		List<Item> item = ts.getNextData(itemId);
		jsonObj = dtu.allItemToJson(item);
		Transfer.responseOut(response, jsonObj.toString());
	}
	
}

