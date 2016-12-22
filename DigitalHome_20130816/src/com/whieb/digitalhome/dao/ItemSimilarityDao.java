package com.whieb.digitalhome.dao;

import java.util.List;

import org.duineframework.recommender.core.RatableItemId;
import org.duineframework.recommender.profile.itemsimilarity.ItemSimilarity;

/**
 * @author Vicky 2012-8-14
 */
public interface ItemSimilarityDao {

	public abstract ItemSimilarity getItemSimilarity(
			final RatableItemId itemId, final RatableItemId otherItemId);

	public abstract void saveItemSimilarity(ItemSimilarity similarity);

	public abstract ItemSimilarity createItemSimilarity(RatableItemId itemId,
			RatableItemId otherItemId, double similarity);

	public abstract void clearAll();

	/* 取出某Item的相似Item-topN */
	public abstract List<ItemSimilarity> getTopNItemSimilarity(
			RatableItemId itemId, int topN);

	public void saveOrUpdateAll(List<ItemSimilarity> sims);

}
