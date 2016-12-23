package com.whieb.digitalhome.dao.impl;

import java.util.Collection;
import java.util.List;

import com.whieb.digitalhome.dao.SourceDao;
import com.whieb.digitalhome.model.Source;
import com.whieb.digitalhome.util.UtilDao;

public class SourceDaoImpl implements SourceDao {
	private UtilDao utilDao;

	public UtilDao getUtilDao() {
		return utilDao;
	}

	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	public void saveOrUpdateAll(Collection<Source> sou) {
		utilDao.saveOrUpdateAll(sou);
	}
	
	/**
	 * 得到资源里面的所有消费信息
	 * (non-Javadoc)
	 * @see com.whieb.digitalhome.dao.SourceDao#listAllItem()
	 */
	public List<Source> listAllSource() {
		String sql = "from Source s";
		List<Source>  ss= utilDao.find(sql, null);
		return ss;
	}
	
	public void clear() {
		utilDao.execute("delete from Source");
	}
}
