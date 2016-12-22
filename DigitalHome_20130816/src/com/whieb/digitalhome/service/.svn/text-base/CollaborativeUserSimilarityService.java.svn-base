package com.whieb.digitalhome.service;

import java.util.ArrayList;
import java.util.List;

import org.duineframework.recommender.profile.usersimilarity.UserSimilarity;

import com.whieb.digitalhome.dao.UserDao;
import com.whieb.digitalhome.dao.UserSimilarityDao;
import com.whieb.digitalhome.model.User;
import com.whieb.digitalhome.service.similarity.user.UserSimilarityCounter;
import com.whieb.digitalhome.util.Configuration;
import com.whieb.digitalhome.util.Parameter;

/**
 * 基于协同过滤的用户相似度计算
 * 
 * @author Vicky
 * 
 */
public class CollaborativeUserSimilarityService {
	private UserDao userDao;
	private UserSimilarityCounter counter;
	private UserSimilarityDao userSimilarityDao;
	private double treshold;
	private Configuration config;

	public Configuration getConfig() {
		return config;
	}

	public void setConfig(Configuration config) {
		this.config = config;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserSimilarityCounter getCounter() {
		return counter;
	}

	public void setCounter(UserSimilarityCounter counter) {
		this.counter = counter;
	}

	public UserSimilarityDao getUserSimilarityDao() {
		return userSimilarityDao;
	}

	public void setUserSimilarityDao(UserSimilarityDao userSimilarityDao) {
		this.userSimilarityDao = userSimilarityDao;
	}

	public void init() {
		// 清空表中原有信息
		userSimilarityDao.clearAll();

		// 初始化阈值
		String value = config
				.getValue(Parameter.USER_COLLABORATIVE_SIMILAIRTYTRESHOLD);
		if (null == value || "".equals(value)) {
			treshold = 0.3;
		} else {
			treshold = Double.parseDouble(value);
		}
	}

	public void mainCount() {
		init();

		List<User> users = userDao.findAllUser();
		System.out.println("load all users total " + users.size() + " ...");
		List<UserSimilarity> sims = new ArrayList<UserSimilarity>();
		if (null == users || users.size() < 2) {
			return;
		}
		for (int i = 0; i < users.size(); i++) {
			for (int j = i + 1; j < users.size(); j++) {
				double similarity = counter.getCollaborativeSimilarity(users
						.get(i).getId(), users.get(j).getId());
				System.out.println("i = " + i + " j = " + j + " sim = "
						+ similarity);
				if (similarity > treshold) {
					UserSimilarity sim = userSimilarityDao
							.createUserSimilarity(users.get(i).getId(), users
									.get(j).getId(), similarity);
					sims.add(sim);
					if (sims.size() > 50) {
						userSimilarityDao.saveOrUpdateAll(sims);
						sims.clear();
					}
				}
			}
		}
		userSimilarityDao.saveOrUpdateAll(sims);
	}
}
