package com.whieb.digitalhome.dao;

import java.util.List;

import com.whieb.digitalhome.model.RecommenderResult;

/**
 * @author Vicky 2012-8-11
 */
public interface RecommenderResultDao {
	public void saveOrUpdateAll(List<RecommenderResult> resc);

	public List<RecommenderResult> showUserRecommenderResult(Long uid,
			String type, int limits);

	public List<Long> getUserRecommender(Long uid, String type, int limits);// 查找某User的推荐结果:type-推荐类型

	public void clearAllTypeResult(String recommenderType);// 清楚该推荐类型的结果
}
