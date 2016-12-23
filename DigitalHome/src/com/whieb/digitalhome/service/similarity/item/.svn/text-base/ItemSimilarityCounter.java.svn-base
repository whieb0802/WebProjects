package com.whieb.digitalhome.service.similarity.item;

import java.util.Map;

import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.service.similarity.item.collaborative.CollaborativeItemSimilarityCounter;
import com.whieb.digitalhome.service.similarity.item.contentbased.ContentSimilarityCounter;
import com.whieb.digitalhome.service.similarity.item.contentbased.TFIDFCounter;

/**
 * 基于内容计算Item相似度
 * 
 * @author Vicky
 * 
 */
public class ItemSimilarityCounter {

	private ContentSimilarityCounter content_counter;
	private CollaborativeItemSimilarityCounter collaborative_counter;

	public ContentSimilarityCounter getContent_counter() {
		return content_counter;
	}

	public void setContent_counter(ContentSimilarityCounter content_counter) {
		this.content_counter = content_counter;
	}

	public CollaborativeItemSimilarityCounter getCollaborative_counter() {
		return collaborative_counter;
	}

	public void setCollaborative_counter(
			CollaborativeItemSimilarityCounter collaborative_counter) {
		this.collaborative_counter = collaborative_counter;
	}

	/**
	 * 基于内容的Item相似度计算
	 * 
	 * @author Vicky 2012-8-14
	 */
	public double getContentSimilarity(Item item, Item otherItem,
			TFIDFCounter tfidf) {
		if (null == item || null == otherItem) {
			return 0.00;
		}
		if (item.equals(otherItem)) {
			return 1.0;
		}
		double similarity = 0.00;
		Map<String, String> attr01 = item.getAttributes();// Item的属性集合
		Map<String, String> attr02 = otherItem.getAttributes();// Item属性集合

		similarity = content_counter.getAttributeSimilarity(attr01, attr02,
				tfidf);
		return similarity;
	}

	/**
	 * 基于协同过滤的Item相似度计算
	 * 
	 * @author Vicky 2012-8-14
	 */
	public double getCollaborativeSimilarity(Item item, Item otherItem) {
		return collaborative_counter.getSimilarity(item, otherItem);
	}
}
