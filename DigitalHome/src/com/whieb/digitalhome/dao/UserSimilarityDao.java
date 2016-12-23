package com.whieb.digitalhome.dao;

import java.util.Collection;

import org.duineframework.recommender.core.UserId;
import org.duineframework.recommender.profile.usersimilarity.UserSimilarity;

/**
 * @author Vicky 2012-8-14
 */
public interface UserSimilarityDao {
	public UserSimilarity createUserSimilarity(UserId userId,
			UserId otherUserId, double similarity);

	public void clearAll();

	public void saveOrUpdateAll(Collection<UserSimilarity> sims);

	public Collection<UserSimilarity> getTopNSimilarityUser(UserId id, int topN);

}
