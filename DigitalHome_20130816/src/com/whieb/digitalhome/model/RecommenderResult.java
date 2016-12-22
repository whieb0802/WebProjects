package com.whieb.digitalhome.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 推荐结果
 * 
 * @author Vicky 2012-8-11
 */
public class RecommenderResult implements Serializable {
	private static final long serialVersionUID = 6731305677121032301L;
	private Long id;
	private Long userId;
	private Long itemId;
	private double value;// 预测的评分
	private String type;// 推荐的类型：基于内容/协同过滤-基于条目相似度/基于用户相似度
	private Date date;// 时间
	private String predictor_name;// 预测器名称
	private String explain;// 解释

	public RecommenderResult() {
		super();
		this.date = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPredictor_name() {
		return predictor_name;
	}

	public void setPredictor_name(String predictor_name) {
		this.predictor_name = predictor_name;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	@Override
	public String toString() {
		return "RecommenderResult [userId=" + userId + ", itemId=" + itemId
				+ ", value=" + value + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecommenderResult other = (RecommenderResult) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
