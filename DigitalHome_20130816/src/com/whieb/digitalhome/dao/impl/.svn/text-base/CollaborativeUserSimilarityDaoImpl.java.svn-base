package com.whieb.digitalhome.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.duineframework.recommender.core.UserId;
import org.duineframework.recommender.dao.springhibernate.SpringHibernateUserSimilarityModelDAO;
import org.duineframework.recommender.profile.usersimilarity.IUserSimilarityModelDAO;
import org.duineframework.recommender.profile.usersimilarity.UserSimilarity;

import com.whieb.digitalhome.model.CollaborativeUserSimilarity;
import com.whieb.digitalhome.util.UtilDao;

public class CollaborativeUserSimilarityDaoImpl implements IUserSimilarityModelDAO {
	private UtilDao utilDao;

	public UtilDao getUtilDao() {
		return utilDao;
	}

	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	private Log log = LogFactory
			.getLog(SpringHibernateUserSimilarityModelDAO.class);

	public UserSimilarity getUserSimilarity(final UserId userId,
			final UserId otherUserId) {
		String hql = "from IUserSimilarity where userId.id = ? and otherUserId.id = ? ";
		Object[] paras = new Object[] { userId.getId(), otherUserId.getId() };
		return (CollaborativeUserSimilarity) utilDao.uniqueResult(hql, paras);
	}

	public void saveUserSimilarity(UserSimilarity similarity) {
		if (!(similarity instanceof CollaborativeUserSimilarity)) {
			log.warn("Similarity "
					+ similarity
					+ " not saved. Expected similarity type is IUserSimilarity but was "
					+ similarity.getClass().getName());
			return;
		}
		utilDao.saveOrUpdate(similarity);
	}

	public UserSimilarity createUserSimilarity(UserId userId,
			UserId otherUserId, double similarity, int sampleSize) {
		UserSimilarity sim = getUserSimilarity(userId, otherUserId);
		if (sim == null) {
			sim = new CollaborativeUserSimilarity(userId, otherUserId, similarity,
					sampleSize);
		} else {
			sim.setSimilarity(similarity);
			sim.setSampleSize(sampleSize);
		}
		return sim;
	}

	public UserSimilarity createUserSimilarity(UserId userId,
			UserId otherUserId, double similarity, int sampleSize,
			boolean checkPersistency) {
		if (checkPersistency == true) {
			return createUserSimilarity(userId, otherUserId, similarity,
					sampleSize);
		}
		return new CollaborativeUserSimilarity(userId, otherUserId, similarity, sampleSize);
	}

	public void clearAll() {
		utilDao.execute("delete IUserSimilarity");
	}

}
