package com.whieb.digitalhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.duineframework.recommender.core.RatableItemId;
import org.duineframework.recommender.core.UserId;
import org.duineframework.recommender.profile.rating.Rating;
import org.springframework.stereotype.Component;

import com.whieb.digitalhome.dao.impl.RatingDaoImpl;
import com.whieb.digitalhome.model.IRating;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.User;

/**
 * @author Vicky
 * 2012-8-11
 */
@Component
public class RatingService {
	private RatingDaoImpl ratingDao;

	public RatingDaoImpl getRatingDao() {
		return ratingDao;
	}
	
	@Resource(name="ratingDao")
	public void setRatingDao(RatingDaoImpl ratingDao) {
		this.ratingDao = ratingDao;
	}
	
	/**zkz
	 * 增加Rating
	 * @param user
	 * @param item
	 * @param value
	 * @param certainty
	 */
	public void saveRating(Rating rating) {
		ratingDao.saveRating(rating);
	}
	
	public Rating  getRating(User user, Item item){
		return ratingDao.getRating(user.getId(), item.getId());
	}
	public List<UserId> getDistinctUserId() {
		return ratingDao.listAllUsers();
	}
}

