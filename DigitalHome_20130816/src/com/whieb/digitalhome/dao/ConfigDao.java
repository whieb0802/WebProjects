package com.whieb.digitalhome.dao;

import java.util.List;

import com.whieb.digitalhome.model.Config;

/**
 * @author Vicky 2012-9-1
 */
public interface ConfigDao {
	public List<Config> getConfigs();// 读取所有的系统参数

	public Config findConfig(String name);// 查询某个参数

	public void saveOrUpdate(Config con);// 保存/更新参数信息
}
