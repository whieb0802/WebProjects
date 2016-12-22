package com.whieb.digitalhome.service;

import org.springframework.stereotype.Component;

/**
 * @author Vicky 2012-11-8 用于完成所有的相似度计算任务
 */
public class SimilarityService {
	private CollaborativeUserSimilarityService userSer;// 基于用户的协同过滤相似度计算
	private CollaborativeItemSimilarityService itemSer;// 基于条目的协同过滤相似度计算
	private ContentBasedItemSimilarityService con_itemSer;// 基于条目内容的相似度计算

	public CollaborativeUserSimilarityService getUserSer() {
		return userSer;
	}

	public void setUserSer(CollaborativeUserSimilarityService userSer) {
		this.userSer = userSer;
	}

	public CollaborativeItemSimilarityService getItemSer() {
		return itemSer;
	}

	public void setItemSer(CollaborativeItemSimilarityService itemSer) {
		this.itemSer = itemSer;
	}

	public ContentBasedItemSimilarityService getCon_itemSer() {
		return con_itemSer;
	}

	public void setCon_itemSer(ContentBasedItemSimilarityService con_itemSer) {
		this.con_itemSer = con_itemSer;
	}

	/**
	 * @author Vicky 2012-11-8 核心任务方法，调用该方法，直接计算所有的相似度信息
	 */
	public void mainCount() {
//		userSer.mainCount();// 计算基于用户的协同过滤相似度
//		itemSer.mainCount();// 计算基于条目的协同过滤相似度
		con_itemSer.mainCount();// 基于条目内容的相似度计算
	}
}
