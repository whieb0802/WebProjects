package com.whieb.digitalhome.service.similarity.item.collaborative;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.duineframework.recommender.core.UserId;
import org.duineframework.recommender.profile.rating.ItemRatings;
import org.duineframework.recommender.profile.rating.Rating;

import com.whieb.digitalhome.dao.impl.RatingDaoImpl;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.util.CosineSimilarityMeasure;

/**
 * @author Vicky 2012-8-14
 */
public class CollaborativeItemSimilarityCounter {
	private RatingDaoImpl ratingDao;
	private CosineSimilarityMeasure measure;

	public CosineSimilarityMeasure getMeasure() {
		return measure;
	}

	public void setMeasure(CosineSimilarityMeasure measure) {
		this.measure = measure;
	}

	public RatingDaoImpl getRatingDao() {
		return ratingDao;
	}

	public void setRatingDao(RatingDaoImpl ratingDao) {
		this.ratingDao = ratingDao;
	}

	public double getSimilarity(Item item, Item otherItemId) {
		if (item.getId() == otherItemId.getId()) {
			return 1.00;
		}
		ItemRatings itemRatings = ratingDao.getItemRating(item.getId());
		ItemRatings other_itemRatings = ratingDao.getItemRating(otherItemId
				.getId());
		double sim = calculate(itemRatings.getRatings(),
				other_itemRatings.getRatings());
		return sim;
	}

	private double calculate(Collection<Rating> ratings,
			Collection<Rating> other_ratings) {
		if (null == ratings || ratings.size() == 0 || null == other_ratings
				|| other_ratings.size() == 0) {
			return 0.00;
		}
		double sim = 0.00;
		Set<UserId> ids = new HashSet<UserId>();
		Set<UserId> ids_all = new HashSet<UserId>();
		for (Rating r : ratings) {
			ids_all.add(r.getUserId());
		}
		// 求交集
		for (Rating r : other_ratings) {
			if (!ids_all.add(r.getUserId())) {// 重复
				ids.add(r.getUserId());
			}
		}
		if (ids.size() == 0) {
			return 0.00;
		}
		double[] d1 = getTermVector(ratings, ids);
		double[] d2 = getTermVector(other_ratings, ids);
		sim = measure.calculate(d1, d2);
		return sim;
	}

	private double[] getTermVector(Collection<Rating> ratings, Set<UserId> ids) {
		double[] dou = new double[ids.size()];
		if (null == ratings || ratings.size() == 0) {
			return dou;
		}
		double total = 0.00;
		Map<UserId, Rating> maps = new HashMap<UserId, Rating>();
		for (Rating r : ratings) {
			total += r.getValue();
			maps.put(r.getUserId(), r);
		}
		double average = total / ratings.size();
		int index = 0;
		for (UserId i : ids) {
			double value = 0;
			if (maps.containsKey(i)) {
				value = maps.get(i).getValue() - average;
			}
			dou[index++] = value;
		}
		return dou;
	}
}
