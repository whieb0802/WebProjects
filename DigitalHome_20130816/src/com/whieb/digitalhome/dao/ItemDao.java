package com.whieb.digitalhome.dao;

import java.util.List;
import java.util.Set;

import org.duineframework.recommender.profile.itemsimilarity.ItemSimilarity;

import com.whieb.digitalhome.model.Connection;
import com.whieb.digitalhome.model.Item;

/**
 * 
 * @author Vicky 2012-8-11
 */
public interface ItemDao {

	public void addItem(Item item);

	public void deleteItem(Item item);

	public void updateItem(Item item);

	public Item findItem(long id);

	public List<Item> findItem(String sql, Object[] item);

	public List<Item> getAllItems();

	public List<Item> getItemsByCatalogue(int catalogueId);

	public List<String> getAllItemInfo();// 取得所有的Item的Info信息

	public List<Item> getItemByConnection(List<Connection> con);
	
	public List<Item> getItemByItemSimi(List<ItemSimilarity> itemSimilarities);
	

	public List<Item> getItemsByIds(Set<Long> ids);// 根据id集合查找Item
	
	public List<Item> findItem(Class<Item> item, int firstIndex,
			int maxResult);                       //分页插叙item
	
	public List<Item> findItem(Object[] o ) ;
	public List<Item> findItem(String sql, Object[] o, int limits);
	public int itemCount(long i,String userIdStr);//统计user的ID为userIdStr并且评论ID为i的之前所评论过的电影的数目
	
	public List<Item> findMaxResult(String sql,Object[] o,int limits);
}
