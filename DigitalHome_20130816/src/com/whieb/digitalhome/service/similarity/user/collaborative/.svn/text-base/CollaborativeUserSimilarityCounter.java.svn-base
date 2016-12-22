package com.whieb.digitalhome.service.similarity.user.collaborative;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.duineframework.recommender.core.RatableItemId;
import org.duineframework.recommender.core.UserId;
import org.duineframework.recommender.profile.rating.IRatingModelDAO;
import org.duineframework.recommender.profile.rating.Rating;

import com.whieb.digitalhome.util.CosineSimilarityMeasure;

/**
 * @author Vicky 2012-8-14
 */
public class CollaborativeUserSimilarityCounter {
	private IRatingModelDAO ratingDao;
	private CosineSimilarityMeasure measure;

	public CosineSimilarityMeasure getMeasure() {
		return measure;
	}

	public void setMeasure(CosineSimilarityMeasure measure) {
		this.measure = measure;
	}

	public IRatingModelDAO getRatingDao() {
		return ratingDao;
	}

	public void setRatingDao(IRatingModelDAO ratingDao) {
		this.ratingDao = ratingDao;
	}

	public double getSimilairty(UserId userId, UserId otherUserId) {
		if (null == userId || null == otherUserId) {
			return 0.00;
		}
		if (userId.getId().equals(otherUserId.getId())) {
			return 1.00;
		}
		Collection<Rating> ratings = ratingDao.getRatings(userId);
		Collection<Rating> other_ratings = ratingDao.getRatings(otherUserId);
		double sim = calculate(ratings, other_ratings);
		return sim;
	}

	private double calculate(Collection<Rating> ratings,
			Collection<Rating> other_ratings) {
		if (null == ratings || ratings.size() == 0 || null == other_ratings
				|| other_ratings.size() == 0) {
			return 0.00;
		}
		double sim = 0.00;
		Set<RatableItemId> ids = new HashSet<RatableItemId>();
		Set<RatableItemId> ids_all = new HashSet<RatableItemId>();
		for (Rating r : ratings) {
			ids_all.add(r.getRatableItemId());
		}
		// 求交集
		for (Rating r : other_ratings) {
			if (!ids_all.add(r.getRatableItemId())) {// 重复
				ids.add(r.getRatableItemId());
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

	private double[] getTermVector(Collection<Rating> ratings,
			Set<RatableItemId> ids) {
		double[] dou = new double[ids.size()];
		if (null == ratings || ratings.size() == 0) {
			return dou;
		}
		double total = 0.00;
		Map<RatableItemId, Rating> maps = new HashMap<RatableItemId, Rating>();
		for (Rating r : ratings) {
			total += r.getValue();
			maps.put(r.getRatableItemId(), r);
		}
		double average = total / ratings.size();
		int index = 0;
		for (RatableItemId i : ids) {
			double value = 0;
			if (maps.containsKey(i)) {
				value = maps.get(i).getValue() - average;
			}
			dou[index++] = value;
		}
		return dou;
	}
}
