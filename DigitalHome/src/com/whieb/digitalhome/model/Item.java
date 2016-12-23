package com.whieb.digitalhome.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.duineframework.recommender.core.IRatableItem;
import org.duineframework.recommender.core.RatableItemId;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.whieb.digitalhome.service.similarity.item.contentbased.TFIDFCounter;
import com.whieb.digitalhome.util.AnalyzerUtil;

/**
 * 
 * @author Vicky
 * 
 */
@Root
public class Item implements IRatableItem {
	private RatableItemId id;
	@Element(required = false)
	private Long key;
	@Element(required = false)
	private String title;
	private int catalogueId;
	private String type;
	private String publisharea;
	private String director;
	private String starring;
	private String info;
	private Date issuedate;
	@Element(required = false)
	private double avg;

	private Map<String, Integer> term_frequence = null;// 存储关键词以及出现的次数
	private Map<String, Double> term_tf = null;// 存储关键词以及TF值
	private Map<String, Double> term_tfidf = null;// 存储关键词以及TFIDF值
	private int total_frequence = 0;// 总的关键词出现的次数
	private boolean isInit = false;// 标识是否初始化

	public Item() {
		super();
	}

	public Item(RatableItemId id) {
		super();
		this.id = id;
	}

	public void setId(RatableItemId id) {
		this.id = id;

	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
		if (null == id) {
			id = new RatableItemId(String.valueOf(key));
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCatalogueId() {
		return catalogueId;
	}

	public void setCatalogueId(int catalogueId) {
		this.catalogueId = catalogueId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPublisharea() {
		return publisharea;
	}

	public Date getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}

	public void setPublisharea(String publisharea) {
		this.publisharea = publisharea;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStarring() {
		return starring;
	}

	public void setStarring(String starring) {
		this.starring = starring;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	/* 初始化 */
	public void init() {
		if (!isInit) {
			term_frequence = new HashMap<String, Integer>();
			term_tf = new HashMap<String, Double>();
			total_frequence = 0;
			// AnalyzerUtil util = new AnalyzerUtil();
			term_frequence = AnalyzerUtil.analysisContent(info);
			for (String s : term_frequence.keySet()) {
				total_frequence += term_frequence.get(s);
			}
			for (String s : term_frequence.keySet()) {
				double tf_value = term_frequence.get(s)
						/ (double) total_frequence;
				term_tf.put(s, tf_value);
			}
			isInit = true;
		}
	}

	/* 取得info的关键词以及出现的次数 */
	public Map<String, Integer> getTermFrequence() {
		init();
		return term_frequence;
	}

	/* 判断某个关键词是否出现在该Item的Info中 */
	public boolean checkTerm(String term) {
		init();
		return term_frequence.containsKey(term);
	}

	/* 计算总的关键词出现的次数 */
	public int getTotaFrequence() {
		init();
		return total_frequence;
	}

	/* 取出该Item的info的所有term */
	public Set<String> getAllTerms() {
		init();
		return term_frequence.keySet();
	}

	/* 取出关键词以及TF值 */
	public Map<String, Double> getTFIDFValue(TFIDFCounter counter) {
		init();
		if (null != term_tfidf) {
			return term_tfidf;
		}
		term_tfidf = new HashMap<String, Double>();
		for (String s : term_tf.keySet()) {
			double tfidf_value = term_tf.get(s) * counter.getIDFValue(s);
			term_tfidf.put(s, tfidf_value);
		}
		return term_tfidf;
	}

	public List<String> getSubjects() {
		if ("".equals(type)) {
			return null;
		}
		List<String> subs = new ArrayList<String>();
		subs.add(type);
		return subs;
	}

	public List<String> getPublishareas() {
		if ("".equals(publisharea)) {
			return null;
		}
		List<String> area = new ArrayList<String>();
		area.add(publisharea);
		return area;
	}

	@Override
	public RatableItemId getId() {
		if (null == id) {
			if (key == 0) {
				return null;
			}
			id = new RatableItemId(String.valueOf(key));
		}
		return id;
	}

	public Map<String, String> getAttributes() {
		Map<String, String> paras = new HashMap<String, String>();
		paras.put("director", director);
		paras.put("starring", starring);
		paras.put("info", info);
		paras.put("publisharea", publisharea);
		paras.put("type", type);
		return paras;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (key != other.key)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Item [title=" + title + ", type=" + type + ", publisharea="
				+ publisharea + ", director=" + director + ", starring="
				+ starring + ", info=" + info + "]";
	}

}
