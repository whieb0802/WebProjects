package com.whieb.digitalhome.service;

import java.util.ArrayList;
import java.util.List;

import org.duineframework.recommender.core.RatableItemId;
import org.duineframework.recommender.profile.itemsimilarity.ItemSimilarity;
import org.springframework.stereotype.Component;

import com.whieb.digitalhome.dao.ItemDao;
import com.whieb.digitalhome.dao.ItemSimilarityDao;
import com.whieb.digitalhome.model.Connection;
import com.whieb.digitalhome.model.ContentItemSimilarity;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.service.similarity.item.ItemSimilarityCounter;
import com.whieb.digitalhome.service.similarity.item.contentbased.TFIDFCounter;
import com.whieb.digitalhome.util.Configuration;
import com.whieb.digitalhome.util.Parameter;
/**
 * 基于内容的条目相似度计算
 * 
 * @author Vicky
 * 
 */
public class ContentBasedItemSimilarityService {
	private ItemDao itemDao;
	private ItemSimilarityCounter counter;
	private ItemSimilarityDao itemSimilarityDao;
	private double treshold;
	private Configuration config;

	public Configuration getConfig() {
		return config;
	}

	public void setConfig(Configuration config) {
		this.config = config;
	}

	public ItemSimilarityDao getItemSimilarityDao() {
		return itemSimilarityDao;
	}

	public void setItemSimilarityDao(ItemSimilarityDao itemSimilarityDao) {
		this.itemSimilarityDao = itemSimilarityDao;
	}

	public ItemSimilarityCounter getCounter() {
		return counter;
	}

	public void setCounter(ItemSimilarityCounter counter) {
		this.counter = counter;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public void init() {
		// 清空表中原有信息
		itemSimilarityDao.clearAll();

		// 初始化阈值
		String value = config
				.getValue(Parameter.ITEM_CONTENTBASED_SIMILAIRTYTRESHOLD);
		if (null == value || "".equals(value)) {
			treshold = 0.3;
		} else {
			treshold = Double.parseDouble(value);
		}
	}
//	zkz
	public List<ItemSimilarity> getContentItemSimi(RatableItemId itemId) {
		// 初始化阈值
		String topN = config
				.getValue(Parameter.RECOMMENDER_TOPN);
		return  itemSimilarityDao.getTopNItemSimilarity(itemId, Integer.parseInt(topN));
	}
	
		// 根据推荐的connection集合得到item集合
		public List<Item> getContentItemSimiData(List<ItemSimilarity> itemSimilarities) {
			List<Item> item = itemDao.getItemByItemSimi(itemSimilarities);
			return item;
		}

	public void mainCount() {
		init();

		List<Item> items = itemDao.getAllItems();
		List<ItemSimilarity> sims = new ArrayList<ItemSimilarity>();
		TFIDFCounter tfidf = new TFIDFCounter(items);
		for (int i = 0; i < items.size(); i++) {
			for (int j = i + 1; j < items.size(); j++) {
				double similarity = counter.getContentSimilarity(items.get(i),
						items.get(j), tfidf);
				System.out.println(items.get(i).getTitle() + "--"
						+ items.get(j).getTitle() + "--similarity = "
						+ similarity);
				if (similarity > treshold) {
					ItemSimilarity sim = itemSimilarityDao
							.createItemSimilarity(items.get(i).getId(), items
									.get(j).getId(), similarity);
					sims.add(sim);
					if (sims.size() > 50) {
						itemSimilarityDao.saveOrUpdateAll(sims);
						sims.clear();
					}
				}
			}
		}
		itemSimilarityDao.saveOrUpdateAll(sims);
	}
}
