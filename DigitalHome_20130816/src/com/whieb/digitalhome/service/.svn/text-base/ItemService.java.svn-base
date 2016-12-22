package com.whieb.digitalhome.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.whieb.digitalhome.dao.ItemDao;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.Trade;
import com.whieb.digitalhome.util.UtilDao;
import com.whieb.digitalhome.util.page.PageView;
import com.whieb.digitalhome.util.page.ResultType;


@Component("itemService")
public class ItemService {
	
	@Resource
	private ItemDao itemDao;
	@Resource
	private UtilDao utilDao;
//	保存Item
	public void addItem(Item item){
		itemDao.addItem(item);
	}
//	删除Item
	public void deleteItem(Item item){
		itemDao.deleteItem(item);
	}
//	更新Item
	public void updateItem(Item item){
		itemDao.updateItem(item);
	}
//	根据ItemID得到Item对象
	public Item findItem(long id){
		return itemDao.findItem(id);
	}
//	利用SQL语句查询得到Item
	public List<Item> findItem(String sql,Object[] item){
		return itemDao.findItem(sql, item);
	}
	
	/**
	 * 找出最新资源
	 * @return
	 */
	public List<Item> findNewItems(int limit) {
		String sql = "from Item i order by i.issuedate desc";
		return utilDao.findMaxResult(sql, null, limit);
	}
	
	/**
	 * 得到热门资源
	 */
	public List<Item> findHotItems(int topN){
		List<Item> items = new ArrayList<Item>();
		List<Long> itemIds =  utilDao.findMaxResult("select itemId from Trade t group by t.itemId order by count(*) desc", null, topN);
		for (Long lon : itemIds) {
			Item i = itemDao.findItem("from Item i where i.key = ?", new Object[]{lon}).get(0);
			items.add(i);
		}
		return items;
	}
	
	/**
	 * 得到最热门资源的关注度
	 */
	public List<Integer> findHotItemCount(int topN){
		return	utilDao.findMaxResult("select count(*) from Trade t group by t.itemId order by count(*) desc", null, topN);
	}
	
	public List<Item> findInterestItem(int parameter, int subjectType,String subject) {
		List<Item> items = new ArrayList<Item>();
		if(subjectType == 0){
			String sql = "from Item i where i.publisharea = ? order by i.avg desc";
			items = itemDao.findItem(sql, new Object[] {subject },parameter);
		}
		else if(subjectType == 1) {
			String sql = "from Item i where i.type = ? order by i.avg desc";
			items = itemDao.findItem(sql, new Object[] {subject },parameter);
		}
		else if(subjectType == 2) {
			String sql = "from Item i where i.director = ? order by i.avg desc";
			items = itemDao.findItem(sql, new Object[] {subject },parameter);
		}
		else {
			String sql = "from Item i where i.starring = ? order by i.avg desc";
			items = itemDao.findItem(sql, new Object[] {subject },parameter);
		}
		return items;
	}
	/**
	 * 分页显示Item列表
	 */
	public PageView<Item> listItem(int currentPage) {
		PageView<Item> pageView = new PageView<Item>(PageView.MaxResutlt, currentPage);
		ResultType<Item> qr = utilDao.fenye(Item.class,
					pageView.getFirstResult(), pageView.getMaxResult());
		pageView.setResultType(qr);
		return pageView;
	}
	
	/**
	 * 得到某一用户历史消费的Item信息
	 */
	public PageView<Item> findHistory(Long userId,int currentPage){
		PageView<Item> pageView = new PageView<Item>(PageView.MaxResutlt, currentPage);
		ResultType<Trade> qr = utilDao.fenye(Trade.class, pageView.getFirstResult(), pageView.getMaxResult(), "o.userId=?", new Object[]{userId});
		List<Item> records = new ArrayList<Item>();
		ResultType<Item> resultType = new ResultType<Item>();
		for(Trade trade : qr.getResultList()){
			Item item = utilDao.find(Item.class, trade.getItemId());
			records.add(item);
		}
		resultType.setTotalRecord(qr.getTotalRecord());
		resultType.setResultList(records);
		pageView.setResultType(resultType);
		return pageView;
	}
	/**
	 * 得到所有的Item信息
	 */
	public List<Item> getAllItem() {		
		return itemDao.getAllItems();
	}
}
