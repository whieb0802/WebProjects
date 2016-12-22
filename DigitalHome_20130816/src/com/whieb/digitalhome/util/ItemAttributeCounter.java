package com.whieb.digitalhome.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whieb.digitalhome.service.similarity.item.contentbased.ContentAlgorithm;
import com.whieb.digitalhome.service.similarity.item.contentbased.TFIDFCounter;

/**
 * @author Vicky 2012-9-1 用于计算Item属性之间的相似度
 */
public class ItemAttributeCounter {
	private ContentAlgorithm algorithm;
	private Configuration config;
	private int topNTerms;
	private boolean flag = false;// 标识是否初始化

	public ContentAlgorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(ContentAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	public Configuration getConfig() {
		return config;
	}

	public void setConfig(Configuration config) {
		this.config = config;
	}

	// 初始化
	public void init() {
		if (!flag) {
			String value = config.getValue(Parameter.TOPNTERMS);// 读取参数值
			if (null != value && !"".equals(value)) {
				topNTerms = Integer.parseInt(value);
				if (topNTerms == 0) {
					topNTerms = Integer.MAX_VALUE;
				}
			} else {
				topNTerms = 10;
			}
			flag = true;
		}
	}

	// type:参数类型/0-数值型/1-枚举型/2-文本型/3-特定格式-字符串空格划分型
	public double getAttributeSimialrity(String attr01, String attr02,
			int type, Object util) {
		init();
		double sim = 0.0;
		if (null == attr01 || null == attr02) {
			return sim;
		}
		switch (type) {
		case 0: {
			break;
		}
		case 1: {
			sim = enum_counter(attr01, attr02);
			break;
		}
		case 2: {
			sim = text_counter(attr01, attr02, util);
			break;
		}
		case 3: {
			sim = space_counter(attr01, attr02);
			break;
		}
		default: {
			break;
		}
		}
		return sim;
	}

	// 枚举类型属性计算相似性
	public double enum_counter(String attr01, String attr02) {
		double sim = 0.0;
		if (null == attr01 || null == attr02 || "".equals(attr01)
				|| "".equals(attr02)) {
			return sim;
		}
		sim = (attr01.equals(attr02)) ? 1.0 : 0.0;
		return sim;
	}

	// 文本类型属性计算相似性
	public double text_counter(String attr01, String attr02, Object util) {
		double sim = 0.0;
		if (null == util || !(util instanceof TFIDFCounter)) {
			return sim;
		}
		Map<String, Double> maps01 = getTopNTerms(getTermTFValue(attr01, util));
		Map<String, Double> maps02 = getTopNTerms(getTermTFValue(attr02, util));
		sim = algorithm.calculate(maps01, maps02);
		return sim;
	}

	// 按空格划分的字符串类型属性计算相似性
	public double space_counter(String attr01, String attr02) {
		double sim = 0.00;
		String[] stars01 = attr01.split(" ");
		String[] stars02 = attr02.split(" ");
		List<String> s_list01 = new ArrayList<String>();
		List<String> s_list02 = new ArrayList<String>();
		for (String s : stars01) {
			String v = s.trim();
			if (!"".equals(v)) {
				s_list01.add(v);
			}
		}
		for (String s : stars02) {
			String v = s.trim();
			if (!"".equals(v)) {
				s_list02.add(v);
			}
		}
		sim = algorithm.calculate(s_list01, s_list02);
		return sim;
	}

	private Map<String, Double> getTermTFValue(String attr, Object util) {
		if (null == util || !(util instanceof TFIDFCounter)) {
			return null;
		}
		TFIDFCounter counter = (TFIDFCounter) util;// TFIDF工具类

		Map<String, Integer> term_frequence = new HashMap<String, Integer>();// 存储关键词以及出现的次数
		Map<String, Double> term_tfidf = new HashMap<String, Double>();// 存储关键词以及TFIDF值
		int total_frequence = 0;// 总的关键词出现的次数
		total_frequence = 0;
		term_frequence = AnalyzerUtil.analysisContent(attr);// 分词
		// 统计所有关键词出现的总次数，计算TF值
		for (String s : term_frequence.keySet()) {
			total_frequence += term_frequence.get(s);
		}
		// 计算Term的TF值
		for (String s : term_frequence.keySet()) {
			double tf_value = term_frequence.get(s) / (double) total_frequence;
			double tfidf_value = counter.getIDFValue(s) * tf_value;
			term_tfidf.put(s, tfidf_value);
		}
		return term_tfidf;
	}

	/* 选取关键字出现次数前N的关键字 */
	private Map<String, Double> getTopNTerms(Map<String, Double> term_tfidf) {
		Map<String, Double> terms = new HashMap<String, Double>();
		if (term_tfidf == null || term_tfidf.size() == 0) {
			return terms;
		}
		// 排序
		List<Map.Entry<String, Double>> lists = new ArrayList<Map.Entry<String, Double>>(
				term_tfidf.entrySet());
		Collections.sort(lists, new Comparator<Map.Entry<String, Double>>() {
			public int compare(Map.Entry<String, Double> e1,
					Map.Entry<String, Double> e2) {
				int result = 0;
				if (e1.getValue() < e2.getValue()) {
					result = 1; // reverse order
				} else if (e1.getValue() > e2.getValue()) {
					result = -1;
				} else {
					result = 0;
				}
				return result;
			}
		});
		// 截取
		for (Map.Entry<String, Double> term : lists) {
			terms.put(term.getKey(), term.getValue());
			if (terms.size() >= topNTerms) {
				break;
			}
		}
		return terms;
	}
}
