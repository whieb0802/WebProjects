package com.whieb.digitalhome.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.duineframework.recommender.core.RatableItemId;
import org.duineframework.recommender.core.UserId;
import org.duineframework.recommender.profile.rating.IRatingModelDAO;
import org.duineframework.recommender.profile.rating.ItemRatings;
import org.duineframework.recommender.profile.rating.Rating;
import org.springframework.stereotype.Component;

import com.whieb.digitalhome.dao.RatingDao;
import com.whieb.digitalhome.model.IRating;
/*import com.whieb.digitalhome.model.Trade;*/
import com.whieb.digitalhome.util.UtilDao;

/**
 * @author Vicky 2012-8-11
 */
@Component("ratingDao")
public class RatingDaoImpl implements IRatingModelDAO, RatingDao {
	private UtilDao utilDao;

	public UtilDao getUtilDao() {
		return utilDao;
	}

	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	public void saveRating(Rating rating) {
		utilDao.saveOrUpdate(rating);
	}

	public void removeRating(UserId userId, RatableItemId itemId) {
		Rating rating = getRating(userId, itemId);
		if (rating == null) {
			return;
		}
		utilDao.delete(rating);
	}

	public void removeRating(Rating rating) {
		utilDao.delete(rating);
	}

	public Rating getRating(final UserId userId, final RatableItemId itemId) {
		String hql = "from IRating where userId.id = ? and ratableItemId.id = ?";
		return (Rating) utilDao.uniqueResult(hql, new Object[] {
				userId.getId(), itemId.getId() });
	}

	public Rating getPreRating(UserId userId) {
		String hql = "from IRating where userId.id = ?";
		List<IRating> ratings = utilDao.find(hql,
				new Object[] { userId.getId() });
		if (ratings.size() == 1 || ratings.size() == 0) {
			return null;
		}
		return ratings.get(ratings.size() - 2);
	}

	public Rating createRating(UserId userId, RatableItemId ratableItemId,
			double value, double certainty, Date lastModification) {
		return doCreateRating(userId, ratableItemId, value, certainty,
				lastModification);
	}

	public Rating createRating(UserId userId, RatableItemId ratableItemId,
			double value, double certainty) {
		return doCreateRating(userId, ratableItemId, value, certainty, null);
	}

	private Rating doCreateRating(UserId userId, RatableItemId ratableItemId,
			double value, double certainty, Date lastModification) {
		Rating rating = getRating(userId, ratableItemId);
		if (rating == null) {
			rating = new IRating(userId, ratableItemId, value, certainty,
					lastModification);
		} else {
			rating.setValue(value);
			rating.setCertainty(certainty);
			rating.setLastModification(lastModification);
		}
		return rating;
	}

	public double getAverageRating(final RatableItemId itemId) {
		String hql = "select avg(r.value) from IRating r where ratableItemId.id = ?";
		Double rating = (Double) utilDao.uniqueResult(hql,
				new Object[] { itemId.getId() });
		if (rating == null) {
			return 0;
		}
		return rating.doubleValue();
	}

	public double getAverageRating(final UserId userId) {
		String hql = "select avg(r.value) from IRating r where userId.id = ?";
		Double rating = (Double) utilDao.uniqueResult(hql,
				new Object[] { userId.getId() });
		if (rating == null) {
			return 0;
		}
		return rating.doubleValue();
	}

	public long getNoItems() {
		String hql = "select count(distinct r.ratableItemId) from IRating r";
		return (Long) utilDao.uniqueResult(hql, null);
	}

	public long getNoRatings() {
		String hql = "select count(r) from IRating r";
		return (Long) utilDao.uniqueResult(hql, null);
	}

	public long getNoUsers() {
		String hql = "select count(distinct r.userId) from IRating r";
		return (Long) utilDao.uniqueResult(hql, null);
	}

	public long getNoRatings(final UserId userId) {
		String hql = "select count(r) from IRating r where userId.id = ?";
		return (Long) utilDao
				.uniqueResult(hql, new Object[] { userId.getId() });
	}

	public long getNoRatings(final RatableItemId itemId) {
		String hql = "select count(r) from IRating r where ratableItemId.id = ?";
		return (Long) utilDao
				.uniqueResult(hql, new Object[] { itemId.getId() });
	}

	public List<UserId> listAllUsers() {
		List<UserId> uids = new ArrayList<UserId>();
		uids = utilDao
				.find("select distinct r.userId from IRating r order by r.userId.id asc",
						null);
		return uids;
	}

	public Collection<Rating> getRatings(UserId userId) {
		List<Rating> ratings = new ArrayList<Rating>();
		String hql = "from IRating r where userId.id = ?";
		ratings = utilDao.find(hql, new Object[] { userId.getId() });
		return ratings;
	}

	public Collection<Rating> getRatings(String userId) {
		List<Rating> ratings = new ArrayList<Rating>();
		String hql = "from IRating r where userId.id = ?";
		ratings = utilDao.find(hql, new Object[] { userId });
		return ratings;
	}

	/*public Collection<Trade> getTrades(Long userId) {
		List<Trade> trades = new ArrayList<Trade>();
		String hql = "from Trade t where userId = ?";
		trades = utilDao.find(hql, new Object[]{userId});
		return trades;
		
	}*/
	
	public Collection<Rating> getRatings(RatableItemId itemId) {
		List<Rating> ratings = new ArrayList<Rating>();
		String hql = "from IRating r where ratableItemId.id = ?";
		ratings = utilDao.find(hql, new Object[] { itemId.getId() });
		return ratings;
	}

	public Collection<Rating> getRatings(final UserId userId,
			final Calendar from, final Calendar to) {
		return null;
	}

	public Collection<RatableItemId> getItemsRatedByBoth(UserId userIdA,
			UserId userIdB) {
		List<RatableItemId> itemIds = new ArrayList<RatableItemId>();
		String hql = "select r1.ratableItemId from IRating r1, IRating r2 where r1.userId.id = ? and r2.userId.id = ? and r1.ratableItemId.id = r2.ratableItemId.id";
		itemIds = utilDao.find(hql,
				new Object[] { userIdA.getId(), userIdB.getId() });
		return itemIds;
	}

	public ItemRatings getItemRating(RatableItemId item_id) {
		ItemRatings ratings = null;
		if (null == ratings) {
			ratings = new ItemRatings(item_id);
			ratings.add(getRatings(item_id));
		}
		return ratings;
	}

	public List<Integer> findRatingByuserId(String userId, String sql) {
		List<Object> objs = utilDao.find(sql, new Object[] { userId });
		List<Integer> ints = new ArrayList<Integer>();
		for (Object o : objs) {
			Integer i = Integer.parseInt(String.valueOf(o));
			ints.add(i) ;
		}
		return ints;
	}

	public int findRatingAllCount(String sql) {
		return Integer.parseInt(String.valueOf(utilDao.find(sql, null).get(0)));
	}

	public int findNumCount(String userId, String sql) {
		return Integer.parseInt(String.valueOf(utilDao.find(sql,
				new Object[] { userId }).get(0)));
	}

	@Override
	// 清空数据
	public void clearAll() {
		utilDao.execute("delete IRating");
	}

	@Override
	// 添加一组
	public void addAll(List<Rating> ratings) {
		utilDao.saveOrUpdateAll(ratings);
	}

}
