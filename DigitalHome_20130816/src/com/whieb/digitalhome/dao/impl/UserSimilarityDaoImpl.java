package com.whieb.digitalhome.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.duineframework.recommender.core.UserId;
import org.duineframework.recommender.profile.usersimilarity.UserSimilarity;

import com.whieb.digitalhome.dao.UserSimilarityDao;
import com.whieb.digitalhome.model.CollaborativeUserSimilarity;
import com.whieb.digitalhome.util.UtilDao;

/**
 * @author Vicky 2012-8-14
 */
public class UserSimilarityDaoImpl implements UserSimilarityDao {

	private UtilDao utilDao;

	public UtilDao getUtilDao() {
		return utilDao;
	}

	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	@Override
	public UserSimilarity createUserSimilarity(UserId userId,
			UserId otherUserId, double similarity) {
		CollaborativeUserSimilarity sim = new CollaborativeUserSimilarity();
		sim.setUserId(userId);
		sim.setOtherUserId(otherUserId);
		sim.setSimilarity(similarity);
		return sim;
	}

	@Override
	public void clearAll() {
		utilDao.execute("delete CollaborativeUserSimilarity");
	}

	@Override
	public void saveOrUpdateAll(Collection<UserSimilarity> sims) {
		utilDao.saveOrUpdateAll(sims);
	}

	@Override
	public Collection<UserSimilarity> getTopNSimilarityUser(UserId id, int topN) {
		List<UserSimilarity> uids = new ArrayList<UserSimilarity>();
		String hql = "select distinct c from CollaborativeUserSimilarity c where c.userId.id = ? or c.otherUserId.id = ? order by c.similarity desc";
		uids = utilDao.findMaxResult(hql,
				new Object[] { id.getId(), id.getId() }, topN);
		return uids;
	}

}
