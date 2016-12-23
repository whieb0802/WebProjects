package com.whieb.digitalhome.service;

import java.util.ArrayList;
import java.util.List;

import org.duineframework.recommender.profile.itemsimilarity.ItemSimilarity;

import com.whieb.digitalhome.dao.ItemDao;
import com.whieb.digitalhome.dao.ItemSimilarityDao;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.service.similarity.item.ItemSimilarityCounter;
import com.whieb.digitalhome.util.Configuration;
import com.whieb.digitalhome.util.Parameter;

/**
 * 基于协同过滤的条目相似度计算
 * 
 * @author Vicky
 * 
 */
public class CollaborativeItemSimilarityService {
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
				.getValue(Parameter.ITEM_COLLABORATIVE_SIMILAIRTYTRESHOLD);
		if (null == value || "".equals(value)) {
			treshold = 0.3;
		} else {
			treshold = Double.parseDouble(value);
		}
	}

	public void mainCount() {
		init() ;
		
		List<Item> items = itemDao.getAllItems();
		System.out.println("load all items : total " + items.size() + " ...");
		List<ItemSimilarity> sims = new ArrayList<ItemSimilarity>();
		for (int i = 0; i < items.size(); i++) {
			for (int j = i + 1; j < items.size(); j++) {
				double similarity = counter.getCollaborativeSimilarity(
						items.get(i), items.get(j));
				System.out.println("i = " + i + " j = " + j + " sim = "
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
