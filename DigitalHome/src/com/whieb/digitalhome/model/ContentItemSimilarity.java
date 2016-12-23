package com.whieb.digitalhome.model;

import org.duineframework.recommender.core.RatableItemId;
import org.duineframework.recommender.profile.itemsimilarity.ItemSimilarity;

/**
 * 基于内容计算的Item相似度
 * 
 * @author Vicky
 * 
 */
/**
 * @author Vicky 2012-8-11
 */
public class ContentItemSimilarity extends ItemSimilarity {
	private int logo;// 标识是基于内容还是协同过滤
	private Long id;

	public ContentItemSimilarity(int logo) {
		super();
		this.logo = logo;
	}

	public ContentItemSimilarity() {
		super();
	}

	public ContentItemSimilarity(RatableItemId itemId,
			RatableItemId otherItemId, double similarity) {
		super(itemId, otherItemId, similarity);
	}

	public ContentItemSimilarity(RatableItemId itemId, RatableItemId otherItemId) {
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

	@Override
	public String toString() {
		return "ContentItemSimilarity [itemId=" + itemId + ", otherItemId="
				+ otherItemId + " similarity=" + getSimilarity() + "]";
	}
}
