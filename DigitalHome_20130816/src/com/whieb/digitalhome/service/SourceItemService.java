package com.whieb.digitalhome.service;

import java.util.List;

import com.whieb.digitalhome.dao.ItemDao;
import com.whieb.digitalhome.dao.SourceItemDao;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.SourceItem;

public class SourceItemService {

	private SourceItemDao sourceItemDao;
	private ItemDao itemDao;

	public SourceItemDao getSourceItemDao() {
		return sourceItemDao;
	}

	public void setSourceItemDao(SourceItemDao sourceItemDao) {
		this.sourceItemDao = sourceItemDao;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	//
	public void validate() {
		System.out.println("start....");
		List<SourceItem> si = sourceItemDao.listAllSourceItem();
		List<Item> items = itemDao.getAllItems();
		int sourceItemSize = si.size();
		int itemSize = items.size();
		for (int i = 0; i < sourceItemSize; i++) {
			for (int j = 0; j < itemSize; j++) {
				if (si.get(i).getName().equals(items.get(j).getTitle())) {
					System.out.println("i=" + i + "replace with" + "j=" + j);
				}
			}
		}
		System.out.println("end....");
	}
}
