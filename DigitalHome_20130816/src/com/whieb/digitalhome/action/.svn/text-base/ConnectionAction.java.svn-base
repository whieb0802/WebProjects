package com.whieb.digitalhome.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.whieb.digitalhome.model.Connection;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.User;
import com.whieb.digitalhome.service.ConnectionService;
import com.whieb.digitalhome.util.DataTranslateUtil;
import com.whieb.digitalhome.util.Transfer;

@Component("connectionAction")
@Scope("prototype")
public class ConnectionAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private ConnectionService cs;
	private JSONObject jsonObj;
	private String json; // 接收js传输过来的参数
	private HttpServletResponse response = ServletActionContext.getResponse();
	@SuppressWarnings("rawtypes")
	private Map map = ActionContext.getContext().getSession();
	private DataTranslateUtil dtu;

	public DataTranslateUtil getDtu() {
		return dtu;
	}

	@Resource
	public void setDtu(DataTranslateUtil dtu) {
		this.dtu = dtu;
	}

	public ConnectionService getCs() {
		return cs;
	}

	@Resource(name = "connectionService")
	public void setCs(ConnectionService cs) {
		this.cs = cs;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	//过滤用户看过的item数据
	public void getConnectionDataA() throws Exception {
		User u = (User) map.get("user");
		jsonObj = JSONObject.fromObject(json); // 将JSON格式的字符串构造成JSON对象
		Long itemId = jsonObj.getLong("id");
		List<Connection> con = cs.getConnection(u.getUserId(), itemId);
		List<Item> item = cs.getConnectionData(con);
		jsonObj = dtu.conToJson(con, item);
		Transfer.responseOut(response, jsonObj.toString());
	}
	
	//不过滤用户看过的item数据
	public void getConnectionData() throws Exception {
		jsonObj = JSONObject.fromObject(json); // 将JSON格式的字符串构造成JSON对象
		Long itemId = jsonObj.getLong("id");
		List<Connection> con = cs.getConnection(itemId);
		List<Item> item = cs.getConnectionData(con);
		jsonObj = dtu.conToJson(con, item);
		Transfer.responseOut(response, jsonObj.toString());
	}

	public void getAllItem() throws Exception {
		int firstIndex = 0;
		jsonObj = JSONObject.fromObject(json); // 将JSON格式的字符串构造成JSON对象
		firstIndex = jsonObj.getInt("page");
		List<Item> item = cs.getItemDao().findItem(Item.class, firstIndex, 10);
		jsonObj = dtu.itemToJson(item);
		Transfer.responseOut(response, jsonObj.toString());
	}
	
	//更新关联规则数据
	public String run(){
		cs.run();
		return SUCCESS;
	}
}
