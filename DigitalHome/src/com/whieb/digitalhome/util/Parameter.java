package com.whieb.digitalhome.util;

/**
 * @author Vicky 2012-9-1
 */
public class Parameter {
	public static final String RECOMMENDER_TOPN = "recommender_topN";// 推荐结果个数
	public static final String RECOMMENDER_HOT_WEEKS = "recommender_hot_weeks";// 热门资源统计周数
	public static final String TOPNTERMS = "topNterms";// 选择多少关键词进行比较
	public static final String ITEM_CONTENTBASED_SIMILAIRTYTRESHOLD = "item_contentbased_similarity_treshold";// 相似度阈值
	public static final String ITEM_COLLABORATIVE_SIMILAIRTYTRESHOLD = "item_collaborative_similarity_treshold";// 相似度阈值
	public static final String USER_COLLABORATIVE_SIMILAIRTYTRESHOLD = "user_collaborative_similarity_treshold";// 相似度阈值
	public static final String RECOMMENDER_LIMITS = "recommender_limits";// 推荐结果保留个数
	public static final String ITEM_NEIGHBOR_LIMITS = "item_neighbor_imits";// Item邻居个数
	public static final String USER_NEIGHBOR_LIMITS = "user_neighbor_imits";// User邻居个数
	public static final String ASSOCIATION_MINSUPPORT = "association_minSupport";// 推荐最小支持度
	public static final String ASSOCIATION_MINCONFIDENCE = "association_minConfidence";// 推荐最小置信度
	
}
