package com.whieb.digitalhome.service.similarity.item.contentbased;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.whieb.digitalhome.model.Item;

/**
 * 计算某一关键词TFIDF值
 * 
 * 单例
 * 
 * @author Vicky
 * 
 */
public class TFIDFCounter {
	private Map<String, Integer> all_terms;// 存储所有的关键词以出现的Item数
	private Map<String, Double> term_idf;// 存储所有的关键词以及IDF值
	private List<Item> all_items;

	public TFIDFCounter(List<Item> all_items) {
		this.all_items = all_items;
		init();
	}

	public void init() {
		if (null == all_items) {
			System.err.print("all_items is null ... ");
			return;
		}
		all_terms = new HashMap<String, Integer>();
		term_idf = new HashMap<String, Double>();
		for (Item i : all_items) {
			Set<String> terms = i.getAllTerms();// 该Item的所有Term
			for (String s : terms) {
				int frequence = 1;
				if (all_terms.containsKey(s)) {
					frequence += all_terms.get(s);
				}
				all_terms.put(s, frequence);
			}
		}
		int total_frequence = all_items.size();// 总Item个数
		for (String s : all_terms.keySet()) {
			double idf_value = Math.log10((total_frequence / (1 + all_terms
					.get(s))));
			term_idf.put(s, idf_value);
		}
	}

	/* 取得某Term的IDF值 */
	public double getIDFValue(String term) {
		if (!term_idf.containsKey(term)) {
			return 0.00;
		}
		return term_idf.get(term);
	}

	public void showAllTerms() {
		for (String s : term_idf.keySet()) {
			System.out.println(s + "--idf_value=" + term_idf.get(s)
					+ "--frequence=" + all_terms.get(s));
		}
	}

	public static void main(String[] args) {

	}
}
