package com.whieb.digitalhome.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.whieb.digitalhome.dao.RecommenderResultDao;
import com.whieb.digitalhome.model.RecommenderResult;
import com.whieb.digitalhome.util.UtilDao;

/**
 * @author Vicky 2012-8-11
 */
public class RecommenderResultDaoImpl implements RecommenderResultDao {

	private UtilDao utilDao;

	public UtilDao getUtilDao() {
		return utilDao;
	}

	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	@Override
	public void saveOrUpdateAll(List<RecommenderResult> recs) {
		utilDao.saveOrUpdateAll(recs);
	}

	/**
	 * 查找某User的推荐结果:type-推荐类型
	 */
	public List<Long> getUserRecommender(Long uid, String type, int limits) {
		List<Long> itemIds = new ArrayList<Long>();
		StringBuffer hql = new StringBuffer(
				"select r.itemId from RecommenderResult r where r.userId = "
						+ uid);
		if (null != type && !("".equals(type))) {
			hql.append(" and r.type like '" + type + "'");
		}
		hql.append(" order by r.value desc");
		itemIds = utilDao.findMaxResult(hql.toString(), null, limits);
		return itemIds;
	}

	@Override
	public void clearAllTypeResult(String recommenderType) {
		String sql = "delete from RecommenderResult where type = '"
				+ recommenderType + "'";
		utilDao.execute(sql);
	}

	@Override
	public List<RecommenderResult> showUserRecommenderResult(Long uid,
			String type, int limits) {
		List<RecommenderResult> results = new ArrayList<RecommenderResult>();
		results = utilDao
				.findMaxResult(
						"from RecommenderResult where userId = ? and type = ? order by value desc ",
						new Object[] { uid, type }, limits);
		return results;
	}
}
