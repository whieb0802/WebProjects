package com.whieb.digitalhome.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.duineframework.recommender.core.RatableItemId;
import org.duineframework.recommender.profile.itemsimilarity.ItemSimilarity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.whieb.digitalhome.model.Connection;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.service.ConnectionService;
import com.whieb.digitalhome.service.ContentBasedItemSimilarityService;
import com.whieb.digitalhome.service.RecommenderService;
import com.whieb.digitalhome.service.SimilarityService;
import com.whieb.digitalhome.service.TemplateService;
import com.whieb.digitalhome.util.DataTranslateUtil;
import com.whieb.digitalhome.util.Transfer;

@Component("contentRecAction")
@Scope("prototype")
public class ContentRecAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private ConnectionService cs;
	private SimilarityService ss;
	private TemplateService ts;
	private JSONObject jsonObj;
	private String json; // 接收js传输过来的参数
	private HttpServletResponse response = ServletActionContext.getResponse();
	private DataTranslateUtil dtu;
	private RecommenderService recommenderService;
	private ContentBasedItemSimilarityService contentBasedItemSimilarityService;
	 
	
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
	
	
	public RecommenderService getRecommenderService() {
		return recommenderService;
	}
	@Resource(name="recommender.contentbased")
	public void setRecommenderService(RecommenderService recommenderService) {
		this.recommenderService = recommenderService;
	}
	
	
	public ContentBasedItemSimilarityService getContentBasedItemSimilarityService() {
		return contentBasedItemSimilarityService;
	}
	@Resource(name="contentBasedItemSimilarityService")
	public void setContentBasedItemSimilarityService(
			ContentBasedItemSimilarityService contentBasedItemSimilarityService) {
		this.contentBasedItemSimilarityService = contentBasedItemSimilarityService;
	}
	public void getAllItem() throws Exception {
		int firstIndex = 0;
		jsonObj = JSONObject.fromObject(json); // 将JSON格式的字符串构造成JSON对象
		firstIndex = jsonObj.getInt("page");
		List<Item> item = cs.getItemDao().findItem(Item.class, firstIndex, 10);
		jsonObj = dtu.itemToJson(item);
		Transfer.responseOut(response, jsonObj.toString());
	}
	//得到内容推荐结果
//	public void getNextData() throws Exception{
//		jsonObj = JSONObject.fromObject(json); // 将JSON格式的字符串构造成JSON对象
//		Long itemId = jsonObj.getLong("id");
//		List<Item> item = ts.getNextData(itemId);
//		jsonObj = dtu.allItemToJson(item);
//		Transfer.responseOut(response, jsonObj.toString());
//	}
	//不过滤用户看过的item数据
	public void getContentRecData() throws Exception {
		jsonObj = JSONObject.fromObject(json); // 将JSON格式的字符串构造成JSON对象
		Long itemId = jsonObj.getLong("id");
		RatableItemId itemID2 = new RatableItemId(itemId.toString());
		List<ItemSimilarity> itemSimilarities = contentBasedItemSimilarityService.getContentItemSimi(itemID2);
		List<Item> item = contentBasedItemSimilarityService.getContentItemSimiData(itemSimilarities);
		jsonObj = dtu.conToJson2(itemSimilarities, item);
		Transfer.responseOut(response, jsonObj.toString());
	}
}

