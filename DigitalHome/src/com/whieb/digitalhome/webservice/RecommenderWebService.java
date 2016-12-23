package com.whieb.digitalhome.webservice;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.duineframework.recommender.core.UserId;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.whieb.digitalhome.model.Connection;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.misc.ArrayWrapper;
import com.whieb.digitalhome.service.ConnectionService;
import com.whieb.digitalhome.service.InterestService;
import com.whieb.digitalhome.service.ItemService;
import com.whieb.digitalhome.service.RecommenderService;
import com.whieb.digitalhome.util.Configuration;
import com.whieb.digitalhome.util.Parameter;
import com.whieb.digitalhome.util.RecommenderType;
import com.whieb.digitalhome.vo.RecommenderExplainResult;

@WebService
public class RecommenderWebService {
	private RecommenderService recommenderService;
	private ItemService itemService;
	private InterestService interestService;
	private ConnectionService connectionService;
	private Configuration config;

	/* 热门 */
	public String showHotItems(int topN) {
		if (0 == topN) {// is 0 , default
			topN = getTopN();
		}
		List<Item> items = itemService.findHotItems(topN);
		return serializeItems(items);
	}

	/* 最新 */
	public String showNewItems(int topN) {
		if (0 == topN) {// is 0 , default
			topN = getTopN();
		}
		List<Item> items = itemService.findNewItems(topN);
		return serializeItems(items);
	}

	/* 基于内容 */
	public String showContentBasedRecommenderResult(long uid, int topN) {
		if (0 == topN) {// is 0 , default
			topN = getTopN();
		}
		UserId userId = new UserId(uid + "");
		List<RecommenderExplainResult> items = recommenderService
				.showRecommenderResult(userId, RecommenderType.CONTENT_BASED,
						topN);
		return serializeItemWithExplaination(items);
	}

	/* 基于Item的协同过滤 */
	public String showCollaborativeItemBasedRecommenderResult(long uid, int topN) {
		if (0 == topN) {// is 0 , default
			topN = getTopN();
		}
		UserId userId = new UserId(uid + "");
		List<RecommenderExplainResult> items = recommenderService
				.showRecommenderResult(userId, RecommenderType.ITEM_SIMILARITY,
						topN);
		return serializeItemWithExplaination(items);
	}

	/* 基于User的协同过滤 */
	public String showCollaborativeUserBasedRecommenderResult(long uid, int topN) {
		if (0 == topN) {// is 0 , default
			topN = getTopN();
		}
		UserId userId = new UserId(uid + "");
		List<RecommenderExplainResult> items = recommenderService
				.showRecommenderResult(userId, RecommenderType.USER_SIMILARITY,
						topN);
		return serializeItemWithExplaination(items);
	}

	/* 基于用户模型 */
	/*public String showUserInterestRecommender(long uid, int topN) {
		if (0 == topN) {// is 0 , default
			topN = getTopN();
		}
		int parameter1 = 3;
		int parameter2 = 2;
		UserId userId = new UserId(uid + "");
		List<Item> items = interestService.replay(parameter1, parameter2, topN,
				userId);
		return serializeItems(items);
	}*/

	/* 基于关联模式 */
	public String showConnectionRecommender(long uid, long itemId, int topN) {
		if (0 == topN) {// is 0 , default
			topN = getTopN();
		}
		List<Connection> con = connectionService.getConnection(uid, itemId);
		if (null == con) {
			con = new ArrayList<Connection>();
		}
		List<Item> items = connectionService.getConnectionData(con);
		return serializeItems(items);
	}

	private String serializeItems(List<Item> items) {
		if (null == items) {
			items = new ArrayList<Item>();
		}
		try {
			Item[] itemArray = new Item[items.size()];
			items.toArray(itemArray);

			ArrayWrapper wrapper = new ArrayWrapper();
			wrapper.items = itemArray;
			Serializer serializer = new Persister();
			StringWriter writer = new StringWriter();
			serializer.write(wrapper, writer);
			return writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String serializeItemWithExplaination(
			List<RecommenderExplainResult> items) {
		if (null == items) {
			items = new ArrayList<RecommenderExplainResult>();
		}

		try {
			RecommenderExplainResult[] itemArray = new RecommenderExplainResult[items
					.size()];
			items.toArray(itemArray);

			ArrayWrapper wrapper = new ArrayWrapper();
			wrapper.explain = itemArray;
			Serializer serializer = new Persister();
			StringWriter writer = new StringWriter();
			serializer.write(wrapper, writer);
			return writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@WebMethod(exclude = true)
	public Integer getTopN() {
		int topN = 0;
		String value = config.getValue(Parameter.RECOMMENDER_TOPN);
		if (null == value || "".equals(value.trim())) {
			topN = 10;
		} else {
			topN = Integer.parseInt(value);
			if (topN == 0) {
				topN = Integer.MAX_VALUE;
			}
		}
		return topN;
	}

	@WebMethod(exclude = true)
	public RecommenderService getRecommenderService() {
		return recommenderService;
	}

	@WebMethod(exclude = true)
	public void setRecommenderService(RecommenderService recommenderService) {
		this.recommenderService = recommenderService;
	}

	@WebMethod(exclude = true)
	public ItemService getItemService() {
		return itemService;
	}

	@WebMethod(exclude = true)
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	@WebMethod(exclude = true)
	public InterestService getInterestService() {
		return interestService;
	}

	@WebMethod(exclude = true)
	public void setInterestService(InterestService interestService) {
		this.interestService = interestService;
	}

	@WebMethod(exclude = true)
	public ConnectionService getConnectionService() {
		return connectionService;
	}

	@WebMethod(exclude = true)
	public void setConnectionService(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}

	@WebMethod(exclude = true)
	public Configuration getConfig() {
		return config;
	}

	@WebMethod(exclude = true)
	public void setConfig(Configuration config) {
		this.config = config;
	}
}
