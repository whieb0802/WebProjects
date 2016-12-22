package com.whieb.digitalhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.whieb.digitalhome.dao.ConfigDao;
import com.whieb.digitalhome.model.Config;
import com.whieb.digitalhome.util.Configuration;
import com.whieb.digitalhome.util.UtilDao;


@Component("parameterService")
public class ParameterService {
	
	private ConfigDao configDao;
	private Configuration config;
	
	public ConfigDao getConfigDao() {
		return configDao;
	}
	@Resource
	public void setConfigDao(ConfigDao configDao) {
		this.configDao = configDao;
	}

	public Configuration getConfig() {
		return config;
	}
	@Resource(name="configuration")
	public void setConfig(Configuration config) {
		this.config = config;
	}
	// 读取所有的系统参数
	public List<Config> getConfigs(){
		return configDao.getConfigs();
	}

	// 查询某个参数
	public Config findConfig(String name){
		return configDao.findConfig(name);
	}

	// 保存/更新参数信息
	public void saveOrUpdate(Config con){
		configDao.saveOrUpdate(con);
	}
	//返回topN
	public int getTopN(){
		return config.getTopN();
	}
}
