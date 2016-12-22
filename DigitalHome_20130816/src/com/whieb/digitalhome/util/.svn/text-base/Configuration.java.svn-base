package com.whieb.digitalhome.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whieb.digitalhome.dao.ConfigDao;
import com.whieb.digitalhome.model.Config;

/**
 * @author Vicky 2012-9-1
 */
public class Configuration {
	private boolean flag = false;
	private ConfigDao configDao;
	private Map<String, Config> name_config;

	public ConfigDao getConfigDao() {
		return configDao;
	}

	public void setConfigDao(ConfigDao configDao) {
		this.configDao = configDao;
	}

	// 初始化，读取数据库中的系统参数
	public void init() {
		if (!flag) {
			name_config = new HashMap<String, Config>();
			List<Config> configs = configDao.getConfigs();// 取出所有的系统参数
			if (null != configs && configs.size() > 0) {
				for (Config c : configs) {
					name_config.put(c.getName(), c);
				}
			}
			flag = false;
		}
	}

	// 根据参数名返回参数值以及参数类型
	public Config getConfig(String name) {
		init();
		if (null == name || "".equals(name.trim())) {
			return null;
		}
		if (name_config.containsKey(name)) {
			return name_config.get(name);
		}
		return null;
	}

	// 根据参数名返回参数数值
	public String getValue(String name) {
		init();
		if (null == name || "".equals(name.trim())) {
			return "";
		}
		if (name_config.containsKey(name)) {
			return name_config.get(name).getValue();
		}
		return "";
	}

	// 返回topN
	public int getTopN() {
		init();
		String value = name_config.get(Parameter.RECOMMENDER_TOPN).getValue();
		int topN = Integer.parseInt(value);
		return topN;
	}

	public void updateParameter(String name, String value) {
		init();
		if (null == name || "".equals(name.trim())) {
			return;
		}
		if (name_config.containsKey(name)) {
			Config c = name_config.get(name);
			c.setValue(value);
			configDao.saveOrUpdate(c);
		}
	}
}
