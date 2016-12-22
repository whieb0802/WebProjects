package com.whieb.digitalhome.service;

import java.util.ArrayList;
import java.util.List;

import org.duineframework.recommender.core.RatableItemId;
import org.duineframework.recommender.core.UserId;

import com.whieb.digitalhome.dao.RecommenderResultDao;
import com.whieb.digitalhome.dao.UserDao;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.RecommenderResult;
import com.whieb.digitalhome.model.User;
import com.whieb.digitalhome.service.similarity.item.collaborative.CollaborativeItemBasedRecommender;
import com.whieb.digitalhome.service.similarity.item.contentbased.ContentBasedRecommender;
import com.whieb.digitalhome.service.similarity.user.collaborative.CollaborativeUserBasedRecommender;
import com.whieb.digitalhome.util.RecommenderType;
import com.whieb.digitalhome.vo.RecommenderExplainResult;

/**
 * 推荐器
 * 
 * @author Vicky 2012-8-11
 */
public class RecommenderService {
	private UserDao userDao;
	private ContentBasedRecommender contentBasedRecommender;
	private CollaborativeItemBasedRecommender collaborativeItemBasedRecommender;
	private CollaborativeUserBasedRecommender collaborativeUserBasedRecommender;
	private RecommenderResultDao recommenderResultDao;
		
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public CollaborativeUserBasedRecommender getCollaborativeUserBasedRecommender() {
		return collaborativeUserBasedRecommender;
	}

	public void setCollaborativeUserBasedRecommender(
			CollaborativeUserBasedRecommender collaborativeUserBasedRecommender) {
		this.collaborativeUserBasedRecommender = collaborativeUserBasedRecommender;
	}

	public CollaborativeItemBasedRecommender getCollaborativeItemBasedRecommender() {
		return collaborativeItemBasedRecommender;
	}

	public void setCollaborativeItemBasedRecommender(
			CollaborativeItemBasedRecommender collaborativeItemBasedRecommender) {
		this.collaborativeItemBasedRecommender = collaborativeItemBasedRecommender;
	}

	public ContentBasedRecommender getContentBasedRecommender() {
		return contentBasedRecommender;
	}

	public void setContentBasedRecommender(
			ContentBasedRecommender contentBasedRecommender) {
		this.contentBasedRecommender = contentBasedRecommender;
	}

	public RecommenderResultDao getRecommenderResultDao() {
		return recommenderResultDao;
	}

	public void setRecommenderResultDao(RecommenderResultDao recommenderResultDao) {
		this.recommenderResultDao = recommenderResultDao;
	}

	/**
	 * 计算基于内容的推荐结果
	 * 
	 * @author Vicky 2012-8-11
	 */
	public void contentBasedRecommender() {
		List<User> users = userDao.findAllUser();
		for (User i : users) {
			contentBasedRecommender.recommender(i.getId());
		}
	}

	/**
	 * 计算基于协同过滤的Item相似度的推荐结果
	 * 
	 * @author Vicky 2012-8-11
	 */
	public void collaborativeItemBasedRecommender() {
		List<User> users = userDao.findAllUser();
		for (User i : users) {
			collaborativeItemBasedRecommender.recommender(i.getId());
		}
	}

	/**
	 * 计算基于协同过滤的User相似度的推荐结果
	 * 
	 * @author Vicky 2012-8-11
	 */
	public void collaborativeUserBasedRecommender() {
		List<User> users = userDao.findAllUser();
		for (User i : users) {
			collaborativeUserBasedRecommender.recommender(i.getId());
		}
	}

	/**
	 * @author Vicky 2012-11-8 计算所有的推荐结果
	 */
	public void mainCount() {
		List<User> users = userDao.findAllUser();
		for (User i : users) {
			collaborativeUserBasedRecommender.recommender(i.getId());
		}
		for (User i : users) {
			contentBasedRecommender.recommender(i.getId());
		}
		for (User i : users) {
			collaborativeItemBasedRecommender.recommender(i.getId());
		}
	}

	/**
	 * 向User显示推荐结果
	 * 
	 * @author Vicky 2012-8-11
	 */
	public List<RecommenderExplainResult> showRecommenderResult(UserId uid,
			RecommenderType type, int limits) {
		List<RecommenderExplainResult> items = new ArrayList<RecommenderExplainResult>();
		if (null == uid) {
			return items;
		}
		if (type == RecommenderType.CONTENT_BASED) {
			items = contentBasedRecommender.showRecommenderResult(uid, limits);
		} else if (type == RecommenderType.ITEM_SIMILARITY) {
			items = collaborativeItemBasedRecommender.showRecommenderResult(
					uid, limits);
		} else if (type == RecommenderType.USER_SIMILARITY) {
			items = collaborativeUserBasedRecommender.showRecommenderResult(
					uid, limits);
		}
		return items;
	}

	/**
	 * 基于内容的推荐结果
	 */
	public List<RecommenderExplainResult> showContentBasedRecommenderResult(
			UserId uid, int limits) {
		return showRecommenderResult(uid, RecommenderType.CONTENT_BASED, limits);
	}

	/**
	 * 根据Item使用基于内容的推荐
	 */
	public List<Item> contentBasedRecommenderByItem(RatableItemId id, int topN) {
		List<Item> items = new ArrayList<Item>();
		items = contentBasedRecommender.recommenderByItem(id, topN);
		return items;
	}

	/**
	 * 基于协同过滤的Item相似度的推荐结果
	 */
	public List<RecommenderExplainResult> showCollaborativeItemBasedRecommenderResult(
			UserId uid, int limits) {
		return showRecommenderResult(uid, RecommenderType.ITEM_SIMILARITY,
				limits);
	}

	/**
	 * 基于协同过滤的User相似度的推荐结果
	 */
	public List<RecommenderExplainResult> showCollaborativeUserBasedRecommenderResult(
			UserId uid, int limits) {
		return showRecommenderResult(uid, RecommenderType.USER_SIMILARITY,
				limits);
	}
	/**
	 * zkz
	 * 基于兴趣模型推荐结果
	 */
	public void saveInterestRecommenderResult(
			UserId uid, List<Item> items) {
		List<RecommenderResult> rescs = new ArrayList<RecommenderResult>();
		for (Item item : items) {
			RecommenderResult resc = new RecommenderResult();
			resc.setUserId(Long.parseLong(uid.getId()));
			resc.setItemId(item.getKey());
			resc.setType("interest_based");
			rescs.add(resc);
		}
		recommenderResultDao.saveOrUpdateAll(rescs);
	}
}
