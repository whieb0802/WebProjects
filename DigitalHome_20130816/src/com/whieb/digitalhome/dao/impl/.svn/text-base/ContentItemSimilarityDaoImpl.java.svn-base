package com.whieb.digitalhome.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.duineframework.recommender.core.RatableItemId;
import org.duineframework.recommender.profile.itemsimilarity.ItemSimilarity;

import com.whieb.digitalhome.dao.ItemSimilarityDao;
import com.whieb.digitalhome.model.ContentItemSimilarity;
import com.whieb.digitalhome.util.UtilDao;

/**
 * 
 * @author Vicky 2012-8-11
 */
public class ContentItemSimilarityDaoImpl implements ItemSimilarityDao {
	private UtilDao utilDao;

	public UtilDao getUtilDao() {
		return utilDao;
	}

	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	@Override
	public ItemSimilarity getItemSimilarity(final RatableItemId itemId,
			final RatableItemId otherItemId) {
		String hql = "from ContentItemSimilarity where itemId.id = ? and otherItemId.id = ? ";
		Object[] paras = new Object[] { itemId.getId(), otherItemId.getId() };
		return (ContentItemSimilarity) utilDao.uniqueResult(hql, paras);
	}

	@Override
	public void saveItemSimilarity(ItemSimilarity similarity) {
		utilDao.save(similarity);
	}

	@Override
	public ItemSimilarity createItemSimilarity(RatableItemId itemId,
			RatableItemId otherItemId, double similarity) {
		ItemSimilarity sim = getItemSimilarity(itemId, otherItemId);
		if (sim == null) {
			sim = new ContentItemSimilarity(itemId, otherItemId, similarity);
		} else {
			sim.setSimilarity(similarity);
		}
		return sim;
	}

	@Override
	public void clearAll() {
		utilDao.execute("delete ContentItemSimilarity");
	}

	/* 取出某Item的相似Item-topN */
	public List<ItemSimilarity> getTopNItemSimilarity(RatableItemId itemId,
			int topN) {
		List<ItemSimilarity> itemIds = new ArrayList<ItemSimilarity>();
		String hql = "select distinct c from ContentItemSimilarity c where c.itemId.id = ? or c.otherItemId.id = ? order by c.similarity desc";
		itemIds = utilDao.findMaxResult(hql, new Object[] { itemId.getId(),
				itemId.getId() }, topN);
		return itemIds;
	}

	@Override
	public void saveOrUpdateAll(List<ItemSimilarity> sims) {
		utilDao.saveOrUpdateAll(sims);
	}
}
