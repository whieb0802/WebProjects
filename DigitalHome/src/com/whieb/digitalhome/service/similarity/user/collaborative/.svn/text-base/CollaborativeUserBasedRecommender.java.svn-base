package com.whieb.digitalhome.service.similarity.user.collaborative;

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
import org.duineframework.recommender.profile.rating.IRatingModelDAO;
import org.duineframework.recommender.profile.rating.Rating;
import org.duineframework.recommender.profile.usersimilarity.UserSimilarity;

import com.whieb.digitalhome.dao.ItemDao;
import com.whieb.digitalhome.dao.RecommenderResultDao;
import com.whieb.digitalhome.dao.UserSimilarityDao;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.RecommenderResult;
import com.whieb.digitalhome.util.Configuration;
import com.whieb.digitalhome.util.Parameter;
import com.whieb.digitalhome.vo.RecommenderExplainResult;

/**
 * @author Vicky 2012-8-14
 */
/**
 * @author Vicky
 * 2012-8-14
 */
/**
 * @author Vicky 2012-8-14
 */
public class CollaborativeUserBasedRecommender {
	public String recommender_type = "collaborative_user_based";
	public int recommender_limits;
	private int similarity_limits;

	private IRatingModelDAO ratingDao;
	private UserSimilarityDao userSimilarityDao;
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

	public String getRecommender_type() {
		return recommender_type;
	}

	public void setRecommender_type(String recommender_type) {
		this.recommender_type = recommender_type;
	}

	public IRatingModelDAO getRatingDao() {
		return ratingDao;
	}

	public void setRatingDao(IRatingModelDAO ratingDao) {
		this.ratingDao = ratingDao;
	}

	public UserSimilarityDao getUserSimilarityDao() {
		return userSimilarityDao;
	}

	public void setUserSimilarityDao(UserSimilarityDao userSimilarityDao) {
		this.userSimilarityDao = userSimilarityDao;
	}

	public RecommenderResultDao getRecommenderResultDao() {
		return recommenderResultDao;
	}

	public void setRecommenderResultDao(
			RecommenderResultDao recommenderResultDao) {
		this.recommenderResultDao = recommenderResultDao;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
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
			value = config.getValue(Parameter.USER_NEIGHBOR_LIMITS);
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
		Collection<UserSimilarity> neighbors = userSimilarityDao
				.getTopNSimilarityUser(userId, similarity_limits);// topN个相似用户
		Collection<Rating> ratings = ratingDao.getRatings(userId);// 取出用户所有的Rating
		Map<RatableItemId, RecommenderResult> result = new HashMap<RatableItemId, RecommenderResult>();// 用来存结果集
		for (UserSimilarity us : neighbors) {
			UserId other_userId = us.getOtherUserId();
			if (userId.getId().equals(other_userId.getId())) {
				other_userId = us.getUserId();
			}
			result = recormmender(other_userId, us.getSimilarity(), result);
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

	/* 根据相似用户计算推荐结果 */
	public Map<RatableItemId, RecommenderResult> recormmender(UserId uid,
			double similarity, Map<RatableItemId, RecommenderResult> result) {
		if (null == result) {
			result = new HashMap<RatableItemId, RecommenderResult>();
		}
		Collection<Rating> n_ratings = ratingDao.getRatings(uid);
		if (null == n_ratings || n_ratings.size() == 0) {
			return result;
		}
		for (Rating r : n_ratings) {
			double value = r.getValue() * similarity;// 可能评分
			RecommenderResult rs = null;
			if (result.containsKey(r.getRatableItemId())) {
				rs = result.get(r.getRatableItemId());
				value = Math.max(value, rs.getValue());
				rs.setValue(value);
			} else {
				rs = new RecommenderResult();
				rs.setValue(value);
			}
			rs.setItemId(Long.parseLong(r.getRatableItemId().getId()));
			rs.setDate(new Date());
			rs.setExplain("和您相似的用户观看过该视频");
			rs.setType(recommender_type);
			result.put(r.getRatableItemId(), rs);
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

}
