package com.whieb.digitalhome.dao;

import java.util.List;

import org.duineframework.recommender.profile.rating.Rating;

/**
 * z
 * 
 * @author zkz 暂时未用到
 * 
 */
public interface RatingDao {

	public void clearAll();// 清空Rating表

	public void addAll(List<Rating> ratings);// 插入一组Rating
	
	public List<Integer> findRatingByuserId(String userId,String sql); //通过用户ID分组统计每种属性值的电影观看记录
	
	public int findRatingAllCount(String sql); //查找每种属性的观看记录的总数
	
	public int findNumCount(String userId,String sql);//统计某个用户观看的所有电影的总数

}
