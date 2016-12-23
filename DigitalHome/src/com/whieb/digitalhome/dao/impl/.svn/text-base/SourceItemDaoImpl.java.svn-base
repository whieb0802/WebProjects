package com.whieb.digitalhome.dao.impl;

import java.util.List;

import com.whieb.digitalhome.dao.SourceItemDao;
import com.whieb.digitalhome.model.SourceItem;
import com.whieb.digitalhome.util.UtilDao;

public class SourceItemDaoImpl implements SourceItemDao {

	private UtilDao utilDao;
		
	public UtilDao getUtilDao() {
		return utilDao;
	}

	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	public List<SourceItem> listAllSourceItem() {
		String sql = "from SourceItem si";
		List<SourceItem> si = utilDao.find(sql, null);
		return si;
	}

}
