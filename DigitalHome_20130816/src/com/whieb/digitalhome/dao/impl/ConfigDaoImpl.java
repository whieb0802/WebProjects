package com.whieb.digitalhome.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.whieb.digitalhome.dao.ConfigDao;
import com.whieb.digitalhome.model.Config;
import com.whieb.digitalhome.util.UtilDao;

/**
 * @author Vicky 2012-9-1
 */
public class ConfigDaoImpl implements ConfigDao {
	private UtilDao utilDao;

	public UtilDao getUtilDao() {
		return utilDao;
	}

	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	@Override
	public List<Config> getConfigs() {
		List<Config> configs = new ArrayList<Config>();
		configs = utilDao.find("from Config", null);
		return configs;
	}

	@Override
	public Config findConfig(String name) {
		Config c = (Config) utilDao.uniqueResult("from Config where name = ?",
				new Object[] { name });
		return c;
	}

	@Override
	public void saveOrUpdate(Config con) {
		utilDao.saveOrUpdate(con);
	}

}
