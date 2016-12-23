package com.whieb.digitalhome.model;

import org.duineframework.recommender.core.RatableItemId;
import org.duineframework.recommender.profile.itemsimilarity.ItemSimilarity;

/**
 * 基于协同过滤计算的Item相似度
 * 
 * @author Vicky
 * 
 */
public class CollaborativeItemSimilarity extends ItemSimilarity {
	private int logo;// 标识是基于内容还是协同过滤
	private Long id;

	public CollaborativeItemSimilarity(int logo) {
		super();
		this.logo = logo;
	}

	public CollaborativeItemSimilarity() {
		super();
	}

	public CollaborativeItemSimilarity(RatableItemId itemId,
			RatableItemId otherItemId, double similarity) {
		super(itemId, otherItemId, similarity);
	}

	public CollaborativeItemSimilarity(RatableItemId itemId,
			RatableItemId otherItemId) {
		super(itemId, otherItemId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getLogo() {
		return logo;
	}

	public void setLogo(int logo) {
		this.logo = logo;
	}

	public void setItemId(RatableItemId itemId) {
		this.itemId = itemId;
	}

	public void setOtherItemId(RatableItemId otherItemId) {
		this.otherItemId = otherItemId;
	}
}
