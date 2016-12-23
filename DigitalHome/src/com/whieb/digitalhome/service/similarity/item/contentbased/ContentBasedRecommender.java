package com.whieb.digitalhome.service.similarity.item.contentbased;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.duineframework.recommender.core.IRatableItem;
import org.duineframework.recommender.core.RatableItemId;
import org.duineframework.recommender.core.UserId;
import org.duineframework.recommender.profile.itemsimilarity.ItemSimilarity;
import org.duineframework.recommender.profile.rating.IRatingModelDAO;
import org.duineframework.recommender.profile.rating.Rating;

import com.whieb.digitalhome.dao.ItemDao;
import com.whieb.digitalhome.dao.ItemSimilarityDao;
import com.whieb.digitalhome.dao.RecommenderResultDao;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.RecommenderResult;
import com.whieb.digitalhome.util.Configuration;
import com.whieb.digitalhome.util.Parameter;
import com.whieb.digitalhome.vo.RecommenderExplainResult;

/**
 * 基于内容的推荐
 * 
 * @author Vicky 2012-8-11
 */
public class ContentBasedRecommender {
	public String recommender_type = "content_based";
	public int recommender_limits;
	private int similarity_limits;

	private IRatingModelDAO ratingDao;
	private ItemSimilarityDao itemSimilarityDao;
	private RecommenderResultDao recommenderResultDao;
	private ItemDao itemDao;

	private boolean isInit = false;// 标识是否初始化
	private Configuration config;

	public Configuration getConfig() {
		return config;
	}

	public void setConfig(Configuration config) {
		this.config = config;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public RecommenderResultDao getRecommenderResultDao() {
		return recommenderResultDao;
	}

	public void setRecommenderResultDao(
			RecommenderResultDao recommenderResultDao) {
		this.recommenderResultDao = recommenderResultDao;
	}

	public ItemSimilarityDao getItemSimilarityDao() {
		return itemSimilarityDao;
	}

	public void setItemSimilarityDao(ItemSimilarityDao itemSimilarityDao) {
		this.itemSimilarityDao = itemSimilarityDao;
	}

	public IRatingModelDAO getRatingDao() {
		return ratingDao;
	}

	public void setRatingDao(IRatingModelDAO ratingDao) {
		this.ratingDao = ratingDao;
	}

	public String getRecommender_type() {
		return recommender_type;
	}

	public void setRecommender_type(String recommender_type) {
		this.recommender_type = recommender_type;
	}

	public void init() {
		if (!isInit) {
			recommenderResultDao.clearAllTypeResult(recommender_type);
			String value = config.getValue(Parameter.RECOMMENDER_LIMITS);
			if (null == value || "".equals(value.trim())) {
				recommender_limits = 20;
			} else {
				recommender_limits = Integer.parseInt(value);
				if (recommender_limits == 0) {
					recommender_limits = Integer.MAX_VALUE;
				}
			}
			value = config.getValue(Parameter.ITEM_NEIGHBOR_LIMITS);
			if (null == value || "".equals(value.trim())) {
				similarity_limits = 10;
			} else {
				similarity_limits = Integer.parseInt(value);
				if (similarity_limits == 0) {
					similarity_limits = Integer.MAX_VALUE;
				}
			}
			isInit = true;
		}
	}

	/* 计算某User的推荐结果 */
	public List<IRatableItem> recommender(UserId userId) {
		init();
		if (null == userId) {
			return null;
		}
		System.out.println("recommender User = " + userId.getId() + " ...");
		Collection<Rating> ratings = ratingDao.getRatings(userId);// 取出用户所有的Rating
		Map<RatableItemId, RecommenderResult> result = new HashMap<RatableItemId, RecommenderResult>();// 用来存结果集

		for (Rating r : ratings) {// 根据每个Rating推荐
			result = recormmender(r, result);
		}
		if (null == result || result.size() == 0) {
			return null;
		}
		// 排序
		Map.Entry<RatableItemId, RecommenderResult>[] entry = sort(result);
		List<RecommenderResult> recs = new ArrayList<RecommenderResult>();
		for (Map.Entry<RatableItemId, RecommenderResult> e : entry) {
			boolean flag = true;
			for (Rating r : ratings) {
				if (e.getKey().getId().equals(r.getRatableItemId().getId())) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				continue;
			}
			e.getValue().setUserId(Long.parseLong(userId.getId()));
			recs.add(e.getValue());
			if (recs.size() >= recommender_limits) {
				break;
			}
		}
		System.out.println("recommender result size = " + recs.size() + " ...");
		recommenderResultDao.saveOrUpdateAll(recs);
		return null;
	}

	/* 根据Rating计算推荐结果 */
	public Map<RatableItemId, RecommenderResult> recormmender(Rating r,
			Map<RatableItemId, RecommenderResult> result) {
		if (null == result) {
			result = new HashMap<RatableItemId, RecommenderResult>();
		}
		RatableItemId itemId = r.getRatableItemId();
		double rating = r.getValue();
		Item item = itemDao.findItem(Long.parseLong(itemId.getId()));
		if (null == item) {
			return result;
		}
		List<ItemSimilarity> items = itemSimilarityDao.getTopNItemSimilarity(
				itemId, similarity_limits);// 取出Item的前20个相似Item
		if (null == items || items.size() == 0) {
			return result;
		}
		for (ItemSimilarity i : items) {
			double value = i.getSimilarity() * rating;// 计算可能评分
			RatableItemId id = i.getItemId();
			if (id.getId().equals(itemId.getId())) {
				id = i.getOtherItemId();
			}
			RecommenderResult rs = null;
			if (result.containsKey(id)) {// 如果已存在，可能评分选择较大值
				rs = result.get(id);
				double old_value = rs.getValue();
				if (value > old_value) {
					rs.setValue(value);
					rs.setExplain("该视频与您看过的\"" + item.getTitle() + "\"相似");
				} else {
					continue;
				}
			} else {
				rs = new RecommenderResult();
				rs.setValue(value);
			}
			rs.setItemId(Long.parseLong(id.getId()));
			rs.setDate(new Date());
			rs.setExplain("该视频与您看过的\"" + item.getTitle() + "\"相似");
			rs.setType(recommender_type);
			result.put(id, rs);
		}
		return result;
	}

	// 排序
	@SuppressWarnings("unchecked")
	public Map.Entry<RatableItemId, RecommenderResult>[] sort(
			Map<RatableItemId, RecommenderResult> maps) {
		Map.Entry<RatableItemId, RecommenderResult>[] entry = (Map.Entry<RatableItemId, RecommenderResult>[]) maps
				.entrySet().toArray(new Map.Entry[maps.entrySet().size()]);
		Arrays.sort(entry,
				new Comparator<Map.Entry<RatableItemId, RecommenderResult>>() {
					@Override
					public int compare(
							Entry<RatableItemId, RecommenderResult> o1,
							Entry<RatableItemId, RecommenderResult> o2) {
						if (o1.getValue().getValue() > o2.getValue().getValue()) {
							return -1;
						} else if (o1.getValue().getValue() < o2.getValue()
								.getValue()) {
							return 1;
						} else {
							return 0;
						}
					}
				});
		return entry;
	}

	/**
	 * 显示推荐结果
	 * 
	 * @author Vicky 2012-8-11
	 */
	public List<RecommenderExplainResult> showRecommenderResult(UserId uid,
			int limits) {
		limits = (limits == 0 ? recommender_limits : limits);
		List<RecommenderExplainResult> results = new ArrayList<RecommenderExplainResult>();
		List<RecommenderResult> rs = recommenderResultDao
				.showUserRecommenderResult(Long.parseLong(uid.getId()),
						recommender_type, limits);
		for (RecommenderResult r : rs) {
			Item i = itemDao.findItem(r.getItemId());
			if (null == i) {
				continue;
			}
			RecommenderExplainResult res = new RecommenderExplainResult();
			res.setItem(i);
			res.setExplain(r.getExplain());
			results.add(res);
		}
		return results;
	}

	/**
	 * 根据Item显示与Item相似的Item集合
	 */
	public List<Item> recommenderByItem(RatableItemId id, int topN) {
		List<Item> items = new ArrayList<Item>();
		List<ItemSimilarity> sims = new ArrayList<ItemSimilarity>();
		// 取出该Item的topN个相似Item,作为推荐结果
		sims = itemSimilarityDao.getTopNItemSimilarity(id, topN);
		if (sims != null && sims.size() > 0) {
			for (ItemSimilarity s : sims) {
				Item i = itemDao
						.findItem(Long.parseLong(s.getItemId().getId()));
				items.add(i);
			}
		}
		return items;
	}
}
