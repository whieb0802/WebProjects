package com.whieb.digitalhome.main;

import com.whieb.digitalhome.service.RecommenderService;
import com.whieb.digitalhome.service.SimilarityService;

/**
 * @author Vicky 2012-11-8 核心Job类，用于完成所有的基础任务，如计算相似度，计算推荐结果，计算用户模型，计算关联规则等任务
 */
public class MainJob {
	private SimilarityService simSer;
	private RecommenderService recSer;

	public SimilarityService getSimSer() {
		return simSer;
	}

	public void setSimSer(SimilarityService simSer) {
		this.simSer = simSer;
	}

	public RecommenderService getRecSer() {
		return recSer;
	}

	public void setRecSer(RecommenderService recSer) {
		this.recSer = recSer;
	}

	public void start() {
		/* 计算相似度 */
		simSer.mainCount();
		/* 计算推荐结果 */
		recSer.mainCount();
	}
}
