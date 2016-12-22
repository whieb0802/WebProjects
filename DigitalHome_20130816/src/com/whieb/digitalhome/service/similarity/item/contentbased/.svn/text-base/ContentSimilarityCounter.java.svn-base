package com.whieb.digitalhome.service.similarity.item.contentbased;

import java.util.Map;

import com.whieb.digitalhome.model.Config;
import com.whieb.digitalhome.util.Configuration;
import com.whieb.digitalhome.util.ItemAttributeCounter;

/**
 * 计算两个Content之间个相似度
 * 
 * @author Vicky
 * 
 */
public class ContentSimilarityCounter {
	private Configuration config;
	private ItemAttributeCounter counter;

	public ItemAttributeCounter getCounter() {
		return counter;
	}

	public void setCounter(ItemAttributeCounter counter) {
		this.counter = counter;
	}

	public Configuration getConfig() {
		return config;
	}

	public void setConfig(Configuration config) {
		this.config = config;
	}

	public double getAttributeSimilarity(Map<String, String> attrs01,
			Map<String, String> attrs02, Object util) {
		double similarity = 0.0;
		if (null == attrs01 || attrs01.size() == 0 || null == attrs02
				|| attrs02.size() == 0) {
			return similarity;
		}
		for (String s : attrs01.keySet()) {
			String attr01_value = attrs01.get(s);
			String attr02_value = attrs02.get(s);
			Config c = config.getConfig(s);// 该Item属性对应的参数信息
			if (null == c) {
				continue;
			}
			double sim = counter.getAttributeSimialrity(attr01_value,
					attr02_value, c.getType(), util)
					* Double.parseDouble(c.getValue());
			System.out.println(s + "--" + sim);
			similarity += sim;
		}
		return similarity;
	}
}
