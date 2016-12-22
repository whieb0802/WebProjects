package com.whieb.digitalhome.dao.impl;

import java.util.List;

import com.whieb.digitalhome.dao.AttributeDao;
import com.whieb.digitalhome.model.MyAttribute;
import com.whieb.digitalhome.util.UtilDao;

public class AttributeDaoImpl implements AttributeDao {

	private UtilDao utilDao;
	
	@Override
	public List<MyAttribute> findAttribute(String sql, Object[] o) {
		return utilDao.find(sql, o);
	}

	public UtilDao getUtilDao() {
		return utilDao;
	}

	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	
}
