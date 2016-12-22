package com.whieb.digitalhome.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.duineframework.recommender.profile.itemsimilarity.ItemSimilarity;


import com.whieb.digitalhome.dao.ItemDao;
import com.whieb.digitalhome.model.Connection;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.util.UtilDao;
import com.whieb.digitalhome.util.page.ResultType;

/**
 * 
 * @author Vicky 2012-8-11
 */
public class ItemDaoImpl implements ItemDao {

	private UtilDao utilDao;

	public UtilDao getUtilDao() {
		return utilDao;
	}

	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	@Override
	public void addItem(Item item) {
		utilDao.save(item);
	}

	@Override
	public void deleteItem(Item item) {
		utilDao.delete(item);
	}

	@Override
	public void updateItem(Item item) {
		utilDao.update(item);
	}

	public Item findItem(long id) {
		return utilDao.find(Item.class, id);
	}

	public int itemCount(long i, String userIdStr) {
		Integer icount;
		String sql = "select count(*) from IRating irating where irating.id < ? and irating.userId.id = ? ";
		Object obj = utilDao.uniqueResult(sql, new Object[] { i, userIdStr });
		icount = Integer.parseInt(String.valueOf(obj));
		return icount;
	}

	@Override
	public List<Item> findItem(String sql, Object[] item) {
		return utilDao.find(sql, item);
	}
	/*通过属性、属性值才查找出符合推荐条件的item*/
	public List<Item> findItem(String sql, Object[] o, int limits) {
		return utilDao.findMaxResult(sql, o, limits);
	}
	
	/* load全部item */
	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<Item>();
		String sql = "from Item order by key asc";
		items = utilDao.find(sql, null);
		return items;
	}

	/* load某类别item */
	public List<Item> getItemsByCatalogue(int catalogueId) {
		List<Item> items = new ArrayList<Item>();
		String sql = "from Item where catalogueId = ?";
		items = utilDao.find(sql, new Object[] { catalogueId });
		return items;
	}

	/* 取得所有的Item的Info信息 */
	public List<String> getAllItemInfo() {
		return null;
	}

	@Override
	public List<Item> getItemByConnection(List<Connection> con) {
		String sql = "from Item i where i.id = ?";
		List<Item> item = new ArrayList<Item>();
		for (Connection c : con) {
			List<Item> i = utilDao
					.find(sql, new Object[] { c.getRelativeId() });
			item.addAll(i);
		}
		return item;
	}
	
//	zkz
	@Override
	public List<Item> getItemByItemSimi(List<ItemSimilarity> itemSimilarities) {
		// TODO Auto-generated method stub
		String sql = "from Item i where i.id = ?";
		List<Item> item = new ArrayList<Item>();
		for (ItemSimilarity itemSimilarity : itemSimilarities) {
			List<Item> i = utilDao
					.find(sql, new Object[] { Long.parseLong(itemSimilarity.getOtherItemId().getId()) });
			item.addAll(i);
		}
		return item;
	}
	
	/* 根据id集合查找Item */
	public List<Item> getItemsByIds(Set<Long> ids) {
		if (null == ids || ids.size() == 0) {
			return null;
		}
		List<Item> items = new ArrayList<Item>();
		StringBuffer hql = new StringBuffer("from Item where key in (");
		for (Long i : ids) {
			hql.append(i).append(",");
		}
		hql.deleteCharAt(hql.length() - 1);
		hql.append(")");
		items = utilDao.find(hql.toString(), null);
		return items;
	}

	public List<Item> findItem(Class<Item> item, int firstIndex, int maxResult) {
		ResultType<Item> it = utilDao.fenye(item, firstIndex, maxResult);
		List<Item> i = it.getResultList();
		return i;
	}

	@Override
	public List<Item> findItem(Object[] type) {
		List<Item> items = new ArrayList<Item>();
		String sql = "from Item item where item.type = ? order by item.avg desc ";
		items = utilDao.findMaxResult(sql, type, 2);
		return items;
	}

	public List<Item> findMaxResult(String sql, Object[] o, int limints) {
		return utilDao.findMaxResult(sql, o, limints);
	}


}
